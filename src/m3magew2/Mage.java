package m3magew2;

import aic2022.user.*;

public class Mage extends AllyUnit {
    Location assemblyLocation;
    Location dest = null;

    Location switchLocation = null;
    boolean justSwitched = false;
    int level = 1;

    int action = 0; // 0 is just spawned, 1 is in assembly, 2 is moving from assembly to group, 3 is in group

    final int WITHIN_GROUP_MAX_DISTANCE = 20;
    final int NUM_TROOPS_PER_ASSEMBLY = 5;

    Mage(UnitController uc) {
        super(uc);
    }

    void runFirstTurn() {
        communication.downloadAllyBase();
        communication.downloadMapBoundariesAndCornerTracking();
    }

    void run() {
        communication.addSelfToTally();

        communication.downloadAllyBase();
        communication.downloadMapBoundariesAndCornerTracking();
        assemblyLocation = communication.getAssemblyLocation();

        communication.lookForMapBoundaries();
        communication.lookForEnemyBase();

        attackNearbyEnemyOrNeutralOrShrine();

        Location myLocation = uc.getLocation();

        if (level == 1) {
            if(tryLevelUp()) {
                level++;
                uc.println("Mage leveled up to level 2");
                return;
            }
            else if (myLocation.distanceSquared(communication.allyBaseLocation) > 4) {
                return;
            }
        }
        else if (level == 2 && myLocation.distanceSquared(communication.allyBaseLocation) > 10
                && uc.canUseFirstAbility(communication.allyBaseLocation)) {
            uc.useFirstAbility(communication.allyBaseLocation);
            communication.uploadAllyBase(myLocation);
            justSwitched = true;
            uc.println("Mage at " + myLocation + " switched locations with ally base at " + communication.allyBaseLocation);
            return;
        }

        Location selfLocation = uc.getLocation();

        int distanceSquaredToAssemblyLocation = selfLocation.distanceSquared(assemblyLocation);

        if (justSwitched) {
            dest = communication.allyBaseLocation;
            Direction movementDir = getDirectionTo(dest);
            if(movementDir != null) tryMove(movementDir);
            if (selfLocation.distanceSquared(dest) < 4) {
                justSwitched = false;
            }
            return;
        }

        if (action == 0) {
            uc.println("Mage moving to assembly " + assemblyLocation);
            dest = assemblyLocation;

            if (distanceSquaredToAssemblyLocation <= WITHIN_GROUP_MAX_DISTANCE) {
                uc.println("Mage joined assembly");
                communication.addSelfToAssembly();
                action = 1;
            }

            Direction movementDir = getDirectionTo(dest);
            if(movementDir != null) tryMove(movementDir);
            return;
        }

        Location lastGroupCenterLocation = communication.getLastGroupCenterLocation();
        int lastNumTroopsInAssembly = communication.getLastAssemblyNumTroops();

        if (action == 1) {
            uc.println("Mage waiting in assembly with " + lastNumTroopsInAssembly + " troops");
            dest = assemblyLocation;
            communication.addSelfToAssembly();

            if (lastNumTroopsInAssembly >= NUM_TROOPS_PER_ASSEMBLY) {
                uc.println("Mage assembly moving to group " + lastGroupCenterLocation);
                dest = lastGroupCenterLocation;
                action = 2;
            }

            tryAdjMoves(getDirectionTo(dest));
            return;
        }


        int distanceSquaredToLastGroupCenterLocation = selfLocation.distanceSquared(lastGroupCenterLocation);

        if (action == 2) {
            uc.println("Mage moving to group");
            dest = lastGroupCenterLocation;

            if (distanceSquaredToLastGroupCenterLocation <= WITHIN_GROUP_MAX_DISTANCE) {
                uc.println("Mage joined group");
                communication.addSelfToGroup();
                action = 3;
            }

            Direction movementDir = getDirectionTo(dest);
            if(movementDir != null) tryMove(movementDir);
            return;
        }

        if (action == 3) {
            if (distanceSquaredToLastGroupCenterLocation > WITHIN_GROUP_MAX_DISTANCE) {
                uc.println("Mage rejoining group " + lastGroupCenterLocation);
                dest = lastGroupCenterLocation;
                action = 2;

                Direction movementDir = getDirectionTo(dest);
                if(movementDir != null) tryMove(movementDir);
                return;
            }

            communication.addSelfToGroup();

            Location groupAttackLocation = communication.getGroupAttackLocation();
            uc.println("Mage moving with group to " + groupAttackLocation);
            dest = groupAttackLocation;

            Direction movementDir = getDirectionTo(dest);
            if(movementDir != null) tryMove(movementDir);
            return;
        }
    }

    Direction getDirectionTo(Location destination) {
        Location myLocation = uc.getLocation();
        Direction movementDir = null;

        int f = Integer.MAX_VALUE;

        for(Direction dir : directions) {
            if(uc.canMove(dir)) {
                Location adj = myLocation.add(dir);
                int newDist = adj.distanceSquared(destination);
                int newF = (int)Math.sqrt(newDist) * 4 + getVisited(adj);
                uc.println("Mage: Cost of moving in direction " + dir + " is " + newF);

                if(newF < f) {
                    f = newF;
                    movementDir = dir;
                }
                else if(newF == f){
                    if((int)(Math.random()*2)==0) {
                        f = newF;
                        movementDir = dir;
                    }
                }
            }
        }

        if (movementDir != null) {
            uc.println("Mage moving in " + movementDir + " -- " + tryAdjMoves(movementDir));
        }

        uc.println("Mage wants to move to destination " + destination + ", moves in dir " + movementDir + " to " + myLocation.add(movementDir));
        return movementDir;
    }
}
package m3mage;

import aic2022.user.*;

public class Barbarian extends AllyUnit {
    Location assemblyLocation;
    Location dest = null;

    boolean doDungeons;
    int action = 0; // 0 is just spawned, 1 is in assembly, 2 is moving from assembly to group, 3 is in group

    final int WITHIN_GROUP_MAX_DISTANCE = 20;
    final int NUM_TROOPS_PER_ASSEMBLY = 5;

    Barbarian(UnitController uc) {
        super(uc);
    }

    void runFirstTurn() {
        communication.downloadAllyBase();
        communication.downloadMapBoundariesAndCornerTracking();

        doDungeons = (int)(Math.random() * 5) == 1;
    }

    void runSecondTurn() {}

    void run() {
        communication.addSelfToTally();
        communication.downloadMapBoundariesAndCornerTracking();
        communication.lookForMapBoundaries();
        communication.lookForEnemyBase();

        if(assemblyLocation == null) {
            assemblyLocation = communication.getAssemblyLocation();
            if(assemblyLocation == null)
                return;
        }

        if(attackAndMoveToClosestEnemyOrNeutralOrShrine()) {
            uc.println("Barbarian chasing enemy");
            return;
        }

        ChestInfo closestChest = findClosestChest();
        if(closestChest != null) {
            dest = closestChest.getLocation();
            openNearbyChests();

            uc.println("Barbarian opening chest " + dest);
            tryAdjMoves(getDirectionTo(dest));
            return;
        }

        Location selfLocation = uc.getLocation();

        int distanceSquaredToAssemblyLocation = selfLocation.distanceSquared(assemblyLocation);

        if(action == 0) {
            uc.println("Barbarian moving to assembly " + assemblyLocation);
            dest = assemblyLocation;

            if(distanceSquaredToAssemblyLocation <= WITHIN_GROUP_MAX_DISTANCE) {
                uc.println("Barbarian joined assembly");
                communication.addSelfToAssembly();
                action = 1;
            }

            tryAdjMoves(getDirectionTo(dest));
            return;
        }

        Location lastGroupCenterLocation = communication.getLastGroupCenterLocation();
        int lastNumTroopsInAssembly = communication.getLastAssemblyNumTroops();

        if(action == 1) {
            uc.println("Barbarian waiting in assembly with " + lastNumTroopsInAssembly + " troops");
            dest = assemblyLocation;
            communication.addSelfToAssembly();

            if(lastNumTroopsInAssembly >= NUM_TROOPS_PER_ASSEMBLY) {
                uc.println("Barbarian assembly moving to group " + lastGroupCenterLocation);
                dest = lastGroupCenterLocation;
                action = 2;
            }

            tryAdjMoves(getDirectionTo(dest));
            return;
        }

        int distanceSquaredToLastGroupCenterLocation = selfLocation.distanceSquared(lastGroupCenterLocation);

        if(action == 2) {
            uc.println("Barbarian moving to group");
            dest = lastGroupCenterLocation;

            if(distanceSquaredToLastGroupCenterLocation <= WITHIN_GROUP_MAX_DISTANCE) {
                uc.println("Barbarian joined group");
                communication.addSelfToGroup();
                action = 3;
            }

            tryAdjMoves(getDirectionTo(dest));
            return;
        }

        if(action == 3) {
            if(distanceSquaredToLastGroupCenterLocation > WITHIN_GROUP_MAX_DISTANCE) {
                uc.println("Barbarian rejoining group " + lastGroupCenterLocation);
                dest = lastGroupCenterLocation;
                action = 2;

                tryAdjMoves(getDirectionTo(dest));
                return;
            }

            communication.addSelfToGroup();

            Location groupAttackLocation = communication.getGroupAttackLocation();
            uc.println("Barbarian moving with group to " + groupAttackLocation);
            dest = groupAttackLocation;

            tryAdjMoves(getDirectionTo(dest));
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
                uc.println("Barbarian: Cost of moving in direction " + dir + " is " + newF);

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
            uc.println("Barbarian moving in " + movementDir + " -- " + tryAdjMoves(movementDir));
        }

        uc.println("Barbarian wants to move to destination " + destination + ", moves in dir " + movementDir + " to " + myLocation.add(movementDir));
        return movementDir;
    }
}
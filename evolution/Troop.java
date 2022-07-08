package wtest_evolution;

import aic2022.user.*;
import java.util.Arrays;

public class Troop extends AllyUnit {
    Troop(UnitController uc) {
        super(uc);
    }

    // x input -> 16 hidden -> 16 hidden -> 9 output
    final int[] LAYER_SIZES = {25, 16, 16, 9};
    // Weights are outgoing weights
    /*weights_start*//*weights_end*/
    /*biases_start*//*biases_end*/

    void runFirstTurn() {
        communication.downloadAllyBase();
        communication.downloadMapBoundariesAndEnemyBase();

        if(weights.length != LAYER_SIZES.length)
            if(loggingOn) uc.println("ERROR 1");
        if(biases.length != LAYER_SIZES.length)
            if(loggingOn) uc.println("ERROR 2");
        for(int layer = 0; layer < LAYER_SIZES.length; layer++) {
            if(weights[layer].length != LAYER_SIZES[layer])
                if(loggingOn) uc.println("ERROR 3");
            if(biases[layer].length != LAYER_SIZES[layer])
                if(loggingOn) uc.println("ERROR 4");
        }
    }

    void run() {
//        communication.downloadMapBoundariesAndEnemyBase();
//        communication.lookForMapBoundaries();

        communication.addAllyAlive();

        UnitInfo nearestEnemyOrNeutral = getNearestEnemyOrNeutral(false, true);

        if(nearestEnemyOrNeutral != null) {
            if(loggingOn) uc.println("nearestEnemyOrNeutral " + nearestEnemyOrNeutral.getLocation());
            int damage = tryAttack(nearestEnemyOrNeutral.getLocation());
            if(damage != 0)
                communication.addScore(damage);
        }

        if(uc.canMove()) {
            if(loggingOn) uc.println("start (" + uc.getEnergyUsed() + " energy)");
            double[] inputData = getInputData(nearestEnemyOrNeutral);
            if(loggingOn) uc.println("inputData " + Arrays.toString(inputData) + " (" + uc.getEnergyUsed() + " energy)");
            double[] outputs = forwardPropagate(inputData);
            if(loggingOn) uc.println("outputs " + Arrays.toString(outputs) + " (" + uc.getEnergyUsed() + " energy)");
            Direction outputDirection = getDirectionFromOutputs(outputs);
            if(loggingOn) uc.println("outputDirection " + outputDirection + " (" + uc.getEnergyUsed() + " energy)");
            tryMove(outputDirection);
        }
    }

    double[] getInputData(UnitInfo nearestEnemyOrNeutral) {
        Location selfLocation = uc.getLocation();

        int canMoveDirectionNorth = uc.canMove(Direction.NORTH) ? 1 : 0;
        int canMoveDirectionNorthEast = uc.canMove(Direction.NORTHEAST) ? 1 : 0;
        int canMoveDirectionEast = uc.canMove(Direction.EAST) ? 1 : 0;
        int canMoveDirectionSouthEast = uc.canMove(Direction.SOUTHEAST) ? 1 : 0;
        int canMoveDirectionSouth = uc.canMove(Direction.SOUTH) ? 1 : 0;
        int canMoveDirectionSouthWest = uc.canMove(Direction.SOUTHWEST) ? 1 : 0;
        int canMoveDirectionWest = uc.canMove(Direction.WEST) ? 1 : 0;
        int canMoveDirectionNorthWest = uc.canMove(Direction.NORTHWEST) ? 1 : 0;

        double selfHealth = Math.log(uc.getInfo().getHealth());

//        double allyBaseDistance = Math.log(Math.sqrt(selfLocation.distanceSquared(communication.allyBaseLocation)));

        int nearestEnemyOrNeutralExists = 0;

        int nearestEnemyOrNeutralDirectionNorth = 0;
        int nearestEnemyOrNeutralDirectionNorthEast = 0;
        int nearestEnemyOrNeutralDirectionEast = 0;
        int nearestEnemyOrNeutralDirectionSouthEast = 0;
        int nearestEnemyOrNeutralDirectionSouth = 0;
        int nearestEnemyOrNeutralDirectionSouthWest = 0;
        int nearestEnemyOrNeutralDirectionWest = 0;
        int nearestEnemyOrNeutralDirectionNorthWest = 0;

        double nearestEnemyOrNeutralHealth = 0;
        double nearestEnemyOrNeutralAttackDamage = 0;

        int nearestEnemyOrNeutralSelfCloseEnoughToAttack = 0;
        int nearestEnemyOrNeutralCanSeeSelf = 0;
        int nearestEnemyOrNeutralCloseEnoughToAttackSelf = 0;

        int nearestEnemyOrNeutralCanMoveNextTurn = 0;
        int nearestEnemyOrNeutralCanAttackNextTurn = 0;

        if(nearestEnemyOrNeutral != null) {
            Location nearestEnemyOrNeutralLocation = nearestEnemyOrNeutral.getLocation();
            int distanceToNearestEnemyOrNeutral = selfLocation.distanceSquared(nearestEnemyOrNeutralLocation);
            UnitType nearestEnemyOrNeutralType = nearestEnemyOrNeutral.getType();

            nearestEnemyOrNeutralExists = 1;

            int nearestEnemyOrNeutralRelativeLocationX = nearestEnemyOrNeutralLocation.x - selfLocation.x;
            int nearestEnemyOrNeutralRelativeLocationY = nearestEnemyOrNeutralLocation.y - selfLocation.y;
            if(nearestEnemyOrNeutralRelativeLocationX == 0) {
                if(nearestEnemyOrNeutralRelativeLocationY > 0)
                    nearestEnemyOrNeutralDirectionNorth = 1;
                else
                    nearestEnemyOrNeutralDirectionSouth = 1;
            }
            else if(nearestEnemyOrNeutralRelativeLocationY == 0) {
                if(nearestEnemyOrNeutralRelativeLocationX > 0)
                    nearestEnemyOrNeutralDirectionEast = 1;
                else
                    nearestEnemyOrNeutralDirectionWest = 1;
            }
            else {
                if(nearestEnemyOrNeutralRelativeLocationX > 0 && nearestEnemyOrNeutralRelativeLocationY > 0)
                    nearestEnemyOrNeutralDirectionNorthEast = 1;
                else if(nearestEnemyOrNeutralRelativeLocationX > 0)
                    nearestEnemyOrNeutralDirectionSouthEast = 1;
                else if(nearestEnemyOrNeutralRelativeLocationY < 0)
                    nearestEnemyOrNeutralDirectionSouthWest = 1;
                else
                    nearestEnemyOrNeutralDirectionNorthWest = 1;
            }

            nearestEnemyOrNeutralHealth = Math.log(nearestEnemyOrNeutral.getHealth());
            nearestEnemyOrNeutralAttackDamage = Math.log(nearestEnemyOrNeutralType.getStat(UnitStat.ATTACK));

            if(distanceToNearestEnemyOrNeutral <= selfAttackRange && distanceToNearestEnemyOrNeutral >= selfMinAttackRange)
                nearestEnemyOrNeutralSelfCloseEnoughToAttack = 1;

            float nearestEnemyOrNeutralVisionRange = nearestEnemyOrNeutralType.getStat(UnitStat.VISION_RANGE);
            if(distanceToNearestEnemyOrNeutral <= nearestEnemyOrNeutralVisionRange)
                nearestEnemyOrNeutralCanSeeSelf = 1;

            float nearestEnemyOrNeutralAttackRange = nearestEnemyOrNeutralType.getStat(UnitStat.ATTACK_RANGE);
            float nearestEnemyOrNeutralMinAttackRange = nearestEnemyOrNeutralType.getStat(UnitStat.MIN_ATTACK_RANGE);
            if(distanceToNearestEnemyOrNeutral <= nearestEnemyOrNeutralAttackRange && distanceToNearestEnemyOrNeutral >= nearestEnemyOrNeutralMinAttackRange)
                nearestEnemyOrNeutralCloseEnoughToAttackSelf = 1;

            float nearestEnemyOrNeutralMoveCooldown = nearestEnemyOrNeutral.getCurrentMovementCooldown();
            if(nearestEnemyOrNeutralMoveCooldown <= 1)
                nearestEnemyOrNeutralCanMoveNextTurn = 1;

            float nearestEnemyOrNeutralAttackCooldown = nearestEnemyOrNeutral.getCurrentAttackCooldown();
            if(nearestEnemyOrNeutralAttackCooldown <= 1)
                nearestEnemyOrNeutralCanAttackNextTurn = 1;
        }

        return new double[]{
                canMoveDirectionNorth, canMoveDirectionNorthEast,
                canMoveDirectionEast, canMoveDirectionSouthEast,
                canMoveDirectionSouth, canMoveDirectionSouthWest,
                canMoveDirectionWest, canMoveDirectionNorthWest,
                selfHealth, nearestEnemyOrNeutralExists,
                nearestEnemyOrNeutralDirectionNorth, nearestEnemyOrNeutralDirectionNorthEast,
                nearestEnemyOrNeutralDirectionEast, nearestEnemyOrNeutralDirectionSouthEast,
                nearestEnemyOrNeutralDirectionSouth, nearestEnemyOrNeutralDirectionSouthWest,
                nearestEnemyOrNeutralDirectionWest, nearestEnemyOrNeutralDirectionNorthWest,
                nearestEnemyOrNeutralHealth, nearestEnemyOrNeutralAttackDamage,
                nearestEnemyOrNeutralSelfCloseEnoughToAttack, nearestEnemyOrNeutralCanSeeSelf,
                nearestEnemyOrNeutralCloseEnoughToAttackSelf,
                nearestEnemyOrNeutralCanMoveNextTurn, nearestEnemyOrNeutralCanAttackNextTurn
        };
    }

    double relu(double x) {
        if(x > 0)
            return x;
        return 0;
    }

    double sigmoid(double x) {
        return 1 / (1 + Math.exp(-x));
    }

    double[] forwardPropagate(double[] inputData) {
        double[][] activations = new double[LAYER_SIZES.length][];
        for(int layer = 1; layer < LAYER_SIZES.length; layer++) {
            activations[layer] = new double[LAYER_SIZES[layer]];
            for(int neuron = 0; neuron < activations[layer].length; neuron++) {
                activations[layer][neuron] = 0;
                if(layer == 1) {
                    for(int previousNeuron = 0; previousNeuron < inputData.length; previousNeuron++) {
                        activations[layer][neuron] += inputData[previousNeuron] * weights[layer - 1][previousNeuron][neuron];
                    }
                }
                else {
                    for(int previousNeuron = 0; previousNeuron < activations[layer - 1].length; previousNeuron++) {
                        activations[layer][neuron] += activations[layer - 1][previousNeuron] * weights[layer - 1][previousNeuron][neuron];
                    }
                }

                activations[layer][neuron] += biases[layer][neuron];

                if(layer != LAYER_SIZES.length - 1)
                    activations[layer][neuron] = relu(activations[layer][neuron]);
                else
                    activations[layer][neuron] = sigmoid(activations[layer][neuron]);
            }
        }

        int outputLayer = LAYER_SIZES.length - 1;
        double[] outputs = new double[LAYER_SIZES[outputLayer]];
        System.arraycopy(activations[outputLayer], 0, outputs, 0, activations[outputLayer].length);
        return outputs;
    }

    Direction getDirectionFromOutputs(double[] outputs) {
//        double highestOutput = 0;
//        int highestOutputIndex = 0;
//        for(int i = 0; i < outputs.length; i++) {
//            if(outputs[i] > highestOutput) {
//                highestOutput = outputs[i];
//                highestOutputIndex = i;
//            }
//        }
//        return directions[highestOutputIndex];
        double totalOutputs = 0;
        for (double output : outputs) {
            totalOutputs += output;
        }
        double selectRandomPercent = Math.random();
        int selectIndex = 0;
        double currentPercent = 0;
        for(int i = 0; i < outputs.length; i++) {
            currentPercent += outputs[i] / totalOutputs;
            if(currentPercent >= selectRandomPercent) {
                selectIndex = i;
                break;
            }
        }
        return directions[selectIndex];
    }
}
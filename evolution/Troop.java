package wtest_evolution;

import aic2022.user.*;
import java.util.Arrays;

public class Troop extends AllyUnit {
    Troop(UnitController uc) {
        super(uc);
    }

    // 7 input -> 16 hidden -> 16 hidden -> 9 output
    final int[] LAYER_SIZES = {7, 16, 16, 9};
    // Weights are outgoing weights
    /*weights_start*/double[][][] weights;/*weights_end*/
    /*biases_start*/double[][] biases;/*biases_end*/

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
        communication.downloadMapBoundariesAndEnemyBase();
        communication.lookForMapBoundaries();

        communication.addAllyAlive();

        UnitInfo nearestEnemyOrNeutral = getNearestEnemyOrNeutral();
        int[] inputData = getInputData(nearestEnemyOrNeutral);
        if(loggingOn) uc.println("inputData " + Arrays.toString(inputData));
        double[] outputs = forwardPropagate(inputData);
        if(loggingOn) uc.println("outputs " + Arrays.toString(outputs));
        Direction outputDirection = getDirectionFromOutputs(outputs);
        if(loggingOn) uc.println("outputDirection " + outputDirection);

        if(nearestEnemyOrNeutral != null) {
            if(loggingOn) uc.println("nearestEnemyOrNeutral " + nearestEnemyOrNeutral.getLocation());
            int damage = tryAttack(nearestEnemyOrNeutral.getLocation());
            if(damage != 0)
                communication.addScore(damage);
        }
        tryMove(outputDirection);
    }

    int[] getInputData(UnitInfo nearestEnemyOrNeutral) {
        Location selfLocation = uc.getLocation();
        int relativeAllyBaseX = selfLocation.x - communication.allyBaseLocation.x;
        int relativeAllyBaseY = selfLocation.y - communication.allyBaseLocation.y;
        int nearestEnemyOrNeutralExists = 0;
        int relativeNearestEnemyOrNeutralX = 0;
        int relativeNearestEnemyOrNeutralY = 0;
        int relativeNearestEnemyOrNeutralIsExplorer = 0;
        int relativeNearestEnemyOrNeutralIsMage = 0;
        if(nearestEnemyOrNeutral != null) {
            Location nearestEnemyOrNeutralLocation = nearestEnemyOrNeutral.getLocation();
            UnitType nearestEnemyOrNeutralType = nearestEnemyOrNeutral.getType();
            nearestEnemyOrNeutralExists = 1;
            relativeNearestEnemyOrNeutralX = selfLocation.x - nearestEnemyOrNeutralLocation.x;
            relativeNearestEnemyOrNeutralY = selfLocation.y - nearestEnemyOrNeutralLocation.y;
            if(nearestEnemyOrNeutralType == UnitType.EXPLORER)
                relativeNearestEnemyOrNeutralIsExplorer = 1;
            else if(nearestEnemyOrNeutralType == UnitType.MAGE)
                relativeNearestEnemyOrNeutralIsMage = 1;
        }
        int[] inputData = {relativeAllyBaseX, relativeAllyBaseY, nearestEnemyOrNeutralExists,
                relativeNearestEnemyOrNeutralX, relativeNearestEnemyOrNeutralY,
                relativeNearestEnemyOrNeutralIsExplorer, relativeNearestEnemyOrNeutralIsMage};
        return inputData;
    }

    double relu(double x) {
        if(x > 0)
            return x;
        return 0;
    }

    double sigmoid(double x) {
        return 1 / (1 + Math.exp(-x));
    }

    double[] forwardPropagate(int[] inputData) {
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

                if(layer == LAYER_SIZES.length - 1)
                    activations[layer][neuron] = sigmoid(activations[layer][neuron]);
                else
                    activations[layer][neuron] = relu(activations[layer][neuron]);
            }
        }

        int outputLayer = LAYER_SIZES.length - 1;
        double[] outputs = new double[LAYER_SIZES[outputLayer]];
        for(int neuron = 0; neuron < activations[outputLayer].length; neuron++) {
            outputs[neuron] = activations[outputLayer][neuron];
        }
        return outputs;
    }

    Direction getDirectionFromOutputs(double[] outputs) {
        double highestOutput = 0;
        int highestOutputIndex = 0;
        for(int i = 0; i < outputs.length; i++) {
            if(outputs[i] > highestOutput) {
                highestOutput = outputs[i];
                highestOutputIndex = i;
            }
        }
        return directions[highestOutputIndex];
    }
}
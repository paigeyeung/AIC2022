package wtest_evolution_pvp_1;

import aic2022.user.*;
import java.util.Arrays;

public class Troop extends AllyUnit {
    Troop(UnitController uc) {
        super(uc);
    }

    // x input -> x hidden -> x hidden -> 9 output
    final int[] LAYER_SIZES = {15, 16, 16, 9};
    // Weights are outgoing weights
/*weights_start*/final float[][][] weights = {{{3.57482336f, -14.03921383f, 0.32164789f, 1.68104785f, 0.12174393f, -1.04102102f, 4.09079015f, 0.73031479f, 1.05270133f, -2.44995282f, 0.78660616f, -3.37182257f, 0.41208746f, 1.6802376f, -4.19972609f, 0.79628766f}, {-1.20022959f, 2.24278817f, -0.54252015f, 0.43310451f, 5.8009658f, -3.70403935f, -0.01738874f, 4.34263357f, -0.49237313f, 4.42202007f, 2.33474326f, 1.95466564f, -0.46132399f, 0.53327143f, -0.13999489f, -1.57382452f}, {-1.84272427f, 0.3693575f, 2.46303345f, -13.03778132f, 5.23209471f, -0.05107777f, 5.76138546f, 0.78168546f, -1.31292222f, 0.42194927f, 6.24421366f, -0.52484965f, 1.02254266f, 0.33217338f, -12.68063926f, -5.94620943f}, {-1.63376668f, -1.62788326f, -2.31967801f, -0.84859787f, 1.54085595f, -10.80472354f, 12.89546406f, 0.81034165f, -0.90735165f, -0.21320737f, 0.48671943f, 10.16848845f, 2.08469192f, 0.107509f, -0.77750712f, -7.90625978f}, {0.52794559f, 1.8000788f, -2.57402914f, 0.11208906f, 30.32146953f, -4.13252281f, 0.95206807f, 0.94144228f, 12.65608988f, 0.03798333f, 1.10126538f, -4.72274803f, -2.21901662f, -8.94538352f, -0.29484351f, -0.63110499f}, {-3.69377321f, 15.23438113f, -1.1543356f, 3.51765395f, 0.32735952f, -2.94543407f, 3.39503733f, 0.7795514f, 1.21873766f, 0.05920402f, -3.24100529f, 0.01613593f, 0.04139914f, 0.37813397f, -1.91634766f, -0.75315653f}, {0.02656257f, 1.60532211f, -2.39374613f, 3.15705294f, 10.64264899f, -1.99440597f, -1.19596182f, 1.84754856f, -0.19477841f, 0.54396614f, 2.42197952f, -0.699376f, 3.33973682f, -2.05029028f, -3.73173814f, 2.50704609f}, {-5.54013458f, 2.03631753f, -0.20472865f, 1.56498512f, -1.80219803f, -0.20774973f, 2.73568114f, 10.5577306f, -2.29722387f, 1.94057222f, 1.71463845f, 3.05089606f, -4.02045233f, 1.14488537f, 1.10167723f, 1.75863942f}, {3.91293906f, 0.17223325f, -0.37395188f, -2.01274742f, -0.74692069f, 0.20800956f, 1.17058596f, -0.68548257f, 8.62002789f, 1.91925257f, -3.21433635f, -0.15997578f, -0.95342354f, 2.31124424f, -7.59998785f, 1.13858277f}, {0.17841505f, 0.27161441f, 0.82272323f, 0.24669556f, 0.52074123f, 0.4204977f, 0.8157665f, 2.03617507f, -12.46483458f, 2.42285211f, 0.43857519f, -1.35079516f, 2.72706083f, 12.39722144f, -3.12503527f, 0.9842405f}, {-1.04145829f, 1.03599102f, -0.02738147f, 0.12230949f, -10.08182092f, 1.29128217f, -1.04348456f, -4.1437678f, -0.12800799f, -4.72058766f, 2.84042797f, 4.6247623f, 0.86066333f, -0.34385963f, -0.30218736f, 0.58904838f}, {-2.08692523f, -1.86065249f, -1.70555597f, -0.71452719f, -0.11776866f, -0.07026888f, -0.50045554f, -6.9767401f, -4.52218726f, -4.53762708f, -0.54352167f, -1.34141397f, 0.03978216f, -1.58304928f, 0.99488322f, 6.94532851f}, {-1.16829406f, -0.92533393f, 11.60516239f, 0.35152118f, 0.85106743f, -0.92584934f, 1.3488454f, -1.57433812f, 1.24075629f, -1.24348919f, -0.44858035f, -1.69200068f, -13.21213195f, -1.76292134f, -4.47736111f, 56.91514944f}, {-0.89783294f, 0.21765884f, -0.89166444f, -2.75674501f, 0.20217248f, -10.16246275f, -0.11962308f, 2.1321521f, -0.34010819f, 2.63160233f, -1.07954622f, -0.03199029f, 0.95249714f, -0.86962898f, -0.1845714f, -0.09461831f}, {-0.65558528f, -1.99845332f, 0.00552243f, 3.26063332f, -3.1266067f, -1.47895907f, -0.44739871f, -1.73036117f, -0.28402261f, 0.50034104f, 3.99971808f, -0.8478289f, 0.14470316f, 0.96549551f, -0.2494206f, 0.15363525f}}, {{-0.26386862f, -2.67132061f, 0.4960046f, 1.3538844f, -1.46110817f, 6.52020675f, -0.50648204f, -1.83393302f, 0.4835129f, 0.26005658f, -0.4785008f, 0.1882545f, 1.18090938f, -0.61051873f, 1.71880963f, 6.62493789f}, {-0.52004276f, -3.61261845f, -0.69639038f, 1.7719508f, 0.93976532f, -0.6585546f, -0.05184594f, 2.66177975f, 4.11412273f, 0.06485252f, 5.23549169f, 2.06992496f, -6.60480735f, -0.77370634f, 2.65907352f, -4.15314911f}, {-1.44600363f, -2.0898849f, 2.33672422f, -4.03016316f, 2.001812f, -0.57274863f, 2.82017641f, -10.02648333f, -4.64113017f, -0.77071496f, -0.88814539f, -0.85447652f, 1.12285641f, -0.03146469f, 1.36629431f, -9.9152441f}, {-1.47658413f, -0.42040151f, 15.53927837f, 13.96841044f, 0.37034576f, 3.29882914f, -0.71569206f, 3.8544829f, -0.52168681f, -0.32178105f, -1.13809234f, 6.80098771f, -1.94042051f, -1.03160091f, -2.80659316f, -0.77598082f}, {-0.64979896f, 0.78774488f, -1.63735186f, -0.16778159f, 2.79063479f, -1.83665413f, -2.67666931f, 1.25920229f, -1.98376617f, -12.84380297f, 1.05015084f, 0.13631249f, -0.47973451f, 2.96696226f, -4.26410471f, -0.91368546f}, {0.36920428f, 1.37987794f, -2.62004134f, -2.0142983f, 8.73112783f, -6.13939818f, -0.69874498f, -0.60791744f, -1.96768106f, 12.38261261f, -0.7596292f, 1.69648184f, -1.79932047f, 1.55720875f, 2.8788173f, 1.24260473f}, {0.36730423f, 1.66769392f, -0.40309973f, -0.48022375f, 0.00121683f, -0.94425719f, -0.249204f, 2.75421652f, -5.49716432f, 0.53776253f, -13.27316336f, -16.704983f, -3.9402533f, 0.05526602f, 0.23995109f, 0.88546779f}, {4.28461025f, -2.2262585f, -3.18435644f, 0.02313147f, 2.11838143f, 0.83332162f, 0.80911233f, 6.39770683f, 0.71828893f, 2.02308697f, -2.50701222f, -2.34193564f, 3.75214036f, -2.30378833f, -0.30912901f, 0.43077623f}, {-2.76993172f, -4.03782046f, 0.95040042f, 0.54394404f, 0.36864016f, 0.71268364f, 1.19176803f, -0.33281752f, -1.03843533f, -1.00168676f, 0.89914331f, 0.35660708f, -0.40544741f, -0.5046784f, 0.32117102f, 0.11879071f}, {-1.74478632f, 6.60722363f, -0.34429787f, 0.68376049f, -0.15016667f, 1.2940268f, -0.7740367f, 2.17744884f, -0.15491418f, -0.71471285f, -2.2998177f, -0.85993225f, 3.10345677f, 1.49897222f, 2.48162959f, 0.08210495f}, {-2.12733572f, 3.94437036f, -0.88155405f, -1.39102112f, 2.51582985f, -1.24819319f, -1.61035929f, 4.74908695f, 6.04437327f, 1.17656278f, -3.22763195f, -0.6860241f, 3.75045232f, -4.21516319f, 14.09045465f, 0.07528358f}, {-0.69667017f, -1.10463142f, 0.40237331f, -1.1891878f, -3.48704636f, 0.98405688f, -0.64469748f, 8.61193652f, -0.66634032f, -1.37002915f, -2.87126507f, -8.45955122f, 2.16360568f, 15.96732731f, -0.99366868f, -0.17146586f}, {0.56068142f, 1.59523555f, -0.34048221f, -3.33098619f, 1.01604535f, 3.95260381f, 0.13683476f, 1.10153595f, -0.51631836f, 9.56269096f, 3.65767716f, 0.40882596f, 1.99033751f, 1.36131311f, 0.18994911f, 1.0947029f}, {5.95989139f, -2.37185213f, 5.74525044f, -1.44803029f, 3.74094238f, -1.89834898f, 7.35459502f, 0.02945677f, -2.12924855f, -9.78903815f, 0.41664131f, 1.7596421f, -6.38696508f, -0.76646925f, -0.15581418f, 0.35410857f}, {-5.86301377f, -0.40833877f, -0.05518429f, 0.10877248f, 2.00882118f, -0.52541104f, -2.53428256f, 0.31227118f, -1.40985216f, -0.69376537f, 0.38420216f, 11.44755136f, 0.15958349f, 2.4665812f, 9.67388098f, -6.05134266f}, {1.05527953f, -1.80932592f, -5.34734473f, 2.73692592f, 1.17052008f, 0.56140744f, -1.19632911f, -2.89436001f, -0.93194384f, 1.05755368f, 1.75644149f, -1.02992398f, -0.12413866f, -0.72864498f, -1.38671214f, 3.62752811f}}, {{-0.69871087f, -2.12091928f, 0.22211881f, -25.84952092f, -0.99520728f, -3.14251975f, 10.03075673f, 1.42393155f, -4.12823476f}, {3.20683763f, 7.67267856f, -0.16217295f, -1.19932836f, -1.14894421f, 2.77018185f, -0.5295719f, -0.3554001f, 1.3708724f}, {-1.14328445f, 0.29302719f, -0.2083129f, -0.65601976f, -1.13393914f, 2.4271859f, 0.59831071f, -0.84803021f, 0.88918925f}, {1.88641897f, -1.52220894f, 1.71240511f, 4.76025618f, 4.19438597f, -1.09981192f, -0.10447591f, -0.81188456f, 0.00808466f}, {1.30046434f, -4.37831459f, -1.16349397f, 2.36974865f, 3.55171554f, -2.23448124f, -0.63817506f, 0.27680405f, 2.25534466f}, {1.44580045f, 1.50154737f, 6.0263995f, -3.33900112f, -0.84701247f, -0.73338937f, -1.94598762f, -12.18484f, 0.82884928f}, {3.96669402f, -1.22886176f, -2.30029205f, 0.18050848f, 0.13591726f, 0.24046869f, 1.32283638f, 7.80810151f, -0.67485231f}, {0.86712831f, 1.03378419f, 0.08931438f, 0.52474844f, -5.7506582f, -1.8738334f, 0.77071795f, 6.85569701f, -0.43397398f}, {-0.67844518f, 5.03094288f, -5.42100633f, 0.1515402f, 1.42089174f, -0.70269326f, 5.73862966f, -0.9772822f, 0.90901151f}, {0.86102118f, 5.17367029f, 0.76671172f, -0.81536181f, 1.82320348f, 13.18766561f, -1.49366153f, 0.45375892f, 0.82228833f}, {1.68195445f, -0.36407315f, 9.802823f, -0.33474575f, 5.06993106f, -0.24303968f, -0.56243723f, 2.449122f, -23.34437753f}, {1.13915031f, 1.52384723f, 0.19134366f, 0.14205703f, 1.2385756f, -0.00508351f, -3.29686507f, 0.33732035f, 0.03532727f}, {1.32964525f, 0.37455623f, 0.30097512f, -21.33704401f, 2.36391708f, 9.22682949f, -0.7661325f, 0.73739984f, -1.7000909f}, {2.48320087f, 10.72972942f, 0.49037908f, -2.98188589f, 1.05376544f, 1.03024636f, 1.59568758f, -1.09568105f, -0.22417989f}, {-3.29609993f, 1.63328219f, -9.01390083f, -0.33292482f, 0.11645978f, -0.6028228f, -2.92817463f, -5.41631979f, 2.58199015f}, {8.64778278f, 0.44618301f, -0.55622575f, -0.19746935f, 0.38530132f, -13.85202221f, -0.25337653f, -6.75366987f, 4.32260388f}}, {{}, {}, {}, {}, {}, {}, {}, {}, {}}};/*weights_end*/
/*biases_start*/final float[][] biases = {{0f, 0f, 0f, 0f, 0f, 0f, 0f, 0f, 0f, 0f, 0f, 0f, 0f, 0f, 0f}, {0.64590795f, -0.39785376f, -0.84826749f, 0.37119164f, -3.01094729f, -6.13562123f, 0.30866826f, -2.01092017f, 0.89444341f, 0.24799867f, 4.20888712f, 1.63419865f, 18.38525242f, -1.25610828f, -4.0835135f, -0.53810926f}, {-0.33026283f, -0.42756217f, 0.83276824f, -2.15895659f, -11.89068894f, -1.07484024f, -0.59683374f, -0.74807285f, 0.81146197f, 0.50134414f, 1.67311685f, 1.5204863f, 5.10251921f, -6.32020575f, 1.74765671f, 0.35679445f}, {-1.25644344f, -0.39390268f, -0.91398206f, -5.24570845f, 0.74171446f, -4.30083577f, -1.13477987f, -2.43704137f, -0.1564428f}};/*biases_end*/

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
        if(uc.canAttack()) {
            UnitInfo nearestEnemyOrNeutral = getNearestEnemyOrNeutral(true, true);
            if(nearestEnemyOrNeutral != null) {
                if(loggingOn) uc.println("nearestEnemyOrNeutral " + nearestEnemyOrNeutral.getLocation());
                int damage = tryAttack(nearestEnemyOrNeutral.getLocation());
                if(damage != 0)
                    communication.addScore(damage);
            }
        }

        if(uc.canMove()) {
            if(loggingOn) uc.println("start (" + uc.getEnergyUsed() + " energy)");
            float[] inputData = getInputData();
            if(loggingOn) uc.println("inputData " + Arrays.toString(inputData) + " (" + uc.getEnergyUsed() + " energy)");
            float[] outputs = forwardPropagate(inputData);
            if(loggingOn) uc.println("outputs " + Arrays.toString(outputs) + " (" + uc.getEnergyUsed() + " energy)");
            Direction outputDirection = getDirectionFromOutputs(outputs);
            if(loggingOn) uc.println("outputDirection " + outputDirection + " (" + uc.getEnergyUsed() + " energy)");
            tryMove(outputDirection, true);
        }
    }

    float[] getInputData() {
        Location selfLocation = uc.getLocation();

        float selfHealth = (float)Math.log(uc.getInfo().getHealth());

        float allyBaseDistance = (float)Math.log(Math.sqrt(selfLocation.distanceSquared(communication.allyBaseLocation)));

        int allyBaseDirectionX = 0;
        int allyBaseDirectionY = 0;
        if(selfLocation.x < communication.allyBaseLocation.x)
            allyBaseDirectionX = 1;
        else if(selfLocation.x > communication.allyBaseLocation.x)
            allyBaseDirectionX = -1;
        if(selfLocation.y < communication.allyBaseLocation.y)
            allyBaseDirectionY = 1;
        else if(selfLocation.y > communication.allyBaseLocation.y)
            allyBaseDirectionY = -1;

        float enemyBaseDistance = (float)Math.log(Math.sqrt(selfLocation.distanceSquared(communication.enemyBaseLocation)));

        int enemyBaseDirectionX = 0;
        int enemyBaseDirectionY = 0;
        if(selfLocation.x < communication.enemyBaseLocation.x)
            enemyBaseDirectionX = 1;
        else if(selfLocation.x > communication.enemyBaseLocation.x)
            enemyBaseDirectionX = -1;
        if(selfLocation.y < communication.enemyBaseLocation.y)
            enemyBaseDirectionY = 1;
        else if(selfLocation.y > communication.enemyBaseLocation.y)
            enemyBaseDirectionY = -1;

        int northEastNumAllies = 0;
        int northEastNumNeuralsOrEnemies = 0;
        int southEastNumAllies = 0;
        int southEastNumNeuralsOrEnemies = 0;
        int southWestNumAllies = 0;
        int southWestNumNeuralsOrEnemies = 0;
        int northWestNumAllies = 0;
        int northWestNumNeuralsOrEnemies = 0;

        UnitInfo[] visibleUnits = uc.senseUnits();
        for (UnitInfo visibleUnit : visibleUnits) {
            Location visibleUnitLocation = visibleUnit.getLocation();
            if(visibleUnit.getTeam() == ally) {
                if(selfLocation.x <= visibleUnitLocation.x) {
                    if(selfLocation.y <= visibleUnitLocation.y)
                        northEastNumAllies++;
                    else
                        southEastNumAllies++;
                }
                else {
                    if(selfLocation.y <= visibleUnitLocation.y)
                        northWestNumAllies++;
                    else
                        southWestNumAllies++;
                }
            }
            else {
                if(selfLocation.x <= visibleUnitLocation.x) {
                    if(selfLocation.y <= visibleUnitLocation.y)
                        northEastNumNeuralsOrEnemies++;
                    else
                        southEastNumNeuralsOrEnemies++;
                }
                else {
                    if(selfLocation.y <= visibleUnitLocation.y)
                        northWestNumNeuralsOrEnemies++;
                    else
                        southWestNumNeuralsOrEnemies++;
                }
            }
        }

        if(loggingOn)
            uc.println("selfHealth: " + selfHealth + ", allyBaseDistance: " + allyBaseDistance + ", allyBaseDirectionX: " + allyBaseDirectionX + ", allyBaseDirectionY: " + allyBaseDirectionY + ", enemyBaseDistance: " + enemyBaseDistance + ", enemyBaseDirectionX: " + enemyBaseDirectionX + ", enemyBaseDirectionY: " + enemyBaseDirectionY + ", northEastNumAllies: " + northEastNumAllies + ", northEastNumNeuralsOrEnemies: " + northEastNumNeuralsOrEnemies + ", southEastNumAllies: " + southEastNumAllies + ", southEastNumNeuralsOrEnemies: " + southEastNumNeuralsOrEnemies + ", southWestNumAllies: " + southWestNumAllies + ", southWestNumNeuralsOrEnemies: " + southWestNumNeuralsOrEnemies + ", northWestNumAllies: " + northWestNumAllies + ", northWestNumNeuralsOrEnemies: " + northWestNumNeuralsOrEnemies);

        return new float[]{
                selfHealth, allyBaseDistance,
                allyBaseDirectionX, allyBaseDirectionY,
                enemyBaseDistance,
                enemyBaseDirectionX, enemyBaseDirectionY,
                northEastNumAllies, northEastNumNeuralsOrEnemies,
                southEastNumAllies, southEastNumNeuralsOrEnemies,
                southWestNumAllies, southWestNumNeuralsOrEnemies,
                northWestNumAllies, northWestNumNeuralsOrEnemies
        };
    }

    float relu(float x) {
        if(x > 0)
            return x;
        return 0;
    }

    float sigmoid(float x) {
        return 1 / (1 + (float)Math.exp(-x));
    }

    float[] forwardPropagate(float[] inputData) {
        float[][] activations = new float[LAYER_SIZES.length][];
        for(int layer = 1; layer < LAYER_SIZES.length; layer++) {
            activations[layer] = new float[LAYER_SIZES[layer]];
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
        float[] outputs = new float[LAYER_SIZES[outputLayer]];
        System.arraycopy(activations[outputLayer], 0, outputs, 0, activations[outputLayer].length);
        return outputs;
    }

    Direction getDirectionFromOutputs(float[] outputs) {
//        float highestOutput = 0;
//        int highestOutputIndex = 0;
//        for(int i = 0; i < outputs.length; i++) {
//            if(outputs[i] > highestOutput) {
//                highestOutput = outputs[i];
//                highestOutputIndex = i;
//            }
//        }
//        return directions[highestOutputIndex];
        float totalOutputs = 0;
        for (float output : outputs) {
            totalOutputs += output;
        }
        float selectRandomPercent = (float)Math.random();
        int selectIndex = 0;
        float currentPercent = 0;
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
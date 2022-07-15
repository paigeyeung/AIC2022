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
/*weights_start*/final float[][][] weights = {{{1.89325897f, -12.79409582f, 0.40798645f, 1.47063925f, 0.44792973f, -1.10033347f, 2.21446033f, 0.94927877f, 1.05538939f, -3.09339859f, 0.71045832f, -10.37235564f, 0.44639969f, 2.4654842f, -0.60374592f, 0.5421893f}, {-0.72196638f, 0.62332439f, -0.83389942f, 0.48123357f, 3.52752554f, -2.29872651f, -0.0096706f, 4.0393777f, -1.62485493f, 2.2581273f, 3.79530963f, 1.78230903f, -0.89257466f, 0.58927647f, -0.12815869f, -3.12520246f}, {-1.6431385f, 0.21693497f, 0.47792937f, -23.00724383f, 3.45771374f, -0.03767728f, 3.19228131f, 0.5303221f, -0.8348f, 1.03551465f, 6.85283863f, -0.63599324f, 1.30771714f, 0.49710298f, -15.93612846f, -3.05476927f}, {-2.48815944f, -0.84113177f, -2.01774572f, -0.54709518f, 0.81441523f, -9.99656594f, 13.60517641f, 1.35182495f, -1.43841339f, -0.26837402f, 0.7089751f, 12.32340098f, 2.12741245f, 0.12023367f, -2.07698434f, -5.80148663f}, {0.66661387f, 4.67008357f, -4.38049959f, 0.20822657f, 23.61166603f, -4.73800435f, 0.91960543f, 0.77130903f, 18.10524204f, 0.04003501f, 0.80662352f, -4.66984303f, -0.92304329f, -3.9997238f, -0.30529774f, -1.58607946f}, {-3.64570927f, 10.33823331f, -1.87366646f, 5.88820943f, 0.19061864f, -2.55230813f, 6.64790812f, 1.20023869f, 1.08780794f, 0.0690205f, -1.10247394f, 0.01029362f, 0.02129831f, 0.30376932f, -1.99531874f, -0.62490618f}, {0.02494462f, 2.734933f, -1.79060565f, 3.72186615f, 5.19144307f, -1.49581231f, -0.43875964f, 1.45068441f, -0.11285682f, 0.26972744f, 2.19851494f, -0.65123271f, 2.37819263f, -0.97297191f, -4.04621766f, 1.67333535f}, {-1.35102649f, 0.9215298f, -0.21590993f, 2.2896439f, -3.22522656f, -0.38610843f, 2.70618818f, 2.3809835f, -1.71710152f, 1.45709016f, 0.71237286f, 1.47981647f, -2.83716402f, 1.90876666f, 0.48159988f, 3.39634132f}, {5.32350627f, 0.28636378f, -0.60332285f, -0.80025869f, -1.44172299f, 0.16741938f, 1.66556456f, -1.41973926f, 14.79199175f, 1.30646938f, -6.35944887f, -0.16294365f, -0.34905647f, 2.41638159f, -12.75390379f, 0.66415059f}, {0.13341444f, 0.64876096f, 0.74881563f, 0.42409095f, 0.68340507f, 1.51174207f, 0.49793947f, 1.70284068f, -26.91155626f, 2.49415137f, 0.15762669f, -1.77403297f, 1.33247222f, 9.88717901f, -3.79219994f, 0.40976252f}, {-1.19477569f, 0.81643022f, -0.08126637f, 0.18400676f, -8.20251952f, 0.52331882f, -0.62162993f, -5.45104422f, -0.06185218f, -5.39594161f, 1.66343337f, 5.54145825f, 1.21324663f, -0.39938482f, -0.57376518f, 0.36205474f}, {-1.02805703f, -1.18130669f, -0.78683361f, -0.46734662f, -0.04666282f, -0.10567483f, -0.95241216f, -4.6301944f, -6.54039715f, -6.15934083f, -0.6335626f, -0.8944117f, 0.04706188f, -1.69842647f, 1.02571387f, 3.92813676f}, {-1.92345482f, -1.96599887f, 9.48011476f, 0.22515926f, 0.56993107f, -0.55916222f, 1.69777653f, -1.22851279f, 0.76208225f, -0.99969572f, -0.26167113f, -2.34453718f, -4.16913709f, -1.87225982f, -4.40076746f, 16.96952643f}, {-0.4695461f, 0.22037719f, -0.45736671f, -1.08438678f, 0.15306663f, -6.29018422f, -0.05921146f, 3.78709738f, -1.0273882f, 0.83658768f, -0.64618373f, -0.02814885f, 0.51016642f, -0.91614603f, -0.23688616f, -0.06389073f}, {-0.48189499f, -0.55628748f, 0.00360072f, 2.62154798f, -2.79724121f, -1.51927023f, -0.54831425f, -1.11185286f, -0.31462419f, 0.62623943f, 6.81061375f, -0.30508438f, 0.07969796f, 4.8751739f, -0.21131717f, 0.15093781f}}, {{-0.22091774f, -0.87792827f, 0.2720634f, 0.77695357f, -0.74487374f, 13.35203682f, -0.75598258f, -1.37349199f, 0.42229092f, 0.23046946f, -0.50737852f, 0.19269011f, 3.1057433f, -0.41934374f, 0.88831703f, 11.91728248f}, {-0.8439987f, -1.94676692f, -0.80835751f, 1.34519895f, 1.87155671f, -3.95906769f, -0.22879018f, 1.12444781f, 13.00955392f, 0.07502916f, 2.8114631f, 3.35877031f, -7.33263501f, -1.60218204f, 2.86738747f, -4.91949396f}, {-2.48950718f, -1.44589171f, 4.01597071f, -4.1164208f, 2.36015207f, -0.87444435f, 1.41359317f, -13.02467007f, -5.54201008f, -0.30693917f, -2.24348795f, -0.46506417f, 0.18797285f, -0.08544671f, 1.83663507f, -8.6841847f}, {-0.96724251f, -0.24554591f, 7.09558053f, 13.96383026f, 0.15567479f, 5.63327983f, -0.54105721f, 4.1977488f, -1.89631022f, -0.28183945f, -1.38700545f, 5.65253473f, -2.54159334f, -1.45624565f, -3.05935122f, -0.86728805f}, {-0.77105817f, 0.23827517f, -0.77339783f, -0.18499086f, 2.60196323f, -2.02195131f, -1.35396f, 0.72504406f, -1.90290873f, -5.07559477f, 1.50277426f, 0.26223574f, -0.22235094f, 0.87953971f, -4.93336788f, -1.32341223f}, {0.38413134f, 1.23345371f, -0.93639244f, -2.33101589f, 10.83440952f, -6.48219828f, -2.22526067f, -0.96519444f, -1.22448215f, 12.59088844f, -0.34719594f, 0.80658886f, -1.87988782f, 0.79110224f, 1.99611415f, 0.78055883f}, {0.2754757f, 1.72262857f, -0.28410133f, -0.56658898f, 0.00214633f, -2.39711992f, -0.41288425f, 2.89315673f, -7.54081529f, 0.96317583f, -32.61527788f, -19.67832667f, -2.39873513f, 0.04226058f, 0.13547946f, 0.99915198f}, {7.00835711f, -0.83944299f, -0.95650889f, 0.06145325f, 0.69338008f, 0.56886035f, 0.88879777f, 5.08114988f, 1.40394265f, 2.01024532f, -4.18588544f, -5.47484739f, 2.217047f, -2.36938317f, -0.45160589f, 1.48159887f}, {-2.32996035f, -4.19796542f, 2.26832848f, 0.62656129f, 0.73336109f, 0.42838924f, 1.65120021f, -0.45740295f, -0.42520982f, -3.74478919f, 0.77277148f, 0.26288535f, -0.29699951f, -0.79565908f, 0.483637f, 0.18534985f}, {-1.94890708f, 3.03913447f, -0.57482496f, 1.01965992f, -0.12023504f, 0.70257025f, -0.52153653f, 1.9422522f, -0.19904008f, -0.90920101f, -1.43234667f, -1.79768888f, 1.55012347f, 1.09918311f, 5.06586279f, 0.43069751f}, {-1.52267414f, 1.46209512f, -1.42401447f, -1.51346531f, 2.56192829f, -0.74227765f, -1.40517241f, 4.40505985f, 7.29045474f, 1.25450089f, -4.39666545f, -0.55503723f, 2.98751751f, -3.17346287f, 9.75095788f, 0.08299361f}, {-0.44640728f, -1.32051021f, 0.98168551f, -0.42739554f, -3.30167767f, 0.49779513f, -0.48990351f, 20.50531307f, -0.87242f, -1.54620826f, -6.78753835f, -6.36847336f, 2.61303564f, 6.7784039f, -2.14444086f, -0.20412587f}, {0.67518516f, 0.47579994f, -0.23941043f, -4.48080619f, 2.34959098f, 3.74510017f, 0.10283511f, 0.25263278f, -0.50258203f, 5.02430958f, 3.62297217f, 0.34370776f, 3.18610685f, 2.06664853f, 0.43041896f, 0.77632768f}, {3.38990319f, -5.21354843f, 7.79042252f, -1.35391913f, 1.81717435f, -2.42669034f, 3.57119376f, 0.0525608f, -5.50138505f, -7.7666035f, 0.87666936f, 2.41856364f, -4.66504394f, -0.2971175f, -0.26101074f, 0.50163627f}, {-5.09527957f, -0.33691906f, -0.04203183f, 0.1774423f, 1.00420485f, -0.48455778f, -1.83429003f, 0.55458448f, -0.8921692f, -0.45375674f, 0.18425272f, 6.25264997f, 0.15930886f, 2.58285965f, 15.19225128f, -5.10641965f}, {2.90670414f, -3.99062492f, -4.19032034f, 2.95135494f, 2.53328951f, 1.33010891f, -1.08266682f, -4.44015456f, -0.9083943f, 0.84002151f, 1.58741638f, -1.54577232f, -0.11142529f, -0.83616888f, -1.46938863f, 1.99129773f}}, {{-0.8072021f, -2.57487883f, 0.50652179f, -21.10654752f, -1.21715182f, -1.71693636f, 5.17499892f, 4.59771171f, -2.29997733f}, {1.86244333f, 4.67389245f, -0.18559005f, -2.00439878f, -1.58760837f, 2.5071564f, -0.47273333f, -0.90289489f, 1.17218074f}, {-1.2833055f, 0.20842766f, -0.28928181f, -0.8126701f, -0.48343608f, 5.17035556f, 0.47704405f, -0.54250222f, 3.42389563f}, {2.64551174f, -2.10109182f, 1.24548207f, 2.69355543f, 3.73622926f, -0.2905463f, -0.11473151f, -0.71732862f, 0.00639414f}, {1.02622929f, -2.9793642f, -1.72458829f, 3.42498838f, 8.12370704f, -3.38844079f, -0.25409506f, 0.2060788f, 1.09108241f}, {1.07973404f, 1.77723127f, 7.10812856f, -7.69067897f, -0.43356246f, -1.04959132f, -7.28569754f, -13.04549101f, 0.52547184f}, {2.69604538f, -1.53460603f, -1.5744639f, 0.1426882f, 0.21472812f, 0.16407637f, 0.96064473f, 4.47419395f, -1.74634496f}, {1.24330231f, 1.58165448f, 0.03123031f, 0.52269647f, -6.78103559f, -1.28432727f, 1.66962884f, 7.71609326f, -0.86792765f}, {-0.46388712f, 6.98936044f, -4.35057062f, 0.37934245f, 1.47394305f, -1.30956395f, 5.07067406f, -0.74153225f, 1.25699562f}, {1.31741046f, 2.22539968f, 1.6662145f, -1.37697644f, 4.85485156f, 16.68521824f, -2.38251097f, 0.32368298f, 0.94194965f}, {1.36034397f, -0.31555704f, 2.90881058f, -0.58550137f, 3.91763285f, -0.43641241f, -0.28477029f, 3.36478929f, -24.38553993f}, {2.49814219f, 3.67744131f, 0.24131394f, 0.1911038f, 3.3621258f, -0.00416209f, -2.62176795f, 0.41652535f, 0.04522008f}, {3.52210993f, 0.50427751f, 0.3303773f, -7.7718153f, 3.7567637f, 11.85459632f, -0.25700859f, 1.57008869f, -1.44958908f}, {1.96721679f, 4.06677499f, 0.42787292f, -5.25062109f, 1.4862747f, 1.78755451f, 3.29769928f, -0.89156163f, -0.26385028f}, {-5.48343718f, 1.62874042f, -9.09255941f, -0.44902234f, 0.09467178f, -0.46005905f, -2.89440885f, -3.01681501f, 0.56043341f}, {1.5864171f, 1.41222804f, -0.37059924f, -0.2834652f, 1.25130044f, -8.78976704f, -0.1877983f, -15.9587733f, 2.28807402f}}, {{}, {}, {}, {}, {}, {}, {}, {}, {}}};/*weights_end*/
/*biases_start*/final float[][] biases = {{0f, 0f, 0f, 0f, 0f, 0f, 0f, 0f, 0f, 0f, 0f, 0f, 0f, 0f, 0f}, {0.62907801f, -0.78339834f, -0.3665441f, 0.87423422f, -3.27390142f, -12.20459979f, 0.67690832f, -4.91545006f, 0.4573929f, 0.40988055f, 4.25425313f, 1.43694513f, 8.13884023f, -2.71886812f, -9.36525585f, -1.80877031f}, {-0.32968284f, -0.80236387f, 1.01191663f, -1.64362402f, -23.94891275f, -1.61588253f, -0.64178138f, -1.46088676f, 0.48271296f, 0.58339349f, 1.80473446f, 1.31897394f, 4.03275779f, -3.85233879f, 2.56522169f, 0.44392343f}, {-2.9695802f, -0.34542181f, -1.07601957f, -4.31334752f, 0.66219029f, -5.35878117f, -0.96001896f, -5.29668612f, -0.37191348f}};/*biases_end*/

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
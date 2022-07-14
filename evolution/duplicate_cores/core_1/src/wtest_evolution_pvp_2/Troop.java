package wtest_evolution_pvp_2;

import aic2022.user.*;
import java.util.Arrays;

public class Troop extends AllyUnit {
    Troop(UnitController uc) {
        super(uc);
    }

    // x input -> x hidden -> x hidden -> 9 output
    final int[] LAYER_SIZES = {15, 16, 16, 9};
    // Weights are outgoing weights
/*weights_start*/final float[][][] weights = {{{3.79491729f, -8.50183975f, 0.34379317f, 1.73870122f, 0.25094619f, -0.86762737f, 2.35461782f, 2.7922887f, 1.64922186f, -2.06412393f, 2.16716382f, -4.02180439f, 0.46332738f, 1.44443574f, -1.65116609f, 0.6136761f}, {-1.57240008f, 1.04860441f, -1.32608149f, 0.5434202f, 3.53204356f, -2.78559521f, -0.01071661f, 5.98702581f, -0.73297479f, 2.45319129f, 2.76082556f, 1.65140619f, -1.06915685f, 0.66975547f, -0.20933609f, -1.45439097f}, {-1.86595238f, 0.19243594f, 2.19290761f, -10.3496162f, 6.18123169f, -0.10755802f, 3.43460472f, 0.44206806f, -1.68176393f, 0.83151985f, 9.75924965f, -0.32312272f, 0.26008356f, 0.59958074f, -14.96655392f, -0.99376182f}, {-3.01021126f, -4.06893727f, -1.20609915f, -0.9922765f, 2.42325276f, -10.97477844f, 9.07895377f, 1.75829253f, -2.47816911f, -0.22443734f, 1.32984441f, 2.77572527f, 1.06946404f, 0.06657781f, -1.50616945f, -5.25667369f}, {1.13108729f, 0.89008077f, -3.35759989f, 0.31515385f, 36.62279612f, -3.87243162f, 0.65688448f, 0.58055281f, 21.91647891f, 0.02592205f, 0.54292093f, -3.9586669f, -1.21074459f, -10.65843577f, -0.80643372f, -1.09054919f}, {-2.37255149f, 12.97663148f, -1.72098526f, 6.96415874f, 1.03516598f, -2.89214745f, 1.33469145f, 3.2077248f, 2.16336842f, 0.10779877f, -1.56739309f, 0.01395671f, 0.06059833f, 0.31197812f, -2.63796327f, -1.20630534f}, {0.01883279f, 2.30908121f, -3.58281255f, 3.51589726f, 2.73452575f, -6.45984766f, -0.54765598f, 1.10606577f, -0.12048195f, 0.75915225f, 2.65976415f, -1.17069466f, 5.54172329f, -1.1038298f, -1.56111982f, 1.28926712f}, {-4.03740184f, 2.8293931f, -0.51498271f, 1.24057823f, -2.04461064f, -0.21860216f, 1.99224446f, 5.71886751f, -2.54200961f, 1.77221897f, 2.89950554f, 1.32218528f, -1.99021744f, 0.81985972f, 0.79309071f, 0.8239817f}, {3.49494873f, 0.5625893f, -0.41234091f, -6.75966193f, -0.44345996f, 0.52817992f, 1.96602813f, -1.00555634f, 22.09167809f, 1.92755969f, -6.47163499f, -0.20753994f, -1.06444068f, 3.1565236f, -5.16888242f, 1.04334816f}, {0.3403439f, 0.44216043f, 1.32064561f, 0.34523065f, 0.54686766f, 1.05734469f, 2.24215312f, 4.5330097f, -8.60296063f, 1.07481618f, 0.37998969f, -1.77810818f, 5.16004163f, 6.14238291f, -2.53210904f, 0.70497371f}, {-1.79540401f, 1.59128967f, -0.02609787f, 0.28565556f, -6.00882065f, 0.87120236f, -1.79976568f, -1.59032948f, -0.11876514f, -6.80157662f, 2.46438433f, 4.66274994f, 2.85617155f, -0.58208493f, -0.59570724f, 1.86026057f}, {-2.50175408f, -1.67671346f, -1.27279514f, -0.57295864f, -0.0550085f, -0.12870163f, -1.18846243f, -2.64260998f, -5.33452441f, -4.60691895f, -0.51741513f, -1.77674163f, 0.0955816f, -3.42290624f, 0.42807481f, 7.31143038f}, {-6.23451176f, -1.85244638f, 5.67065162f, 0.68997676f, 1.32536124f, -0.87666164f, 2.27669816f, -1.61743441f, 1.13872098f, -1.68779032f, -0.20362884f, -3.36639784f, -7.91620733f, -0.69301312f, -4.06335811f, 7.89831289f}, {-1.18912699f, 0.16247844f, -1.12976802f, -3.44002942f, 0.31008349f, -4.32391382f, -0.07104462f, 2.27387106f, -1.1650464f, 1.29525387f, -1.4832829f, -0.03619916f, 1.51087874f, -1.5662532f, -0.21732361f, -0.12414626f}, {-0.76888063f, -1.43283218f, 0.00445999f, 4.55733431f, -3.04748931f, -2.4690518f, -2.2544552f, -2.03453773f, -0.41488021f, 1.1483939f, 4.48925804f, -0.71791232f, 0.11386477f, 1.49606825f, -0.43460135f, 0.11358753f}}, {{-0.71162002f, -1.10484393f, 0.26705653f, 1.63257345f, -0.85986668f, 17.66329474f, -0.55510065f, -2.12750774f, 1.22713437f, 0.31733723f, -0.18150365f, 0.13706552f, 2.2752161f, -2.53381982f, 2.9122313f, 5.59284068f}, {-1.62472066f, -3.1529463f, -0.72486497f, 2.94053078f, 1.83200784f, -1.70837561f, -0.09988095f, 0.99810659f, 10.97038859f, 0.08663006f, 2.36201045f, 3.65750102f, -7.18625044f, -1.58791758f, 3.28786661f, -4.08405935f}, {-1.71861842f, -1.80588682f, 2.0465696f, -11.11899796f, 2.97785769f, -1.15864359f, 1.63627152f, -6.22752203f, -4.37529153f, -0.70166859f, -1.11003828f, -0.79617546f, 0.58536459f, -0.162241f, 2.29393174f, -9.80373881f}, {-0.89148329f, -0.40936999f, 12.93187144f, 12.45901933f, 0.77379874f, 5.03095019f, -0.49471491f, 2.33690303f, -0.85705594f, -0.79737652f, -2.00304296f, 17.52803362f, -2.98691362f, -2.18430366f, -3.50008552f, -1.02472074f}, {-0.3647019f, 0.72191727f, -1.81252827f, -0.26274861f, 1.94394548f, -1.89626583f, -4.91022163f, 0.75653699f, -1.71163606f, -5.06174812f, 0.74928797f, 0.21332074f, -0.71155677f, 1.4885224f, -4.56678339f, -0.75239432f}, {0.61918774f, 1.7610516f, -2.01048308f, -3.57573077f, 8.69980771f, -6.14405657f, -0.89139579f, -0.56562228f, -0.83413408f, 4.82402876f, -0.41554768f, 5.46066996f, -1.0336437f, 1.47785981f, 3.33214845f, 0.68398079f}, {1.26001921f, 1.7490091f, -0.25526803f, -0.56285108f, 0.00182382f, -1.70103302f, -0.68722522f, 2.40596191f, -6.33353674f, 1.27243689f, -19.46114147f, -15.61870638f, -3.46842251f, 0.08224681f, 0.22236388f, 1.57394114f}, {5.03879912f, -0.97271042f, -3.2160762f, 0.0379347f, 2.569179f, 1.19426263f, 0.96478972f, 3.56559774f, 1.83046487f, 1.5944862f, -1.77064475f, -5.73299081f, 1.68108014f, -3.36890911f, -0.3164668f, 0.76382034f}, {-7.10223055f, -6.31410153f, 4.11013254f, 0.96235734f, 1.00263237f, 1.78894588f, 0.68485683f, -0.33114782f, -0.66067766f, -1.58053319f, 1.402191f, 0.69948887f, -0.35521274f, -0.79998329f, 0.51915696f, 0.22253292f}, {-2.23654093f, 6.34389316f, -0.64245411f, 0.72923027f, -0.12599176f, 0.65889483f, -1.37878339f, 1.39988878f, -0.13397372f, -0.70506481f, -1.7539971f, -1.23107025f, 8.6055327f, 2.07999836f, 4.80442238f, 0.30592664f}, {-1.50507697f, 2.77015394f, -1.71064752f, -0.678315f, 2.68684818f, -0.72254292f, -4.14848394f, 4.69907268f, 5.41766054f, 1.19696681f, -2.70934139f, -1.07237916f, 2.76618533f, -2.53853186f, 5.6651706f, 0.0933532f}, {-0.38306153f, -0.97730213f, 1.61477463f, -0.55372779f, -3.75125405f, 0.82037949f, -0.9993137f, 12.77161272f, -2.45999358f, -1.19902906f, -2.97492311f, -2.19002173f, 1.77456073f, 5.79329039f, -2.07194803f, -0.52627637f}, {0.60826343f, 2.06595002f, -0.64532558f, -6.91403596f, 2.24510321f, 4.59971255f, 0.12202189f, 0.70442365f, -0.233162f, 7.16695566f, 3.80192465f, 1.12765376f, 1.32537112f, 2.76114057f, 0.1973192f, 1.53248452f}, {7.75102102f, -2.27360801f, 4.75965041f, -0.66996281f, 1.67886902f, -1.13067006f, 13.75909871f, 0.10341375f, -2.72978808f, -4.05427547f, 0.36178077f, 5.23737183f, -6.07811671f, -0.89155711f, -0.20085418f, 0.47345306f}, {-7.57810909f, -0.30126538f, -0.06584688f, 0.17346718f, 1.57627698f, -0.90636149f, -1.58097703f, 0.73660986f, -1.27130103f, -0.78754917f, 0.40530712f, 6.29070344f, 0.31075973f, 7.80148546f, 18.54327652f, -12.81456372f}, {1.44568724f, -3.81981551f, -3.09484159f, 1.72804416f, 1.65541555f, 0.8849434f, -1.93854985f, -1.6318786f, -3.09267798f, 0.73367255f, 2.8110208f, -1.06609071f, -0.22125078f, -0.88051474f, -3.32667295f, 1.54536405f}}, {{-0.88634223f, -1.8276132f, 0.50663614f, -25.33842675f, -2.19550944f, -1.51742497f, 7.33374849f, 2.12793393f, -2.2504853f}, {2.11134866f, 3.54205428f, -0.23627249f, -1.12083971f, -1.14900015f, 2.37722864f, -0.35635701f, -1.28471283f, 1.94662166f}, {-1.64439144f, 0.31722791f, -0.37982304f, -1.61030029f, -0.55474709f, 5.33698925f, 0.15453653f, -1.10802f, 1.91324909f}, {2.32192011f, -0.93246776f, 1.34146691f, 4.7017523f, 6.25071276f, -1.60067258f, -0.34000475f, -2.04286723f, 0.00766476f}, {2.06431733f, -6.96812914f, -1.55754893f, 5.19160095f, 5.93679235f, -4.22093866f, -0.27468506f, 0.16064507f, 2.10815677f}, {3.02930121f, 1.57196533f, 3.66273441f, -3.58161343f, -0.40667555f, -0.68669123f, -5.17083774f, -13.82855988f, 2.69905821f}, {2.31991744f, -1.20260328f, -3.17946715f, 0.1014004f, 0.10974895f, 0.41135077f, 0.88614198f, 4.27763275f, -1.90460406f}, {2.10710947f, 1.60223574f, 0.07008891f, 0.57231502f, -3.30246561f, -1.47440505f, 0.72156132f, 7.60978519f, -0.82188865f}, {-1.21902041f, 6.89661031f, -8.96733538f, 0.24025533f, 1.20340434f, -0.6547061f, 2.67167624f, -1.22460907f, 2.52176466f}, {0.82741211f, 2.98136225f, 0.50494008f, -1.79345103f, 4.42456275f, 13.46779328f, -1.08125279f, 0.38451952f, 0.79711481f}, {1.28223455f, -0.22963102f, 4.29777832f, -0.95371265f, 6.25985724f, -0.45598178f, -0.40853555f, 2.86310017f, -16.85175609f}, {2.34568718f, 5.98986371f, 0.4106689f, 0.20092436f, 3.001115f, -0.00889013f, -1.86292027f, 0.97461616f, 0.07141817f}, {1.34310265f, 0.25763277f, 0.30467762f, -6.79282414f, 11.48816063f, 10.72845796f, -1.54151106f, 2.19756321f, -1.37238997f}, {1.83809729f, 7.34804744f, 0.64375918f, -6.28721512f, 1.33613321f, 1.61983018f, 1.37325057f, -1.58025185f, -0.34838415f}, {-3.8092983f, 2.21823921f, -13.22598769f, -0.5461918f, 0.15754936f, -0.61074883f, -2.8714479f, -5.71184403f, 0.72803221f}, {4.71221141f, 1.35708474f, -0.25594662f, -0.67439719f, 0.8608898f, -6.99187918f, -0.19341081f, -5.66262366f, 4.19692332f}}, {{}, {}, {}, {}, {}, {}, {}, {}, {}}};/*weights_end*/
/*biases_start*/final float[][] biases = {{0f, 0f, 0f, 0f, 0f, 0f, 0f, 0f, 0f, 0f, 0f, 0f, 0f, 0f, 0f}, {0.82192016f, -0.542031f, -0.34531054f, 0.5102622f, -3.12629414f, -3.21954473f, 0.63697043f, -1.99132289f, 0.52557515f, 0.24394236f, 3.42859964f, 0.90147206f, 6.12392517f, -1.87032096f, -2.75882343f, -1.6161376f}, {-0.39195813f, -0.60164098f, 0.57870457f, -1.50799999f, -10.94749202f, -0.87022043f, -1.28691149f, -0.91431446f, 1.05804859f, 0.55042113f, 1.79112225f, 1.39176263f, 10.93844031f, -2.81819636f, 3.94397179f, 1.16253224f}, {-1.24746542f, -0.54665924f, -0.79540701f, -6.50922464f, 0.92162367f, -3.51210013f, -2.17404438f, -2.76027597f, -0.17570765f}};/*biases_end*/

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
            UnitInfo nearestEnemyOrNeutral = getNearestEnemyOrNeutral(true, false);
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
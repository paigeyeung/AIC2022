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
/*weights_start*/final float[][][] weights = {{{4.52734471f, -20.13223127f, 0.26434705f, 1.43572253f, 0.33804861f, -1.99055739f, 2.51909751f, 0.78536864f, 1.09992809f, -4.04390766f, 1.20694212f, -4.01263899f, 0.27221713f, 2.00678522f, -2.24668118f, 0.47662796f}, {-1.1191496f, 0.44415051f, -0.73587799f, 0.35904294f, 2.55228697f, -5.37835993f, -0.01407795f, 3.80752835f, -1.11903299f, 2.0904531f, 3.22336822f, 2.98072155f, -1.10244385f, 0.60606734f, -0.10144796f, -2.03655031f}, {-1.3825591f, 0.15032362f, 1.15584059f, -20.88161718f, 6.12991437f, -0.03524275f, 3.21714135f, 0.24868626f, -1.1281758f, 0.40530258f, 10.45755883f, -0.83056375f, 0.78698114f, 0.35165757f, -24.1134868f, -4.03346239f}, {-2.17440599f, -1.39503912f, -0.69983897f, -0.44387495f, 0.83132416f, -6.95863977f, 12.51339882f, 1.62784855f, -0.66516844f, -0.23969774f, 0.26610086f, 4.05553569f, 1.02305836f, 0.1110033f, -1.58655032f, -5.62322184f}, {1.01274341f, 3.58388622f, -2.90697279f, 0.17814146f, 47.43199613f, -3.30401505f, 0.90738459f, 0.50724741f, 9.31463765f, 0.03552805f, 1.03652621f, -4.46762214f, -0.98526429f, -4.10171112f, -0.15695698f, -1.61420001f}, {-2.80017239f, 11.95371187f, -1.89125249f, 4.66015728f, 0.22825368f, -3.30968261f, 2.45651906f, 0.96364094f, 0.78931305f, 0.06831079f, -2.11788045f, 0.00821513f, 0.05740416f, 0.29809137f, -2.66475744f, -0.64147829f}, {0.04350096f, 1.82968336f, -2.65975807f, 4.55119724f, 3.24348161f, -2.15750877f, -0.58287998f, 0.75300807f, -0.06558526f, 0.53729023f, 2.72559249f, -0.33206308f, 1.84171986f, -1.15445037f, -2.74134976f, 2.45629615f}, {-1.99099279f, 1.65605594f, -0.14984112f, 2.06561722f, -2.21494204f, -0.31628381f, 2.15359714f, 2.97599503f, -2.04536528f, 0.98544094f, 1.00252528f, 1.80979754f, -5.55278443f, 1.1997656f, 0.97826618f, 2.14619448f}, {5.94100488f, 0.36846762f, -0.35232452f, -1.06380114f, -0.6655753f, 0.20622968f, 1.85709287f, -1.11018731f, 12.39075323f, 1.75643949f, -9.66369542f, -0.23385836f, -0.41069648f, 2.33975816f, -11.43201805f, 1.31426573f}, {0.16468207f, 0.58612448f, 0.50257878f, 0.33138299f, 0.39856635f, 1.48108711f, 0.51620655f, 2.03899516f, -11.34014702f, 3.37334972f, 0.2334073f, -1.2356995f, 1.7295105f, 27.33186369f, -3.69112125f, 0.97788907f}, {-0.98264727f, 0.55883428f, -0.06229558f, 0.09723511f, -10.98249477f, 1.10618409f, -0.94085877f, -8.11950221f, -0.04632915f, -9.03526215f, 1.49420183f, 6.07370521f, 0.96848793f, -0.34637852f, -0.32367054f, 0.65104157f}, {-1.2324215f, -0.76674149f, -0.74769028f, -0.41825039f, -0.0907067f, -0.12566679f, -0.64765927f, -4.09983927f, -4.34295348f, -5.83968752f, -0.42817817f, -1.52693689f, 0.02689256f, -1.23512489f, 0.85075241f, 3.19274409f}, {-2.33218164f, -1.41701358f, 5.49239334f, 0.35031753f, 0.68368939f, -1.74458636f, 2.48757982f, -1.23267089f, 0.86456792f, -1.22463515f, -0.22982384f, -3.3541706f, -5.5797212f, -2.34177637f, -4.91526411f, 15.70633973f}, {-0.83854526f, 0.25908107f, -0.43724934f, -0.95393081f, 0.09755747f, -14.0228069f, -0.04446126f, 6.6849245f, -0.62933216f, 1.40623589f, -1.46521172f, -0.03724256f, 1.70119813f, -0.53209371f, -0.1203664f, -0.14314777f}, {-1.16029739f, -1.12528506f, 0.00371963f, 3.71511285f, -3.60562129f, -0.79701661f, -0.56780294f, -1.28653388f, -0.25421853f, 0.62880068f, 8.4451424f, -0.83359625f, 0.06507094f, 3.15230658f, -0.58656514f, 0.17777596f}}, {{-0.34161111f, -0.91117655f, 0.32170954f, 0.7839955f, -0.652257f, 13.99434243f, -0.30965179f, -2.37371511f, 0.48657369f, 0.15586613f, -0.32935669f, 0.21656532f, 2.21810862f, -0.5089264f, 1.4994189f, 7.91490152f}, {-1.04962511f, -2.84283204f, -0.72078466f, 0.99006328f, 2.21328442f, -2.48800171f, -0.21174553f, 0.67571858f, 8.51310573f, 0.08812055f, 3.19433502f, 2.3604716f, -5.2856707f, -0.71491835f, 1.91070233f, -3.49015894f}, {-3.62886626f, -1.02297026f, 2.16208718f, -6.13658605f, 1.78527816f, -0.75700778f, 1.53906344f, -15.19414682f, -4.54557647f, -0.5402777f, -1.76404367f, -0.49772145f, 0.53407096f, -0.09572905f, 1.73034488f, -15.02670828f}, {-1.02574413f, -0.49989742f, 9.83063625f, 20.65754096f, 0.23906141f, 7.40522013f, -0.50852198f, 3.114005f, -1.44271839f, -0.56056448f, -1.91798641f, 6.96751669f, -1.77000013f, -1.06129082f, -1.73953222f, -0.83355211f}, {-0.71478122f, 0.30242247f, -1.43533729f, -0.3429017f, 1.84527447f, -1.29400957f, -1.9406408f, 0.89567267f, -1.70318562f, -10.12682838f, 1.69988972f, 0.10831003f, -0.58443003f, 0.78207156f, -3.05598006f, -1.80885896f}, {0.53409419f, 0.81561749f, -1.23579501f, -2.37544783f, 11.49347241f, -5.66181435f, -1.68268279f, -0.60162779f, -0.54552309f, 29.9594175f, -0.76457128f, 1.72790495f, -0.81139946f, 0.81411912f, 4.55007101f, 1.3964627f}, {0.31219074f, 2.4278376f, -0.64402174f, -0.99324199f, 0.00136983f, -1.20772856f, -0.60088255f, 1.56658363f, -5.91794724f, 1.02006201f, -19.31258368f, -18.15761142f, -1.55304281f, 0.06451675f, 0.16672545f, 1.47160376f}, {11.40194075f, -1.12705032f, -1.3061329f, 0.02427286f, 1.10315562f, 0.53989235f, 0.77074986f, 4.24061274f, 0.62143043f, 2.65776472f, -3.3402573f, -3.5356731f, 1.45978243f, -3.73982767f, -0.57858289f, 1.02228737f}, {-3.85064935f, -6.0414626f, 2.30379209f, 0.60379207f, 1.40956389f, 0.3851162f, 1.28204616f, -0.67402276f, -0.67244448f, -1.08950881f, 0.65737762f, 0.46889898f, -0.22556663f, -0.93260462f, 0.50692676f, 0.25838253f}, {-2.15415812f, 3.69773914f, -0.24446949f, 1.3142757f, -0.18495519f, 0.88894529f, -0.49665361f, 3.42737659f, -0.1295737f, -0.62231087f, -3.36998094f, -1.23678615f, 3.16680366f, 0.57675481f, 4.99897175f, 0.22762996f}, {-1.66840633f, 1.18446421f, -1.10665929f, -0.94795502f, 2.42918502f, -0.56423076f, -1.21581859f, 4.78136138f, 6.40280714f, 1.20650255f, -3.09666755f, -0.91626985f, 5.76085406f, -2.48909594f, 6.39856073f, 0.09231245f}, {-0.2788928f, -0.90728333f, 1.34031734f, -0.7429304f, -1.98377134f, 0.40289725f, -0.5219858f, 13.56725244f, -1.42176819f, -1.21932412f, -5.17717133f, -3.71593802f, 1.11405986f, 4.06095213f, -2.00552967f, -0.29677221f}, {0.69232562f, 1.65810509f, -0.41027797f, -3.67168593f, 1.81493283f, 2.90717649f, 0.08907009f, 0.53302683f, -0.37173177f, 14.08415133f, 3.13440466f, 0.55386472f, 1.2417146f, 1.67181157f, 0.40759886f, 0.64730025f}, {4.01875027f, -2.50881767f, 5.51985569f, -1.75909374f, 3.21823281f, -2.97472404f, 5.30491459f, 0.02053013f, -5.74297395f, -7.81288877f, 0.42062018f, 1.48362548f, -3.56910843f, -0.58829273f, -0.15936017f, 0.58358178f}, {-7.20747996f, -0.2424499f, -0.06152267f, 0.17671694f, 1.58424025f, -0.38014329f, -0.78981303f, 0.76703951f, -1.59897175f, -0.49595535f, 0.20619055f, 7.15218004f, 0.14754727f, 3.7871364f, 23.45383794f, -4.20221365f}, {1.97658277f, -2.83366801f, -5.32035948f, 1.9809926f, 1.59416131f, 1.0462535f, -1.4237238f, -2.92136802f, -1.32361703f, 1.65972843f, 1.02902964f, -1.40404502f, -0.07509549f, -0.96717153f, -1.440138f, 3.33387392f}}, {{-0.70370511f, -1.82080932f, 0.51769222f, -13.08103017f, -2.89160612f, -2.45238965f, 6.26757838f, 3.99500478f, -2.23520286f}, {2.67988672f, 5.01228902f, -0.23210347f, -2.79524654f, -0.94722842f, 2.96248227f, -0.87604332f, -1.42280815f, 1.59617585f}, {-0.90575514f, 0.11072885f, -0.179737f, -0.65962461f, -0.47219343f, 6.06576276f, 0.34169741f, -0.81190437f, 2.86700054f}, {2.26331873f, -1.59954053f, 1.28724794f, 3.6623862f, 3.82695444f, -0.58873778f, -0.05276127f, -1.05602016f, 0.00894359f}, {1.26427458f, -5.552347f, -1.79598709f, 2.52600245f, 7.1045307f, -1.63238851f, -0.42977475f, 0.15304267f, 0.39957456f}, {1.04593859f, 1.5700643f, 7.69836374f, -3.32597135f, -0.33396815f, -0.62304376f, -7.44195779f, -15.95166094f, 0.17133599f}, {2.90952199f, -1.05107137f, -2.38515788f, 0.08436232f, 0.24157153f, 0.22198589f, 0.76634635f, 6.52612724f, -1.5749443f}, {1.85603451f, 2.13751193f, 0.02260258f, 0.27860661f, -5.57963334f, -1.84312588f, 0.77991084f, 5.38815062f, -0.48317022f}, {-0.18470587f, 5.52391507f, -6.17329508f, 0.25097133f, 2.72498939f, -1.24952957f, 2.58973642f, -1.59020239f, 1.17657621f}, {0.31031521f, 3.14098898f, 0.83529078f, -1.59158478f, 2.77112677f, 7.09782364f, -1.07774927f, 0.29729188f, 1.14352895f}, {1.04170279f, -0.161317f, 2.59369061f, -0.53940781f, 4.06480268f, -0.7549702f, -0.4079372f, 3.57713798f, -26.06404932f}, {1.21818954f, 2.62975738f, 0.27486421f, 0.26573207f, 3.09101746f, -0.00315079f, -2.07237161f, 1.0671971f, 0.04402825f}, {3.13722605f, 0.65642012f, 0.39629623f, -4.4778063f, 6.23231967f, 14.26627115f, -0.37609502f, 1.40884092f, -1.10587026f}, {3.5399101f, 8.24196185f, 0.34344233f, -5.32243194f, 0.6672441f, 0.91815005f, 1.44061952f, -1.65401092f, -0.22496392f}, {-6.21918373f, 1.7706987f, -15.07754539f, -0.3289414f, 0.27098259f, -0.84819164f, -3.03174724f, -3.02221496f, 0.45228662f}, {2.48904619f, 1.30496612f, -0.22028413f, -0.57676816f, 0.53358061f, -10.30788898f, -0.55788832f, -8.46587896f, 5.53474434f}}, {{}, {}, {}, {}, {}, {}, {}, {}, {}}};/*weights_end*/
/*biases_start*/final float[][] biases = {{0f, 0f, 0f, 0f, 0f, 0f, 0f, 0f, 0f, 0f, 0f, 0f, 0f, 0f, 0f}, {1.11459536f, -0.81554844f, -0.35241105f, 0.3430751f, -2.7754451f, -6.56039534f, 0.51234179f, -3.63295765f, 0.58123274f, 0.09856302f, 4.94434137f, 0.61133493f, 7.16995887f, -1.35065358f, -5.22284405f, -3.34678266f}, {-0.29679703f, -1.15515053f, 0.74841682f, -2.98786705f, -29.43317902f, -0.62553556f, -0.39649373f, -0.95486069f, 0.54381759f, 0.75152669f, 1.45989447f, 1.36140142f, 1.83293621f, -5.69165925f, 0.97371515f, 0.56256187f}, {-1.06806262f, -0.26664188f, -0.93706569f, -5.34552567f, 0.99334607f, -3.00067193f, -1.05558445f, -7.16933618f, -0.3137482f}};/*biases_end*/

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
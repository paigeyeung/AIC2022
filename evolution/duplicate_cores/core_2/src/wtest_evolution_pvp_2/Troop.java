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
/*weights_start*/final float[][][] weights = {{{2.74551475f, -11.14593648f, 0.55713968f, 1.33936188f, 0.17025272f, -1.04776361f, 9.05026146f, 2.28563761f, 1.07031387f, -2.55198237f, 1.56008419f, -5.07334761f, 0.53920131f, 0.6560936f, -2.6821478f, 0.44338965f}, {-0.81334283f, 0.8785591f, -1.03820931f, 0.89915159f, 1.46425915f, -4.10895882f, -0.01590586f, 5.43689126f, -0.56330983f, 0.98177168f, 2.34134331f, 1.83730743f, -1.49785605f, 0.59141626f, -0.30472329f, -2.37442119f}, {-2.16512409f, 0.27436209f, 0.89867393f, -21.4173477f, 4.20446435f, -0.04910225f, 2.78880604f, 0.22324852f, -1.85960691f, 0.84834317f, 13.15958429f, -0.42233225f, 0.1401292f, 1.73941543f, -10.68815816f, -2.3811837f}, {-3.89839237f, -0.93232791f, -1.20494946f, -0.4494126f, 2.01228418f, -6.01383692f, 18.56175831f, 5.05704744f, -3.54493598f, -0.3709463f, 2.15466748f, 2.4267702f, 1.30137472f, 0.05937784f, -2.78370333f, -4.00611249f}, {0.6375111f, 0.74381806f, -9.43405173f, 0.3349682f, 32.60075529f, -8.9330718f, 0.84569342f, 1.47721232f, 8.20586134f, 0.02121168f, 0.82596726f, -4.14879648f, -1.61836679f, -5.82029337f, -0.83790236f, -0.93835768f}, {-3.07717485f, 9.08795511f, -4.64272121f, 12.91949155f, 2.93245135f, -2.75611171f, 2.72807107f, 1.77485759f, 1.62717531f, 0.08883066f, -0.82240405f, 0.01355498f, 0.04861631f, 0.4090431f, -3.58504882f, -0.99023694f}, {0.0135636f, 2.14652645f, -4.87104357f, 9.63167457f, 2.62506666f, -8.45139122f, -0.64335722f, 1.31661868f, -0.11085446f, 1.14494347f, 1.21310096f, -0.60221469f, 3.26337941f, -1.4878069f, -1.47486346f, 1.2670702f}, {-2.93637823f, 1.23243955f, -0.51510288f, 0.87474122f, -2.04887282f, -0.30122989f, 2.48798245f, 4.75267113f, -2.4842516f, 0.44683817f, 3.4622538f, 1.95450417f, -2.3648367f, 1.49460769f, 0.36625409f, 1.20110861f}, {1.97385001f, 0.34191124f, -0.41253253f, -4.53431712f, -0.47130647f, 0.56148768f, 1.80057628f, -1.32126073f, 12.60024748f, 1.59622468f, -4.98045489f, -0.17640327f, -1.11087665f, 2.78102746f, -3.67725817f, 1.17758239f}, {0.44043631f, 1.07281143f, 1.11862399f, 0.3943434f, 0.32501405f, 0.47645005f, 1.29261239f, 4.99069871f, -3.62358621f, 1.45877491f, 0.21189621f, -5.39082277f, 3.0455678f, 4.34670544f, -3.3109335f, 1.22548565f}, {-2.17158294f, 0.59611696f, -0.02087675f, 0.61733137f, -4.67677803f, 0.43750424f, -1.16769732f, -1.75341254f, -0.16826605f, -9.92932405f, 1.51712256f, 3.42266056f, 2.16894281f, -0.28526926f, -1.09053487f, 1.83180827f}, {-2.59751044f, -2.18690043f, -0.87693663f, -0.5786773f, -0.10285222f, -0.36219225f, -1.87832114f, -3.23662257f, -9.37539633f, -5.82658173f, -0.76072647f, -1.89906699f, 0.10202563f, -5.21728604f, 1.16711676f, 18.69135958f}, {-6.07384331f, -1.71611962f, 4.94769134f, 0.62379034f, 0.9895663f, -2.41393171f, 4.44415216f, -1.18688138f, 1.55463743f, -0.70252471f, -0.93888798f, -0.96509591f, -8.93221091f, -0.81630855f, -6.83054986f, 11.38642526f}, {-1.11044804f, 0.16294107f, -1.08331575f, -1.29780389f, 0.18709254f, -2.74011845f, -0.08943003f, 4.95147199f, -2.11179583f, 1.26127891f, -1.98359228f, -0.05621083f, 1.31312289f, -0.52354524f, -0.22747248f, -0.13819389f}, {-0.29443356f, -0.58580061f, 0.00622864f, 4.68538302f, -1.2212038f, -1.79471697f, -2.52853175f, -2.51448325f, -0.84172963f, 1.04853206f, 7.13788571f, -0.97068171f, 0.16567595f, 2.30164629f, -0.15881932f, 0.24632657f}}, {{-0.34148863f, -0.51992366f, 0.47212507f, 1.7701816f, -0.69100198f, 14.38014664f, -1.22337296f, -3.31185548f, 1.24643207f, 0.26112848f, -0.13315842f, 0.13959217f, 2.7012973f, -3.97416128f, 1.95662385f, 4.93922209f}, {-1.47576278f, -1.63889087f, -1.17647893f, 2.53165494f, 1.4983679f, -2.28916202f, -0.1914228f, 1.59119936f, 5.61801466f, 0.06639177f, 1.75731772f, 2.62788405f, -7.61199281f, -2.61665413f, 3.01491337f, -5.14758418f}, {-1.628598f, -3.08238706f, 1.27110237f, -13.91962092f, 1.77327856f, -1.12208839f, 1.15450663f, -7.53428783f, -5.58691381f, -0.37144542f, -2.59356879f, -0.89767485f, 0.76950542f, -0.22253977f, 4.97759325f, -8.00086437f}, {-0.76973383f, -1.10306484f, 13.3008996f, 18.64545116f, 0.47865004f, 5.07727293f, -0.29412261f, 1.85311496f, -0.84300523f, -0.51055488f, -3.0567938f, 10.53871514f, -3.491125f, -1.17858242f, -5.11464652f, -1.17734316f}, {-0.21701581f, 0.92052476f, -0.82478523f, -0.27790568f, 2.54082285f, -2.04962137f, -2.07233392f, 0.62109573f, -2.12739808f, -7.4478916f, 1.70741437f, 0.18119117f, -0.69320968f, 0.55081619f, -3.49269864f, -0.7672358f}, {0.633361f, 1.77001058f, -4.60820003f, -7.77596359f, 9.95955639f, -5.33544011f, -0.764118f, -0.72838339f, -0.54396427f, 8.74266545f, -0.55216752f, 5.23929597f, -1.96052637f, 1.1037101f, 2.84802368f, 0.98792547f}, {0.89284987f, 1.76354662f, -0.11015617f, -0.60145252f, 0.00258054f, -0.8001391f, -0.70066949f, 3.81323541f, -2.91550341f, 2.41826125f, -27.18383217f, -6.97932965f, -2.60554315f, 0.04461971f, 0.1888867f, 1.03909644f}, {3.88498583f, -0.92358433f, -2.13298279f, 0.04964834f, 2.25640205f, 1.21629539f, 0.51138199f, 2.65276353f, 2.55252029f, 1.74565848f, -2.53280456f, -4.75833128f, 1.91150797f, -3.43472695f, -0.25255452f, 0.34427991f}, {-1.64282558f, -6.29470295f, 6.51952785f, 0.92010963f, 2.00304147f, 4.17841011f, 0.88029452f, -0.84925818f, -2.40132309f, -0.65998617f, 1.52784249f, 0.33431564f, -0.1244943f, -0.30476758f, 0.70761016f, 0.29896118f}, {-1.31205654f, 4.90754589f, -0.70055188f, 0.55667847f, -0.21502046f, 0.90863385f, -1.22782901f, 1.52819279f, -0.15000711f, -0.4234392f, -2.2403483f, -1.49804509f, 9.86268288f, 2.25595109f, 4.5410965f, 0.18027765f}, {-3.15633776f, 1.32132121f, -2.16332211f, -0.51652185f, 3.45564957f, -0.49272431f, -2.01745241f, 3.96621961f, 4.08359964f, 1.99758662f, -1.20601181f, -0.49613953f, 1.3977438f, -4.53839942f, 4.26913254f, 0.11384016f}, {-0.35329588f, -1.57758522f, 0.87588737f, -1.02737884f, -1.9152883f, 0.86937815f, -0.93787645f, 6.725212f, -2.19862305f, -2.13599202f, -3.01967759f, -2.96908438f, 1.94423732f, 7.87666512f, -3.18401542f, -0.26506622f}, {1.02198687f, 1.20417651f, -0.81808085f, -7.42587397f, 1.22355913f, 3.9723331f, 0.06717875f, 0.57583553f, -0.21935875f, 4.92640171f, 5.34571989f, 1.18318406f, 1.31342306f, 4.80334766f, 0.68135089f, 1.99066084f}, {7.51327846f, -0.99049799f, 3.7393381f, -0.80986849f, 2.72420918f, -0.61285337f, 19.35997594f, 0.13932134f, -1.83667551f, -3.29531667f, 0.43418693f, 4.6771854f, -1.92848756f, -0.58890364f, -0.39425661f, 1.08847641f}, {-4.59847642f, -0.50671721f, -0.18191531f, 0.16478401f, 1.42270764f, -0.93980826f, -1.25122785f, 0.45346145f, -2.31351041f, -1.6575465f, 0.36300467f, 4.38772575f, 0.27030143f, 8.48663269f, 9.39940267f, -7.29452784f}, {1.81996976f, -3.39255365f, -1.97202912f, 0.98094717f, 4.30593933f, 0.88852196f, -1.12552998f, -2.49138154f, -3.48490499f, 1.41303553f, 1.36414814f, -0.79589353f, -0.26307829f, -1.51530761f, -5.02796893f, 2.19166723f}}, {{-0.87926069f, -1.87068626f, 1.25011417f, -32.46899067f, -1.7418946f, -1.85466047f, 3.25778867f, 1.95470615f, -10.57541931f}, {1.04494007f, 2.04874829f, -0.33299882f, -1.12772585f, -1.25160737f, 1.65493748f, -0.63018635f, -1.5917478f, 1.68422206f}, {-1.25722082f, 0.29195297f, -0.3748524f, -1.74003165f, -0.57025529f, 4.94065269f, 0.27214219f, -0.83300339f, 3.01652289f}, {3.18770197f, -3.33204001f, 0.7012129f, 3.05952776f, 10.68372708f, -1.01277119f, -0.20467883f, -1.47720056f, 0.01200405f}, {2.8544507f, -5.10518935f, -2.18891058f, 3.40533229f, 5.6663834f, -4.56280444f, -0.16658877f, 0.11600821f, 2.42388135f}, {4.15831571f, 1.08027316f, 6.33431927f, -7.46312433f, -0.68977724f, -0.41254038f, -5.63340649f, -8.99328586f, 2.58035665f}, {3.97162401f, -3.57092129f, -4.06629822f, 0.07772429f, 0.07331373f, 0.3735127f, 1.05045781f, 2.67880341f, -1.06245549f}, {3.40557419f, 0.79749595f, 0.12286256f, 0.09198168f, -2.3647264f, -1.48846397f, 0.96578987f, 5.65828393f, -1.38834737f}, {-0.46895672f, 10.93210305f, -6.53444493f, 0.31674407f, 1.04905147f, -0.52595595f, 0.97784332f, -1.41608202f, 2.65326513f}, {0.43957475f, 1.98357378f, 0.40920121f, -1.99516113f, 2.48478127f, 9.17411448f, -0.67083282f, 0.2666822f, 0.43929885f}, {0.99306449f, -0.10753946f, 5.38797825f, -2.47725917f, 5.27128739f, -0.82644032f, -1.01331399f, 2.30474374f, -11.95109161f}, {1.37414426f, 4.61415856f, 0.22615884f, 0.26261954f, 6.19516289f, -0.00576697f, -4.29480854f, 1.57307124f, 0.05597149f}, {1.13653883f, 0.38062993f, 0.28877372f, -4.64984348f, 8.81302875f, 9.7089465f, -1.14258199f, 2.70533748f, -0.65433278f}, {0.74992716f, 7.08442573f, 0.52923137f, -4.97373914f, 0.73968335f, 6.61057676f, 3.66749341f, -1.39470169f, -0.65027453f}, {-2.74834723f, 6.53045875f, -14.68196676f, -0.52626212f, 0.14169774f, -1.35117997f, -3.60561741f, -3.35679249f, 0.63676107f}, {3.33776018f, 1.11298394f, -0.24027185f, -0.7558134f, 0.23150671f, -6.49874094f, -0.16927698f, -9.73402023f, 3.06505787f}}, {{}, {}, {}, {}, {}, {}, {}, {}, {}}};/*weights_end*/
/*biases_start*/final float[][] biases = {{0f, 0f, 0f, 0f, 0f, 0f, 0f, 0f, 0f, 0f, 0f, 0f, 0f, 0f, 0f}, {1.02487236f, -0.45230305f, -0.29611839f, 0.26702731f, -5.96805089f, -3.19131536f, 0.28095969f, -1.37936588f, 0.52056788f, 0.13740597f, 4.30492707f, 2.05461465f, 7.42003236f, -1.47188322f, -3.5704308f, -1.54736577f}, {-0.35074001f, -1.11418759f, 0.95845313f, -3.45234609f, -6.91271758f, -1.16104716f, -1.5921275f, -0.84061841f, 0.31786423f, 0.40613241f, 1.72548967f, 1.2238057f, 6.64923554f, -2.38332408f, 1.61922031f, 1.63482243f}, {-2.48526814f, -0.51476653f, -1.01820493f, -3.56977375f, 1.00186589f, -4.62989838f, -1.90763667f, -1.65233502f, -0.10306201f}};/*biases_end*/

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
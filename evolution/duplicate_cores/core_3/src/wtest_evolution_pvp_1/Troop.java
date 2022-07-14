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
/*weights_start*/final float[][][] weights = {{{3.85427596f, -3.78804119f, 0.61624802f, 2.10053539f, 0.31288633f, -1.20970243f, 5.82005801f, 3.20244969f, 1.5297243f, -2.20114417f, 4.12327321f, -4.80772302f, 0.36256221f, 1.9636428f, -1.14295552f, 0.77978021f}, {-1.060754f, 1.05479669f, -2.0984698f, 0.61107464f, 2.12815525f, -3.58882292f, -0.02838889f, 3.25062725f, -0.59188336f, 1.14639649f, 1.8436925f, 2.08513132f, -1.34124183f, 0.79404967f, -0.33116111f, -1.8380776f}, {-1.94043619f, 0.37836898f, 0.86895297f, -15.97568424f, 2.33606744f, -0.19252929f, 3.0290076f, 0.44107559f, -3.21322138f, 0.78228382f, 11.32274576f, -0.21835121f, 0.53132784f, 0.63747083f, -24.60725907f, -1.73283507f}, {-1.4339604f, -4.05112232f, -0.70576322f, -0.55773709f, 1.00734748f, -2.33783978f, 11.85560055f, 3.43700638f, -1.95232686f, -0.5726662f, 2.55181654f, 4.02030247f, 1.76295085f, 0.07406369f, -3.66033734f, -4.16389478f}, {0.7802467f, 2.00107584f, -3.50435022f, 0.69870065f, 48.26458248f, -9.13793251f, 1.02718022f, 1.41466563f, 9.46644184f, 0.01447019f, 0.89935698f, -5.04981082f, -0.92582853f, -8.6190413f, -0.93180344f, -1.31639335f}, {-1.72065342f, 4.87339843f, -3.75642446f, 4.76607936f, 4.03127897f, -5.31585305f, 2.20561015f, 2.83579162f, 2.15686328f, 0.04931665f, -2.12788262f, 0.01188919f, 0.09834282f, 0.41017123f, -1.45655329f, -1.44283768f}, {0.01043502f, 2.92847373f, -3.16030794f, 6.99169759f, 2.34543244f, -5.60844936f, -0.83547471f, 2.4107603f, -0.25105152f, 0.58203822f, 2.69211181f, -0.96228021f, 2.3598585f, -3.35519302f, -2.33701735f, 1.19951542f}, {-2.06745897f, 2.01266065f, -0.42778497f, 0.99402671f, -3.74889997f, -0.18912574f, 0.90817502f, 4.97919931f, -2.89602116f, 0.58575323f, 0.70835164f, 1.55833764f, -1.50604339f, 1.28372207f, 0.42950901f, 1.00640701f}, {1.28208361f, 0.45353093f, -0.38365731f, -12.37780098f, -0.51600239f, 0.88270899f, 1.63200437f, -0.93281632f, 11.45624264f, 2.23810166f, -5.23423851f, -0.12069767f, -0.67634943f, 2.97327341f, -4.10312267f, 1.71664137f}, {0.6367422f, 1.5628119f, 2.48627587f, 0.47957222f, 0.25121302f, 0.90242488f, 0.90111802f, 2.08142058f, -4.5979033f, 0.56827061f, 0.1726674f, -1.76317232f, 3.16146811f, 5.29919748f, -2.2400773f, 1.07076501f}, {-1.44030186f, 1.43276606f, -0.02563833f, 0.49304516f, -3.2735482f, 0.5224397f, -2.05350078f, -1.19120298f, -0.19392786f, -19.36456224f, 3.10512509f, 2.58108382f, 2.0815961f, -0.39995635f, -0.63420252f, 3.7640941f}, {-1.46801088f, -4.25754584f, -0.41761227f, -0.68483057f, -0.03872213f, -0.31053894f, -3.57078216f, -6.02818782f, -5.84126508f, -2.7994306f, -0.54995406f, -3.89412924f, 0.18996942f, -5.87423306f, 0.55985817f, 15.21081769f}, {-5.38314075f, -2.67408383f, 4.42224598f, 0.39288701f, 1.27522714f, -1.34976319f, 1.42022072f, -1.17643184f, 0.90478266f, -0.79813511f, -0.67216707f, -2.01099832f, -13.79842052f, -0.84018803f, -8.39945077f, 8.55008485f}, {-0.96185436f, 0.23795411f, -0.94133707f, -4.74713422f, 0.21861094f, -2.36974002f, -0.19614194f, 1.32491649f, -0.81861654f, 1.06081143f, -1.0824189f, -0.06336476f, 1.88490277f, -1.60676812f, -0.20581842f, -0.13483776f}, {-0.27746019f, -0.36170273f, 0.00535692f, 5.79996402f, -2.04914764f, -1.51647286f, -1.24050986f, -2.08766808f, -0.26402141f, 1.30067663f, 6.06039491f, -0.90470465f, 0.32684408f, 2.94321066f, -0.52673461f, 0.44252784f}}, {{-0.44624962f, -1.17758271f, 0.36040602f, 1.74436581f, -0.69272833f, 9.2877834f, -0.4583464f, -3.4712046f, 0.31009549f, 0.23554485f, -0.12769881f, 0.21298683f, 3.99173011f, -1.28146158f, 2.94623102f, 4.48195272f}, {-1.97772106f, -2.49344464f, -0.63308669f, 2.33547704f, 1.675338f, -1.58935494f, -0.10773274f, 1.1760517f, 7.25230086f, 0.0676378f, 1.68836663f, 4.30689595f, -5.2785182f, -1.09535915f, 4.0888628f, -3.46137685f}, {-1.01034571f, -2.96516808f, 2.25645153f, -8.07740409f, 3.20934867f, -2.46851247f, 1.85027782f, -6.14569725f, -1.97916345f, -0.8788519f, -1.40865531f, -0.71424144f, 1.2535996f, -0.25805491f, 3.63552218f, -16.82957787f}, {-0.80356289f, -1.69533597f, 11.9158065f, 13.1496223f, 1.06923257f, 3.49545178f, -0.40404219f, 3.50361335f, -0.28541624f, -1.23711836f, -5.10946851f, 8.37074044f, -3.70890497f, -0.93037029f, -3.9623816f, -2.35539946f}, {-0.32933291f, 0.50631008f, -1.01982224f, -0.21225382f, 3.39997044f, -2.33738798f, -2.5167663f, 1.0110241f, -1.00988746f, -4.64932631f, 1.35285454f, 0.16867172f, -0.49927847f, 0.74079898f, -5.38506404f, -0.41869518f}, {0.5267504f, 2.08982294f, -1.96726442f, -2.96204779f, 7.30811087f, -3.03382817f, -0.56233439f, -1.10102375f, -0.64333108f, 6.71547176f, -0.35040286f, 4.12886785f, -1.03438388f, 1.29740021f, 4.06634527f, 0.79111453f}, {1.10601862f, 1.61539927f, -0.13573013f, -0.67963205f, 0.00236429f, -0.76455079f, -0.50333291f, 2.11887685f, -2.91153839f, 1.82092425f, -17.61647429f, -9.61717729f, -3.35126024f, 0.06318326f, 0.13604034f, 0.94897541f}, {3.3320813f, -1.20518331f, -4.10496286f, 0.03672076f, 3.40217194f, 2.44827461f, 0.90674778f, 2.88856437f, 3.55968446f, 4.06028039f, -2.56326499f, -5.81674608f, 2.90273676f, -3.65529549f, -0.19966605f, 0.70816629f}, {-4.70892454f, -5.06357325f, 2.82946245f, 0.52340007f, 1.28457107f, 2.28108341f, 0.89925583f, -0.43913465f, -0.88809161f, -0.92954128f, 0.9360426f, 0.2804547f, -0.07657362f, -0.58726417f, 0.45236696f, 0.11009682f}, {-2.15910714f, 3.6086361f, -0.79106517f, 0.7152391f, -0.15673329f, 0.48630479f, -1.67417039f, 2.36598957f, -0.13843686f, -1.17703449f, -1.7435671f, -1.47648332f, 6.41445472f, 1.75661203f, 4.7340144f, 0.30759064f}, {-1.9671936f, 1.4995483f, -1.21311773f, -0.51962168f, 3.14967968f, -1.66300089f, -2.61215755f, 1.21621282f, 11.19986025f, 0.9267073f, -3.06167909f, -1.32088225f, 1.81553039f, -2.1568709f, 5.20399694f, 0.09780058f}, {-0.63436535f, -1.8110842f, 1.80045527f, -0.82706943f, -3.88463424f, 1.29271997f, -1.24526751f, 14.37250044f, -3.94185047f, -2.05289754f, -5.26291065f, -0.86791722f, 3.22331784f, 7.53275462f, -1.39964692f, -0.32380647f}, {0.45087495f, 0.82307358f, -0.73624554f, -4.95692982f, 1.38780495f, 1.18007515f, 0.08909593f, 0.50110258f, -0.25564792f, 7.10303545f, 7.56547839f, 1.00283213f, 0.97664259f, 5.07484888f, 0.35832399f, 3.38731865f}, {5.046096f, -0.99055753f, 4.62587779f, -1.239148f, 1.06779023f, -0.82607949f, 8.65519719f, 0.10675529f, -2.79229307f, -5.19533743f, 0.44875738f, 5.58713284f, -2.62612311f, -0.66641695f, -0.41271858f, 0.5578024f}, {-7.56041674f, -0.76921933f, -0.08661002f, 0.13813542f, 2.52232298f, -2.27842011f, -1.85906483f, 0.663308f, -1.09623273f, -1.20514745f, 0.45913938f, 5.45625776f, 0.39044883f, 3.77201127f, 4.6855118f, -5.26291956f}, {2.04903091f, -4.29401614f, -2.59665818f, 1.68800741f, 2.05226254f, 1.26085359f, -1.12995851f, -2.19596084f, -7.56514156f, 1.06830122f, 1.50735272f, -1.49658335f, -0.51016246f, -0.9686828f, -9.95836597f, 1.88185148f}}, {{-0.20706847f, -1.12384477f, 1.49689771f, -15.60058347f, -1.1359934f, -1.20640512f, 2.73373854f, 0.55190107f, -6.30588652f}, {2.04464594f, 3.67511644f, -0.22667256f, -0.82722203f, -0.66393373f, 2.31131868f, -0.36918862f, -1.32213785f, 1.32198572f}, {-1.14358199f, 0.40069127f, -0.71765747f, -4.24692709f, -0.59515318f, 3.5725603f, 0.23539616f, -0.67260727f, 2.85679179f}, {1.91992106f, -1.74266657f, 0.55083642f, 3.52657658f, 9.3373568f, -1.57458018f, -0.3070808f, -1.65167977f, 0.00828597f}, {2.4405217f, -5.39665804f, -1.71265797f, 2.03023941f, 5.26736753f, -6.09269129f, -0.2163576f, 0.15519047f, 2.59232179f}, {2.90630982f, 1.91701713f, 4.58629439f, -3.20592006f, -0.31151415f, -0.7692875f, -2.87749961f, -10.17337042f, 2.2775281f}, {6.39425733f, -2.04198538f, -4.1457663f, 0.13000841f, 0.10919994f, 0.22145699f, 1.16014128f, 2.4711841f, -2.37250612f}, {2.12950625f, 0.77295162f, 0.10907211f, 0.49056265f, -1.60594295f, -2.4145082f, 0.8343889f, 4.73664355f, -1.33697079f}, {-1.07664189f, 15.86511705f, -4.04168712f, 0.15281801f, 3.56723015f, -0.31375883f, 1.77893331f, -3.24363252f, 2.56823153f}, {0.85751281f, 3.31584604f, 0.56565683f, -1.83488549f, 2.1724578f, 10.82605805f, -1.00699507f, 0.1809258f, 0.47868918f}, {1.33552666f, -0.19023162f, 5.79738057f, -2.04732384f, 5.30727858f, -0.67828598f, -0.44905946f, 1.44126435f, -8.41341801f}, {2.92809233f, 1.47711229f, 0.24696788f, 0.16237171f, 3.65998738f, -0.00801443f, -1.80203673f, 0.95286453f, 0.06599704f}, {1.41720566f, 0.56901744f, 0.26297312f, -2.75000085f, 4.84946201f, 4.53369007f, -1.28833237f, 4.14731264f, -1.09874533f}, {1.68675885f, 6.75393019f, 0.73787708f, -2.54274127f, 0.8233174f, 2.07883409f, 1.17104166f, -1.73281255f, -1.30798496f}, {-3.14166897f, 3.54117806f, -14.75259082f, -1.2574773f, 0.12145554f, -1.40646705f, -4.39206491f, -3.03187755f, 0.5778379f}, {3.46389685f, 0.80028779f, -0.86295f, -0.79051994f, 0.47465293f, -5.89447095f, -0.15591696f, -3.07429826f, 2.02333451f}}, {{}, {}, {}, {}, {}, {}, {}, {}, {}}};/*weights_end*/
/*biases_start*/final float[][] biases = {{0f, 0f, 0f, 0f, 0f, 0f, 0f, 0f, 0f, 0f, 0f, 0f, 0f, 0f, 0f}, {0.81487441f, -0.45141335f, -0.4294656f, 0.31398389f, -5.04103925f, -1.90693772f, 0.24185387f, -1.99004127f, 0.83490664f, 0.52927998f, 8.03164641f, 1.01103716f, 8.80479562f, -2.2958527f, -2.61414208f, -1.3220503f}, {-0.39545092f, -2.12368806f, 0.6444769f, -1.57463908f, -7.20049734f, -0.88735764f, -1.92694905f, -1.70116893f, 0.47469186f, 0.60103295f, 5.08077074f, 1.82910354f, 4.58459415f, -3.79479824f, 2.40626455f, 3.52389981f}, {-0.84220006f, -0.53019662f, -0.4126294f, -4.26074283f, 0.75262882f, -3.98212244f, -2.77875545f, -0.98863701f, -0.20948021f}};/*biases_end*/

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
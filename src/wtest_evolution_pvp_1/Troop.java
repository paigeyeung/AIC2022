package wtest_evolution_pvp_1;

import aic2022.user.*;
import java.util.Arrays;

public class Troop extends AllyUnit {
    Troop(UnitController uc) {
        super(uc);
    }

    // x input -> x hidden -> x hidden -> 9 output
    final int[] LAYER_SIZES = {12, 16, 16, 9};
    // Weights are outgoing weights
/*weights_start*/final float[][][] weights = {{{-1.59630868f, -4.59093319f, 2.37726697f, -4.4613419f, 2.42595666f, -2.82423275f, 4.90284317f, -1.0425093f, 1.64033615f, -0.88926984f, 2.82182569f, -2.57994668f, -3.90414115f, -2.96814329f, -0.78342819f, 2.34692275f}, {3.95230071f, 0.22252747f, 4.26250084f, -4.03740336f, -3.81556848f, 1.3356473f, -4.81408249f, 2.94230168f, -1.88777915f, 4.00960467f, -0.38403845f, 3.41013489f, -1.72945317f, 2.92546763f, -2.9847283f, -2.72078602f}, {3.40280498f, 2.47687669f, -0.13537269f, -4.54464735f, 2.81379905f, -2.9611846f, -3.98864237f, -3.74863987f, 0.89909603f, -3.24371611f, 1.23418571f, 0.3062903f, 1.48031505f, 2.01455454f, -2.50767864f, 1.68232503f}, {4.59859635f, 0.98063433f, 2.72276173f, 0.79294593f, 2.82636004f, 1.51465906f, -3.31265289f, -1.49267825f, 3.65867864f, 4.91102042f, -4.63249852f, -2.79326723f, 2.76749552f, -0.88159328f, 4.38722505f, 4.35457929f}, {-2.35822025f, 4.3869952f, 0.22290411f, -3.28153932f, -4.65663783f, -3.83778495f, -2.30079141f, 4.83330408f, 1.74925665f, -3.27320049f, -0.95590718f, -2.38984482f, -2.23867286f, -4.99878308f, 1.18421116f, -3.85568312f}, {3.59843592f, 3.75498175f, -0.0805703f, -1.64414688f, -1.02680112f, -4.59578224f, -0.78185572f, -2.43819462f, -0.25752855f, 4.7193952f, -0.19167406f, 3.07479435f, -4.72048259f, 0.37377661f, -3.84175294f, 4.32958922f}, {4.97459609f, -1.94506894f, -2.9972193f, -1.81385277f, 3.80096489f, -1.48571589f, -1.86398294f, -4.99790954f, -2.34701508f, 3.99478825f, -4.7092612f, 1.2105726f, -1.42785639f, 2.94679028f, -4.26267572f, -4.44088273f}, {-1.61422887f, -2.73495036f, 3.11292508f, 4.72740478f, 2.99156478f, -0.27811484f, 0.33260786f, -4.83393524f, -2.39020549f, 4.0932655f, 4.50962909f, 0.20943948f, 4.01838249f, -2.51484832f, -4.49873126f, 3.64806856f}, {0.60799982f, 4.3382454f, -3.28157f, -3.79449893f, -2.29692099f, -2.04748054f, 4.36193446f, -1.08186665f, -1.25948335f, -2.01777263f, -3.0041535f, 3.46620341f, -4.2147642f, 0.25686721f, -4.55212249f, -2.22090376f}, {2.76856147f, -4.25595411f, -4.80943254f, 2.41905722f, 3.69184952f, -0.0738336f, 4.85524078f, -4.70423652f, 1.29917773f, -2.87007176f, -0.50320782f, -2.5629568f, -3.1532886f, 3.96338612f, 3.18856552f, -1.45619847f}, {2.83198513f, -4.27207674f, -3.13582481f, 1.13876821f, -2.07821213f, 3.71860025f, -3.31623661f, -3.50945572f, -0.61129534f, 2.71805692f, -3.9048298f, -2.81199029f, -0.89098375f, -1.42543948f, -2.35818429f, -2.79588348f}, {-1.39914588f, -0.30418077f, -3.63109163f, 4.47660331f, 2.43605479f, -3.84556452f, 0.9287919f, -2.60940252f, -4.68899741f, 0.29090284f, 2.98953484f, 2.42821261f, -3.31787843f, 1.82767789f, -4.14255156f, -0.39821237f}}, {{-2.32611012f, 3.37855226f, 4.72483387f, 1.65537105f, 4.8890306f, -2.62215917f, 3.11230784f, 2.41611851f, -0.52210463f, -3.75962019f, -4.22196734f, 3.30769516f, 2.99858147f, 2.98153588f, 2.20024069f, -2.19340014f}, {-4.99765775f, 2.50766055f, -0.16399592f, 2.48181972f, 1.47108784f, 4.46254664f, -3.47534031f, -0.71376402f, 1.06085229f, 3.26517328f, 4.30638274f, 4.75030933f, 3.86653072f, 1.64377975f, -2.26610436f, -0.17629599f}, {0.34406839f, 1.98538648f, 0.30677488f, -2.35526462f, 2.61173759f, -3.2450806f, 2.01326775f, -3.50269503f, -3.24313885f, -4.56702249f, -0.22409787f, 4.0652506f, -4.09020038f, 3.60378847f, -0.4855963f, 0.83396206f}, {-3.11445917f, -1.97503168f, 2.37138094f, -4.11984511f, -3.95731247f, -1.56335048f, 1.88548379f, -0.96296931f, 4.18819928f, -1.67799403f, 4.74484866f, -1.32270688f, 1.74008787f, 0.41559285f, -1.90111759f, 0.47642592f}, {-1.7250619f, -2.76794815f, 3.98867542f, 3.61181319f, 3.38127265f, 3.32940488f, -0.68810983f, -3.23501188f, -0.21885536f, -3.67357926f, 4.93533919f, 1.02260904f, -2.69525549f, 2.58818186f, 1.898f, -1.32186859f}, {0.58794978f, -1.09852657f, 2.4590662f, -3.89194686f, -2.52881595f, -3.93426622f, -4.85553882f, -3.09041915f, -0.31077497f, 1.54394927f, 3.67781336f, -0.57660197f, -4.68757209f, -2.15689244f, 3.20996171f, 1.40623778f}, {-3.0600986f, -4.26102922f, 0.68867345f, -2.03113294f, -3.78057352f, 3.05765154f, 0.37716771f, 0.07668196f, 4.72605658f, -4.49305178f, 3.57100637f, 4.44490642f, -0.29722291f, 0.30137698f, -3.23849894f, 4.90899733f}, {2.60242965f, 0.19286349f, -1.28444874f, -0.82834173f, -3.48409934f, -1.1911154f, 0.8714162f, -0.7054046f, -2.14987426f, 4.32004306f, 2.63375796f, 2.59595212f, 1.03512341f, 0.3973569f, -3.93306659f, -3.13384238f}, {-2.70519f, 2.06092016f, 0.79387409f, 0.44199428f, -4.72008199f, -0.84552211f, -1.80380828f, 3.76084466f, 4.96271044f, 0.93531698f, 0.0500209f, 3.75657418f, -3.65518977f, -2.8140805f, -0.74392165f, -4.81594164f}, {1.5586084f, 2.36647841f, 4.81840522f, 4.00312658f, -2.08294643f, 4.40246105f, -1.94436083f, -3.3027539f, 4.38013729f, 0.17790452f, -0.6819557f, 0.07264696f, 1.95113547f, -4.1727133f, -4.54790811f, -1.27830852f}, {4.45195632f, -3.22869075f, 4.65752749f, 4.75983286f, 4.90936005f, -2.47055111f, -4.00245969f, 2.9027416f, -0.38803001f, -1.06817681f, -1.12360824f, -0.24624578f, 2.54174259f, 3.94706573f, -3.05212914f, -4.03761357f}, {4.07073677f, 4.06282083f, -4.10061677f, 4.14736351f, -3.36370258f, -1.47905164f, 2.41979832f, 1.22536024f, -1.50647719f, 0.75243971f, -3.6734582f, -1.67569468f, -3.88671007f, 0.45640764f, -4.98664035f, -4.87635944f}, {-2.79512246f, 3.53603051f, 0.72279154f, 2.76636285f, -1.85429118f, -1.97283561f, 1.92791911f, 3.9491377f, 4.46471406f, 3.71135499f, -3.5453826f, 1.29988004f, -1.00176388f, -1.57298125f, -4.10211773f, -3.92592551f}, {-1.28617678f, 4.6733623f, 4.08990106f, 2.02135545f, -4.16870899f, -4.42593209f, -4.58646715f, 2.33484607f, -1.63273411f, -3.93273667f, 4.40787482f, 2.10680158f, -3.50069303f, -1.01377156f, 1.60161191f, -3.40198761f}, {3.69701847f, -4.41112346f, -0.34110894f, -4.05056784f, -2.56347021f, 4.83384531f, 2.67139191f, -1.7965682f, -3.46149945f, -2.94566972f, 3.82823108f, 2.64525623f, -1.23290443f, -4.30548967f, 1.16631284f, -2.56454434f}, {4.04345525f, 2.15703861f, 0.6946108f, -4.9414175f, 0.08452338f, -4.36587524f, -4.68659002f, -2.10548105f, -3.14832016f, 2.3405469f, -3.88258966f, -0.10433526f, -4.64890624f, 4.16601708f, 4.44635144f, 1.9994547f}}, {{3.55509654f, -1.38479807f, 2.57476698f, 4.07437368f, -4.74277959f, -0.91907196f, 1.94396943f, 3.31800386f, -3.44132416f}, {3.45333643f, -0.59119809f, 2.03162532f, -0.08093515f, 0.85311f, 1.17721941f, 2.26083627f, -1.01942659f, -3.96180889f}, {0.48519812f, 3.74594759f, 3.9631842f, -3.19067532f, 2.72860494f, -3.0945012f, -0.28592586f, -1.55202383f, 4.02272638f}, {-2.05379142f, -1.04458282f, 3.07836639f, -2.58165325f, -0.20266729f, 4.06918401f, 1.01639371f, 4.77822514f, -4.91147151f}, {-4.68287246f, 0.3200907f, 3.05589002f, -0.16951772f, -0.58486184f, -4.4886342f, 2.29427236f, -0.86288433f, 1.59887821f}, {1.60168021f, 2.85814603f, -4.67496251f, -1.10147452f, -2.82757838f, 2.84685533f, -3.66281453f, 3.09353906f, -4.92477769f}, {1.28334156f, 2.73265207f, 0.11577397f, -0.51029776f, -4.04590003f, 2.75912325f, 3.37314032f, -2.64664573f, 4.63267713f}, {-3.79328369f, 4.18042148f, -3.04234447f, -1.1797072f, 3.52454203f, -4.76657781f, 4.31567219f, 1.47056438f, -0.89213238f}, {0.17494963f, -0.76777152f, 2.16306603f, -2.38444174f, 4.40984191f, 3.1626331f, -0.7535103f, 0.99140551f, -0.57890012f}, {-4.63215611f, 4.14969862f, -4.53090534f, -0.91016038f, 2.86805049f, -0.29515596f, -2.26137237f, -1.21433151f, -1.75197378f}, {0.90168426f, -3.34723106f, -1.73985462f, -2.69149573f, 1.08874826f, -1.3997928f, -3.02917628f, 1.39647239f, 2.32168875f}, {1.3075214f, -1.76565936f, -0.88096764f, 2.05912577f, -4.88269229f, 0.64926748f, -2.50276509f, 4.92748961f, -2.61030445f}, {-0.36973782f, 4.86031444f, 0.53565675f, -2.38185305f, 1.91934695f, 4.11750264f, -2.35456515f, -3.02326072f, 1.50361634f}, {1.18745334f, 0.39340924f, 0.80863989f, 2.06789306f, 2.4803588f, 4.91401164f, -2.04318109f, 4.14176829f, 2.35061099f}, {1.15776732f, -3.36881117f, 2.80624496f, -1.13819812f, 0.78000028f, -1.85325279f, -4.45589671f, -3.83572297f, -2.22320029f}, {-3.16272894f, -0.91400506f, -3.59844525f, 4.54208966f, 4.09752649f, 1.12346565f, -3.4498564f, -3.66170858f, -0.3100961f}}, {{}, {}, {}, {}, {}, {}, {}, {}, {}}};/*weights_end*/
/*biases_start*/final float[][] biases = {{0f, 0f, 0f, 0f, 0f, 0f, 0f, 0f, 0f, 0f, 0f, 0f}, {2.70585147f, 4.08267258f, -0.89177348f, 4.06082463f, -4.44057495f, -2.22634078f, -4.7395006f, 1.54300706f, 1.80901891f, 2.35922049f, 2.40449583f, -3.31202717f, 1.59347361f, 2.76556508f, 1.38428121f, -2.90695231f}, {-0.30678912f, 0.11666102f, 2.59882913f, -4.51940351f, 4.4801411f, -4.58431727f, 0.57539068f, 1.18691957f, -3.68747532f, 2.48476252f, 0.69674483f, -2.17620915f, -1.08881262f, 1.38101452f, -0.60442967f, -0.84834087f}, {2.39961041f, -3.45113274f, 1.84383378f, 3.43925118f, -1.61705393f, -1.85589518f, -3.56777529f, 3.04845692f, -1.26302493f}};/*biases_end*/

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
            float[] inputData = getInputData(nearestEnemyOrNeutral);
            if(loggingOn) uc.println("inputData " + Arrays.toString(inputData) + " (" + uc.getEnergyUsed() + " energy)");
            float[] outputs = forwardPropagate(inputData);
            if(loggingOn) uc.println("outputs " + Arrays.toString(outputs) + " (" + uc.getEnergyUsed() + " energy)");
            Direction outputDirection = getDirectionFromOutputs(outputs);
            if(loggingOn) uc.println("outputDirection " + outputDirection + " (" + uc.getEnergyUsed() + " energy)");
            tryMove(outputDirection);
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

        return new float[]{
                selfHealth, allyBaseDistance,
                allyBaseDirectionX, allyBaseDirectionY,
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
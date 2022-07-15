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
/*weights_start*/final float[][][] weights = {{{3.44993129f, -21.88886784f, 0.32966721f, 1.8445585f, 0.38315644f, -1.43351933f, 1.78668836f, 0.93295084f, 0.93959788f, -4.74800438f, 1.08812379f, -3.35987181f, 0.31610896f, 2.93295832f, -1.88973825f, 0.41133642f}, {-1.37063939f, 0.31281884f, -0.57991209f, 0.32604151f, 3.80537654f, -6.57348347f, -0.01279789f, 4.87972692f, -1.40293534f, 2.76395505f, 3.35353031f, 2.23839915f, -0.95795242f, 0.82010898f, -0.19044523f, -2.1130312f}, {-1.18607571f, 0.22925863f, 0.75407965f, -17.54141454f, 6.60911259f, -0.04761138f, 3.24205998f, 0.32104788f, -1.27582407f, 0.43966505f, 10.01477679f, -0.72563778f, 0.74883876f, 0.19601939f, -18.29748596f, -3.20390391f}, {-2.09448269f, -1.78647472f, -0.88140455f, -0.47472965f, 0.72246086f, -5.4831468f, 16.9724138f, 1.92436198f, -0.85469197f, -0.28710738f, 0.24734226f, 4.65329106f, 1.16947554f, 0.12373791f, -1.2772963f, -5.49550358f}, {0.97970873f, 3.6810836f, -3.43368555f, 0.23809066f, 52.16003441f, -3.96282525f, 0.60791946f, 0.46775556f, 8.52254968f, 0.03870495f, 1.03002915f, -4.41041979f, -0.95460296f, -5.95958692f, -0.18321068f, -1.54511269f}, {-2.32077172f, 10.79765649f, -2.52435088f, 3.11854243f, 0.24208049f, -1.98254589f, 2.86250298f, 1.19334345f, 0.87707394f, 0.04844605f, -1.6856973f, 0.0171645f, 0.05172343f, 0.26015972f, -1.89016704f, -0.71131258f}, {0.06416064f, 2.64353907f, -2.46048623f, 5.39938295f, 1.53994033f, -1.90153774f, -0.49369801f, 0.65136561f, -0.06003328f, 0.58652694f, 2.70853687f, -0.49642929f, 1.38900352f, -1.79719964f, -2.51155135f, 2.18799064f}, {-1.848431f, 1.77471179f, -0.14204915f, 1.87890561f, -1.79500179f, -0.31732833f, 2.7509797f, 3.81637731f, -3.04329679f, 1.05139714f, 0.90109052f, 1.93889883f, -4.66106156f, 2.59717212f, 0.96006301f, 2.5389189f}, {3.87760756f, 0.37220286f, -0.2572514f, -1.4549501f, -1.1247435f, 0.32203959f, 2.11352336f, -0.81014686f, 14.51695763f, 1.85636972f, -7.18253492f, -0.20806705f, -0.5006781f, 2.78838467f, -9.2009262f, 1.36741731f}, {0.11809486f, 0.72354944f, 0.66438656f, 0.24780861f, 0.39924291f, 1.39644243f, 0.47973769f, 2.241123f, -9.63454882f, 3.41825861f, 0.21684227f, -1.21633968f, 2.13473322f, 27.56119877f, -3.80290355f, 0.86435739f}, {-1.36915958f, 0.91372012f, -0.04417311f, 0.10625407f, -6.8019244f, 0.90022835f, -1.01817782f, -9.39793442f, -0.03679168f, -9.45895227f, 1.93023914f, 5.30698206f, 1.10739031f, -0.33188612f, -0.63741052f, 0.8613395f}, {-1.07790387f, -0.84574296f, -0.54052441f, -0.56078252f, -0.06156349f, -0.09298365f, -0.50379683f, -5.26754115f, -6.52728056f, -3.89232295f, -0.47489744f, -0.97709967f, 0.03274793f, -1.40878518f, 1.06941048f, 2.16203049f}, {-2.47177397f, -1.64531262f, 4.50685509f, 0.24988592f, 0.74400486f, -1.74760268f, 2.41997238f, -1.3001145f, 0.77546022f, -1.58118289f, -0.24509783f, -2.50545715f, -6.67841979f, -1.36031429f, -3.95947397f, 24.56769863f}, {-0.49423869f, 0.23648153f, -0.34874498f, -1.14933605f, 0.17300661f, -8.32769247f, -0.04572782f, 5.42388724f, -0.83968757f, 0.80360377f, -1.5594857f, -0.03627076f, 1.33616917f, -0.73699147f, -0.14214532f, -0.08653393f}, {-1.07036724f, -1.16935965f, 0.00345099f, 6.94276903f, -2.89310141f, -0.86924492f, -0.40185636f, -1.44964484f, -0.39690312f, 0.6614553f, 6.96568891f, -0.49290822f, 0.07623256f, 2.21954464f, -0.77464148f, 0.16900636f}}, {{-0.3468942f, -0.69665877f, 0.34650397f, 1.53897292f, -0.69697288f, 10.87068059f, -0.39313298f, -1.64761737f, 0.61483186f, 0.12936725f, -0.2965572f, 0.20092363f, 1.63269403f, -0.62011045f, 1.60296607f, 9.0696208f}, {-1.15823851f, -2.20075292f, -0.64173604f, 1.06492312f, 1.47269058f, -1.92561365f, -0.21932582f, 1.0449295f, 12.4178717f, 0.08049952f, 3.00068039f, 2.07725211f, -6.30679032f, -0.58054866f, 3.71835641f, -4.03644709f}, {-2.88135251f, -1.04032631f, 2.23423759f, -5.01442589f, 1.25420246f, -0.80355292f, 1.78177142f, -9.21145956f, -5.79803919f, -0.52371724f, -2.2124039f, -0.65691057f, 0.46283128f, -0.08184695f, 1.63155211f, -9.75285122f}, {-0.70866304f, -0.6114643f, 11.00220253f, 20.78392899f, 0.36472138f, 10.50347453f, -0.43644942f, 3.65292729f, -0.94824365f, -0.69648106f, -1.7099085f, 5.91137993f, -1.40926543f, -2.29866859f, -1.65160185f, -1.13629637f}, {-0.52537372f, 0.382699f, -1.64130813f, -0.30258508f, 1.85473991f, -1.5444895f, -1.73242704f, 0.63214689f, -1.25538272f, -8.7301012f, 1.41435421f, 0.14419624f, -0.84791692f, 0.86796449f, -3.56441319f, -1.19085964f}, {0.55524293f, 0.91865492f, -1.73334585f, -2.01393983f, 13.70346882f, -4.99703727f, -1.73895786f, -0.85853191f, -0.75514492f, 24.83801885f, -0.97652493f, 1.37669573f, -1.50300283f, 0.73686379f, 3.30565741f, 1.37308478f}, {0.37910054f, 2.27537412f, -0.64660753f, -0.70980578f, 0.00086058f, -1.25089747f, -0.6516365f, 1.7440203f, -5.73917854f, 1.31095757f, -23.35987933f, -11.31082782f, -2.22337033f, 0.06930956f, 0.17226167f, 1.22794694f}, {12.2894068f, -1.27545036f, -0.91263223f, 0.01980896f, 1.01202877f, 0.57825038f, 0.68730888f, 5.04726216f, 0.6797936f, 2.46613287f, -2.76328267f, -3.94125919f, 1.07467494f, -2.61692784f, -0.41070007f, 0.85617978f}, {-2.41574555f, -6.33457249f, 2.03562233f, 0.68363519f, 1.17384607f, 0.43738315f, 1.53518362f, -0.62425643f, -0.59910566f, -1.2846907f, 0.7173879f, 0.43689151f, -0.26701019f, -0.8918876f, 0.49616313f, 0.30880331f}, {-2.41648296f, 4.89254143f, -0.3179732f, 1.80495374f, -0.21196953f, 1.09709968f, -0.43593463f, 2.80989301f, -0.16397554f, -0.53590599f, -2.44902881f, -1.71579754f, 2.67838631f, 0.66685485f, 5.16090974f, 0.22128217f}, {-1.90048734f, 0.98817908f, -1.12453227f, -1.17470535f, 2.84368805f, -0.65622983f, -1.63429429f, 4.66275064f, 7.12430385f, 0.961403f, -2.85978842f, -0.67889471f, 4.01125081f, -3.3295433f, 4.47213532f, 0.12309249f}, {-0.27370598f, -1.00935805f, 1.08226691f, -0.70220146f, -1.81516559f, 0.40520172f, -0.48184262f, 13.84973991f, -1.50462891f, -1.43057698f, -5.921841f, -5.58825106f, 1.35947086f, 4.12947375f, -1.92195347f, -0.33835507f}, {0.48386699f, 1.43318993f, -0.30065134f, -3.15224365f, 2.44096501f, 2.2184999f, 0.16491116f, 0.29067075f, -0.36783838f, 12.52842467f, 2.77000604f, 0.55976674f, 1.37614174f, 1.80292151f, 0.24221635f, 0.79966029f}, {4.19126721f, -2.31158214f, 5.81325291f, -1.50186171f, 1.72766795f, -1.82188526f, 5.23604335f, 0.01622754f, -6.21040284f, -9.73236565f, 0.54392277f, 3.04318653f, -3.75641783f, -0.45723251f, -0.1652826f, 0.47710352f}, {-7.12739995f, -0.24324203f, -0.05310272f, 0.22974721f, 1.98739995f, -0.60884725f, -0.80905863f, 0.68826619f, -0.9280534f, -0.73112395f, 0.17536386f, 8.86678136f, 0.10144495f, 3.92344495f, 15.99176582f, -3.02816573f}, {1.99713823f, -2.51404556f, -7.49617832f, 1.98810005f, 1.91348373f, 0.94419579f, -1.06526521f, -2.89286128f, -1.22396204f, 1.57025816f, 1.40188446f, -1.73789913f, -0.08550777f, -0.66150737f, -1.71020224f, 3.83960039f}}, {{-0.47737713f, -1.86573346f, 0.7464457f, -14.39375893f, -1.56013082f, -1.57459607f, 6.30978083f, 5.06582136f, -2.16112871f}, {3.29522911f, 5.05475466f, -0.21276171f, -2.13602802f, -0.78580724f, 2.82629339f, -0.64649966f, -1.17544233f, 1.29056284f}, {-0.49731269f, 0.11970218f, -0.18451997f, -1.012001f, -0.39643871f, 5.65340648f, 0.27842245f, -0.75411862f, 1.93241852f}, {2.71999768f, -1.85928187f, 1.45085157f, 2.80862101f, 5.0355664f, -0.35485428f, -0.05210935f, -1.40631363f, 0.00952277f}, {1.05237911f, -6.89539575f, -1.19915864f, 2.5343391f, 7.87014286f, -1.75657177f, -0.50385254f, 0.12488135f, 0.41340782f}, {0.98669726f, 1.49654894f, 8.44455092f, -3.75193078f, -0.39540369f, -0.6277065f, -9.59242371f, -14.39663861f, 0.29930555f}, {1.89599966f, -0.6596191f, -2.45292122f, 0.13547068f, 0.16990227f, 0.21800424f, 0.65702338f, 5.39998261f, -1.64019323f}, {1.54143374f, 2.36941959f, 0.02965779f, 0.34553971f, -4.24289541f, -1.19753477f, 0.9889309f, 4.73496305f, -0.5728998f}, {-0.15004032f, 6.60876261f, -5.26145616f, 0.31258383f, 2.21765249f, -2.07272106f, 2.88283031f, -1.47634422f, 1.38770099f}, {0.44657319f, 2.21762586f, 1.50683635f, -1.64804354f, 2.55572578f, 11.11502133f, -1.71825346f, 0.28114287f, 0.78381914f}, {1.36206879f, -0.13361676f, 2.89053032f, -0.79748918f, 3.89954029f, -0.87190095f, -0.391943f, 3.07038952f, -34.14014253f}, {1.7413746f, 3.18432383f, 0.35745053f, 0.294702f, 4.73027849f, -0.00253526f, -2.52592611f, 1.24721794f, 0.02784453f}, {2.79923904f, 0.74897467f, 0.32049459f, -6.8938637f, 5.92268056f, 9.80211125f, -0.4435929f, 1.49942507f, -1.35046653f}, {2.47871874f, 6.19266998f, 0.38272758f, -4.04425427f, 0.52899286f, 0.72354966f, 1.43495925f, -1.26906313f, -0.24925652f}, {-3.74065239f, 1.78518693f, -13.03210294f, -0.23802929f, 0.22796167f, -0.90020334f, -3.31448627f, -4.41318511f, 0.68245297f}, {2.43559301f, 1.1534489f, -0.25399805f, -0.41455393f, 0.62752812f, -10.05183634f, -0.35168174f, -13.80692553f, 3.73369317f}}, {{}, {}, {}, {}, {}, {}, {}, {}, {}}};/*weights_end*/
/*biases_start*/final float[][] biases = {{0f, 0f, 0f, 0f, 0f, 0f, 0f, 0f, 0f, 0f, 0f, 0f, 0f, 0f, 0f}, {1.14720314f, -0.78400922f, -0.31887281f, 0.40720791f, -2.55440751f, -13.89702318f, 0.4920678f, -3.86282255f, 0.41180538f, 0.16842461f, 3.97088489f, 0.55889277f, 10.71752838f, -1.42892686f, -4.7677516f, -3.6200928f}, {-0.27808509f, -1.13435458f, 0.50290103f, -2.39309169f, -31.84248627f, -0.47695802f, -0.44078054f, -1.1964441f, 0.50252639f, 0.57817065f, 1.47560406f, 1.52319037f, 2.65341888f, -5.84236122f, 1.03478192f, 0.48111797f}, {-1.67937888f, -0.39248319f, -0.92685607f, -5.18801251f, 0.87569569f, -2.17205583f, -1.20423773f, -4.39828063f, -0.22099468f}};/*biases_end*/

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
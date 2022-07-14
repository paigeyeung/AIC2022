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
/*weights_start*/final float[][][] weights = {{{3.1963085f, -5.9073434f, 0.58178417f, 1.15272922f, 0.14485607f, -1.42253807f, 6.75799886f, 2.10076599f, 1.94317693f, -3.60460337f, 2.28562286f, -2.86531672f, 0.31701788f, 0.94682005f, -1.83466134f, 0.47658142f}, {-1.50235752f, 0.7216213f, -1.4535648f, 0.61227794f, 3.43481378f, -3.13543928f, -0.01644104f, 4.97060948f, -0.49347861f, 1.38872526f, 2.66830773f, 1.23263492f, -1.63600254f, 0.98850792f, -0.39157921f, -1.65514638f}, {-2.50392868f, 0.18233009f, 1.49871739f, -12.54817914f, 2.8704235f, -0.10155761f, 2.58031523f, 0.38692625f, -2.55382585f, 0.8318436f, 13.69362988f, -0.17906198f, 0.17107357f, 0.41624124f, -8.94181968f, -0.95920876f}, {-3.39673225f, -2.43054929f, -1.70337347f, -0.46374738f, 0.8668417f, -11.71539862f, 7.45744357f, 3.29436801f, -3.00158676f, -0.20375091f, 1.60502835f, 3.39875152f, 1.03891564f, 0.04858572f, -2.32979545f, -4.22974086f}, {0.47687546f, 2.2053877f, -5.96685131f, 0.39055946f, 40.74535185f, -5.46114412f, 1.05347219f, 1.04952284f, 16.74278896f, 0.05081197f, 0.58152903f, -2.55493152f, -0.6830162f, -9.11654461f, -0.94526272f, -0.87846572f}, {-1.25096842f, 10.37643507f, -3.27153054f, 8.52555508f, 1.66525292f, -3.88452637f, 2.92409786f, 1.45171518f, 2.39974755f, 0.10505748f, -2.27035202f, 0.02122315f, 0.06273412f, 0.30188782f, -2.07123217f, -1.28286783f}, {0.02597485f, 3.82623604f, -3.1789583f, 4.76430728f, 3.25526298f, -5.51937795f, -0.48609409f, 0.82895868f, -0.13903963f, 0.38652682f, 1.33249023f, -1.13392472f, 4.65936416f, -2.21796402f, -2.53831734f, 1.29027904f}, {-2.9628907f, 1.98111792f, -0.64028105f, 1.28567802f, -2.70484063f, -0.42395184f, 2.62697219f, 6.98260644f, -2.30842458f, 1.63595853f, 2.94022618f, 1.5741374f, -1.7394402f, 1.12869278f, 0.91776316f, 1.36341888f}, {2.74761839f, 0.39584033f, -0.56944303f, -5.59705533f, -0.65747633f, 0.69552463f, 1.68704339f, -2.37913687f, 12.64670609f, 1.41792888f, -14.14459961f, -0.24319013f, -1.16570912f, 1.8122961f, -3.66681223f, 1.52769975f}, {0.4520356f, 0.79322728f, 1.09239373f, 0.44019918f, 0.35433484f, 1.58753727f, 1.57742947f, 3.80370418f, -5.50831034f, 1.33290815f, 0.24586871f, -2.5499975f, 3.81172276f, 7.97381457f, -2.50754877f, 0.97874116f}, {-2.24544761f, 1.89966886f, -0.02741834f, 0.31279015f, -4.05086158f, 1.10003904f, -2.32313202f, -1.54011634f, -0.18953975f, -12.72209995f, 1.22091207f, 3.80561191f, 1.33846333f, -0.57687198f, -1.02583178f, 1.55014947f}, {-1.04812786f, -1.79944246f, -1.15351305f, -0.68831573f, -0.07681818f, -0.2119661f, -2.31304064f, -4.86680353f, -5.95026961f, -5.65825576f, -0.49211454f, -2.87887974f, 0.14758539f, -4.32357859f, 0.45189808f, 7.06875648f}, {-4.98768861f, -1.99675631f, 7.47259058f, 0.49056f, 1.49947438f, -1.62776192f, 2.11754526f, -1.08041847f, 0.87689959f, -1.2090664f, -0.8935869f, -2.56558991f, -8.26739425f, -0.62911069f, -4.5610683f, 12.40927747f}, {-1.18753073f, 0.22676866f, -0.74342665f, -2.12708442f, 0.15426231f, -4.53972761f, -0.0441744f, 2.77686463f, -1.12142783f, 2.04517892f, -1.54352949f, -0.04424016f, 1.07412512f, -0.950433f, -0.12802371f, -0.10373316f}, {-0.80827113f, -0.98463214f, 0.00439532f, 4.83749718f, -1.52045945f, -1.2507058f, -1.52266701f, -2.10404051f, -0.28208704f, 1.00117941f, 5.3984231f, -0.78017858f, 0.22027917f, 3.29088651f, -0.14356817f, 0.25117387f}}, {{-0.54582744f, -1.02722844f, 0.41399226f, 1.28801028f, -0.99115598f, 19.33340122f, -0.85697308f, -2.31609911f, 0.67553068f, 0.24965377f, -0.12155055f, 0.1368612f, 2.3092852f, -2.6963972f, 3.87238221f, 6.68808579f}, {-1.16714506f, -2.04330234f, -0.51706059f, 1.15927274f, 2.26244558f, -3.14206388f, -0.16614357f, 1.31690947f, 7.43620381f, 0.09095312f, 2.54295055f, 2.19154803f, -6.16554521f, -2.20291282f, 2.94021279f, -2.44233092f}, {-2.60528812f, -2.71396779f, 1.82764111f, -8.22513921f, 3.74351795f, -1.62277663f, 1.11562573f, -6.65165447f, -4.46958444f, -0.46643664f, -2.00353257f, -0.74323342f, 0.64051158f, -0.19731082f, 1.23926633f, -9.47078593f}, {-0.5273596f, -0.93373958f, 10.0394287f, 16.96679103f, 0.77932975f, 5.44567078f, -0.54015373f, 0.77115755f, -0.84467411f, -0.88271397f, -2.54803256f, 13.55667713f, -2.51495141f, -2.2873933f, -3.91135286f, -1.71532439f}, {-0.84194186f, 0.84876322f, -1.18373893f, -0.14863619f, 3.27960961f, -3.1918157f, -1.6941756f, 0.65914365f, -2.13909838f, -10.97912772f, 2.12020986f, 0.11994499f, -0.70666094f, 2.0461936f, -5.89055956f, -0.62268842f}, {0.47471157f, 1.95761222f, -2.62780726f, -7.05509634f, 6.47473742f, -5.35378163f, -1.18224993f, -0.77374024f, -0.79302242f, 3.65702896f, -0.70574928f, 2.46315513f, -1.55576917f, 1.7422061f, 2.81630772f, 1.06086252f}, {0.95050715f, 2.40356848f, -0.27089847f, -0.36666753f, 0.00318806f, -1.98072711f, -0.84033222f, 3.54922352f, -6.42812119f, 2.24695354f, -10.22596512f, -13.69655679f, -5.37563702f, 0.05417695f, 0.22626243f, 1.23647547f}, {5.42338336f, -1.08311457f, -3.04644931f, 0.02709887f, 2.63591661f, 1.26018456f, 0.75718631f, 3.66219709f, 1.87123163f, 2.56901239f, -3.42996512f, -6.44333764f, 1.75383468f, -6.00344334f, -0.64848668f, 0.84203395f}, {-3.5124645f, -7.82987087f, 5.7093776f, 0.73827758f, 1.42625488f, 1.34012698f, 0.85740796f, -0.60792817f, -0.6192119f, -1.42755258f, 0.96141903f, 0.54381938f, -0.30886459f, -0.87524722f, 0.61383948f, 0.31398019f}, {-2.61571828f, 8.38231438f, -0.54062262f, 1.27744842f, -0.13427924f, 0.45505085f, -1.92957077f, 2.33578414f, -0.10190261f, -0.78024921f, -2.52859549f, -2.98880793f, 10.69083701f, 2.405233f, 9.62165282f, 0.34282304f}, {-4.21280592f, 1.99749902f, -2.5039147f, -0.2791703f, 1.75393765f, -0.6925092f, -2.42753563f, 3.98086556f, 8.94549155f, 1.33165284f, -1.53296771f, -1.0614116f, 1.93508665f, -2.83639644f, 6.85241952f, 0.14387723f}, {-0.23710706f, -1.40018878f, 1.79160157f, -1.02885019f, -4.3313894f, 1.58977637f, -1.03825064f, 5.72426038f, -2.26462998f, -1.516403f, -3.32664402f, -1.24621771f, 1.62618707f, 6.63947299f, -2.00551739f, -0.28186266f}, {0.60777702f, 1.5548635f, -0.69359419f, -3.34587962f, 3.16975699f, 2.39223347f, 0.11584507f, 0.9784778f, -0.31998317f, 12.59873599f, 6.0291026f, 1.67390086f, 1.54556329f, 2.99056627f, 0.11446783f, 2.36108148f}, {5.34343878f, -1.62178627f, 3.85174954f, -2.14902262f, 1.61877663f, -0.67189234f, 16.54410043f, 0.10461799f, -2.42277671f, -2.36722518f, 0.38681548f, 5.85104218f, -2.32210584f, -0.40404139f, -0.45700399f, 0.5874743f}, {-8.39999894f, -0.41751419f, -0.09201236f, 0.18272171f, 1.69050672f, -0.97414658f, -1.10877935f, 0.58658544f, -1.31673891f, -1.22494423f, 0.83045461f, 4.3326271f, 0.36239809f, 3.52375376f, 15.17173881f, -7.25829906f}, {1.25172548f, -2.43641545f, -2.52106887f, 0.85766243f, 2.87336578f, 1.38737433f, -2.73392819f, -1.82247254f, -2.92392961f, 1.02038409f, 3.42178469f, -0.68109334f, -0.23582758f, -0.71513409f, -5.94893654f, 2.15642885f}}, {{-0.52327404f, -2.20239f, 1.28055072f, -30.61596282f, -2.47447909f, -1.51489556f, 5.54057263f, 4.15952657f, -4.05395074f}, {1.60429197f, 2.6285759f, -0.35210435f, -1.17222641f, -2.3924965f, 1.83531629f, -0.45876089f, -3.5655599f, 1.40077492f}, {-1.27909053f, 0.59038752f, -0.23615016f, -1.62439097f, -0.65328535f, 2.91232816f, 0.2700537f, -0.66469731f, 1.89217035f}, {1.97679166f, -1.40473477f, 0.8537893f, 3.1675319f, 10.48998322f, -1.01324226f, -0.37699473f, -1.87790246f, 0.01043843f}, {1.70190282f, -5.32538105f, -1.17955936f, 4.60315556f, 3.66703873f, -3.49433195f, -0.23980124f, 0.1429903f, 2.8187307f}, {1.11814126f, 1.49886707f, 3.44334961f, -2.18564267f, -0.44018983f, -0.72765668f, -2.90507536f, -7.10196316f, 1.60232925f}, {3.83949324f, -1.81579505f, -5.03933104f, 0.18441065f, 0.0594983f, 0.43907403f, 1.43539154f, 2.24430383f, -1.56141322f}, {1.47155469f, 1.81047101f, 0.06015058f, 0.22627993f, -4.40703614f, -0.76672354f, 0.70292728f, 6.03432831f, -0.91459714f}, {-0.59709387f, 11.36439922f, -6.65417898f, 0.22797293f, 1.7981248f, -0.61340402f, 2.3903926f, -2.19849402f, 1.59283214f}, {1.34266038f, 4.0440938f, 0.68717102f, -1.72871989f, 2.26122573f, 10.507927f, -1.2530405f, 0.42543901f, 0.46323618f}, {1.14184324f, -0.15508919f, 4.69245802f, -0.92516013f, 5.66417898f, -0.93060641f, -0.48358209f, 2.51764454f, -8.34027896f}, {2.42527171f, 5.11949716f, 0.49376415f, 0.13904067f, 2.68770013f, -0.00911725f, -2.649902f, 2.2520039f, 0.05461333f}, {1.57069102f, 0.44709113f, 0.494926f, -4.5128064f, 9.03389397f, 6.2415551f, -1.11318754f, 1.44316406f, -0.78763632f}, {1.51519403f, 6.23722164f, 0.7431204f, -3.15827124f, 0.64571375f, 2.68414587f, 1.5968657f, -0.9881436f, -0.32760606f}, {-1.45123144f, 3.11550956f, -21.89090338f, -1.34372759f, 0.15910923f, -0.79665203f, -3.37770937f, -3.83008295f, 1.02779574f}, {6.70580743f, 0.79679069f, -0.27671527f, -0.34562813f, 1.1182614f, -9.39823375f, -0.22741446f, -6.44813525f, 2.27265001f}}, {{}, {}, {}, {}, {}, {}, {}, {}, {}}};/*weights_end*/
/*biases_start*/final float[][] biases = {{0f, 0f, 0f, 0f, 0f, 0f, 0f, 0f, 0f, 0f, 0f, 0f, 0f, 0f, 0f}, {0.74717792f, -0.73962409f, -0.54297496f, 0.43708783f, -3.2691145f, -3.50248963f, 0.6390228f, -1.80160365f, 0.31288734f, 0.15811907f, 5.22505739f, 0.95898281f, 10.14269592f, -0.67937257f, -4.78342368f, -2.17298142f}, {-0.31678142f, -1.41848872f, 0.85565553f, -1.48956835f, -8.68700469f, -1.10459524f, -1.78123609f, -0.96214824f, 0.66869094f, 0.51183618f, 1.68780428f, 1.77234474f, 4.90801296f, -1.51943042f, 3.41122293f, 2.44089515f}, {-1.1880539f, -0.44122274f, -0.60249115f, -6.37579432f, 1.59001643f, -3.71131883f, -2.33956263f, -3.41188019f, -0.2109665f}};/*biases_end*/

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
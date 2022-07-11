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
/*weights_start*/final float[][][] weights = {{{2.55179489f, -2.61324632f, 1.70463986f, 2.45967436f, 0.34518929f, -3.96238128f, 5.6625041f, 2.78007791f, 4.41976539f, -3.87399932f, 1.68050972f, -2.56583749f, 1.54121362f, 3.49281608f, -3.35137157f, 6.05190969f}, {-3.18994466f, 0.97256144f, -1.49317484f, 3.85426419f, 6.29895132f, -2.5468991f, -0.24852141f, 5.40852622f, -1.71745315f, 0.46444506f, 1.27741143f, 1.74622344f, -2.3072142f, 0.38378181f, -0.93660139f, -0.99183512f}, {-1.11227232f, 0.75736016f, 1.58287176f, -3.44597109f, 0.92715869f, -0.20195942f, 0.84006353f, 1.1911768f, -2.17172694f, 2.82339721f, 5.77386258f, -1.54481148f, 0.55629767f, 4.65714073f, -3.5983933f, -1.98618638f}, {-1.23450336f, -1.90558832f, -3.84256127f, -1.32499693f, 3.00892394f, -5.96179194f, 3.74016698f, 3.46035173f, -0.75335969f, -0.74111524f, 7.15861124f, 3.11313703f, 2.74123457f, 0.25306126f, -1.90504742f, -4.37184862f}, {2.11306229f, 2.81139832f, -3.93799565f, 1.80083823f, 9.39427092f, -3.00947448f, 1.07233071f, 0.97987635f, 4.17353067f, 0.1666202f, 0.41349449f, -3.87176609f, -3.42483958f, -4.22367049f, -0.80532338f, -2.59659724f}, {-2.36802241f, 2.69548835f, -2.93968782f, 2.17855657f, 3.65079572f, -6.0962843f, 1.1678116f, 1.24608453f, 2.96729719f, 0.45684251f, -3.10716959f, 0.10599864f, 0.29033884f, 0.38013043f, -4.77547388f, -2.36355118f}, {0.05505845f, 5.76701052f, -2.35034648f, 2.30711231f, 2.35710009f, -3.25355109f, -2.12749021f, 0.61753113f, -4.50502369f, 0.3452615f, 1.55178138f, -1.6070011f, 7.1564395f, -6.15915237f, -1.21424307f, 4.01201922f}, {-6.12810338f, 2.01740215f, -4.6794593f, 4.49432981f, -4.01413296f, -0.16491075f, 2.00155194f, 8.43787701f, -3.30987111f, 0.927096f, 9.43884507f, 0.42310036f, -2.52899627f, 2.45629304f, 0.6755234f, 1.3586445f}, {4.30253757f, 0.62475856f, -2.32096458f, -4.56309508f, -1.19106052f, 0.93233513f, 5.99323135f, -4.64771335f, 3.34610658f, 0.72130117f, -4.04273559f, -0.83224813f, -1.57158469f, 5.80277453f, -3.25456551f, 1.93365092f}, {0.40757936f, 2.23129188f, 5.66199832f, 1.0467352f, 0.47618812f, 2.41797707f, 1.99113806f, 3.21613264f, -3.2226985f, 1.04763912f, 1.28137565f, -3.77253163f, 6.22332847f, 1.54904712f, -2.64445144f, 2.33653346f}, {-4.14539032f, 1.6775163f, -0.71161461f, 0.80198784f, -2.26236679f, 0.55678033f, -2.4691211f, -0.79132718f, -0.71854263f, -3.09782753f, 7.80469052f, 3.49602387f, 2.58062714f, -1.5648512f, -2.14154386f, 1.84688556f}, {-2.42983263f, -2.56570618f, -1.37126754f, -0.65447139f, -0.1510705f, -1.22831953f, -3.02100306f, -2.48556485f, -2.42993142f, -3.18866477f, -3.75113333f, -4.57863994f, 0.97672778f, -4.45169697f, 1.70136921f, 0.86923097f}, {-1.50368674f, -4.77849836f, 1.97416754f, 0.47233745f, 1.10048588f, -5.81453286f, 1.98130663f, -0.58763278f, 3.09490905f, -0.7983509f, -5.49930077f, -1.86626277f, -1.3895397f, -2.34443852f, -8.91316246f, 4.57179983f}, {-3.04360107f, 0.420967f, -2.32305602f, -4.2045071f, 0.48753295f, -3.58589904f, -0.6827587f, 1.79965558f, -1.42873324f, 2.58436289f, -5.54824682f, -0.06424221f, 1.25864872f, -0.38581347f, -1.25688896f, -0.24099002f}, {-0.91941837f, -0.58964632f, 0.0077752f, 5.21939139f, -1.39540782f, -4.06386305f, -1.44963407f, -3.2483934f, -1.8982392f, 0.89303667f, 2.10857339f, -3.2271907f, 0.24577102f, 5.80143114f, -3.05214361f, 0.51651092f}}, {{-0.24728721f, -2.29085028f, 0.79057207f, 0.51234912f, -4.05904406f, 4.95186604f, -1.0065539f, -5.88920361f, 0.90097776f, 0.88345099f, -0.71710496f, 0.34973625f, 2.26161051f, -5.44984661f, 4.67337481f, 2.98005336f}, {-3.32999406f, -2.92603796f, -0.35522591f, 1.41810412f, 4.80030513f, -1.49957148f, -1.88981221f, 2.78960996f, 2.8702372f, 1.5759209f, 2.07438043f, 5.19341456f, -2.65631956f, -6.04339963f, 1.53192969f, -1.83428974f}, {-1.51298645f, -0.95916455f, 1.71801932f, -5.33605118f, 1.54766112f, -3.88241184f, 3.20167911f, -2.85947504f, -4.06153376f, -1.44301492f, -1.32890856f, -4.96890907f, 3.3669911f, -1.06312118f, 13.50439038f, -2.23482616f}, {-0.66573674f, -5.656641f, 3.78886565f, 4.6416762f, 2.51556448f, 3.89982549f, -2.42790977f, 4.85450772f, -3.35554539f, -2.86306367f, -5.11655066f, 4.37119358f, -4.09073564f, -0.73683145f, -2.90903569f, -3.2529948f}, {-1.68632542f, 2.16466197f, -1.53587292f, -0.74235942f, 1.36537144f, -2.34467172f, -7.08210415f, 2.59967627f, -0.97731347f, -5.34266326f, 1.0220266f, 0.37628481f, -4.45090213f, 3.94655907f, -5.95313312f, -0.97461334f}, {1.35531952f, 2.83867675f, -2.28167213f, -4.64647221f, 2.90463499f, -4.17735886f, -0.97423314f, -0.4116671f, -1.18946207f, 1.39066893f, -0.91998626f, 3.22394621f, -3.13821441f, 1.43319997f, 5.52333596f, 2.81319573f}, {0.69315964f, 1.91565448f, -0.2843455f, -1.70176377f, 0.00518021f, -2.94427284f, -2.32369669f, 6.33070899f, -3.79521889f, 1.68210006f, -2.00676176f, -9.09443263f, -2.54116731f, 0.28902611f, 1.28825125f, 1.92373314f}, {2.79547019f, -1.58376603f, -4.01330831f, 0.13716318f, 3.14820955f, 0.45960599f, 1.12226746f, 1.67430107f, 2.32371489f, 2.53968193f, -4.08628256f, -3.57350063f, 5.39725396f, -2.3184485f, -0.32299686f, 2.11579478f}, {-2.22677122f, -6.07584983f, 1.64120849f, 1.73850388f, 2.06241529f, 4.18433272f, 1.73128275f, -0.47786776f, -3.47257537f, -1.15998174f, 1.71728599f, 0.39036052f, -1.50153741f, -1.41853101f, 0.37231372f, 0.56666413f}, {-1.58690954f, 4.14456131f, -0.91078676f, 4.18051796f, -0.32302511f, 4.53554494f, -1.16057373f, 4.99240192f, -1.08788408f, -0.56363375f, -7.16900463f, -3.79054338f, 3.60996701f, 1.96483428f, 1.79373479f, 0.91471644f}, {-3.29809321f, 0.78438659f, -0.76247452f, -2.05149317f, 4.87019772f, -2.65099978f, -4.32779599f, 2.69876414f, 2.6601651f, 1.48075086f, -6.5234028f, -5.10238923f, 5.96645835f, -2.70437173f, 3.28248055f, 0.08040286f}, {-3.28002481f, -3.74122977f, 1.98589781f, -1.23086757f, -1.93360873f, 3.09523329f, -1.95718953f, 6.80507066f, -0.51315473f, -0.55927572f, -3.73383425f, -3.54927471f, 3.22478714f, 3.20478279f, -1.79660399f, -1.81406164f}, {0.42304563f, 2.31744686f, -1.88044052f, -2.57773211f, 2.0387971f, 2.21264524f, 0.06505822f, 4.37599466f, -0.5292148f, 7.75104277f, 2.38991947f, 3.44452405f, 1.74678477f, 3.4075423f, 1.95217312f, 3.6659318f}, {3.44852464f, -4.26489792f, 2.38073028f, -0.41291785f, 0.91121171f, -2.86223224f, 3.78798888f, 0.43908715f, -0.5441383f, -1.39379154f, 2.33686091f, 2.680111f, -5.76682054f, -3.50461046f, -0.10026829f, 0.28999253f}, {-1.59204298f, -1.06243743f, -0.49013222f, 0.87861917f, 1.89453403f, -2.20423213f, -6.81401684f, 0.89608247f, -6.64219344f, -1.78175581f, 1.76923145f, 4.28934348f, 1.25476462f, 4.1751971f, 3.76326911f, -3.32540231f}, {2.82536557f, -2.98008137f, -1.96518024f, 2.31072528f, 1.79698718f, 5.63071885f, -3.05191309f, -2.36670145f, -4.24330834f, 1.8795018f, 0.65858266f, -2.92536177f, -1.7180637f, -4.29467867f, -8.63103546f, 1.97967987f}}, {{-0.80595425f, -5.72270506f, 3.21716915f, -8.62416975f, -2.32649883f, -2.08504356f, 2.44134748f, 2.56397786f, -6.86799215f}, {2.38259045f, 2.01122866f, -1.3290403f, -2.64558215f, -0.83554202f, 2.40307981f, -0.93465062f, -0.48077127f, 1.87944802f}, {-3.98686691f, 3.45156979f, -1.73824969f, -2.31123839f, -0.91518556f, 3.43143579f, 0.79713981f, -1.47860651f, 1.79493423f}, {2.56723852f, -2.81433548f, 2.3379976f, 2.49608093f, 1.18757796f, -1.15266989f, -1.50559139f, -2.44114777f, 0.08060526f}, {1.16824007f, -3.47281729f, -3.59596909f, 6.9964741f, 5.21973833f, -1.45672373f, -0.43901415f, 0.75919706f, 3.49800497f}, {3.66254661f, 1.02100491f, 2.07515092f, -1.69826457f, -2.56269975f, -2.02899686f, -2.3492724f, -5.42161398f, 3.59526195f}, {2.6589493f, -2.76142987f, -2.20395201f, 0.35205205f, 0.41942712f, 0.88065626f, 0.67535618f, 1.42947234f, -1.50904217f}, {3.01232486f, 1.32063201f, 1.06369267f, 0.37926591f, -1.75571727f, -12.90176039f, 1.90749322f, 4.0669046f, -1.46803912f}, {-1.9635854f, 3.33020137f, -1.75177917f, 0.25042254f, 1.13388687f, -0.80187406f, 4.5562869f, -1.42763329f, 2.63984324f}, {3.90615311f, 2.30989607f, 1.65685872f, -2.71112973f, 1.49925319f, 3.68472749f, -1.13628529f, 0.64874977f, 0.26959918f}, {0.64697024f, -0.29544407f, 3.03237745f, -0.89918043f, 4.30312389f, -4.30377924f, -1.99733351f, 2.08807342f, -1.77769486f}, {1.10500348f, 3.26207329f, 0.86881307f, 1.70676322f, 2.48304297f, -0.05095746f, -2.10888784f, 1.84725424f, 0.04751251f}, {3.79966552f, 0.13840891f, 3.31033444f, -2.37562261f, 1.61908976f, 4.80949223f, -1.40073746f, 1.96663229f, -0.54885386f}, {1.2608456f, 1.82222797f, 2.36136975f, -2.59337585f, 1.57473376f, 3.11263226f, 3.17249567f, -3.50699497f, -1.13763069f}, {-4.62864141f, 4.62010937f, -3.35725936f, -0.719021f, 0.42277068f, -2.4919394f, -1.87176119f, -3.62488384f, 1.46206273f}, {3.25236841f, 0.7145058f, -0.90655468f, -1.14696011f, 1.91937007f, -3.57858068f, -0.67593915f, -6.36630032f, 2.94753789f}}, {{}, {}, {}, {}, {}, {}, {}, {}, {}}};/*weights_end*/
/*biases_start*/final float[][] biases = {{0f, 0f, 0f, 0f, 0f, 0f, 0f, 0f, 0f, 0f, 0f, 0f, 0f, 0f, 0f}, {5.20880283f, -0.92022583f, -0.27828538f, 1.35496223f, -2.22454676f, -1.78598529f, 0.75054351f, -0.60341098f, 0.27329456f, 1.34041212f, 1.66330998f, 2.45641164f, 3.17493981f, -2.0496583f, -3.18053947f, -3.13445916f}, {-0.28940865f, -8.38745397f, 1.81264149f, -4.40400483f, -3.42024547f, -3.42217741f, -7.55764895f, -4.70998317f, 1.97789464f, 0.65317057f, 2.01909439f, 2.54196544f, 2.46349167f, -3.07321447f, 0.5421846f, 2.23444448f}, {-3.39607347f, -0.21165497f, -1.21913587f, -5.17082974f, 0.27604454f, -6.05389872f, -2.53082053f, -1.18254335f, -1.04866773f}};/*biases_end*/

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
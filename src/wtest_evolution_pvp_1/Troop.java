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
/*weights_start*/final float[][][] weights = {{{1.81472521f, -2.23548422f, 2.07461534f, 1.53631711f, 0.46005704f, -3.96155483f, 4.85188661f, 4.69062701f, 2.44692691f, -1.40645094f, 2.20167573f, -2.47155736f, 0.75077205f, 5.87721447f, -3.37183268f, 5.0871757f}, {-3.42512298f, 2.00928112f, -1.49488687f, 2.59433411f, 7.86265101f, -2.40361138f, -0.13443393f, 4.06899262f, -2.06897683f, 1.39753847f, 1.84119392f, 2.11050326f, -1.88062911f, 0.42672588f, -0.67988031f, -1.43109112f}, {-1.61441187f, 0.40152425f, 1.95098698f, -5.14177585f, 1.69102152f, -0.12144702f, 2.39789623f, 1.34755269f, -1.38491368f, 1.01670555f, 4.08047847f, -1.06948831f, 0.30424032f, 5.64760928f, -6.51577906f, -2.51837644f}, {-2.12855085f, -1.18598767f, -2.73317834f, -0.7133048f, 2.93906744f, -3.30991228f, 5.90006861f, 3.35581039f, -0.58072742f, -1.68181467f, 5.68033168f, 2.85511835f, 2.18547438f, 0.12005634f, -5.65713838f, -4.44100098f}, {1.47926627f, 1.88804594f, -1.90887714f, 0.83905114f, 10.24958137f, -5.04443107f, 0.77107645f, 0.77326376f, 6.58565173f, 0.03549603f, 0.87377193f, -2.75857804f, -5.76650744f, -6.21133169f, -1.17216171f, -2.61375909f}, {-1.39988011f, 1.87475085f, -4.41483994f, 2.8799667f, 1.83150592f, -2.86425924f, 2.27378431f, 0.84380267f, 1.17273901f, 0.61325705f, -3.17848497f, 0.0423939f, 0.2524983f, 0.38221008f, -1.84369589f, -2.48150516f}, {0.07492798f, 6.29013902f, -2.1587021f, 2.39031657f, 5.62442386f, -3.04000279f, -0.79625765f, 1.57025182f, -1.1088679f, 0.43135096f, 2.49150054f, -1.62766066f, 11.98936115f, -3.97213413f, -1.65326657f, 4.32053611f}, {-6.07599306f, 2.15766717f, -3.68860531f, 2.39390401f, -3.87395157f, -0.24631313f, 2.492246f, 4.49127522f, -3.45503191f, 1.11793618f, 1.78566771f, 0.86339348f, -3.52808281f, 1.88600489f, 0.89335311f, 1.99814085f}, {5.7083773f, 0.57401917f, -1.03148035f, -2.74736184f, -1.3776593f, 0.65482636f, 6.4169724f, -2.22191739f, 8.59103177f, 1.53251827f, -3.23991081f, -0.71866113f, -1.25737145f, 3.28036873f, -4.550685f, 1.76183982f}, {0.5740916f, 1.75545036f, 5.68969929f, 0.80650337f, 0.64828055f, 3.1036496f, 2.29547445f, 1.84123741f, -2.49933907f, 0.77378997f, 0.62006961f, -4.51480959f, 5.92417287f, 3.43248006f, -3.20675263f, 1.35640334f}, {-5.59679679f, 1.94355968f, -0.2830625f, 0.66298253f, -3.87639465f, 1.19717887f, -1.9954436f, -1.05067858f, -0.49314282f, -2.96054031f, 1.6790507f, 1.60226335f, 2.65654884f, -0.74551668f, -2.3396553f, 5.80197344f}, {-1.62115833f, -6.59594796f, -1.10930867f, -0.72333886f, -0.13304204f, -0.8609793f, -4.15853906f, -4.58431229f, -4.16858374f, -3.25920103f, -3.58035444f, -2.84756232f, 0.66196304f, -2.94107522f, 0.79990788f, 2.8067082f}, {-2.80141526f, -3.27019729f, 6.06876892f, 0.46149712f, 0.86851879f, -1.7013401f, 2.77626181f, -0.41675657f, 2.92356728f, -2.46463004f, -2.60049151f, -3.56368333f, -4.44105877f, -3.75177929f, -5.37860765f, 9.20590773f}, {-1.52149435f, 0.25049719f, -3.18200624f, -2.01111905f, 0.22288233f, -2.36578514f, -0.5525317f, 1.77473398f, -2.1206989f, 1.5920686f, -2.48710857f, -0.02836692f, 2.46656989f, -0.81920018f, -1.21277002f, -0.11532247f}, {-1.33050134f, -0.76800374f, 0.00382383f, 5.55090198f, -1.05427597f, -3.19329177f, -2.72345341f, -3.58084516f, -1.7109074f, 3.14459055f, 3.77012297f, -1.71492916f, 0.15688014f, 5.27159134f, -2.58349288f, 0.71189965f}}, {{-0.70356559f, -2.29133274f, 0.81774135f, 0.53262676f, -3.1600873f, 4.56241104f, -1.17313153f, -4.77220715f, 0.88783846f, 0.85294665f, -0.5590003f, 0.3572381f, 2.10859146f, -4.32753757f, 1.68120215f, 2.34739688f}, {-4.53024624f, -3.13696931f, -0.67578933f, 5.09213075f, 3.43047754f, -1.52545481f, -0.90932076f, 2.14709765f, 5.22718071f, 1.26479055f, 1.45901554f, 3.87901608f, -6.9587075f, -2.3928979f, 3.03080518f, -4.14926231f}, {-3.30380818f, -0.90747902f, 2.60997417f, -8.03934025f, 1.84397957f, -3.04348324f, 1.20870607f, -1.92018891f, -4.26178607f, -2.21655418f, -1.23736577f, -1.7227752f, 1.87241902f, -1.36627215f, 5.61090478f, -2.51338309f}, {-1.11695434f, -3.77872405f, 8.60992365f, 5.78057809f, 2.01751776f, 6.63202116f, -2.73249062f, 4.25817213f, -1.50237154f, -2.91038985f, -3.69412006f, 3.78725229f, -2.60775491f, -0.59881603f, -3.09279894f, -3.20280414f}, {-1.56788037f, 2.69143797f, -1.69884358f, -0.72775948f, 1.87803804f, -3.32890519f, -3.9698953f, 1.77368385f, -1.43957671f, -7.8890529f, 1.70776523f, 0.29564208f, -3.21636434f, 2.95109131f, -4.58267195f, -0.58564104f}, {0.76866118f, 3.9722753f, -2.78138393f, -3.63260561f, 3.18091952f, -4.30377317f, -1.12701372f, -0.41944653f, -1.1479627f, 3.66046844f, -0.63738768f, 4.17685221f, -3.76797161f, 0.81966585f, 2.29554493f, 0.95305497f}, {1.41099677f, 2.58326502f, -0.27108857f, -2.0286553f, 0.00179304f, -1.48594563f, -0.70816754f, 6.96865063f, -2.88720671f, 1.47817512f, -6.62150384f, -9.18402935f, -4.42264162f, 0.15318942f, 0.75311106f, 1.36623546f}, {4.02917201f, -2.52037761f, -2.51732302f, 0.18292126f, 6.57165452f, 0.95654585f, 2.20048313f, 7.61169083f, 0.95032422f, 2.49239793f, -3.27693173f, -1.87079587f, 6.91820619f, -3.50491054f, -0.36746834f, 1.70599696f}, {-1.91794637f, -4.79692969f, 2.44812566f, 1.25569276f, 1.84772067f, 4.043195f, 0.89724792f, -0.37381136f, -4.70429567f, -2.72543275f, 1.42250159f, 0.93132504f, -0.52225248f, -1.34156261f, 0.53686908f, 0.85129662f}, {-2.50904452f, 4.12489636f, -1.44662954f, 1.82872646f, -0.45661737f, 2.04674029f, -2.13822591f, 1.89820887f, -0.59275575f, -1.15945388f, -2.15256683f, -2.22753793f, 3.68295464f, 1.34006542f, 2.54827828f, 0.75575592f}, {-4.10272137f, 1.81364751f, -1.55766562f, -1.4459654f, 4.92425681f, -1.81151204f, -5.25232363f, 2.95997644f, 1.74759199f, 1.44204091f, -5.68300177f, -4.13455018f, 4.59489487f, -1.50865493f, 7.69254381f, 0.087318f}, {-3.73074684f, -4.16304328f, 2.69128014f, -1.62636492f, -2.89503215f, 3.6849131f, -3.34268989f, 5.22524178f, -0.78772516f, -0.74283981f, -3.46814316f, -2.50423851f, 1.93565341f, 3.36567694f, -1.8241965f, -1.3281753f}, {0.61805524f, 2.63293662f, -1.31009654f, -4.27396544f, 2.18342146f, 1.58744332f, 0.06825967f, 2.59709243f, -0.35112275f, 4.78371053f, 1.85432875f, 2.10221074f, 2.81132175f, 4.95433564f, 1.30670578f, 7.16523556f}, {2.51285231f, -2.10608464f, 3.98761759f, -1.00851984f, 1.36114343f, -1.79983579f, 6.5592435f, 0.14779455f, -1.79914888f, -3.66714513f, 1.71589093f, 5.32749989f, -3.91443574f, -2.7963005f, -0.11519176f, 0.45497802f}, {-7.52567653f, -1.03997674f, -0.23817982f, 0.35378421f, 2.50293091f, -2.28236644f, -5.15237027f, 0.93952505f, -2.99186176f, -2.40053666f, 2.1788034f, 4.42545827f, 1.39303678f, 4.70303201f, 5.75298498f, -4.32024828f}, {4.03609206f, -2.47136513f, -1.08406176f, 2.79061718f, 2.70866739f, 6.2519387f, -2.13689175f, -1.26030888f, -4.44523397f, 2.21136565f, 1.40788165f, -2.63437171f, -0.89036249f, -2.83154455f, -2.59094018f, 1.69850936f}}, {{-0.50672269f, -4.61283963f, 1.73222401f, -4.00021799f, -1.30115018f, -2.62578921f, 2.98148412f, 7.74041569f, -3.81682242f}, {3.41838342f, 5.12960448f, -0.72246179f, -2.2167831f, -1.79618919f, 3.52367597f, -1.2887672f, -0.81147724f, 1.64425572f}, {-2.41676453f, 2.69708497f, -0.49391223f, -1.80441564f, -0.83235692f, 1.83622034f, 0.67782756f, -2.17785466f, 2.56446882f}, {5.86091929f, -6.80108647f, 1.87715875f, 3.73499307f, 4.75822929f, -1.1129244f, -2.29768474f, -1.2465141f, 0.07218896f}, {5.24723812f, -4.10805641f, -1.77883536f, 2.28919597f, 4.73579168f, -3.75752936f, -0.73363871f, 0.79358871f, 5.14004213f}, {2.83736918f, 0.73737848f, 4.11481924f, -1.9650923f, -1.40306248f, -0.96359739f, -3.7356575f, -6.38921118f, 3.12569237f}, {1.77843219f, -1.49386057f, -2.68834428f, 0.21608935f, 0.28500165f, 1.1200389f, 0.63098005f, 2.42621395f, -2.50029757f}, {1.82947767f, 1.28567323f, 0.46393393f, 0.74740888f, -1.76701356f, -3.07071363f, 1.29224349f, 2.12619915f, -2.14718866f}, {-2.86382704f, 4.08208416f, -1.56947582f, 0.39948112f, 1.86919155f, -0.77471182f, 6.6773538f, -6.52498667f, 2.17599023f}, {3.80532355f, 1.93199728f, 3.02222481f, -2.56378901f, 3.18284182f, 6.67294671f, -1.40892282f, 0.60375158f, 0.64167086f}, {1.63124051f, -0.14728716f, 3.97206044f, -1.85087143f, 3.40200765f, -2.96212099f, -2.59893202f, 3.63736488f, -5.06255114f}, {2.41240159f, 1.65517337f, 1.03967151f, 0.62617505f, 5.08755274f, -0.0328304f, -2.95976528f, 1.29721772f, 0.06477014f}, {3.0048136f, 0.16300867f, 1.4350059f, -3.23754792f, 1.30445139f, 6.8530347f, -2.22550646f, 4.69049208f, -0.67236964f}, {0.67786698f, 3.61939696f, 2.04995381f, -5.0030143f, 2.33078643f, 2.95327639f, 2.63641173f, -2.58093336f, -0.6349947f}, {-2.92721625f, 3.74067704f, -2.56131317f, -0.62688326f, 0.41056936f, -2.06002918f, -8.37807001f, -3.22068279f, 1.26598947f}, {3.11898012f, 0.6270446f, -1.0383956f, -2.55934732f, 1.88539803f, -2.18824962f, -0.72768852f, -6.91803695f, 3.25614257f}}, {{}, {}, {}, {}, {}, {}, {}, {}, {}}};/*weights_end*/
/*biases_start*/final float[][] biases = {{0f, 0f, 0f, 0f, 0f, 0f, 0f, 0f, 0f, 0f, 0f, 0f, 0f, 0f, 0f}, {5.19413027f, -1.11845506f, -0.16354165f, 4.02293291f, -4.32720847f, -1.35622324f, 1.31733772f, -1.20965994f, 0.33380957f, 0.63819902f, 2.45996951f, 2.4416669f, 4.75772415f, -1.83890612f, -2.45030012f, -1.48835515f}, {-0.76095693f, -4.03760439f, 1.30426952f, -2.26410873f, -7.10580375f, -2.41641172f, -1.80926252f, -2.38382928f, 1.91052208f, 0.56527628f, 1.37460436f, 1.19239944f, 6.49543216f, -2.02404424f, 0.87795724f, 2.56047698f}, {-7.3202446f, -0.43973166f, -1.1478302f, -3.05603703f, 0.69223655f, -3.95228197f, -1.8349186f, -1.59502128f, -1.15220351f}};/*biases_end*/

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
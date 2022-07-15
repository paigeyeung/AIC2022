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
/*weights_start*/final float[][][] weights = {{{4.89578062f, -21.29929675f, 0.22970336f, 1.97119826f, 0.47737199f, -1.9513106f, 3.48341551f, 0.97898728f, 0.88895579f, -2.48197681f, 1.17379053f, -2.84430016f, 0.40760603f, 2.83081549f, -2.45279984f, 0.40490427f}, {-1.05157742f, 0.45336341f, -0.59271426f, 0.41754024f, 3.61694148f, -5.1570007f, -0.01194467f, 3.02707359f, -1.14362282f, 2.50431835f, 2.81454027f, 2.75216503f, -0.86051114f, 0.53122196f, -0.10178718f, -2.06180781f}, {-0.99069385f, 0.19765218f, 1.16761676f, -19.88923136f, 6.02671032f, -0.05165002f, 3.4281916f, 0.23626644f, -1.03286993f, 0.48017996f, 9.91719165f, -0.70100591f, 0.82514751f, 0.28361752f, -19.44505262f, -3.64170775f}, {-2.27318555f, -2.04146377f, -0.98859097f, -0.48871783f, 1.00061811f, -7.55979554f, 12.11305273f, 1.57140705f, -0.70582895f, -0.20358824f, 0.23723767f, 4.65697201f, 0.99671632f, 0.08493153f, -1.58147102f, -4.55445582f}, {0.83126907f, 2.61020984f, -2.68781726f, 0.21949805f, 60.81544797f, -3.29624925f, 0.85447973f, 0.44421392f, 6.36005937f, 0.0426731f, 0.75601831f, -5.91121262f, -1.1557629f, -3.43722887f, -0.21151615f, -1.632486f}, {-2.23906005f, 10.07063251f, -2.01871252f, 4.82561359f, 0.24165096f, -2.39101156f, 2.40967025f, 0.74201602f, 0.7371967f, 0.05978691f, -1.74986394f, 0.00768886f, 0.05843769f, 0.34543746f, -1.99143202f, -0.77140499f}, {0.06202104f, 2.73064577f, -2.44616486f, 5.74051985f, 2.11325187f, -1.93859002f, -0.74754694f, 0.49773944f, -0.07308875f, 0.51299711f, 3.32639443f, -0.30717072f, 1.49128697f, -0.88805258f, -2.83533089f, 2.58686794f}, {-2.31097671f, 1.57701426f, -0.12676305f, 2.01388782f, -2.46996932f, -0.34483353f, 2.70295892f, 3.98084931f, -2.51759503f, 1.00187799f, 0.7597324f, 1.9796436f, -5.17647798f, 1.86603561f, 0.86340931f, 2.02740833f}, {5.93806019f, 0.42858202f, -0.35410271f, -1.58773754f, -0.48291783f, 0.30374743f, 1.18140464f, -1.36663931f, 13.94502866f, 1.93886981f, -9.15764007f, -0.25221683f, -0.49921222f, 3.12900893f, -11.09053636f, 1.10287813f}, {0.1583492f, 0.640131f, 0.66304672f, 0.34518565f, 0.42385494f, 1.37900936f, 0.41997382f, 1.77870162f, -9.62140202f, 4.78122672f, 0.21964535f, -1.12632675f, 2.24370087f, 20.10655463f, -3.16156757f, 0.95157837f}, {-0.98260512f, 0.53718588f, -0.09594944f, 0.12195896f, -10.3409255f, 0.89698634f, -0.86420495f, -6.63370131f, -0.04470031f, -9.58531167f, 1.43441399f, 5.96173064f, 0.86413496f, -0.31604746f, -0.43593908f, 0.90026777f}, {-0.96487956f, -0.85952205f, -0.72991782f, -0.57543612f, -0.08332968f, -0.12788498f, -0.75965352f, -4.31851695f, -5.78620798f, -5.09625003f, -0.36534335f, -1.17320224f, 0.03061523f, -1.50796026f, 1.05774065f, 2.55658357f}, {-1.66363089f, -1.42051382f, 6.92720226f, 0.37791328f, 0.78237222f, -1.8459168f, 3.3212315f, -1.05415995f, 0.92838098f, -0.99182549f, -0.28274914f, -1.97857963f, -6.29638239f, -1.7522739f, -4.38278f, 22.91151996f}, {-0.68594043f, 0.15827949f, -0.39740222f, -1.9367371f, 0.15275109f, -9.72124002f, -0.04791207f, 7.15368205f, -0.69225703f, 1.30912832f, -1.49794003f, -0.04219803f, 2.00428f, -0.6965642f, -0.13696504f, -0.11206038f}, {-1.55551164f, -1.06730178f, 0.00364894f, 4.85573813f, -3.34887911f, -0.7687298f, -0.38929628f, -1.21373355f, -0.27308632f, 0.57495678f, 8.46654591f, -0.70572475f, 0.04910167f, 2.75211468f, -0.435981f, 0.14693321f}}, {{-0.4248139f, -0.99201961f, 0.2884619f, 1.09307827f, -0.52290153f, 13.87996733f, -0.25484644f, -2.44735947f, 0.4717892f, 0.14079276f, -0.36620478f, 0.17664262f, 1.80652999f, -0.60180193f, 2.13270151f, 7.2705614f}, {-1.36725352f, -3.55061673f, -0.5139022f, 1.06727244f, 2.2623426f, -3.33136567f, -0.19951288f, 0.99060233f, 9.22185641f, 0.08422461f, 3.26084068f, 1.67055595f, -5.47117824f, -0.69941296f, 2.34678781f, -2.74103325f}, {-2.9526282f, -1.24108205f, 2.36318538f, -6.49540647f, 1.38972661f, -0.94668409f, 1.50561551f, -20.34136123f, -5.51500477f, -0.52134227f, -1.74470668f, -0.65996922f, 0.47561302f, -0.10912132f, 1.94311989f, -12.6113536f}, {-0.86623237f, -0.51038821f, 10.87738827f, 14.48344835f, 0.34389737f, 8.43392329f, -0.44611598f, 2.2894913f, -1.3541015f, -0.70333558f, -1.56293145f, 6.33859832f, -2.06850368f, -1.61484602f, -2.04281471f, -0.98319611f}, {-0.4184349f, 0.32996918f, -1.78101507f, -0.30830784f, 2.14375381f, -1.3437172f, -1.99882642f, 0.9375646f, -1.21546882f, -11.58257294f, 1.84861407f, 0.13975107f, -0.64027493f, 0.8194446f, -2.80798373f, -1.79231687f}, {0.51894412f, 0.79630957f, -1.49425175f, -1.67351738f, 10.37015464f, -7.26595707f, -1.70895743f, -0.59214548f, -0.68025737f, 26.52458006f, -0.77055572f, 1.61591916f, -0.87171892f, 0.72627089f, 3.82448178f, 1.28017037f}, {0.49821881f, 2.33307226f, -0.60362486f, -0.96970121f, 0.00135587f, -1.09630353f, -0.54453973f, 2.11063649f, -6.04888126f, 1.44027818f, -18.969542f, -15.10371747f, -1.57204728f, 0.0595682f, 0.11247194f, 1.20443962f}, {10.50143016f, -1.10780171f, -1.42945349f, 0.02769675f, 0.88153128f, 0.42607999f, 0.57909632f, 3.11137422f, 0.56032007f, 2.4460115f, -3.37406796f, -4.17095101f, 1.30609355f, -3.64761749f, -0.44954805f, 0.97487143f}, {-3.70605354f, -5.52140936f, 2.65974285f, 0.85364653f, 1.42213584f, 0.53757534f, 1.27556534f, -0.49611748f, -0.76330019f, -1.12453229f, 0.62394251f, 0.38741005f, -0.25105307f, -1.14930432f, 0.57538308f, 0.22830944f}, {-2.2977881f, 4.00977946f, -0.3304065f, 1.14889884f, -0.23020529f, 1.26379948f, -0.51027587f, 2.73699618f, -0.16119371f, -0.57046441f, -2.53044877f, -1.45613902f, 3.14673854f, 0.65844631f, 5.48491009f, 0.23738349f}, {-1.54517923f, 1.0339221f, -1.67577764f, -0.96805035f, 3.06751374f, -0.70437366f, -1.45118041f, 5.21477931f, 5.60843816f, 0.84508055f, -3.61996372f, -1.19168861f, 4.58089617f, -1.79464257f, 6.03888155f, 0.12744231f}, {-0.33760129f, -0.86436275f, 1.12944647f, -0.71386055f, -3.23413057f, 0.38438364f, -0.60808095f, 11.71047672f, -1.28953424f, -1.34662812f, -4.4437423f, -4.53837566f, 1.59864743f, 3.4011036f, -2.23347395f, -0.32259744f}, {0.41255207f, 1.3100626f, -0.31023177f, -3.38082628f, 2.9769493f, 2.35964178f, 0.10241848f, 0.39949638f, -0.50360485f, 11.94186503f, 3.20493878f, 0.50642119f, 1.09667961f, 1.8385864f, 0.37576975f, 0.63206554f}, {4.18712477f, -2.88508657f, 5.08278556f, -1.52238878f, 3.41983915f, -2.64276265f, 4.47218771f, 0.01316115f, -6.43660783f, -11.30214239f, 0.37723198f, 1.87649223f, -4.66193745f, -0.52751286f, -0.15486081f, 0.54725343f}, {-8.37717472f, -0.28169417f, -0.06160478f, 0.26748999f, 1.76047206f, -0.38962727f, -0.94301758f, 0.89579946f, -1.30154694f, -0.39184365f, 0.30234738f, 6.55558825f, 0.12290062f, 3.05642675f, 18.09593199f, -2.70237305f}, {2.63660305f, -2.85242246f, -3.81602859f, 2.19992663f, 1.55190326f, 0.93797529f, -1.27092189f, -2.27671158f, -1.089076f, 1.53507884f, 1.12282221f, -1.41292119f, -0.06337145f, -0.99413378f, -1.33087001f, 3.24863418f}}, {{-0.74544404f, -2.19748853f, 0.71426045f, -15.75108075f, -2.0939993f, -1.68540878f, 5.4028213f, 6.17117401f, -2.35410995f}, {2.99251226f, 4.36715687f, -0.20804845f, -2.66291839f, -0.70620826f, 2.19553979f, -0.80826934f, -1.38842105f, 1.22407401f}, {-0.78670799f, 0.14787165f, -0.17062986f, -0.64900921f, -0.39028433f, 7.01396743f, 0.36498113f, -0.79898641f, 2.35797056f}, {2.83111041f, -1.23893959f, 1.12454936f, 3.95837121f, 4.92409763f, -0.50717892f, -0.04579692f, -1.10557727f, 0.00780956f}, {0.84640007f, -5.66980951f, -1.72211398f, 2.91243311f, 9.99813938f, -1.58468087f, -0.51800577f, 0.18650287f, 0.38235944f}, {1.70334331f, 1.50773542f, 7.09334367f, -4.09503152f, -0.32523814f, -0.60704343f, -9.59628071f, -15.91924241f, 0.25025044f}, {2.34049534f, -0.89047452f, -2.11543318f, 0.09727315f, 0.18812843f, 0.20882767f, 0.72214583f, 5.7636186f, -1.52549419f}, {1.16143882f, 2.82853664f, 0.02016149f, 0.22997876f, -5.23145699f, -1.5231018f, 1.26865427f, 4.92195406f, -0.47798951f}, {-0.25696477f, 5.20655135f, -6.39756327f, 0.26934063f, 3.16307497f, -1.35606861f, 3.29204256f, -1.74148437f, 1.51944812f}, {0.35615055f, 3.52758498f, 1.06464505f, -1.55259414f, 3.02166568f, 8.3826824f, -1.08671816f, 0.26634363f, 0.93970448f}, {1.36068067f, -0.17630439f, 4.17331449f, -0.64656226f, 4.26635421f, -0.84285318f, -0.67350609f, 2.57120302f, -29.79155426f}, {1.31696632f, 3.16438481f, 0.30885849f, 0.20745214f, 2.81962086f, -0.00400972f, -2.43616558f, 0.94941556f, 0.04889811f}, {2.97598992f, 0.68700447f, 0.37754165f, -8.50501194f, 7.04409314f, 11.04233193f, -0.32172744f, 1.33597348f, -1.11233649f}, {2.27345243f, 7.3956309f, 0.43681458f, -4.16641087f, 0.7371848f, 1.26206579f, 1.42188428f, -1.51313275f, -0.1426559f}, {-6.55263255f, 1.56262297f, -16.18243714f, -0.3604196f, 0.2014941f, -0.75456363f, -2.89196347f, -3.13603926f, 0.50384567f}, {2.45829517f, 1.15171676f, -0.27608804f, -0.61074346f, 0.51787063f, -8.15971384f, -0.44231781f, -11.77298746f, 4.58990726f}}, {{}, {}, {}, {}, {}, {}, {}, {}, {}}};/*weights_end*/
/*biases_start*/final float[][] biases = {{0f, 0f, 0f, 0f, 0f, 0f, 0f, 0f, 0f, 0f, 0f, 0f, 0f, 0f, 0f}, {0.82675254f, -0.96075835f, -0.52058211f, 0.48928541f, -2.66641795f, -8.11226761f, 0.52453204f, -3.74018465f, 0.55495273f, 0.10005236f, 5.36693862f, 0.62136373f, 6.92537347f, -1.25112857f, -4.15272777f, -3.17985846f}, {-0.47127565f, -0.94831593f, 0.5951625f, -3.52646545f, -28.26365657f, -0.71575989f, -0.57067584f, -0.81802199f, 0.50270844f, 0.8196607f, 1.29148021f, 1.51880549f, 2.66354326f, -5.68416432f, 1.02324577f, 0.54031127f}, {-1.50747236f, -0.28751432f, -1.02262554f, -6.40095534f, 0.95730106f, -2.97423954f, -1.33031577f, -6.9067851f, -0.28242136f}};/*biases_end*/

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
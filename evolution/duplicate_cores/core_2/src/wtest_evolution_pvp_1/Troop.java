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
/*weights_start*/final float[][][] weights = {{{3.0900317f, -4.18547887f, 0.80157729f, 1.50232444f, 0.27336264f, -1.65475718f, 2.36056124f, 2.79704202f, 1.92660654f, -1.43889286f, 4.46172769f, -2.19571673f, 0.67127021f, 1.06592835f, -1.96049262f, 0.45315833f}, {-1.35802584f, 1.16318347f, -1.2699762f, 0.65948557f, 2.67017554f, -5.40083874f, -0.01621884f, 4.08121714f, -0.61610077f, 2.66902785f, 2.75059602f, 1.20028218f, -0.87286686f, 0.98001977f, -0.28431452f, -1.70662061f}, {-3.75158612f, 0.30470425f, 2.44294115f, -10.59085533f, 10.5575814f, -0.10240997f, 3.59287229f, 0.43254274f, -1.50402764f, 0.47963206f, 7.63677666f, -0.31164231f, 0.25739513f, 0.45827421f, -8.66470651f, -1.11758052f}, {-4.41869668f, -3.93530798f, -1.41786637f, -0.76089446f, 1.71925491f, -6.78527436f, 9.17459093f, 2.60961279f, -2.80294712f, -0.39673391f, 1.779923f, 3.10341173f, 1.01287356f, 0.04984573f, -1.96901311f, -5.26196797f}, {0.67998572f, 1.60087604f, -6.0198146f, 0.19939702f, 39.19382146f, -4.46558611f, 0.81385949f, 0.54711559f, 18.31375014f, 0.05134148f, 0.6827259f, -3.93165723f, -1.58524675f, -12.67691765f, -0.479939f, -1.32491268f}, {-2.96116345f, 9.2492103f, -2.09040479f, 7.53315417f, 0.92092617f, -2.36693073f, 1.91805447f, 2.33276855f, 2.6670382f, 0.13272012f, -1.40404736f, 0.01600988f, 0.07489685f, 0.312409f, -2.2462177f, -1.01402425f}, {0.03939082f, 2.15260245f, -2.80493454f, 4.8317403f, 2.19508986f, -4.86914595f, -0.37493591f, 1.10955779f, -0.15097832f, 0.49855535f, 2.08045008f, -0.93013146f, 6.2477321f, -1.30268867f, -1.81668282f, 1.82713644f}, {-3.86348798f, 1.99279123f, -0.38923364f, 1.41915292f, -2.9496689f, -0.25846723f, 1.55735309f, 7.3534156f, -2.74370983f, 2.19941863f, 3.11843529f, 1.30665976f, -1.44811796f, 1.01270922f, 0.67716268f, 0.73708257f}, {2.34375832f, 0.43018307f, -0.54177064f, -8.44476942f, -0.4610666f, 0.62451f, 2.20713989f, -2.0525237f, 17.52081444f, 2.47710168f, -12.70830511f, -0.18948838f, -0.99253134f, 2.39375006f, -4.39137945f, 1.35131318f}, {0.44403285f, 0.62512713f, 1.96312202f, 0.57513254f, 0.45939096f, 1.1584491f, 2.61080219f, 6.6172004f, -9.35319549f, 0.91712753f, 0.8121511f, -2.03041614f, 5.53702836f, 5.31657634f, -1.93952796f, 0.86775391f}, {-2.09423394f, 1.61635176f, -0.01804176f, 0.22805266f, -4.23973336f, 0.64246736f, -1.59035536f, -2.32299572f, -0.09895062f, -8.47945143f, 1.02836265f, 5.26675161f, 1.84929221f, -0.56880016f, -0.82472126f, 2.87318753f}, {-1.91387917f, -1.5485582f, -1.31929008f, -0.53888063f, -0.04087357f, -0.12027792f, -1.62308092f, -1.87123619f, -4.98630553f, -5.86259254f, -0.49218864f, -2.52060589f, 0.10670542f, -2.95722972f, 0.4360852f, 8.6344201f}, {-4.63737577f, -3.04076828f, 7.67541485f, 0.42103215f, 1.121785f, -0.72933726f, 3.00775541f, -0.87299785f, 0.76604654f, -1.44461572f, -0.61272316f, -2.84498513f, -9.22652679f, -0.56163181f, -5.58697135f, 12.76974769f}, {-1.13251583f, 0.1645129f, -1.30788026f, -2.53200963f, 0.25548118f, -4.07818486f, -0.07266603f, 3.30995351f, -0.87344469f, 1.27403276f, -2.3836352f, -0.03906858f, 1.19056001f, -0.94562876f, -0.38036321f, -0.10009414f}, {-0.60671386f, -0.91818752f, 0.00332419f, 4.91335169f, -2.07095184f, -1.74908869f, -1.85662509f, -2.54419255f, -0.45132801f, 1.12432535f, 6.10719584f, -0.78226448f, 0.10522293f, 1.48343136f, -0.27351443f, 0.10187617f}}, {{-0.40551946f, -1.58233616f, 0.31022826f, 1.57247292f, -0.75947679f, 24.35452833f, -1.24406447f, -2.6316014f, 0.83780391f, 0.22868666f, -0.23729141f, 0.1114651f, 3.16861576f, -2.96341611f, 2.71733832f, 6.96481957f}, {-1.07947837f, -3.48105824f, -0.59767984f, 1.974786f, 1.38432936f, -2.53172101f, -0.16177763f, 1.28907058f, 7.53183797f, 0.07559547f, 2.08117954f, 1.82833674f, -5.10761413f, -1.52451427f, 2.91809524f, -4.82740634f}, {-1.41874453f, -2.36993483f, 2.78689086f, -14.27379076f, 2.33948967f, -2.33595718f, 1.31523672f, -2.98508487f, -4.69323187f, -0.88131868f, -1.17392972f, -0.90803229f, 0.38059417f, -0.12477934f, 1.0526713f, -12.02963733f}, {-0.61205552f, -0.41987517f, 14.24861855f, 10.83032001f, 0.75057509f, 4.10975434f, -0.53046297f, 2.0097082f, -0.45437557f, -0.63029456f, -2.86052462f, 18.22653514f, -2.14838657f, -2.08115401f, -4.04873129f, -1.35868736f}, {-0.42180016f, 0.64135497f, -1.28347462f, -0.21543526f, 3.40131031f, -1.58546184f, -2.58985568f, 0.99374632f, -3.51304228f, -4.9551196f, 1.15289267f, 0.17959026f, -0.83008241f, 1.38097592f, -4.8285781f, -0.72305777f}, {0.86203513f, 1.74151725f, -2.16404712f, -4.44490841f, 5.21765218f, -8.23405509f, -1.30257948f, -0.42339049f, -0.85304867f, 6.19439485f, -0.39835878f, 3.73202601f, -0.98626564f, 1.0408603f, 3.21622317f, 0.62746227f}, {1.5832757f, 2.28876805f, -0.3487854f, -0.37054388f, 0.00213465f, -1.30519541f, -0.72291492f, 3.44554878f, -6.49716804f, 1.21378876f, -23.82135347f, -11.48018007f, -4.45581624f, 0.06622335f, 0.22456302f, 1.63880762f}, {4.68960475f, -0.75753454f, -2.90270961f, 0.03802936f, 2.88869732f, 1.15603689f, 0.6223869f, 3.45393376f, 2.06134581f, 0.99998963f, -2.13395099f, -7.80906089f, 1.3978363f, -4.18060759f, -0.46546378f, 0.7763444f}, {-8.05452997f, -11.00641656f, 3.46805484f, 0.76754065f, 1.1729942f, 2.05077398f, 1.42144171f, -0.39151971f, -0.87868845f, -0.98385521f, 1.10851646f, 0.61039857f, -0.37014264f, -1.23439986f, 0.70476224f, 0.15180399f}, {-2.8378131f, 8.92141743f, -0.80446416f, 1.48871875f, -0.14699542f, 0.877272f, -1.49682225f, 1.46337422f, -0.13577598f, -0.47803351f, -1.16081938f, -1.31880318f, 5.28592761f, 2.2219647f, 5.97521167f, 0.27031786f}, {-2.36248562f, 2.68184795f, -1.64123092f, -0.63811857f, 2.6651756f, -0.77387849f, -3.26731175f, 4.04317981f, 6.17502439f, 1.09995944f, -2.06334059f, -1.2248503f, 2.60534197f, -2.01775167f, 4.73238689f, 0.12632219f}, {-0.28645377f, -1.56315768f, 1.30710766f, -0.73506185f, -4.65851093f, 0.80287836f, -1.84165358f, 6.37666175f, -2.02127999f, -1.59284339f, -3.21365251f, -1.44657498f, 1.92159462f, 3.88452332f, -1.7626284f, -0.37057817f}, {0.64748343f, 1.6913499f, -0.66300355f, -4.65245065f, 1.17133568f, 2.69120064f, 0.15103677f, 0.57226563f, -0.24094784f, 5.13621659f, 4.00556457f, 1.17897261f, 1.55132564f, 5.45392853f, 0.25710719f, 1.71678114f}, {4.87249623f, -1.99819263f, 4.91303944f, -1.2990857f, 1.40111333f, -0.61228326f, 14.34055002f, 0.10762759f, -1.95195495f, -3.14771772f, 0.36310274f, 4.7824672f, -5.60478739f, -0.98227002f, -0.27815733f, 0.55928026f}, {-5.10787592f, -0.35421162f, -0.06531199f, 0.1632039f, 2.24853234f, -0.72166692f, -1.06216897f, 0.58280062f, -1.24901133f, -0.98729137f, 0.45256103f, 6.3719712f, 0.31050483f, 7.13748465f, 12.97474023f, -8.72677057f}, {1.56237108f, -4.39456268f, -1.82998815f, 1.28730976f, 1.99940818f, 1.46910016f, -1.063144f, -1.62400375f, -4.32428303f, 0.85535583f, 2.10242554f, -1.13197206f, -0.25548694f, -1.34237217f, -3.5546657f, 1.60513393f}}, {{-0.69843274f, -1.84051308f, 0.83741564f, -33.66450815f, -2.19477766f, -1.72396569f, 8.39680969f, 2.35898991f, -3.61177124f}, {1.98065165f, 2.76720496f, -0.18951246f, -1.08873301f, -0.78513241f, 2.3448856f, -0.51812389f, -1.71142184f, 2.22214045f}, {-1.03985998f, 0.46150375f, -0.28299762f, -1.49214951f, -0.8395896f, 3.82564923f, 0.15718846f, -1.06771243f, 1.77273962f}, {1.45846005f, -1.38285714f, 1.04944477f, 4.23951943f, 4.03306364f, -0.99385754f, -0.41746274f, -1.48092842f, 0.02234678f}, {2.18448813f, -6.34249374f, -1.14744482f, 5.18912067f, 5.93784477f, -4.09796093f, -0.23491905f, 0.21520832f, 2.56671068f}, {2.34337434f, 1.57336638f, 4.19576989f, -1.88955286f, -0.33680019f, -0.97016955f, -3.89380642f, -10.95878977f, 2.95599386f}, {3.00203817f, -1.79591953f, -4.42399001f, 0.16702334f, 0.10856393f, 0.41537366f, 0.83233233f, 2.51090122f, -2.26231593f}, {3.05914904f, 1.55808001f, 0.05343502f, 0.31208037f, -4.16598675f, -1.06405083f, 0.46482183f, 5.10962127f, -0.79780797f}, {-1.14445162f, 10.67608893f, -6.7475483f, 0.18806118f, 2.29925892f, -0.50434347f, 2.46794657f, -1.49437099f, 1.61338374f}, {0.92261203f, 3.41493327f, 1.00903756f, -2.67354857f, 2.64553185f, 13.93439065f, -0.76301782f, 0.40050687f, 0.82413731f}, {1.27881036f, -0.19406101f, 4.6593398f, -1.08688028f, 6.95484651f, -0.44792225f, -0.31869499f, 1.34042213f, -24.18757361f}, {1.60088078f, 7.11228078f, 0.32464668f, 0.15219379f, 2.83129644f, -0.00908548f, -2.34199442f, 1.96163451f, 0.10272446f}, {1.13234659f, 0.30787164f, 0.30113007f, -5.22977667f, 10.52522232f, 9.23917841f, -1.91347989f, 2.44518329f, -1.45326256f}, {1.78860455f, 4.53827515f, 0.70966041f, -5.49421656f, 0.72875289f, 1.5589175f, 1.07961632f, -1.01989704f, -0.30015834f}, {-3.40899237f, 3.02864169f, -8.1122953f, -0.58734312f, 0.18085411f, -1.13668369f, -3.21635394f, -8.08897033f, 0.77062091f}, {5.38503503f, 2.34770305f, -0.26817281f, -0.4936287f, 1.21224075f, -10.58749436f, -0.16783582f, -6.05625971f, 3.35225224f}}, {{}, {}, {}, {}, {}, {}, {}, {}, {}}};/*weights_end*/
/*biases_start*/final float[][] biases = {{0f, 0f, 0f, 0f, 0f, 0f, 0f, 0f, 0f, 0f, 0f, 0f, 0f, 0f, 0f}, {1.05812859f, -0.58984482f, -0.42893559f, 0.53359879f, -4.45283724f, -3.23411799f, 0.36361637f, -1.69047802f, 0.56082814f, 0.25613559f, 2.86695541f, 0.89362683f, 5.8311737f, -2.37893937f, -2.80208882f, -1.7280861f}, {-0.50398636f, -0.57462951f, 1.11181994f, -0.82036999f, -8.70875722f, -0.62463417f, -1.97830277f, -0.8726985f, 1.19453335f, 0.43090189f, 2.16283682f, 1.69141104f, 6.35877017f, -2.98718359f, 2.26470037f, 1.23017208f}, {-1.95136217f, -0.50840973f, -1.17345895f, -5.64045524f, 0.97102816f, -3.82569679f, -2.03761279f, -2.37771122f, -0.14581776f}};/*biases_end*/

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
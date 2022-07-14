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
/*weights_start*/final float[][][] weights = {{{3.53002276f, -3.48767269f, 0.56056793f, 2.12163045f, 0.27984133f, -1.00341044f, 4.82573691f, 3.26951446f, 1.80759681f, -1.96108658f, 3.67052111f, -5.39346331f, 0.38299429f, 2.26837051f, -1.21724351f, 0.98913832f}, {-0.96661724f, 1.01952937f, -1.90537209f, 0.63105373f, 2.11096806f, -4.08523694f, -0.02326068f, 3.16281864f, -0.66701104f, 1.0746263f, 1.76229708f, 2.09291739f, -1.35824637f, 0.71847691f, -0.30824718f, -2.07944335f}, {-1.88296137f, 0.40356757f, 1.06688191f, -16.40971325f, 1.47217188f, -0.19444533f, 4.16223465f, 0.49002223f, -4.54409021f, 0.79547692f, 10.36984492f, -0.20579937f, 0.43282761f, 0.67104153f, -21.48315681f, -1.89481448f}, {-1.42354092f, -3.9287413f, -0.6284573f, -0.70395671f, 1.00375739f, -2.86302685f, 10.98436709f, 2.65922612f, -2.22140842f, -0.54128588f, 2.79196775f, 3.61234127f, 1.76180133f, 0.08166446f, -4.85372407f, -3.81420951f}, {0.68675648f, 1.97530873f, -3.20100905f, 0.48393481f, 45.65923452f, -9.66829963f, 0.79767107f, 1.55774702f, 11.69575057f, 0.01289461f, 0.87035918f, -4.43713221f, -0.92558151f, -9.27475382f, -0.77082367f, -1.23270993f}, {-1.60169253f, 3.63873555f, -3.79677147f, 3.8111423f, 4.33324603f, -4.43109739f, 2.25991882f, 3.09449161f, 1.87605545f, 0.06306798f, -2.31989161f, 0.01254706f, 0.12915775f, 0.3772563f, -1.27615611f, -1.20695549f}, {0.01042594f, 2.78848163f, -3.380489f, 7.52667669f, 2.54167864f, -5.30841397f, -0.8021885f, 2.20985837f, -0.22886136f, 0.83953276f, 2.59114094f, -1.07997187f, 2.34082717f, -3.40585168f, -2.5236183f, 1.24487336f}, {-2.37123324f, 2.74852654f, -0.35616191f, 0.77205625f, -4.19551595f, -0.15941537f, 0.98382053f, 6.02090522f, -2.72616787f, 0.50308527f, 0.97161582f, 1.09761688f, -1.49254012f, 1.21785492f, 0.38978323f, 0.92669432f}, {1.34881005f, 0.46761603f, -0.33971495f, -11.71152452f, -0.53093802f, 0.92467396f, 1.38899431f, -1.0755541f, 11.84642943f, 2.37083817f, -4.72326374f, -0.12332034f, -0.75103621f, 3.43954845f, -4.31106796f, 1.73427601f}, {0.62872292f, 1.52332008f, 2.03458307f, 0.57120383f, 0.28580883f, 0.92077683f, 1.19331613f, 1.95629014f, -4.47201654f, 0.44148598f, 0.12932439f, -1.51368614f, 3.85162534f, 5.18889381f, -1.90888341f, 1.04206021f}, {-1.33504269f, 1.68419713f, -0.02062239f, 0.51589131f, -3.69004107f, 0.62356239f, -2.01373587f, -1.17192647f, -0.20638203f, -15.58587758f, 3.23025277f, 3.30604324f, 1.64100242f, -0.40553905f, -0.60698225f, 4.32913009f}, {-1.32957242f, -4.08952202f, -0.47148956f, -0.76397693f, -0.0418852f, -0.33444364f, -3.99131849f, -3.71217249f, -6.26043928f, -3.37979852f, -0.56275434f, -3.30121149f, 0.16735972f, -5.78072905f, 0.56803212f, 13.95918623f}, {-5.61963679f, -2.5729058f, 4.09058512f, 0.5176724f, 1.38117014f, -1.22388813f, 1.61392063f, -0.92843189f, 0.95915212f, -0.73308393f, -0.67327674f, -2.50131298f, -12.42710827f, -0.86525393f, -6.68080599f, 5.84271351f}, {-0.83158531f, 0.23997958f, -0.7942608f, -4.70514402f, 0.21523272f, -2.69467028f, -0.18539546f, 1.5184296f, -0.74143797f, 0.93065824f, -1.51702142f, -0.05329566f, 1.66207544f, -1.25731999f, -0.23546932f, -0.14362552f}, {-0.27825398f, -0.36763221f, 0.00510586f, 6.65406368f, -1.55233357f, -1.33366242f, -1.05013778f, -1.6719389f, -0.21553332f, 1.36113132f, 6.73226946f, -0.91916188f, 0.20742414f, 2.4815053f, -0.52945348f, 0.41578869f}}, {{-0.43856379f, -1.08989475f, 0.35426173f, 1.29540415f, -0.79273762f, 10.31056931f, -0.40814608f, -4.17659775f, 0.35174357f, 0.18504339f, -0.1440495f, 0.24775654f, 3.60564063f, -1.29284728f, 2.72013564f, 2.81179869f}, {-1.77022354f, -2.45196868f, -0.50754978f, 2.87122486f, 1.74971203f, -1.42030091f, -0.11733489f, 1.24242988f, 5.07374214f, 0.06247271f, 1.82605215f, 4.3126428f, -5.02472811f, -1.37023025f, 3.43649643f, -3.55511952f}, {-0.98977884f, -3.31202381f, 2.32062308f, -8.33758908f, 4.10370957f, -2.78188171f, 1.66338841f, -6.5387354f, -1.71853493f, -0.8768655f, -1.03443523f, -0.58267016f, 1.35843422f, -0.25835656f, 4.40136051f, -13.0652061f}, {-0.80327553f, -1.63356685f, 11.36470535f, 11.4485796f, 1.09901983f, 2.88715901f, -0.41386399f, 3.89030222f, -0.28618128f, -1.27772798f, -3.98906367f, 9.08128941f, -2.79562503f, -1.10305306f, -3.69194214f, -3.13290054f}, {-0.28502867f, 0.39154115f, -1.07604153f, -0.20090944f, 4.13950272f, -2.30486893f, -2.21819103f, 1.05011342f, -1.03279153f, -4.9248366f, 1.75050267f, 0.16539344f, -0.48362149f, 0.66420858f, -5.39669107f, -0.47018178f}, {0.57213691f, 2.06308978f, -1.65948704f, -3.62677885f, 7.97002399f, -2.41729955f, -0.50831606f, -0.91841649f, -0.67158814f, 6.33985977f, -0.31221287f, 3.89810595f, -1.1911522f, 1.25747368f, 4.43064777f, 0.79340933f}, {1.06686342f, 1.638338f, -0.14499462f, -0.57532035f, 0.00286871f, -0.82749009f, -0.54919429f, 2.6320042f, -3.19044852f, 2.18411347f, -17.25742559f, -7.37742566f, -3.71678815f, 0.07480063f, 0.13709275f, 0.88056231f}, {2.84695267f, -0.95407923f, -5.05423401f, 0.03133972f, 3.25860474f, 2.17517943f, 0.94579826f, 1.93714136f, 3.57839562f, 3.59715909f, -1.69637463f, -5.05302812f, 2.48563984f, -3.98480062f, -0.21358928f, 0.67090745f}, {-4.44016999f, -4.57705973f, 2.54262435f, 0.61714878f, 1.39237001f, 3.15703573f, 0.8876982f, -0.38813168f, -0.95498769f, -0.98856864f, 1.09833101f, 0.23188135f, -0.08609941f, -0.58355734f, 0.4209538f, 0.13337168f}, {-2.4258384f, 3.79497341f, -0.75133991f, 0.64470008f, -0.17971962f, 0.64898914f, -1.74348239f, 2.38249681f, -0.13867468f, -1.2050781f, -2.01254608f, -1.33543574f, 7.841167f, 1.78022139f, 5.91125571f, 0.29731594f}, {-1.78228201f, 1.70962216f, -1.0760583f, -0.51161827f, 3.76002324f, -1.75650082f, -2.54571409f, 1.193551f, 9.00408232f, 0.88751681f, -3.11628529f, -1.04519182f, 1.99705468f, -2.00716258f, 5.4465214f, 0.09676461f}, {-0.65375966f, -1.65281838f, 2.24738987f, -0.85627529f, -3.73015276f, 1.12654491f, -1.14747949f, 15.08718507f, -4.26703669f, -2.12197356f, -4.57553478f, -1.03632148f, 3.50756727f, 6.93586402f, -1.52964741f, -0.27338328f}, {0.52334326f, 0.93681731f, -0.97228204f, -4.35295859f, 1.57563898f, 1.1886023f, 0.07376314f, 0.65941923f, -0.2211049f, 5.55523829f, 7.24706081f, 0.86103125f, 1.0657967f, 4.61335884f, 0.38569147f, 3.41915025f}, {5.19194393f, -1.00314402f, 5.4114678f, -1.13391855f, 0.85826156f, -0.64971605f, 5.911535f, 0.1176561f, -2.70674392f, -4.52981786f, 0.49881836f, 7.21747686f, -2.88191247f, -0.79216327f, -0.39116976f, 0.50433837f}, {-7.96705434f, -0.81406113f, -0.08674147f, 0.13528158f, 2.09205599f, -2.03483629f, -2.53131513f, 0.60925611f, -1.04181763f, -1.41736479f, 0.50747895f, 4.85444847f, 0.41401928f, 2.78887915f, 4.60877649f, -5.18682426f}, {2.05167913f, -4.00222709f, -2.43575208f, 1.54042058f, 1.89071661f, 1.26528878f, -1.00816248f, -2.11560153f, -6.0621589f, 1.10314896f, 1.41872686f, -1.13372501f, -0.48073335f, -1.07064076f, -10.33608741f, 2.63406639f}}, {{-0.24329611f, -1.2970744f, 1.55685019f, -12.97454219f, -1.08706446f, -1.16057351f, 2.35117315f, 0.72609102f, -5.61067052f}, {2.00186645f, 3.3155991f, -0.24285241f, -0.98417018f, -0.74826047f, 2.36459841f, -0.38229616f, -1.18072069f, 1.25772966f}, {-1.10530942f, 0.36305088f, -0.66677319f, -4.90200228f, -0.58629131f, 3.29176598f, 0.26453006f, -0.54928656f, 2.85714506f}, {1.63614514f, -2.33579637f, 0.59980004f, 3.43497735f, 9.49731624f, -1.33066326f, -0.36895177f, -1.69380353f, 0.00739832f}, {2.45755918f, -5.595575f, -1.56742067f, 1.57613565f, 4.94375759f, -4.90003431f, -0.19819587f, 0.12513567f, 3.21098028f}, {2.52960886f, 1.8233975f, 3.80938674f, -3.22615299f, -0.30534954f, -0.7404852f, -3.40803868f, -12.79334239f, 2.06186929f}, {5.86504615f, -2.09718694f, -4.27171826f, 0.13926213f, 0.1033037f, 0.21686149f, 1.03990829f, 2.76436931f, -2.28544199f}, {1.86806168f, 0.81626549f, 0.09489568f, 0.4090834f, -1.4675438f, -2.34389988f, 0.86911813f, 4.68949308f, -1.29950626f}, {-1.01117095f, 13.59748175f, -3.27353394f, 0.15812228f, 3.22150255f, -0.34502031f, 1.98146673f, -3.24039984f, 2.92280087f}, {0.93250098f, 3.51641787f, 0.62315886f, -1.45444814f, 2.1073806f, 12.92449536f, -0.83455042f, 0.17950907f, 0.41775859f}, {1.10788986f, -0.1951024f, 7.04037211f, -2.12100677f, 3.56570043f, -0.79238392f, -0.42379565f, 1.87104692f, -8.24054408f}, {2.9245709f, 1.83871124f, 0.28082899f, 0.1934995f, 3.34364753f, -0.00645331f, -2.03374929f, 0.90137824f, 0.08075138f}, {1.53432911f, 0.51714037f, 0.24424958f, -2.50373787f, 5.10771135f, 5.33369883f, -1.02939326f, 5.33387816f, -1.03979808f}, {1.61664152f, 6.23030764f, 0.66437776f, -2.53343683f, 0.8356378f, 2.20348853f, 1.34044472f, -1.55088977f, -1.33423713f}, {-4.08077179f, 3.54251868f, -16.08753262f, -1.16366916f, 0.10891765f, -1.36285337f, -5.25839651f, -3.83966348f, 0.5647645f}, {2.72150822f, 0.97280411f, -0.63585003f, -0.61654739f, 0.48427483f, -5.9567469f, -0.15882492f, -3.01374684f, 2.55628947f}}, {{}, {}, {}, {}, {}, {}, {}, {}, {}}};/*weights_end*/
/*biases_start*/final float[][] biases = {{0f, 0f, 0f, 0f, 0f, 0f, 0f, 0f, 0f, 0f, 0f, 0f, 0f, 0f, 0f}, {0.77740157f, -0.48003497f, -0.34736177f, 0.34520127f, -4.55722803f, -2.05095245f, 0.24819781f, -1.66201765f, 0.90650444f, 0.46025712f, 7.02867523f, 0.87944733f, 8.11769567f, -1.81236252f, -2.58869082f, -1.34359046f}, {-0.40375406f, -1.78673986f, 0.89626704f, -1.5387445f, -7.05208359f, -1.2435009f, -2.49170319f, -1.38120774f, 0.58866676f, 0.59974383f, 5.00547199f, 2.11770145f, 5.06467212f, -3.95743275f, 2.56346951f, 3.06711991f}, {-0.87934447f, -0.58136274f, -0.40017105f, -4.12884855f, 0.84619285f, -3.53289873f, -2.83892521f, -1.22808668f, -0.21911987f}};/*biases_end*/

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
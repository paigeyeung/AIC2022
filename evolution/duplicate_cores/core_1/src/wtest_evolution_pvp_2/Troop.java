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
/*weights_start*/final float[][][] weights = {{{4.00000284f, -21.88220787f, 0.24907859f, 1.61322615f, 0.45238902f, -1.99590718f, 2.92912884f, 0.83061348f, 0.76948945f, -2.43480496f, 1.49337731f, -3.22571605f, 0.39617378f, 2.64754899f, -1.72417173f, 0.43894203f}, {-0.97725264f, 0.44290759f, -0.63456865f, 0.34752106f, 3.49026547f, -5.11110927f, -0.00955914f, 2.94403859f, -1.35781472f, 2.5248027f, 2.20117781f, 2.53015747f, -0.92685872f, 0.5596414f, -0.09583995f, -2.69660568f}, {-0.97411663f, 0.22022112f, 1.61357627f, -19.01254454f, 6.87098103f, -0.04286719f, 3.35803614f, 0.25310452f, -1.2006005f, 0.46291009f, 9.01919819f, -0.7927546f, 0.85278621f, 0.27104277f, -22.23966949f, -3.06735586f}, {-2.10312976f, -1.7280993f, -0.99415924f, -0.48559578f, 0.98952558f, -6.27567058f, 15.87111143f, 1.76973797f, -0.7400412f, -0.26664105f, 0.25091932f, 4.6957209f, 1.02432579f, 0.08177084f, -1.48341374f, -4.94612713f}, {0.88417935f, 2.40498346f, -2.65422639f, 0.20485464f, 61.80449289f, -4.41431789f, 0.79645464f, 0.36924607f, 7.0530333f, 0.03820533f, 0.90242817f, -4.63534641f, -1.25742607f, -3.37134759f, -0.23059161f, -1.47242061f}, {-2.6579812f, 9.77500096f, -1.83726847f, 5.51591402f, 0.22047801f, -2.59939726f, 2.72304772f, 0.8233576f, 0.52371944f, 0.06700919f, -2.02638753f, 0.00926949f, 0.07577621f, 0.28684798f, -2.17788631f, -0.67205961f}, {0.0562061f, 3.24910349f, -2.09393633f, 4.97995093f, 1.90582738f, -1.64113476f, -0.72530423f, 0.67229245f, -0.05793533f, 0.48243011f, 3.58791649f, -0.30416377f, 1.49429403f, -1.19546133f, -2.60583937f, 2.40422269f}, {-2.07361962f, 1.21366981f, -0.12155186f, 1.3938195f, -2.16896177f, -0.29055155f, 2.47457063f, 3.66047079f, -2.5959973f, 0.9981858f, 0.87192663f, 1.75623056f, -5.19842911f, 1.52876797f, 0.87854852f, 1.88267046f}, {5.15370254f, 0.44820303f, -0.3714082f, -1.57941026f, -0.46436466f, 0.25959651f, 1.62539742f, -1.03868553f, 11.18090613f, 1.73465482f, -7.97514526f, -0.23790297f, -0.41055159f, 2.75080149f, -9.56452096f, 1.21020329f}, {0.14587828f, 0.6270453f, 0.63129699f, 0.33693483f, 0.35705543f, 1.68310524f, 0.36058613f, 1.50006777f, -8.39452732f, 4.73418307f, 0.23601329f, -1.09294834f, 2.49056976f, 18.46203387f, -3.03003083f, 1.02921852f}, {-1.01318233f, 0.8850017f, -0.07300641f, 0.11166764f, -9.09519084f, 0.8169803f, -0.85043514f, -7.41657593f, -0.04420671f, -8.36034299f, 1.36996261f, 5.39152463f, 1.07406286f, -0.32466582f, -0.36338971f, 0.75705343f}, {-0.97978389f, -0.89391141f, -0.69926414f, -0.57004584f, -0.09144946f, -0.11065995f, -0.68971756f, -4.46651302f, -5.60385501f, -4.19100893f, -0.35224169f, -1.31480865f, 0.03817712f, -1.32309972f, 1.06634299f, 2.43211613f}, {-2.17839965f, -1.53168475f, 7.92953995f, 0.39551337f, 0.74775121f, -1.68266399f, 3.11110425f, -1.09361022f, 0.92077199f, -1.44098642f, -0.27437001f, -3.00712824f, -6.35647345f, -1.73230733f, -3.83426249f, 22.53066428f}, {-0.68207511f, 0.18473875f, -0.46752192f, -1.72000484f, 0.14537411f, -10.28830853f, -0.04210743f, 5.26710745f, -0.68708693f, 1.18380327f, -1.5892729f, -0.03514818f, 2.1611784f, -0.76133809f, -0.13389568f, -0.11922259f}, {-1.38383685f, -1.01693808f, 0.00339666f, 4.91495995f, -3.75241711f, -0.7959863f, -0.49840952f, -1.44292969f, -0.2672091f, 0.63600339f, 8.70406767f, -0.70611812f, 0.06251281f, 2.6651081f, -0.55451015f, 0.12136501f}}, {{-0.29950835f, -1.02167246f, 0.23165042f, 1.29667963f, -0.60621497f, 10.10135692f, -0.25386573f, -2.20798513f, 0.48642826f, 0.13733922f, -0.3317833f, 0.18363127f, 1.59746311f, -0.51692223f, 2.06563736f, 7.14163629f}, {-1.35787446f, -2.57943127f, -0.74130796f, 0.98477338f, 2.05851491f, -3.01900166f, -0.19306323f, 0.91183513f, 8.36196607f, 0.10569588f, 2.81658654f, 2.28614003f, -4.79290722f, -0.66420921f, 2.65481533f, -3.03640075f}, {-2.45471979f, -1.16790513f, 2.32871984f, -6.22832335f, 1.44076507f, -1.07287705f, 1.56087171f, -18.96179134f, -6.01375787f, -0.54010352f, -1.70367628f, -0.65964177f, 0.40302789f, -0.1111189f, 1.42577243f, -13.06039054f}, {-1.03533979f, -0.5171101f, 10.36983776f, 17.9362487f, 0.29664561f, 7.01472289f, -0.51905829f, 2.34739532f, -1.50010655f, -0.73609013f, -1.88697645f, 6.00913845f, -1.87732997f, -1.58260135f, -2.0529195f, -0.96285904f}, {-0.43411405f, 0.3546911f, -1.67634461f, -0.27040419f, 2.48796243f, -1.43879573f, -1.7615604f, 1.02027115f, -1.4479601f, -10.09656031f, 1.86693181f, 0.14367804f, -0.57980608f, 1.01979956f, -3.13345145f, -1.45885298f}, {0.64436085f, 0.91615831f, -1.33387765f, -1.914591f, 10.73704633f, -6.94424553f, -1.85385651f, -0.55568778f, -0.64971979f, 22.30823003f, -0.82266436f, 1.34804708f, -1.14111568f, 0.80025494f, 3.39052847f, 1.57410161f}, {0.44561359f, 1.95050809f, -0.47054469f, -0.72160616f, 0.00121188f, -0.97170187f, -0.45934296f, 1.83234947f, -6.61806304f, 1.18249427f, -16.69363383f, -21.55930888f, -1.54687262f, 0.0710738f, 0.14208577f, 1.12947203f}, {9.30748234f, -1.09615996f, -1.17889183f, 0.02710376f, 0.93292902f, 0.52545665f, 0.63766783f, 3.25424545f, 0.63343782f, 2.84583702f, -2.82886382f, -4.24709898f, 1.26066289f, -3.26195535f, -0.44202497f, 1.1300486f}, {-4.54248366f, -5.54897979f, 2.46175051f, 0.8546643f, 1.23629642f, 0.49229256f, 1.79500528f, -0.50716791f, -0.63953852f, -1.43934638f, 0.72294871f, 0.4357163f, -0.21220063f, -1.08582205f, 0.46267921f, 0.23445149f}, {-1.95826049f, 4.4998158f, -0.37275305f, 1.3315853f, -0.19274555f, 1.00702215f, -0.43689989f, 3.10755002f, -0.16068305f, -0.66457221f, -2.51442529f, -1.40803615f, 3.22537868f, 0.59391134f, 4.15788728f, 0.27696742f}, {-1.72198623f, 1.21941562f, -1.56268092f, -0.91754805f, 3.15036753f, -0.53195536f, -1.42524004f, 5.2746984f, 6.317009f, 0.92357218f, -3.86522794f, -0.89967367f, 4.23452332f, -2.54680801f, 7.82272843f, 0.13383092f}, {-0.28493607f, -0.79159658f, 1.05094212f, -0.57444739f, -2.85400874f, 0.37428834f, -0.63953884f, 12.31252639f, -1.17946912f, -1.239492f, -4.00658404f, -4.79735752f, 1.40892564f, 3.39985893f, -1.64590665f, -0.31519396f}, {0.4794945f, 1.32476717f, -0.29586641f, -3.38869659f, 2.52502975f, 3.11249448f, 0.14105748f, 0.41682204f, -0.62361183f, 10.24067668f, 3.82722549f, 0.5769883f, 1.12072687f, 1.49153333f, 0.37845635f, 0.63183856f}, {4.00408496f, -2.48688553f, 5.10083189f, -1.55170021f, 3.8138333f, -2.55547094f, 4.16667792f, 0.02183131f, -6.18390537f, -10.856885f, 0.43982533f, 2.07149121f, -4.98339606f, -0.49986823f, -0.13055922f, 0.59491951f}, {-6.61464771f, -0.28032964f, -0.05209653f, 0.24744358f, 1.88965837f, -0.36418925f, -0.86325787f, 1.07523112f, -1.50728065f, -0.36627517f, 0.27704749f, 6.97499496f, 0.15203925f, 2.79843122f, 21.81998618f, -2.79545371f}, {2.0675728f, -2.51099264f, -4.13757403f, 2.47113425f, 1.96627588f, 1.21823841f, -1.0387013f, -1.99356604f, -0.93989501f, 1.36993145f, 1.23609008f, -1.39887412f, -0.07410767f, -0.84276591f, -1.32739427f, 3.91344224f}}, {{-0.63607772f, -2.28254434f, 0.7072021f, -15.33079443f, -2.53377888f, -1.60486661f, 5.33726942f, 5.57648101f, -3.25909442f}, {3.00942772f, 3.79667793f, -0.24958962f, -2.70652491f, -0.62993912f, 2.22016409f, -0.79374454f, -1.50277692f, 1.52889417f}, {-0.84638163f, 0.09302765f, -0.17529337f, -0.51364646f, -0.37824544f, 7.6192733f, 0.33417267f, -0.89342966f, 2.64653161f}, {3.25554622f, -1.11838427f, 1.20895148f, 4.31408772f, 5.3608285f, -0.47282634f, -0.04653166f, -1.29184945f, 0.01080011f}, {0.9592439f, -5.61453013f, -2.00082732f, 3.26535511f, 9.55293207f, -1.49438422f, -0.47752893f, 0.14492267f, 0.48812966f}, {1.48253732f, 1.41922277f, 8.67128619f, -3.21070548f, -0.25708908f, -0.66793328f, -8.92345081f, -15.21244262f, 0.2060623f}, {2.3923758f, -0.82472573f, -2.30659729f, 0.09399834f, 0.20805938f, 0.18499438f, 0.70974201f, 4.96461831f, -1.42962131f}, {1.36365981f, 2.55878341f, 0.02851964f, 0.21914448f, -5.14558143f, -1.77542861f, 1.06458928f, 5.34528636f, -0.60019834f}, {-0.20109189f, 5.26120066f, -5.80779314f, 0.2688325f, 3.34361174f, -1.379845f, 2.82378012f, -1.59963729f, 1.21056225f}, {0.31785187f, 3.09150559f, 1.03616442f, -1.61819675f, 3.01445046f, 6.02758056f, -0.95889431f, 0.27101477f, 1.04035792f}, {1.17731176f, -0.15455627f, 3.89784635f, -0.63846596f, 4.34078149f, -0.84003609f, -0.47203515f, 2.74181692f, -30.23141778f}, {1.58103374f, 3.16194985f, 0.29785007f, 0.20676484f, 2.82634519f, -0.00382415f, -2.00151425f, 0.92488957f, 0.04227826f}, {3.49656282f, 0.69727163f, 0.33640493f, -7.13346824f, 6.1689515f, 13.38427228f, -0.37726795f, 1.60707585f, -1.12840511f}, {2.24906957f, 8.12324186f, 0.37511034f, -4.48155653f, 0.70371318f, 1.17371674f, 1.42858656f, -1.75317934f, -0.20966293f}, {-6.99914602f, 1.94088235f, -13.94920526f, -0.31867495f, 0.21388302f, -0.85613836f, -3.26407287f, -3.43051487f, 0.55957658f}, {2.16331243f, 1.35034973f, -0.23677486f, -0.67749625f, 0.4677278f, -8.59798232f, -0.50546941f, -11.30415463f, 3.86509065f}}, {{}, {}, {}, {}, {}, {}, {}, {}, {}}};/*weights_end*/
/*biases_start*/final float[][] biases = {{0f, 0f, 0f, 0f, 0f, 0f, 0f, 0f, 0f, 0f, 0f, 0f, 0f, 0f, 0f}, {0.79208027f, -0.82267979f, -0.46419275f, 0.43907739f, -2.40056015f, -6.81504456f, 0.54856583f, -3.22356607f, 0.5974969f, 0.08521384f, 5.48436555f, 0.66985107f, 7.53659601f, -1.45753856f, -4.73045616f, -2.81707964f}, {-0.4084614f, -0.86026127f, 0.52908677f, -3.80991133f, -24.44184203f, -0.7144338f, -0.42442096f, -0.74352907f, 0.47047311f, 0.80473468f, 1.43691869f, 1.71786956f, 2.72253888f, -6.70760923f, 0.97182799f, 0.70040115f}, {-1.45001885f, -0.27640092f, -0.88426102f, -5.72605571f, 0.86190162f, -3.40309692f, -1.1098647f, -7.60332897f, -0.28071285f}};/*biases_end*/

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
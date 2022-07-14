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
/*weights_start*/final float[][][] weights = {{{4.00542606f, -5.49866351f, 0.33605473f, 2.45364073f, 0.28606618f, -1.14092276f, 5.72135136f, 2.47470447f, 1.69329285f, -2.64540885f, 2.61219147f, -5.97017447f, 0.47209013f, 1.5790395f, -2.24717961f, 0.57973309f}, {-1.73622231f, 0.74959503f, -1.19232838f, 1.21823706f, 1.51589233f, -2.82269631f, -0.01783485f, 4.40147624f, -0.59127504f, 1.34381535f, 2.34964352f, 2.40838596f, -1.17741645f, 0.74254536f, -0.31728266f, -1.45022848f}, {-1.27583776f, 0.32624265f, 1.39479297f, -15.10372542f, 1.63555453f, -0.21790457f, 5.12347629f, 0.3802301f, -3.42343218f, 0.57212984f, 11.23746813f, -0.2585578f, 0.28588926f, 0.8716443f, -14.71665014f, -2.55420216f}, {-2.61052108f, -4.02202083f, -0.65379535f, -0.45109475f, 1.10013778f, -5.17255353f, 9.83687596f, 5.15778079f, -2.39077485f, -0.54962516f, 1.85642288f, 3.38280255f, 1.73674501f, 0.07037881f, -3.48140975f, -4.77876338f}, {0.69704129f, 1.80710498f, -4.88996308f, 0.57336019f, 50.99808779f, -5.21656577f, 0.7727842f, 1.20386389f, 13.12258136f, 0.02434225f, 0.75376398f, -4.22824863f, -1.28549446f, -6.2666159f, -1.07388216f, -1.74541875f}, {-1.63778691f, 4.57827676f, -3.07047428f, 4.1954292f, 2.63059291f, -2.63537044f, 1.8962376f, 1.60412716f, 2.43117352f, 0.08320775f, -2.01780797f, 0.02122969f, 0.15643774f, 0.32793739f, -1.4458662f, -1.15486371f}, {0.00960365f, 2.29976488f, -3.92314939f, 7.175746f, 2.33998816f, -4.09502977f, -0.82311941f, 3.34411591f, -0.23657187f, 0.88584425f, 2.54791028f, -1.104413f, 2.57275838f, -3.2403283f, -2.24632541f, 1.03701563f}, {-4.77199895f, 2.93245312f, -0.34107296f, 0.56514342f, -3.85724382f, -0.23079991f, 1.22763861f, 7.97880643f, -2.31447098f, 1.350881f, 1.6604649f, 1.1521733f, -1.78586914f, 1.43382523f, 0.54079321f, 0.92761123f}, {1.86581909f, 0.48831459f, -0.35914462f, -10.0612303f, -0.5670816f, 1.28759103f, 1.04019642f, -1.38847477f, 10.83188957f, 1.6275211f, -7.58213893f, -0.10626902f, -0.521729f, 5.14621751f, -8.39586145f, 1.88337951f}, {0.25103694f, 1.49821777f, 1.46883765f, 0.4027364f, 0.29508617f, 0.60640404f, 1.24627812f, 1.87588459f, -4.01933768f, 0.69709749f, 0.45423796f, -1.56433892f, 5.2393476f, 5.78357242f, -2.15819367f, 1.30665482f}, {-1.42351828f, 1.57624919f, -0.01776437f, 0.36533443f, -4.19172413f, 0.69747463f, -2.12297293f, -0.94787863f, -0.16851062f, -9.14653214f, 3.84101794f, 3.04850957f, 2.31791453f, -0.20057273f, -0.89978149f, 4.59354046f}, {-1.72111221f, -4.56602224f, -0.98711469f, -0.70556833f, -0.03797162f, -0.25750177f, -2.37096122f, -4.11158583f, -9.9433772f, -3.94789527f, -0.62009096f, -2.83662277f, 0.16330754f, -3.18122075f, 0.69472786f, 8.01659227f}, {-5.75037385f, -2.03122259f, 2.64930191f, 0.61034208f, 1.72530271f, -1.16286414f, 3.04260163f, -1.47421777f, 0.96732557f, -0.81087014f, -0.58514609f, -3.8450128f, -14.15600136f, -0.86222093f, -8.96163017f, 7.91161001f}, {-0.67203081f, 0.27952195f, -0.96981296f, -5.24304949f, 0.23850924f, -3.29362229f, -0.10479739f, 1.13070538f, -0.52843951f, 1.94160056f, -1.48484298f, -0.05239511f, 2.36109865f, -1.36180465f, -0.1921005f, -0.15585381f}, {-0.62307326f, -0.38682107f, 0.00312887f, 4.58349046f, -2.71187037f, -1.4071127f, -0.89798238f, -4.34870206f, -0.50790501f, 1.59058079f, 5.80554084f, -1.0074144f, 0.2542609f, 2.81215338f, -0.24532437f, 0.32027496f}}, {{-0.50689556f, -1.03357707f, 0.52189221f, 1.31794356f, -0.54722566f, 13.24346247f, -0.44487137f, -2.93173989f, 0.31543853f, 0.25810675f, -0.1852807f, 0.27000442f, 3.87020547f, -1.26907467f, 3.37957759f, 4.25241502f}, {-1.97825517f, -0.99952919f, -1.11901616f, 2.84416654f, 1.29999208f, -2.04877533f, -0.11999748f, 1.06018279f, 7.26670943f, 0.06546184f, 2.39825762f, 3.84682808f, -3.49941729f, -1.58821998f, 3.4889909f, -2.71162593f}, {-1.02279145f, -1.86508924f, 1.8738667f, -9.63422556f, 3.38796984f, -1.75854413f, 2.17603626f, -6.90981198f, -1.89847621f, -1.08691851f, -1.75345155f, -1.09441555f, 0.87903552f, -0.2728734f, 4.23199047f, -13.2546151f}, {-0.64581915f, -1.36353293f, 6.70399759f, 15.27890658f, 1.348064f, 3.77777723f, -0.44457767f, 2.14072086f, -0.28123711f, -1.21239099f, -3.46604568f, 9.21041817f, -3.63324159f, -1.17979216f, -2.5737165f, -1.71170021f}, {-0.5028775f, 0.49481725f, -0.69755291f, -0.25265087f, 2.83508903f, -2.44549124f, -1.8425194f, 0.65338284f, -1.68412139f, -3.85693942f, 1.56248534f, 0.21943642f, -0.53578277f, 0.95957715f, -2.45469131f, -0.6273252f}, {0.77484243f, 2.51731937f, -3.10592933f, -4.9946805f, 6.66640397f, -2.38950437f, -0.95814286f, -1.02279983f, -0.78189873f, 5.3798122f, -0.57395767f, 4.07978128f, -1.28084702f, 1.31765737f, 4.19122901f, 1.26849173f}, {0.79784847f, 2.33470525f, -0.20888805f, -1.178102f, 0.00209833f, -1.00385116f, -0.26943397f, 2.64213489f, -3.59147063f, 1.85556805f, -22.73248388f, -10.4635785f, -2.54417934f, 0.07254292f, 0.12412891f, 0.70997772f}, {2.68844299f, -1.16621174f, -3.79821595f, 0.03517439f, 3.02879648f, 1.27612547f, 0.74739147f, 4.07539161f, 2.20027829f, 3.30594112f, -2.04832474f, -8.06655659f, 2.84582224f, -3.75622567f, -0.19747575f, 0.85151791f}, {-6.65746465f, -6.77026409f, 2.76588039f, 0.68643378f, 1.16342184f, 2.52147531f, 0.86169867f, -0.33378729f, -0.8470991f, -0.71855542f, 1.40967862f, 0.36405117f, -0.10259065f, -0.49083598f, 1.16029447f, 0.14061337f}, {-3.02766771f, 6.22014098f, -0.61964939f, 0.94578195f, -0.24584383f, 0.77829597f, -1.32082675f, 1.28643198f, -0.11721942f, -1.83415768f, -1.54125126f, -1.80271014f, 9.02383895f, 2.75166784f, 6.81634148f, 0.33598476f}, {-2.54680504f, 0.82317115f, -1.15676033f, -0.34101484f, 2.10735873f, -1.80944955f, -2.16170378f, 3.46235511f, 8.88223566f, 1.26980338f, -2.75603005f, -1.44328389f, 2.03834587f, -2.43533507f, 6.26886683f, 0.0785749f}, {-0.77152465f, -1.07029849f, 2.20541518f, -0.78665487f, -3.69300592f, 1.39747072f, -0.82039658f, 8.94061737f, -4.36089554f, -1.3281443f, -3.94671219f, -1.14712549f, 1.97828856f, 6.81679587f, -1.41247055f, -0.2872294f}, {0.36694494f, 0.71072299f, -0.47082217f, -3.83121257f, 1.43418696f, 2.18294797f, 0.08936711f, 0.56940297f, -0.1738132f, 9.28678638f, 6.88128516f, 1.21779587f, 1.07992076f, 4.0681301f, 0.46148922f, 2.9176552f}, {6.07450888f, -0.97942801f, 4.21389763f, -2.06365853f, 1.28246442f, -1.19803247f, 8.37973682f, 0.09135706f, -2.69695835f, -7.10749901f, 0.47495238f, 7.94800935f, -3.87863435f, -0.61113705f, -0.3958955f, 0.58348295f}, {-9.89973317f, -0.7643776f, -0.08491754f, 0.12366502f, 1.70488783f, -1.03528376f, -1.22869776f, 0.68743953f, -1.79781592f, -0.87898144f, 0.38365514f, 8.32946166f, 0.20834392f, 3.55459492f, 5.1281495f, -4.58151338f}, {2.37937352f, -4.54587721f, -2.47242257f, 1.0836139f, 2.71405354f, 1.34578819f, -1.30768899f, -2.37563644f, -6.21931519f, 1.69508029f, 1.15610064f, -1.03814938f, -0.3160143f, -0.99525987f, -5.58621777f, 3.25217883f}}, {{-0.23381003f, -0.95347331f, 1.35723316f, -21.98964395f, -1.11730325f, -1.88953325f, 3.63826321f, 1.06826081f, -4.89317287f}, {1.2413031f, 3.02058824f, -0.17675417f, -1.46337996f, -0.81848367f, 1.8910557f, -0.34422508f, -1.02620115f, 1.54599317f}, {-1.12715321f, 0.36136442f, -0.5070956f, -3.04099782f, -0.49155698f, 2.91863336f, 0.33571418f, -0.6698352f, 2.40440633f}, {2.14135398f, -1.56890514f, 0.82705252f, 2.56520787f, 10.05646022f, -1.64238809f, -0.49540578f, -1.65416892f, 0.00774608f}, {1.71633441f, -9.95168174f, -1.20642271f, 3.92434375f, 3.7048616f, -4.57334746f, -0.23247167f, 0.20088514f, 2.17032682f}, {3.69897547f, 1.2663233f, 7.28665869f, -2.53078613f, -0.24498608f, -0.8560384f, -4.17649937f, -10.86207322f, 1.45873976f}, {7.41831882f, -3.51850733f, -3.5327418f, 0.12586231f, 0.17434666f, 0.30754952f, 0.74800811f, 2.10348004f, -2.63016912f}, {2.1409485f, 1.07480764f, 0.08548704f, 0.56529939f, -1.1668535f, -1.65660772f, 0.64618756f, 3.81524181f, -0.88454945f}, {-0.57991686f, 9.27084936f, -2.90049546f, 0.10433383f, 1.51861282f, -0.49598412f, 2.32973313f, -3.99476459f, 1.61291055f}, {1.61415315f, 3.38379842f, 0.69878116f, -0.89728091f, 1.82177295f, 9.11464554f, -0.89774676f, 0.16155153f, 0.35496128f}, {1.15050387f, -0.18875117f, 18.55409736f, -1.3011795f, 3.34417584f, -0.7611688f, -0.44870654f, 2.32422159f, -9.07256025f}, {4.23600495f, 2.57446266f, 0.34845818f, 0.20125849f, 4.21165806f, -0.00875101f, -1.9675748f, 0.95892446f, 0.09532713f}, {0.63041074f, 0.30925524f, 0.25145083f, -1.78121678f, 5.93026436f, 6.54442985f, -1.11667381f, 3.9027995f, -0.95244903f}, {1.32706161f, 4.76840853f, 0.69908861f, -2.44675256f, 0.48173391f, 2.95602285f, 1.41812443f, -1.58860798f, -0.75922346f}, {-3.31317623f, 4.30582225f, -14.05877924f, -0.9925398f, 0.08873821f, -1.67063271f, -6.80233524f, -3.32156409f, 1.08402016f}, {2.69070803f, 0.84212252f, -0.55585103f, -0.57325533f, 0.4662197f, -5.87440565f, -0.1536008f, -6.85889986f, 2.34129196f}}, {{}, {}, {}, {}, {}, {}, {}, {}, {}}};/*weights_end*/
/*biases_start*/final float[][] biases = {{0f, 0f, 0f, 0f, 0f, 0f, 0f, 0f, 0f, 0f, 0f, 0f, 0f, 0f, 0f}, {0.97759513f, -0.79269168f, -0.35794416f, 0.52608954f, -4.2675942f, -2.26366826f, 0.24226498f, -3.13627483f, 0.8458098f, 0.38142274f, 4.99582501f, 0.80933476f, 11.44416809f, -1.65288778f, -4.16888664f, -1.31393564f}, {-0.27768535f, -2.20040188f, 1.0606461f, -0.95990898f, -7.94605328f, -0.88078474f, -1.75866229f, -1.61364406f, 0.35213894f, 0.79762119f, 2.37036482f, 1.74613107f, 4.95811018f, -3.30135549f, 2.02140921f, 1.92880873f}, {-1.13923483f, -0.50158382f, -0.55140692f, -4.62834348f, 0.61838275f, -2.73753406f, -4.87517364f, -1.59240863f, -0.34660694f}};/*biases_end*/

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
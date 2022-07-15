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
/*weights_start*/final float[][][] weights = {{{2.6332773f, -7.20293279f, 0.17916917f, 1.11296347f, 0.32515135f, -1.09676679f, 2.57864238f, 4.80441188f, 1.03489873f, -1.83213953f, 2.26124857f, -2.75921852f, 0.30540409f, 0.85876898f, -3.24323097f, 0.23341666f}, {-1.26843293f, 0.31036295f, -0.37501284f, 0.3571979f, 3.92673386f, -2.24682577f, -0.01473441f, 2.42546292f, -0.59405646f, 0.79419474f, 2.39938137f, 3.16117978f, -0.68170505f, 0.58658454f, -0.13477331f, -0.68380276f}, {-5.48046005f, 0.19159103f, 1.74128246f, -31.76525596f, 3.17283012f, -0.06067718f, 4.40483408f, 0.09742929f, -2.12481052f, 0.70516026f, 12.2550567f, -0.23974367f, 0.21387337f, 0.62030884f, -17.20592403f, -2.01915696f}, {-2.53370925f, -5.03567507f, -0.77217187f, -0.55513716f, 0.85881335f, -5.58483397f, 11.09655811f, 1.58866684f, -2.42162795f, -0.24882475f, 0.99922481f, 2.69580961f, 1.35630361f, 0.12278244f, -0.96689369f, -3.18743239f}, {0.36828212f, 1.95091984f, -9.03226668f, 0.13345023f, 40.85200579f, -1.87386813f, 0.94543543f, 0.74696757f, 16.50506364f, 0.03120257f, 1.17692971f, -1.97627443f, -0.80431149f, -6.33260268f, -0.46498458f, -3.46347594f}, {-2.31671748f, 30.68723132f, -0.71915539f, 10.30305124f, 0.5143535f, -2.13713187f, 0.50915295f, 4.11954233f, 1.52385278f, 0.0900453f, -0.98905427f, 0.01192458f, 0.04065327f, 0.18257882f, -3.01420937f, -1.700853f}, {0.03141259f, 3.36011334f, -4.35534927f, 5.04152403f, 4.35370288f, -3.23362008f, -0.4877066f, 1.62881561f, -0.11204999f, 0.35186647f, 4.55797347f, -0.52550395f, 1.70624991f, -2.03990099f, -2.16101626f, 0.86434339f}, {-3.89626845f, 3.403303f, -0.18010834f, 0.69796589f, -2.53423189f, -0.24733189f, 1.93424938f, 7.62652991f, -0.88668833f, 1.62629919f, 0.82875335f, 1.04444472f, -0.98425743f, 0.97378072f, 0.20667701f, 0.95394938f}, {1.48542618f, 1.06535231f, -0.26571009f, -3.39731923f, -0.99207692f, 0.25804804f, 2.08424334f, -1.98513805f, 20.89802737f, 1.51741617f, -9.64274247f, -0.08344669f, -1.39250079f, 2.27202293f, -12.01259687f, 1.90744575f}, {0.27318179f, 0.44917328f, 1.12606441f, 0.40613802f, 0.34334128f, 2.36029395f, 1.46390843f, 1.23006815f, -11.28165794f, 0.67579439f, 0.74159687f, -1.81049781f, 9.355902f, 11.61325258f, -0.91832956f, 0.40742774f}, {-0.71518497f, 1.80633741f, -0.035295f, 0.36440728f, -3.80067903f, 1.60728846f, -1.5906586f, -4.06945579f, -0.02294968f, -9.52848983f, 1.31402483f, 3.59020531f, 1.7748399f, -0.37374565f, -0.49019713f, 1.27876417f}, {-3.20399781f, -1.23153009f, -0.97797802f, -0.36494943f, -0.05246917f, -0.20346237f, -1.31810741f, -5.00527997f, -6.36490227f, -9.1916126f, -0.50048708f, -2.65988702f, 0.03015968f, -2.30043697f, 0.57906516f, 7.20294708f}, {-8.02565463f, -3.68975805f, 3.03512223f, 0.35063334f, 0.47759501f, -0.51429298f, 1.65859556f, -2.1345308f, 1.22008899f, -1.05411458f, -0.1719612f, -2.18234382f, -5.47123221f, -0.51944343f, -13.37467373f, 11.2208688f}, {-1.46852768f, 0.23697929f, -0.44434642f, -1.15548361f, 0.09558301f, -5.58397254f, -0.07048899f, 1.21183202f, -1.20136894f, 0.7345385f, -1.60934932f, -0.02927905f, 2.08689223f, -1.61676285f, -0.32978997f, -0.04040771f}, {-0.46886262f, -1.94771187f, 0.01604423f, 1.21661856f, -3.32529909f, -2.2005887f, -1.45281442f, -0.94339574f, -0.18659198f, 0.67615612f, 6.95299416f, -0.54770357f, 0.11800098f, 0.56326708f, -0.79908379f, 0.09969883f}}, {{-0.61994597f, -0.65832764f, 0.15620413f, 1.29855497f, -0.76210869f, 10.10592337f, -0.41519256f, -0.90722601f, 0.55108477f, 0.12796091f, -0.21754663f, 0.18486825f, 3.52373817f, -2.04244246f, 2.03165496f, 4.33349452f}, {-1.59638343f, -3.05248473f, -0.89413851f, 3.50229958f, 2.98711842f, -1.32356244f, -0.17371202f, 2.36962308f, 13.37754212f, 0.11537891f, 1.21146382f, 1.23885413f, -4.54260893f, -0.82182013f, 1.16824284f, -1.61071289f}, {-1.33343193f, -0.85107597f, 2.08377225f, -7.74180979f, 2.96507997f, -1.06141733f, 1.08445275f, -8.16964044f, -5.23445959f, -0.39370483f, -2.51441857f, -0.3036314f, 0.69659286f, -0.08008012f, 2.41724967f, -18.07103114f}, {-0.91677644f, -0.34171526f, 13.52379753f, 2.576783f, 0.91663337f, 6.02752952f, -0.72294753f, 1.50231391f, -0.40753651f, -0.22100812f, -1.64557649f, 13.3455067f, -1.29797222f, -1.3812331f, -6.15272711f, -1.60821915f}, {-0.54353013f, 0.26659354f, -1.2461573f, -0.50912959f, 6.11262756f, -2.6580866f, -5.98209097f, 0.74282105f, -2.47701681f, -6.22779087f, 0.77616333f, 0.18271754f, -0.18324513f, 1.28846762f, -3.98949857f, -0.67230614f}, {0.44847982f, 0.56058683f, -1.23742284f, -2.09470942f, 3.80497481f, -5.13029338f, -1.48420358f, -0.27152099f, -0.57651228f, 6.87293506f, -0.38995995f, 4.32290273f, -1.10000672f, 0.98653731f, 2.39181794f, 0.63450291f}, {0.37554259f, 1.59602333f, -0.32990333f, -0.17230488f, 0.0014812f, -1.03153452f, -0.37539702f, 3.97369617f, -7.48654242f, 0.61897858f, -17.71859349f, -12.62559626f, -4.18975796f, 0.03697453f, 0.22027687f, 0.8979792f}, {8.22913776f, -1.80028629f, -3.16730107f, 0.04201797f, 1.38384207f, 1.28044661f, 2.01055973f, 2.12035134f, 0.82143903f, 0.96250012f, -3.39934274f, -5.51064336f, 0.95091253f, -1.5914762f, -0.40119641f, 0.48596236f}, {-5.21197117f, -7.2816065f, 1.8177313f, 0.78874411f, 0.87283246f, 0.80068598f, 1.52309634f, -0.4455688f, -0.49131383f, -1.54251291f, 2.67524306f, 0.41167205f, -0.40314187f, -0.42271333f, 1.01333625f, 0.11642062f}, {-0.99759765f, 8.98974909f, -0.23886572f, 1.40412434f, -0.08011195f, 0.33164237f, -0.82843238f, 1.00637883f, -0.10250791f, -0.68254378f, -1.91425667f, -0.3266224f, 5.53684194f, 1.73229856f, 7.4801554f, 0.22004242f}, {-2.49589727f, 4.32354617f, -0.90267945f, -0.46289175f, 3.22070475f, -0.41386128f, -2.7528799f, 7.68597098f, 7.59459245f, 1.21493976f, -3.90593022f, -0.41223676f, 1.35737192f, -2.50883295f, 7.19942744f, 0.20921998f}, {-0.13456286f, -3.11072047f, 2.39892791f, -0.96604524f, -4.51174847f, 0.39570101f, -0.69369707f, 5.0887988f, -1.19023748f, -1.60208282f, -2.62714781f, -1.77186721f, 0.94234757f, 10.69170277f, -1.6467357f, -0.61152669f}, {0.43622951f, 3.43531657f, -0.48359631f, -5.00647677f, 2.40067568f, 4.88215433f, 0.11179493f, 1.83011485f, -0.23053087f, 10.29547479f, 0.75809077f, 0.45067315f, 1.04634846f, 3.481488f, 0.31313553f, 1.00839078f}, {6.0162406f, -1.42644459f, 10.06352705f, -0.63329446f, 1.68921087f, -1.40822622f, 14.48321982f, 0.03320805f, -4.72513881f, -3.01905426f, 0.86281353f, 2.83798429f, -2.28209182f, -0.54798143f, -0.32618948f, 0.22915059f}, {-2.44813952f, -0.87380838f, -0.03674316f, 0.07081427f, 1.14101283f, -1.68833834f, -0.94706173f, 1.84192863f, -3.14264616f, -0.41363774f, 0.2545077f, 6.48323051f, 0.18242149f, 19.02302906f, 32.58313902f, -8.58845777f}, {1.97421139f, -1.32331614f, -3.52838052f, 2.4289005f, 1.53715225f, 1.54688358f, -1.56596764f, -2.3377778f, -0.72009463f, 2.08487715f, 1.45447958f, -0.99252651f, -0.13272292f, -1.38812251f, -1.89120578f, 1.77925141f}}, {{-1.14085436f, -1.55945768f, 0.73430569f, -40.72296235f, -2.15919508f, -2.21959567f, 4.15800524f, 8.22382018f, -1.825503f}, {3.27677489f, 5.22188114f, -0.28082797f, -2.36154594f, -1.42425715f, 1.7240602f, -0.11233222f, -1.2348432f, 1.53494742f}, {-1.21466604f, 0.49270031f, -0.28691439f, -1.14397242f, -0.57238486f, 3.0941494f, 0.1391093f, -0.3400837f, 1.73999887f}, {0.71400899f, -0.57424598f, 1.17070989f, 6.76154839f, 5.93325768f, -0.58283059f, -0.29632484f, -2.56653575f, 0.01111489f}, {1.50393978f, -14.3337904f, -1.51449232f, 1.74405211f, 6.61980135f, -4.86404019f, -0.38121344f, 0.06469884f, 2.76017768f}, {3.10198456f, 2.37193849f, 2.81259457f, -1.85385107f, -0.21132106f, -0.62972747f, -6.77895895f, -5.05436469f, 1.84161001f}, {2.77203025f, -1.80150923f, -1.87409564f, 0.3533328f, 0.30771917f, 0.51105454f, 0.98261133f, 4.88173351f, -1.24230209f}, {1.43536938f, 0.68403402f, 0.07126986f, 0.3769759f, -3.48439435f, -0.88574529f, 1.70328008f, 4.39806103f, -1.4916716f}, {-1.338536f, 4.75050621f, -3.59945127f, 0.18005277f, 1.00713504f, -0.37015331f, 6.8798427f, -1.36895229f, 2.62802512f}, {0.86369306f, 2.89130977f, 0.32806232f, -1.52643678f, 0.97042428f, 15.95211244f, -0.59903037f, 0.33428676f, 0.35761029f}, {1.19002025f, -0.18001575f, 9.88532934f, -0.73599491f, 9.03807938f, -0.61908904f, -0.66567348f, 2.39204294f, -64.90941448f}, {2.36384788f, 9.30600492f, 0.37474615f, 0.17062356f, 2.50966715f, -0.01611133f, -1.67989959f, 0.81260831f, 0.05682545f}, {0.78185498f, 0.55406536f, 0.34201362f, -7.2999532f, 7.4094669f, 3.97289619f, -1.01350707f, 2.92591791f, -0.73956232f}, {2.21535826f, 12.12553845f, 0.16922876f, -8.74528549f, 1.26616181f, 2.32157435f, 2.06419233f, -1.35827225f, -0.4552553f}, {-14.36979347f, 3.17111749f, -14.97031539f, -0.27067183f, 0.26578345f, -0.77370978f, -2.56135467f, -3.51734039f, 2.01029996f}, {2.32267612f, 1.33650759f, -0.3903452f, -0.5841198f, 0.40634449f, -11.74562263f, -0.26040207f, -4.51068533f, 3.19353394f}}, {{}, {}, {}, {}, {}, {}, {}, {}, {}}};/*weights_end*/
/*biases_start*/final float[][] biases = {{0f, 0f, 0f, 0f, 0f, 0f, 0f, 0f, 0f, 0f, 0f, 0f, 0f, 0f, 0f}, {0.73514946f, -0.70741971f, -0.34421196f, 1.04819391f, -3.06774597f, -10.91154248f, 0.93832419f, -3.78654664f, 0.73310303f, 0.19292865f, 3.00373882f, 0.46918754f, 9.29814861f, -2.56643436f, -1.47132232f, -0.71052697f}, {-0.51761143f, -0.45503385f, 0.71555356f, -2.73188674f, -9.40854277f, -1.16141559f, -1.84780586f, -1.34836234f, 0.73328647f, 0.30716147f, 1.65907228f, 4.85614119f, 10.73340167f, -5.69932201f, 1.9208712f, 0.82752906f}, {-1.5589167f, -0.21287056f, -1.12591992f, -1.77167456f, 0.44617248f, -5.35338931f, -1.28725874f, -1.2340394f, -0.07158732f}};/*biases_end*/

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
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
/*weights_start*/final float[][][] weights = {{{2.71988248f, -5.22445302f, 0.5934811f, 1.64584114f, 0.26278866f, -2.37327825f, 2.71970502f, 2.64308886f, 1.61614378f, -1.86429102f, 4.41872825f, -2.07046462f, 0.42200003f, 0.9417174f, -2.05642412f, 0.46508381f}, {-1.04643605f, 1.16696165f, -1.15044186f, 0.641395f, 3.18649637f, -4.85776999f, -0.01702125f, 3.63334844f, -0.59563787f, 2.01319438f, 1.93480662f, 0.97095551f, -0.88011719f, 0.97138383f, -0.33750086f, -1.57577876f}, {-3.20704287f, 0.31171779f, 2.12613682f, -10.62383231f, 8.20458623f, -0.11453166f, 3.81807677f, 0.43880536f, -1.49333345f, 0.40505217f, 8.47386987f, -0.2643419f, 0.29010442f, 0.46299004f, -10.01642877f, -1.1749292f}, {-4.05813604f, -3.62173065f, -1.38070318f, -0.85307906f, 1.92971701f, -8.47903302f, 10.72919359f, 2.41229283f, -2.90338443f, -0.37985685f, 1.65162097f, 3.73055079f, 1.20233338f, 0.04460819f, -1.68506247f, -4.88483737f}, {0.88099046f, 1.49029101f, -5.30531733f, 0.2133351f, 36.15026352f, -4.57688837f, 0.91704827f, 0.60117437f, 13.36059305f, 0.05055837f, 0.56907949f, -4.09691223f, -1.3272846f, -11.69734717f, -0.68311009f, -1.27588287f}, {-3.05303801f, 9.62458146f, -2.00578018f, 6.9698867f, 0.87600793f, -2.17106015f, 2.03913821f, 1.99098536f, 2.41737401f, 0.1681516f, -1.58355727f, 0.02064081f, 0.08093289f, 0.33569377f, -1.67110762f, -1.00351615f}, {0.04514323f, 1.72847338f, -2.89828104f, 4.15501069f, 2.39225615f, -4.4973253f, -0.22715048f, 1.09420795f, -0.15503106f, 0.37371014f, 2.21404803f, -0.88164628f, 6.79445398f, -1.34375157f, -1.57800512f, 1.71225444f}, {-3.57378479f, 1.81988298f, -0.36268273f, 1.48968577f, -2.82649185f, -0.25431208f, 1.94595616f, 6.97985222f, -2.30259221f, 2.09310794f, 3.12233051f, 1.31118721f, -1.57365676f, 1.00000068f, 0.59938296f, 0.78740899f}, {2.32733377f, 0.43139639f, -0.43072824f, -8.37581224f, -0.40649011f, 0.70422329f, 2.02604722f, -1.80479311f, 17.50972436f, 1.96600427f, -11.7540527f, -0.18631699f, -0.96306009f, 1.79219819f, -4.17737308f, 0.92350089f}, {0.38996257f, 0.70617608f, 1.6381279f, 0.65101377f, 0.48200972f, 1.1302873f, 2.51012915f, 5.55522726f, -9.58755546f, 0.98753536f, 0.62783086f, -1.9433327f, 6.1836675f, 6.5543713f, -2.31406204f, 0.77825201f}, {-2.0864115f, 1.77489697f, -0.02038076f, 0.22941444f, -4.47248702f, 0.63445396f, -1.78601246f, -2.2925003f, -0.10392815f, -9.00516507f, 1.30612453f, 4.43101671f, 1.6393533f, -0.57310811f, -0.9369174f, 3.0792885f}, {-2.4903654f, -1.27210165f, -1.27034681f, -0.46119303f, -0.03411497f, -0.13028549f, -1.31985726f, -1.97482263f, -5.50819348f, -6.84391453f, -0.54932612f, -2.37039005f, 0.09343033f, -2.7570861f, 0.39891668f, 7.77212648f}, {-4.82541654f, -3.64782639f, 8.24571408f, 0.45715741f, 1.29465248f, -0.83847999f, 3.71781516f, -0.7066351f, 0.75020728f, -1.76834996f, -0.56045534f, -2.57136776f, -7.95364293f, -0.58155878f, -5.58630071f, 14.62476805f}, {-1.03741936f, 0.16952135f, -1.35219079f, -2.6051827f, 0.28427873f, -5.69189973f, -0.07112629f, 3.05812464f, -0.86679842f, 1.27885213f, -2.25329416f, -0.03875653f, 0.99036487f, -0.89230382f, -0.45066985f, -0.10126805f}, {-0.75147504f, -0.94298092f, 0.00432046f, 3.92366539f, -1.7615302f, -1.97127207f, -1.49400774f, -2.38290738f, -0.5031168f, 0.83635246f, 6.29567617f, -0.93419259f, 0.12272769f, 1.71367216f, -0.26636628f, 0.09732676f}}, {{-0.43184358f, -1.69442181f, 0.32295403f, 1.79458622f, -1.1379118f, 25.99424852f, -0.98207026f, -3.31382045f, 0.81014861f, 0.19234724f, -0.19388091f, 0.0908313f, 4.41005223f, -3.11574103f, 2.38848777f, 6.67427373f}, {-1.27583274f, -3.61598127f, -0.71964089f, 2.31923642f, 2.26270613f, -2.45221434f, -0.13865281f, 1.06752118f, 8.0633811f, 0.06512898f, 2.3139308f, 1.70077336f, -4.95202067f, -1.50675769f, 2.71974277f, -4.3871361f}, {-1.60495103f, -1.80207979f, 3.36551795f, -12.64014292f, 2.1896017f, -1.88998353f, 1.25219978f, -2.86201875f, -4.61113031f, -0.69022127f, -1.23925782f, -0.78007997f, 0.39184052f, -0.11316499f, 1.22644371f, -13.24246149f}, {-0.63594993f, -0.52647801f, 16.79309126f, 13.76355937f, 0.77200127f, 4.90880371f, -0.7057438f, 2.16713613f, -0.59193615f, -0.5900011f, -2.75319183f, 17.70864041f, -2.21397464f, -1.66912503f, -4.40979738f, -1.48199607f}, {-0.51577524f, 0.64267181f, -1.18477523f, -0.18307899f, 3.58200562f, -1.45248403f, -2.67260138f, 1.03586027f, -2.94311747f, -6.42480449f, 1.06583721f, 0.22815999f, -0.84314516f, 1.21610651f, -4.30709982f, -0.63923286f}, {0.84688169f, 1.54186741f, -1.97849072f, -4.3292358f, 5.50389633f, -8.2364993f, -1.55112259f, -0.62757999f, -0.99338601f, 5.80675348f, -0.47473835f, 4.15197267f, -0.96733958f, 1.0716478f, 2.56659927f, 0.68235319f}, {1.41734414f, 1.85833477f, -0.31409371f, -0.41377984f, 0.00253363f, -1.59168562f, -0.73115459f, 3.85322646f, -7.11145035f, 1.28658103f, -24.28557983f, -10.8519367f, -4.50559992f, 0.0657921f, 0.17989126f, 1.35874435f}, {4.64877187f, -0.77629311f, -2.85488271f, 0.03543567f, 3.00901873f, 1.17293226f, 0.64365841f, 3.18181557f, 2.02129326f, 0.88033392f, -1.88121116f, -6.52389123f, 1.53122021f, -3.25951432f, -0.3491274f, 0.78859948f}, {-6.86820052f, -10.06195913f, 3.58104831f, 0.55918898f, 1.04696797f, 1.96909098f, 1.45128986f, -0.39792672f, -0.99670588f, -1.10615777f, 1.26198334f, 0.62746366f, -0.39247978f, -1.23356067f, 0.66485823f, 0.12241749f}, {-3.01446496f, 7.86628093f, -0.73132231f, 1.41400043f, -0.11629469f, 0.75624496f, -1.62111532f, 1.60721749f, -0.14805102f, -0.43663849f, -1.51129693f, -1.12972064f, 6.32463763f, 2.25249162f, 4.87571433f, 0.26957939f}, {-2.30099341f, 3.06513385f, -1.41453416f, -0.78281159f, 2.57800367f, -0.7815632f, -3.03277652f, 3.71589372f, 5.17879963f, 1.18217598f, -1.91606473f, -1.24812784f, 3.40109458f, -2.23114055f, 5.95623224f, 0.12072665f}, {-0.2942376f, -1.32149076f, 1.62801842f, -0.6430252f, -4.76208725f, 0.84879555f, -1.45628648f, 8.05968521f, -2.18444338f, -1.68935184f, -3.59768398f, -1.13372117f, 2.06173097f, 3.45272013f, -1.78562379f, -0.45928396f}, {0.64647358f, 1.80712392f, -0.8864346f, -5.31377441f, 0.86380131f, 2.99586645f, 0.18083727f, 0.62794142f, -0.21548026f, 4.68802738f, 4.93032857f, 1.14163893f, 1.99497907f, 5.30001145f, 0.23936933f, 1.93858805f}, {4.26317704f, -1.93976631f, 3.74466324f, -1.24574695f, 1.27461458f, -0.68968714f, 20.61236157f, 0.11508579f, -1.5213501f, -2.54309342f, 0.41769432f, 4.45431686f, -6.78039913f, -0.87486305f, -0.40212382f, 0.46854406f}, {-5.18653595f, -0.34634957f, -0.05883135f, 0.14985365f, 2.20453829f, -0.66982691f, -1.32982344f, 0.64349362f, -1.35679835f, -0.86377074f, 0.59445619f, 6.10518253f, 0.20668596f, 5.31173819f, 13.10817045f, -8.09844037f}, {1.52006186f, -3.84783359f, -2.09864491f, 1.43019719f, 1.68939227f, 1.39317842f, -0.9475428f, -1.70447545f, -4.24975147f, 0.80645465f, 1.85195444f, -1.10220338f, -0.28677897f, -1.3029469f, -2.91379778f, 1.53022464f}}, {{-0.72386572f, -2.13469516f, 0.59322901f, -34.43090713f, -1.57456151f, -1.98027129f, 7.72993275f, 2.21383726f, -3.03333402f}, {2.09422135f, 3.1067512f, -0.19766827f, -1.20353259f, -0.90222139f, 2.1964581f, -0.62257009f, -1.92355244f, 2.22612257f}, {-1.21948021f, 0.36830866f, -0.29742575f, -1.66152062f, -0.89793014f, 3.78980362f, 0.15731969f, -0.90528689f, 2.18415413f}, {1.3194901f, -1.18897613f, 1.00710085f, 4.00204164f, 4.52994635f, -1.10750028f, -0.54861058f, -1.46613293f, 0.01629532f}, {2.00990344f, -5.43083471f, -1.26154656f, 5.66162994f, 6.39606459f, -3.92649461f, -0.20523993f, 0.2097517f, 2.63699335f}, {2.56867872f, 1.34326027f, 5.14619794f, -2.25971823f, -0.36100048f, -0.90820828f, -3.26522049f, -11.06859059f, 2.47478096f}, {2.56943789f, -1.56876917f, -4.40376197f, 0.14039166f, 0.11335048f, 0.52559306f, 1.07138316f, 3.13233096f, -2.09113383f}, {2.82607274f, 1.41839049f, 0.06114049f, 0.44619476f, -4.11531764f, -0.87244675f, 0.54493938f, 5.0792551f, -0.82197455f}, {-1.34809967f, 11.88885503f, -7.06849777f, 0.15406922f, 1.63000336f, -0.49202761f, 2.63938429f, -1.37429859f, 2.26783062f}, {1.08040424f, 3.33821805f, 0.7956299f, -2.75462159f, 2.66960776f, 14.49251165f, -0.97935361f, 0.30699439f, 0.67342256f}, {1.48387247f, -0.19808484f, 4.67953624f, -1.03114038f, 6.70958818f, -0.34343757f, -0.38181785f, 1.26070437f, -19.8882454f}, {1.736972f, 7.70224154f, 0.3021103f, 0.19634801f, 2.45333337f, -0.00936288f, -2.09249382f, 2.1197718f, 0.08408856f}, {1.28951144f, 0.37512363f, 0.29176274f, -4.53298033f, 9.96850575f, 9.29455731f, -1.67978208f, 1.88308109f, -1.29688059f}, {1.9111634f, 5.17584654f, 0.72276493f, -5.65141525f, 0.63415106f, 1.75762713f, 1.13078637f, -1.15592693f, -0.37219817f}, {-3.95608463f, 3.46098296f, -7.05553348f, -0.504162f, 0.22022033f, -1.07134297f, -2.8092653f, -7.03162917f, 0.82350646f}, {4.82346598f, 2.07164607f, -0.29333067f, -0.46605433f, 1.08211108f, -10.45281259f, -0.1985758f, -6.6564512f, 3.13192121f}}, {{}, {}, {}, {}, {}, {}, {}, {}, {}}};/*weights_end*/
/*biases_start*/final float[][] biases = {{0f, 0f, 0f, 0f, 0f, 0f, 0f, 0f, 0f, 0f, 0f, 0f, 0f, 0f, 0f}, {1.08471978f, -0.53428314f, -0.33768757f, 0.55330043f, -5.32323336f, -2.66979698f, 0.42486569f, -1.39301121f, 0.57137216f, 0.23611358f, 2.76786912f, 0.72502598f, 5.63767205f, -2.21105052f, -2.66902683f, -1.51867642f}, {-0.52453667f, -0.64062889f, 0.91931835f, -0.87373514f, -8.51789219f, -0.57505504f, -1.73776187f, -0.87044642f, 0.87555165f, 0.42463893f, 1.70640054f, 1.76112985f, 7.2382203f, -2.60751509f, 2.87888106f, 1.02100943f}, {-1.47498319f, -0.43306031f, -1.26153003f, -6.22244595f, 0.88031242f, -3.34454524f, -2.08107069f, -3.2196092f, -0.10678434f}};/*biases_end*/

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
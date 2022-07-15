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
/*weights_start*/final float[][][] weights = {{{3.17576665f, -13.97264772f, 0.37142111f, 2.17709709f, 0.10865809f, -0.90659486f, 4.42294842f, 0.74037653f, 1.16612404f, -2.26295668f, 0.77637796f, -3.64851513f, 0.54090865f, 1.58251785f, -4.17899836f, 0.77997545f}, {-1.39812942f, 2.07893747f, -0.83436103f, 0.39020798f, 6.51555976f, -4.90228913f, -0.01262366f, 6.18686256f, -0.54962442f, 3.8153455f, 2.25354213f, 1.14982276f, -0.37590703f, 0.83985858f, -0.15532625f, -1.47650781f}, {-2.22152249f, 0.44528714f, 2.4983771f, -14.75623632f, 4.45593286f, -0.04274759f, 5.13926874f, 0.56124624f, -1.38991234f, 0.50534143f, 6.35180701f, -0.46649807f, 1.10178267f, 0.4364406f, -8.63709197f, -6.06725201f}, {-1.99783799f, -1.89095502f, -2.94870619f, -1.0737576f, 1.56001046f, -11.69514357f, 12.86417449f, 0.89623689f, -1.10684701f, -0.27411162f, 0.41224796f, 11.69980405f, 1.42690141f, 0.12014596f, -0.89399823f, -9.06570906f}, {0.37262708f, 1.38856168f, -3.39254453f, 0.08005995f, 34.41390056f, -2.69145397f, 1.04644631f, 1.10542323f, 12.35161651f, 0.02833514f, 1.1750014f, -5.30901337f, -2.04094674f, -9.20813516f, -0.34771403f, -0.7697524f}, {-3.64288952f, 13.84625708f, -1.34927009f, 3.55311178f, 0.29615329f, -3.29651325f, 2.59140726f, 0.75107238f, 0.80971371f, 0.04611982f, -2.60217838f, 0.01340624f, 0.03839692f, 0.31603826f, -2.68233084f, -1.01372348f}, {0.02321242f, 1.89301213f, -4.35376006f, 2.77949731f, 10.60775648f, -1.56052829f, -1.58297252f, 1.58267189f, -0.14772125f, 0.38008444f, 3.04325988f, -1.02233461f, 2.92398392f, -2.03613332f, -3.86557106f, 1.93789786f}, {-5.30176338f, 1.65279595f, -0.20774478f, 1.18242763f, -2.38294233f, -0.21188489f, 2.30677772f, 7.96107502f, -2.6649757f, 1.68667879f, 1.48077597f, 3.04835334f, -5.21406167f, 1.21675119f, 1.05424674f, 2.25279417f}, {3.64793631f, 0.25446168f, -0.34863369f, -1.67812723f, -0.69038809f, 0.25666944f, 0.88579416f, -0.57400178f, 9.78981861f, 1.45720347f, -3.12393826f, -0.21734335f, -0.75186771f, 1.66405054f, -6.99466755f, 1.04977807f}, {0.13018446f, 0.27794434f, 0.86300628f, 0.2733122f, 0.55700987f, 0.31991463f, 0.69545031f, 1.95835137f, -11.78771178f, 1.47195755f, 0.3590363f, -1.81721889f, 3.20425199f, 11.16192812f, -3.06751638f, 1.01676814f}, {-1.26756179f, 0.9391208f, -0.02580211f, 0.10125215f, -9.63354311f, 0.96021973f, -0.57771706f, -3.83358107f, -0.10489432f, -6.94279607f, 2.16328161f, 4.4583651f, 0.88305507f, -0.46290251f, -0.29363972f, 0.74220663f}, {-2.1433183f, -1.67851842f, -1.71767145f, -0.70131927f, -0.10865539f, -0.06202697f, -0.73465119f, -6.04426482f, -5.19763289f, -4.98836123f, -0.50338625f, -1.3031286f, 0.03064237f, -1.74907212f, 1.04780237f, 5.49025114f}, {-1.56181909f, -0.87239097f, 11.69537022f, 0.44307847f, 1.00688497f, -0.83254357f, 1.48487827f, -1.38551384f, 1.22698677f, -1.43291966f, -0.41001235f, -3.06968683f, -10.04854251f, -1.76618196f, -3.77228218f, 35.07996105f}, {-0.80359048f, 0.20187688f, -0.85903214f, -3.14430308f, 0.20423556f, -9.82418389f, -0.08710629f, 2.07602187f, -0.44309507f, 2.55773554f, -0.84926173f, -0.03181079f, 0.53073789f, -1.00641533f, -0.21621989f, -0.11282245f}, {-0.71352389f, -1.7961446f, 0.00660697f, 3.80982827f, -3.54741753f, -1.3648582f, -0.469579f, -1.30850254f, -0.29485317f, 0.4266774f, 4.22483138f, -0.77568225f, 0.16092512f, 0.93840494f, -0.23041417f, 0.13214893f}}, {{-0.2671988f, -1.97504044f, 0.71906387f, 1.33045078f, -1.21876031f, 6.84125313f, -0.48407482f, -1.24993023f, 0.38340722f, 0.28884215f, -0.5260507f, 0.12700407f, 1.20855344f, -0.59998126f, 1.36717275f, 8.95788225f}, {-0.47627728f, -4.93351322f, -0.48258748f, 1.8434569f, 1.55980031f, -0.4516305f, -0.0579851f, 2.71092788f, 3.71952048f, 0.09534783f, 4.04266833f, 2.21120578f, -10.270263f, -0.760647f, 2.36765421f, -3.1812226f}, {-1.11158453f, -2.76659552f, 2.69673681f, -6.15166896f, 1.72513691f, -0.75744793f, 2.35773936f, -8.16643708f, -3.80697071f, -0.48596201f, -0.76924868f, -1.00248523f, 1.13284727f, -0.0335385f, 1.61027496f, -9.104844f}, {-1.30831978f, -0.44968253f, 18.43655523f, 11.08681547f, 0.39856958f, 5.48226939f, -0.65780495f, 4.47814382f, -0.41976661f, -0.37312016f, -0.8573355f, 5.68276646f, -2.01172422f, -1.23116982f, -2.69763759f, -0.73995492f}, {-0.60403338f, 0.6739922f, -1.08987915f, -0.19014504f, 2.13869135f, -1.34478526f, -2.99717018f, 0.98400093f, -2.18113745f, -11.6428513f, 0.92188208f, 0.17911013f, -0.50719934f, 3.0528356f, -3.9693611f, -0.80161324f}, {0.38439679f, 1.27839562f, -2.29507052f, -1.9752694f, 8.15882973f, -5.60269069f, -0.66786206f, -0.88873157f, -1.82891608f, 13.37327462f, -0.88393594f, 1.54775351f, -1.35882538f, 1.81907234f, 2.10629946f, 1.22610286f}, {0.4016386f, 1.47891152f, -0.22405789f, -0.47135255f, 0.00108008f, -0.84277841f, -0.21439582f, 2.47112422f, -6.66014872f, 0.7110437f, -15.61114822f, -13.44099249f, -4.66839185f, 0.04497828f, 0.24541484f, 0.84832017f}, {3.75477752f, -2.26441298f, -2.97976305f, 0.02530405f, 2.22894943f, 0.68572543f, 0.84152856f, 4.6962268f, 0.76219541f, 2.65501953f, -2.77742542f, -3.03256878f, 4.23709423f, -1.76102875f, -0.31020965f, 0.60672882f}, {-1.97365408f, -5.27767602f, 0.9184729f, 0.35617332f, 0.3698371f, 0.64307779f, 1.47323694f, -0.46953706f, -0.85790781f, -0.90729143f, 0.81800948f, 0.31888618f, -0.3670689f, -0.71173864f, 0.28908506f, 0.11066061f}, {-2.24332477f, 3.65498121f, -0.33894933f, 0.83535329f, -0.14609655f, 0.98330248f, -0.7304733f, 2.62950231f, -0.2162568f, -0.90174099f, -1.96673641f, -0.81221516f, 2.37290834f, 1.14149643f, 2.78617241f, 0.07148341f}, {-2.71626494f, 2.91086338f, -0.71769442f, -1.2926909f, 2.94763751f, -1.29350063f, -2.00473775f, 4.60742764f, 6.59984623f, 1.58693959f, -2.75568717f, -0.78233118f, 4.39258169f, -2.79664241f, 15.99728003f, 0.07997088f}, {-0.67870636f, -1.00182091f, 0.45895238f, -1.04640417f, -3.28187374f, 1.12077755f, -0.60518691f, 8.79321658f, -0.49393719f, -1.33364046f, -2.8232498f, -8.52237445f, 2.54064867f, 18.21025278f, -1.11497506f, -0.18972344f}, {0.64842794f, 2.13910901f, -0.389876f, -4.74183791f, 1.25878547f, 4.29760714f, 0.13951461f, 0.90982488f, -0.61993952f, 10.33133519f, 4.46512482f, 0.45200555f, 2.28754278f, 1.25797257f, 0.17894868f, 0.906508f}, {5.35147934f, -2.03079628f, 3.80220945f, -1.26647946f, 3.20551252f, -1.83517673f, 7.03008744f, 0.01758745f, -1.74697351f, -12.09373246f, 0.36324555f, 2.19625366f, -5.39814061f, -0.71903892f, -0.11140183f, 0.30067568f}, {-4.04064451f, -0.42175491f, -0.07693581f, 0.10566392f, 1.65727168f, -0.65002275f, -2.25865185f, 0.29065341f, -1.02135336f, -0.64260863f, 0.43551057f, 15.60594175f, 0.1719937f, 2.61810458f, 8.14833972f, -5.22820287f}, {1.19650354f, -2.62256991f, -3.82633479f, 3.38469111f, 1.51314133f, 0.5074512f, -1.04235197f, -4.32160065f, -0.69077002f, 0.9531834f, 1.97475971f, -0.90961267f, -0.11961409f, -0.9471361f, -1.89134271f, 3.0297842f}}, {{-0.59175015f, -2.22831129f, 0.28599563f, -22.15543844f, -0.86911795f, -2.11480204f, 8.23991287f, 1.53284482f, -3.29078776f}, {2.67972598f, 6.81146439f, -0.13665044f, -1.16372238f, -1.09060454f, 2.23949886f, -0.56502222f, -0.45379672f, 1.57605108f}, {-1.26506186f, 0.25685001f, -0.22074634f, -0.79996474f, -0.66662951f, 4.14739093f, 0.53597285f, -0.72965002f, 0.83933734f}, {2.25311112f, -1.66806824f, 1.26689661f, 7.09799411f, 3.74097031f, -0.82312523f, -0.06171059f, -0.90996561f, 0.0080097f}, {1.58517839f, -5.26827867f, -1.23564343f, 2.89083945f, 2.99737438f, -2.70525482f, -0.45819199f, 0.26737037f, 1.70255789f}, {1.41325623f, 1.78838615f, 6.34579273f, -3.24254565f, -0.54510748f, -0.90691454f, -2.44991077f, -12.25076711f, 0.86951361f}, {3.82863244f, -1.09767525f, -2.00494087f, 0.15264483f, 0.11545091f, 0.2634181f, 1.14581031f, 5.99081683f, -0.95603152f}, {0.8040177f, 1.15792028f, 0.08054974f, 0.4839573f, -5.72887108f, -2.24747243f, 1.14290497f, 6.86203745f, -0.52433319f}, {-0.69840954f, 4.40064618f, -5.80896389f, 0.11307326f, 1.50460744f, -0.64769374f, 7.04358633f, -1.3844227f, 0.8270446f}, {0.86503196f, 5.99178051f, 0.64706797f, -0.8046959f, 2.86225808f, 16.77602311f, -1.63236152f, 0.40979255f, 1.0587223f}, {1.68936103f, -0.32289093f, 7.97926472f, -0.39634245f, 4.89243678f, -0.21437653f, -0.75582572f, 2.75134174f, -17.95978264f}, {1.44591829f, 1.09474289f, 0.19568695f, 0.19803505f, 1.37774401f, -0.0059844f, -3.68342186f, 0.59119213f, 0.02738746f}, {1.90648388f, 0.39014919f, 0.41166579f, -21.71470909f, 2.14425749f, 8.46749584f, -0.6784478f, 0.83147748f, -1.72328985f}, {2.37499311f, 10.43440743f, 0.4584287f, -3.25410955f, 1.1818621f, 1.34815186f, 1.8907738f, -1.14285924f, -0.2033427f}, {-3.04410821f, 1.78634077f, -10.8428841f, -0.28377102f, 0.09938667f, -0.82104729f, -2.94120127f, -5.90027405f, 3.02928697f}, {8.61707489f, 0.43798199f, -0.68486107f, -0.17737153f, 0.42945072f, -10.69092644f, -0.23736407f, -6.51756087f, 4.66598688f}}, {{}, {}, {}, {}, {}, {}, {}, {}, {}}};/*weights_end*/
/*biases_start*/final float[][] biases = {{0f, 0f, 0f, 0f, 0f, 0f, 0f, 0f, 0f, 0f, 0f, 0f, 0f, 0f, 0f}, {0.47585835f, -0.42221982f, -0.93275917f, 0.38446106f, -2.81594499f, -6.53007845f, 0.30441812f, -1.616087f, 0.91560577f, 0.22309899f, 6.16532545f, 1.65466281f, 21.44821417f, -1.48179254f, -4.10325475f, -0.67333902f}, {-0.30009183f, -0.42860477f, 0.97574858f, -2.22457889f, -11.66352532f, -0.80830818f, -0.43413603f, -0.56593076f, 0.95192865f, 0.48665843f, 2.40144269f, 1.26728986f, 4.75352667f, -5.8946654f, 1.97517843f, 0.20956879f}, {-1.77717492f, -0.36092547f, -1.27770575f, -6.64784815f, 0.64283432f, -4.6344808f, -1.02574893f, -1.79724348f, -0.26918647f}};/*biases_end*/

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
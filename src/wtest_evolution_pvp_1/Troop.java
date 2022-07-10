package wtest_evolution_pvp_1;

import aic2022.user.*;
import java.util.Arrays;

public class Troop extends AllyUnit {
    Troop(UnitController uc) {
        super(uc);
    }

    // x input -> 14 hidden -> 14 hidden -> 9 output
    final int[] LAYER_SIZES = {25, 14, 14, 9};
    // Weights are outgoing weights
/*weights_start*/final float[][][] weights = {{{0.454535f, 1.62409f, -0.85711f, 0.163805f, 1.210323f, 0.442988f, 0.31145f, 0.178916f, 0.519144f, 1.255094f, -0.566639f, -0.029107f, 0.260279f, -1.547499f}, {-1.29181f, -1.151181f, 1.360398f, -1.849335f, 0.35056f, -0.691715f, 0.084044f, 1.689889f, -0.208416f, 1.791972f, 0.72028f, 1.807097f, 0.422927f, 1.734332f}, {-0.396172f, 1.692643f, -0.744579f, -1.103714f, -1.635366f, 1.41197f, 0.445832f, 1.753802f, 1.138072f, -0.424807f, 1.909199f, 1.008105f, 0.431556f, 0.188607f}, {0.222515f, -0.773048f, -0.475499f, -0.835919f, 0.946312f, -0.219115f, -0.195678f, 0.854502f, 2.082318f, -0.241082f, 1.77895f, -1.097456f, 0.057777f, -0.003241f}, {-1.754322f, 0.501041f, 1.812686f, 1.824832f, 0.614274f, 0.065397f, 0.367827f, -0.213472f, 1.884104f, -1.880178f, -1.795169f, -0.513738f, -0.873406f, 0.515303f}, {1.327488f, 0.255344f, 0.340845f, -1.080411f, -1.431233f, -1.546419f, -1.121352f, -2.019443f, -0.624036f, 0.640404f, -0.173329f, 0.528605f, -1.244715f, 1.938327f}, {1.67538f, -0.714027f, -1.878171f, -1.046672f, 0.32542f, -0.881688f, -1.093301f, -1.780268f, 1.556976f, -0.951128f, 0.438199f, 0.380022f, -1.848552f, 0.95785f}, {-1.051204f, -1.178891f, 0.740545f, 0.048434f, -1.573619f, -0.651794f, -0.182126f, -0.335675f, 1.721368f, -0.767118f, 0.939004f, -0.705109f, -0.026034f, -0.75185f}, {1.137557f, -1.924127f, -0.405519f, -1.363199f, 0.512986f, 0.572354f, 1.589622f, 0.95857f, -1.575793f, -0.124361f, 0.313614f, -1.610953f, 1.456011f, -1.652997f}, {0.036411f, 1.59627f, -1.325568f, 1.828676f, -0.090852f, 1.622877f, 1.686588f, -0.504648f, 1.495433f, -0.154401f, -0.902757f, -0.354799f, -0.571657f, 0.022719f}, {0.348989f, 1.085427f, 1.560624f, -0.555674f, -0.088383f, 0.477478f, -1.172863f, -0.559408f, -0.893418f, 1.459719f, 1.261678f, 0.01784f, -0.941576f, -1.048024f}, {-1.667918f, -0.933438f, -1.222286f, 0.295948f, 0.938229f, -1.582806f, 2.020733f, -1.278402f, 0.120464f, -1.714504f, 1.552004f, 0.626172f, 0.580612f, 0.091905f}, {-0.607914f, 0.925631f, -0.627385f, -0.83847f, 0.328458f, 1.494096f, -0.145044f, -1.433324f, -1.651135f, -0.737332f, -1.235754f, -0.528538f, -2.026169f, 2.191409f}, {1.278222f, 0.032564f, 1.36656f, -0.0436f, -0.255332f, 0.843791f, -1.024235f, -0.851655f, -0.37263f, -1.41037f, -1.04068f, -1.514481f, -1.638071f, 0.129878f}, {1.177986f, -1.597574f, 1.420938f, 1.755303f, 1.682985f, -1.673634f, 0.406971f, -0.721976f, -0.387847f, -1.736627f, 0.485306f, 1.875824f, -1.870031f, 0.183793f}, {-0.992067f, 0.466205f, -1.522683f, -0.729917f, -2.000273f, 0.464669f, 0.182162f, 0.132757f, -0.3266f, -0.045553f, 1.272179f, 0.166476f, -0.277496f, 0.497124f}, {1.734069f, 1.438779f, 0.799072f, -1.143207f, 1.481657f, -1.562397f, -1.14656f, 1.271447f, -1.496699f, 1.172474f, -1.698352f, -0.168012f, -1.611482f, -1.79372f}, {0.841812f, 1.710688f, 0.911015f, -1.269695f, -0.158938f, -0.033166f, -1.44895f, -1.741241f, 0.972093f, -0.056468f, -0.920769f, 0.744631f, 1.045933f, -1.612051f}, {1.184902f, 1.302638f, 1.003279f, 1.317602f, 1.650285f, -0.02964f, 1.780276f, -0.531506f, 1.501811f, 0.970135f, -0.155864f, 1.456083f, 0.661478f, 1.108473f}, {-1.361446f, -0.064152f, 1.75061f, 2.066826f, -1.152623f, 1.870224f, 1.372438f, -0.589616f, -0.463499f, 0.92037f, -1.651853f, 1.331157f, 0.701298f, -1.519484f}, {0.898406f, 0.176027f, -0.458153f, -1.569875f, 1.912663f, -0.586013f, -0.626167f, -0.371181f, 1.802448f, 1.18601f, 0.617579f, -1.224197f, -0.936158f, 0.882594f}, {2.187456f, 0.566056f, 0.098493f, 1.027576f, -1.399106f, -1.314667f, 0.745f, 1.566433f, 1.610075f, 1.509091f, -1.637754f, 0.734263f, 1.916469f, 0.744999f}, {-0.784666f, 0.433692f, 1.697661f, -1.204522f, -0.295657f, 0.37105f, -0.132493f, -1.16759f, -0.12074f, 0.183703f, 1.876729f, -0.217888f, -0.86364f, -1.030851f}, {-0.020073f, -0.095288f, 1.149367f, -0.237204f, -0.661128f, -0.92448f, -0.330569f, -0.462802f, 0.719193f, -0.346268f, 0.983999f, -1.579885f, 0.330631f, 0.626697f}, {-0.543568f, 0.043126f, 0.897751f, -0.987176f, -1.747336f, 0.180461f, 1.458666f, -0.161214f, 1.825932f, -0.099803f, 0.048254f, -0.173923f, 1.554528f, 0.437906f}}, {{1.030862f, 1.494175f, 1.854083f, 0.433502f, -1.244149f, -0.177413f, 1.853548f, 0.342622f, -0.161335f, 0.806758f, -1.224508f, 1.962623f, -1.316113f, -0.968128f}, {1.182015f, -0.493673f, -0.274392f, 1.859713f, 1.16299f, 1.597558f, -0.929055f, 0.074513f, -0.012734f, -1.13462f, -1.393091f, 0.62828f, -0.376437f, 1.919623f}, {0.956927f, 0.008556f, 0.081461f, 1.375825f, 0.952622f, 1.787896f, -1.314518f, 0.279569f, -0.201173f, -1.98152f, -1.909024f, 0.564521f, -1.154398f, -0.552763f}, {-1.473046f, 1.661687f, -0.464383f, 1.638357f, 1.466447f, 2.038591f, 1.292582f, -0.024505f, 0.392191f, 1.259251f, 1.525609f, 1.93614f, -1.869288f, 0.576986f}, {-2.14485f, -1.602699f, -0.796785f, 1.730253f, 1.102152f, 0.412377f, -0.741841f, -1.070062f, -1.499596f, -1.50885f, -1.455114f, 0.150791f, 1.900736f, -1.167039f}, {-0.177355f, -1.237028f, 0.646919f, -0.708596f, 2.072791f, -1.327939f, 2.035615f, 0.89371f, 0.522992f, 1.404281f, 0.23329f, -0.707851f, 0.71428f, -0.203896f}, {-1.147027f, -0.610005f, -0.888562f, -0.434547f, -0.519634f, 0.868448f, -1.58402f, -0.063825f, 0.767948f, 1.730597f, 0.474306f, 1.126299f, -0.485989f, 1.699083f}, {-1.361272f, -0.163877f, 1.20949f, 2.181023f, 0.014879f, -0.305501f, -0.932654f, 0.541721f, 0.482351f, -1.765082f, 1.737136f, -1.836442f, 0.569408f, 0.757974f}, {1.068153f, -0.09675f, 0.193472f, -2.155226f, -1.832376f, -1.569765f, -1.944857f, 1.268694f, 1.492559f, -1.674154f, 1.254063f, 0.27878f, -0.716466f, 0.396673f}, {0.419137f, -0.225414f, -0.083231f, 0.781133f, 1.318899f, 0.596805f, 1.580439f, 0.663883f, 0.926843f, 0.028027f, -0.652428f, 1.121702f, -1.112773f, 0.339501f}, {1.383512f, -0.093129f, 1.765286f, 0.900369f, -0.217845f, -0.069794f, -0.636725f, -0.605098f, -0.150269f, 1.885379f, 0.574459f, -1.28359f, 0.31294f, 2.015636f}, {1.711357f, -0.264424f, 1.793887f, -1.386957f, -0.319495f, 1.635078f, 1.520033f, 0.364152f, 0.164846f, -0.564431f, 1.676406f, -1.348068f, 1.133901f, 1.635149f}, {-1.561637f, -1.002891f, 1.425676f, -0.180076f, 1.496787f, 2.011862f, 1.262231f, -1.377565f, 0.888192f, 1.211833f, -1.260578f, -1.335416f, 1.012459f, -1.352876f}, {0.130632f, -1.108561f, -0.476437f, 0.906474f, -0.902135f, -1.131606f, 0.775499f, 0.86328f, 0.518427f, 1.605186f, -2.009333f, -0.168924f, -0.13012f, 1.281579f}}, {{0.530486f, 1.099758f, -1.73679f, 1.14794f, 1.261852f, -0.23329f, -1.230537f, 1.33419f, 0.929515f}, {-1.330891f, -0.594987f, 0.562276f, 1.116439f, 1.485371f, 0.530823f, -0.399283f, 0.262196f, 0.434452f}, {0.572956f, 0.304208f, 0.56343f, 0.187232f, -0.314636f, 1.80565f, -1.287541f, -0.788975f, 0.166182f}, {-1.492996f, -1.519277f, 1.366145f, 1.156144f, -1.72295f, 0.299146f, -1.247516f, -1.731438f, 0.441998f}, {-0.842359f, -0.352398f, 0.73449f, -1.619035f, 1.004758f, -0.664342f, -0.864391f, -1.501712f, -1.046859f}, {-0.837458f, 0.600696f, -1.201879f, 0.133458f, -1.476713f, 1.137689f, -1.317106f, 0.030529f, 0.494531f}, {-0.179234f, 1.146569f, -2.018785f, -2.03683f, -0.381189f, -0.27357f, -0.441311f, -0.008973f, -0.12092f}, {-1.31818f, 1.125177f, 0.727964f, 1.566036f, -1.40695f, 1.487654f, 0.905188f, 0.082268f, 0.500673f}, {-0.661933f, -0.565311f, 0.078021f, -1.056149f, -0.115333f, -1.855364f, -1.389045f, -1.060556f, -0.366315f}, {1.273061f, 0.356301f, -0.919291f, 0.479317f, -0.196511f, 1.653904f, -1.575325f, 0.259547f, -1.37294f}, {-0.887346f, -0.481434f, 0.967082f, -1.709739f, 1.860402f, -1.516198f, -0.51846f, 1.761312f, 1.992913f}, {0.373199f, -1.304461f, -0.751165f, -0.031873f, -0.30947f, 1.346441f, -0.957438f, -0.84389f, -1.315311f}, {1.345954f, 1.632447f, -0.775535f, 2.058052f, 0.663496f, -1.802597f, 0.660229f, 1.117159f, 0.278815f}, {1.698337f, 0.69256f, -1.398408f, 0.304804f, -0.585322f, -1.332411f, -1.398089f, -1.385171f, 1.362746f}}, {{}, {}, {}, {}, {}, {}, {}, {}, {}}};/*weights_end*/
/*biases_start*/final float[][] biases = {{0f, 0f, 0f, 0f, 0f, 0f, 0f, 0f, 0f, 0f, 0f, 0f, 0f, 0f, 0f, 0f, 0f, 0f, 0f, 0f, 0f, 0f, 0f, 0f, 0f}, {-1.535777f, -1.61314f, -1.124986f, 1.337737f, 0.078636f, -0.340361f, 1.763296f, -1.657818f, -0.230527f, -1.749556f, 0.828675f, 0.433522f, 1.267339f, -1.17328f}, {-1.144109f, -1.789776f, 1.173384f, -1.416779f, -0.795198f, 0.922821f, -0.558033f, 1.669066f, 0.283105f, 0.242696f, 1.297201f, 1.914148f, 1.435461f, 1.079059f}, {1.666048f, 1.633561f, -0.587028f, 0.579686f, 1.560855f, 0.892606f, -1.022276f, -0.802662f, -1.251361f}};/*biases_end*/

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
        communication.downloadMapBoundariesAndEnemyBase();
        communication.lookForMapBoundaries();

        UnitInfo nearestEnemyOrNeutral = getNearestEnemyOrNeutral(true, false);

        if(nearestEnemyOrNeutral != null) {
            if(loggingOn) uc.println("nearestEnemyOrNeutral " + nearestEnemyOrNeutral.getLocation());
            int damage = tryAttack(nearestEnemyOrNeutral.getLocation());
            if(damage != 0)
                communication.addScore(damage);
        }

        if(uc.canMove()) {
            if(loggingOn) uc.println("start (" + uc.getEnergyUsed() + " energy)");
            float[] inputData = getInputData(nearestEnemyOrNeutral);
            if(loggingOn) uc.println("inputData " + Arrays.toString(inputData) + " (" + uc.getEnergyUsed() + " energy)");
            float[] outputs = forwardPropagate(inputData);
            if(loggingOn) uc.println("outputs " + Arrays.toString(outputs) + " (" + uc.getEnergyUsed() + " energy)");
            Direction outputDirection = getDirectionFromOutputs(outputs);
            if(loggingOn) uc.println("outputDirection " + outputDirection + " (" + uc.getEnergyUsed() + " energy)");
            if(!tryMove(outputDirection))
                communication.addScore(-10);
        }
    }

    float[] getInputData(UnitInfo nearestEnemyOrNeutral) {
        Location selfLocation = uc.getLocation();

        int canMoveDirectionNorth = uc.canMove(Direction.NORTH) ? 1 : 0;
        int canMoveDirectionNorthEast = uc.canMove(Direction.NORTHEAST) ? 1 : 0;
        int canMoveDirectionEast = uc.canMove(Direction.EAST) ? 1 : 0;
        int canMoveDirectionSouthEast = uc.canMove(Direction.SOUTHEAST) ? 1 : 0;
        int canMoveDirectionSouth = uc.canMove(Direction.SOUTH) ? 1 : 0;
        int canMoveDirectionSouthWest = uc.canMove(Direction.SOUTHWEST) ? 1 : 0;
        int canMoveDirectionWest = uc.canMove(Direction.WEST) ? 1 : 0;
        int canMoveDirectionNorthWest = uc.canMove(Direction.NORTHWEST) ? 1 : 0;

        float selfHealth = (float)Math.log(uc.getInfo().getHealth());

//        float allyBaseDistance = Math.log(Math.sqrt(selfLocation.distanceSquared(communication.allyBaseLocation)));

        int nearestEnemyOrNeutralExists = 0;

        int nearestEnemyOrNeutralDirectionNorth = 0;
        int nearestEnemyOrNeutralDirectionNorthEast = 0;
        int nearestEnemyOrNeutralDirectionEast = 0;
        int nearestEnemyOrNeutralDirectionSouthEast = 0;
        int nearestEnemyOrNeutralDirectionSouth = 0;
        int nearestEnemyOrNeutralDirectionSouthWest = 0;
        int nearestEnemyOrNeutralDirectionWest = 0;
        int nearestEnemyOrNeutralDirectionNorthWest = 0;

        float nearestEnemyOrNeutralHealth = 0;
        float nearestEnemyOrNeutralAttackDamage = 0;

        int nearestEnemyOrNeutralSelfCloseEnoughToAttack = 0;
        int nearestEnemyOrNeutralCanSeeSelf = 0;
        int nearestEnemyOrNeutralCloseEnoughToAttackSelf = 0;

        int nearestEnemyOrNeutralCanMoveNextTurn = 0;
        int nearestEnemyOrNeutralCanAttackNextTurn = 0;

        if(nearestEnemyOrNeutral != null) {
            Location nearestEnemyOrNeutralLocation = nearestEnemyOrNeutral.getLocation();
            int distanceToNearestEnemyOrNeutral = selfLocation.distanceSquared(nearestEnemyOrNeutralLocation);
            UnitType nearestEnemyOrNeutralType = nearestEnemyOrNeutral.getType();

            nearestEnemyOrNeutralExists = 1;

            int nearestEnemyOrNeutralRelativeLocationX = nearestEnemyOrNeutralLocation.x - selfLocation.x;
            int nearestEnemyOrNeutralRelativeLocationY = nearestEnemyOrNeutralLocation.y - selfLocation.y;
            if(nearestEnemyOrNeutralRelativeLocationX == 0) {
                if(nearestEnemyOrNeutralRelativeLocationY > 0)
                    nearestEnemyOrNeutralDirectionNorth = 1;
                else
                    nearestEnemyOrNeutralDirectionSouth = 1;
            }
            else if(nearestEnemyOrNeutralRelativeLocationY == 0) {
                if(nearestEnemyOrNeutralRelativeLocationX > 0)
                    nearestEnemyOrNeutralDirectionEast = 1;
                else
                    nearestEnemyOrNeutralDirectionWest = 1;
            }
            else {
                if(nearestEnemyOrNeutralRelativeLocationX > 0 && nearestEnemyOrNeutralRelativeLocationY > 0)
                    nearestEnemyOrNeutralDirectionNorthEast = 1;
                else if(nearestEnemyOrNeutralRelativeLocationX > 0)
                    nearestEnemyOrNeutralDirectionSouthEast = 1;
                else if(nearestEnemyOrNeutralRelativeLocationY < 0)
                    nearestEnemyOrNeutralDirectionSouthWest = 1;
                else
                    nearestEnemyOrNeutralDirectionNorthWest = 1;
            }

            nearestEnemyOrNeutralHealth = (float)Math.log(nearestEnemyOrNeutral.getHealth());
            nearestEnemyOrNeutralAttackDamage = (float)Math.log(nearestEnemyOrNeutralType.getStat(UnitStat.ATTACK));

            if(distanceToNearestEnemyOrNeutral <= selfAttackRange && distanceToNearestEnemyOrNeutral >= selfMinAttackRange)
                nearestEnemyOrNeutralSelfCloseEnoughToAttack = 1;

            float nearestEnemyOrNeutralVisionRange = nearestEnemyOrNeutralType.getStat(UnitStat.VISION_RANGE);
            if(distanceToNearestEnemyOrNeutral <= nearestEnemyOrNeutralVisionRange)
                nearestEnemyOrNeutralCanSeeSelf = 1;

            float nearestEnemyOrNeutralAttackRange = nearestEnemyOrNeutralType.getStat(UnitStat.ATTACK_RANGE);
            float nearestEnemyOrNeutralMinAttackRange = nearestEnemyOrNeutralType.getStat(UnitStat.MIN_ATTACK_RANGE);
            if(distanceToNearestEnemyOrNeutral <= nearestEnemyOrNeutralAttackRange && distanceToNearestEnemyOrNeutral >= nearestEnemyOrNeutralMinAttackRange)
                nearestEnemyOrNeutralCloseEnoughToAttackSelf = 1;

            float nearestEnemyOrNeutralMoveCooldown = nearestEnemyOrNeutral.getCurrentMovementCooldown();
            if(nearestEnemyOrNeutralMoveCooldown <= 1)
                nearestEnemyOrNeutralCanMoveNextTurn = 1;

            float nearestEnemyOrNeutralAttackCooldown = nearestEnemyOrNeutral.getCurrentAttackCooldown();
            if(nearestEnemyOrNeutralAttackCooldown <= 1)
                nearestEnemyOrNeutralCanAttackNextTurn = 1;
        }

        return new float[]{
                canMoveDirectionNorth, canMoveDirectionNorthEast,
                canMoveDirectionEast, canMoveDirectionSouthEast,
                canMoveDirectionSouth, canMoveDirectionSouthWest,
                canMoveDirectionWest, canMoveDirectionNorthWest,
                selfHealth, nearestEnemyOrNeutralExists,
                nearestEnemyOrNeutralDirectionNorth, nearestEnemyOrNeutralDirectionNorthEast,
                nearestEnemyOrNeutralDirectionEast, nearestEnemyOrNeutralDirectionSouthEast,
                nearestEnemyOrNeutralDirectionSouth, nearestEnemyOrNeutralDirectionSouthWest,
                nearestEnemyOrNeutralDirectionWest, nearestEnemyOrNeutralDirectionNorthWest,
                nearestEnemyOrNeutralHealth, nearestEnemyOrNeutralAttackDamage,
                nearestEnemyOrNeutralSelfCloseEnoughToAttack, nearestEnemyOrNeutralCanSeeSelf,
                nearestEnemyOrNeutralCloseEnoughToAttackSelf,
                nearestEnemyOrNeutralCanMoveNextTurn, nearestEnemyOrNeutralCanAttackNextTurn
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
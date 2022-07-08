package wtest_evolution;

import aic2022.user.*;
import java.util.Arrays;

public class Troop extends AllyUnit {
    int lastTurnHealth;

    Troop(UnitController uc) {
        super(uc);
    }

    // x input -> 14 hidden -> 14 hidden -> 9 output
    final int[] LAYER_SIZES = {25, 14, 14, 9};
    // Weights are outgoing weights
/*weights_start*/final float[][][] weights = {{{-2.096899f, 2.072407f, -1.365645f, -1.502283f, -0.849375f, 0.002783f, -0.274014f, -1.140447f, 1.074852f, -0.52688f, -0.979536f, -1.665738f, -1.35681f, 0.33253f}, {1.410303f, -0.137755f, 0.022455f, 1.041803f, 1.782425f, -1.545798f, 1.813612f, -0.53528f, 0.437238f, -0.829273f, -0.752779f, 0.34406f, 1.584695f, 0.76161f}, {-0.171321f, -1.660718f, -1.368683f, -1.975913f, 1.5359f, -0.178471f, -1.452499f, 0.343511f, 0.847658f, 0.890185f, -1.471692f, 1.584429f, 0.250342f, 0.788543f}, {1.877046f, -1.096975f, -1.140913f, 1.589813f, 1.043075f, 1.73975f, -1.487313f, 1.463955f, -0.76415f, -0.55386f, 0.07398f, 0.612014f, -1.056319f, -0.957323f}, {-0.350099f, -1.628824f, -1.104988f, 1.741566f, -0.701133f, -0.087904f, 1.230418f, -1.864504f, -0.213472f, -0.755419f, 2.10887f, -0.909333f, -1.225542f, 0.121143f}, {0.714715f, -0.316899f, -0.014872f, -1.539685f, 1.431625f, -0.712871f, 1.52715f, 0.925436f, -0.042221f, 0.195007f, 0.559179f, -0.478885f, -1.423859f, -0.449478f}, {0.824495f, 1.375567f, 1.677404f, 1.429915f, -0.024502f, -1.669835f, -0.4864f, -1.153947f, -0.161568f, -0.134512f, -1.84273f, 0.98391f, 1.454156f, -1.920018f}, {-1.346f, 1.78977f, -1.008428f, 0.258684f, 1.122991f, -1.171576f, -1.132261f, -0.540814f, -0.520318f, 1.149814f, 1.47161f, 1.699809f, 1.187804f, -0.039415f}, {-0.136776f, -1.589974f, -1.528411f, 1.836475f, -0.779862f, 2.322821f, -0.165889f, -0.092853f, -0.457788f, 0.565605f, 1.521653f, -0.415853f, 0.51534f, -0.610424f}, {2.065302f, -1.830981f, 0.112819f, 0.085964f, -1.249507f, -1.770875f, -1.660905f, 0.886606f, 0.270759f, -0.77158f, 1.8087f, 0.876524f, -1.175441f, -1.042844f}, {-1.253995f, 1.934098f, -0.043383f, 1.400778f, -0.176882f, 0.131069f, 0.061542f, -0.936572f, -0.406292f, 1.046134f, -0.794577f, -1.087144f, 0.631294f, 0.454829f}, {-1.972081f, -0.704197f, 1.027749f, -1.005866f, 1.62078f, 0.778989f, 0.914245f, 1.560277f, -0.059354f, -0.400415f, 1.611435f, -0.028124f, -1.301975f, -1.639155f}, {0.39519f, 2.12024f, -1.384409f, -1.158696f, -0.783555f, 1.244061f, 0.822941f, -0.936477f, 0.894782f, -1.383943f, 0.698959f, -0.663478f, -0.786437f, -1.44976f}, {-1.940021f, 0.57966f, 0.047293f, 1.239492f, 1.405908f, 0.390568f, -1.789873f, -1.607486f, -0.042115f, -0.437756f, 0.006907f, 0.023224f, -1.273662f, 0.958563f}, {-1.26641f, 1.251187f, 0.116193f, -1.387482f, 1.087217f, 1.686981f, -1.827541f, -1.781715f, 0.459557f, 1.468548f, -0.327619f, 0.984304f, 0.114875f, 0.944962f}, {-0.751419f, -0.491041f, -2.082371f, 1.872678f, 1.004542f, 0.235597f, 1.137131f, 1.959798f, 1.193218f, 0.634988f, -1.313539f, -0.784056f, 1.666686f, 1.136696f}, {-0.884809f, -1.213082f, 0.316784f, 1.706297f, 0.790132f, -0.242742f, -0.843325f, -0.652545f, -0.05877f, 1.164048f, 0.912321f, -1.858097f, -0.203539f, 0.027551f}, {-1.856183f, 0.105971f, 0.194417f, -0.499865f, 0.304448f, 0.799054f, 0.21017f, 1.706958f, -1.003226f, 0.886372f, 1.625895f, 0.606023f, -0.235622f, -1.714734f}, {-1.965943f, -0.681575f, -0.823032f, 1.360251f, 0.500731f, -0.091277f, -1.479025f, 1.650041f, 1.710509f, -0.430069f, 0.717162f, -2.031682f, -0.721341f, 0.807404f}, {-0.911935f, 0.491597f, 0.337013f, -1.350634f, -0.963454f, 0.996873f, 0.41112f, 0.052075f, -2.087938f, -0.033118f, 0.539915f, -0.207081f, -0.597943f, 1.170559f}, {-1.228458f, -0.507401f, 1.287952f, 0.587132f, 0.782929f, 0.408587f, 1.932245f, -0.109579f, -0.584282f, -1.680603f, 0.940562f, 1.786805f, -1.55237f, 1.527214f}, {-1.483722f, 1.04305f, 1.326099f, 1.254279f, -0.052657f, -0.334024f, 1.658237f, -1.34635f, 2.069909f, 0.960238f, -0.219799f, -1.748573f, -0.075732f, 1.038754f}, {-0.506998f, 0.076381f, 0.718893f, 1.505948f, 1.692638f, 0.475474f, -1.909346f, 0.180004f, 0.410484f, -0.74144f, -1.06977f, 1.375425f, 0.462745f, 0.66631f}, {0.644089f, -1.393504f, -1.73452f, 1.481985f, -1.398309f, -1.128959f, 1.05631f, -0.690554f, 1.88037f, -1.626523f, 1.17286f, -0.148207f, 0.242548f, 1.564674f}, {1.318455f, 1.800996f, -0.224836f, -1.057673f, -2.311926f, -1.39721f, -0.479866f, -1.705731f, 1.74076f, -0.608243f, 0.840501f, 0.926065f, -0.68417f, 1.474358f}}, {{1.038354f, 1.440836f, -1.578146f, -0.123335f, 1.741659f, 0.347337f, -1.913129f, 1.634391f, -0.806929f, 1.438471f, -1.302505f, 1.396475f, 1.93032f, -0.183313f}, {1.476685f, -1.392177f, 1.065825f, 0.560049f, -1.856192f, -1.710671f, -0.678038f, -1.095747f, 0.750195f, -1.145903f, -1.947262f, -1.528084f, -0.822026f, 0.284043f}, {0.778427f, 1.951749f, 1.545117f, 1.279405f, 1.575642f, 0.283339f, -1.440771f, -1.001466f, 1.527087f, -1.545067f, 0.445304f, -1.251646f, 1.384268f, -0.653626f}, {-0.743805f, 0.454883f, -2.423509f, 0.707666f, -2.062698f, 0.47735f, -0.189021f, 0.208544f, 1.302105f, 1.178817f, 0.016643f, 0.451936f, 0.549868f, 1.023153f}, {1.24529f, 0.744056f, -1.922084f, 1.686013f, -1.069749f, 0.206698f, -1.081801f, -1.776656f, 0.55219f, -0.73613f, 0.25766f, -1.198057f, 0.019095f, -0.499957f}, {-0.977981f, 1.452907f, -2.111295f, -1.039611f, -1.772871f, 0.055206f, -1.58459f, 1.1795f, -0.02743f, 1.424138f, -1.01976f, 1.882865f, -0.02311f, -0.758819f}, {0.121335f, -1.036173f, 0.386491f, -0.54176f, -1.461817f, 1.11349f, 1.760747f, -1.251576f, 1.295501f, 0.650738f, -1.822232f, -0.466314f, -1.541818f, -1.561756f}, {1.478502f, 1.043416f, -1.221518f, 1.568788f, 1.128156f, 1.296874f, -1.063655f, 1.3005f, -1.816306f, -1.08571f, -1.392271f, -0.900244f, 1.855281f, 0.049623f}, {0.200183f, 1.608122f, -1.014365f, 1.505804f, -0.834055f, -1.146001f, 1.851781f, 0.426868f, 0.992579f, 0.851641f, -0.647235f, -1.079237f, 0.171823f, -1.8847f}, {-1.130884f, -1.886827f, -0.891622f, 0.699921f, 1.770872f, 1.991273f, -1.907883f, 2.056034f, -1.229425f, -1.499257f, 1.000402f, -1.978464f, -1.479131f, -0.71373f}, {0.105119f, 1.681448f, 2.098245f, 0.720195f, -1.350187f, -0.982725f, 1.516529f, -0.74079f, 0.3987f, -0.034679f, 0.994673f, 0.101019f, 1.046509f, -0.836094f}, {-0.120607f, 0.656157f, -0.443109f, -0.074234f, 1.782673f, 1.403545f, -2.314828f, -0.840525f, 1.500607f, 0.209891f, 1.814383f, 0.843078f, 1.888026f, 1.683021f}, {0.403332f, 0.274207f, 0.534382f, 1.861599f, 0.197385f, -0.112777f, -2.06615f, 1.132744f, -1.258046f, -0.992034f, -0.384325f, 1.597302f, 0.807332f, -1.880533f}, {-0.007034f, -1.172959f, -0.250616f, 0.970137f, -0.778214f, 0.147034f, 0.433941f, 0.670507f, 1.889812f, -1.866012f, 1.850193f, 1.590822f, 0.236208f, 0.446152f}}, {{-0.552541f, -0.942973f, 2.195274f, 0.456349f, -1.888609f, 1.024619f, 1.871389f, 1.980675f, 1.018642f}, {-1.742936f, -0.460266f, -0.020061f, -1.097719f, -2.18578f, 1.890363f, -1.086933f, 2.067722f, -0.981564f}, {0.907445f, 0.013115f, 0.375496f, -1.278936f, 1.187697f, 0.453409f, -1.513387f, -0.935664f, -0.326491f}, {-0.445009f, -0.69413f, 1.020875f, 0.383587f, -0.520422f, 0.83659f, -1.703669f, 1.170109f, -0.547952f}, {-0.06298f, -1.510017f, 0.858685f, -0.483075f, -0.224239f, -0.254125f, 1.661273f, 0.759556f, -1.545842f}, {0.875862f, -1.498177f, -1.573523f, 0.039648f, -1.067844f, 0.354717f, 0.871103f, -1.069298f, -1.498239f}, {0.736201f, -0.662258f, -1.005234f, 1.625378f, -0.767854f, 1.553559f, -0.997093f, -0.303481f, 0.370791f}, {-0.658891f, -0.270237f, 1.948575f, -0.915862f, -0.734785f, 0.930542f, -0.396307f, -0.641116f, 0.804157f}, {-1.404132f, 2.120836f, 2.179051f, 0.342381f, -0.603888f, -1.1471f, -0.115065f, 0.487105f, -1.716942f}, {-1.459741f, 1.285222f, -1.329442f, 1.809948f, 0.566018f, 0.680561f, -1.805651f, 1.863071f, -0.11458f}, {1.271405f, 0.752894f, 1.251343f, -0.173484f, 1.46057f, 0.931926f, 1.155163f, -0.346919f, 1.088471f}, {-1.733858f, 0.246344f, 1.404381f, 1.477389f, -1.037525f, 0.429116f, -0.14748f, -1.136863f, -1.160886f}, {-0.521532f, 0.361375f, -1.77089f, 0.140578f, 0.050589f, -1.82891f, -0.571172f, 1.592401f, -2.371279f}, {0.123932f, -0.503151f, 1.131358f, -1.517378f, 1.674065f, -1.416471f, 2.607659f, -1.500833f, 0.621347f}}, {{}, {}, {}, {}, {}, {}, {}, {}, {}}};/*weights_end*/
/*biases_start*/final float[][] biases = {{0f, 0f, 0f, 0f, 0f, 0f, 0f, 0f, 0f, 0f, 0f, 0f, 0f, 0f, 0f, 0f, 0f, 0f, 0f, 0f, 0f, 0f, 0f, 0f, 0f}, {-1.734021f, -1.257518f, 1.622804f, -1.655305f, 0.315051f, -0.758688f, 0.379325f, 1.25783f, 0.90239f, -1.273725f, -0.350896f, 0.117129f, -0.854934f, -1.408192f}, {0.545638f, 2.093708f, -1.992798f, -0.401686f, 1.152863f, 0.51123f, 1.059624f, 0.452788f, 1.056289f, 0.690706f, 0.030895f, 0.687978f, -0.375552f, 1.085943f}, {2.154565f, 1.031577f, -2.169872f, -1.124105f, -0.628293f, -0.460058f, 0.327396f, 0.569459f, 1.711272f}};/*biases_end*/

    void runFirstTurn() {
        lastTurnHealth = uc.getInfo().getHealth();

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
//        communication.downloadMapBoundariesAndEnemyBase();
//        communication.lookForMapBoundaries();

        communication.addAllyAlive();

        int health = uc.getInfo().getHealth();
        int tookDamage = lastTurnHealth - health;
        if(tookDamage != 0) {
            communication.addScore(-tookDamage);
            lastTurnHealth = health;
        }

        UnitInfo nearestEnemyOrNeutral = getNearestEnemyOrNeutral(false, true);

        if(nearestEnemyOrNeutral != null) {
            if(loggingOn) uc.println("nearestEnemyOrNeutral " + nearestEnemyOrNeutral.getLocation());
            int damage = tryAttack(nearestEnemyOrNeutral.getLocation());
            if(damage != 0)
                communication.addScore(damage * 100);
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
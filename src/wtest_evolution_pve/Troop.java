package wtest_evolution_pve;

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
/*weights_start*/final float[][][] weights = {{{0.363692f, 1.698777f, -1.077832f, -0.06134f, 1.630909f, 0.683208f, 0.252082f, -0.046718f, 0.038299f, 1.181289f, -0.55354f, 0.30303f, -0.066558f, -1.580749f}, {-1.340064f, -1.327435f, 1.428725f, -1.801468f, 0.507899f, -0.64134f, -0.073146f, 1.515494f, -0.075408f, 2.258409f, 0.680502f, 1.9119f, 0.219265f, 1.740371f}, {-0.421098f, 2.073878f, -0.53827f, -1.365489f, -1.56724f, 1.490135f, 0.674772f, 1.769475f, 1.199528f, -0.364401f, 2.164993f, 1.044118f, 0.238153f, 0.119963f}, {0.233262f, -0.637994f, -0.775561f, -0.53832f, 0.91407f, 0.481103f, -0.213986f, 0.334197f, 2.062974f, 0.246593f, 1.5876f, -1.146008f, 0.27659f, 0.220203f}, {-1.534395f, 0.56669f, 2.064155f, 2.100357f, 0.881249f, -0.044655f, 0.503324f, -0.035913f, 1.720153f, -1.960739f, -2.004954f, -0.494521f, -0.512209f, 0.550916f}, {1.451829f, 0.07143f, 0.013846f, -0.951189f, -1.395171f, -1.765583f, -1.089843f, -2.012782f, -0.818396f, 0.550464f, 0.160583f, 0.484131f, -1.368177f, 2.257992f}, {2.069445f, -0.758795f, -1.974569f, -0.631704f, 0.580362f, -0.827006f, -1.31289f, -1.656025f, 1.68743f, -0.797533f, 0.360992f, 0.230474f, -1.595576f, 0.965438f}, {-0.933153f, -0.950218f, 0.751496f, 0.372175f, -1.614645f, -0.641744f, -0.861925f, -0.339995f, 1.450205f, -0.873324f, 0.930432f, -0.554244f, 0.063158f, -0.724081f}, {1.274746f, -1.759178f, -0.297778f, -1.602072f, -0.029807f, 0.375352f, 1.602666f, 1.104951f, -1.744814f, -0.419339f, 0.319994f, -1.806116f, 1.534189f, -1.793272f}, {-0.336033f, 1.585806f, -1.026273f, 1.735386f, -0.20211f, 1.386609f, 1.81451f, -0.659888f, 1.312669f, -0.38156f, -1.01512f, -0.229392f, -0.623453f, 0.196521f}, {0.637568f, 1.026318f, 2.207366f, -0.726255f, 0.167939f, 0.331507f, -0.994759f, -0.568064f, -1.033345f, 1.539865f, 1.145839f, -0.296738f, -0.764931f, -1.127079f}, {-2.050035f, -0.896365f, -1.00291f, 0.370532f, 0.940992f, -1.407962f, 2.084156f, -1.348841f, 0.313674f, -1.409401f, 1.933725f, 0.649803f, 1.098722f, 0.349053f}, {-0.537245f, 1.097383f, -0.531158f, -0.587331f, 0.262874f, 1.608508f, -0.244546f, -1.333327f, -1.853698f, -0.873712f, -1.19702f, -0.549032f, -1.654234f, 2.054946f}, {1.28017f, -0.019734f, 1.347537f, -0.184508f, 0.256001f, 1.157827f, -0.770552f, -1.189454f, -0.444999f, -1.353024f, -0.382031f, -1.506261f, -1.692316f, -0.110635f}, {1.157208f, -1.411391f, 1.389064f, 1.693909f, 1.913039f, -1.80408f, 0.270727f, -0.801662f, -0.432012f, -1.370577f, 0.645913f, 1.797243f, -1.973906f, -0.379506f}, {-1.328702f, 0.729708f, -1.802408f, -0.696645f, -2.037215f, 0.095081f, 0.163045f, 0.031864f, -0.241926f, -0.24139f, 1.433616f, 0.274847f, -0.181423f, 0.378451f}, {1.375131f, 1.38207f, 0.549688f, -0.905149f, 1.444629f, -1.682723f, -1.20322f, 1.248282f, -1.878875f, 0.989365f, -1.442787f, -0.221038f, -1.343402f, -1.54148f}, {0.733254f, 2.237967f, 0.768747f, -1.233214f, 0.094925f, 0.078611f, -1.684077f, -1.764396f, 0.711401f, -0.161297f, -1.066531f, 0.660523f, 0.944051f, -1.72647f}, {0.972462f, 1.690716f, 0.976175f, 1.357712f, 1.705742f, 0.002423f, 1.913455f, -0.14087f, 1.102062f, 0.716495f, -0.172474f, 1.617892f, 0.561801f, 1.298704f}, {-1.217015f, -0.066617f, 1.47397f, 1.946664f, -1.15366f, 1.628502f, 1.307818f, -0.511406f, -0.632089f, 0.9239f, -1.283931f, 1.767328f, 0.997195f, -1.483715f}, {0.648359f, 0.426576f, -0.625453f, -1.7301f, 1.870146f, -0.620532f, -0.70697f, -0.343284f, 1.944649f, 0.911094f, 0.445304f, -1.164642f, -0.986808f, 0.770506f}, {1.623116f, 0.473287f, 0.180919f, 1.038213f, -1.655939f, -1.357398f, 0.758526f, 1.636813f, 1.495864f, 1.567611f, -1.975354f, 0.66177f, 1.689466f, 1.126383f}, {-0.459728f, 0.391313f, 1.504517f, -1.10375f, -0.491555f, 0.605542f, -0.293062f, -1.161033f, 0.053808f, 0.429683f, 1.784568f, 1.6e-05f, -0.894351f, -1.07148f}, {0.159607f, -0.352092f, 1.1384f, 0.012322f, -0.637796f, -0.611673f, 0.003353f, -0.326306f, 0.606058f, -0.379115f, 0.855614f, -1.28149f, 0.809874f, 0.631821f}, {-0.74649f, -0.315632f, 0.829655f, -1.208497f, -1.785365f, -0.251108f, 1.356239f, 0.093165f, 1.649247f, -0.177391f, -0.178049f, -0.109366f, 1.767986f, 0.029685f}}, {{1.092577f, 1.643164f, 1.967166f, 0.51784f, -1.163614f, -0.082471f, 1.724643f, 0.434803f, -0.002919f, 0.259332f, -1.458777f, 1.804518f, -1.341851f, -0.804254f}, {0.866903f, -0.552961f, -0.304876f, 1.871883f, 0.977632f, 1.804887f, -0.747421f, -0.069461f, 0.24286f, -1.295615f, -1.089822f, 0.417946f, -0.270013f, 1.659094f}, {0.889501f, 0.202512f, 0.248567f, 1.260817f, 0.847924f, 1.570241f, -1.538529f, 0.352551f, -0.047753f, -1.717191f, -2.212414f, 0.889385f, -1.28974f, -0.974312f}, {-1.253618f, 1.859591f, -0.458385f, 1.663251f, 1.794818f, 1.644858f, 1.090664f, 0.062865f, 0.042105f, 1.045704f, 1.490614f, 2.099821f, -1.954279f, 0.43644f}, {-1.795395f, -1.754588f, -0.817389f, 2.04908f, 1.027925f, 0.510873f, -0.494261f, -0.586563f, -1.78238f, -1.036471f, -1.532639f, -0.400561f, 1.681284f, -1.15562f}, {0.221686f, -1.063354f, 0.820128f, -0.601448f, 2.009434f, -1.368268f, 2.083945f, 0.963789f, 0.602345f, 1.757614f, 0.334493f, -0.701775f, 0.738929f, -0.307011f}, {-1.22316f, -0.815891f, -0.976664f, -0.084526f, -0.525573f, 0.718475f, -1.707847f, -0.035767f, 0.459697f, 1.325925f, 0.655483f, 0.703739f, -0.705417f, 1.82332f}, {-1.409108f, -0.141728f, 1.168623f, 1.937415f, 0.159867f, -0.390512f, -0.755127f, 0.572358f, -0.117154f, -1.688875f, 1.334542f, -1.80468f, 0.623406f, 0.782597f}, {1.138053f, 0.055393f, -0.022942f, -1.660538f, -1.683888f, -1.384616f, -1.930801f, 1.194298f, 1.65899f, -1.864874f, 1.423779f, 0.051534f, -0.917473f, 0.164916f}, {0.93051f, 0.135491f, 0.113996f, 0.778535f, 1.282472f, 0.464364f, 1.681915f, 0.690475f, 0.958386f, -0.099724f, -0.421984f, 1.107418f, -0.88948f, 0.311901f}, {0.998766f, -0.061954f, 1.894148f, 0.592724f, 0.07059f, -0.563625f, -0.211655f, -0.502848f, 0.045382f, 1.688136f, 0.658737f, -1.019393f, 0.396748f, 1.778238f}, {1.621607f, -0.14755f, 1.665093f, -1.471593f, -0.449083f, 1.479976f, 1.681554f, 0.382978f, 0.175736f, -0.245757f, 1.928374f, -1.330725f, 1.152743f, 1.817581f}, {-1.643322f, -1.138039f, 0.992053f, -0.566777f, 1.751511f, 1.863479f, 1.554448f, -1.178721f, 0.96552f, 1.427055f, -1.005256f, -1.439268f, 1.242279f, -1.31801f}, {0.353995f, -1.129437f, -0.414954f, 0.848142f, -1.070666f, -0.874387f, 0.971294f, 0.768354f, 0.885569f, 1.775387f, -1.643182f, -0.224543f, -0.207364f, 0.996606f}}, {{0.909856f, 1.27754f, -1.701478f, 0.741967f, 0.992689f, -0.349511f, -1.174646f, 1.333347f, 0.771448f}, {-1.041012f, -0.5474f, 1.020094f, 0.607252f, 1.586647f, 0.905414f, -0.268966f, 0.448363f, 0.188449f}, {0.406539f, 0.522372f, 0.834478f, 0.431276f, 0.097998f, 1.768422f, -1.399609f, -1.074472f, -0.104363f}, {-1.392768f, -1.597244f, 1.561843f, 1.233902f, -1.55727f, -0.153764f, -1.045635f, -1.804581f, 0.537322f}, {-0.428517f, -0.433004f, 0.836737f, -1.496554f, 1.096367f, -0.72816f, -1.262975f, -1.4365f, -0.751955f}, {-0.673885f, 0.613374f, -0.918362f, 0.269171f, -1.383948f, 1.633583f, -1.457401f, -0.511196f, 0.626031f}, {-0.093328f, 1.152798f, -1.899364f, -2.047926f, -0.233523f, -0.394709f, -0.525886f, 0.042329f, -0.14721f}, {-1.06788f, 0.991142f, 0.657898f, 1.584456f, -1.639863f, 1.174152f, 0.889251f, -0.065969f, 0.14834f}, {-0.534441f, -0.725203f, 0.031169f, -1.232584f, -0.431791f, -1.821371f, -1.519362f, -1.056819f, -0.261899f}, {1.102635f, 0.142944f, -0.857947f, 0.759975f, 0.058198f, 2.027313f, -1.95022f, 0.083873f, -1.552133f}, {-1.253036f, -0.482244f, 0.96546f, -2.106123f, 1.718554f, -1.455812f, -0.679188f, 1.6768f, 2.133998f}, {0.751645f, -1.699776f, -0.886602f, -0.414609f, -0.911751f, 1.576927f, -1.164564f, -1.653947f, -1.691151f}, {1.304863f, 1.531209f, -0.974417f, 1.879488f, 0.501297f, -1.867184f, 0.454758f, 0.953386f, 0.13585f}, {1.516292f, 0.392618f, -1.41957f, 0.335805f, -0.458125f, -1.003443f, -1.260576f, -1.145422f, 1.170808f}}, {{}, {}, {}, {}, {}, {}, {}, {}, {}}};/*weights_end*/
/*biases_start*/final float[][] biases = {{0f, 0f, 0f, 0f, 0f, 0f, 0f, 0f, 0f, 0f, 0f, 0f, 0f, 0f, 0f, 0f, 0f, 0f, 0f, 0f, 0f, 0f, 0f, 0f, 0f}, {-1.421509f, -1.528216f, -0.778618f, 1.76781f, -0.211017f, -0.184402f, 1.842517f, -1.82448f, -0.071874f, -1.585647f, 0.919828f, 0.402662f, 1.248381f, -1.256898f}, {-0.999377f, -1.762741f, 0.767132f, -1.399939f, -0.771167f, 0.480092f, -1.094382f, 1.999394f, 0.386853f, 0.028075f, 0.999463f, 1.914799f, 1.236624f, 0.975516f}, {1.267083f, 1.671898f, -0.60591f, 0.362785f, 1.30263f, 1.048514f, -0.979932f, -1.096527f, -1.04778f}};/*biases_end*/

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
            communication.addScore(-tookDamage * 10);
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
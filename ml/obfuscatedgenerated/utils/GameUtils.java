package ml.obfuscatedgenerated.utils;

/**
 * Utils for game development.
 * 
 * @author @author obfuscatedgenerated
 * @version 1.0.0
 */

public class GameUtils {
    private static double initTime = System.currentTimeMillis();
    private static double deltaTime = 0;

    public static void init () {
        initTime = System.currentTimeMillis();
        deltaTime = 0;
    }

    public static void update() { // IMPORTANT: call this every frame
        double nowTime = System.currentTimeMillis();
        deltaTime = (nowTime - initTime) / 1000;
	    initTime = nowTime;
    }

    public static double getDelta() {
        return deltaTime;
    }

    public static float invSqrt(float x) { // the FISR, as in Quake III Arena
        float xhalf = 0.5f * x;
        int i = Float.floatToIntBits(x);
        i = 0x5f3759df - (i >> 1);
        x = Float.intBitsToFloat(i);
        x *= (1.5f - xhalf * x * x);
        return x;
    }
}

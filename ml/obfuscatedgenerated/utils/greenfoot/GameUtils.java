package ml.obfuscatedgenerated.utils.greenfoot;

import greenfoot.*;

import java.util.Map;
import java.util.HashMap;

/**
 * Utils for game development.
 * 
 * @author @author obfuscatedgenerated
 * @version 1.0.0
 */

public class GameUtils extends Actor {
    private static double initTime = System.currentTimeMillis();
    private static double deltaTime = 0;
    private static Map<Actor,Double> exactX = new HashMap<>();
    private static Map<Actor,Double> exactY = new HashMap<>();
    
    public static void setExactLocation(Actor object, double x, double y) {
        exactX.put(object,x);
        exactY.put(object,y);
        object.setLocation((int) x, (int) y);
    }
    
    public static double getExactX(Actor object) {
        if (exactX.containsKey(object)) {
            return exactX.get(object);
        } else {
            return object.getX();
        }
    }
    
    public static double getExactY(Actor object) {
        if (exactY.containsKey(object)) {
            return exactY.get(object);
        } else {
            return object.getY();
        }
    }

    public static void update() {
        double nowTime = System.currentTimeMillis();
        deltaTime = (nowTime - initTime) / 1000;
        initTime = nowTime;
    }

    public static double getDelta() {
        return deltaTime;
    }
}

// EXAMPLE CODE FOR DELTA MOVEMENT:
//
// import greenfoot.*;
// import ml.obfuscatedgenerated.utils.greenfoot.GameUtils;
//
// public class SmoothMover extends Actor {
//     public void act() {
//         GameUtils.update();
//         GameUtils.setExactLocation(this,GameUtils.getExactX(this)+(100*GameUtils.getDelta()),50.0);
//     }
// }
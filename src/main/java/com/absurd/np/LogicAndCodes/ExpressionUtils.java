package com.absurd.np.LogicAndCodes;

/**
 * Created by wangwenwei on 16/11/6.
 */
public class ExpressionUtils {
    public static boolean and(boolean a,boolean b){
        return a&&b;
    }

    public static boolean or(boolean a, boolean b){
        return a||b;
    }

    public static boolean not(boolean a){
        return !a;
    }

    public static boolean equ(boolean a,boolean b){
        return a==b;
    }
}

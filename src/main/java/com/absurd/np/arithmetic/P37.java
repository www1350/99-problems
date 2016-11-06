package com.absurd.np.arithmetic;

/**
 * Determine the greatest common divisor of two positive integer numbers.
 * Created by wangwenwei on 16/11/6.
 */
public class P37 {
    public static int gcd(int fir, int sec) {
     return sec ==0? fir:gcd(sec,fir%sec );

    }
}

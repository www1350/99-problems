package com.absurd.np.arithmetic;

/**
 * Determine whether two positive integer numbers are coprime.
 * Two numbers are coprime if their greatest common divisor equals 1.
 * Created by wangwenwei on 16/11/6.
 */
public class P38 {
    public static boolean coprime(int i, int i1) {
       return P37.gcd(i,i1)==1?true:false;
    }
}

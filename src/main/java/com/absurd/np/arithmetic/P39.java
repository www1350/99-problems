package com.absurd.np.arithmetic;

import java.util.stream.IntStream;

/**
 * Calculate Euler's totient function phi(m).
 * Euler's so-called totient function phi(m) is defined as the number of positive integers r (1 <= r < m) that are coprime to m.
 * Created by wangwenwei on 16/11/6.
 */
public class P39 {
    public static long phi(int i) {
     return   IntStream.range(1,i)
                .filter(e->P38.coprime(e,i))
                .count();
    }
}

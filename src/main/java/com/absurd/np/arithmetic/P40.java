package com.absurd.np.arithmetic;

import java.util.stream.IntStream;

/**
 * Calculate Euler's totient function phi(m) (2).
 * See problem P39 for the definition of Euler's totient function.
 * If the list of the prime factors of a number m is known in the form of problem 2.03 then
 * the function phi(m) can be efficiently calculated as follows: Let [[p1,m1],[p2,m2],[p3,m3],...] be
 * the list of prime factors (and their multiplicities) of a given number m.
 * Then phi(m) can be calculated with the following formula:
 * phi(m) = (p1 - 1) * p1**(m1 - 1) * (p2 - 1) * p2**(m2 - 1) * (p3 - 1) * p3**(m3 - 1) * ...
 * Note that a**b stands for the b'th power of a
 * Created by wangwenwei on 16/11/6.
 */
public class P40 {
    public static int phi(int i) {
    return  P33.primeFactorsMult(i)
                .stream()
                .map(e->(e.getKey()-1)*Math.pow(e.getKey(),e.getValue()-1))//(p1 - 1) * p1**(m1 - 1)
                .mapToInt(Double::intValue)//double->int
                .reduce(1 , (a,b)->a*b);
    }
}

package com.absurd.np.arithmetic;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;


/**
 * Goldbach's conjecture says that every positive even number greater than 2 is the sum of two prime numbers.
 * Example: 28 = 5 + 23.
 * It is one of the most famous facts in number theory that has not been proved to be correct in the general case.
 * It has been numerically confirmed up to very large numbers.
 * Write a predicate to find the two prime numbers that sum up to a given even integer.
 * Created by wangwenwei on 16/11/6.
 */
public class P35 {
    public static List<Integer> goldbach(int i) {
        if(i==2) Collections.emptyList();
     List<Integer> allPrime =   PrimeUtils.makePrime_sieve(i-1);
        List<Integer> result = new ArrayList<>();
        for(Integer e: allPrime) {
            if(allPrime.contains(i-e)) {
                result.add(e);
                result.add(i-e);
                return result;
            }

        }

    return result;
    }
}

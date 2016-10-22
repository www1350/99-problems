package com.absurd.np.arithmetic;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * @author <a href="mailto:www_1350@163.com">Absurd</a>
 * @version V1.0
 * @Title: 99-problems
 * @Package com.absurd.np.arithmetic
 * @Description:
 * A list of prime numbers
 * @date 2016/10/22 10:52
 */
public class P34 {
    public static List<Integer> primeNumbers(IntStream intStream) {
       return intStream.filter(P31::isPrime)
               .boxed()
                .collect(Collectors.toList());
    }

    public static List<Integer> primeNumbers_sieve(IntStream intStream) {
       int[] arr = intStream.toArray();
      return  PrimeUtils.makePrime_sieve(
              arr[0] ,
              arr[arr.length-1]);
    }
}

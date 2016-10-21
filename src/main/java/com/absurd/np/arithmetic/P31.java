package com.absurd.np.arithmetic;

import java.util.stream.LongStream;

/**
 * @author <a href="mailto:www_1350@163.com">Absurd</a>
 * @version V1.0
 * @Title: 99-problems
 * @Package com.absurd.np
 * @Description:
 * Determine whether a given integer number is prime.
 * @date 2016/10/21 15:10
 */
public class P31 {

    public static boolean isPrime(long num) {
        if(num==1) return false;
        if(num==2) return true;
    for(int i=2;i<Math.sqrt(num);i++){
        if(num % i ==0) return false;
    }
        return true;
    }


    public static boolean isPrime_stream(long number) {
        return number == 1 ? false :
                !LongStream.rangeClosed(2, Math.round(Math.sqrt(number)))
                        .anyMatch(n -> number % n == 0);
    }
}

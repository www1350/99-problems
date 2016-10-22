package com.absurd.np.arithmetic;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.LongStream;

/**
 * @author <a href="mailto:www_1350@163.com">Absurd</a>
 * @version V1.0
 * @Title: 99-problems
 * @Package com.absurd.np
 * @Description:
 * Determine the prime factors of a given positive integer.
 * @date 2016/10/21 15:28
 */
public class P32 {
    public static List<Integer> primeFactors(long num) {
        if(num == 1 ) return Arrays.asList(1);
        List<Integer> list = new ArrayList<>();
        for(int i=2;i<=num;i++){
            if(num % i ==0) {
                list.add(i);
                num/=i;
                i--;
            }
        }

        return list;
    }


    public static List<Integer> primeFactors_stream(long num) {
        if(num == 1 ) return Arrays.asList(1);
        List<Integer> result = new ArrayList<>();
       IntStream.rangeClosed(2,(int)(num/2))
                .filter(P31::isPrime)
                .forEach(
                        e->{
                            long n = num;
                            while(n % e ==0){
                                result.add(e);
                                n/=e;
                            }

                        }
                );
        return result;
    }
}

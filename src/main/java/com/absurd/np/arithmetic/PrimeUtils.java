package com.absurd.np.arithmetic;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author <a href="mailto:www_1350@163.com">Absurd</a>
 * @version V1.0
 * @Title: 99-problems
 * @Package com.absurd.np.arithmetic
 * @Description:
 * @date 2016/10/22 11:18
 */
public class PrimeUtils {

    public static List<Integer> makePrime(final  int end){
        List<Integer> result = new ArrayList<>();
        boolean flag = true;
        for(int i=2;i<=end;i++){
            flag=true;
            for(int j=2;j<=Math.sqrt(i);j++){
                while(i%j==0) {
                    flag=false;
                    break;}
            }
            if(flag) result.add(i);
        }

        return result;

    }

    //素数筛法
    public static List<Integer> makePrime_sieve(final  int end){
        boolean[] primes = new boolean[end + 1];
        Arrays.fill(primes, true);
        primes[0]=false;
        primes[1]=false;
       for(int i=2;i<end;i++){
           if(primes[i]){
               for(int j=i*i;j<=end;j+=i)
                   primes[j]=false;
           }
       }
        List<Integer> result = new ArrayList<>();
        for (int i = 2; i < primes.length; i++) {
            if (primes[i]) {
                result.add(i);
            }
        }

        return result;

    }


    //素数筛法
    public static List<Integer> makePrime_sieve(final  int start,final  int end){
        boolean[] primes = new boolean[end + 1];
        List<Integer> result = new ArrayList<>();
        Arrays.fill(primes, true);
        primes[0]=false;
        primes[1]=false;
        int index = 0;
        for(int i=2;i<end+1;i++){
            //如果是素数
            if(primes[i]) {
                result.add(i);
                index++;
            }
                for(int j=0;j<index && result.get(j) * i <end+1 ;j++) {
                    primes[i * result.get(j)] = false;
                    if(i % result.get(j) == 0) break;
                }

        }
        return  result.stream().filter(e->e>=start).collect(Collectors.toList());

    }






}

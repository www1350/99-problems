package com.absurd.np.arithmetic;

import com.absurd.np.prologLists.P09;
import com.absurd.np.prologLists.P10;

import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author <a href="mailto:www_1350@163.com">Absurd</a>
 * @version V1.0
 * @Title: 99-problems
 * @Package com.absurd.np.arithmetic
 * @Description:
 *  Determine the prime factors of a given positive integer (2).
 * @date 2016/10/22 10:40
 */
public class P33 {
    public static List<AbstractMap.SimpleEntry<Integer,Integer>> primeFactorsMult(long num) {
        List<AbstractMap.SimpleEntry<Integer,Integer>> result = new ArrayList<>();
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int i=2;i<=num;i++){
            if(num % i ==0) {
                map.put(i,map.compute(i,(k,v)->v==null?1:v+1));
                num/=i;
                i--;
            }
        }
       for ( Integer key:  map.keySet()){
          result.add( new AbstractMap.SimpleEntry<>(key,map.get(key)));
       }

       return result;

    }

    public static List<AbstractMap.SimpleEntry<Integer,Integer>> primeFactorsMult_stream(long num) {
        return P09.pack(P32.primeFactors_stream(num))
                .stream()
                .map(e -> new AbstractMap.SimpleEntry<>(e.get(0),e.size()) )
                .collect(Collectors.toList());
    }
}

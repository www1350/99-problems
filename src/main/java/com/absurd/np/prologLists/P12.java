package com.absurd.np.prologLists;

import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author <a href="mailto:www_1350@163.com">Absurd</a>
 * @version V1.0
 * @Title: 99-problems
 * @Package com.absurd.np
 * @Description:
 * Decode a run-length encoded list
 * Given a run-length code list generated as specified in problem 1.11. Construct its uncompressed version.
 * @date 2016/10/20 13:54
 */
public class P12 {
    public static <T> List<T> decode(List<?> lists){
        List<T> result = new ArrayList<T>();
        lists.forEach(
                e->{
                    if(e instanceof AbstractMap.SimpleEntry){
                        int key =  (Integer) ((AbstractMap.SimpleEntry) e).getKey();
                        T value =  (T)  ((AbstractMap.SimpleEntry) e).getValue();
                        for(int i=0;i<key;i++)
                            result.add(value);
                    }else{
                        result.add((T)e);
                    }
                }
        );
        return result;
    }


    public static <T> List<T> decode_stream(List<?> lists) {
//      return  lists.stream()
//                .flatMap(e->{
//                    if(e instanceof AbstractMap.SimpleEntry){
//                        int key =  (Integer) ((AbstractMap.SimpleEntry) e).getKey();
//                        T value =  (T)  ((AbstractMap.SimpleEntry) e).getValue();
//                        List<T> result = new ArrayList<>();
//
//                        for(int i=0;i<key;i++)
//                            result.add(value);
//                       return result.stream();
//                    }else{
//                     return Stream.of((T)e);
//                    }
//                })
//                .collect(Collectors.toList());
    return    lists.stream()
                .flatMap(
                        e->
                            (e instanceof AbstractMap.SimpleEntry)?
                                    Collections.nCopies((Integer) ((AbstractMap.SimpleEntry) e).getKey(),(T)((AbstractMap.SimpleEntry) e).getValue()).stream() :
                                   Stream.of((T)e)
                )
                .collect(Collectors.toList());
    }
}

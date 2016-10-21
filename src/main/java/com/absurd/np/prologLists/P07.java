package com.absurd.np.prologLists;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author <a href="mailto:www_1350@163.com">Absurd</a>
 * @version V1.0
 * @Title: 99-problems
 * @Package com.absurd.np
 * @Description:
 * Flatten a nested list structure
 * @date 2016/10/20 10:32
 */
public class P07 {
    public static <T> List<T> flatten(List<?> list, Class<T> elementType){
        if(list == null){
            throw new IllegalArgumentException("list can't be null");
        }
        List<T> fa = new ArrayList<>();

        list.forEach(
                e->{
                    if(e instanceof  List){
                        fa.addAll(
                                flatten((List<?>) e, elementType)
                        );
                    }else
                fa.add((T) e);
                }
        );
        return fa;
    }


    public static <T> List<T> flatten_stream(List<?> list, Class<T> elementType){
        if(list == null){
            throw new IllegalArgumentException("list can't be null");
        }
        return list.stream()
                .flatMap(e->
                e instanceof  List ? flatten_stream((List<?>) e,elementType).stream() : Stream.of(e))
                .map( e -> (T) e)
                .collect(Collectors.toList());
    }
}

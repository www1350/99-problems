package com.absurd.np.prologLists;

import java.util.AbstractMap.SimpleEntry;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author <a href="mailto:www_1350@163.com">Absurd</a>
 * @version V1.0
 * @Title: 99-problems
 * @Package com.absurd.np
 * @Description:
 *  Run-length encoding of a list
 *  Use the result of problem 1.09 to implement the so-called run-length encoding data compression method. Consecutive duplicates of elements are encoded as terms [N,E] where N is the number of duplicates of the element E.
 * @date 2016/10/20 13:34
 */
public class P10 {
    public static <T> List<SimpleEntry<Integer,T>> encode(List<T> lists) {
        List<List<T>> listAll = P09.pack(lists);
        List<SimpleEntry<Integer,T>> result = new ArrayList<>();
                listAll.forEach(
                        e->{
                            SimpleEntry<Integer,T> se = new SimpleEntry<Integer, T>(e.size(),e.get(0));
                            result.add(se);
                        }

                );
        return result;
    }



    public static <T> List<SimpleEntry<Integer,T>> encode_stream(List<T> lists) {
        return  P09.pack(lists)
                .stream()
                .map(e -> new SimpleEntry<>(e.size(),e.get(0)) )
                .collect(Collectors.toList());

    }
}

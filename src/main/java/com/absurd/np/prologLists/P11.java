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
 * Modified run-length encoding
 * Modify the result of problem 1.10 in such a way that if an element has no duplicates it is simply copied into the result list. Only elements with duplicates are transferred as [N,E] terms.
 * @date 2016/10/20 13:47
 */
public class P11 {
    public static <T> List<Object> encode_modified(List<T> lists) {
        List<List<T>> listAll = P09.pack(lists);
        List<Object> result = new ArrayList<>();
        listAll.forEach(
                e->{
                    if(e.size() == 1) result.add(e.get(0));
                    else {
                        SimpleEntry<Integer, T> se = new SimpleEntry<Integer, T>(e.size(), e.get(0));
                        result.add(se);
                    }
                }

        );
        return result;
    }

    public static <T> List<Object> encode_modified_stream(List<T> lists) {
        return  P09.pack(lists)
                .stream()
                .map(e -> e.size()==1?e.get(0):new SimpleEntry<>(e.size(),e.get(0)) )
                .collect(Collectors.toList());

    }
}

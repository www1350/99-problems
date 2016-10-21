package com.absurd.np.prologLists;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author <a href="mailto:www_1350@163.com">Absurd</a>
 * @version V1.0
 * @Title: 99-problems
 * @Package com.absurd.np
 * @Description:
 * Generate the combinations of K distinct objects chosen from the N elements of a list
 * @date 2016/10/20 21:01
 */
public class P26 {
    public static <T> List<List<T>> combinations(List<T> lists, int k) {
        List<List<T>>  combinations = new ArrayList<>();
        if (k == 0 || lists.isEmpty()) {
            return combinations;
        }
        if (k == 1) {
            lists.forEach(e->
                combinations.add(Arrays.asList(e))
            );
            return combinations;
        }
        T head = lists.get(0);
        List<T> tail = lists.subList(1,lists.size());

        //不含首元素
        List<List<T>> l1 =  combinations(tail,k);

        //含首元素
        List<List<T>> l2 =  combinations(tail,k-1);
        for (int i=0;i<l2.size();i++) {
            List<T> rt = new ArrayList<>();
            rt.add(head);
            rt.addAll(l2.get(i));
            l2.set(i,rt);
        }
        //合并
        l1.addAll(l2);
        return l1;
    }

    public static <T> List<List<T>> combinations_stream(List<T> lists, int k) {
        if (k == 0 || lists.isEmpty()) {
            return Collections.emptyList();
        }
        if (k == 1) {
            return lists.stream().map(
                    e -> Stream.of(e)
                            .collect(Collectors.toList()))
                    .collect(Collectors.toList()
            );
        }

        Map<Boolean,List<T>> map = P17.split_stream(lists,1);
        List<T> head =  map.get(true);
        List<T> tail =  map.get(false);
        //含第一个元素的组合
        List<List<T>> c1 = combinations_stream( tail,k-1).stream()
                .map(e-> {
                    List<T> l = new ArrayList<>();
                    l.addAll(head);
                    l.addAll(e);
                    return l;
                }).collect(Collectors.toList());
        //不含第一个元素的组合
        List<List<T>> c2 = combinations_stream(tail, k);
        c1.addAll(c2);
        return c1;
    }
}

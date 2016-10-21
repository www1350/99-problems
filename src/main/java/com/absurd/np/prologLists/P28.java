package com.absurd.np.prologLists;

import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @author <a href="mailto:www_1350@163.com">Absurd</a>
 * @version V1.0
 * @Title: 99-problems
 * @Package com.absurd.np
 * @Description:
 * Sorting a list of lists according to length of sublists
 * a) We suppose that a list (InList) contains elements that are lists themselves. The objective is to sort the elements of InList according to their length. E.g. short lists first, longer lists later, or vice versa.
 * b) Again, we suppose that a list (InList) contains elements that are lists themselves. But this time the objective is to sort the elements of InList according to their length frequency; i.e. in the default, where sorting is done in ascending order, lists with rare lengths are placed first, others with a more frequent length come later.
 * @date 2016/10/21 14:05
 */
public class P28 {

    public static <T> List<List<T>> lsort(List<List<T>> lists) {
        return   lists.stream()
                .sorted(Comparator.comparing(List::size))
                .collect(Collectors.toList());
    }

    public static <T> List<List<T>> lfsort(List<List<T>> lists) {
        Map<Integer,Integer> freMap = new HashMap<>();
        //计算出这个长度的频率，之后排序对比频率就行了
        lists.stream()
                .map(List::size)
                .forEach(e->freMap.put(e,
                        freMap.compute(
                                e,(k,v)-> v== null ? 1 : v+1
                        )
                ));
      return  lists.stream()
                .sorted(
                        (h1,h2)->Integer.compare(freMap.get(h1.size()),freMap.get(h2.size()))
                ).collect(Collectors.toList());
    }
}

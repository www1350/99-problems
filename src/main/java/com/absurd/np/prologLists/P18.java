package com.absurd.np.prologLists;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * @author <a href="mailto:www_1350@163.com">Absurd</a>
 * @version V1.0
 * @Title: 99-problems
 * @Package com.absurd.np
 * @Description:
 * Extract a slice from a list
 * @date 2016/10/20 15:59
 */
public class P18 {
    public static <T> List<T> slice(List<T> lists, int from, int to) {
       return lists.subList(from-1,to);
    }

    public static <T> List<T> slice_stream(List<T> lists, int from, int to) {
//        int[] idx = { 0 };
//      return  lists.stream()
//                .filter(e->
//                        (((++idx[0])<=to)&&(idx[0]>=from))
//                )
//         .collect(Collectors.toList());


      return  IntStream.range(from-1,to)
               .mapToObj(i->lists.get(i))
                .collect(Collectors.toList());
    }
}

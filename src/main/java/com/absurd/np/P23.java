package com.absurd.np;

import java.util.Comparator;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

/**
 * @author <a href="mailto:www_1350@163.com">Absurd</a>
 * @version V1.0
 * @Title: 99-problems
 * @Package com.absurd.np
 * @Description:
 * Extract a given number of randomly selected elements from a list
 * @date 2016/10/20 19:59
 */
public class P23 {
    public static <T> List<T> randomSelect(List<T> lists, int n) {
//      return  new Random()
//                .ints(0,lists.size())
//                .limit(n)
//                .mapToObj(lists::get)
//                .collect(Collectors.toList());

     return   lists.stream()
                .sorted((s1, s2) -> new Random().ints(-1,2).limit(1).findFirst().getAsInt())
                .limit(n)
                .collect(Collectors.toList());
    }

}

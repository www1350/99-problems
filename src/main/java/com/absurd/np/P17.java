package com.absurd.np;

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
 * Split a list into two parts; the length of the first part is given
 * @date 2016/10/20 15:48
 */
public class P17 {

    public static <T> Map<Boolean,List<T>> split(List<T> lists, int i) {
        Map<Boolean,List<T>> result = new HashMap<>();
        result.put(true,lists.subList(0,i));
        result.put(false,lists.subList(i,lists.size()))  ;
        return result;
    }

    public static <T> Map<Boolean,List<T>> split_stream(List<T> lists, int i) {
        int[] idx = { 0 };
       return lists.stream()
               .collect(Collectors.partitioningBy(
                  e->
                     i> idx[0]++
               ));
    }
}

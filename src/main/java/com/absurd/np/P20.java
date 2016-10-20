package com.absurd.np;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @author <a href="mailto:www_1350@163.com">Absurd</a>
 * @version V1.0
 * @Title: 99-problems
 * @Package com.absurd.np
 * @Description:
 * Remove the K'th element from a list
 * @date 2016/10/20 16:34
 */
public class P20 {
    public static <T> Object[] removeAt(List<T> lists, int i) {
        Object[] result = new Object[2];
        List<T> temp = new ArrayList(lists);
        T e = temp.remove(i-1);
        result[0] = temp;
        result[1] = e;
        return result;
    }

    public static <T> Object[] removeAt_stream(List<T> lists, int pos) {
        int[] idx = { 0 };
        Map<Boolean,List<T>> map = lists.stream()
                .collect(Collectors.partitioningBy(
                        e->pos == ++idx[0]
                ));
        Object[] result = new Object[2];
        result[0] = map.get(false);
        result[1] =  map.get(true).get(0);
        return result;
    }
}

package com.absurd.np;

import java.util.List;
import java.util.stream.IntStream;

/**
 * @author <a href="mailto:www_1350@163.com">Absurd</a>
 * @version V1.0
 * @Title: 99-problems
 * @Package com.absurd.np
 * @Description:
 *  Insert an element at a given position into a list
 * @date 2016/10/20 17:24
 */
public class P21 {
    public static <T> List<T> insertAt(List<T> lists, int i, T insert) {
        lists.add(i-1,insert);
        return lists;
    }

}

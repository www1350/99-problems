package com.absurd.np.prologLists;

import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author <a href="mailto:www_1350@163.com">Absurd</a>
 * @version V1.0
 * @Title: 99-problems
 * @Package com.absurd.np
 * @Description:
 * Find the Kth element of a list
 * The first element of a list has index 0. In the example shown below, last element would be at kth position 4.
 * @date 2016/10/19 20:26
 */
public class P03 {
    public static <T> T kth(List<T> numbers, int i) {
        return numbers.get(i);
    }
    public static <T> T kthStream(List<T> numbers, int i) {
        return numbers.stream().limit(i+1).collect(Collectors.toCollection(LinkedList::new)).getLast();
    }

}

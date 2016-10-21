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
 * Create a list containing all integers within a given range
 * @date 2016/10/20 19:44
 */
public class P22 {
    public static  List<Integer> range(int from, int to) {
        return IntStream.range(from,to+1)
                .mapToObj(i->i)
                .collect(Collectors.toList());
    }
}

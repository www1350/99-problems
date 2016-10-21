package com.absurd.np.prologLists;

import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

/**
 * @author <a href="mailto:www_1350@163.com">Absurd</a>
 * @version V1.0
 * @Title: 99-problems
 * @Package com.absurd.np
 * @Description:
 * Generate a random permutation of the elements of a list
 * @date 2016/10/20 20:24
 */
public class P25 {
    public static <T> List<T> randomPermutation(List<T> lists) {
        return   lists.stream()
                .sorted((s1, s2) -> new Random().ints(-1,2).limit(1).findFirst().getAsInt())
                .limit(lists.size())
                .collect(Collectors.toList());

//        return new Random().ints(0,lists.size())
//                .limit(lists.size())
//                .mapToObj(i->lists.get(i))
//                .collect(Collectors.toList());
    }
}


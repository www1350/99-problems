package com.absurd.np.prologLists;

import java.util.LinkedList;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author <a href="mailto:www_1350@163.com">Absurd</a>
 * @version V1.0
 * @Title: 99-problems
 * @Package com.absurd.np
 * @Description:
 * @date 2016/10/19 20:13
 */
public class CollectUtils {
    public static <T> LinkedList<T> linkedList(T... e){
        return Stream.of(e).collect(Collectors.toCollection(LinkedList::new));
    }
}

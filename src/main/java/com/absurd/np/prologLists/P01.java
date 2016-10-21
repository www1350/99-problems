package com.absurd.np.prologLists;

import java.util.LinkedList;
import java.util.List;

/**
 * @author <a href="mailto:www_1350@163.com">Absurd</a>
 * @version V1.0
 * @Title: 99-problems
 * @Package com.absurd.np
 * @Description: Find the last element of a list
 * @date 2016/10/19 19:55
 */
public class P01 {

    public static <T> T last(List<T> elements) {
        return elements.get(elements.size()-1);
    }


    public static <T> T last(LinkedList<T> elements) {
        return elements.getLast();
    }


}

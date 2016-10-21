package com.absurd.np.prologLists;

import java.util.List;

/**
 * @author <a href="mailto:www_1350@163.com">Absurd</a>
 * @version V1.0
 * @Title: 99-problems
 * @Package com.absurd.np
 * @Description:
 *  Find the number of elements of a list
 * @date 2016/10/19 20:31
 */
public class P04 {
    public static <T> int length(List<T> lists) {
        return lists.size();
    }

    public static <T> int lengthStream(List<T> lists) {
        return (int)lists.stream().count();
    }
}

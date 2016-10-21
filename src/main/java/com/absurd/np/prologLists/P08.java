package com.absurd.np.prologLists;

import java.util.ArrayList;
import java.util.List;

/**
 * @author <a href="mailto:www_1350@163.com">Absurd</a>
 * @version V1.0
 * @Title: 99-problems
 * @Package com.absurd.np
 * @Description:
 *  Eliminate consecutive duplicates of list elements
 *  If a list contains repeated elements they should be replaced with a single copy of the element. The order of the elements should not be changed.
 * @date 2016/10/20 10:55
 */
public class P08 {

    public static <T> List<T> compress(List<T> lists) {
        if(lists == null){
            throw new IllegalArgumentException("list can't be null");
        }
        int size = lists.size();
        if(size == 1 ) return lists;
        List<T> newLists = new ArrayList<>();
        T temp = lists.get(0);
        newLists.add(temp);
        for (int i = 1; i < size; i++) {
            T e = lists.get(i);
            if(!temp.equals(e))
                newLists.add(e);
            temp = e;
        }
        return newLists;
    }

    public static <T> List<T> compress_stream(List<T> lists) {
        if (lists == null) {
            throw new IllegalArgumentException("list can't be null");
        }
//        lists.stream().
        //TODO
    return null;
    }

}

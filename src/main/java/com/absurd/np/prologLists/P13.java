package com.absurd.np.prologLists;

import java.util.AbstractMap.SimpleEntry;
import java.util.ArrayList;
import java.util.List;

/**
 * @author <a href="mailto:www_1350@163.com">Absurd</a>
 * @version V1.0
 * @Title: 99-problems
 * @Package com.absurd.np
 * @Description:
 * Run-length encoding of a list (direct solution)
 * Implement the so-called run-length encoding data compression method directly. I.e. don't explicitly create the sublists containing the duplicates, as in problem P09, but only count them.
 * @date 2016/10/20 14:14
 */
public class P13 {

    public static <T> List<SimpleEntry<Integer,T>> encode_direct(List<T> lists) {
        if(lists == null){
            throw new IllegalArgumentException("list can't be null");
        }
        List<SimpleEntry<Integer,T>> result = new ArrayList<>();
        T temp = lists.get(0);
        int i =1;
        for(int pos = 1;pos<lists.size();pos++){
         T e = lists.get(pos);
             if(e.equals(temp)) {
                 i++;
            }else {
                 result.add(new SimpleEntry<>(i, temp));
                 i=1;
             }
             temp = e;
        }
        result.add(new SimpleEntry<>(i, temp));
        return result;
    }
}

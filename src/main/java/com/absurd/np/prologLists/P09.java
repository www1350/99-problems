package com.absurd.np.prologLists;

import java.util.ArrayList;
import java.util.List;

/**
 * @author <a href="mailto:www_1350@163.com">Absurd</a>
 * @version V1.0
 * @Title: 99-problems
 * @Package com.absurd.np
 * @Description:
 * Pack consecutive duplicates of list elements into sublists
 * If a list contains repeated elements they should be placed in separate sublists.
 * @date 2016/10/20 11:31
 */
public class P09 {

    public static <T> List<List<T>> pack(List<T> lists) {
        if (lists == null) {
            throw new IllegalArgumentException("list can't be null");
        }
        int size = lists.size();
        List<List<T>> packedList = new ArrayList<>();
        if(size == 1){
            packedList.add(lists);
            return packedList;
        }
        T temp  = null;
        List<T> tempList = new ArrayList<>();
        for(int i=0;i<size;i++){
            T e = lists.get(i);
            if(!e.equals(temp)){
                tempList = new ArrayList<>();
                packedList.add(tempList);
            }
            tempList.add(e);
            temp = e;

        }
        return packedList;
    }

//    public static <T> List<List<T>> pack_stream(List<T> lists) {
//        if (lists == null) {
//            throw new IllegalArgumentException("list can't be null");
//        }
//        lists.stream().collect(Collectors.groupBy(String::length, Collectors.toList()));
//    }
}

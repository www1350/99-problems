package com.absurd.np;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * @author <a href="mailto:www_1350@163.com">Absurd</a>
 * @version V1.0
 * @Title: 99-problems
 * @Package com.absurd.np
 * @Description:
 * Rotate a list N places to the left
 * @date 2016/10/20 16:16
 */
public class P19 {

    public static <T> List<T> rotate(List<T> lists, int i) {
        i = (i+lists.size())%lists.size();
        List<T> result = new ArrayList<>();
        result.addAll(lists.subList(i,lists.size()));
        result.addAll(lists.subList(0,i));
        return result;
    }


    public static <T> List<T> rotate_deep(List<T> lists, int i) {
        T[] arr =(T[]) lists.toArray();
       i = (i+arr.length)%arr.length;
        reverse(arr,0,i-1);
        reverse(arr,i,arr.length-1);
        reverse(arr,0,arr.length-1);
        return Arrays.asList(arr);
    }

    public static <T> void reverse(T[] arr, int left, int right){
        if(arr ==null ||arr.length ==1)
            return;
        while (left<right){
            T temp = arr[left];
            arr[left] =arr[right];
            arr[right] = temp;
            left++;
            right--;
        }
        return;
    }

    //Not Good
    public static <T> List<T> rotate_stream(List<T> lists, int pos) {
        pos = (pos+lists.size())%lists.size();
        List<T> result = new ArrayList<>();
        result.addAll(IntStream.range(pos,lists.size())
                .mapToObj(i->lists.get(i))
                .collect(Collectors.toList()));
        result.addAll(IntStream.range(0,pos)
                .mapToObj(i->lists.get(i))
                .collect(Collectors.toList()));
        return    result;
    }
}

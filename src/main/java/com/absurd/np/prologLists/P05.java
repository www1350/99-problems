package com.absurd.np.prologLists;


import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * @author <a href="mailto:www_1350@163.com">Absurd</a>
 * @version V1.0
 * @Title: 99-problems
 * @Package com.absurd.np
 * @Description:
 * Reverse a list
 * @date 2016/10/19 20:34
 */
public class P05 {

    public static <T> List<T>  reverse(List<T> numbers) {
        if (numbers == null) {
            throw new IllegalArgumentException("list can't be null");
        }
        int size = numbers.size();
        T temp =null;
        for(int i=0;i<size/2;i++){
         temp =   numbers.get(i);
            numbers.set(i,numbers.get(size-i-1));
            numbers.set(size-i-1,temp);
        }
        return numbers;
    }

    public static <T> List<T>  reverseStream(List<T> numbers) {
        if (numbers == null) {
            throw new IllegalArgumentException("list can't be null");
        }
        //sort not  reverse should impl Comparator
//        return  numbers.stream()
//                .sorted(Collections.reverseOrder()).collect(Collectors.toList());


        //ok
      return   IntStream.range(0, numbers.size())
                .mapToObj(i -> numbers.get(numbers.size()-i-1)).collect(Collectors.toList());

//            return   numbers.stream().collect(Collectors.collectingAndThen(Collectors.toList(), l -> {
//            Collections.reverse(l);
//            return l;
//        }));
    }


    public static <T> List<T>  reverseStream(LinkedList<T> numbers) {
        if (numbers == null) {
            throw new IllegalArgumentException("list can't be null");
        }
        return   numbers.stream().collect(Collectors.collectingAndThen(Collectors.toList(), l -> {
            Collections.reverse(l);
            return l;
        }));
    }
}

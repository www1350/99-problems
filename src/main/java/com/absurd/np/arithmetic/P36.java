package com.absurd.np.arithmetic;

import java.util.AbstractMap.SimpleEntry;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * Given a range of integers by its lower and upper limit,
 * print a list of all even numbers and their Goldbach composition.
 * Created by wangwenwei on 16/11/6.
 */
public class P36 {
    public static List<SimpleEntry<Integer,List<Integer>>> goldbach_list1(IntStream intStream, int i) {
    return goldbach_list(intStream)
            .stream()
            .filter(n->n.getValue().get(0)>i&&n.getValue().get(1)>i)
            .collect(Collectors.toList());
    }

    public static List<SimpleEntry<Integer, List<Integer>>> goldbach_list(IntStream intStream) {
        return intStream
                .filter(n->n%2==0)//筛选出偶数
                .filter(n -> n>2)//
                .mapToObj(n->new SimpleEntry<>(n,P35.goldbach(n)))
                .collect(Collectors.toList());
    }
}

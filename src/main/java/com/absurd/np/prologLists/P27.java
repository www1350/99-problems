package com.absurd.np.prologLists;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author <a href="mailto:www_1350@163.com">Absurd</a>
 * @version V1.0
 * @Title: 99-problems
 * @Package com.absurd.np
 * @Description:
 * Group the elements of a set into disjoint subsets
 * a) In how many ways can a group of 9 people work in 3 disjoint subgroups of 2, 3 and 4 persons? Write a predicate that generates all the possibilities via backtracking
 * b) Generalize the above predicate in a way that we can specify a list of group sizes and the predicate will return a list of groups.
 * @date 2016/10/21 10:44
 */
public class P27 {
    public static <T> List<List<List<T>>> group3(List<T> lists) {
        List<List<List<T>>> result = new ArrayList<>();
        List<List<T>> l2 =  P26.combinations(lists,2);
        l2.forEach(
                e1->{
                    List<T> o1 =  other(lists,e1);
                    List<List<T>> l3 =  P26.combinations(o1,3);
                    l3.forEach(
                            e2->{
                                List<T> o2 =  other(o1,e2);
                                result.add( Arrays.asList(e1,e2,o2));
                            }
                    );
                }
        );
        return result;
    }

    private static <T> List<T> other(List<T> lists, List<T> e1) {
        List<T> result = new ArrayList<>();
        lists.forEach(
                e-> {if(!e1.contains(e))  result.add(e);}
        );
        return result;
    }




    private static <T> List<T> other_stream(List<T> lists, List<T> e1) {
        return   lists.stream()
                .filter(
                        e->!e1.contains(e)
                )
                .collect(Collectors.toList());
    }

    public static <T> List<List<List<T>>> group(List<T> lists, List<Integer> collect) {
        List<List<List<T>>>  result = new ArrayList<>();
        if(collect.isEmpty()){
            return Arrays.asList(Arrays.asList(Arrays.asList()));
        }
        int head = collect.get(0);
        List<Integer> tail = collect.subList(1,collect.size());

        //先选出head个，剩下的递归
        P26.combinations_stream(lists,head)
                .forEach(
                        //e1->前head个元素List<T>
                        e1->{
                            //remains 除去前head个后剩下元素
                            List<T> remains = other_stream(lists,e1);
                            //每次选出head个，合并上剩下的元素
                            group(remains,tail)
                                    .forEach(e2->{
                                        List<List<T>> sg = new ArrayList<>();
                                        sg.add(e1);
                                        sg.addAll(e2);
                                        result.add(sg);
                                    });

                        }
                );
        return result;
    }
}

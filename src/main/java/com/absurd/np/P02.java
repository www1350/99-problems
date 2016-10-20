package com.absurd.np;

import java.util.List;
import java.util.NoSuchElementException;

/**
 * @author <a href="mailto:www_1350@163.com">Absurd</a>
 * @version V1.0
 * @Title: 99-problems
 * @Package com.absurd.np
 * @Description:
 * Find the last but one element of a list
 * The method should throw NoSuchElementException when list is either empty or has one element.
 * @date 2016/10/19 20:20
 */
public class P02 {
    public static <T> T secondLast(List<T> numbers) {
        if(numbers==null || numbers.size() <2){
            throw new NoSuchElementException();
        }
        return numbers.get(numbers.size()-2);

    }
}

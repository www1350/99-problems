package com.absurd.np;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author <a href="mailto:www_1350@163.com">Absurd</a>
 * @version V1.0
 * @Title: 99-problems
 * @Package com.absurd.np
 * @Description:
 * Duplicate the elements of a list
 * @date 2016/10/20 15:07
 */
public class P14 {
    public static <T> List<T> duplicate(List<T> lists) {
        if(lists == null){
            throw new IllegalArgumentException("list can't be null");
        }
        List<T> result = new ArrayList<>();
                lists.forEach(
                        e->result.addAll(Collections.nCopies(2,e))
                );
        return result;
    }

    public static <T> List<T> duplicate_stream(List<T> lists) {
        if(lists == null){
            throw new IllegalArgumentException("list can't be null");
        }
      return  lists.stream()
              .flatMap(e->Collections.nCopies(2,e).stream())
              .collect(Collectors.toList());
    }
}

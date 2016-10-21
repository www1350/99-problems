package com.absurd.np.prologLists;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author <a href="mailto:www_1350@163.com">Absurd</a>
 * @version V1.0
 * @Title: 99-problems
 * @Package com.absurd.np
 * @Description:
 * Drop every N'th element from a list
 * @date 2016/10/20 15:21
 */
public class P16 {

    public static <T> List<T> dropEveryNth(List<T> lists, int i) {
        List<T> result = new ArrayList<>();
        for(int pos=0;pos<lists.size();pos++){
            if(i==0 || !((pos+1) % i == 0) ) result.add(lists.get(pos));
        }
        return result;

    }

    public static <T> List<T> dropEveryNth_stream(List<T> lists, int i) {
        int[] idx = { 0 };
        return lists.stream()
                .filter(
                        e->( i ==0 || !((++idx[0])%i==0) )
                )
                .collect(Collectors.toList());

    }
}

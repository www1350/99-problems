package com.absurd.np;

import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

/**
 * @author <a href="mailto:www_1350@163.com">Absurd</a>
 * @version V1.0
 * @Title: 99-problems
 * @Package com.absurd.np
 * @Description:
 * Lotto: Draw N different random numbers from the set 1..M
 * Hint: Combine the solutions of problems P22 and P23
 * @date 2016/10/20 20:21
 */
public class P24 {

    public static List<Integer> randomSelect(int n, int from, int to) {
              return  new Random()
                .ints(from,to+1)
                .limit(n)
                .mapToObj(i->i)
                .collect(Collectors.toList());

    }
}

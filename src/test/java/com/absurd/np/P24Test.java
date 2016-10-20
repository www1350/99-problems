package com.absurd.np;

import org.junit.Test;

import java.util.List;

import static org.hamcrest.Matchers.hasSize;
import static org.junit.Assert.assertThat;

/**
 * @author <a href="mailto:www_1350@163.com">Absurd</a>
 * @version V1.0
 * @Title: 99-problems
 * @Package com.absurd.np
 * @Description:
 * @date 2016/10/20 20:22
 */
public class P24Test {
    @Test
    public void shouldGive6RandomNumbersFromARangeStartingFrom1To49() throws Exception {
        List<Integer> randomList = P24.randomSelect(6, 1, 49);
        assertThat(randomList, hasSize(6));
        System.out.println(randomList); // One possible output [47, 30, 36, 38, 11, 1]
    }
}

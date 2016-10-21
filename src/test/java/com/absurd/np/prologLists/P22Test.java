package com.absurd.np.prologLists;

import org.junit.Test;

import java.util.List;

import static org.hamcrest.Matchers.contains;
import static org.hamcrest.Matchers.hasSize;
import static org.junit.Assert.assertThat;

/**
 * @author <a href="mailto:www_1350@163.com">Absurd</a>
 * @version V1.0
 * @Title: 99-problems
 * @Package com.absurd.np
 * @Description:
 * @date 2016/10/20 19:45
 */
public class P22Test {
    @Test
    public void shouldCreateARangeBetween4And9() throws Exception {
        List<Integer> range = P22.range(4, 9);
        assertThat(range, hasSize(6));
        assertThat(range, contains(4, 5, 6, 7, 8, 9));

    }
}

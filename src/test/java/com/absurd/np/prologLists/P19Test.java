package com.absurd.np.prologLists;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;

/**
 * @author <a href="mailto:www_1350@163.com">Absurd</a>
 * @version V1.0
 * @Title: 99-problems
 * @Package com.absurd.np
 * @Description:
 * @date 2016/10/20 16:16
 */
public class P19Test {
    @Test
    public void shouldRotateAListByThreeElementsWhenNIs3() throws Exception {
        List<String> rotated = P19.rotate(Arrays.asList("a", "b", "c", "d", "e", "f", "g", "h"), 3);
        assertThat(rotated, equalTo(Arrays.asList("d", "e", "f", "g", "h", "a", "b", "c")));
    }

    @Test
    public void shouldReturnSameListWhenNIs0() throws Exception {
        List<String> rotated = P19.rotate(Arrays.asList("a", "b", "c", "d", "e", "f", "g", "h"), 0);
        assertThat(rotated, equalTo(Arrays.asList("a", "b", "c", "d", "e", "f", "g", "h")));
    }

    @Test
    public void shouldRotateWhenNIsNegative() throws Exception {
        List<String> rotated = P19.rotate(Arrays.asList("a", "b", "c", "d", "e", "f", "g", "h"), -2);
        assertThat(rotated, equalTo(Arrays.asList("g", "h", "a", "b", "c", "d", "e", "f")));
    }


    @Test
    public void shouldRotateAListByThreeElementsWhenNIs3ByDeep() throws Exception {
        List<String> rotated = P19.rotate_deep(Arrays.asList("a", "b", "c", "d", "e", "f", "g", "h"), 3);
        assertThat(rotated, equalTo(Arrays.asList("d", "e", "f", "g", "h", "a", "b", "c")));
    }

    @Test
    public void shouldReturnSameListWhenNIs0ByDeep() throws Exception {
        List<String> rotated = P19.rotate_deep(Arrays.asList("a", "b", "c", "d", "e", "f", "g", "h"), 0);
        assertThat(rotated, equalTo(Arrays.asList("a", "b", "c", "d", "e", "f", "g", "h")));
    }

    @Test
    public void shouldRotateWhenNIsNegativeByDeep() throws Exception {
        List<String> rotated = P19.rotate_deep(Arrays.asList("a", "b", "c", "d", "e", "f", "g", "h"), -2);
        assertThat(rotated, equalTo(Arrays.asList("g", "h", "a", "b", "c", "d", "e", "f")));
    }
}

package com.absurd.np;

import org.junit.Test;

import java.util.Arrays;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;

/**
 * @author <a href="mailto:www_1350@163.com">Absurd</a>
 * @version V1.0
 * @Title: 99-problems
 * @Package com.absurd.np
 * @Description:
 * @date 2016/10/20 16:34
 */
public class P20Test {
    @Test
    public void shouldRemoveKthElementFromList() throws Exception {
        Object[] result = P20.removeAt(Arrays.asList("a", "b", "c", "d"), 2);
        assertThat(result[0], equalTo(Arrays.asList("a", "c", "d")));
        assertThat(result[1], equalTo("b"));
    }
    @Test
    public void shouldRemoveKthElementFromListByStream() throws Exception {
        Object[] result = P20.removeAt_stream(Arrays.asList("a", "b", "c", "d"), 2);
        assertThat(result[0], equalTo(Arrays.asList("a", "c", "d")));
        assertThat(result[1], equalTo("b"));
    }


}

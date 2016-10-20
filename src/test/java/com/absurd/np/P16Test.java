package com.absurd.np;

import org.junit.Test;

import java.util.Arrays;
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
 * @date 2016/10/20 15:22
 */
public class P16Test {
    @Test
    public void shouldDropEveryNthElement() throws Exception {
        List<String> result = P16.dropEveryNth(Arrays.asList("a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k"), 3);
        assertThat(result, hasSize(8));
        assertThat(result, contains("a", "b", "d", "e", "g", "h", "j", "k"));
    }

    @Test
    public void shouldReturnSameListWhenNIsLessThanListSize() throws Exception {
        List<String> result = P16.dropEveryNth(Arrays.asList("a", "b"), 3);
        assertThat(result, hasSize(2));
        assertThat(result, contains("a", "b"));
    }

    @Test
    public void shouldReturnSameListWhenNIsZero() throws Exception {
        List<String> result = P16.dropEveryNth(Arrays.asList("a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k"), 0);
        assertThat(result, hasSize(11));
        assertThat(result, contains("a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k"));
    }



    @Test
    public void shouldDropEveryNthElementByStream() throws Exception {
        List<String> result = P16.dropEveryNth_stream(Arrays.asList("a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k"), 3);
        assertThat(result, hasSize(8));
        assertThat(result, contains("a", "b", "d", "e", "g", "h", "j", "k"));
    }

    @Test
    public void shouldReturnSameListWhenNIsLessThanListSizeByStream() throws Exception {
        List<String> result = P16.dropEveryNth_stream(Arrays.asList("a", "b"), 3);
        assertThat(result, hasSize(2));
        assertThat(result, contains("a", "b"));
    }

    @Test
    public void shouldReturnSameListWhenNIsZeroByStream() throws Exception {
        List<String> result = P16.dropEveryNth_stream(Arrays.asList("a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k"), 0);
        assertThat(result, hasSize(11));
        assertThat(result, contains("a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k"));
    }

}

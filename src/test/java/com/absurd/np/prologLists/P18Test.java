package com.absurd.np.prologLists;

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
 * @date 2016/10/20 15:59
 */
public class P18Test {
    @Test
    public void shouldGiveSliceOfAList() throws Exception {
        List<String> slice = P18.slice(Arrays.asList("a", "b", "c", "d", "e", "f", "g", "h", "i", "k"), 3, 7);
        assertThat(slice, hasSize(5));
        assertThat(slice, contains("c", "d", "e", "f", "g"));
    }

    @Test
    public void shouldGiveSliceOfAListByStream() throws Exception {
        List<String> slice = P18.slice_stream(Arrays.asList("a", "b", "c", "d", "e", "f", "g", "h", "i", "k"), 3, 7);
        assertThat(slice, hasSize(5));
        assertThat(slice, contains("c", "d", "e", "f", "g"));
    }
}

package com.absurd.np.prologLists;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import static org.hamcrest.Matchers.contains;
import static org.junit.Assert.assertThat;

/**
 * @author <a href="mailto:www_1350@163.com">Absurd</a>
 * @version V1.0
 * @Title: 99-problems
 * @Package com.absurd.np
 * @Description:
 * @date 2016/10/20 15:48
 */
public class P17Test {
    @Test
    public void shouldSplitInTwoHalves() throws Exception {
        Map<Boolean, List<String>> result = P17.split(Arrays.asList("a", "b", "c", "d", "e", "f", "g", "h", "i", "k"), 3);
        assertThat(result.get(true), contains("a", "b", "c"));
        assertThat(result.get(false), contains("d", "e", "f", "g", "h", "i", "k"));
    }

    @Test
    public void shouldSplitInTwoHalvesByStream() throws Exception {
        Map<Boolean, List<String>> result = P17.split_stream(Arrays.asList("a", "b", "c", "d", "e", "f", "g", "h", "i", "k"), 3);
        assertThat(result.get(true), contains("a", "b", "c"));
        assertThat(result.get(false), contains("d", "e", "f", "g", "h", "i", "k"));
    }
}

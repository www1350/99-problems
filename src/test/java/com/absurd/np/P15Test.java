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
 * @date 2016/10/20 15:18
 */
public class P15Test {
    @Test
    public void shouldDuplicateElementsInAList() throws Exception {
        List<String> duplicates = P15.duplicate(Arrays.asList("a", "b", "c"), 3);
        assertThat(duplicates, hasSize(9));
        assertThat(duplicates, contains("a", "a", "a", "b", "b", "b", "c", "c", "c"));
    }

    @Test
    public void shouldDuplicateElementsInAListByStream() throws Exception {
        List<String> duplicates = P15.duplicate_stream(Arrays.asList("a", "b", "c"), 3);
        assertThat(duplicates, hasSize(9));
        assertThat(duplicates, contains("a", "a", "a", "b", "b", "b", "c", "c", "c"));
    }
}

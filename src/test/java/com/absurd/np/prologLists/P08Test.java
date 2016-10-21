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
 * @date 2016/10/20 10:55
 */
public class P08Test {
    @Test
    public void shouldRemoveConsecutiveDuplicatesInAList() throws Exception {
        List<String> compressedList = P08.compress(Arrays.asList("a", "a", "a", "a", "b", "c", "c", "d", "e", "e", "e", "e"));
        assertThat(compressedList, hasSize(5));
        assertThat(compressedList, contains("a", "b", "c","d", "e"));
    }

    @Test
    public void shouldNotRemoveNonConsecutiveSimilarElementsFromAList() throws Exception {
        List<String> compressedList = P08.compress(Arrays.asList("a", "a", "a", "a", "b", "c", "c", "a", "a", "d", "e", "e", "e", "e"));
        assertThat(compressedList, hasSize(6));
        assertThat(compressedList, contains("a", "b", "c","a", "d", "e"));
    }
}

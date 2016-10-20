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
 * @date 2016/10/20 11:32
 */
public class P09Test {
    @Test
    public void shouldReturnAListWithTwoListElementsWhenAListWithTwoUniqueElementsIsPassed() throws Exception {
        List<List<String>> packedList = P09.pack(Arrays.asList("a", "b"));
        assertThat(packedList, hasSize(2));
        assertThat(packedList.get(0), contains("a"));
        assertThat(packedList.get(1), contains("b"));
    }



    @Test
    public void shouldPackConsecutiveDuplicatesInTheirOwnLists() throws Exception {
        List<List<String>> packedList = P09.pack(Arrays.asList("a", "a", "a", "a", "b", "c", "c", "a", "a", "d", "e", "e", "e", "e"));
        assertThat(packedList, hasSize(6));
        assertThat(packedList.get(0), contains("a", "a", "a", "a"));
        assertThat(packedList.get(1), contains("b"));
        assertThat(packedList.get(2), contains("c", "c"));
        assertThat(packedList.get(3), contains("a", "a"));
        assertThat(packedList.get(4), contains("d"));
        assertThat(packedList.get(5), contains("e", "e", "e", "e"));
    }
}

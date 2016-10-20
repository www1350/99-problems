package com.absurd.np;

import org.junit.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.hamcrest.CoreMatchers.hasItems;
import static org.hamcrest.Matchers.hasSize;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

/**
 * @author <a href="mailto:www_1350@163.com">Absurd</a>
 * @version V1.0
 * @Title: 99-problems
 * @Package com.absurd.np
 * @Description:
 * @date 2016/10/20 10:32
 */
public class P07Test {
    @Test
    public void shouldFlattenAListOfList() throws Exception {
        List<String> flatten = P07.flatten(Arrays.asList("a", Arrays.asList("b", Arrays.asList("c", "d")), "e"), String.class);
        assertThat(flatten, hasSize(5));
        assertThat(flatten, hasItems("a", "b", "c", "d", "e"));
    }

    @Test
    public void shouldFlattenDeepNestedLists() throws Exception {
        List<String> flatten = P07.flatten(Arrays.asList("a", Arrays.asList("b", Arrays.asList("c", Arrays.asList("d", "e", Arrays.asList("f", "g"))), "h")), String.class);
        assertThat(flatten, hasSize(8));
        assertThat(flatten, hasItems("a", "b", "c", "d", "e", "f", "g", "h"));
    }

    @Test
    public void shouldReturnEmptyListWhenTryingToFlattenAnEmptyList() throws Exception {
        List<String> flatten = P07.flatten(Collections.emptyList(), String.class);
        assertTrue(flatten.isEmpty());
    }



    @Test
    public void shouldFlattenAListOfListByStream() throws Exception {
        List<String> flatten = P07.flatten_stream(Arrays.asList("a", Arrays.asList("b", Arrays.asList("c", "d")), "e"), String.class);
        assertThat(flatten, hasSize(5));
        assertThat(flatten, hasItems("a", "b", "c", "d", "e"));
    }

    @Test
    public void shouldFlattenDeepNestedListsByStream() throws Exception {
        List<String> flatten = P07.flatten_stream(Arrays.asList("a", Arrays.asList("b", Arrays.asList("c", Arrays.asList("d", "e", Arrays.asList("f", "g"))), "h")), String.class);
        assertThat(flatten, hasSize(8));
        assertThat(flatten, hasItems("a", "b", "c", "d", "e", "f", "g", "h"));
    }

    @Test
    public void shouldReturnEmptyListWhenTryingToFlattenAnEmptyListByStream() throws Exception {
        List<String> flatten = P07.flatten_stream(Collections.emptyList(), String.class);
        assertTrue(flatten.isEmpty());
    }
}

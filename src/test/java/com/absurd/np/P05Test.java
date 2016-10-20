package com.absurd.np;

import org.junit.Test;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

/**
 * @author <a href="mailto:www_1350@163.com">Absurd</a>
 * @version V1.0
 * @Title: 99-problems
 * @Package com.absurd.np
 * @Description:
 * @date 2016/10/19 20:35
 */
public class P05Test {
    @Test
    public void shouldReverseAList() throws Exception {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);
        assertThat(P05.reverse(numbers), is(equalTo(Arrays.asList(5, 4, 3, 2, 1))));
    }

    @Test
    public void shouldReverseAListByStream() throws Exception {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);
        assertThat(P05.reverseStream(numbers), is(equalTo(Arrays.asList(5, 4, 3, 2, 1))));
    }


    @Test
    public void shouldReverseAStringListByStream() throws Exception {
        List<String> numbers = Arrays.asList("aa" , "dfa", "1dfa", "22dfa", "ef");
        assertThat(P05.reverseStream(numbers), is(equalTo(Arrays.asList("ef", "22dfa", "1dfa", "dfa", "aa" ))));
    }

    @Test
    public void shouldReverseALinkedListByStream() throws Exception {
        LinkedList<Integer> numbers = CollectUtils.linkedList(1, 2, 3, 4, 5);
        assertThat(P05.reverseStream(numbers), is(equalTo(Arrays.asList(5, 4, 3, 2, 1))));
    }
}

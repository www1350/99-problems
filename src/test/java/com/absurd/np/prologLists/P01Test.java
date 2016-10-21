package com.absurd.np.prologLists;

import org.junit.Test;

import java.util.Arrays;
import java.util.LinkedList;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

/**
 * @author <a href="mailto:www_1350@163.com">Absurd</a>
 * @version V1.0
 * @Title: 99-problems
 * @Package com.absurd.np
 * @Description:
 * @date 2016/10/19 20:02
 */
public class P01Test {
    @Test
    public void shouldFindLastElementFromAListOfAlphabets() throws Exception {
        assertThat(P01.last(Arrays.asList("a", "b", "c", "d")), is(equalTo("d")));
    }

    @Test
    public void shouldFindLastElementFromALinkListOfAlphabets() throws Exception {
        LinkedList<String> alphabets = CollectUtils.linkedList("a", "b", "c", "d");
        assertThat(P01.last(alphabets), is(equalTo("d")));
    }
}

package com.absurd.np.prologLists;

import org.junit.Test;

import java.util.AbstractMap.SimpleEntry;
import java.util.Arrays;
import java.util.List;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.Matchers.hasSize;
import static org.junit.Assert.assertThat;

/**
 * @author <a href="mailto:www_1350@163.com">Absurd</a>
 * @version V1.0
 * @Title: 99-problems
 * @Package com.absurd.np
 * @Description:
 * @date 2016/10/20 14:15
 */
public class P13Test {

    @Test
    public void shouldEncodeAList() throws Exception {
        List<SimpleEntry<Integer, String>> encodedList = P13.encode_direct(Arrays.asList("a", "a", "a", "a", "b", "c", "c", "a", "a", "d", "e", "e", "e", "e"));
        assertThat(encodedList, hasSize(6));
        assertThat(encodedList.get(0), is(equalTo(new SimpleEntry<>(4, "a"))));
        assertThat(encodedList.get(1), is(equalTo(new SimpleEntry<>(1, "b"))));
        assertThat(encodedList.get(2), is(equalTo(new SimpleEntry<>(2, "c"))));
        assertThat(encodedList.get(3), is(equalTo(new SimpleEntry<>(2, "a"))));
        assertThat(encodedList.get(4), is(equalTo(new SimpleEntry<>(1, "d"))));
        assertThat(encodedList.get(5), is(equalTo(new SimpleEntry<>(4, "e"))));
    }

    @Test
    public void shouldEncodeAList2() throws Exception {
        List<SimpleEntry<Integer, String>> encodedList = P13.encode_direct(Arrays.asList("a", "a", "a", "a", "b", "c", "c", "a", "a", "d", "e", "e", "e", "e","d"));
        assertThat(encodedList, hasSize(7));
        assertThat(encodedList.get(0), is(equalTo(new SimpleEntry<>(4, "a"))));
        assertThat(encodedList.get(1), is(equalTo(new SimpleEntry<>(1, "b"))));
        assertThat(encodedList.get(2), is(equalTo(new SimpleEntry<>(2, "c"))));
        assertThat(encodedList.get(3), is(equalTo(new SimpleEntry<>(2, "a"))));
        assertThat(encodedList.get(4), is(equalTo(new SimpleEntry<>(1, "d"))));
        assertThat(encodedList.get(5), is(equalTo(new SimpleEntry<>(4, "e"))));
        assertThat(encodedList.get(6), is(equalTo(new SimpleEntry<>(1, "d"))));
    }

    @Test
    public void shouldEncodeAList3() throws Exception {
        List<SimpleEntry<Integer, String>> encodedList = P13.encode_direct(Arrays.asList("a"));
        assertThat(encodedList, hasSize(1));
        assertThat(encodedList.get(0), is(equalTo(new SimpleEntry<>(1, "a"))));
    }
}

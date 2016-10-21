package com.absurd.np.prologLists;

import org.junit.Test;

import java.util.AbstractMap.SimpleEntry;
import java.util.Arrays;
import java.util.List;

import static org.hamcrest.Matchers.hasSize;
import static org.junit.Assert.assertThat;

/**
 * @author <a href="mailto:www_1350@163.com">Absurd</a>
 * @version V1.0
 * @Title: 99-problems
 * @Package com.absurd.np
 * @Description:
 * @date 2016/10/20 13:55
 */
public class P12Test {

    @Test
    public void shouldDecodeEncodedList() throws Exception {
        List<String> encoded = P12.decode(
                Arrays.asList(
                        new SimpleEntry<>(4, "a"),
                        "b",
                        new SimpleEntry<>(2, "c"),
                        new SimpleEntry<>(2, "a"),
                        "d",
                        new SimpleEntry<>(4, "e")));

        assertThat(encoded, hasSize(14));
    }


    @Test
    public void shouldDecodeEncodedListByStream() throws Exception {
        List<String> encoded = P12.decode_stream(
                Arrays.asList(
                        new SimpleEntry<>(4, "a"),
                        "b",
                        new SimpleEntry<>(2, "c"),
                        new SimpleEntry<>(2, "a"),
                        "d",
                        new SimpleEntry<>(4, "e")));

        assertThat(encoded, hasSize(14));
    }
}


package com.absurd.np;

import org.junit.Test;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.hamcrest.Matchers.hasSize;
import static org.junit.Assert.assertThat;

/**
 * @author <a href="mailto:www_1350@163.com">Absurd</a>
 * @version V1.0
 * @Title: 99-problems
 * @Package com.absurd.np
 * @Description:
 * @date 2016/10/20 21:01
 */
public class P26Test {
    @Test
    public void shouldFindAllCombinationsOfSize3FromAListWithSize6() throws Exception {
        List<String> input = Stream.of("a", "b", "c", "d", "e", "f").collect(Collectors.toList());
        List<List<String>> combinations = P26.combinations(input, 3);
        assertThat(combinations, hasSize(20));
    }


    @Test
    public void shouldFindAllCombinationsOfSize3FromAListWithSizeByStream() throws Exception {
        List<String> input = Stream.of("a", "b", "c", "d", "e", "f").collect(Collectors.toList());
        List<List<String>> combinations = P26.combinations_stream(input, 3);
        assertThat(combinations, hasSize(20));
    }
}

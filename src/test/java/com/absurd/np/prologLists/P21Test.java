package com.absurd.np.prologLists;

import org.junit.Test;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.hamcrest.Matchers.contains;
import static org.hamcrest.Matchers.hasSize;
import static org.junit.Assert.assertThat;

/**
 * @author <a href="mailto:www_1350@163.com">Absurd</a>
 * @version V1.0
 * @Title: 99-problems
 * @Package com.absurd.np
 * @Description:
 * @date 2016/10/20 17:24
 */
public class P21Test {
    @Test
    public void shouldInsertElementAtSecondPosition() throws Exception {
        List<String> input = Stream.of("a", "b", "c", "d").collect(Collectors.toList());
        List<String> result = P21.insertAt(input, 2, "alfa");
        assertThat(result, hasSize(5));
        assertThat(result, contains("a", "alfa", "b", "c", "d"));

    }

    @Test
    public void shouldInsertElementAtFirstPosition() throws Exception {
        List<String> input = Stream.of("a", "b", "c", "d").collect(Collectors.toList());
        List<String> result = P21.insertAt(input, 1, "alfa");
        assertThat(result, hasSize(5));
        assertThat(result, contains("alfa", "a", "b", "c", "d"));

    }

    @Test
    public void shouldInsertElementAtEnd() throws Exception {
        List<String> input = Stream.of("a", "b", "c", "d").collect(Collectors.toList());
        List<String> result = P21.insertAt(input, 5, "alfa");
        assertThat(result, hasSize(5));
        assertThat(result, contains("a", "b", "c", "d", "alfa"));
    }
}

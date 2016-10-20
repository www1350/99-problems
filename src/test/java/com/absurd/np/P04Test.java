package com.absurd.np;

import org.junit.Test;

import java.util.Arrays;
import java.util.Collections;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

/**
 * @author <a href="mailto:www_1350@163.com">Absurd</a>
 * @version V1.0
 * @Title: 99-problems
 * @Package com.absurd.np
 * @Description:
 * @date 2016/10/19 20:31
 */
public class P04Test {
    @Test
    public void listOfEmptyListShouldBe0() throws Exception {
        int length = P04.lengthStream(Collections.emptyList());
        assertThat(length, is(equalTo(0)));
    }

    @Test
    public void shouldFindListOfNonEmptyList() throws Exception {
        assertThat(P04.lengthStream(Arrays.asList(1, 2, 3, 4, 5)), is(equalTo(5)));
    }
}

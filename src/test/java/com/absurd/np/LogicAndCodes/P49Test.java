package com.absurd.np.LogicAndCodes;

import org.junit.Test;

import java.util.List;

import static org.hamcrest.Matchers.contains;
import static org.junit.Assert.assertThat;

/**
 * Created by wangwenwei on 16/11/6.
 */
public class P49Test {
    @Test
    public void shouldFindGrayCodeWhenNIs1() throws Exception {
        List<String> graySequence = P49.gray(1);
        assertThat(graySequence, contains("0", "1"));
    }

    @Test
    public void shouldFindGrayCodeWhenNIs2() throws Exception {
        List<String> graySequence = P49.gray(2);
        assertThat(graySequence, contains("00", "01", "11", "10"));
    }

    @Test
    public void shouldFindGrayCodeWhenNIs3() throws Exception {
        List<String> graySequence = P49.gray(3);
        assertThat(graySequence, contains("000", "001", "011", "010", "110", "111", "101", "100"));
    }
}

package com.absurd.np.arithmetic;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;

/**
 * Created by wangwenwei on 16/11/6.
 */
public class P41Test {
    @Test
    public void shouldCalculatePhiOf10090UsingP39() throws Exception {
        long p = P39.phi(10090);
        assertThat(p, equalTo(4032L));
    }

    @Test
    public void shouldCalculatePhiOf10090UsingP40() throws Exception {
        long p = P40.phi(10090);
        assertThat(p, equalTo(4032L));
    }
}

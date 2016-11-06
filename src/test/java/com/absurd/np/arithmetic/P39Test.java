package com.absurd.np.arithmetic;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;

/**
 * Created by wangwenwei on 16/11/6.
 */
public class P39Test {
    @Test
    public void shouldSayPhiOf10Is4() throws Exception {
        long phi = P39.phi(10);
        assertThat(phi, equalTo(4L));
    }
}

package com.absurd.np.arithmetic;

import org.junit.Test;

import static org.junit.Assert.assertTrue;

/**
 * Created by wangwenwei on 16/11/6.
 */
public class P38Test {
    @Test
    public void shouldSay35And64IsCoprime() throws Exception {
        boolean coprime = P38.coprime(35, 64);
        assertTrue(coprime);
    }
}

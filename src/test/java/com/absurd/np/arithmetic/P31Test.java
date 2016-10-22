package com.absurd.np.arithmetic;

import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * @author <a href="mailto:www_1350@163.com">Absurd</a>
 * @version V1.0
 * @Title: 99-problems
 * @Package com.absurd.np
 * @Description:
 * @date 2016/10/21 15:10
 */
public class P31Test {
    @Test
    public void shouldSay7IsAPrimeNumber() throws Exception {
        boolean prime = P31.isPrime(7);
        assertTrue(prime);
    }

    @Test
    public void shouldSay10IsNotAPrimeNumber() throws Exception {
        boolean prime = P31.isPrime(3);
        assertFalse(prime);
    }


    @Test
    public void shouldSay1IsNotAPrimeNumber() throws Exception {
        boolean prime = P31.isPrime(1);
        assertFalse(prime);
    }

    @Test
    public void shouldSay2IsAPrimeNumber() throws Exception {
        boolean prime = P31.isPrime(2);
        assertTrue(prime);
    }

    @Test
    public void shouldSay7IsAPrimeNumberByStream() throws Exception {
        boolean prime = P31.isPrime_stream(7);
        assertTrue(prime);
    }

    @Test
    public void shouldSay10IsNotAPrimeNumberByStream() throws Exception {
        boolean prime = P31.isPrime_stream(10);
        assertFalse(prime);
    }


    @Test
    public void shouldSay1IsNotAPrimeNumberByStream() throws Exception {
        boolean prime = P31.isPrime_stream(1);
        assertFalse(prime);
    }

    @Test
    public void shouldSay2IsAPrimeNumberByStream() throws Exception {
        boolean prime = P31.isPrime_stream(2);
        assertTrue(prime);
    }
}

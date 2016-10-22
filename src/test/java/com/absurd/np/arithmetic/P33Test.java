package com.absurd.np.arithmetic;

import org.junit.Test;

import java.util.AbstractMap;
import java.util.List;

import static org.hamcrest.CoreMatchers.hasItems;
import static org.junit.Assert.assertThat;

/**
 * @author <a href="mailto:www_1350@163.com">Absurd</a>
 * @version V1.0
 * @Title: 99-problems
 * @Package com.absurd.np.arithmetic
 * @Description:
 * @date 2016/10/22 10:41
 */
public class P33Test {
    @Test
    public void shouldFindPrimeFactorsOf315() throws Exception {
        List<AbstractMap.SimpleEntry<Integer, Integer>> primeFactors = P33.primeFactorsMult(315);
        assertThat(primeFactors, hasItems(new AbstractMap.SimpleEntry<>(3, 2), new AbstractMap.SimpleEntry<>(5, 1), new AbstractMap.SimpleEntry<>(7, 1)));
    }

    @Test
    public void shouldFindPrimeFactorsOf33() throws Exception {
        List<AbstractMap.SimpleEntry<Integer, Integer>> primeFactors = P33.primeFactorsMult(33);
        assertThat(primeFactors, hasItems(new AbstractMap.SimpleEntry<>(3, 1), new AbstractMap.SimpleEntry<>(11, 1)));
    }


    @Test
    public void shouldFindPrimeFactorsOf315ByStream() throws Exception {
        List<AbstractMap.SimpleEntry<Integer, Integer>> primeFactors = P33.primeFactorsMult_stream(315);
        assertThat(primeFactors, hasItems(new AbstractMap.SimpleEntry<>(3, 2), new AbstractMap.SimpleEntry<>(5, 1), new AbstractMap.SimpleEntry<>(7, 1)));
    }

    @Test
    public void shouldFindPrimeFactorsOf33ByStream() throws Exception {
        List<AbstractMap.SimpleEntry<Integer, Integer>> primeFactors = P33.primeFactorsMult_stream(33);
        assertThat(primeFactors, hasItems(new AbstractMap.SimpleEntry<>(3, 1), new AbstractMap.SimpleEntry<>(11, 1)));
    }
}

package com.absurd.np.arithmetic;

import org.junit.Test;

import java.util.List;

import static org.hamcrest.CoreMatchers.hasItems;
import static org.junit.Assert.assertThat;

/**
 * @author <a href="mailto:www_1350@163.com">Absurd</a>
 * @version V1.0
 * @Title: 99-problems
 * @Package com.absurd.np
 * @Description:
 * @date 2016/10/21 15:28
 */
public class P32Test {
    @Test
    public void shouldFindPrimeFactorsOf315() throws Exception {
        List<Integer> primeFactors = P32.primeFactors(315);
        assertThat(primeFactors, hasItems(3, 3, 5, 7));
    }

    @Test
    public void shouldFindPrimeFactorsOf33() throws Exception {
        List<Integer> primeFactors = P32.primeFactors(33);
        assertThat(primeFactors, hasItems(3, 11));
    }


    @Test
    public void shouldFindPrimeFactorsOf315ByStream() throws Exception {
        List<Integer> primeFactors = P32.primeFactors_stream(315);
        assertThat(primeFactors, hasItems(3, 3, 5, 7));
    }

    @Test
    public void shouldFindPrimeFactorsOf33ByStream() throws Exception {
        List<Integer> primeFactors = P32.primeFactors_stream(33);
        assertThat(primeFactors, hasItems(3, 11));
    }
}

package com.absurd.np.arithmetic;

import org.junit.Test;

import java.util.List;

import static org.hamcrest.Matchers.hasSize;
import static org.junit.Assert.assertThat;

/**
 * @author <a href="mailto:www_1350@163.com">Absurd</a>
 * @version V1.0
 * @Title: 99-problems
 * @Package com.absurd.np.arithmetic
 * @Description:
 * @date 2016/10/22 11:27
 */
public class PrimeUtilsTest {
    @Test
    public void shouldmakAPrimeList() throws Exception {
        List<Integer> list = PrimeUtils.makePrime_sieve(1000);
        assertThat(list,hasSize(168));
    }
}

package com.absurd.np;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.Matchers.containsInAnyOrder;
import static org.hamcrest.Matchers.hasSize;
import static org.junit.Assert.assertThat;

/**
 * @author <a href="mailto:www_1350@163.com">Absurd</a>
 * @version V1.0
 * @Title: 99-problems
 * @Package com.absurd.np
 * @Description:
 * @date 2016/10/20 19:59
 */
public class P23Test {
    @Test
    public void shouldReturnAListOfThreeRandomSelectedElements() throws Exception {
        List<String> result = P23.randomSelect(Arrays.asList("a", "b", "c", "d", "e", "f", "g", "h"), 3);
        System.out.println(result);
        assertThat(result, hasSize(3));

    }

    @Test
    public void shouldReturnAListOfThreeRandomSelectedElementsAll() throws Exception {
        List<String> result = P23.randomSelect(Arrays.asList("a", "b", "c", "d", "e", "f", "g", "h"), 8);
        System.out.println(result);
        assertThat(result, hasSize(8));
        assertThat(result, containsInAnyOrder("a", "b", "c", "d", "e", "f", "g", "h"));

    }


}

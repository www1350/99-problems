package com.absurd.np.prologLists;

import org.junit.Test;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.hamcrest.Matchers.containsInAnyOrder;
import static org.hamcrest.Matchers.hasSize;
import static org.junit.Assert.assertThat;

/**
 * @author <a href="mailto:www_1350@163.com">Absurd</a>
 * @version V1.0
 * @Title: 99-problems
 * @Package com.absurd.np
 * @Description:
 * @date 2016/10/20 20:25
 */
public class P25Test {
    @Test
    public void shouldGenerateRandomPermutationOfElementsOfAList() throws Exception {
        List<String> permutation = P25.randomPermutation(Stream.of("a", "b", "c", "d", "e", "f").collect(Collectors.toList()));
        assertThat(permutation, hasSize(6));
        assertThat(permutation, containsInAnyOrder("a", "b", "c", "d", "e", "f"));
        System.out.println(permutation); // one possible output [a, e, f, c, b, d]
    }
}

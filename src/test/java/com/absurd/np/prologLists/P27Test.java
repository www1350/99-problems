package com.absurd.np.prologLists;

import org.junit.Test;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.hamcrest.Matchers.hasSize;
import static org.junit.Assert.assertThat;

/**
 * @author <a href="mailto:www_1350@163.com">Absurd</a>
 * @version V1.0
 * @Title: 99-problems
 * @Package com.absurd.np
 * @Description:
 * @date 2016/10/21 10:44
 */
public class P27Test {
    @Test
    public void shouldGroupIntoThreeGroupsOfSize_2_3_and_4() throws Exception {
        List<String> input = Stream.of("aldo", "beat", "carla", "david", "evi", "flip", "gary", "hugo", "ida").collect(Collectors.toList());
        List<List<List<String>>> groups = P27.group3(input);
        assertThat(groups, hasSize(1260));
    }

    @Test
    public void shouldGroupIntoThreeGroupsOfSize_2_2_and_5() throws Exception {
        List<String> input = Stream.of("aldo", "beat", "carla", "david", "evi", "flip", "gary", "hugo", "ida").collect(Collectors.toList());
        List<List<List<String>>> groups = P27.group(input, Stream.of(2, 2, 5).collect(Collectors.toList()));
        assertThat(groups, hasSize(756));
    }

}

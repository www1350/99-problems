package com.absurd.np.LogicAndCodes;

import org.junit.Test;

import static org.hamcrest.core.IsEqual.equalTo;
import static org.junit.Assert.assertThat;

/**
 * Created by wangwenwei on 16/11/6.
 */
public class P46Test {
    @Test
    public void shouldGenerateTruthTable() throws Exception {
        String table = P46.table((a, b) -> ExpressionUtils.and(a, ExpressionUtils.or(a, b)));
        String result = "A          B          result\n" +
                "true       true       true\n" +
                "true       false      true\n" +
                "false      true       false\n" +
                "false      false      false";

        assertThat(table, equalTo(result));
    }


}

package com.absurd.np.LogicAndCodes;

import org.junit.Test;

import static org.hamcrest.core.IsEqual.equalTo;
import static org.junit.Assert.assertThat;

/**
 * Created by wangwenwei on 16/11/6.
 */
public class P48Test {
    @Test
    public void shouldGenerateTruthTable() throws Exception {
        String table = P48.table(
                (a, b,c) ->
                        ExpressionUtils.equ(ExpressionUtils.and(a,ExpressionUtils.and(b,c))
                                ,ExpressionUtils.and(ExpressionUtils.and(a,b),ExpressionUtils.and(a,c))
                                )
        );
        String result = "A          B          C          result\n" +
                "true       true       true       true\n" +
                "true       true       false      true\n"+
                "true       false      true       true\n"+
                "true       false      false      true\n"+
                "false      true       true       true\n"+
                "false      true       false      true\n"+
                "false      false      true       true\n"+
                "false      false      false      true";

        assertThat(table, equalTo(result));
    }


}

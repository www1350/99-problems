package com.absurd.np.binaryTrees;

import org.junit.Test;

import static org.junit.Assert.assertTrue;

/**
 * @author <a href="mailto:wangwenwei@myhexin.com">王文伟</a>
 * @Company:浙江核新同花顺网络信息股份有限公司
 * @Title: ninetynine_problems
 * @Package com.absurd.np.binaryTrees
 * @Description:
 * @date 2016/12/8 16:07
 */
public class P54ATest {
    @Test
    public void  check_a_given_null_is_a_tree(){
        assertTrue(P54A.isTree(null));
    }

    @Test
    public void check_a_given_term_is_a_tree(){
        assertTrue(P54A.isTree(new BinaryTree("a",
                null,
                new BinaryTree("b",
                        null,
                        new BinaryTree("c",null,null))
                                            )
                            )
                    );
    }


}

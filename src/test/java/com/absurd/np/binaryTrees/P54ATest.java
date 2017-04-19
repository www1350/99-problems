package com.absurd.np.binaryTrees;

import org.junit.Test;

import static org.junit.Assert.assertTrue;


/****
 *
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

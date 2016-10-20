package com.absurd.np;

import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * @author <a href="mailto:www_1350@163.com">Absurd</a>
 * @version V1.0
 * @Title: 99-problems
 * @Package com.absurd.np
 * @Description:
 * @date 2016/10/20 10:19
 */
public class P06Test {

    @Test
    public void shouldReturnTrueWhenListIsPalindrome() throws Exception {
        assertTrue(P06.isPalindrome(Arrays.asList("x", "a", "m", "a", "x")));
    }

    @Test
    public void shouldReturnFalseWhenListIsNotPalindrome() throws Exception {
        assertFalse(P06.isPalindrome(Arrays.asList(1, 2, 3, 4, 5)));
    }


    @Test
    public void shouldReturnTrueWhenListIsPalindromeByStream() throws Exception {
        assertTrue(P06.isPalindrome_Stream(Arrays.asList("x", "a", "m", "a", "x")));
    }

    @Test
    public void shouldReturnFalseWhenListIsNotPalindromeByStream() throws Exception {
        assertFalse(P06.isPalindrome_Stream(Arrays.asList(1, 2, 3, 4, 5)));
    }
}

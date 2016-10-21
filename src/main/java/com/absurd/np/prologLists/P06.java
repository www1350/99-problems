package com.absurd.np.prologLists;

import java.util.List;

/**
 * @author <a href="mailto:www_1350@163.com">Absurd</a>
 * @version V1.0
 * @Title: 99-problems
 * @Package com.absurd.np
 * @Description:
 *  Find out whether a list is a palindrome
 * @date 2016/10/20 10:18
 */
public class P06 {
    public static <T> boolean isPalindrome(List<T> list){
        if(list == null){
            throw new IllegalArgumentException("list can't be null");
        }
        int size = list.size();
        for (int i = 0; i < size/2; i++) {
            if(!list.get(i) .equals(list.get(size-1-i))) return false;
        }
        return true;
    }

    public static <T> boolean isPalindrome_Stream(List<T> list){
        if(list == null){
            throw new IllegalArgumentException("list can't be null");
        }

        return P05.reverseStream(list).equals(list);
    }

}

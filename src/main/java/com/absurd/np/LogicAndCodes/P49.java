package com.absurd.np.LogicAndCodes;

import com.absurd.np.prologLists.CollectUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * An n-bit Gray code is a sequence of n-bit strings constructed according to certain rules. For example,
 * n = 1: C(1) = ['0','1'].
 * n = 2: C(2) = ['00','01','11','10'].
 * n = 3: C(3) = ['000','001','011','010','110','111','101','100'].
 * Created by wangwenwei on 16/11/6.
 */
public class P49 {

    /***
     * 格雷码，每次只要往上一次结果前面加0或者1，加0和加1顺序说反过来的
     * @param n
     * @return
     */
    public static List<String> gray(int n) {
        if(n==1){
            return Arrays.asList("0","1");
        }
        List<String> zeroList = gray(n-1);
        List<String> oneList = new ArrayList<>(zeroList);
        Collections.reverse(oneList);
        return Stream
                .concat(zeroList.stream().map(e->"0"+e),oneList.stream().map(e->"1"+e))
                .collect(Collectors.toList());
    }
}

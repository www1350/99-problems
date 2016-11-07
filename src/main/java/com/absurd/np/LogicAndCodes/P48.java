package com.absurd.np.LogicAndCodes;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.BiPredicate;
import java.util.stream.Collectors;

/**
 * Created by wangwenwei on 16/11/6.
 */
public class P48 {
    public static String table(TriPredicate<Boolean, Boolean,Boolean> f) {
        List<String> stringBuilder = new ArrayList<>();
        stringBuilder.add("A          B          C          result");
        for(Boolean a: Arrays.asList(true,false)){
            for (Boolean b:Arrays.asList(true,false)){
                for (Boolean c:Arrays.asList(true,false)){
                    stringBuilder.add(String.format("%-10s %-10s %-10s %s",a,b,c,f.test(a,b,c)));
                }
            }

        }
   return  stringBuilder.stream().collect(Collectors.joining("\n"));


    }
}

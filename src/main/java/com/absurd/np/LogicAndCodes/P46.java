package com.absurd.np.LogicAndCodes;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.BiPredicate;
import java.util.stream.Collectors;

/**
 * Define predicates and/2, or/2, nand/2, nor/2, xor/2, impl/2 and equ/2 (for logical equivalence) which succeed or fail according to the result of their respective operations;
 * e.g. and(A,B) will succeed, if and only if both A and B succeed.
 * Note that A and B can be Prolog goals (not only the constants true and fail).
 * A logical expression in two variables can then be written in prefix notation, as in the following example:
 * and(or(A,B),nand(A,B)).
 * Now, write a predicate table/3 which prints the truth table of a given logical expression in two variables.
 * Created by wangwenwei on 16/11/6.
 */
public class P46 {
    public static String table(BiPredicate<Boolean, Boolean> f) {
List<String> stringBuilder = new ArrayList<>();
        stringBuilder.add("A          B          result");
        for(Boolean a: Arrays.asList(true,false)){
            for(Boolean b: Arrays.asList(true,false)){
                stringBuilder.add(String.format("%-10s %-10s %s",a,b,f.test(a,b)));
            }

        }
        return stringBuilder.stream().collect(Collectors.joining("\n"));
    }



}

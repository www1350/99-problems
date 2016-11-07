package com.absurd.np.LogicAndCodes;

/**
 * Created by wangwenwei on 16/11/6.
 */
@FunctionalInterface
public interface TriPredicate<A,B,C> {
    boolean test(A a,B b,C c);
}

package com.wrh.java8.lambda;

/**
 * @author Simple
 * @description: 练习题3
 * @date 2020/11/29
 */
@FunctionalInterface
public interface LongLambda<T,R> {

    public R longLambda(T t1,T t2);
}

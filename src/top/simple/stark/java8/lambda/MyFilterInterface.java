package top.simple.stark.java8.lambda;

/**
 * @author Simple
 * @description: 过滤接口
 * @date 2020/11/27
 */
@FunctionalInterface
public interface MyFilterInterface<T> {

    public boolean filter(T t);
}

package top.simple.stark.java8.lambda;

/**
 * 过滤接口
 * @author Simple
 * @date 2020/11/27
 */
@FunctionalInterface
public interface MyFilterInterface<T> {

    boolean filter(T t);
}

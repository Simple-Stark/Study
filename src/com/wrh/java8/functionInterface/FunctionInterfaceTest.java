package com.wrh.java8.functionInterface;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

/**
 * @author Simple
 * @description: Java内置的四大函数式接口的认识及简单应用
 * @date 2020/11/29
 */
public class FunctionInterfaceTest {

    /**
     * Consumer<T>: 消费型接口
     */
    @Test
    public void Test1() {
        Happy(1000.0, x -> System.out.println("今天消费了" + x + "元"));
    }

    public void Happy(Double money, Consumer<Double> consumer) {
        consumer.accept(money);
    }

    /**
     * Supplier<T>: 供给型接口
     * 需求：产生指定个数的偶数，并放入集合中
     */
    @Test
    public void Test2() {
        List<Integer> numList = getNumList(5, () -> {
            int num = (int) (Math.random() * 100);
            if (num % 2 == 0) {
                return num;
            } else {
                return num + 1;
            }
        });
        numList.forEach(System.out::println);
    }

    public List<Integer> getNumList(int num, Supplier<Integer> supplier) {
        List<Integer> resultList = new ArrayList<>(num);
        for (int i = 0; i < num; i++) {
            resultList.add(supplier.get());
        }
        return resultList;
    }

    /**
     * function<T,R>: 函数型接口
     * 需求：处理字符串，返回转换为大写
     */
    @Test
    public void Test3() {
        String s = strHandler("hello test", x -> x.toUpperCase());
        System.out.println(s);
    }

    public String strHandler(String s, Function<String,String> function) {
        return function.apply(s);
    }

    /**
     * Predicate<T>: 断言型接口
     * 需求：判断是否为偶数
     */
    @Test
    public void Test4() {
        List<Integer> integers = Arrays.asList(2, 29, 23, 45, 62, 34, 31);
        List<Integer> integers1 = filterEvenNum(integers, x -> x % 2 == 0);
        integers1.forEach(System.out::println);
    }

    public List<Integer> filterEvenNum(List<Integer> ints, Predicate<Integer> predicate) {
        List<Integer> result = new ArrayList<>();
        for (Integer anInt : ints) {
            if (predicate.test(anInt)) {
                result.add(anInt);
            }
        }
        return result;
    }

}

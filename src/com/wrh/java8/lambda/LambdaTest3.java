package com.wrh.java8.lambda;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * @author Simple
 * @description: Lambda表达式练习
 * @date 2020/11/29
 */
public class LambdaTest3 {

    // 员工信息表
    List<Employee> employees = Arrays.asList(
            new Employee("张三",23,9999.99),
            new Employee("李四",38,7777.77),
            new Employee("王五",55,3333.33),
            new Employee("赵六",18,6666.66)
    );

    /**
     * 调用Collections.sort()方法，通过定制排序比较两个Employee（先按年龄比，年龄相同按姓氏比），使用Lambda作为参数传递
     */
    @Test
    public void Test1() {
        Collections.sort(this.employees,(e1,e2) -> {
            if (e1.getAge() == e2.getAge()) {
                return e1.getName().compareTo(e2.getName());
            } else {
                return -e1.getAge().compareTo(e2.getAge());
            }
        });

        employees.forEach(System.out::println);
    }

    /**
     * 声明函数式接口，接口中声明抽象方法，public String getValue(String str),
     * 声明类TestLambda，类中编写方法使用接口作为参数，将一个字符串转化为大写并返回。
     * 再将一个字符串的第二个和第四个索引位置进行截取字符串
     */
    @Test
    public void Test2() {
        // 转换为大写
        System.out.println(StringLambdaMethod("Hello Lambda", x -> x.toUpperCase()));
        // 截取索引从二到四的字符串
        System.out.println(StringLambdaMethod("Hello Lambda", x -> x.substring(2,4)));

    }

    public String StringLambdaMethod(String str, StringLambda stringLambda) {
        return stringLambda.getValue(str);
    }

    /**
     * 声明一个带两个泛型的函数式接口，泛型类型为<T,R> T为参数，R为返回值
     * 接口中声明对应的抽象方法
     * 声明类TestLambda，使用接口作为参数，计算两个Long型参数的和
     * 再计算两个Long型参数的积
     */
    @Test
    public void Test3() {
        // 计算两个Long型参数的和
        System.out.println(LongHelper(100L,10L,(x,y) -> x + y));
        // 计算两个Long型参数的和
        System.out.println(LongHelper(100L,10L,(x,y) -> x * y));
    }

    public Long LongHelper(Long l1, Long l2, LongLambda<Long,Long> longLambda) {
        return longLambda.longLambda(l1,l2);
    }
}

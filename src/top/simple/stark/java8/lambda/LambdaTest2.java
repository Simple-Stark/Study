package top.simple.stark.java8.lambda;

import org.junit.jupiter.api.Test;

import java.util.Comparator;
import java.util.function.Consumer;

/**
 * @author Simple
 * @description: Lambda表达式语法格式
 * @date 2020/11/29
 */
public class LambdaTest2 {

    /**
     * 语法格式一：无参数，无返回值。
     */
    @Test
    public void Test1() {
        Runnable r = new Runnable() {
            @Override
            public void run() {
                System.out.println("Hello World!");
            }
        };
        r.run();

        System.out.println("---------------------");

        Runnable r1 = () -> System.out.println("Hello Lambda");
        r1.run();
    }

    /**
     * 语法格式二：有一个参数，无返回值
     * 语法格式三：若只有一个参数，那么参数的小括号，可以省略不写。
     */
    @Test
    public void Test2() {
        Consumer<String> c = (x) -> System.out.println("Hello " + x);
        c.accept("Consumer1");

        Consumer<String> c1 = x -> System.out.println("Hello " + x);
        c1.accept("Consumer2");
    }

    /**
     * 语法格式四：有两个以上的参数，有返回值，并且Lambda体中有多条语句。
     * 语法格式五：在四的基础上，如果Lambda体只有一条语句，那么return和大括号可以省略。
     */
    @Test
    public void Test3() {
        Comparator<Integer> com = (x,y) -> {
            System.out.println("函数式接口！");
            return Integer.compare(x,y);
        };

        Comparator<Integer> com1 = (x,y) -> Integer.compare(x,y);
    }
}

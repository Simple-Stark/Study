package top.simple.stark.java8.lambda;

import org.junit.jupiter.api.Test;

import java.io.PrintStream;
import java.util.Comparator;
import java.util.function.*;

/**
 * Lambda之方法引用
 * @author Simple
 * @date 2021/1/5 22:13
 * @change: 2021/1/5 22:13 by Simple for init
 */
public class MethodRefTest {

    /*
    * 方法引用：若Lambda体中的内容有方法已经实现了，我们可以使用"方法引用"
    *           （可以理解为方法引用是Lambda表达式的另一种表现形式）
    * 语法格式
    *
    * 对象::实例方法名
    *
    * 类::静态方法名
    *
    * 类::实例方法名
    *
    * 注意：
    *  1.Lambda体中调用方法的参数列表与返回类型，要与函数式接口中抽象方法的函数列表和返回类型保持一致
    *  2.若Lambda 参数列表中的第一个参数是实例方法的调用者，而第二个参数是实例方法的参数时可以使用 ClassName::MethodName
    *
    * 构造器引用
    *
    *   语法格式
    *   类名::new
    * 注意：需要调用的构造器的参数列表需要与函数式接口中的抽象方法的参数列表保持一致
    *
    * 数组引用：
    *   Type[]::new
    *
    */

    // 对象::实例方法名
    @Test
    public void Test1() {
        Consumer<String> con = x -> System.out.println(x);

        PrintStream out = System.out;
        Consumer<String> con1 = out::println;
        con1.accept("abcdef");
    }

    @Test
    public void Test2() {
        Employee emp = new Employee("zhangsan",18,2222.22);
        Supplier<String> sup = emp::getName;
        System.out.println(sup.get());

        Supplier<Integer> sup1 = emp::getAge;
        System.out.println(sup1.get());
    }

    // 类::静态方法名
    @Test
    public void Test3() {
        Comparator<Integer> com = (x,y) -> Integer.compare(x,y);
        Comparator<Integer> com1 = Integer::compareTo;
    }

    // 类::实例方法名
    @Test
    public void Test4() {
        BiPredicate<String,String> bip = (x,y) -> x.equals(y);

        BiPredicate<String,String> bip1 = String::equals;
    }

    // 构造器引用
    @Test
    public void Test5() {
        Supplier<Employee> sup = () -> new Employee();

        Supplier<Employee> sup1 = Employee::new;
        Employee employee = sup1.get();
        System.out.println(employee);

        Function<String,Employee> fun = Employee::new;
        Employee apply = fun.apply("李四");
        System.out.println(apply);

        BiFunction<String,Integer,Employee> fun2 = Employee::new;
        Employee apply1= fun2.apply("王五", 20);
        System.out.println(apply1);
    }

    // 数组引用
    @Test
    public void Test6() {
        Function<Integer,String[]> fun = x -> new String[x];
        Function<Integer,String[]> fun1 = String[]::new;
        String[] apply = fun1.apply(10);
        System.out.println(apply.length);
    }
}

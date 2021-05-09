package top.simple.stark.java8.stream;

import org.junit.jupiter.api.Test;
import top.simple.stark.java8.lambda.Employee;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Stream
 * @author Simple
 * @date 2021/5/9 11:56
 * @change 2021/5/9 11:56 by wangruoheng@bonc.com.cn for init
 */
public class StreamTest {

    // 员工信息表
    List<Employee> employees = Arrays.asList(
            new Employee("张三",23,9999.99),
            new Employee("李四",38,7777.77),
            new Employee("王五",55,3333.33),
            new Employee("赵六",18,6666.66)
    );

    // 获得员工列表中所有年龄大于35的员工的姓名
    @Test
    public void test1() {
        List<String> names = employees.stream()
                .filter(e -> e.getAge() > 35)
                .map(Employee::getName)
                .collect(Collectors.toList());

        names.forEach(System.out::println);
    }

    // reduce示例
    @Test
    public void test2() {
        Double sumSalary = employees.stream()
                .map(Employee::getSalary)
                .reduce(Double::sum)
                .get();

        Double sumSalary1 = employees.stream()
                .map(Employee::getSalary)
                .reduce((a,b) -> a+b )
                .get();

        System.out.println(sumSalary);
        System.out.println(sumSalary.equals(sumSalary1));
    }

    // reduce2示例
    @Test
    public void test3() {
        Double sumSalary = employees.stream()
                .map(Employee::getSalary)
                .reduce(100.0,(a, b) -> a + b );

        System.out.println(sumSalary);
    }

    // reduce3示例
    @Test
    public void test4() {
        List<Integer> numList = Arrays.asList(Integer.MAX_VALUE,Integer.MAX_VALUE);
        long result = numList.stream().reduce(0L,(a,b) ->  a + b, (a,b)-> 0L );
        System.out.println(result);
    }


    @Test
    public void test5(){
        List<Integer> numList = Arrays.asList(1, 2, 3, 4, 5, 6);
        ArrayList<String> result = numList.stream().reduce(new ArrayList<String>(), (a, b) -> {
            a.add("element-" + b);
            return a;
        }, (a, b) -> null);
        System.out.println(result);
    }
}

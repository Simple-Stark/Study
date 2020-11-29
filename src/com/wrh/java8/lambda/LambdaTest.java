package com.wrh.java8.lambda;

import org.junit.jupiter.api.Test;

import java.util.*;

/**
 * @description: 认识Lambda表达式
 * @author Simple
 * @date 2020/11/27
 */
public class LambdaTest {

    @Test
    public void Test1() {
        // 原来的匿名内部类
        Comparator<Integer> comparator = new Comparator<Integer>() {

            @Override
            public int compare(Integer o1, Integer o2) {
                return Integer.compare(o1,o2);
            }
        };

        TreeSet<Integer> treeSet = new TreeSet<>(comparator);
    }

    @Test
    public void Test2() {
        // Lambda表达式
        Comparator<Integer> comparator = (x,y) -> Integer.compare(x,y);
        TreeSet<Integer> treeSet = new TreeSet<>(comparator);
    }

    // 员工信息表
    List<Employee> employees = Arrays.asList(
            new Employee("张三",23,9999.99),
            new Employee("李四",38,7777.77),
            new Employee("王五",55,3333.33),
            new Employee("赵六",18,6666.66)
    );

    // 需求：获取员工年龄大于35岁的员工信息
    public List<Employee> filterEmployee(List<Employee> list) {
        List<Employee> result = new ArrayList<>();

        for (Employee employee : list) {
            if (employee.getAge() > 35) {
                result.add(employee);
            }
        }
        return result;
    }

    @Test
    public void Test3() {
        List<Employee> employees = filterEmployee(this.employees);
        for (Employee employee : employees) {
            System.out.println(employee);
        }
    }

    // 需求变更：获取员工薪资大于4000的员工信息
    public List<Employee> filterEmployeeBySalary(List<Employee> list) {
        List<Employee> result = new ArrayList<>();

        for (Employee employee : list) {
            if (employee.getSalary() > 4000) {
                result.add(employee);
            }
        }
        return result;
    }

    @Test
    public void Test4() {
        List<Employee> employees = filterEmployeeBySalary(this.employees);
        for (Employee employee : employees) {
            System.out.println(employee);
        }
    }

    // 优化方式一：设计模式---策略设计模式
    public List<Employee> filterEmployee1(List<Employee> list, MyFilterInterface<Employee> myFilterInterface) {
        List<Employee> result = new ArrayList<>();

        for (Employee employee : list) {
            if (myFilterInterface.filter(employee)) {
                result.add(employee);
            }
        }
        return result;
    }

    @Test
    public void Test5() {
        List<Employee> employees = filterEmployee1(this.employees,new EmployeeFilterByAge());
        System.out.println("年龄大于35");
        for (Employee employee : employees) {
            System.out.println(employee);
        }

        List<Employee> employees1 = filterEmployee1(this.employees, new EmployeeBySalary());
        System.out.println("工资高于4000");
        for (Employee employee : employees1) {
            System.out.println(employee);
        }
    }

    // 优化方式二：匿名内部类,不用重新创建接口的实现类
    @Test
    public void Test6() {
        List<Employee> list = filterEmployee1(this.employees, new MyFilterInterface<Employee>() {
            @Override
            public boolean filter(Employee employee) {
                return employee.getAge() > 35;
            }
        });

        System.out.println("年龄大于35");
        for (Employee employee : list) {
            System.out.println(employee);
        }

        List<Employee> list2 = filterEmployee1(this.employees, new MyFilterInterface<Employee>() {
            @Override
            public boolean filter(Employee employee) {
                return employee.getSalary() > 4000;
            }
        });

        System.out.println("工资高于4000");
        for (Employee employee : list2) {
            System.out.println(employee);
        }
    }

    // 优化方法三：lambda表达式(在策略模式的基础上)
    @Test
    public void Test7() {
        List<Employee> employees = filterEmployee1(this.employees, (e) -> e.getAge() > 35);
        System.out.println("年龄大于35");
        employees.forEach(System.out::println);
    }

    // 优化方式四：Lambda表达式 + Stream
    @Test
    public void Test8() {
        // 获取员工年龄大于35岁的员工信息
        this.employees.stream()
                .filter(e -> e.getAge() > 35)
                .forEach(System.out::println);

        System.out.println("--------------------");

        // 获取员工年龄大于35岁的员工姓名
        this.employees.stream()
                .filter(e -> e.getAge() > 35)
                .map(e -> e.getName())
                .forEach(System.out::println);
    }
}

package top.simple.stark.java8.lambda;

/**
 * 过滤出年龄大于35的
 * @author Simple
 * @date 2020/11/27
 */
public class EmployeeFilterByAge implements MyFilterInterface<Employee>{

    @Override
    public boolean filter(Employee employee) {
        return employee.getAge() > 35;
    }
}

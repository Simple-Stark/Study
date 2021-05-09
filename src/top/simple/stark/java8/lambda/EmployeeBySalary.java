package top.simple.stark.java8.lambda;

/**
 * 过滤工资大于4000的
 * @author Simple
 * @date 2020/11/27
 */
public class EmployeeBySalary implements MyFilterInterface<Employee>{
    @Override
    public boolean filter(Employee employee) {
        return employee.getSalary() > 4000;
    }
}

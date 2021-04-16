package top.simple.stark.java8.lambda;

/**
 * @author Simple
 * @description: TODO
 * @date 2020/11/27
 */
public class EmployeeFilterByAge implements MyFilterInterface<Employee>{

    @Override
    public boolean filter(Employee employee) {
        return employee.getAge() > 35;
    }
}

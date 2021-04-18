package top.simple.stark.reflex;

import org.junit.jupiter.api.Test;

/**
 * 描述内容
 *
 * @author Simple
 * @date 2021/4/18 15:37
 * @change 2021/4/18 15:37 by wangruoheng@bonc.com.cn for init
 */
public class ReflexTest {

    @Test
    public void Test1() {
        Animal cat = new Cat();
        cat.say();
        Animal dog = new Dog();
        dog.say();
    }

    /**
     * 获取Class的几种方式
     */
    @Test
public void Test2() throws ClassNotFoundException {
    // 方式一 类Class
    Class personClass = Person.class;

    // 方式二 实例.getClass()
    Person person = new Person();
    Class personClass1 = person.getClass();

    // 方式三 Class.forName("类的全路径")
    Class personClass2 = Class.forName("top.simple.stark.reflex.Person");

    System.out.println(personClass == personClass1);
    System.out.println(personClass == personClass2);
}
}

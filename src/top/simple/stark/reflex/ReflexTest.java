package top.simple.stark.reflex;

import org.junit.jupiter.api.Test;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;

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

    @Test
    public void Test3() throws Exception {
        // 1.获取Class对象
        Class personClazz = Class.forName("top.simple.stark.reflex.Person");
        // 2.获取构造函数
        // 有参构造
        Constructor constructor1 = personClazz.getConstructor(String.class, Integer.class,Byte.class,Boolean.class);
        // 无参构造
        Constructor constructor = personClazz.getConstructor();
        // 3.创建对象（有参）
        Person person1 = (Person) constructor1.newInstance("张三",18,(byte)11,false);
        System.out.println(person1.toString());
        // 创建对象 无参
        Person person = (Person) constructor.newInstance();
        person.setName("simple");
        System.out.println(person.toString());

        System.out.println(person == person1);
    }

    @Test
    public void Test4() throws Exception {
        // 1.获取Class对象
        Class<?> personClazz = Class.forName("top.simple.stark.reflex.Person");
        // public属性的获取
        // 2.获取name对应的Field
        Field nameField = personClazz.getField("name");

        // private 属性的获取
        // 2.获取sex对应的Field
        Field sexField = personClazz.getDeclaredField("sex");
        // 将sexField设置为可以访问,如果缺少这个代码，获取时将会出现异常
        sexField.setAccessible(true);

        // protected 属性的获取
        // 2.获取age对应的Field
        Field ageField = personClazz.getDeclaredField("age");
        // 与private同理
        ageField.setAccessible(true);

        // default 属性的获取
        // 2.获取isMarriage对应的Field
        Field isMarriageField = personClazz.getDeclaredField("isMarriage");
        isMarriageField.setAccessible(true);

        // 3.创建一个person对象
        Constructor constructor = personClazz.getConstructor();
        Person person = (Person) constructor.newInstance();

        // 4.获取该对象的name属性的值
        String name = (String) nameField.get(person);
        System.out.println("name:" + name);
        // 4.获取该对象的sex属性的值
        Byte sex = (Byte) sexField.get(person);
        System.out.println("sex:" + sex);
        // 4.获取该对象的age属性的值
        Integer age = (Integer) ageField.get(person);
        System.out.println("age:" + age);
        // 4.获取该对象的isMarriage 属性的值
        Boolean isMarriage = (Boolean) isMarriageField.get(person);
        System.out.println("isMarriage:" + isMarriage);

        // 5.Field的常用方法 参考Field.toString();
         /** Field.toString();
         * --------------------------------------------------------------------
         * public String toString() {
         *         int mod = getModifiers();
         *         return (((mod == 0) ? "" : (Modifier.toString(mod) + " "))
         *             + getType().getTypeName() + " "
         *             + getDeclaringClass().getTypeName() + "."
         *             + getName());
         * }
         */
        System.out.println("Field.toString():" + nameField.toString());
        System.out.println("获取字段的类型:" + nameField.getType());
        System.out.println("获取字段的名字:" + nameField.getName());
        System.out.println("获取字段的访问修饰符:" + Modifier.toString(nameField.getModifiers()));
        System.out.println("获取字段所在类的全路径:" + nameField.getDeclaringClass().getName());
    }
}

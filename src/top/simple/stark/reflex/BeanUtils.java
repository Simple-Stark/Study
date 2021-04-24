package top.simple.stark.reflex;

import java.lang.reflect.Field;

/**
 * 反射应用：实现将一个对象属性相同的值赋值给另一个对象
 *
 * @author Simple
 * @date 2021/4/24 17:37
 * @change 2021/4/24 17:37 by wangruoheng@bonc.com.cn for init
 */
public class BeanUtils {

    /**
     * 拷贝对象值
     * @param oldObj 被转换的对象
     * @param newObj 目标转换对象
     * @throws IllegalAccessException
     */
    public static void convertor(Object oldObj,Object newObj) throws IllegalAccessException {
        // 1. 获取Class对象
        Class<?> oldObjClass = oldObj.getClass();
        Class<?> newObjClass = newObj.getClass();
        // 2.获取属性值，必须使用getDeclaredFields(),否则非public修饰的字段将无法复制
        Field[] oldObjFields = oldObjClass.getDeclaredFields();
        Field[] newObjFields = newObjClass.getDeclaredFields();

        // 3. 赋值
        for (Field oldObjField : oldObjFields) {
            for (Field newObjField : newObjFields) {
                // 属性相同则赋值
                if (oldObjField.getName().equals(newObjField.getName())) {
                    // 使能够赋值
                    oldObjField.setAccessible(true);
                    newObjField.setAccessible(true);
                    newObjField.set(newObj,oldObjField.get(oldObj));
                }
            }
        }
    }

    public static void main(String[] args) throws Throwable{
        // Service层返回的
        Person person = new Person("muse", 10, (byte)1, true);

        // 需要返回给前段实体对象
        PersonVo personVo = new PersonVo();

        BeanUtils.convertor(person, personVo);

        System.out.println("person" + person);

        System.out.println("personVo" + personVo);

    }

}

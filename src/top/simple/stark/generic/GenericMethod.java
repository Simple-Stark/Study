package top.simple.stark.generic;

/**
 * 泛型方法
 *
 * @author Simple
 * @date 2021/4/26 9:33
 * @change 2021/4/26 9:33 by wangruoheng@bonc.com.cn for init
 */
public class GenericMethod {

    // 泛型方法语法，使用前需要先声明<T>
    public static <T> void show(T t) {
        System.out.println(t);
    }
}

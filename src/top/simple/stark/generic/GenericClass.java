package top.simple.stark.generic;

/**
 * 描述内容
 *
 * @author Simple
 * @date 2021/4/25 19:53
 * @change 2021/4/25 19:53 by wangruoheng@bonc.com.cn for init
 */
public class GenericClass<T> {
    private T obj;

    public T getObj() {
        return obj;
    }

    public void setObj(T obj) {
        this.obj = obj;
    }
}

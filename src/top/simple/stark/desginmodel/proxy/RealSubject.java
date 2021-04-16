package top.simple.stark.desginmodel.proxy;

/**
 * 真实对象
 *
 * @author Simple
 * @date 2021/4/11 18:39
 */
public class RealSubject implements Subject {
    @Override
    public void request() {
        System.out.println("具体的业务实现。");
    }
}

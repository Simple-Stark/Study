package top.simple.stark.desginmodel.proxy;

/**
 * 真实对象One
 *
 * @author Simple
 * @date 2021/4/11 18:24
 */
public class RealOneSubject implements Subject{

    @Override
    public void request() {
        System.out.println("RealOneSubject具体的业务实现。");
    }
}

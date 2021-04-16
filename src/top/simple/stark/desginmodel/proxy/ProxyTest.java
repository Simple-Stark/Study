package top.simple.stark.desginmodel.proxy;

import org.junit.jupiter.api.Test;

/**
 * 测试类
 *
 * @author Simple
 * @date 2021/4/10 18:24
 */
public class ProxyTest {

    /*-------------静态代理-------------*/

    @Test
    public void Test() {
        Subject subject = new ProxySubject(new RealSubject());
        subject.request();
    }

    /*-------------JDK动态代理-------------*/

    @Test
    public void Test1() {
        ProxyJDKSubject proxy = new ProxyJDKSubject();
        // 真实角色测试1
        Subject instance = proxy.getInstance(new RealSubject());
        instance.request();

    }
    /*-----------------CGLIB动态代理-----------------*/

    @Test
    public void Test2() {
        ProxyCgLibSubject proxy = new ProxyCgLibSubject();
        RealSubject instance = (RealSubject) proxy.getInstance(new RealSubject());
        instance.request();
    }
}

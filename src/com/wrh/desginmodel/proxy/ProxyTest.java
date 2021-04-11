package com.wrh.desginmodel.proxy;

import org.junit.jupiter.api.Test;

/**
 * 描述内容
 *
 * @author Simple
 * @date 2021/4/10 18:24
 * @change 2021/4/10 18:24 by wangruoheng@bonc.com.cn for init
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
        RealOneSubject instance = (RealOneSubject) proxy.getInstance(new RealOneSubject());
        instance.request();
    }
}

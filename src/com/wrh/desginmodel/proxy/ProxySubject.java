package com.wrh.desginmodel.proxy;

/**
 * 静态代理
 *
 * @author Simple
 * @date 2021/4/11 18:39
 */
public class ProxySubject implements Subject {

    private Subject subject;

    public ProxySubject(final Subject subject) {
        this.subject = subject;
    }

    @Override
    public void request() {
        beforeRequest();
        subject.request();
        afterRequest();
    }

    void beforeRequest () {
        System.out.println("beforeRequest");
    }

    void afterRequest () {
        System.out.println("afterRequest");
    }
}

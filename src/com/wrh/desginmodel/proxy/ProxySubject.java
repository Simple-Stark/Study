package com.wrh.desginmodel.proxy;

/**
 * 描述内容
 *
 * @author Simple
 * @date 2021/4/11 18:39
 * @change 2021/4/11 18:39 by wangruoheng@bonc.com.cn for init
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

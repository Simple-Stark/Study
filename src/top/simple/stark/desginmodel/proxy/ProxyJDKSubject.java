package top.simple.stark.desginmodel.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * JDK动态代理
 *
 * @author Simple
 * @date 2021/4/11 18:40
 */
public class ProxyJDKSubject implements InvocationHandler {

    private Subject subject;

    public Subject getInstance(Subject subject) {
        this.subject = subject;
        Class<?> clazz = subject.getClass();
        return (Subject) Proxy.newProxyInstance(clazz.getClassLoader(), clazz.getInterfaces(), this);
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        beforeRequest();
        Object invoke = method.invoke(this.subject, args);
        afterRequest();
        return invoke;
    }

    void beforeRequest () {
        System.out.println("beforeRequest");
    }

    void afterRequest () {
        System.out.println("afterRequest");
    }
}

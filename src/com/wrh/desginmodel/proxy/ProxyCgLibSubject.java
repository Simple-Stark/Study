package com.wrh.desginmodel.proxy;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * CGLIB动态代理
 *
 * @author Simple
 * @date 2021/4/11 18:25
 */
public class ProxyCgLibSubject implements MethodInterceptor {

    public Object getInstance(final Object target) {
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(target.getClass());
        enhancer.setCallback(new ProxyCgLibSubject());
        return enhancer.create();
    }

    @Override
    public Object intercept(Object sub, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        beforeRequest();
        Object object = methodProxy.invokeSuper(sub, objects);
        afterRequest();
        return object;
    }

    void beforeRequest () {
        System.out.println("beforeRequest");
    }

    void afterRequest () {
        System.out.println("afterRequest");
    }
}

package com.wrh.desginmodel.proxy;

/**
 * 描述内容
 *
 * @author Simple
 * @date 2021/4/11 18:24
 * @change 2021/4/11 18:24 by wangruoheng@bonc.com.cn for init
 */
public class RealOneSubject implements Subject{

    public void request() {
        System.out.println("RealOneSubject具体的业务实现。");
    }
}

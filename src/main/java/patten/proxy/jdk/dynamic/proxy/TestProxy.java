/**
 * Alibaba.com Inc.
 * Copyright (c) 2004-2022 All Rights Reserved.
 */
package patten.proxy.jdk.dynamic.proxy;

import java.lang.reflect.Proxy;

/**
 *
 * @author wenxiangqin
 * @version $Id: Test.java, v 0.1 2022-01-04 10:57 上午 wenxiangqin Exp $$
 */
public class TestProxy {
    public static void main(String[] args) {
        IHello proxyInstance = (IHello) Proxy.newProxyInstance(IHello.class.getClassLoader(), new Class[]{IHello.class}, new MyInvocationHandler(new HelloImpl()));
        proxyInstance.sayHello();
    }
}
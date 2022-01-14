/**
 * Alibaba.com Inc.
 * Copyright (c) 2004-2022 All Rights Reserved.
 */
package patten.proxy.jdk.dynamic.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 *
 * @author wenxiangqin
 * @version $Id: MyInvocationHandler.java, v 0.1 2022-01-04 10:55 上午 wenxiangqin Exp $$
 */
public class MyInvocationHandler implements InvocationHandler {

    private Object object;

    public MyInvocationHandler(Object o) {
        this.object = o;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("say hello before");
        Object invoke = method.invoke(object, args);
        System.out.println("say hellp after");
        return invoke;
    }
}
/**
 * Alibaba.com Inc.
 * Copyright (c) 2004-2022 All Rights Reserved.
 */
package patten.proxy.jdk.cglib;

import java.lang.reflect.Method;

import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

/**
 *
 * @author wenxiangqin
 * @version $Id: MyIntercepyor.java, v 0.1 2022-01-04 11:12 上午 wenxiangqin Exp $$
 */
public class MyInterceptor implements MethodInterceptor {
    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        System.out.println("Say hello before");
        Object invokeSuper = methodProxy.invokeSuper(o, objects);
        System.out.println("Say hello after");
        return invokeSuper;
    }
}
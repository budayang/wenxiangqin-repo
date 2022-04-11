/**
 * Alibaba.com Inc.
 * Copyright (c) 2004-2022 All Rights Reserved.
 */
package springsourcecode.service;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

import springsourcecode.spring.BeanPostProcessor;
import springsourcecode.spring.Component;

/**
 *
 * @author wenxiangqin
 * @version $Id: MyBeanPostProcessor.java, v 0.1 2022-04-09 11:04 上午 wenxiangqin Exp $$
 */
@Component
public class MyBeanPostProcessor implements BeanPostProcessor {
    @Override
    public Object postProcessBeforeInitiallization(String beanName, Object bean) {
        if (beanName.equals("userService")) {
            System.out.println("I am userService before");
        }
        return bean;
    }

    @Override
    public Object postProcessAfterInitiallization(String beanName, Object bean) {
        if (beanName.equals("userService")) {
            System.out.println("I am userService after");
            Object proxyInstance = Proxy.newProxyInstance(MyBeanPostProcessor.class.getClassLoader(), bean.getClass().getInterfaces(), new InvocationHandler() {
                @Override
                public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                    System.out.println("切面逻辑");
                    return method.invoke(bean, args);
                }
            });
            return proxyInstance;
        }
        return bean;
    }
}
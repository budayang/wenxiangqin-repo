/**
 * Alibaba.com Inc.
 * Copyright (c) 2004-2022 All Rights Reserved.
 */
package patten.proxy.jdk.cglib;

import net.sf.cglib.proxy.Enhancer;

/**
 *
 * @author wenxiangqin
 * @version $Id: Client.java, v 0.1 2022-01-04 11:16 上午 wenxiangqin Exp $$
 */
public class Client {
    public static void main(String[] args) {
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(HelloService.class);
        enhancer.setCallback(new MyInterceptor());
        HelloService proxyInstance = (HelloService) enhancer.create();
        proxyInstance.sayHello();
        proxyInstance.sayOthers();
    }
}
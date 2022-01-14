/**
 * Alibaba.com Inc.
 * Copyright (c) 2004-2022 All Rights Reserved.
 */
package patten.proxy.jdk.cglib;

/**
 *
 * @author wenxiangqin
 * @version $Id: HelloService.java, v 0.1 2022-01-04 11:10 上午 wenxiangqin Exp $$
 */
public class HelloService {

    public HelloService() {
        System.out.println("HelloService construct");
    }

    public void sayHello() {
        System.out.println("say hello.....");
    }
    final public void sayOthers() {
        System.out.println("say others....");
    }
}
/**
 * Alibaba.com Inc.
 * Copyright (c) 2004-2022 All Rights Reserved.
 */
package patten.proxy.jdk.dynamic.proxy;

/**
 *
 * @author wenxiangqin
 * @version $Id: HelloImpl.java, v 0.1 2022-01-04 10:55 上午 wenxiangqin Exp $$
 */
public class HelloImpl implements IHello{
    @Override
    public void sayHello() {
        System.out.println("Hello China");
    }
}
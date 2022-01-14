/**
 * Alibaba.com Inc.
 * Copyright (c) 2004-2022 All Rights Reserved.
 */
package patten.proxy.jdk.statics.proxy;

/**
 *
 * @author wenxiangqin
 * @version $Id: TestStaticProxy.java, v 0.1 2022-01-04 11:06 上午 wenxiangqin Exp $$
 */
public class TestStaticProxy {
    public static void main(String[] args) {
        UserDao userDao = new UserDaoImpl();
        UserDao transactionHandler = new TransactionHandler(userDao);
        transactionHandler.save();
    }
}
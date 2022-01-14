/**
 * Alibaba.com Inc.
 * Copyright (c) 2004-2022 All Rights Reserved.
 */
package patten.proxy.jdk.statics.proxy;

/**
 *
 * @author wenxiangqin
 * @version $Id: TransactionHandler.java, v 0.1 2022-01-04 11:05 上午 wenxiangqin Exp $$
 */
public class TransactionHandler implements UserDao{

    private UserDao userDao;

    public TransactionHandler(UserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    public void save() {
        System.out.println("开启事物");
        userDao.save();
        System.out.println("关闭事物");
    }
}
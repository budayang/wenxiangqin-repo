/**
 * Alibaba.com Inc.
 * Copyright (c) 2004-2022 All Rights Reserved.
 */
package patten.proxy.jdk.statics.proxy;

/**
 *
 * @author wenxiangqin
 * @version $Id: UserDaoImpl.java, v 0.1 2022-01-04 11:04 上午 wenxiangqin Exp $$
 */
public class UserDaoImpl implements UserDao{
    @Override
    public void save() {
        System.out.println("save user.....");
    }
}
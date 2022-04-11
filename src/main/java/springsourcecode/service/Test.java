/**
 * Alibaba.com Inc.
 * Copyright (c) 2004-2022 All Rights Reserved.
 */
package springsourcecode.service;

import springsourcecode.spring.MyApplicationContext;

/**
 *
 * @author wenxiangqin
 * @version $Id: Test.java, v 0.1 2022-04-09 9:52 上午 wenxiangqin Exp $$
 */
public class Test {
    public static void main(String[] args) {

        MyApplicationContext myApplicationContext = new MyApplicationContext(AppConfig.class);
//        System.out.println(myApplicationContext.getBean("userService"));
//        System.out.println(myApplicationContext.getBean("userService"));
//        System.out.println(myApplicationContext.getBean("userService"));
//        System.out.println(myApplicationContext.getBean("orderService"));
        UserInterface userService = (UserInterface) myApplicationContext.getBean("userService");
        userService.test();
    }
}
/**
 * Alibaba.com Inc.
 * Copyright (c) 2004-2022 All Rights Reserved.
 */
package springsourcecode.service;

import springsourcecode.spring.Autowired;
import springsourcecode.spring.BeanNameAware;
import springsourcecode.spring.Component;
import springsourcecode.spring.InitializingBean;
import springsourcecode.spring.Scope;

/**
 *
 * @author wenxiangqin
 * @version $Id: UserService.java, v 0.1 2022-04-09 9:52 上午 wenxiangqin Exp $$
 */

@Component("userService")
//@Scope("prototype")
public class UserService implements UserInterface {

    @Autowired
    private OrderService orderService;

//    private String beanName;
//
//    private String initialization;

    @Override
    public void test() {
        System.out.println(orderService);
    }

//    @Override
//    public void setBeanName(String beanName) {
//        this.beanName = beanName;
//    }

//    @Override
//    public void afterPropertiesSet() {
//        System.out.println("初始化方法");
//    }
}
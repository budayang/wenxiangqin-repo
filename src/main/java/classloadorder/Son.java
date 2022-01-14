/**
 * Alibaba.com Inc.
 * Copyright (c) 2004-2021 All Rights Reserved.
 */
package classloadorder;

/**
 *
 * @author wenxiangqin
 * @version $Id: Son.java, v 0.1 2021-12-16 2:23 下午 wenxiangqin Exp $$
 */
public class Son extends Father {
    static {
        System.out.println("Son static block");
    }

    public Son() {
        System.out.println("Son contruction method");
    }
}
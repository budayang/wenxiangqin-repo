/**
 * Alibaba.com Inc.
 * Copyright (c) 2004-2021 All Rights Reserved.
 */
package classloadorder;

/**
 *
 * @author wenxiangqin
 * @version $Id: Father.java, v 0.1 2021-12-16 2:20 下午 wenxiangqin Exp $$
 */
public class Father {
    static {
        System.out.println("Father static block");
    }

    public Father() {
        System.out.println("Father contruction method");
    }
}
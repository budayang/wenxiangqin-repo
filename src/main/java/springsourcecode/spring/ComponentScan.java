/**
 * Alibaba.com Inc.
 * Copyright (c) 2004-2022 All Rights Reserved.
 */
package springsourcecode.spring;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 *
 * @author wenxiangqin
 * @version $Id: Component.java, v 0.1 2022-04-09 9:55 上午 wenxiangqin Exp $$
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
public @interface ComponentScan {

    String value() default "";
}
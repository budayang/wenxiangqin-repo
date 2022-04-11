/**
 * Alibaba.com Inc.
 * Copyright (c) 2004-2022 All Rights Reserved.
 */
package springsourcecode.spring;

/**
 *
 * @author wenxiangqin
 * @version $Id: BeanPostProcessor.java, v 0.1 2022-04-09 11:02 上午 wenxiangqin Exp $$
 */
public interface BeanPostProcessor {

    Object postProcessBeforeInitiallization(String beanName, Object bean);
    Object postProcessAfterInitiallization(String beanName, Object bean);
}
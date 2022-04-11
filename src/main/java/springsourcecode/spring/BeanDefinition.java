/**
 * Alibaba.com Inc.
 * Copyright (c) 2004-2022 All Rights Reserved.
 */
package springsourcecode.spring;

/**
 *
 * @author wenxiangqin
 * @version $Id: BeanDefinition.java, v 0.1 2022-04-09 10:24 上午 wenxiangqin Exp $$
 */
public class BeanDefinition {

    private Class type;
    private String scope;

    /**
     * Getter method for property type.
     *
     * @return property value of type
     */
    public Class getType() {
        return type;
    }

    /**
     * Setter method for property type.
     *
     * @param type value to be assigned to property type
     */
    public void setType(Class type) {
        this.type = type;
    }

    /**
     * Getter method for property scope.
     *
     * @return property value of scope
     */
    public String getScope() {
        return scope;
    }

    /**
     * Setter method for property scope.
     *
     * @param scope value to be assigned to property scope
     */
    public void setScope(String scope) {
        this.scope = scope;
    }
}
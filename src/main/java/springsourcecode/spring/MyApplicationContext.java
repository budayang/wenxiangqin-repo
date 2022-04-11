/**
 * Alibaba.com Inc.
 * Copyright (c) 2004-2022 All Rights Reserved.
 */
package springsourcecode.spring;

import java.beans.Introspector;
import java.io.File;
import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;


/**
 *
 * @author wenxiangqin
 * @version $Id: MyApplicationContext.java, v 0.1 2022-04-09 9:53 上午 wenxiangqin Exp $$
 */
public class MyApplicationContext {

    private Class configClass;

    private ConcurrentHashMap<String, BeanDefinition> beanDefinitionMap = new ConcurrentHashMap<>();
    private ConcurrentHashMap<String, Object> singletonBeanMap = new ConcurrentHashMap<>();

    private List<BeanPostProcessor> beanPostProcessorList = new ArrayList<>();

    public MyApplicationContext(Class configClass) {
        this.configClass = configClass;

        /** 扫描 */
        if (configClass.isAnnotationPresent(ComponentScan.class)) {
            ComponentScan componentScanAnnotation = (ComponentScan) configClass.getAnnotation(ComponentScan.class);
            // 包名
            String path = componentScanAnnotation.value();
            path = path.replace(".", "/");

            ClassLoader classLoader = MyApplicationContext.class.getClassLoader();
            URL resource = classLoader.getResource(path);

            File file = new File(resource.getFile());
            if (file.isDirectory()) {
                File[] files = file.listFiles();
                for (File f : files) {
                    String fileName = f.getAbsolutePath();
                    System.out.println(fileName);

                    if (fileName.endsWith(".class")) {
                        String className = fileName.substring(fileName.indexOf("springsourcecode"), fileName.indexOf(".class"));

                        className = className.replace("/", ".");

                        System.out.println(className);
                        try {
                            Class<?> clazz = classLoader.loadClass(className);
                            if (clazz.isAnnotationPresent(Component.class)) {

                                if (BeanPostProcessor.class.isAssignableFrom(clazz)) {
                                    BeanPostProcessor instance = (BeanPostProcessor) clazz.newInstance();
                                    beanPostProcessorList.add(instance);
                                }

                                // BeanDefinition
                                BeanDefinition beanDefinition = new BeanDefinition();
                                beanDefinition.setType(clazz);
                                if (clazz.isAnnotationPresent(Scope.class)) {
                                    Scope scopeAnnotation = clazz.getAnnotation(Scope.class);
                                    beanDefinition.setScope(scopeAnnotation.value());
                                } else {
                                    beanDefinition.setScope("singleton");
                                }
                                Component component = clazz.getAnnotation(Component.class);
                                String beanName = component.value();
                                if (beanName.equals("")) {
                                    beanName = Introspector.decapitalize(clazz.getSimpleName());
                                }
                                beanDefinitionMap.put(beanName, beanDefinition);
                            }
                        } catch (ClassNotFoundException e) {
                            e.printStackTrace();
                        } catch (IllegalAccessException e) {
                            e.printStackTrace();
                        } catch (InstantiationException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        }

        /** 创建单例bean对象 */
        for (String beanName : beanDefinitionMap.keySet()) {
            BeanDefinition beanDefinition = beanDefinitionMap.get(beanName);
            if (beanDefinition.getScope().equals("singleton")) {
                Object bean = createBean(beanName, beanDefinition);
                singletonBeanMap.put(beanName, bean);
            }
        }
    }

    private Object createBean(String beanName, BeanDefinition beanDefinition) {
        Class clazz = beanDefinition.getType();
        Object instance = null;
        try {
            instance = clazz.getConstructor().newInstance();

            // 依赖注入
            for (Field f : clazz.getDeclaredFields()) {
                if (f.isAnnotationPresent(Autowired.class)) {
                    f.setAccessible(true);
                    f.set(instance, getBean(f.getName()));
                }
            }

            // 回调方法实现 Aware
            if (instance instanceof BeanNameAware) {
                ((BeanNameAware) instance).setBeanName(beanName);
            }


            // 初始化前 BeanPostProcessor
            for (BeanPostProcessor beanPostProcessor : beanPostProcessorList) {
                instance = beanPostProcessor.postProcessBeforeInitiallization(beanName, instance);
            }

            // 初始化方法
            if (instance instanceof InitializingBean) {
                ((InitializingBean) instance).afterPropertiesSet();
            }

            // 初始化后 AOP BeanPostProcessor
            for (BeanPostProcessor beanPostProcessor : beanPostProcessorList) {
                instance = beanPostProcessor.postProcessAfterInitiallization(beanName, instance);
            }

            return instance;
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }
        return null;
    }

    public Object getBean(String beanName) {
        // beanName
        BeanDefinition beanDefinition = beanDefinitionMap.get(beanName);
        if (beanDefinition == null) {
            throw new NullPointerException();
        } else {
            String scope = beanDefinition.getScope();
            if (scope.equals("singleton")) {
                // 单例
                Object bean = singletonBeanMap.get(beanName);
                if (bean == null) {
                    Object objBean = createBean(beanName, beanDefinition);
                    singletonBeanMap.put(beanName, objBean);
                }
                return bean;
            } else {
                // 多例
                return createBean(beanName, beanDefinition);
            }
        }
    }
}
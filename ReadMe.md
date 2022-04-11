# `循环依赖`

bServiceBean的生命周期
循环依赖--->提前进行AOP
0、creatingSet<'BService'>
1、实例化--->BService普通对象--->singletonFactories.put("BService", () -> getEarlyBeanReference(beanName, mbd, bean))
2、填充aServiceBean--->单例池Map--->创建AService
    2.1、实例化--->普通对象
    2.2、填充bService--->单例池Map--->creatingSet--->BService出现了循环依赖--->earlySingletonObjects--->singletonFactories--->lambda表达式--->执行lambda表达式
    --->AOP--->BService代理对象（需要先获得BService普通对象）--->Map(earlySingletonObjects)
    2.3、填充其它属性
    2.4、做一些其它事情(AOP)
    2.5、添加到实例池

**2、填充cServiceBean--->单例池Map--->创建CService
    2.1、实例化--->普通对象
    2.2、填充bService--->单例池Map--->creatingSet--->BService出现了循环依赖--->earlySingletonObjects
    2.3、填充其它属性
    2.4、做一些其它事情(AOP)
    2.5、添加到实例池**

3、填充普通对象其它属性

4、做一些其它的事情(AOP)--->BService代理对象
    4.1、earlySingletonObjects.get("BService")--->经过了Bean的完整生命周期

5、添加到单例池

6、creatingSet.remove<'BService'>

三级缓存
第一级缓存：singletonObjects（完整生命周期的对象）
第二级缓存：earlySingletonObjects（代理对象）
第三级缓存：singletonFactories（打破循环）

earlyProxyReferences（从这个Map中判断是否已经生成过Bean）

# `spring-mybatis`

FactoryBean ---> 工厂Bean（生产Bean对象）

class MyFactoryBean implements FactoryBean {

    @Override
    public Object getObject() {
        // 生产Bean
    }
    
}


AnnotationConfigApplicationContext application = new AnnotationConfigApplicationContext();
applcation.register(Appconfig.class);

AbstractBeanDefinition beanDefinition = BeanDefinitionBuilder.genericBeanDefinition().getBeanDefinition();
beanDefinition.setBeanClass(MyBeanFactory.class);
beanDefinition.getContructorArgumentValues().addGenericArgumentValue(UserMappper.class);

application.registerBeanDefinition("userMapper", beanDefinition);
application.refresh();

applationContext.getBean("myFactoryBean") ---> 被代理的对象
applationContext.getBean("&myFactoryBean") ---> myFactoryBean对象

BeanFactory ---> Spring基础容器

ImportBeanDefinitionRegistrar --->

# `Spring扫描`

扫描中ASM技术(不需要提前加载类到JVM中，可以获取类的相关信息)
ClassReader classReader = new ClassReader(inputStream);

excludeFilter匹配机制（排除bean）
includeFilter匹配机制（存在默认的过滤器，@Component，@Named，~~@ManagedBean~~默认这三个过滤器）

抽象类 
@Lookup("orderService")只是找到这个对象，不会执行这个注解的方法



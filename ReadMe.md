Bean 生命周期：
总结：
1、实例化、
2、属性赋值、
3、初始化（涉及了 Aware、BeanPostProcessor、InitializingBean、init-method 的概念）、
4、销毁


1、Spring 中提供的 Aware 接口有：
    1.1、BeanNameAware：注入当前 bean 对应 beanName；
    1.2、BeanClassLoaderAware：注入加载当前 bean 的 ClassLoader；
    1.3、BeanFactoryAware：注入 当前BeanFactory容器 的引用。

2、BeanPostProcessor
    BeanPostProcessor 是 Spring 为修改 bean提供的强大扩展点，其可作用于容器中所有 bean，其定义如下：
    public interface BeanPostProcessor { 
    // 初始化前置处理 default Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException { return bean; } 
    // 初始化后置处理 default Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException { return bean; } }
    2.1、对于标记接口的实现类，进行自定义处理。
    2.2、为当前对象提供代理实现。例如 Spring AOP 功能，生成对象的代理类，然后返回。

3、InitializingBean 和 init-method
    InitializingBean 和 init-method 是 Spring 为 bean 初始化提供的扩展点。
    InitializingBean接口 的定义如下：
    public interface InitializingBean { void afterPropertiesSet() throws Exception; } 复制代码
    在 afterPropertiesSet() 方法写初始化逻辑。
    指定 init-method 方法，指定初始化方法

4、DisposableBean接口，执行销毁destory方法、destory-method方法

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



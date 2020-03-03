# Spring

[toc]

## 理解Spring框架要思考的几个问题

- BeanFactory中的Bean从何而来？
- Bean如何从定义信息变成Bean？
- 如果想在BeanFactory创建之前或之后对BeanFactory进行操作怎么办？
- 如果想在Bean创建之前或之后对BeanFactory进行操作怎么办？
- 环境如何加载？
- 如何监听BeanFactory容器的状态？

## key方法——refresh详解

```java
public void refresh() throws BeansException, IllegalStateException {
		synchronized (this.startupShutdownMonitor) {
			// Prepare this context for refreshing.
            /**
             * 准备环境
             * 1. 改变相应参数
             * 2. 将系统参数加载到environment中(environment是applicationContext的私有变量)
             * 3. 初始化listener，即将earlyListener赋给listener，并将earlyListener制空
             */
			prepareRefresh();

			// Tell the subclass to refresh the internal bean factory.
            /**
             * 获取BeanFactory
             * 1. 初始化BeanFactory实例
             * 2. 更改相应参数
             * 3. 加载BeanDefinition
             */
			ConfigurableListableBeanFactory beanFactory = obtainFreshBeanFactory();

			// Prepare the bean factory for use in this context.
            /**
             * 在BeanFactory中添加相应数据
             * 1. 添加回调接口
             * 2. 添加特殊注入参数到BeanFactory（BeanFactory，ApplicationContext,事件发布器，资源加载器）
             * 3. 将环境（Env）注册到BeanFactory中
             */
			prepareBeanFactory(beanFactory);

			try {
				// Allows post-processing of the bean factory in context subclasses.
                /**
                 * 允许子类对执行BeanFactory执行相应操作
                 */
				postProcessBeanFactory(beanFactory);

				// Invoke factory processors registered as beans in the context.
                /**
                 * 执行BeanFactoryPostProcessor
                 * 1、对BeanFactoryPostProcessor进行分类、排序
                 * 2、如果BeanFactoryPostProcessor是其子类，调用其子接口方法
                 * 3、执行BeanFactoryPostProcessor
                 */
				invokeBeanFactoryPostProcessors(beanFactory);

				// Register bean processors that intercept bean creation.
                /**
                 * 在Bean创建之前对注册BeanProcessor
                 * 1、对BeanProcessor进行分类、排序
                 * 2、注册BeanProcessor到BeanFactory
                 */
				registerBeanPostProcessors(beanFactory);

				// Initialize message source for this context.
                /**
                 * 在BeanFactory中注册MessageSource
                 */
				initMessageSource();

				// Initialize event multicaster for this context.
                /**
                 * 在BeanFactory中注册事件分发器
                 */
				initApplicationEventMulticaster();

				// Initialize other special beans in specific context subclasses.
                /**
                 * 在子类中初始化特殊bean
                 */
				onRefresh();

				// Check for listener beans and register them.
                /**
                 * 在BeanFactory中注册监听器
                 */
				registerListeners();

				// Instantiate all remaining (non-lazy-init) singletons.
                /**
                 * 实例化单例bean（非懒加载）
                 * 1. 从单例缓存中获取，获取到则返回，否则执行下述步骤
                 * 2. 解决依赖问题，实例化需要依赖的Bean
                 * 3. 执行postProcessorBeforeInitation
                 * 4. 若postProcessorBeforeInitation返回bean，则拿这个bean作为实例，并执行postProcessorAfterInitation，否则执行下一步
                 * 5. 实例化bean
                 * 6. 执行BeanDefinitionPostProcossor
                 * 7. 执行postProcessAfterInstantiation
                 * 8. 提取需要注入的属性
                 * 9. 注入属性
                 * 10. 调用生命周期方法
                 */
				finishBeanFactoryInitialization(beanFactory);

				// Last step: publish corresponding event.
                /**
                 * 发布相应事件
                 */
				finishRefresh();
			}

			catch (BeansException ex) {
				if (logger.isWarnEnabled()) {
					logger.warn("Exception encountered during context initialization - " +
							"cancelling refresh attempt: " + ex);
				}

				// Destroy already created singletons to avoid dangling resources.
				destroyBeans();

				// Reset 'active' flag.
				cancelRefresh(ex);

				// Propagate exception to caller.
				throw ex;
			}

			finally {
				// Reset common introspection caches in Spring's core, since we
				// might not ever need metadata for singleton beans anymore...
				resetCommonCaches();
			}
		}
	}
```

## Spring关键接口

- BeanDefinition：Bean定义信息
- BeanFactory：Bean工厂
- BeanFactoryPostProcessor：Bean工厂增强
- BeanPostProcessor：Bean增强
- Environment

## Spring常见问题

- Bean的生命周期
- 如何解决循环依赖问题
- SpringAOP


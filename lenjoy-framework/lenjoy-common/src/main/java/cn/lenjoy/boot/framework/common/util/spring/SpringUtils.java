package cn.lenjoy.boot.framework.common.util.spring;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.BeanDefinitionRegistryPostProcessor;
import org.springframework.beans.factory.support.GenericBeanDefinition;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

import javax.annotation.Nonnull;

/**
 * @description: Spring 上下文工具类
 * @author: lenjoy's bincloud,mvpzhou
 * @date: Create By lenjoy's bincloud,mvpzhou on 2022 08 14 星期日
 * @version: 1.0.0
 */
@Component
@SuppressWarnings("unused")
public final class SpringUtils implements BeanFactoryPostProcessor, ApplicationContextAware, BeanDefinitionRegistryPostProcessor {

    private SpringUtils(){}

    private static ConfigurableListableBeanFactory beanFactory;
    private static ApplicationContext applicationContext;
    private static BeanDefinitionRegistry beanDefinitionRegistry;


    @Override
    public synchronized void postProcessBeanFactory(@Nonnull ConfigurableListableBeanFactory beanFactory) throws BeansException {
        SpringUtils.beanFactory = beanFactory;
    }

    @Override
    public synchronized void setApplicationContext(@Nonnull ApplicationContext applicationContext) throws BeansException {
        SpringUtils.applicationContext = applicationContext;
    }

    @Override
    public synchronized void postProcessBeanDefinitionRegistry(@Nonnull BeanDefinitionRegistry beanDefinitionRegistry) throws BeansException {
        SpringUtils.beanDefinitionRegistry = beanDefinitionRegistry;
    }

    @SuppressWarnings("unchecked")
    public static <T> T getBean(String name) throws BeansException {
        return (T) beanFactory.getBean(name);
    }

    public static <T> T getBean(String name, Class<T> clazz) throws BeansException {
        return beanFactory.getBean(name, clazz);
    }

    public static boolean containsBean(String name) {
        return beanFactory.containsBean(name);
    }

    @SuppressWarnings("unchecked")
    public static <T> T getBeanBy(String name) throws BeansException {
        return (T) applicationContext.getBean(name);
    }

    public static <T> T getBeanBy(String name, Class<T> clazz) throws BeansException {
        return applicationContext.getBean(name, clazz);
    }

    public static boolean containsBeanBy(String name) {
        return applicationContext.containsBean(name);
    }

    public static <T> void registerBeanBy(String name, Class<T> clazz) {
        GenericBeanDefinition genericBeanDefinition = new GenericBeanDefinition();
        genericBeanDefinition.setBeanClass(clazz);
        beanDefinitionRegistry.registerBeanDefinition(name, genericBeanDefinition);
    }
}

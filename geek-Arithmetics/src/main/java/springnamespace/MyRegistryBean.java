package springnamespace;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.BeanDefinitionRegistryPostProcessor;
import org.springframework.beans.factory.support.GenericBeanDefinition;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.core.io.ClassPathResource;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

import java.util.concurrent.CountDownLatch;

/**
 * @ClassName MyRegistryBean
 * @Author Leo
 * @Description //TODO
 * @Date: 2019/1/5 15:35
 **/

public class MyRegistryBean implements ApplicationContextAware, BeanDefinitionRegistryPostProcessor {

    private ApplicationContext ctx;

    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {
    }

    @Override
    public void postProcessBeanDefinitionRegistry(BeanDefinitionRegistry beanDefinitionRegistry) throws BeansException {

        String[] names = ctx.getBeanNamesForType(Leo.class);
        for (String name : names) {
            Leo leo = (Leo) ctx.getBean(name);
            String serviceName = leo.getInterfaces();
            Class clazz = null;
            try {
                clazz = Class.forName(serviceName);
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
            BeanDefinitionBuilder builder = BeanDefinitionBuilder.genericBeanDefinition(clazz);
            GenericBeanDefinition definition = (GenericBeanDefinition) builder.getRawBeanDefinition();
            definition.getPropertyValues().add("interfaceClass", definition.getBeanClassName());
            definition.setBeanClass(MyProxyFactory.class);
            definition.setAutowireMode(GenericBeanDefinition.AUTOWIRE_BY_TYPE);
            // 注册bean名,一般为类名首字母小写
            beanDefinitionRegistry.registerBeanDefinition(name, definition);
        }


    }

    @Override
    public void setApplicationContext(ApplicationContext ctx) throws BeansException {
        this.ctx = ctx;
    }

}

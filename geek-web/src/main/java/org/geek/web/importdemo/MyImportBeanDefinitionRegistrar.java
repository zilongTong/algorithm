package org.geek.web.importdemo;

import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.RootBeanDefinition;
import org.springframework.context.annotation.ImportBeanDefinitionRegistrar;
import org.springframework.core.type.AnnotationMetadata;

/**
 * @ClassName MyImportBeanDefinitionRegistrar
 * @Author Leo
 * @Description //TODO
 * @Date: 2019/1/21 14:11
 **/
public class MyImportBeanDefinitionRegistrar implements ImportBeanDefinitionRegistrar {
    @Override
    public void registerBeanDefinitions(AnnotationMetadata annotationMetadata, BeanDefinitionRegistry beanDefinitionRegistry) {
        // new一个RootBeanDefinition
        RootBeanDefinition rootBeanDefinition = new RootBeanDefinition(Rectangle.class);
        // 注册一个名字叫rectangle的bean
        beanDefinitionRegistry.registerBeanDefinition("rectangle", rootBeanDefinition);
    }
}

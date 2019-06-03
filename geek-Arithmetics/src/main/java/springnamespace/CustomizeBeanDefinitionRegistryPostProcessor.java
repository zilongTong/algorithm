package springnamespace;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.BeanDefinitionRegistryPostProcessor;
import org.springframework.beans.factory.support.RootBeanDefinition;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

/**
 * @ClassName CustomizeBeanDefinitionRegistryPostProcessor
 * @Author Leo
 * @Description //TODO
 * @Date: 2018/12/31 14:14
 **/
public class CustomizeBeanDefinitionRegistryPostProcessor implements BeanDefinitionRegistryPostProcessor, ApplicationContextAware {

    private ApplicationContext context;

    @Override
    public void postProcessBeanDefinitionRegistry(BeanDefinitionRegistry beanDefinitionRegistry) throws BeansException {
        //打印当前堆栈信息
        Leo leo = (Leo) context.getBean("leoTon");
        Utils.printTrack("execute postProcessBeanDefinitionRegistry");
//        Proxy proxy = new Proxy();
        String serviceName = leo.getInterfaces();
        Class clazz = null;
        try {
            clazz = Class.forName(serviceName);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        ILeoService service = (ILeoService) RpcProxy.create(clazz);
//        ILeoService leoService  = (ILeoService) proxy.create(service.getClass());
//        创建一个bean的定义类的对象，bean类型是CalculateServiceImpl
        RootBeanDefinition registerBean = new RootBeanDefinition(service.getClass());
//        bean的定义注册到spring环境
        beanDefinitionRegistry.registerBeanDefinition("leoService", registerBean);
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.context = applicationContext;
    }

    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory configurableListableBeanFactory) throws BeansException {
        //打印当前堆栈信息
        Utils.printTrack("execute postProcessBeanFactory");
    }
}

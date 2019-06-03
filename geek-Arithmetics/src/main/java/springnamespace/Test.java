package springnamespace;

import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.support.GenericBeanDefinition;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Calendar;

/**
 * @ClassName Test
 * @Author Leo
 * @Description //TODO
 * @Date: 2018/12/20 11:36
 **/
public class Test {

    public static void main(String[] args) {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("/spring/leo_spring.xml");
//        ILeoService leoService = (ILeoService) ctx.getBean("leoService");
//        System.out.println(0);
//        leoService.cool("222");
//        System.out.println(1);
//        Leo leo = (Leo) ctx.getBean("leoTon");
////        Proxy proxy = new Proxy();
//        String serviceName = leo.getInterfaces();
//        Class clazz = null;
//        try {
//            clazz = Class.forName(serviceName);
//        } catch (ClassNotFoundException e) {
//            e.printStackTrace();
//        }
////        ILeoService service = (ILeoService) proxy.create(clazz);
////        System.out.println(service.cool("11"));
//        JavassistProxyFactory02 jpf02 = new JavassistProxyFactory02();
//        System.out.println("---------------------------------------");
//        ILeoService a2 = null;
//        try {
//            a2 = (ILeoService) jpf02.getProxy(ILeoService.class);
//        } catch (InstantiationException e) {
//        } catch (IllegalAccessException e) {
//            e.printStackTrace();
//        }
//        a2.cool("111");
    }
}

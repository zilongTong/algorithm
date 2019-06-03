package springnamespace;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @ClassName Start
 * @Author Leo
 * @Description //TODO
 * @Date: 2019/1/5 15:40
 **/
public class Start {

    public static void main(String[] args) {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("/spring/leo_spring.xml");
        ILeoService leoService = (ILeoService) ctx.getBean("leoService");
        ITonService tonService = (ITonService) ctx.getBean("tonService");
        System.out.println(leoService.cool("11"));
        System.out.println(tonService.say());
    }
}

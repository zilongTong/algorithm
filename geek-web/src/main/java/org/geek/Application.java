package org.geek;

import org.geek.web.importdemo.MainConfig;
import org.geek.web.importdemo.Rectangle;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

@SpringBootApplication
public class Application {

    public static void main(String[] args) {

        AnnotationConfigApplicationContext applicationContext2 = new AnnotationConfigApplicationContext(MainConfig.class);
        String[] beanNames = applicationContext2.getBeanDefinitionNames();
        Rectangle rectangle = (Rectangle) applicationContext2.getBean("rectangle");
        System.out.println("1111111111" + rectangle);
        rectangle.say();
        for (int i = 0; i < beanNames.length; i++) {
            System.out.println("bean名称为===" + beanNames[i]);
        }

		SpringApplication.run(Application.class, args);
    }

}

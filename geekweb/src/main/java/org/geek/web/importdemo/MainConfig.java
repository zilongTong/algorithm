package org.geek.web.importdemo;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

/**
 * @ClassName MainConfig
 * @Author Leo
 * @Description //TODO
 * @Date: 2019/1/21 14:01
 **/
//@Import({Square.class,Circular.class})
//@Import({Square.class,Circular.class,MyImportSelector.class})
@Import({Square.class,Circular.class,MyImportSelector.class,MyImportBeanDefinitionRegistrar.class})
@Configuration
public class MainConfig {
}

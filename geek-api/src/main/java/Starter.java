/*
 * Copyright (C),2016-2017. 上海朔羡网络科技有限公司
 * FileName: Starter.java
 * Author:  tongzilong@mgzf.com
 * Date:     2017-11-17 11 : 11:04
 * Description: //模块目的、功能描述
 * History: //修改记录 修改人姓名 修改时间 版本号 描述
 * <tongzilong>  <2017-11-17 11 : 11:04> <version>   <desc>
 */

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * <一句话功能简述>
 * <功能详细描述>
 *
 * @auth:tongzilong@mgzf.com
 * @see: [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
public class Starter {

        public static void main(String[] args) {
            //@Configuration注解的spring容器加载方式，用AnnotationConfigApplicationContext替换ClassPathXmlApplicationContext
            ApplicationContext context = new AnnotationConfigApplicationContext(Starter.class);

            //如果加载spring-context.xml文件：
            //ApplicationContext context = new ClassPathXmlApplicationContext("spring-context.xml");
        }
    }

/*
 * Copyright (C),2016-2017. 上海朔羡网络科技有限公司
 * FileName: TestConfiguration.java
 * Author:  tongzilong@mgzf.com
 * Date:     2017-11-17 11 : 12:13
 * Description: //模块目的、功能描述
 * History: //修改记录 修改人姓名 修改时间 版本号 描述
 * <tongzilong>  <2017-11-17 11 : 12:13> <version>   <desc>
 */

import org.springframework.context.annotation.Configuration;

/**
 * <一句话功能简述>
 * <功能详细描述>
 *
 * @auth:tongzilong@mgzf.com
 * @see: [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
@Configuration
public class TestConfiguration {
    public TestConfiguration(){
        System.out.println("spring容器启动初始化。。。");
    }
}
/*
 * Copyright (C),2016-2018. 上海朔羡网络科技有限公司
 * FileName: TestCglib.java
 * Author:  tongzilong@mgzf.com
 * Date:     2018-05-21 02 : 37:01
 * Description: //模块目的、功能描述
 * History: //修改记录 修改人姓名 修改时间 版本号 描述
 * <tongzilong>  <2018-05-21 02 : 37:01> <version>   <desc>
 */

package designpatterns.Proxy.DynamicProxy.cglib;

import designpatterns.Proxy.DynamicProxy.Animal;
import designpatterns.Proxy.DynamicProxy.Dog;

/**
 * <一句话功能简述>
 * <功能详细描述>
 *
 * @auth:tongzilong@mgzf.com
 * @see: [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
public class TestCglib {
    public static void main(String[] args) {
        AnimalCglibDynamicProxy proxy = new AnimalCglibDynamicProxy();
        Animal dog = (Animal) proxy.createProxy(new Dog().getClass());
        dog.eat("111");
        System.out.println("-------------------------");
        dog._sleep();
    }
}

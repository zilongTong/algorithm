/*
 * Copyright (C),2016-2018. 上海朔羡网络科技有限公司
 * FileName: TestJdk.java
 * Author:  tongzilong@mgzf.com
 * Date:     2018-05-21 03 : 37:56
 * Description: //模块目的、功能描述
 * History: //修改记录 修改人姓名 修改时间 版本号 描述
 * <tongzilong>  <2018-05-21 03 : 37:56> <version>   <desc>
 */

package designpatterns.Proxy.DynamicProxy.jdk;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
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
public class TestJdk {
    public static void main(String[] args) {
        try {
            Class animal = Class.forName("designpatterns.Proxy.DynamicProxy.Dog");
            Class[] clazz = animal.getInterfaces();
            System.out.println(clazz[0]);
            Dog dog = (Dog) animal.newInstance();
            Dog dog1 = (Dog) animal.newInstance();
            System.out.println(dog);
            System.out.println(dog1);
            Method method = animal.getMethod("eat", new Class[]{Class.forName("java.lang.String")});
            method.invoke(dog, new String[]{"oooooo"});
            method.invoke(dog, new String[]{"iiiiiiiiiii"});
            method.invoke(dog1, new String[]{"pppppppppppppp"});
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
        } catch (NoSuchMethodException e) {
        } catch (
            ClassNotFoundException e)

        {
            e.printStackTrace();
        }

        AnimalJdkDynamicProxy proxy = new AnimalJdkDynamicProxy();
        Animal dog = (Animal) proxy.createProxy(new Dog());
        dog._sleep();
        System.out.println("-----------");
        dog.eat("111");
    }
}

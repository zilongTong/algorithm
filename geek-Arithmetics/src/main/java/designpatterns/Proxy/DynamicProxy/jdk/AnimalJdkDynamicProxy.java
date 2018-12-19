/*
 * Copyright (C),2016-2018. 上海朔羡网络科技有限公司
 * FileName: AnimalJdkDynamicProxy.java
 * Author:  tongzilong@mgzf.com
 * Date:     2018-05-21 03 : 31:41
 * Description: //模块目的、功能描述
 * History: //修改记录 修改人姓名 修改时间 版本号 描述
 * <tongzilong>  <2018-05-21 03 : 31:41> <version>   <desc>
 */

package designpatterns.Proxy.DynamicProxy.jdk;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import org.apache.commons.lang3.ObjectUtils;

/**
 * <一句话功能简述>
 * <功能详细描述>
 *
 * @auth:tongzilong@mgzf.com
 * @see: [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
public class AnimalJdkDynamicProxy implements InvocationHandler {

    private Object target;


    public Object createProxy(Object target) {
        this.target = target;
        return Proxy.newProxyInstance(target.getClass().getClassLoader(), target.getClass().getInterfaces(), this);
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        //系统级业务  开始事务
        System.out.println("主人在召唤");
        //主业务
        Object result = method.invoke(target, args);
        //系统级业务  关闭事务
        System.out.println("主人离开");
        return result;
    }
}

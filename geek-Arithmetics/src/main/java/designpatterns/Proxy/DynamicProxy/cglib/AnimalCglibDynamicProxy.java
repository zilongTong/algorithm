/*
 * Copyright (C),2016-2018. 上海朔羡网络科技有限公司
 * FileName: AnimalCglibDynamicProxy.java
 * Author:  tongzilong@mgzf.com
 * Date:     2018-05-21 02 : 29:12
 * Description: //模块目的、功能描述
 * History: //修改记录 修改人姓名 修改时间 版本号 描述
 * <tongzilong>  <2018-05-21 02 : 29:12> <version>   <desc>
 */

package designpatterns.Proxy.DynamicProxy.cglib;


import java.lang.reflect.Method;
import org.apache.commons.lang3.ObjectUtils;
import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

/**
 * <一句话功能简述>
 * <功能详细描述>
 *
 * @auth:tongzilong@mgzf.com
 * @see: [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
public class AnimalCglibDynamicProxy implements MethodInterceptor {

    /**
     * 在enhancer中有一个setCallBack(this)
     * 这样就实现了代理类和委托类的关联
     */
    private Enhancer enhancer = new Enhancer();

    public Object createProxy(Class clazz) {
        //设置公共接口的公共类
        enhancer.setSuperclass(clazz);
        //建立关系类
        enhancer.setCallback(this);
        return enhancer.create();
    }

    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        //系统级业务  开始事务
        System.out.println("主人在召唤");
        //主业务
        Object result = methodProxy.invokeSuper(o, objects);
        //系统级业务  关闭事务
        System.out.println("主人离开");
        return result;
    }
}

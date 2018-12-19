package designpatterns.templateMethod;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.FactoryBean;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by zilong on 2017/8/29.
 */
public class ConcreteTemplate extends AbstractTemplate implements FactoryBean<Object> {
    @Override
    protected void abstractMethod() {

    }

    //重写父类的方法,选择实现
    @Override
    public void hookMethod() {
        //业务相关的代码
        BeanFactory factory = new ClassPathXmlApplicationContext();
    }

    @Override
    public Object getObject() throws Exception {
        return null;
    }

    @Override
    public Class<?> getObjectType() {
        return null;
    }

    @Override
    public boolean isSingleton() {
        return false;
    }
}

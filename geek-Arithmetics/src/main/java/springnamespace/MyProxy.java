package springnamespace;

import io.netty.channel.EventLoop;
import net.sf.cglib.proxy.InvocationHandler;
import net.sf.cglib.proxy.Proxy;
import org.springframework.util.CollectionUtils;

import java.lang.reflect.Method;
import java.util.Collections;


/**
 * @ClassName MyProxy
 * @Author Leo
 * @Description //TODO
 * @Date: 2019/1/5 15:38
 **/
public class MyProxy implements InvocationHandler {

    private Class<?> interfaceClass;

    public Object bind(Class<?> cls) {
        this.interfaceClass = cls;
        return Proxy.newProxyInstance(cls.getClassLoader(), new Class[]{interfaceClass}, this);
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        return null;
    }

}


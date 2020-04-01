package org.tzl.proxy.custom;

import java.lang.reflect.Method;


public interface LInvocationHandler {
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable;
}

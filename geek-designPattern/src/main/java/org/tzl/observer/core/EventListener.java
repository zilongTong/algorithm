package org.tzl.observer.core;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

public class EventListener {


    /**
     * 监听Method方法池
     * <p>
     * 核心实现
     * event.getCallback().invoke(event.getTarget(), event);
     * <p>
     * target是继承EventListener的类，event是target的Method方法的参数
     */
    private Map<Enum, Event> eventMap = new HashMap<>();

    public void addListener(Enum type, Object target, Method callBack) {
        eventMap.put(type, new Event(target, callBack));
    }


    private void trigger(Event event) {
        event.setSource(this);
        event.setTime(System.currentTimeMillis());

        try {
            event.getCallback().invoke(event.getTarget(), event);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
    }


    protected void trigger(Enum e) {
        if (eventMap.containsKey(e)) {
            trigger(eventMap.get(e).setTrigger(e.toString()));
        }
    }
}

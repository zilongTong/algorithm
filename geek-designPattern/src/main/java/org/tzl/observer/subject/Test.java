package org.tzl.observer.subject;

import org.tzl.observer.core.Event;

import java.lang.reflect.Method;

public class Test {

    public static void main(String[] args) {
        Observer observer = new Observer();
        try {
            Method advice = Observer.class.getMethod("advice", new Class<?>[]{Event.class});
            Subject subject = new Subject();
//            subject.addListener(SubjectEventType.ON_ADD, observer, advice);
            subject.addListener(SubjectEventType.ON_REMOVE, observer, advice);
            subject.pay();
            subject.payBack();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }


    }
}

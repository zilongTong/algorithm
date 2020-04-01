package org.tzl.observer.subject;

import org.tzl.observer.core.EventListener;

public class Subject extends EventListener {

    public void pay() {
        System.out.println("业务支付方法");
        this.trigger(SubjectEventType.ON_ADD);
    }

    public void payBack() {
        System.out.println("业务退费方法");
        this.trigger(SubjectEventType.ON_REMOVE);
    }

}

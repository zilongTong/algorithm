package org.tzl.observer.subject;

import org.tzl.observer.core.Event;

public class Observer {

    public void advice(Event event) {

        System.out.println("=========触发事件，打印日志========\n" + event);

        /*
         *  input
         *  input.addLisenter("click",function(){
         *
         *
         *  });
         *
         *
         * */
    }
}

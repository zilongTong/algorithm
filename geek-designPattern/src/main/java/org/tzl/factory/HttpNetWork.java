package org.tzl.factory;

public class HttpNetWork implements NetWork {

    @Override
    public void send() {
        System.out.println("http 通信");
    }
}

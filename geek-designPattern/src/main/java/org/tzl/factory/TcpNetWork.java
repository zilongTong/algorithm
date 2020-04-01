package org.tzl.factory;

public class TcpNetWork implements NetWork {
    @Override
    public void send() {
        System.out.println("tcp 通信");
    }
}

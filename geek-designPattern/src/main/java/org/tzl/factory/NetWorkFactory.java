package org.tzl.factory;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class NetWorkFactory {

    private static Map<NetType, NetWork> netMap = new ConcurrentHashMap<NetType, NetWork>();

    static {
        System.out.println("init.......");
        netMap.put(NetType.HTTP, new HttpNetWork());
        netMap.put(NetType.TCP, new TcpNetWork());
    }

    public static NetWork factory(NetType type) {
        return netMap.get(type);
    }

}

package org.tzl.factory;

public class Test {

    /**
     * 对于调用者来说，隐藏了复杂的逻辑处理过程，调用 者只关心执行结果。
     * 对于工厂来说要对结果负责，保证生产出符合规范的 产品。
     *
     * @param args
     */
    public static void main(String[] args) {
        NetWork netWork = NetWorkFactory.factory(NetType.HTTP);
        System.out.println(netWork);
        netWork.send();
        NetWork netWork2 = NetWorkFactory.factory(NetType.TCP);
        System.out.println(netWork2);
        netWork2.send();
        NetWork netWork3 = NetWorkFactory.factory(NetType.TCP);
        System.out.println(netWork3);
        netWork3.send();
    }
}

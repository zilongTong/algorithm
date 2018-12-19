package designpatterns.factory.e1;

public class Test {

    /**
     * @param args
     * 
     *            　如果系统需要加入一个新的导出类型，那么所需要的就是向系统中加入一个这个导出类以及所对应的工厂类。没有必要修改客户端，也没有必要修改抽象工厂角色或者其他已有的具体工厂角色。对于增加新的导出类型而言，
     *            这个系统完全支持“开-闭原则”。
     */
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        String data = "";
        ExportFactory exportFactory = new ExportHtmlFactory();
        ExportFile ef = exportFactory.factory("s");
        ef.export(data);
    }

}
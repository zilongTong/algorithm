package designpatterns.factory.e1;

public class ExportStandardHtmlFile implements ExportFile {

    public boolean export(String data) {
        // TODO Auto-generated method stub
        /**
         * 业务逻辑
         */
        System.out.println("导出标准HTML文件");
        return true;
    }

}
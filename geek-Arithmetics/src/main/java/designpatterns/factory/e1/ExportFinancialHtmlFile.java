package designpatterns.factory.e1;

public class ExportFinancialHtmlFile implements ExportFile {
    @Override
    public boolean export(String data) {
        // TODO Auto-generated method stub
        /**
         * 业务逻辑
         */
        System.out.println("导出财务版html文件");
        return true;
    }
}

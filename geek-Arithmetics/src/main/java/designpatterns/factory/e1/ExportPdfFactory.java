package designpatterns.factory.e1;

public class ExportPdfFactory implements ExportFactory {
    public ExportFile factory(String type) {
        // TODO Auto-generated method stub
        if ("s".equals(type)) {

            return new ExportStandardPdfFile();

        } else if ("f".equals(type)) {

            return new ExportFinancialPdfFile();

        } else {
            throw new RuntimeException("没有找到对象");
        }
    }
}

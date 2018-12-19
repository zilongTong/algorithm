package designpatterns.factory.e1;

public class ExportHtmlFactory implements ExportFactory {
    public ExportFile factory(String type) {
        if ("s".equals(type)) {
            return new ExportStandardHtmlFile();

        } else if ("f".equals(type)) {
            return new ExportFinancialHtmlFile();

        } else {
            throw new RuntimeException("没有找到对象");
        }
    }
}

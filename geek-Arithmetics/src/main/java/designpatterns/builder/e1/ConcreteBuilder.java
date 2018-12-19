package designpatterns.builder.e1;

public class ConcreteBuilder implements Builder {

    private Product product = new Product();

    @Override
    public void builderPart1() {
        // 构建产品的第一个零件
        product.setPart1("编号：9527");
    }

    @Override
    public void builderPart2() {
        // 构建产品的第二个零件
        product.setPart2("名称：XXX");

    }

    @Override
    public Product retrieveResult() {
        return product;
    }

}

package designpatterns.strategy.simple;

/**
 * @ClassName Test
 * @Author Leo
 * @Description //TODO
 * @Date: 2019/1/14 10:37
 **/
public class Test {
    /**
     * 在策略上下文里面执行接口实现的方法
     * 定制方法实现的逻辑
     * @param args
     */
    public static void main(String[] args) {
        StrategyContext context = new StrategyContext(new IStrategy() {
            @Override
            public void algorithmMethod() {
                System.out.println("212121");
            }
        });
        context.contextMethod();
    }

}

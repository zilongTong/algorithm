package designpatterns.strategy.simple;

/**
 * @ClassName StrategyContext
 * @Author Leo
 * @Description //TODO
 * @Date: 2019/1/14 10:34
 **/
public class StrategyContext {
    private IStrategy strategy;

    public StrategyContext(IStrategy strategy) {
        this.strategy = strategy;
    }

    /**
     * 获取对应的策略方法
     */
    public void contextMethod() {
        strategy.algorithmMethod();
    }
}

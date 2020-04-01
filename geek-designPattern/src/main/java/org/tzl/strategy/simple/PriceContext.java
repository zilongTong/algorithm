package org.tzl.strategy.simple;

public class PriceContext<T> {

    private T var;

    public PriceContext(T var) {
        this.var = var;
    }

    /**
     * 计算图书的价格
     */
    public double quote(MemberStrategy strategy) {
        System.out.println(strategy.calcPrice(var));
        return strategy.calcPrice(var);
    }

}

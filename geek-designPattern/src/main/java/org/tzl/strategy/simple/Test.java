package org.tzl.strategy.simple;

public class Test {


    /**
     * 　　这个模式涉及到三个角色：
     * <p>
     * 　　●　　环境(Context)角色：持有一个Strategy的引用。
     * <p>
     * 　　●　　抽象策略(Strategy)角色：这是一个抽象角色，通常由一个接口或抽象类实现。此角色给出所有的具体策略类所需的接口。
     * <p>
     * 　　●　　具体策略(ConcreteStrategy)角色：包装了相关的算法或行为。
     * <p>
     * <p>
     * 在制定泛型类型时使用
     * 　<? extends T>:  是指 “上界通配符（Upper Bounds Wildcards）
     * 继承关系是正三角
     *
     * <p>
     * <? super T>：是指 “下界通配符（Lower Bounds Wildcards）
     * 继承关系是倒三角
     *
     * @param args
     */
    public static void main(String[] args) {
        PriceContext<? extends Double> context = new PriceContext<>(1.1);

        context.quote(new MemberStrategy<Double>() {
            @Override
            public double calcPrice(Double booksPrice) {
                return 1.1 * 10;
            }
        });
    }
}

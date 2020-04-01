package org.tzl.strategy.pay.payport;


import org.tzl.strategy.pay.PayState;

/**
 * 支付渠道
 */
public interface Payment {

    public PayState pay(String uid, double amount);

}

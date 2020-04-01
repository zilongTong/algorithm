package org.tzl.decorator;

public interface ISignForThirdService extends ISignService {

    ResultMsg loginForQQ(String openId);

    ResultMsg loginForWeChat(String openId);

    ResultMsg loginForToken(String token);

    ResultMsg loginForTelPhone(String tel, String code);

    ResultMsg loginForRegistry(String username, String password);

}

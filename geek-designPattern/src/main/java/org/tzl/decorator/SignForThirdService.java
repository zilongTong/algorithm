package org.tzl.decorator;

public class SignForThirdService implements ISignForThirdService {

    private ISignService signService;

    public SignForThirdService(ISignService signService) {
        this.signService = signService;
    }

    @Override
    public ResultMsg loginForQQ(String openId) {
        return loginForRegistry(openId,null);
    }

    @Override
    public ResultMsg loginForWeChat(String openId) {
        return null;
    }

    @Override
    public ResultMsg loginForToken(String token) {
        return null;
    }

    @Override
    public ResultMsg loginForTelPhone(String tel, String code) {
        return null;
    }

    @Override
    public ResultMsg loginForRegistry(String username, String password) {
        this.registry(username, password);
        return this.login(username, password);
    }

    @Override
    public ResultMsg registry(String username, String password) {
        return signService.registry(username, password);
    }

    @Override
    public ResultMsg login(String username, String password) {
        return signService.login(username, password);
    }
}

package org.tzl.decorator;

public interface ISignService {

    public ResultMsg registry(String username, String password);


    /**
     * 登录的方法
     *
     * @param username
     * @param password
     * @return
     */
    public ResultMsg login(String username, String password);

}

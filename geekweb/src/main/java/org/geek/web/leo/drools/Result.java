package org.geek.web.leo.drools;

import lombok.Data;

/**
 * @ClassName Result
 * @Author Leo
 * @Description //TODO
 * @Date: 2019/3/20 19:39
 **/
@Data
public class Result<T> {
    private static final int CODE_SUCCESS = 200;

    private static final int CODE_FAIL = 500;
    private int code;

    private String errorMsg;

    private T data;

    public Result(int code, String msg, T data) {
        this.setCode(code);
        this.setErrorMsg(msg);
        this.setData(data);
    }

    public static boolean isSuccess() {
        return true;
    }

    public static <T> Result<T> buildFail(T data, String msg, String trace) {
        return new Result(CODE_FAIL, msg, msg);
    }

    public static <T> Result<T> buildFail(T data, String msg) {
        return new Result(CODE_FAIL, msg, null);
    }

    public static <T> Result<T> buildSucc(T data) {
        return new Result(CODE_SUCCESS, null, data);
    }


}

package org.geek.web.leo.drools;

/**
 * @ClassName ResponseDTO
 * @Author Leo
 * @Description //TODO
 * @Date: 2019/3/14 15:38
 **/
public class ResponseDTO<T> {

    private static final int CODE_SUCCESS = 200;

    private static final int CODE_FAIL = 500;


    private int code;

    private String msg;

    private T data;

    public ResponseDTO(int code, String msg, T data) {
        this.setCode(code);
        this.setMsg(msg);
        this.setData(data);
    }

    public static <T> ResponseDTO<T> success() {
        return new ResponseDTO<T>(CODE_SUCCESS, "success", null);
    }

    public static <T> ResponseDTO<T> success(String message) {
        return new ResponseDTO<T>(CODE_SUCCESS, message, null);
    }

    public static <T> ResponseDTO<T> success(T data) {
        return new ResponseDTO<T>(CODE_SUCCESS, "success", data);
    }

    public static <T> ResponseDTO<T> success(String message, T data) {
        return new ResponseDTO<T>(CODE_SUCCESS, message, data);
    }

    public static <T> ResponseDTO<T> error() {
        return new ResponseDTO<T>(CODE_FAIL, "fail", null);
    }

    public static <T> ResponseDTO<T> error(String message) {
        return new ResponseDTO<T>(CODE_FAIL, message, null);
    }

    public static <T> ResponseDTO<T> error(T data) {
        return new ResponseDTO<T>(CODE_FAIL, "fail", data);
    }

    public static <T> ResponseDTO<T> error(String message, T data) {
        return new ResponseDTO<T>(CODE_FAIL, message, data);
    }

    public static <T> ResponseDTO<T> badrequest(String message) {
        return new ResponseDTO<T>(CODE_FAIL, message, null);
    }


    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

}

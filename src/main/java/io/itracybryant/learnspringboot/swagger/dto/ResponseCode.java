package io.itracybryant.learnspringboot.swagger.dto;

/**
 * 将返回状态码封装成dto对象
 *
 * @ClassName ResponseCode
 * @Description TODO
 * @Author Administrator
 * @Date 2019/3/28 14:18
 * @Version 1.0
 */
public class ResponseCode {
    private Long code;
    private String message;
    private Object data;

    public ResponseCode() {
    }

    public ResponseCode(Long code, String message, Object data) {
        this.code = code;
        this.message = message;
        this.data = data;
    }

    public static ResponseCode ok(String message) {
        return new ResponseCode(200L, message, null);
    }

    public static ResponseCode ok(String message, Object data) {
        return new ResponseCode(200L, message, data);
    }

    public Long getCode() {
        return code;
    }

    public void setCode(Long code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "ResponseCode{" +
                "code=" + code +
                ", message='" + message + '\'' +
                ", data=" + data +
                '}';
    }
}

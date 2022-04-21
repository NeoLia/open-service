package org.mjh.openservice.common.vo;

/**
 * @author: Neo Lia Marx
 * @date: 2022/04/20
 */
public class ResultVO<T> {
    private String code;
    private String message;
    private Boolean success;
    private T data;

    public ResultVO(String code, String message, Boolean success, T data) {
        this.code = code;
        this.message = message;
        this.success = success;
        this.data = data;
    }

    @Override
    public String toString() {
        return "ResultVO{" +
                "code='" + code + '\'' +
                ", message='" + message + '\'' +
                ", success=" + success +
                ", data=" + data.toString() +
                '}';
    }

    public static <T> ResultVO<T> ok(String message, T data) {
        return new ResultVO<>("0", message, true, data);
    }

    public static <T> ResultVO<T> ok(String message) {
        return new ResultVO<>("0", message, true, null);
    }

    public static ResultVO error(String code, String message) {
        return new ResultVO<>(code, message, false, null);
    }

    public String getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }

    public Boolean getSuccess() {
        return success;
    }

    public T getData() {
        return data;
    }
}

package com.angrywolves.tolink.framework.common.response;

/**
 * Created by xulu
 */
public class UcResponseData<T> {

    private T data;
    private String message;
    private Integer result;

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Integer getResult() {
        return result;
    }

    public void setResult(Integer result) {
        this.result = result;
    }

}

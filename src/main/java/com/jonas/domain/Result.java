package com.jonas.domain;

/**
 * HTTP请求返回的最外层对象
 * Author Jonas
 * 2018/8/31 11:26
 */
public class Result<T> {

    //错误码
    private Integer code;

    //错误信息
    private String msg;

    //具体内容
    private T data;

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
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

    @Override
    public String toString() {
        return "Result{" +
                "code=" + code +
                ", msg='" + msg + '\'' +
                ", data=" + data +
                '}';
    }
}

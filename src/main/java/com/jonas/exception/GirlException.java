package com.jonas.exception;

import com.jonas.enums.ResultEnum;

/**
 * Author Jonas
 * 2018/9/3 11:18
 */
public class GirlException extends Exception {

    private Integer code;

    public GirlException(ResultEnum resultEnum) {
        super(resultEnum.getMsg());
        this.code = resultEnum.getCode();
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }
}

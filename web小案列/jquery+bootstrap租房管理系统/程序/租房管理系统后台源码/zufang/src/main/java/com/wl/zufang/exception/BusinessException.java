package com.wl.zufang.exception;

import com.wl.zufang.enums.ErrorCodeEnum;
import lombok.Getter;

/**
 * @author w.z
 * @date 2019/11/24 21:53
 */
@Getter
public class BusinessException extends RuntimeException {
    /**
     * 错误码
     */
    private String code;

    public BusinessException(ErrorCodeEnum errorEnum) {
        super(errorEnum.getMsg());
        this.code = errorEnum.getCode();
    }

    public BusinessException(String code, String message) {
        super(message);
        this.code = code;
    }
}

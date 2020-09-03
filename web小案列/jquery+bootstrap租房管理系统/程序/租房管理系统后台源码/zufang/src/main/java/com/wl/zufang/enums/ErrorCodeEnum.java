package com.wl.zufang.enums;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;

/**
 * 错误枚举
 * @author w.z
 * @date 2019/11/24 21:55
 */
@Getter
@AllArgsConstructor
public enum ErrorCodeEnum {

    PARAM_NULL("0010","参数为空"),
    USERNAME_EXISTS("0011","用户名已经存在"),
    TELEPHONE_EXISTS("0012","电话号码已注册"),
    PASSWORD_ERROR("0013","密码错误"),
    SUCCESS("0014","请求成功"),
    REGISTER_ERROR("0015","注册失败"),
    UPDATE_ERROR("0016","修改信息失败"),
    LOGIN_ERROR("0017","用户名或电话错误"),
    CANCEL_ERROR("0018","取消订单失败"),
    INSERT_ERROR("0019","增加租房订单失败");
    /**
     * 提示码
     */
    private String code;

    /**
     * 提示信息
     */
    private String msg;
}

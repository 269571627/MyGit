package com.wl.zufang.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Pattern;

/**
 * 修改用户信息
 * @author w.z
 * @date 2019/11/25 11:13
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UpdateVo {

    /**
     * 用户id
     */
    private Long id;
    
    /**
     * 用户名
     */
    private String username;

    /**
     * 手机号
     */
    @Pattern(regexp = "^1(3|4|5|7|8)\\d{9}$", message = "手机号码格式错误")
    private String telephone;

    /**
     * 邮件
     */
    @Pattern(regexp = "[1-9]\\d{7,10}@qq\\.com",message = "邮箱格式错误")
    private String email;

    /**
     * 性别
     */
    private String sex;

    /**
     * 头像
     */
    private String image;
    
}

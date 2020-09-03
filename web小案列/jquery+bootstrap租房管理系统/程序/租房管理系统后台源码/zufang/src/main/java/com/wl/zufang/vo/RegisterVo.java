package com.wl.zufang.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

/**
 * 注册
 * @author w.z
 * @date 2019/11/25 9:43
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class RegisterVo {
    
    @NotNull(message = "用户名不能为空")
    private  String username;
    
    @NotNull(message = "电话号码不能为空")
    @Pattern(regexp = "^1(3|4|5|7|8)\\d{9}$", message = "手机号码格式错误")
    private String telephone;

    @Pattern(regexp = "[1-9]\\d{7,10}@qq\\.com",message = "邮箱格式错误")
    private String email;
    
    @NotNull(message = "密码不能为空")
    private String password;
    
    private String sex;
    
    private String image;
    
}

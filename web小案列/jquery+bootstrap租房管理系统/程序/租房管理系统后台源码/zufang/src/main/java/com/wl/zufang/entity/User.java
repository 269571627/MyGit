package com.wl.zufang.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.wl.zufang.util.EncryptionUtil;
import com.wl.zufang.vo.RegisterVo;
import com.wl.zufang.vo.UpdateVo;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author w.z
 * @date 2019/11/24 20:27
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {

    /**
     * 用户id
     */
    private Long id;

    /**
     * 用户名
     */
    private String username;

    /**
     * 电话
     */
    private String telephone;

    /**
     * 邮箱
     */
    private String email;

    /**
     * 密码
     */
    @JsonIgnore
    private String password;

    /**
     * 性别
     */
    private String sex;

    /**
     * 头像
     */
    private String image;

    /**
     * 盐值
     */
    @JsonIgnore
    private String salt;
    
    
    public User(RegisterVo registerVo,String salt){
        this.username = registerVo.getUsername();
        this.telephone = registerVo.getTelephone();
        this.email = registerVo.getEmail();
        this.image = registerVo.getImage();
        this.sex = registerVo.getSex();
        this.salt = salt;
        this.password = EncryptionUtil.md5Hash(registerVo.getPassword(),salt);
    }
    
    public void  updateUser(UpdateVo updateVo){
        this.id = updateVo.getId();
        this.username = updateVo.getUsername();
        this.email = updateVo.getEmail();
        this.sex = updateVo.getSex();
        this.image = updateVo.getImage();
        this.telephone = updateVo.getTelephone();
    }
}

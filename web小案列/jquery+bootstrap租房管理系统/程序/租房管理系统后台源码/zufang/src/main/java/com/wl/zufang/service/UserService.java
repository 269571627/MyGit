package com.wl.zufang.service;
import com.wl.zufang.entity.User;

/**
 * 用户
 * @author w.z
 * @date 2019/11/24 21:43
 */
public interface UserService {

    /**
     * 用户注册
     * @param user
     * @return
     */
    boolean register(User user);

    /**
     * 用户登录
     * @param checkName
     * @return
     */
    User login(String checkName,String password);


    /**
     * 修改用户信息
     * @param user
     * @return
     */
    boolean updateUser(User user);
    
}

package com.wl.zufang.dao;
import org.apache.ibatis.annotations.Param;
import com.wl.zufang.entity.User;


/**
 * 用户
 * @author w.z
 * @date 2019/11/24 20:40
 */
public interface UserDao {

    /**
     * 用户登录
     * @param checkName
     * @param password
     * @return
     *//*
    User login(@Param("checkName") String checkName,@Param("password") String password);
*/
    /**
     * 用户注册
     * @param user
     * @return
     */
    int insert(User user);

    /**
     * 根据电话查询用户
     * @param telephone
     * @return
     */
    User getByTelephone(String telephone);

    /**
     * 根据用户名查询用户
     * @param username
     * @return
     */
    User getByUsername(String username);


    /**
     * 修改用户信息
     * @param user
     * @return
     */
    int update(User user);

    /**
     * 根据id查询用户
     * @param id
     * @return
     */
    User getById(Long id);
}

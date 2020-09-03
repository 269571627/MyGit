package com.wl.zufang.service.Impl;

import com.wl.zufang.dao.UserDao;
import com.wl.zufang.entity.User;
import com.wl.zufang.enums.ErrorCodeEnum;
import com.wl.zufang.exception.BusinessException;
import com.wl.zufang.service.UserService;
import com.wl.zufang.util.EncryptionUtil;
import com.wl.zufang.util.TelephoneUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

/**
 * @author w.z
 * @date 2019/11/24 21:45
 */
@Slf4j
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    /**
     * 用户注册
     *
     * @param user
     * @return
     */
    @Override
    public boolean register(User user) {
        if (user == null) {
            log.error("UserServiceImpl#register: param is null.");
            throw new BusinessException(ErrorCodeEnum.PARAM_NULL);
        }
        User user1 = userDao.getByUsername(user.getUsername());
        if (user1 != null){
            log.error("UserServiceImpl#register: username has exists.");
            throw new BusinessException(ErrorCodeEnum.USERNAME_EXISTS);
        }
        User user2 = userDao.getByTelephone(user.getTelephone());
        if (user2 != null){
            log.error("UserServiceImpl#register: telephone has been registered");
            throw new BusinessException(ErrorCodeEnum.TELEPHONE_EXISTS);
        }
        int result = userDao.insert(user);
        if (result > 0) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * 用户登录
     *
     * @param checkName
     * @return
     */
    @Override
    public User login(String checkName,String password) {
        if (StringUtils.isEmpty(checkName)){
            log.error("UserServiceImpl#login: param is null");
            throw new BusinessException(ErrorCodeEnum.PARAM_NULL);
        }
        User user = new User();
        if (TelephoneUtil.isPhoneLegal(checkName)){
           user = userDao.getByTelephone(checkName);
        } else {
            user = userDao.getByUsername(checkName);
        }
        if (user == null){
            log.error("UserServiceImpl#login: login error.checkname={},password={}",checkName,password);
            throw new BusinessException(ErrorCodeEnum.LOGIN_ERROR);
        }
        String md5Password = EncryptionUtil.md5Hash(password,user.getSalt());
        if (md5Password.equals(user.getPassword())){
            return user;
        } else {
            log.error("UserServiceImpl#login: password error.");
            throw new BusinessException(ErrorCodeEnum.PASSWORD_ERROR);
        }
    }

    /**
     * 修改用户信息
     * @param user
     * @return
     */
    @Override
    public boolean updateUser(User user) {
        if (user == null){
            log.error("UserServiceImpl#updateUser: param is null");
            throw new BusinessException(ErrorCodeEnum.PARAM_NULL);
        }
        int result = userDao.update(user);
        if (result > 0){
            return true;
        } else {
            log.error("UserServiceImpl#updateUser: update error.");
            throw new BusinessException(ErrorCodeEnum.UPDATE_ERROR);
        }
    }
}

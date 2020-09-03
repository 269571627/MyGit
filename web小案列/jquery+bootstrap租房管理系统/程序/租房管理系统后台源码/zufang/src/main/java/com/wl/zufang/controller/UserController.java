package com.wl.zufang.controller;

import com.wl.zufang.entity.User;
import com.wl.zufang.enums.ErrorCodeEnum;
import com.wl.zufang.exception.BusinessException;
import com.wl.zufang.service.UserService;
import com.wl.zufang.util.EncryptionUtil;
import com.wl.zufang.util.ResultUtil;
import com.wl.zufang.vo.RegisterVo;
import com.wl.zufang.vo.ResultVo;
import com.wl.zufang.vo.UpdateVo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

/**
 * @author w.z
 * @date 2019/11/25 9:40
 */
@RestController
@RequestMapping("/user")
@Slf4j
@CrossOrigin(allowCredentials = "true", maxAge = 3600)
public class UserController {
    
    @Autowired
    private UserService userService;

    /**
     * 用户注册
     * @param registerVo
     * @param bindingResult
     * @return
     */
    @PostMapping("/register")
    public ResultVo register(@Valid  @RequestBody RegisterVo registerVo, BindingResult bindingResult){
        if (bindingResult.hasErrors()) {
            log.error("UserController#register: param is error. registerVo={}. ", registerVo);
            throw new BusinessException(
                    ErrorCodeEnum.PARAM_NULL.getCode(), bindingResult.getFieldError().getDefaultMessage());
        }
        // 获取加密盐值
        String salt = EncryptionUtil.getMd5HashSalt(16);
        // 在构造函数中加密
        User user = new User(registerVo,salt);
        boolean result = userService.register(user);
        if (result){
            return ResultUtil.success();
        } else {
            log.error("UserController#register: register error.");
            throw new BusinessException(ErrorCodeEnum.REGISTER_ERROR);
        }
    }


    /**
     * 用户登录
     * @param checkname
     * @param password
     * @return
     */
    @PostMapping("/login")
    public ResultVo<User> login(@RequestParam(value="checkname",required = false) String checkname, @RequestParam(value = "password",required = false) String password, HttpServletRequest request){
        if (StringUtils.isEmpty(checkname) || StringUtils.isEmpty(password)){
            log.error("UserController#login: param is null");
            throw new BusinessException(ErrorCodeEnum.PARAM_NULL);
        }
        User user = userService.login(checkname,password);
        HttpSession session = request.getSession();
        session.setAttribute("user",user);
        
        return ResultUtil.success(user);
    }

    /**
     * 修改用户信息
     * @param updateVo
     * @param bindingResult
     * @return
     */
    @PutMapping("/update")
    public ResultVo<User> update(@Valid @RequestBody UpdateVo updateVo,BindingResult bindingResult,HttpSession session){
        if (bindingResult.hasErrors()) {
            log.error("UserController#update: param is error. registerVo={}. ", updateVo);
            throw new BusinessException(
                    ErrorCodeEnum.PARAM_NULL.getCode(), bindingResult.getFieldError().getDefaultMessage());
        }
        
        //创建修改用户信息
        User user = new User();
        user.updateUser(updateVo);
        
        boolean result = userService.updateUser(user);
        if (result){
            return ResultUtil.success();
        } else {
            log.error("UserController#update: update error.");
            throw new BusinessException(ErrorCodeEnum.UPDATE_ERROR);
        }
    }
}

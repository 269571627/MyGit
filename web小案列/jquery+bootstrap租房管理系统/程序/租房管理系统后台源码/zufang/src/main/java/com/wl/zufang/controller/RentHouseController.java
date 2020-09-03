package com.wl.zufang.controller;

import com.wl.zufang.dto.PageDto;
import com.wl.zufang.entity.RentHouse;
import com.wl.zufang.entity.User;
import com.wl.zufang.enums.ErrorCodeEnum;
import com.wl.zufang.exception.BusinessException;
import com.wl.zufang.service.RentHouseService;
import com.wl.zufang.util.ResultUtil;
import com.wl.zufang.vo.RentHouseVo;
import com.wl.zufang.vo.ResultVo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
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
 * @date 2019/11/25 22:08
 */
@RequestMapping("/renthouse")
@RestController
@Slf4j
@CrossOrigin(allowCredentials = "true", maxAge = 3600)
public class RentHouseController {
    
    @Autowired
    private RentHouseService rentHouseService;
    
    /**
     *  新增租房订单
     * @param rentHouseVo
     * @param bindingResult
     * @return
     */
    @PostMapping("/add")
    public ResultVo addRent(@Valid @RequestBody  RentHouseVo rentHouseVo, BindingResult bindingResult, HttpServletRequest request){

        if (bindingResult.hasErrors()) {
            log.error("UserController#register: param is error. registerVo={}. ", rentHouseVo);
            throw new BusinessException(
                    ErrorCodeEnum.PARAM_NULL.getCode(), bindingResult.getFieldError().getDefaultMessage());
        }
        // 构造租房订单
        RentHouse rentHouse = new RentHouse(rentHouseVo);
        // 租房数据处理
        boolean result = rentHouseService.insert(rentHouse);
        if (result){
            return ResultUtil.success();
        } else {
            return ResultUtil.error(ErrorCodeEnum.INSERT_ERROR);
        }
    }


    /**
     * 根据id取消订单
     * @param id
     * @return
     */
    @PutMapping("/delete")
    public ResultVo cancel(@RequestParam("id") Long id){
        if (id == null){
            log.error("UserController#cancel: param is null.");
            throw new BusinessException(ErrorCodeEnum.PARAM_NULL);
        }
        boolean result = rentHouseService.cancel(id);
        if (result){
            return ResultUtil.success();
        } else {
            return ResultUtil.error(ErrorCodeEnum.CANCEL_ERROR);
        }
    }

    /**
     * 根据用户id查看用户的所有订单
     * @param userId
     * @return
     */
    @GetMapping("/list")
   public ResultVo<PageDto> listAll(@RequestParam("userId") long userId){
        // 获取用户订单
       PageDto<RentHouse> pageDto = rentHouseService.listByUserID(userId);
       return ResultUtil.success(pageDto);
   }
}

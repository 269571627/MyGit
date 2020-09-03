package com.wl.zufang.controller;

import com.wl.zufang.dto.PageDto;
import com.wl.zufang.entity.House;
import com.wl.zufang.service.HouseService;
import com.wl.zufang.util.ResultUtil;
import com.wl.zufang.vo.ResultVo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author w.z
 * @date 2019/11/30 9:40
 */
@RestController
@RequestMapping("/house")
@CrossOrigin(allowCredentials = "true",maxAge = 3600)
@Slf4j
public class HouseController {
    
    @Autowired
    private HouseService houseService;

    /**
     * 查询所有房源信息
     * @return
     */
    @GetMapping("/list")
    public ResultVo<PageDto> list(){
        PageDto<House> pageDto = houseService.queryHouse();
        return ResultUtil.success(pageDto);
    }
}

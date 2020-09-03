package com.wl.zufang.service;

import com.wl.zufang.dto.PageDto;
import com.wl.zufang.entity.House;

/**
 * 房源信息
 * @author w.z
 * @date 2019/11/25 22:10
 */
public interface HouseService {

    /**
     * 根据id查询房源信息
     * @param id
     * @return
     */
    House getById(Long id);

    /**
     * 租房
     * @param id
     * @return
     */
    boolean rent(Long id);

    /**
     * 退房
     * @param id
     * @return
     */
    boolean cancel(Long id);

    /**
     * 查询所有房源信息
     * @return
     */
    PageDto<House> queryHouse();
}

package com.wl.zufang.service;

import com.wl.zufang.dto.PageDto;
import com.wl.zufang.entity.RentHouse;

/**
 * 租房
 * @author w.z
 * @date 2019/11/25 21:12
 */
public interface RentHouseService {

    /**
     * 新增租房订单
     * @param rentHouse
     * @return
     */
    boolean insert(RentHouse rentHouse);

    /**
     * 根据id取消订单
     * @param id
     * @return
     */
    boolean cancel(Long id);

    /**
     * 查询用户的所有订单
     * @param userId
     * @return
     */
    PageDto<RentHouse> listByUserID(Long userId);
}

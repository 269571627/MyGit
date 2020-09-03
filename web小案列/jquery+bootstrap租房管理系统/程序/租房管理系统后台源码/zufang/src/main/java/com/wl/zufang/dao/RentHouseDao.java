package com.wl.zufang.dao;

import com.wl.zufang.entity.RentHouse;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 用户租房订单处理
 * @author w.z
 * @date 2019/11/25 20:42
 */
public interface RentHouseDao {

    /**
     * 插入租房订单
     * @param rentHouse
     * @return
     */
    int insert(RentHouse rentHouse);
    /**
     * 根据id取消用户租房订单
     * @param id
     * @return
     */
    int delete(long id);

    /**
     * 查询用户所有的订单
     * @param userId
     * @return
     */
    List<RentHouse> listAll(@Param("userId") long userId);

    /**
     * 根据订单id查询订单
     * @param id
     * @return
     */
    RentHouse getById(long id);
}

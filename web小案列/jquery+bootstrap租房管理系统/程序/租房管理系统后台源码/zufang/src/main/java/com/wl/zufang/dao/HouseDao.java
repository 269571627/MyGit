package com.wl.zufang.dao;

import com.wl.zufang.entity.House;

import java.util.List;

/**
 * 房源信息处理
 * @author w.z
 * @date 2019/11/25 20:22
 */
public interface HouseDao {

    /**
     * 根据id查询房源信息
     * @param id
     * @return
     */
    House getById(long id);


    /**
     * 根据id修改房源状态,租房
     * @param id
     * @return
     */
    int updateRent(long id);

    /**
     * 根据id修改房源信息,退房
     * @param id
     * @return
     */
    int updateRetreat(long id);

    /**
     * 查询所有房源信息
     * @return
     */
    List<House> queryAll();
}

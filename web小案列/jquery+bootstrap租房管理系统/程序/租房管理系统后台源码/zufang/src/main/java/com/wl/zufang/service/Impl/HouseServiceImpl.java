package com.wl.zufang.service.Impl;

import com.wl.zufang.dao.HouseDao;
import com.wl.zufang.dto.PageDto;
import com.wl.zufang.entity.House;
import com.wl.zufang.service.HouseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author w.z
 * @date 2019/11/25 22:10
 */
@Service
public class HouseServiceImpl  implements HouseService {

    @Autowired
    private HouseDao houseDao;
    
    @Override
    public House getById(Long id) {
        return null;
    }

    /**
     * 租房
     * @param id
     * @return
     */
    @Override
    public boolean rent(Long id) {
        return false;
    }

    /**
     * 退房
     * @param id
     * @return
     */
    @Override
    public boolean cancel(Long id) {
        return false;
    }

    /**
     * 查询所有房源信息
     * @return
     */
    @Override
    public PageDto<House> queryHouse() {
        List<House> list = houseDao.queryAll();
        return new PageDto<>(list);
    }
}

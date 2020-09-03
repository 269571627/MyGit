package com.wl.zufang.service.Impl;

import com.wl.zufang.dao.HouseDao;
import com.wl.zufang.dao.RentHouseDao;
import com.wl.zufang.dto.PageDto;
import com.wl.zufang.entity.RentHouse;
import com.wl.zufang.enums.ErrorCodeEnum;
import com.wl.zufang.exception.BusinessException;
import com.wl.zufang.service.RentHouseService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


/**
 * @author w.z
 * @date 2019/11/25 21:23
 */
@Slf4j
@Service
public class RentHouseServiceImpl implements RentHouseService {

    @Autowired
    private RentHouseDao rentHouseDao;
    
    @Autowired
    private HouseDao houseDao;

    /**
     * 新增租房订单
     * @param rentHouse
     * @return
     */
    @Override
    public boolean insert(RentHouse rentHouse) {
        if (rentHouse == null) {
            log.error("RentHouseServiceImpl#insert: param is null.");
            throw new BusinessException(ErrorCodeEnum.PARAM_NULL);
        }
        // 修改房源状态
        int rent = houseDao.updateRent(rentHouse.getHouseId());
        // 记录订单信息
        int result = rentHouseDao.insert(rentHouse);
        if (result > 0 && rent > 0) {
            return true;
        } else {
            log.error("RentHouseServiceImpl#insert: add rentHous error.");
            throw new BusinessException(ErrorCodeEnum.INSERT_ERROR);
        }
    }

    /**
     * 取消订单
     * @param id
     * @return
     */
    @Override
    public boolean cancel(Long id) {
        if (id == null){
            log.error("RentHouseServiceImpl#cancel: param is null.");
            throw new BusinessException(ErrorCodeEnum.PARAM_NULL);
        }
        // 根据订单id查询订单
        RentHouse rentHouse = rentHouseDao.getById(id);
        // 修改房源状态
        int rent = houseDao.updateRetreat(rentHouse.getHouseId());
        // 删除订单记录
        int result = rentHouseDao.delete(id);
        if (result > 0 && rent > 0){
            return true;
        } else {
            log.error("RentHouseServiceImpl#cancel: cancel error.");
            throw new BusinessException(ErrorCodeEnum.CANCEL_ERROR);
        }
    }

    /**
     * 查询用户的订单
     * @param userId
     * @return
     */
    @Override
    public PageDto<RentHouse> listByUserID(Long userId) {
        if (userId == null){
            log.error("RentHouseServiceImpl#listByUserID: param is null.");
            throw new BusinessException(ErrorCodeEnum.PARAM_NULL);
        }
        List<RentHouse> list = rentHouseDao.listAll(userId);
        return new PageDto<>(list);
    }
}

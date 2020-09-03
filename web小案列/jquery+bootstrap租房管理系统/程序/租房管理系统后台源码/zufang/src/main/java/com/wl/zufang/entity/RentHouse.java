package com.wl.zufang.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.wl.zufang.vo.RentHouseVo;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

/**
 * 用户租房记录
 * @author w.z
 * @date 2019/11/25 19:27
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class RentHouse implements Serializable {

    private static final long serialVersionUID = -6324814976457662808L;
    /**
     * ID
     */
    private Long id;

    /**
     * 用户id
     */
    private Long userId;

    /**
     * 房源id
     */
    private Long houseId;

    /**
     * 房源编号
     */
    private String houseNumber;

    /**
     * 价格
     */
    private String price;

    /**
     * 租房时长
     */
    private String duration;

    /**
     * 房源介绍
     */
    private String content;

    /**
     * 房源状态,默认已出租
     */
    @JsonIgnore
    private int state;
    
    /**
     * 创建订单时间
     */
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
    private Date gmtCreate;

    /**
     * 修改时间
     */
    @JsonIgnore
    private Date gmtModify;
    
    public RentHouse(RentHouseVo rentHouseVo){
        this.userId = rentHouseVo.getUserId();
        this.houseId = rentHouseVo.getHouseId();
        this.houseNumber = rentHouseVo.getHouseNumber();
        this.price = rentHouseVo.getPrice();
        this.duration = rentHouseVo.getDuration();
        this.content = rentHouseVo.getContent();
    }
}

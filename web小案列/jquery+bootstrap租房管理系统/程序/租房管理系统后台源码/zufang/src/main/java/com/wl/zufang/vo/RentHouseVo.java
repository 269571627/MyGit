package com.wl.zufang.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author w.z
 * @date 2019/11/25 22:34
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class RentHouseVo {


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
}

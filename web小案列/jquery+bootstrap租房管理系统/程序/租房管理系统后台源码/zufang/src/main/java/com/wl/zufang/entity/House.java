package com.wl.zufang.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 房源信息
 * @author w.z
 * @date 2019/11/25 17:23
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class House {

    /**
     * 用户id
     */
    private Long id;

    /**
     * 房源编号
     */
    private String houseNumber;

    /**
     * 房源地区
     */
    private String area;

    /**
     * 户型
     */
    private String layout;

    /**
     * 价格
     */
    private String price;

    /**
     * 房源状态,默认未出租
     */
    @JsonIgnore
    private int state;

    /**
     * 属性
     */
    private String houseType;

    /**
     * 更多信息
     */
    private String content;

    /**
     * 图片1
     */
    private String image1;

    /**
     * 图片2
     */
    private String image2;
}

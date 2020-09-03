package com.wl.zufang.vo;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @author w.z
 * @date 2019/11/17 20:42
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ResultVo<T> implements Serializable {


    private static final long serialVersionUID = 5294354180042744886L;
    /**
     * 提示码
     */
    private String code;

    /**
     * 提示信息
     */
    private String msg;

    /**
     * 数据
     */
    private T data;
}

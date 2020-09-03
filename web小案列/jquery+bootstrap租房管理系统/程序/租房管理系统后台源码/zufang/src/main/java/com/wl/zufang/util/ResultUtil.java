package com.wl.zufang.util;

import com.wl.zufang.enums.ErrorCodeEnum;
import com.wl.zufang.vo.ResultVo;

/**
 * @author w.z
 * @date 2019/11/17 20:45
 */
public final class ResultUtil {

    public static ResultVo success(Object data) {
        ResultVo result = new ResultVo();
        result.setCode(ErrorCodeEnum.SUCCESS.getCode());
        result.setMsg(ErrorCodeEnum.SUCCESS.getMsg());
        result.setData(data);
        return result;
    }

    public static ResultVo success() {
        return success(null);
    }

    public static ResultVo error(String code, String msg) {
        ResultVo result = new ResultVo();
        result.setCode(code);
        result.setMsg(msg);
        result.setData(null);
        return result;
    }

    public static ResultVo error(ErrorCodeEnum errorCodeEnum) {
        ResultVo result = new ResultVo();
        result.setCode(errorCodeEnum.getCode());
        result.setMsg(errorCodeEnum.getMsg());
        result.setData(null);
        return result;
    }
}

package com.miaoshaproject.valiator;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.apache.commons.lang3.StringUtils;

import java.util.HashMap;
import java.util.Map;

/**
 * @Auther: Zihaoo
 * @Date: 2019/4/4
 */
public class ValidationResult {
    /**
     * 校验结果是否有错
     */
    @Setter
    private boolean hasErrors = false;

    /**
     * 存放错误信息的map
     */
    @Getter
    @Setter
    private Map<String, String> errorMsgMap = new HashMap<>();

    public boolean isHasErrors() {
        return hasErrors;
    }

    /**
     * 实现通用的通过格式化字符串信息获取错误结果的msg方法
     *
     * @return
     */
    public String getErrMsg() {
        return StringUtils.join(errorMsgMap.values().toArray(), ",");
    }
}


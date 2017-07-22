package org.snowWave.framework.bean;

import org.snowWave.framework.util.CollectionUtil;

import java.util.Collection;
import java.util.Map;

/**
 * 请求参数对象
 * Created by SnowWave on 2017/7/18.
 */
public class Param {

    private Map<String, Object> paramMap;

    public Param(Map<String, Object> paramMap) {
        this.paramMap = paramMap;
    }

    /**
     * 根据参数名获取long型参数值
     */
//    public long getLong(String name) {
//        return CastUtil.castLong(paramMap.get(name));
//    }

    /**
     * 获取所有字段信息
     */
    public Map<String, Object> getMap() {
        return paramMap;
    }

    /**
     * 判断是否为空
     */
    public boolean isEmpty() {
        return CollectionUtil.isEmpty((Collection<?>) paramMap);
    }
}

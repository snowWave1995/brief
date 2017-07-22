package org.snowWave.framework.util;

import org.apache.commons.collections4.CollectionUtils;
import org.snowWave.framework.bean.FormParam;

import java.util.Collection;
import java.util.List;

/**
 * 集合工具类
 * Created by SnowWave on 2017/7/18.
 */
public class CollectionUtil {



    /**
     * 判断集合是否非空
     */
    public static boolean isNotEmpty(Collection<?> collection) {
        return CollectionUtils.isNotEmpty(collection);
    }

    /**
     * 判断集合是否为空
     */
    public static boolean isEmpty(Collection<?> collection) {
        return CollectionUtils.isEmpty(collection);
    }
}

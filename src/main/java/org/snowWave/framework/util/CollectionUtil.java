package org.snowWave.framework.util;

import org.apache.commons.collections4.CollectionUtils;

import java.util.Collection;
import java.util.Set;

/**
 * 集合工具类
 * Created by SnowWave on 2017/7/18.
 */
public class CollectionUtil {


    /**
     * 判断集合是否非空
     * @param collection
     */
    public static boolean isNotEmpty(Set<Class<?>> collection) {
        return CollectionUtils.isNotEmpty((Collection<?>) collection);
    }

    /**
     * 判断集合是否为空
     */
    public static boolean isEmpty(Collection<?> collection) {
        return CollectionUtils.isEmpty(collection);
    }
}

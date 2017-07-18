package org.snowWave.framework.helper;

import org.snowWave.framework.util.ReflectionUtil;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * Created by SnowWave on 2017/7/17.
 *
 */
public final class BeanHelper {

    /**
     * 定义Bean 映射（用于存放 Bean类 与 Bean 实例的映射关系）
     */
    private static final Map<Class<?>, Object> BEAN_MAP = new HashMap<Class<?>, Object>();

    static {
        Set<Class<?>> beanClassSet = ClassHelper.getBeanClassSet();
        for (Class<?> beanClass : beanClassSet) {
            Object obj = ReflectionUtil.newInstance(beanClass);
            BEAN_MAP.put(beanClass, obj);
        }
    }

    /**
     * 获取Bean映射
     */
    public static Map<Class<?>,Object> getBeanMap() {
        return BEAN_MAP;
    }

    /**
     * 获取Bean 实例
     */
    public static <T> T getBean(Class<T> cls) {
        if (!BEAN_MAP.containsKey(cls)) {
            throw new RuntimeException("can not get bean by class:" + cls);
        }
        return (T) BEAN_MAP.get(cls);
    }
}

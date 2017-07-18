package org.snowWave.framework.helper;

import org.snowWave.framework.annotation.Autowired;
import org.snowWave.framework.util.ArrayUtil;
import org.snowWave.framework.util.CollectionUtil;
import org.snowWave.framework.util.ReflectionUtil;

import java.lang.reflect.Field;
import java.util.Map;

/**
 * 依赖注入助手
 * Created by SnowWave on 2017/7/17.
 *
 */
public final class IocHelper {
    static {
        //获取所有的Bean类与Bean实例之间的映射关系（map bean）
        Map<Class<?>, Object> beanMap = BeanHelper.getBeanMap();
        if (CollectionUtil.isNotEmpty(beanMap)) {
            //遍历 Bean Map
            for (Map.Entry<Class<?>, Object> beanEntity : beanMap.entrySet()) {
                //从BeanMap中获取Bean类与Bean实例
                Class<?> beanClass = beanEntity.getKey();
                Object beanInstance = beanEntity.getValue();
                //获取Bean类定义的所有成员变量（bean Field）
                Field[] beanFields = beanClass.getDeclaredFields();
                if (ArrayUtil.isNotEmpty(beanFields)) {
                    //遍历Bean Field
                    for (Field beanField : beanFields) {
                        //判断当前 Bean Field 是否带有Inject注解
                        if (beanField.isAnnotationPresent(Autowired.class)) {
                            //在Bean Map中获取Bean Field 对应的实例
                            Class<?> beanFieldClass = beanField.getType();
                            Object beanFieldInstance = beanMap.get(beanFieldClass);
                            if (beanFieldInstance != null) {
                                //通过反射初始化BeanField的值
                                ReflectionUtil.setField(beanInstance, beanField, beanFieldInstance);
                            }
                        }
                    }
                }
            }
        }
    }
}

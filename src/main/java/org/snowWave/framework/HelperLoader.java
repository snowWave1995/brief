package org.snowWave.framework;

import org.snowWave.framework.helper.BeanHelper;
import org.snowWave.framework.helper.ClassHelper;
import org.snowWave.framework.helper.ControllerHelper;
import org.snowWave.framework.helper.IocHelper;
import org.snowWave.framework.util.ClassUtil;

/**
 * 加载相应的Helper类
 * Created by SnowWave on 2017/7/18.
 */
public final class HelperLoader {

    public static void init() {
        Class<?>[] classList = {
                ClassHelper.class,
                BeanHelper.class,
                IocHelper.class,
                ControllerHelper.class
        };
        for (Class<?> cls : classList) {
            ClassUtil.loadClass(cls.getName(), false);
        }
    }

}

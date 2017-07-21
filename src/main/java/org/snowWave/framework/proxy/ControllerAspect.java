package org.snowWave.framework.proxy;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.print.attribute.standard.Media;
import java.lang.reflect.Method;

/**
 * Created by SnowWave on 2017/7/20.
 */
public class ControllerAspect extends AspectProxy {

    private static final Logger LOGGER = LoggerFactory.getLogger(ControllerAspect.class);
    private long begin;

    public void before(Class<?> cls, Method method, Object[] params) throws Throwable {
        LOGGER.debug(String.format("class: %s", cls.getName()));
        LOGGER.debug(String.format("method: %s", method.getName()));
        begin = System.currentTimeMillis();
    }

    public void after(Class<?> cls, Method method, Object[] params, Object result) throws Throwable {
        LOGGER.debug(String.format("time: %dms",System.currentTimeMillis() - begin));
    }
}

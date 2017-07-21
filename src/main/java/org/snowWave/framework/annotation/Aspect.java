package org.snowWave.framework.annotation;

import java.lang.annotation.*;

/**
 * 切面注解
 * Created by SnowWave on 2017/7/20.
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
public @interface Aspect {

    Class<? extends Annotation> value();
}

package org.snowWave.framework.util;

import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang3.StringUtils;

import java.util.Collection;

/**
 * Created by SnowWave on 2017/7/18.
 */
public class StringUtil {
    /**
     * 判断String是否非空
     */
    public static boolean isNotEmpty(String string) {
        return !StringUtils.isEmpty(string);
    }

    /**
     * 判断String是否为空
     */
    public static boolean isEmpty(String string) {
        return StringUtils.isEmpty(string);
    }

    public static String[] splitString(String body, String split){
        return body.split(split);
    }
}

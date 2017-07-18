package org.snowWave.framework.helper;

import org.apache.commons.collections4.CollectionUtils;
import org.snowWave.framework.annotation.Action;
import org.snowWave.framework.bean.Handler;
import org.snowWave.framework.bean.Request;
import org.snowWave.framework.util.ArrayUtil;
import org.snowWave.framework.util.CollectionUtil;

import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * Created by SnowWave on 2017/7/18.
 */
public final class ControllerHelper {

    /**
     * 用于存放请求与处理器的映射关系（Action Map）
     */
    private static final Map<Request,Handler> ACTION_MAP = new HashMap<Request, Handler>();

    static {
        //获取所有的Controller类
        Set<Class<?>> controllerClassSet = ClassHelper.getControllerClassSet();
        if (CollectionUtil.isNotEmpty(controllerClassSet)) {
            //遍历这些Controller类
            for (Class<?> controllerClass : controllerClassSet) {
                //获取Controller类中定义方法
                Method[] methods = controllerClass.getDeclaredMethods();
                if (ArrayUtil.isNotEmpty(methods)) {
                    //遍历这些Controller类中的方法
                    for (Method method : methods) {
                        //是否有Action注解
                        if (method.isAnnotationPresent(Action.class)) {
                            //从Action注解中获取URL映射规则
                            Action action = method.getAnnotation(Action.class);
                            String mapping = action.value();
                            //验证URL映射规则
                            if (mapping.matches("\\w+:/\\w*")) {
                                String[] array = mapping.split(":");
                                if (ArrayUtil.isNotEmpty(array) && array.length == 2) {
                                    //获取请求方法与路径
                                    String requestMethod = array[0];
                                    String requestPath = array[1];
                                    Request request = new Request(requestMethod, requestPath);
                                    Handler handler = new Handler(controllerClass, method);
                                    //初始化Action Map
                                    ACTION_MAP.put(request, handler);
                                }
                            }
                        }
                    }
                }
            }
        }
    }

    /**
     * 获取Handler
     */
    public static Handler getHandler(String requestMethod, String requestPath) {
        Request request = new Request(requestMethod, requestPath);
        return ACTION_MAP.get(request);
    }
}

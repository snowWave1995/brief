package org.snowWave.framework.bean;

import java.lang.reflect.Method;

/**
 * 封装Action信息
 * Created by SnowWave on 2017/7/17.
 */
public class Handler {

    /**
     * Controller 类
     */
    private Class<?> controllerClass;

    /**
     * Action方法
     * @param controllerClass
     * @param actionMethod
     */
    private Method actionMethod;

    public Handler(Class<?> controllerClass, Method actionMethod) {
        this.controllerClass = controllerClass;
        this.actionMethod = actionMethod;
    }

    public Class<?> getControllerClass() {
        return controllerClass;
    }

    public Method getActionMethod() {
        return actionMethod;
    }

 }

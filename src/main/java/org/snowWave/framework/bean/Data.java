package org.snowWave.framework.bean;

/**
 * 返回数据对象
 * Created by SnowWave on 2017/7/18.
 */
public class Data {

    /**
     * 模型数据
     */
    private Object model;

    public Data(Object model) {
        this.model = model;
    }

    public Object getModel() {
        return model;
    }
}

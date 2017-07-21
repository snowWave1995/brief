package org.snowWave.framework.proxy;

/**
 * 代理接口
 * Created by SnowWave on 2017/7/20.
 */
public interface Proxy {

    /**
     * 执行链式代理
     */
    Object doProxy(ProxyChain proxyChain) throws Throwable;
}

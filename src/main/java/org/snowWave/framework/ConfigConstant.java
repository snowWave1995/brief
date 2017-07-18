package org.snowWave.framework;

/**
 * 提供配置项常量
 * Created by SnowWave on 2017/7/16.
 */
public interface ConfigConstant {
    String CONFIG_FILE = "brief.properties";

    String JDBC_DRIVER = "brief.framework.jdbc.driver";
    String JDBC_URL = "brief.framework.jdbc.url";
    String JDBC_USERNAME = "brief.framework.jdbc.username";
    String JDBC_PASSWORD = "brief.framework.jdbc.password";

    String APP_BASE_PACKAGE = "brief.framework.app.base_package";
    String APP_JSP_PATH = "brief.framework.app.jsp_path";
    String APP_ASSET_PATH = "brief.framework.app.asset_path";
}

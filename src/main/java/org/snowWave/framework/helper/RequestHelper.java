package org.snowWave.framework.helper;

import com.sun.org.apache.regexp.internal.RE;
import org.snowWave.framework.bean.FormParam;
import org.snowWave.framework.bean.Param;
import org.snowWave.framework.util.ArrayUtil;
import org.snowWave.framework.util.CodecUtil;
import org.snowWave.framework.util.StreamUtil;
import org.snowWave.framework.util.StringUtil;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;

/**
 * Created by SnowWave on 2017/7/22.
 */
public final class RequestHelper {

    /**
     * 创建请求对象
     */
    public static Param createParam(HttpServletRequest request) throws IOException {
        List<FormParam> formParamList = new ArrayList<FormParam>();
        formParamList.addAll(parseParametersNames(request));
        formParamList.addAll(parseInputStream(request));
        return new Param(formParamList);
    }

    private static List<FormParam> parseParametersNames(HttpServletRequest request) {
        List<FormParam> formParamList = new ArrayList<FormParam>();
        Enumeration<String> paramNames = request.getParameterNames();
        while (paramNames.hasMoreElements()) {
            String fieldName = paramNames.nextElement();
            String[] fieldValues = request.getParameterValues(fieldName);
            if (ArrayUtil.isNotEmpty(fieldValues)) {
                Object fieldValue;
                if (fieldValues.length == 1) {
                    fieldValue = fieldValues[0];
                } else {
                    StringBuilder sb = new StringBuilder("");
                    for (int i = 0; i < fieldValues.length; i++) {
                        sb.append(fieldValues[i]);
                        if ( i != fieldValues.length-1) {
                            sb.append(StringUtil.SEPARATOR);
                        }
                    }
                    fieldValue = sb.toString();
                }
                formParamList.add(new FormParam(fieldName, fieldValue));
            }
        }
        return formParamList;
    }

    private static List<FormParam> parseInputStream(HttpServletRequest request) throws IOException {
        List<FormParam> formParamList = new ArrayList<FormParam>();
        String body = CodecUtil.decodeURL(StreamUtil.getString(request.getInputStream()));
        if (StringUtil.isNotEmpty(body)) {
            String[] kvs = StringUtil.splitString(body, "&");
            for (String kv : kvs) {
                String[] array = StringUtil.splitString(kv, "=");
                if (ArrayUtil.isNotEmpty(array) && array.length ==2) {
                    String fieldName = array[0];
                    String fieldValue = array[1];
                    formParamList.add(new FormParam(fieldName, fieldValue));
                }
            }
        }
        return formParamList;
    }



}

package com.dip.utils;

import java.util.Map;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

/**
 * @author 98285
 */
@SuppressWarnings({"rawtypes"})
public final class DataConvertUtil {

    private DataConvertUtil() {

    }

    /**
     * json字符串转map
     *
     * @param jsonStr
     * @return
     */
    public static Map convertJsonToMap(String jsonStr) {
        Object obj = JSONObject.parse(jsonStr);
        return JSON.parseObject(obj.toString(), Map.class);
    }
}

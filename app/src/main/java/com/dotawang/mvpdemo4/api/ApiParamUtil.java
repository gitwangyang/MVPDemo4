package com.dotawang.mvpdemo4.api;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Android-汪洋
 * @Date 2018/11/30
 * @Description 网络请求参数配置
 */
public class ApiParamUtil {
    //新闻
    public static Map<String, String> getNewsList(String type) {
        Map<String, String> map = new HashMap<>();
        map.put("key", "2ce13fbfa4c244516a8f006cfec98100");
        map.put("type", type);
        return map;
    }
}

package com.dotawang.mvpdemo4.api;

/**
 * @author Android-汪洋
 * @Date 2018/11/30
 * @Description 服务器环境配置
 */
public class ApiConstants {

    /** 是否正式环境*/
    public static boolean ISRELEASE = false;

    /**测试地址*/
    public static String TEST_URL = "http://v.juhe.cn/";

    /**正式地址*/
    public static String RELEASE_URL = "http://v.juhe.cn/";

    public static final String BASE_URL = ISRELEASE ? "http://v.juhe.cn/" : "http://v.juhe.cn/";

}

package com.dotawang.mvpdemo4.base;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.content.res.Resources;
import android.support.multidex.MultiDex;

import java.util.ArrayList;

/**
 * @author Android-汪洋
 * @Date 2018/11/30
 * @Description
 */
public class MyApplication extends Application{

    public static MyApplication instance;

    private ArrayList<Activity> activityList = new ArrayList<Activity>();

    @Override
    public void onCreate() {
        super.onCreate();
        instance = this;
    }

    /**
     * 分包
     * @param base
     */
    @Override
    protected void attachBaseContext(Context base) {
        super.attachBaseContext(base);
        MultiDex.install(this);
    }

    public static Context getAppContext(){
        return instance;
    }

    public static Resources getAppResource(){
        return instance.getResources();
    }

//    /**
//     * 程序终止的时候执行
//     */
//    @Override
//    public void onTerminate() {
//        super.onTerminate();
//        this.mAppDelegate.onTerminate();
//    }

//    /**
//     * 将AppComponent返回出去,供其它地方使用, AppComponent接口中声明的方法返回的实例,在getAppComponent()拿到对象后都可以直接使用
//     * @return
//     */
//    @Override
//    public AppComponent getAppComponent() {
//        return mAppDelegate.getAppComponent();
//    }

    // 添加Activity到容器中
    public void addActivity(Activity activity) {
        activityList.add(activity);
    }

    // 遍历所有Activity并finish
    public void exit() {
        for (Activity activity : activityList) {
            activity.finish();
        }
//		App.getInstance().destroyMap();
        System.exit(0);
    }


    //销毁某个activity实例
    public void remove(Class<? extends Activity> t) {
        for (Activity activity : activityList) {
            if (activity.getClass() == t) {
                activity.finish();
            }
        }
    }

    public boolean haveActivity(Class<? extends Activity> t) {
        for (Activity activity : activityList) {
            if (activity.getClass() == t) {
                return true;
            }
        }
        return false;
    }

    public void clearActivityList() {
        for (Activity activity : activityList) {
            activity.finish();
        }
        activityList.clear();
    }

    public ArrayList<Activity> getActivityList() {
        return activityList;
    }

}

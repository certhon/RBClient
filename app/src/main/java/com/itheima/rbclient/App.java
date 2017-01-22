package com.itheima.rbclient;

import android.app.Application;
import android.content.Context;

import org.senydevpkg.net.HttpLoader;

/**
 * 全局Application类
 * 通常做一些初始化工作，
 * Notice：记得在AndroidManife.xml清单文件中配置APP路径
 */
public class App extends Application{

    /** 全局上下文 */
    public static Context context;


    public static HttpLoader HL;

    @Override
    public void onCreate() {
        super.onCreate();

		System.out.println("aaaaaaaaaaaaaaaaaaa");

        System.out.println("xxxxxxxxxxxxxxx");
        context = this.getApplicationContext();
        HL = HttpLoader.getInstance(context);

    }
}

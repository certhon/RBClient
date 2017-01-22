package com.itheima.rbclient.util;

import android.content.Context;
import android.content.SharedPreferences;

import java.util.HashMap;
import java.util.Map;


public class NetUtil {

    /**
     * 生成公共的请求头部，一般一个应用的所有接口的请求头都是固定的。
     * @param context
     * @return
     */
    public static Map<String, String> generateHeaders(Context context) {
        Map<String, String> headers = new HashMap<>();
        /**
         * Notice：从SP中去取userid，userid在登录后由服务器返回。
         * eg:
         *  SharedPreferences sp = context.getSharedPreferences("config", Context.MODE_PRIVATE)
         *  header.put("userid", sp.getString("userid", ""))
         */

        SharedPreferences sp = context.getSharedPreferences("config", Context.MODE_PRIVATE);
        String userid = sp.getString("userid","");

        headers.put("userid", userid);
        return headers;
    }
}

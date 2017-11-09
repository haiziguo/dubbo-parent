package me.lzp;

import com.alibaba.dubbo.common.URL;

/**
 * Created by lizhanpeng on 2017/11/9.
 */
public class SimpleExtImpl2 implements SimpleExt {
    public String echo(URL url, String s) {
        return "Ext1Impl2-echo";
    }

    public String yell(URL url, String s) {
        return "Ext1Impl2-yell";
    }

    public String bang(URL url, int i) {
        return "bang2";
    }

}
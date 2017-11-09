package me.lzp;

import com.alibaba.dubbo.common.URL;
import com.alibaba.dubbo.common.extension.Adaptive;
import com.alibaba.dubbo.common.extension.SPI;

/**
 * Created by lizhanpeng on 2017/11/9.
 */
@SPI("impl1")
public interface SimpleExt {
    // 没有使用key的@Adaptive ！
    @Adaptive
    String echo(URL url, String s);

    @Adaptive({"key1", "key2"})
    String yell(URL url, String s);

    // 无@Adaptive ！
    String bang(URL url, int i);
}

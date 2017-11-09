package me.lzp;

import com.alibaba.dubbo.common.URL;
import com.alibaba.dubbo.common.extension.ExtensionLoader;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by lizhanpeng on 2017/11/9.
 */
public class Main {
    public static void main(String[] args) {
       /* SimpleExt ext = ExtensionLoader.getExtensionLoader(SimpleExt.class).getDefaultExtension();
        System.out.println(ext);*/
        //me.lzp.SimpleExtImpl1@5d1ddcf4


        SimpleExt ext = ExtensionLoader.getExtensionLoader(SimpleExt.class).getAdaptiveExtension();

        Map<String, String> map = new HashMap<String, String>();
        map.put("simple.ext", "impl2");//手动在参数中配置impl2,参数为simple.ext
        //没有指定具体parameters参数，所以选用默认实现，最后返回impl1
        URL url = new URL("p1", "1.2.3.4", 1010, "path1", map);
        //如果不设置默认的SPI实现类，则报异常
        //java.lang.IllegalStateException: Fail to get extension(com.alibaba.dubbo.common.extensionloader.ext1.SimpleExt) name from url(p1://1.2.3.4:1010/path1) use keys([simple.ext])
        String echo = ext.echo(url, "haha");
        System.out.println(echo);
    }
}

package com.alibaba.dubbo.demo.consumer;

import com.alibaba.dubbo.demo.DemoService;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by ken.lj on 2017/7/31.
 */
public class Consumer {

    public static void main(String[] args)throws Exception {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(new String[]{"META-INF/spring/dubbo-demo-consumer.xml"});
        context.start();
       /* RpcContext.getContext().setAttachment()*/
        for (int i = 0; i < 100; i++) {
            DemoService demoService = (DemoService) context.getBean("demoService"); // 获取远程服务代理
            String hello = demoService.sayHello("world"); // 执行远程方法
            System.out.println(hello); // 显示调用结果
            Thread.sleep(1000);
        }
    }
}

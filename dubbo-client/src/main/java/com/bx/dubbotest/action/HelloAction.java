package com.bx.dubbotest.action;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.dubbo.config.annotation.Reference;
import com.bx.dubbotest.api.HelloService;

import java.text.SimpleDateFormat;
import java.util.Date;

@RestController
@RequestMapping(value="/hello")
public class HelloAction {
	
	@Reference HelloService helloService;
	
	@RequestMapping
	public String say(String name) {
		System.out.println("HelloAction接收到请求:"+name);
		String str="<h1>这是Dubbo 消费者端(springboot)</h1>";
		str+="<h2></h2>";
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss ");
		String ds = df.format(new Date());
		System.out.println(ds + "HelloAction接收到请求:"+name);
		str = ds + "<h1>这是Dubbo 消费者端(Apollo)</h1><h2>新功能测试</h2>";
		str+=helloService.hello(name);
		System.out.println(ds + "HelloService返回到结果:"+str);
		return str;
	}
}

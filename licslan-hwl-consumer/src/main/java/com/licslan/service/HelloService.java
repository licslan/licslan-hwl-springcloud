package com.licslan.service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

/**
 * Created by fangzhipeng on 2017/4/6.
 */
@Service
public class HelloService {

    @Autowired
    RestTemplate restTemplate;

   /* public String hiService(String name) {
        return restTemplate.getForObject("http://licslan-hwl-eurekaclient/hi?name="+name,String.class);
    }*/

   /**
    * 改造HelloService类，在hiService方法上加上@HystrixCommand注解。
    * 该注解对该方法创建了熔断器的功能，并指定了fallbackMethod熔断方法，
    * 熔断方法直接返回了一个字符串，字符串为”hi,”+name+”,sorry,error!”，代码如下：
    * */

    @HystrixCommand(fallbackMethod = "hiError")
    public String hiService(String name) {
        return restTemplate.getForObject("http://licslan-hwl-eurekaclient/hi?name="+name,String.class);
    }

    public String hiError(String name) {
        return "hi,"+name+",sorry,error!";
    }

}

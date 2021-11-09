package com.baidu.springcloud.controller;

import com.baidu.springcloud.pojo.Dept;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@RestController
public class DeptConsumerController {
    //dubbo 和 zookeeper rpc时候是 reference引用接口
    //消费者不应该有service请求
    //找restful风格 此时可以发现有resttemplate模板 用于请求供我们直接调用就可以
    //把template注册到spring中，没有@bean 手动构造config
    @Autowired
    private RestTemplate restTemplate; //提供多种便捷访问远程http的方法 简单的restful服务模板
    //private static final String REST_URL_PREFIX="http://localhost:8001";
    //此时ribbon应该拿某一个服务来做请求
    private static final String REST_URL_PREFIX="http://SPRINGCLOUD-PROVIDER-DEPT";
    @RequestMapping("/consumer/dept/add")
    public boolean add( Dept dept){
        return  restTemplate.postForObject(REST_URL_PREFIX+"/dept/add", dept,Boolean.class);
    }
    @RequestMapping("/consumer/dept/list")
    public List<Dept> getList(){
        return restTemplate.getForObject(REST_URL_PREFIX+"/dept/list", List.class);
    }

    @RequestMapping("/consumer/dept/get/{id}")
    public Dept get(@PathVariable("id") Long id){
        //此时需要去localhost:8001/dept/get/{id} 拿
        return restTemplate.getForObject(REST_URL_PREFIX+"/dept/get/"+id,Dept.class);//返回dept类型
    }


}

package com.baidu.springcloud.controller;

import com.baidu.springcloud.pojo.Dept;
import com.baidu.springcloud.service.DeptService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class DeptController {
    //提供restful服务
    @Autowired
    DeptService deptService;
    //获取配置信息
    @Autowired
    DiscoveryClient discoveryClient;


    @HystrixCommand(fallbackMethod = "queryByid_Hystrix") //失败了调用备选方法（方法名字）
    @GetMapping("/dept/get/{id}")
    public Dept queryByid(@PathVariable("id") Long id){
        Dept dept = deptService.queryDeptById(id);
        if(dept==null){
            throw new RuntimeException("id=>"+id+"不存在该用户，或者信息无法找到");//id不存在抛出异常
        }
        return dept;
    }
    //备选方案
    public Dept queryByid_Hystrix(@PathVariable("id") Long id){
        return new Dept()
                .setDeptno(id)
                .setDname("hystrix 不存在该id")
                .setDb_source("没有这个数据库"); //链式编程 需要在pojo加@Accessors(chain = true) 注解
    }


}

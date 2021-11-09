package com.baidu.springcloud.controller;

import com.baidu.springcloud.pojo.Dept;
import com.baidu.springcloud.service.DeptService;
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


    @PostMapping("/dept/add")
    public boolean addDept(@RequestBody Dept dept){
        return deptService.addDept(dept);
    }
    @GetMapping("/dept/get/{id}")
    public Dept queryByid(@PathVariable("id") Long id){
        return deptService.queryDeptById(id);
    }
    @GetMapping("/dept/list")
    public List<Dept> queryAll(){
        return deptService.queryDept();
    }

    //注册进来的微服务获取一些消息
    //个人用不到
    // 协同需要
    @RequestMapping("/dept/discovery")
    public Object discovery(){
        List<String> services = discoveryClient.getServices();
        System.out.println("discover=>"+services);

        //得到一个具体微服务信息
        List<ServiceInstance> instances = discoveryClient.getInstances("SPRINGCLOUD-PROVIDER-DEPT");//通过具体微服务名字拿到信息
        for (ServiceInstance instance : instances) {
            System.out.println(instance); //服务的端口，主机，等等内容
        }
        return this.discoveryClient;
    }
}

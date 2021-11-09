package com.baidu.springcloud.controller;

import com.baidu.springcloud.pojo.Dept;
import com.baidu.springcloud.service.DeptClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@RestController
public class DeptConsumerController {
    //dubbo 和 zookeeper rpc时候是 reference引用接口
    //消费者不应该有service请求
    //找restful风格 此时可以发现有resttemplate模板 用于请求供我们直接调用就可以
    //把template注册到spring中，没有@bean 手动构造config
    //@Autowired
    //private RestTemplate restTemplate; //提供多种便捷访问远程http的方法 简单的restful服务模板
    //private static final String REST_URL_PREFIX="http://localhost:8001";
    //此时ribbon应该拿某一个服务来做请求
    //private static final String REST_URL_PREFIX="http://SPRINGCLOUD-PROVIDER-DEPT";

    //Feign
    @Autowired
    private DeptClientService deptClientService;

    @RequestMapping("/consumer/dept/add")
    public boolean add( Dept dept){
        return deptClientService.addDept(dept);
    }
    @RequestMapping("/consumer/dept/list")
    public List<Dept> getList(){
        return deptClientService.queryDept();
    }

    @RequestMapping("/consumer/dept/get/{id}")
    public Dept get(@PathVariable("id") Long id){
        return deptClientService.queryDeptById(id);
    }


}

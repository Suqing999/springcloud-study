package com.baidu.springcloud.service;

import com.baidu.springcloud.pojo.Dept;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.Mapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

//写了注解就和reference一样可以被服务直接调用
//value是微服务的名字

@Component
@FeignClient(value = "SPRINGCLOUD-PROVIDER-DEPT",fallbackFactory = DeptClientFallbackFactory.class)
public interface DeptClientService {
    //增加一个部门
    @PostMapping("/dept/add")
    public boolean addDept(Dept dept);
    //根据id查
    @GetMapping("/dept/get/{id}")
    public Dept queryDeptById(@PathVariable("id") Long id );
    //查询所有
    @GetMapping("/dept/list")
    public List<Dept> queryDept();
}

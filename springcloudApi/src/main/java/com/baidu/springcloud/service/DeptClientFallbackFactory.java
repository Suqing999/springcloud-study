package com.baidu.springcloud.service;

import com.baidu.springcloud.pojo.Dept;
import feign.hystrix.FallbackFactory;
import org.springframework.stereotype.Component;

import java.util.List;

//用于服务降级
@Component
public class DeptClientFallbackFactory implements FallbackFactory {

    @Override
    public DeptClientService create(Throwable throwable) {
        //进行熔断降级
        return new DeptClientService() {
            @Override
            public boolean addDept(Dept dept) {
                return false;
            }
            @Override
            public Dept queryDeptById(Long id) {
                return new Dept()
                        .setDeptno(id)
                        .setDname("没有对应的信息")
                        .setDb_source("没有对应的数据库");
            }
            @Override
            public List<Dept> queryDept() {
                return null;
            }
        };
    }
}

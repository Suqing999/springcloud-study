package com.baidu.springcloud.service;

import com.baidu.springcloud.pojo.Dept;

import java.util.List;

public interface DeptService {

    //增加一个部门
    public boolean addDept(Dept dept);

    //根据id查
    public Dept queryDeptById(Long id );

    //查询所有
    public List<Dept> queryDept();

}

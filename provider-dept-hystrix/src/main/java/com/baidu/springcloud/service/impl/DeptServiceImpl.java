package com.baidu.springcloud.service.impl;

import com.baidu.springcloud.dao.DeptDao;
import com.baidu.springcloud.pojo.Dept;
import com.baidu.springcloud.service.DeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DeptServiceImpl implements DeptService {

    @Autowired
    DeptDao deptDao;

    @Override
    public boolean addDept(Dept dept) {
        return deptDao.addDept(dept);
    }

    @Override
    public Dept queryDeptById(Long id) {
        return deptDao.queryDeptById(id);
    }

    @Override
    public List<Dept> queryDept() {
        return deptDao.queryDept();
    }
}

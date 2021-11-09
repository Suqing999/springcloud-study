package com.baidu.springcloud.dao;

import com.baidu.springcloud.pojo.Dept;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface DeptDao {
    //增加一个部门
    public boolean addDept(Dept dept);

    //根据id查
    public Dept queryDeptById(Long id );

    //查询所有
    public List<Dept> queryDept();

}

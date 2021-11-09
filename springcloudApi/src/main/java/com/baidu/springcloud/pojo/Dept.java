package com.baidu.springcloud.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.experimental.Accessors;

import java.io.Serializable;

//所有实体类要序列化
//orm
@Data
@NoArgsConstructor
@ToString
@Accessors(chain = true) //支持链式写法
public class Dept implements Serializable {
    private Long deptno;
    private String dname;

    //微服务架构 一个服务对应一个数据库（同一个信息可能存在不同的数据库）
    private String db_source;

    public Dept(String dname) {
        this.dname = dname;
    }
}

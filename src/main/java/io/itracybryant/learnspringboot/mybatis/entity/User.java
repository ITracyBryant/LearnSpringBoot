package io.itracybryant.learnspringboot.mybatis.entity;

import lombok.Data;
import lombok.ToString;

import java.io.Serializable;
import java.util.Date;

/**
 * @ClassName ShiroUser
 * @Description TODO
 * @Author Administrator
 * @Date 2019/3/9 16:30
 * @Version 1.0
 */
@Data
@ToString
public class User implements Serializable {
    private Long id;
    private String username;
    private String password;
    private Date createTime;
}

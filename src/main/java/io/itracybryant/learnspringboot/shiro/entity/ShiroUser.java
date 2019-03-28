package io.itracybryant.learnspringboot.shiro.entity;

import lombok.Data;
import lombok.ToString;

import java.io.Serializable;

/**
 * @ClassName ShiroUser
 * @Description TODO
 * @Author Administrator
 * @Date 2019/3/26 20:53
 * @Version 1.0
 */
@Data
@ToString
public class ShiroUser implements Serializable {
    private Long id;
    private String username;
    private String password;
}

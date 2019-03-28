package io.itracybryant.learnspringboot.thymeleaf;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

/**
 * @ClassName ShiroUser
 * @Description TODO
 * @Author Administrator
 * @Date 2019/3/3 10:50
 * @Version 1.0
 */
@Getter
@Setter
public class User implements Serializable {

    private String username;
    private String password;
}

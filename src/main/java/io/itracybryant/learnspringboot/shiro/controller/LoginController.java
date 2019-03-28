package io.itracybryant.learnspringboot.shiro.controller;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

/**
 * @ClassName LoginController
 * @Description TODO
 * @Author Administrator
 * @Date 2019/3/26 21:00
 * @Version 1.0
 */
@Controller
public class LoginController {
    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @GetMapping("/shiro/index")
    public String index() {
        return "shiro/index";
    }

    /**
     * 登录地址
     *
     * @return
     */
    @GetMapping("/login")
    public String login() {
        return "shiro/login";
    }

    /**
     * 登录接口
     * @param username
     * @param password
     * @param model
     * @return 登录结果信息或成功主页视图
     */
    @PostMapping("/login")
    public String login(String username, String password, Model model) {
        String info = null;
        // 封装token信息，等于用户名+密码
        UsernamePasswordToken token = new UsernamePasswordToken(username, password);
        // 获取Shiro Subject的实例
        Subject subject = SecurityUtils.getSubject();
        try {
            subject.login(token);
            info = String.valueOf(subject.isAuthenticated());
            model.addAttribute("info", "登录结果 ---> " + info);
            return "shiro/index";
        } catch (UnknownAccountException e) {
            e.printStackTrace();
            info = "未知账户异常";
        } catch (AuthenticationException e) {
            e.printStackTrace();
            info = "账户名或密码错误";
        } catch (Exception e) {
            e.printStackTrace();
            info = "其它错误";
        }
        model.addAttribute("info", "登录结果 ---> " + info);
        logger.info("登录结果 ---> {}", info);
        return "shiro/login";
    }
}

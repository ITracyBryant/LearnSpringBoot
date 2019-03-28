package io.itracybryant.learnspringboot.thymeleaf;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName ThymeleafController
 * @Description TODO
 * @Author Administrator
 * @Date 2019/3/2 21:13
 * @Version 1.0
 */
@Controller
public class ThymeleafController {

    @RequestMapping("/index")
    public String index(Model model){
        model.addAttribute("test","测试");

        User user = new User();
        user.setUsername("itracybryant");
        user.setPassword("xyz");
        model.addAttribute("user",user);

        List<String> list = new ArrayList<>();
        list.add("元素1");
        list.add("元素2");
        list.add("元素3");
        model.addAttribute("list", list);
        return "index";
    }
}

package io.itracybryant.learnspringboot.redis.controller;

import io.itracybryant.learnspringboot.redis.dto.RedisInfo;
import io.itracybryant.learnspringboot.redis.service.RedisService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * @ClassName RedisController
 * @Description TODO
 * @Author Administrator
 * @Date 2019/3/10 16:57
 * @Version 1.0
 */
@Controller
public class RedisController {
    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @GetMapping("/")
    public String main() {
        return "/common/main";
    }

    @GetMapping("/index1")
    public String index1() {
        return "index1";
    }

    @GetMapping("/redis/monitor")
    public String monitor() {
        return "/redis/monitor";
    }

    @Autowired
    private RedisService redisService;

    @GetMapping("/redis/info")
    public String info(Model model) {
        try {
            List<RedisInfo> infoList = redisService.getRedisInfo();
            model.addAttribute("infoList", infoList);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "/redis/info";
    }

    @RequestMapping("/redis/memory")
    @ResponseBody
    public Map memory() {
        return redisService.getRedisMemory();
    }

    @RequestMapping("/redis/dbsize")
    @ResponseBody
    public Map dbsize() {
        return redisService.getRedisDbSize();
    }

    @GetMapping("/redis/terminal")
    public String terminal(Model model) {
        model.addAttribute("osName", System.getProperty("os.name"));
        return "/redis/terminal";
    }

    @RequestMapping("/redis/keys")
    @ResponseBody
    public Set<String> keys(String arg) {
        return redisService.getKeys(arg);
    }

    @RequestMapping("/redis/get")
    @ResponseBody
    public String get(String arg) {
        return redisService.get(arg);
    }

    @RequestMapping("/redis/set")
    @ResponseBody
    public Boolean set(String arg) {
        try {
            String[] args = arg.split(",");
            if (args.length == 1 || args.length != 2) {
                logger.error("参数错误");
                return null;
            }
            return redisService.set(args[0], args[1]);
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    @RequestMapping("/redis/del")
    @ResponseBody
    public Long del(String arg) {
        try {
            String[] args = arg.split(",");
            return redisService.del(args);
        } catch (Exception e) {
            e.printStackTrace();
            return 0L;
        }
    }

    @RequestMapping("/redis/exists")
    @ResponseBody
    public Long exists(String arg) {
        try {
            String[] args = arg.split(",");
            return redisService.exist(args);
        } catch (Exception e) {
            e.printStackTrace();
            return 0L;
        }
    }

    @RequestMapping("/redis/pttl")
    @ResponseBody
    public Long pttl(String arg){
        try{
            return redisService.pttl(arg);
        }catch (Exception e){
            e.printStackTrace();
            return 0L;
        }
    }

    @RequestMapping("/redis/pexpire")
    public Long pexpire(String arg) {
        try {
            String[] args = arg.split(",");
            if (args.length != 2) {
                logger.error("参数错误");
                return 0L;
            }
            return redisService.pexpire(args[0], Long.valueOf(args[1]));
        } catch (Exception e) {
            e.printStackTrace();
            return 0L;
        }
    }
}

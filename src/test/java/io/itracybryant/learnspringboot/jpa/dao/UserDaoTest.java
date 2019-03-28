package io.itracybryant.learnspringboot.jpa.dao;

import io.itracybryant.learnspringboot.jpa.entity.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.*;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName UserDaoTest
 * @Description TODO
 * @Author Administrator
 * @Date 2019/3/7 9:30
 * @Version 1.0
 */
@SpringBootTest
@RunWith(SpringRunner.class)
public class UserDaoTest {
    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private UserDao userDao;

    // 查询所有
    @Test
    public void testFindAll(){
        List<User> list = userDao.findAll();
        list.forEach(user -> {
            logger.info("user = {}", user);
        });
    }

    //根据ID查询
    @Test
    public void testFindById(){
        User user = userDao.findById(1L).get();
        logger.info("user = {}", user);
    }

    // 动态条件查询，根据某个字段查询
    @Test
    public void testFindByExample(){
        User user = new User();
        user.setUsername("zz23");
        Example<User> example = Example.of(user);
        List<User> list = userDao.findAll(example);
        list.forEach(user1 -> {
            logger.info("user = {}", user1);
        });
    }

    //添加
    @Test
    public void testSave(){
        User user = new User();
        user.setUsername("vc");
        user.setPassword("xy");
        user.setDesciption("qwertyuiopasdfghjklzxcvbnm");
        userDao.save(user);
        List<User> list = userDao.findAll();
        list.forEach(user1 -> {
            logger.info("user = {}", user1);
        });
    }

    // 批量插入  直接方法，很慢
    @Test
    public void testBatchSave(){
        List<User> list = new ArrayList<>();
        for(int i = 0; i < 10; i++){
            User user = new User();
            user.setUsername("xyxy" + i);
            user.setPassword("zzzz" + i);
            user.setDesciption("asdfasdf" + i);
            list.add(user);
            //userDao.save(user);
        }
        userDao.saveAll(list);
        List<User> userList = userDao.findAll();
        userList.forEach(user -> {
            logger.info("user = {}", user);
        });
    }

    // 更新
    @Test
    public void testUpdate(){
        User user = new User();
        user.setId(1L);
        user.setUsername("yyy");
        userDao.save(user);
        logger.info("user = {}", userDao.findById(user.getId()).get());
    }

    // 删除
    @Test
    public void testDelete(){
        User user = new User();
        user.setId(1L);
        userDao.delete(user);
    }

    // 分页查询
    @Test
    public void testFindByPage(){
        int pageNumber = 0; // 当前页数是第一页，从0开始
        int pageSize = 10; // 每页显示的记录数
        Sort sort = new Sort(Sort.Direction.ASC, "id");
        Pageable pageable = new PageRequest(pageNumber, pageSize, sort);
        Page<User> page = userDao.findAll(pageable);
        logger.info("总记录数 = {}", page.getTotalElements());
        logger.info("总页数 = {}", page.getTotalPages());
        logger.info("当前页记录 = {}", page.getContent());
    }

    //自定义sql
    @Test
    public void testFindByUsername(){
        User user = userDao.findByUsername("vc");
        logger.info("user = {}", user);
    }

    @Test
    public void testFindByPassword(){
        User user = userDao.findByPassword("xxx");
        logger.info("user = {}", user);
    }

    @Test
    public void testDeleteByPassword(){
        userDao.deleteByPassword("zzzz9");
        User user = userDao.findByPassword("zzzz9");
        logger.info("user = {}", user);
    }
}

package io.itracybryant.learnspringboot.jpa.dao;

import io.itracybryant.learnspringboot.jpa.entity.Demo;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.*;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;
import java.util.List;

/**
 * @ClassName DemoDaoTest
 * @Description TODO
 * @Author Administrator
 * @Date 2019/3/4 20:23
 * @Version 1.0
 */
@SpringBootTest
@RunWith(SpringRunner.class)
public class DemoDaoTest {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private DemoDao demoDao;

    // 查询全部
    @Test
    public void testFindAll(){
        List<Demo> list = demoDao.findAll();
        list.forEach(demo -> {
            logger.info("demo={}",demo);
        });
        /*for(Demo demo : list){
            logger.info("demo={}", demo);
        }*/
    }

    // 根据ID查询
    @Test
    public void testFindById(){
        //Demo demo = demoDao.getOne(1L); // org.hibernate.LazyInitializationException - No Session
        Demo demo = demoDao.findById(1L).get();
        logger.info("demo={}", demo);
    }

    //动态查询，根据某个字段查询
    @Test
    public void testFindByExample(){
        Demo demo = new Demo();
        Example<Demo> example = Example.of(demo);
        demo.setName("xy");
        List<Demo> list = demoDao.findAll(example);
        list.forEach(d -> {
            logger.info("demo={}",d);
        });
    }

    // 插入
    @Test
    public void testSave(){
        Demo demo = new Demo();
        demo.setName("zy");
        demo.setCreateTime(new Date());
        demoDao.save(demo);
        List<Demo> list = demoDao.findAll();
        list.forEach(d -> {
            logger.info("demo={}", d);
        });
    }

    // 更新
    @Test
    public void testUpdate(){
        Demo demo = new Demo();
        demo.setId(2L);
        demo.setName("Evolving");
        demo.setCreateTime(new Date());
        demoDao.save(demo);
        logger.info("demo = {}", demoDao.findById(demo.getId()).get());
    }

    // 删除
    @Test
    public void testDelete(){
        demoDao.deleteById(3L);
        /*Demo demo = new Demo();
        demo.setId(1L);
        demoDao.delete(demo);*/
    }

    // 分页查询
    @Test
    public void testFindByPage(){
        int pageNumber = 1; // 当前页是第二页，从0开始
        int pageSize = 1; // 每页显示的记录数
        /*// 排序的分页
        Sort sort = new Sort(Sort.Direction.ASC, "id");
        Pageable pageable = new PageRequest(pageNumber, pageSize, sort);*/
        Pageable pageable = new PageRequest(pageNumber, pageSize);
        Page<Demo> page = demoDao.findAll(pageable);
        logger.info("总记录数 = {}",page.getTotalElements());
        logger.info("总页数 = {}",page.getTotalPages());
        logger.info("当前记录 = {}", page.getContent());
    }
}

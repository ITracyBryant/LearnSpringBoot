package io.itracybryant.learnspringboot.jpa.dao;

import io.itracybryant.learnspringboot.jpa.entity.Demo;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @ClassName DemoDao
 * @Description TODO
 * @Author Administrator
 * @Date 2019/3/4 19:58
 * @Version 1.0
 */
public interface DemoDao extends JpaRepository<Demo, Long> {
}

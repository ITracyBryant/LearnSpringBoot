package io.itracybryant.learnspringboot.jpa.dao;

import io.itracybryant.learnspringboot.jpa.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

/**
 * @InterfaceName UserDao
 * @Description TODO
 * @Author Administrator
 * @Date 2019/3/4 20:28
 * @Version 1.0
 */
public interface UserDao extends JpaRepository<User, Long> {
    @Query("select u from User u where u.username = ?1")
    User findByUsername(String username);

    @Query("select u from User u where u.password = ?1")
    @Transactional(timeout = 10)
    User findByPassword(String password);

    @Query("delete from User where password = ?1")
    @Modifying
    @Transactional(rollbackFor = Exception.class)
    void deleteByPassword(String password);
}

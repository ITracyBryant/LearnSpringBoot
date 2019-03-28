package io.itracybryant.learnspringboot;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

/**
 * @author Administrator
 */
@SpringBootApplication
@EnableJpaAuditing
@MapperScan({"io.itracybryant.learnspringboot.mybatis.mapper", "io.itracybryant.learnspringboot.shiro.mapper"})
public class LearnSpringBootApplication {

    public static void main(String[] args) {
        SpringApplication.run(LearnSpringBootApplication.class, args);
    }

}

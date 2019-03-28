package io.itracybryant.learnspringboot.swagger.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * Swagger全局配置信息
 * Swagger生成API文档是通过扫描指定package下的请求映射类，然后根据映射接口生成API文档接口(关键就是包扫描要配置好)
 *
 * @ClassName SwaggerConfig
 * @Description TODO
 * @Author Administrator
 * @Date 2019/3/28 13:01
 * @Version 1.0
 */
@Configuration
@EnableSwagger2
public class SwaggerConfig {


    /**
     * .apis(RequestHandlerSelectors.basePackage()包扫描 一般用SpringMVC时，通常把请求映射类放在/controller/package下
     * .paths(PathSelectors.regex("/.*")) 扫描请求的路径 如regex("/article/.*")即在Swagger中显示所有以/article开头的接口地址，.*匹配所有子请求
     * @return
     */
    @Bean
    public Docket createRestApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .select()
                .apis(RequestHandlerSelectors.basePackage("io.itracybryant.learnspringboot.swagger.controller"))
                .paths(PathSelectors.regex("/.*"))
                .build();
    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("SpringBoot整合Swagger2构建Restful API")
                .description("文档地址：https://itracybryant.github.io")
                .termsOfServiceUrl("https://blog.csdn.net/oschina_41638142")
                .contact(new Contact("itracybryant", "https://blog.csdn.net/oschina_41638142", ""))
                .version("v1.0")
                .build();
    }
}

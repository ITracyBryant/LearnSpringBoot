package io.itracybryant.learnspringboot.swagger.controller;

import io.itracybryant.learnspringboot.swagger.dto.ResponseCode;
import io.itracybryant.learnspringboot.swagger.entity.Article;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

/**
 * Swagger遵循Restful接口规范
 * 前后端分离，后端一般只负责接收传递Json数据
 * @RestController 所有方法的返回值都会被Spring转换成JSON格式
 * @ClassName ArticleController
 * @Description TODO
 * @Author Administrator
 * @Date 2019/3/28 14:24
 * @Version 1.0
 */
@RestController
@RequestMapping("/article")
@Api(value = "ArticleController", tags = {"文档管理接口"})
public class ArticleController {
    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @GetMapping(value = "/{id}", produces = "application/json")
    @ApiOperation(value = "查询文档详情", notes = "文档ID大于0")
    @ApiImplicitParam(name = "id", value = "文档编号", required = true, dataType = "Long")
    public ResponseCode findById(@PathVariable Long id) {
        logger.info("查询文档信息，查询的文档ID是 --> {}", id);
        Article article = new Article(1L, "Swagger", "SpringBoot整合Swagger2", new Date());
        return ResponseCode.ok("查询成功", article);
    }

    @DeleteMapping(value = "/{id}", produces = "application/json")
    @ApiOperation(value = "删除文档")
    @ApiImplicitParam(name = "id", value = "文档编号", required = true, dataType = "Long")
    public ResponseCode delete(@PathVariable Long id) {
        logger.info("删除文档信息，删除的文档ID是 --> {}", id);
        return ResponseCode.ok("删除成功");
    }

    @PostMapping(value = "/", produces = "application/json")
    @ApiOperation(value = "保存文档")
    @ApiImplicitParam(name = "article", value = "文档信息实体", required = true, dataType = "Article", paramType = "body")
    public ResponseCode save(@RequestBody Article article) {
        logger.info("保存文档信息，保存的文档内容 --> {}", article);
        return ResponseCode.ok("保存成功");
    }

    @PutMapping(value = "/", produces = "application/json")
    @ApiOperation(value = "更新文档")
    @ApiImplicitParam(name = "article", value = "文档信息实体", required = true, dataType = "Article", paramType = "body")
    public ResponseCode update(@RequestBody Article article) {
        logger.info("更新文档信息，更新内容 --> {}", article);
        return ResponseCode.ok("更新成功");
    }

}

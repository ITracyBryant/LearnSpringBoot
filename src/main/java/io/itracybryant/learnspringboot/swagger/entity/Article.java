package io.itracybryant.learnspringboot.swagger.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.Date;

/**
 * @ClassName Article
 * @Description TODO
 * @Author Administrator
 * @Date 2019/3/28 14:02
 * @Version 1.0
 */
@ApiModel(value = "Article", description = "文档实体对象")
public class Article implements Serializable {

    /**
     * @ApiModelProperty 用于描述实体字段
     *  value: 字段说明
     *  name: 重写字段名称
     *  dataType: 重写字段类型
     *  required: 字段是否必填
     *  example: 举例说明
     *  hidden: 是否隐藏显示
     */

    /**
     * 文档id
     */
    @ApiModelProperty(value = "id", example = "1", required = true)
    private Long id;

    /**
     * 文档名称
     */
    @ApiModelProperty(name = "name", value = "文档名称", example = "Swagger", required = true)
    private String name;

    /**
     * 文档标题
     */
    @ApiModelProperty(name = "title", value = "文档标题", example = "SpringBoot中使用Swagger", required = true)
    private String title;

    /**
     * 创建时间
     */
    @ApiModelProperty(name = "createTime", value = "创建时间", required = false)
    private Date createTime;

    public Article() {
    }

    public Article(Long id, String name, String title, Date createTime) {
        this.id = id;
        this.name = name;
        this.title = title;
        this.createTime = createTime;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    @Override
    public String toString() {
        return "Article{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", title='" + title + '\'' +
                ", createTime=" + createTime +
                '}';
    }
}

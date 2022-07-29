package com.ruoyi.blog.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 博客管理对象 t_blog
 * 
 * @author liphui
 * @date 2022-07-29
 */
public class TBlog extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 主键 */
    private String id;

    /** 标题 */
    @Excel(name = "标题")
    private String title;

    /** 内容 */
    @Excel(name = "内容")
    private String content;

    /** 默认图片 */
    @Excel(name = "默认图片")
    private String defaultPicture;

    /** 博客来源 */
    @Excel(name = "博客来源")
    private String source;

    /** 浏览次数 */
    @Excel(name = "浏览次数")
    private Long views;

    /** 博客描述 */
    @Excel(name = "博客描述")
    private String description;

    /** 是否推荐：0不推荐，1推荐 */
    @Excel(name = "是否推荐：0不推荐，1推荐")
    private Integer recommend;

    /** 版权开关 */
    @Excel(name = "版权开关")
    private Integer copyright;

    /** 赞赏开关 */
    @Excel(name = "赞赏开关")
    private Integer appreciation;

    /** 评论开关 */
    @Excel(name = "评论开关")
    private Integer comment;

    /** 是否发布 */
    @Excel(name = "是否发布")
    private Integer published;

    /** 外键：类型ID */
    @Excel(name = "外键：类型ID")
    private String typeId;

    /** 外键：用户ID */
    @Excel(name = "外键：用户ID")
    private String userId;

    /** 删除标志（0代表存在 2代表删除） */
    private String delFlag;

    /** 备用1 */
    @Excel(name = "备用1")
    private String standby1;

    /** 备用2 */
    @Excel(name = "备用2")
    private String standby2;

    /** 备用3 */
    @Excel(name = "备用3")
    private String standby3;

    /** 备用4 */
    @Excel(name = "备用4")
    private String standby4;

    /** 备用5 */
    @Excel(name = "备用5")
    private String standby5;

    public void setId(String id) 
    {
        this.id = id;
    }

    public String getId() 
    {
        return id;
    }
    public void setTitle(String title) 
    {
        this.title = title;
    }

    public String getTitle() 
    {
        return title;
    }
    public void setContent(String content) 
    {
        this.content = content;
    }

    public String getContent() 
    {
        return content;
    }
    public void setDefaultPicture(String defaultPicture) 
    {
        this.defaultPicture = defaultPicture;
    }

    public String getDefaultPicture() 
    {
        return defaultPicture;
    }
    public void setSource(String source) 
    {
        this.source = source;
    }

    public String getSource() 
    {
        return source;
    }
    public void setViews(Long views) 
    {
        this.views = views;
    }

    public Long getViews() 
    {
        return views;
    }
    public void setDescription(String description) 
    {
        this.description = description;
    }

    public String getDescription() 
    {
        return description;
    }
    public void setRecommend(Integer recommend) 
    {
        this.recommend = recommend;
    }

    public Integer getRecommend() 
    {
        return recommend;
    }
    public void setCopyright(Integer copyright) 
    {
        this.copyright = copyright;
    }

    public Integer getCopyright() 
    {
        return copyright;
    }
    public void setAppreciation(Integer appreciation) 
    {
        this.appreciation = appreciation;
    }

    public Integer getAppreciation() 
    {
        return appreciation;
    }
    public void setComment(Integer comment) 
    {
        this.comment = comment;
    }

    public Integer getComment() 
    {
        return comment;
    }
    public void setPublished(Integer published) 
    {
        this.published = published;
    }

    public Integer getPublished() 
    {
        return published;
    }
    public void setTypeId(String typeId) 
    {
        this.typeId = typeId;
    }

    public String getTypeId() 
    {
        return typeId;
    }
    public void setUserId(String userId) 
    {
        this.userId = userId;
    }

    public String getUserId() 
    {
        return userId;
    }
    public void setDelFlag(String delFlag) 
    {
        this.delFlag = delFlag;
    }

    public String getDelFlag() 
    {
        return delFlag;
    }
    public void setStandby1(String standby1) 
    {
        this.standby1 = standby1;
    }

    public String getStandby1() 
    {
        return standby1;
    }
    public void setStandby2(String standby2) 
    {
        this.standby2 = standby2;
    }

    public String getStandby2() 
    {
        return standby2;
    }
    public void setStandby3(String standby3) 
    {
        this.standby3 = standby3;
    }

    public String getStandby3() 
    {
        return standby3;
    }
    public void setStandby4(String standby4) 
    {
        this.standby4 = standby4;
    }

    public String getStandby4() 
    {
        return standby4;
    }
    public void setStandby5(String standby5) 
    {
        this.standby5 = standby5;
    }

    public String getStandby5() 
    {
        return standby5;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("title", getTitle())
            .append("content", getContent())
            .append("defaultPicture", getDefaultPicture())
            .append("source", getSource())
            .append("views", getViews())
            .append("description", getDescription())
            .append("recommend", getRecommend())
            .append("copyright", getCopyright())
            .append("appreciation", getAppreciation())
            .append("comment", getComment())
            .append("published", getPublished())
            .append("createTime", getCreateTime())
            .append("updateTime", getUpdateTime())
            .append("typeId", getTypeId())
            .append("userId", getUserId())
            .append("delFlag", getDelFlag())
            .append("remark", getRemark())
            .append("standby1", getStandby1())
            .append("standby2", getStandby2())
            .append("standby3", getStandby3())
            .append("standby4", getStandby4())
            .append("standby5", getStandby5())
            .toString();
    }
}

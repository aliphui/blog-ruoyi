package com.ruoyi.blog.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.TreeEntity;

/**
 * 评论内容对象 t_comment
 * 
 * @author liphui
 * @date 2022-07-29
 */
public class TComment extends TreeEntity
{
    private static final long serialVersionUID = 1L;

    /** 主键（父） */
    private String id;

    /** 昵称 */
    @Excel(name = "昵称")
    private String nickname;

    /** 邮箱 */
    @Excel(name = "邮箱")
    private String email;

    /** 头像 */
    @Excel(name = "头像")
    private String heatPhoto;

    /** 评论内容 */
    @Excel(name = "评论内容")
    private String content;

    /** 外键：博客id */
    @Excel(name = "外键：博客id")
    private String blogId;

    /** 自连接（子id） */
    @Excel(name = "自连接", readConverterExp = "子=id")
    private String commentId;

    public void setId(String id) 
    {
        this.id = id;
    }

    public String getId() 
    {
        return id;
    }
    public void setNickname(String nickname) 
    {
        this.nickname = nickname;
    }

    public String getNickname() 
    {
        return nickname;
    }
    public void setEmail(String email) 
    {
        this.email = email;
    }

    public String getEmail() 
    {
        return email;
    }
    public void setHeatPhoto(String heatPhoto) 
    {
        this.heatPhoto = heatPhoto;
    }

    public String getHeatPhoto() 
    {
        return heatPhoto;
    }
    public void setContent(String content) 
    {
        this.content = content;
    }

    public String getContent() 
    {
        return content;
    }
    public void setBlogId(String blogId) 
    {
        this.blogId = blogId;
    }

    public String getBlogId() 
    {
        return blogId;
    }
    public void setCommentId(String commentId) 
    {
        this.commentId = commentId;
    }

    public String getCommentId() 
    {
        return commentId;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("nickname", getNickname())
            .append("email", getEmail())
            .append("heatPhoto", getHeatPhoto())
            .append("content", getContent())
            .append("createTime", getCreateTime())
            .append("blogId", getBlogId())
            .append("commentId", getCommentId())
            .toString();
    }
}

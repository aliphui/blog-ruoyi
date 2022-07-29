package com.ruoyi.blog.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 用户对象 t_user
 * 
 * @author liphui
 * @date 2022-07-29
 */
public class TUser extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 主键 */
    private String id;

    /** 姓名 */
    @Excel(name = "姓名")
    private String name;

    /** 昵称 */
    @Excel(name = "昵称")
    private String nickname;

    /** 用户名 */
    @Excel(name = "用户名")
    private String username;

    /** 密码 */
    @Excel(name = "密码")
    private String passward;

    /** qq号 */
    @Excel(name = "qq号")
    private String qq;

    /** 微信号 */
    @Excel(name = "微信号")
    private String wechat;

    /** 邮箱 */
    @Excel(name = "邮箱")
    private String email;

    /** 类型：1：管理员，2：普通用户，3：游客 */
    @Excel(name = "类型：1：管理员，2：普通用户，3：游客")
    private Long type;

    /** 头像 */
    @Excel(name = "头像")
    private String heatPhoto;

    /** 用户状态（1：正常 2：停用） */
    @Excel(name = "用户状态", readConverterExp = "1=：正常,2=：停用")
    private String state;

    public void setId(String id) 
    {
        this.id = id;
    }

    public String getId() 
    {
        return id;
    }
    public void setName(String name) 
    {
        this.name = name;
    }

    public String getName() 
    {
        return name;
    }
    public void setNickname(String nickname) 
    {
        this.nickname = nickname;
    }

    public String getNickname() 
    {
        return nickname;
    }
    public void setUsername(String username) 
    {
        this.username = username;
    }

    public String getUsername() 
    {
        return username;
    }
    public void setPassward(String passward) 
    {
        this.passward = passward;
    }

    public String getPassward() 
    {
        return passward;
    }
    public void setQq(String qq) 
    {
        this.qq = qq;
    }

    public String getQq() 
    {
        return qq;
    }
    public void setWechat(String wechat) 
    {
        this.wechat = wechat;
    }

    public String getWechat() 
    {
        return wechat;
    }
    public void setEmail(String email) 
    {
        this.email = email;
    }

    public String getEmail() 
    {
        return email;
    }
    public void setType(Long type) 
    {
        this.type = type;
    }

    public Long getType() 
    {
        return type;
    }
    public void setHeatPhoto(String heatPhoto) 
    {
        this.heatPhoto = heatPhoto;
    }

    public String getHeatPhoto() 
    {
        return heatPhoto;
    }
    public void setState(String state) 
    {
        this.state = state;
    }

    public String getState() 
    {
        return state;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("name", getName())
            .append("nickname", getNickname())
            .append("username", getUsername())
            .append("passward", getPassward())
            .append("qq", getQq())
            .append("wechat", getWechat())
            .append("email", getEmail())
            .append("type", getType())
            .append("heatPhoto", getHeatPhoto())
            .append("createTime", getCreateTime())
            .append("updateTime", getUpdateTime())
            .append("state", getState())
            .toString();
    }
}

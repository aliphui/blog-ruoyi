package com.ruoyi.blog.service;

import java.util.List;
import com.ruoyi.blog.domain.TBlog;

/**
 * 博客管理Service接口
 * 
 * @author liphui
 * @date 2022-07-29
 */
public interface ITBlogService 
{
    /**
     * 查询博客管理
     * 
     * @param id 博客管理主键
     * @return 博客管理
     */
    public TBlog selectTBlogById(String id);

    /**
     * 查询博客管理列表
     * 
     * @param tBlog 博客管理
     * @return 博客管理集合
     */
    public List<TBlog> selectTBlogList(TBlog tBlog);

    /**
     * 新增博客管理
     * 
     * @param tBlog 博客管理
     * @return 结果
     */
    public int insertTBlog(TBlog tBlog);

    /**
     * 修改博客管理
     * 
     * @param tBlog 博客管理
     * @return 结果
     */
    public int updateTBlog(TBlog tBlog);

    /**
     * 批量删除博客管理
     * 
     * @param ids 需要删除的博客管理主键集合
     * @return 结果
     */
    public int deleteTBlogByIds(String[] ids);

    /**
     * 删除博客管理信息
     * 
     * @param id 博客管理主键
     * @return 结果
     */
    public int deleteTBlogById(String id);
}

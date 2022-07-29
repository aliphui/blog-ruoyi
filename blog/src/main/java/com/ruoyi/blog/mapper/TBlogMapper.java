package com.ruoyi.blog.mapper;

import java.util.List;
import com.ruoyi.blog.domain.TBlog;

/**
 * 博客管理Mapper接口
 * 
 * @author liphui
 * @date 2022-07-29
 */
public interface TBlogMapper 
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
     * 删除博客管理
     * 
     * @param id 博客管理主键
     * @return 结果
     */
    public int deleteTBlogById(String id);

    /**
     * 批量删除博客管理
     * 
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteTBlogByIds(String[] ids);
}

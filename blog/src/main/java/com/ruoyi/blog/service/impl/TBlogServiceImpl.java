package com.ruoyi.blog.service.impl;

import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.blog.mapper.TBlogMapper;
import com.ruoyi.blog.domain.TBlog;
import com.ruoyi.blog.service.ITBlogService;

/**
 * 博客管理Service业务层处理
 * 
 * @author liphui
 * @date 2022-07-29
 */
@Service
public class TBlogServiceImpl implements ITBlogService 
{
    @Autowired
    private TBlogMapper tBlogMapper;

    /**
     * 查询博客管理
     * 
     * @param id 博客管理主键
     * @return 博客管理
     */
    @Override
    public TBlog selectTBlogById(String id)
    {
        return tBlogMapper.selectTBlogById(id);
    }

    /**
     * 查询博客管理列表
     * 
     * @param tBlog 博客管理
     * @return 博客管理
     */
    @Override
    public List<TBlog> selectTBlogList(TBlog tBlog)
    {
        return tBlogMapper.selectTBlogList(tBlog);
    }

    /**
     * 新增博客管理
     * 
     * @param tBlog 博客管理
     * @return 结果
     */
    @Override
    public int insertTBlog(TBlog tBlog)
    {
        tBlog.setCreateTime(DateUtils.getNowDate());
        return tBlogMapper.insertTBlog(tBlog);
    }

    /**
     * 修改博客管理
     * 
     * @param tBlog 博客管理
     * @return 结果
     */
    @Override
    public int updateTBlog(TBlog tBlog)
    {
        tBlog.setUpdateTime(DateUtils.getNowDate());
        return tBlogMapper.updateTBlog(tBlog);
    }

    /**
     * 批量删除博客管理
     * 
     * @param ids 需要删除的博客管理主键
     * @return 结果
     */
    @Override
    public int deleteTBlogByIds(String[] ids)
    {
        return tBlogMapper.deleteTBlogByIds(ids);
    }

    /**
     * 删除博客管理信息
     * 
     * @param id 博客管理主键
     * @return 结果
     */
    @Override
    public int deleteTBlogById(String id)
    {
        return tBlogMapper.deleteTBlogById(id);
    }
}

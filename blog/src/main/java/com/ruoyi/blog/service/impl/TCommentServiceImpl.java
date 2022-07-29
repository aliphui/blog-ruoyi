package com.ruoyi.blog.service.impl;

import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.blog.mapper.TCommentMapper;
import com.ruoyi.blog.domain.TComment;
import com.ruoyi.blog.service.ITCommentService;

/**
 * 评论内容Service业务层处理
 * 
 * @author liphui
 * @date 2022-07-29
 */
@Service
public class TCommentServiceImpl implements ITCommentService 
{
    @Autowired
    private TCommentMapper tCommentMapper;

    /**
     * 查询评论内容
     * 
     * @param id 评论内容主键
     * @return 评论内容
     */
    @Override
    public TComment selectTCommentById(String id)
    {
        return tCommentMapper.selectTCommentById(id);
    }

    /**
     * 查询评论内容列表
     * 
     * @param tComment 评论内容
     * @return 评论内容
     */
    @Override
    public List<TComment> selectTCommentList(TComment tComment)
    {
        return tCommentMapper.selectTCommentList(tComment);
    }

    /**
     * 新增评论内容
     * 
     * @param tComment 评论内容
     * @return 结果
     */
    @Override
    public int insertTComment(TComment tComment)
    {
        tComment.setCreateTime(DateUtils.getNowDate());
        return tCommentMapper.insertTComment(tComment);
    }

    /**
     * 修改评论内容
     * 
     * @param tComment 评论内容
     * @return 结果
     */
    @Override
    public int updateTComment(TComment tComment)
    {
        return tCommentMapper.updateTComment(tComment);
    }

    /**
     * 批量删除评论内容
     * 
     * @param ids 需要删除的评论内容主键
     * @return 结果
     */
    @Override
    public int deleteTCommentByIds(String[] ids)
    {
        return tCommentMapper.deleteTCommentByIds(ids);
    }

    /**
     * 删除评论内容信息
     * 
     * @param id 评论内容主键
     * @return 结果
     */
    @Override
    public int deleteTCommentById(String id)
    {
        return tCommentMapper.deleteTCommentById(id);
    }
}

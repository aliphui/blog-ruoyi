package com.ruoyi.blog.service;

import java.util.List;
import com.ruoyi.blog.domain.TComment;

/**
 * 评论内容Service接口
 * 
 * @author liphui
 * @date 2022-07-29
 */
public interface ITCommentService 
{
    /**
     * 查询评论内容
     * 
     * @param id 评论内容主键
     * @return 评论内容
     */
    public TComment selectTCommentById(String id);

    /**
     * 查询评论内容列表
     * 
     * @param tComment 评论内容
     * @return 评论内容集合
     */
    public List<TComment> selectTCommentList(TComment tComment);

    /**
     * 新增评论内容
     * 
     * @param tComment 评论内容
     * @return 结果
     */
    public int insertTComment(TComment tComment);

    /**
     * 修改评论内容
     * 
     * @param tComment 评论内容
     * @return 结果
     */
    public int updateTComment(TComment tComment);

    /**
     * 批量删除评论内容
     * 
     * @param ids 需要删除的评论内容主键集合
     * @return 结果
     */
    public int deleteTCommentByIds(String[] ids);

    /**
     * 删除评论内容信息
     * 
     * @param id 评论内容主键
     * @return 结果
     */
    public int deleteTCommentById(String id);
}

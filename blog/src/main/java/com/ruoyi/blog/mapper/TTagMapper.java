package com.ruoyi.blog.mapper;

import java.util.List;
import com.ruoyi.blog.domain.TTag;

/**
 * 标签管理Mapper接口
 * 
 * @author liphui
 * @date 2022-07-29
 */
public interface TTagMapper 
{
    /**
     * 查询标签管理
     * 
     * @param id 标签管理主键
     * @return 标签管理
     */
    public TTag selectTTagById(String id);

    /**
     * 查询标签管理列表
     * 
     * @param tTag 标签管理
     * @return 标签管理集合
     */
    public List<TTag> selectTTagList(TTag tTag);

    /**
     * 新增标签管理
     * 
     * @param tTag 标签管理
     * @return 结果
     */
    public int insertTTag(TTag tTag);

    /**
     * 修改标签管理
     * 
     * @param tTag 标签管理
     * @return 结果
     */
    public int updateTTag(TTag tTag);

    /**
     * 删除标签管理
     * 
     * @param id 标签管理主键
     * @return 结果
     */
    public int deleteTTagById(String id);

    /**
     * 批量删除标签管理
     * 
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteTTagByIds(String[] ids);
}

package com.ruoyi.blog.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.blog.mapper.TTagMapper;
import com.ruoyi.blog.domain.TTag;
import com.ruoyi.blog.service.ITTagService;

/**
 * 标签管理Service业务层处理
 * 
 * @author liphui
 * @date 2022-07-29
 */
@Service
public class TTagServiceImpl implements ITTagService 
{
    @Autowired
    private TTagMapper tTagMapper;

    /**
     * 查询标签管理
     * 
     * @param id 标签管理主键
     * @return 标签管理
     */
    @Override
    public TTag selectTTagById(String id)
    {
        return tTagMapper.selectTTagById(id);
    }

    /**
     * 查询标签管理列表
     * 
     * @param tTag 标签管理
     * @return 标签管理
     */
    @Override
    public List<TTag> selectTTagList(TTag tTag)
    {
        return tTagMapper.selectTTagList(tTag);
    }

    /**
     * 新增标签管理
     * 
     * @param tTag 标签管理
     * @return 结果
     */
    @Override
    public int insertTTag(TTag tTag)
    {
        return tTagMapper.insertTTag(tTag);
    }

    /**
     * 修改标签管理
     * 
     * @param tTag 标签管理
     * @return 结果
     */
    @Override
    public int updateTTag(TTag tTag)
    {
        return tTagMapper.updateTTag(tTag);
    }

    /**
     * 批量删除标签管理
     * 
     * @param ids 需要删除的标签管理主键
     * @return 结果
     */
    @Override
    public int deleteTTagByIds(String[] ids)
    {
        return tTagMapper.deleteTTagByIds(ids);
    }

    /**
     * 删除标签管理信息
     * 
     * @param id 标签管理主键
     * @return 结果
     */
    @Override
    public int deleteTTagById(String id)
    {
        return tTagMapper.deleteTTagById(id);
    }
}

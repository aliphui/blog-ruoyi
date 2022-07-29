package com.ruoyi.blog.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.blog.mapper.TTypeMapper;
import com.ruoyi.blog.domain.TType;
import com.ruoyi.blog.service.ITTypeService;

/**
 * 类型管理Service业务层处理
 * 
 * @author liphui
 * @date 2022-07-29
 */
@Service
public class TTypeServiceImpl implements ITTypeService 
{
    @Autowired
    private TTypeMapper tTypeMapper;

    /**
     * 查询类型管理
     * 
     * @param id 类型管理主键
     * @return 类型管理
     */
    @Override
    public TType selectTTypeById(String id)
    {
        return tTypeMapper.selectTTypeById(id);
    }

    /**
     * 查询类型管理列表
     * 
     * @param tType 类型管理
     * @return 类型管理
     */
    @Override
    public List<TType> selectTTypeList(TType tType)
    {
        return tTypeMapper.selectTTypeList(tType);
    }

    /**
     * 新增类型管理
     * 
     * @param tType 类型管理
     * @return 结果
     */
    @Override
    public int insertTType(TType tType)
    {
        return tTypeMapper.insertTType(tType);
    }

    /**
     * 修改类型管理
     * 
     * @param tType 类型管理
     * @return 结果
     */
    @Override
    public int updateTType(TType tType)
    {
        return tTypeMapper.updateTType(tType);
    }

    /**
     * 批量删除类型管理
     * 
     * @param ids 需要删除的类型管理主键
     * @return 结果
     */
    @Override
    public int deleteTTypeByIds(String[] ids)
    {
        return tTypeMapper.deleteTTypeByIds(ids);
    }

    /**
     * 删除类型管理信息
     * 
     * @param id 类型管理主键
     * @return 结果
     */
    @Override
    public int deleteTTypeById(String id)
    {
        return tTypeMapper.deleteTTypeById(id);
    }
}

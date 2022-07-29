package com.ruoyi.blog.service;

import java.util.List;
import com.ruoyi.blog.domain.TType;

/**
 * 类型管理Service接口
 * 
 * @author liphui
 * @date 2022-07-29
 */
public interface ITTypeService 
{
    /**
     * 查询类型管理
     * 
     * @param id 类型管理主键
     * @return 类型管理
     */
    public TType selectTTypeById(String id);

    /**
     * 查询类型管理列表
     * 
     * @param tType 类型管理
     * @return 类型管理集合
     */
    public List<TType> selectTTypeList(TType tType);

    /**
     * 新增类型管理
     * 
     * @param tType 类型管理
     * @return 结果
     */
    public int insertTType(TType tType);

    /**
     * 修改类型管理
     * 
     * @param tType 类型管理
     * @return 结果
     */
    public int updateTType(TType tType);

    /**
     * 批量删除类型管理
     * 
     * @param ids 需要删除的类型管理主键集合
     * @return 结果
     */
    public int deleteTTypeByIds(String[] ids);

    /**
     * 删除类型管理信息
     * 
     * @param id 类型管理主键
     * @return 结果
     */
    public int deleteTTypeById(String id);
}

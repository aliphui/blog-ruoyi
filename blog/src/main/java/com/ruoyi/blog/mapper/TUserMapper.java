package com.ruoyi.blog.mapper;

import java.util.List;
import com.ruoyi.blog.domain.TUser;

/**
 * 用户Mapper接口
 * 
 * @author liphui
 * @date 2022-07-29
 */
public interface TUserMapper 
{
    /**
     * 查询用户
     * 
     * @param id 用户主键
     * @return 用户
     */
    public TUser selectTUserById(String id);

    /**
     * 查询用户列表
     * 
     * @param tUser 用户
     * @return 用户集合
     */
    public List<TUser> selectTUserList(TUser tUser);

    /**
     * 新增用户
     * 
     * @param tUser 用户
     * @return 结果
     */
    public int insertTUser(TUser tUser);

    /**
     * 修改用户
     * 
     * @param tUser 用户
     * @return 结果
     */
    public int updateTUser(TUser tUser);

    /**
     * 删除用户
     * 
     * @param id 用户主键
     * @return 结果
     */
    public int deleteTUserById(String id);

    /**
     * 批量删除用户
     * 
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteTUserByIds(String[] ids);
}

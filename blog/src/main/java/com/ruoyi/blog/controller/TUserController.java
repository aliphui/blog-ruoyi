package com.ruoyi.blog.controller;

import java.util.List;
import javax.servlet.http.HttpServletResponse;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.blog.domain.TUser;
import com.ruoyi.blog.service.ITUserService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 用户Controller
 *
 * @author liphui
 * @date 2022-07-29
 */
@RestController
@RequestMapping("/blog/user")
public class TUserController extends BaseController
{
    @Autowired
    private ITUserService tUserService;

    /**
     * 查询用户列表
     */
//    @PreAuthorize("@ss.hasPermi('blog:user:list')")
    @GetMapping("/list")
    public TableDataInfo list(TUser tUser)
    {
        startPage();
        List<TUser> list = tUserService.selectTUserList(tUser);
        return getDataTable(list);
    }

    /**
     * 导出用户列表
     */
//    @PreAuthorize("@ss.hasPermi('blog:user:export')")
    @Log(title = "用户", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, TUser tUser)
    {
        List<TUser> list = tUserService.selectTUserList(tUser);
        ExcelUtil<TUser> util = new ExcelUtil<TUser>(TUser.class);
        util.exportExcel(response, list, "用户数据");
    }

    /**
     * 获取用户详细信息
     */
//    @PreAuthorize("@ss.hasPermi('blog:user:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") String id)
    {
        return AjaxResult.success(tUserService.selectTUserById(id));
    }

    /**
     * 新增用户
     */
//    @PreAuthorize("@ss.hasPermi('blog:user:add')")
    @Log(title = "用户", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody TUser tUser)
    {
        return toAjax(tUserService.insertTUser(tUser));
    }

    /**
     * 修改用户
     */
//    @PreAuthorize("@ss.hasPermi('blog:user:edit')")
    @Log(title = "用户", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody TUser tUser)
    {
        return toAjax(tUserService.updateTUser(tUser));
    }

    /**
     * 删除用户
     */
//    @PreAuthorize("@ss.hasPermi('blog:user:remove')")
    @Log(title = "用户", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable String[] ids)
    {
        return toAjax(tUserService.deleteTUserByIds(ids));
    }
}

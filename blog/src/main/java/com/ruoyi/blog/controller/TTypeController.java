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
import com.ruoyi.blog.domain.TType;
import com.ruoyi.blog.service.ITTypeService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 类型管理Controller
 *
 * @author liphui
 * @date 2022-07-29
 */
@RestController
@RequestMapping("/blog/type")
public class TTypeController extends BaseController
{
    @Autowired
    private ITTypeService tTypeService;

    /**
     * 查询类型管理列表
     */
//    @PreAuthorize("@ss.hasPermi('blog:type:list')")
    @GetMapping("/list")
    public TableDataInfo list(TType tType)
    {
        startPage();
        List<TType> list = tTypeService.selectTTypeList(tType);
        return getDataTable(list);
    }

    /**
     * 导出类型管理列表
     */
//    @PreAuthorize("@ss.hasPermi('blog:type:export')")
    @Log(title = "类型管理", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, TType tType)
    {
        List<TType> list = tTypeService.selectTTypeList(tType);
        ExcelUtil<TType> util = new ExcelUtil<TType>(TType.class);
        util.exportExcel(response, list, "类型管理数据");
    }

    /**
     * 获取类型管理详细信息
     */
//    @PreAuthorize("@ss.hasPermi('blog:type:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") String id)
    {
        return AjaxResult.success(tTypeService.selectTTypeById(id));
    }

    /**
     * 新增类型管理
     */
//    @PreAuthorize("@ss.hasPermi('blog:type:add')")
    @Log(title = "类型管理", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody TType tType)
    {
        return toAjax(tTypeService.insertTType(tType));
    }

    /**
     * 修改类型管理
     */
//    @PreAuthorize("@ss.hasPermi('blog:type:edit')")
    @Log(title = "类型管理", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody TType tType)
    {
        return toAjax(tTypeService.updateTType(tType));
    }

    /**
     * 删除类型管理
     */
//    @PreAuthorize("@ss.hasPermi('blog:type:remove')")
    @Log(title = "类型管理", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable String[] ids)
    {
        return toAjax(tTypeService.deleteTTypeByIds(ids));
    }
}

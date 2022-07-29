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
import com.ruoyi.blog.domain.TTag;
import com.ruoyi.blog.service.ITTagService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 标签管理Controller
 *
 * @author liphui
 * @date 2022-07-29
 */
@RestController
@RequestMapping("/blog/tag")
public class TTagController extends BaseController
{
    @Autowired
    private ITTagService tTagService;

    /**
     * 查询标签管理列表
     */
//    @PreAuthorize("@ss.hasPermi('blog:tag:list')")
    @GetMapping("/list")
    public TableDataInfo list(TTag tTag)
    {
        startPage();
        List<TTag> list = tTagService.selectTTagList(tTag);
        return getDataTable(list);
    }

    /**
     * 导出标签管理列表
     */
//    @PreAuthorize("@ss.hasPermi('blog:tag:export')")
    @Log(title = "标签管理", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, TTag tTag)
    {
        List<TTag> list = tTagService.selectTTagList(tTag);
        ExcelUtil<TTag> util = new ExcelUtil<TTag>(TTag.class);
        util.exportExcel(response, list, "标签管理数据");
    }

    /**
     * 获取标签管理详细信息
     */
//    @PreAuthorize("@ss.hasPermi('blog:tag:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") String id)
    {
        return AjaxResult.success(tTagService.selectTTagById(id));
    }

    /**
     * 新增标签管理
     */
//    @PreAuthorize("@ss.hasPermi('blog:tag:add')")
    @Log(title = "标签管理", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody TTag tTag)
    {
        return toAjax(tTagService.insertTTag(tTag));
    }

    /**
     * 修改标签管理
     */
//    @PreAuthorize("@ss.hasPermi('blog:tag:edit')")
    @Log(title = "标签管理", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody TTag tTag)
    {
        return toAjax(tTagService.updateTTag(tTag));
    }

    /**
     * 删除标签管理
     */
//    @PreAuthorize("@ss.hasPermi('blog:tag:remove')")
    @Log(title = "标签管理", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable String[] ids)
    {
        return toAjax(tTagService.deleteTTagByIds(ids));
    }
}

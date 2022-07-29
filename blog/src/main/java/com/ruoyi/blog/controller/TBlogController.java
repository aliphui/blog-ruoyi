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
import com.ruoyi.blog.domain.TBlog;
import com.ruoyi.blog.service.ITBlogService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 博客管理Controller
 *
 * @author liphui
 * @date 2022-07-29
 */
@RestController
@RequestMapping("/blog/blog")
public class TBlogController extends BaseController
{
    @Autowired
    private ITBlogService tBlogService;

    /**
     * 查询博客管理列表
     */
//    @PreAuthorize("@ss.hasPermi('blog:blog:list')")
    @GetMapping("/list")
    public TableDataInfo list(TBlog tBlog)
    {
        startPage();
        List<TBlog> list = tBlogService.selectTBlogList(tBlog);
        return getDataTable(list);
    }

    /**
     * 导出博客管理列表
     */
//    @PreAuthorize("@ss.hasPermi('blog:blog:export')")
    @Log(title = "博客管理", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, TBlog tBlog)
    {
        List<TBlog> list = tBlogService.selectTBlogList(tBlog);
        ExcelUtil<TBlog> util = new ExcelUtil<TBlog>(TBlog.class);
        util.exportExcel(response, list, "博客管理数据");
    }

    /**
     * 获取博客管理详细信息
     */
//    @PreAuthorize("@ss.hasPermi('blog:blog:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") String id)
    {
        return AjaxResult.success(tBlogService.selectTBlogById(id));
    }

    /**
     * 新增博客管理
     */
//    @PreAuthorize("@ss.hasPermi('blog:blog:add')")
    @Log(title = "博客管理", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody TBlog tBlog)
    {
        return toAjax(tBlogService.insertTBlog(tBlog));
    }

    /**
     * 修改博客管理
     */
//    @PreAuthorize("@ss.hasPermi('blog:blog:edit')")
    @Log(title = "博客管理", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody TBlog tBlog)
    {
        return toAjax(tBlogService.updateTBlog(tBlog));
    }

    /**
     * 删除博客管理
     */
//    @PreAuthorize("@ss.hasPermi('blog:blog:remove')")
    @Log(title = "博客管理", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable String[] ids)
    {
        return toAjax(tBlogService.deleteTBlogByIds(ids));
    }
}

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
import com.ruoyi.blog.domain.TComment;
import com.ruoyi.blog.service.ITCommentService;
import com.ruoyi.common.utils.poi.ExcelUtil;

/**
 * 评论内容Controller
 *
 * @author liphui
 * @date 2022-07-29
 */
@RestController
@RequestMapping("/blog/comment")
public class TCommentController extends BaseController
{
    @Autowired
    private ITCommentService tCommentService;

    /**
     * 查询评论内容列表
     */
//    @PreAuthorize("@ss.hasPermi('blog:comment:list')")
    @GetMapping("/list")
    public AjaxResult list(TComment tComment)
    {
        List<TComment> list = tCommentService.selectTCommentList(tComment);
        return AjaxResult.success(list);
    }

    /**
     * 导出评论内容列表
     */
//    @PreAuthorize("@ss.hasPermi('blog:comment:export')")
    @Log(title = "评论内容", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, TComment tComment)
    {
        List<TComment> list = tCommentService.selectTCommentList(tComment);
        ExcelUtil<TComment> util = new ExcelUtil<TComment>(TComment.class);
        util.exportExcel(response, list, "评论内容数据");
    }

    /**
     * 获取评论内容详细信息
     */
//    @PreAuthorize("@ss.hasPermi('blog:comment:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") String id)
    {
        return AjaxResult.success(tCommentService.selectTCommentById(id));
    }

    /**
     * 新增评论内容
     */
//    @PreAuthorize("@ss.hasPermi('blog:comment:add')")
    @Log(title = "评论内容", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody TComment tComment)
    {
        return toAjax(tCommentService.insertTComment(tComment));
    }

    /**
     * 修改评论内容
     */
//    @PreAuthorize("@ss.hasPermi('blog:comment:edit')")
    @Log(title = "评论内容", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody TComment tComment)
    {
        return toAjax(tCommentService.updateTComment(tComment));
    }

    /**
     * 删除评论内容
     */
//    @PreAuthorize("@ss.hasPermi('blog:comment:remove')")
    @Log(title = "评论内容", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable String[] ids)
    {
        return toAjax(tCommentService.deleteTCommentByIds(ids));
    }
}

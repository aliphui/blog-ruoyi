<template>
  <div class="app-container">
    <el-form :model="queryParams" ref="queryForm" size="small" :inline="true" v-show="showSearch" label-width="68px">
      <el-form-item label="标题" prop="title">
        <el-input
          v-model="queryParams.title"
          placeholder="请输入标题"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="博客来源" prop="source">
        <el-select v-model="queryParams.source" placeholder="请选择博客来源" clearable>
          <el-option
            v-for="dict in dict.type.tb_blog_source"
            :key="dict.value"
            :label="dict.label"
            :value="dict.value"
          />
        </el-select>
      </el-form-item>
      <el-form-item label="浏览次数" prop="views">
        <el-input
          v-model="queryParams.views"
          placeholder="请输入浏览次数"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="是否推荐" prop="recommend">
        <el-select v-model="queryParams.recommend" placeholder="请选择是否推荐" clearable>
          <el-option
            v-for="dict in dict.type.t_blog_y_n"
            :key="dict.value"
            :label="dict.label"
            :value="dict.value"
          />
        </el-select>
      </el-form-item>
      <el-form-item label="版权开关" prop="copyright">
        <el-select v-model="queryParams.copyright" placeholder="请选择版权开关" clearable>
          <el-option
            v-for="dict in dict.type.tb_blog_o_c"
            :key="dict.value"
            :label="dict.label"
            :value="dict.value"
          />
        </el-select>
      </el-form-item>
      <el-form-item label="赞赏开关" prop="appreciation">
        <el-select v-model="queryParams.appreciation" placeholder="请选择赞赏开关" clearable>
          <el-option
            v-for="dict in dict.type.tb_blog_o_c"
            :key="dict.value"
            :label="dict.label"
            :value="dict.value"
          />
        </el-select>
      </el-form-item>
      <el-form-item label="评论开关" prop="comment">
        <el-select v-model="queryParams.comment" placeholder="请选择评论开关" clearable>
          <el-option
            v-for="dict in dict.type.tb_blog_o_c"
            :key="dict.value"
            :label="dict.label"
            :value="dict.value"
          />
        </el-select>
      </el-form-item>
      <el-form-item label="是否发布" prop="published">
        <el-select v-model="queryParams.published" placeholder="请选择是否发布" clearable>
          <el-option
            v-for="dict in dict.type.t_blog_y_n"
            :key="dict.value"
            :label="dict.label"
            :value="dict.value"
          />
        </el-select>
      </el-form-item>
      <el-form-item label="类型" prop="typeId">
        <el-select v-model="queryParams.typeId" placeholder="请选择类型" clearable>
          <el-option
            v-for="item in typeList"
            :key="item.id"
            :label="item.name"
            :value="item.id"
          />
        </el-select>
      </el-form-item>
<!--      <el-form-item label="外键：用户ID" prop="userId">-->
<!--        <el-input-->
<!--          v-model="queryParams.userId"-->
<!--          placeholder="请输入外键：用户ID"-->
<!--          clearable-->
<!--          @keyup.enter.native="handleQuery"-->
<!--        />-->
<!--      </el-form-item>-->
      <el-form-item>
        <el-button type="primary" icon="el-icon-search" size="mini" @click="handleQuery">搜索</el-button>
        <el-button icon="el-icon-refresh" size="mini" @click="resetQuery">重置</el-button>
      </el-form-item>
    </el-form>

    <el-row :gutter="10" class="mb8">
      <el-col :span="1.5">
        <el-button
          type="primary"
          plain
          icon="el-icon-plus"
          size="mini"
          @click="handleAdd"
          v-hasPermi="['blog:blog:add']"
        >新增
        </el-button>
      </el-col>
      <el-col :span="1.5">
        <el-button
          type="success"
          plain
          icon="el-icon-edit"
          size="mini"
          :disabled="single"
          @click="handleUpdate"
          v-hasPermi="['blog:blog:edit']"
        >修改
        </el-button>
      </el-col>
      <el-col :span="1.5">
        <el-button
          type="danger"
          plain
          icon="el-icon-delete"
          size="mini"
          :disabled="multiple"
          @click="handleDelete"
          v-hasPermi="['blog:blog:remove']"
        >删除
        </el-button>
      </el-col>
      <el-col :span="1.5">
        <el-button
          type="warning"
          plain
          icon="el-icon-download"
          size="mini"
          @click="handleExport"
          v-hasPermi="['blog:blog:export']"
        >导出
        </el-button>
      </el-col>
      <right-toolbar :showSearch.sync="showSearch" @queryTable="getList"></right-toolbar>
    </el-row>

    <el-table v-loading="loading" :data="blogList" @selection-change="handleSelectionChange">
      <el-table-column type="selection" width="55" align="center"/>
      <!--      <el-table-column label="主键" align="center" prop="id" />-->
      <el-table-column label="标题" align="center" prop="title"/>
      <!--      <el-table-column label="内容" align="center" prop="content" />-->
      <el-table-column label="默认图片" align="center" prop="defaultPicture" width="100">
        <template slot-scope="scope">
          <image-preview :src="scope.row.defaultPicture" :width="50" :height="50"/>
        </template>
      </el-table-column>
      <el-table-column label="博客来源" align="center" prop="source">
        <template slot-scope="scope">
          <dict-tag :options="dict.type.tb_blog_source" :value="scope.row.source"/>
        </template>
      </el-table-column>>
      <el-table-column label="浏览次数" align="center" prop="views"/>
      <!--      <el-table-column label="博客描述" align="center" prop="description" />-->
      <el-table-column label="是否推荐" align="center" prop="recommend">
        <template slot-scope="scope">
          <dict-tag :options="dict.type.t_blog_y_n" :value="scope.row.recommend"/>
        </template>
      </el-table-column>
      <el-table-column label="版权开关" align="center" prop="copyright">
        <template slot-scope="scope">
          <dict-tag :options="dict.type.tb_blog_o_c" :value="scope.row.copyright"/>
        </template>
      </el-table-column>
      <el-table-column label="赞赏开关" align="center" prop="appreciation">
        <template slot-scope="scope">
          <dict-tag :options="dict.type.tb_blog_o_c" :value="scope.row.appreciation"/>
        </template>
      </el-table-column>
      <el-table-column label="评论开关" align="center" prop="comment">
        <template slot-scope="scope">
          <dict-tag :options="dict.type.tb_blog_o_c" :value="scope.row.comment"/>
        </template>
      </el-table-column>
      <el-table-column label="是否发布" align="center" prop="published">
        <template slot-scope="scope">
          <dict-tag :options="dict.type.t_blog_y_n" :value="scope.row.published"/>
        </template>
      </el-table-column>
      <el-table-column label="类型" align="center" prop="typeId">
        <template scope="scope">
          <span v-for="item in typeList" v-if="item.id == scope.row.typeId">{{item.name}}</span>
        </template>
      </el-table-column>>
<!--      <el-table-column label="外键：用户ID" align="center" prop="userId"/>-->
      <el-table-column label="备注" align="center" prop="remark"/>
      <!--      <el-table-column label="备用1" align="center" prop="standby1" />-->
      <!--      <el-table-column label="备用2" align="center" prop="standby2" />-->
      <!--      <el-table-column label="备用3" align="center" prop="standby3" />-->
      <!--      <el-table-column label="备用4" align="center" prop="standby4" />-->
      <!--      <el-table-column label="备用5" align="center" prop="standby5" />-->
      <el-table-column label="操作" align="center" class-name="small-padding fixed-width">
        <template slot-scope="scope">
          <el-button
            size="mini"
            type="text"
            icon="el-icon-edit"
            @click="handleUpdate(scope.row)"
            v-hasPermi="['blog:blog:edit']"
          >修改
          </el-button>
          <el-button
            size="mini"
            type="text"
            icon="el-icon-delete"
            @click="handleDelete(scope.row)"
            v-hasPermi="['blog:blog:remove']"
          >删除
          </el-button>
        </template>
      </el-table-column>
    </el-table>

    <pagination
      v-show="total>0"
      :total="total"
      :page.sync="queryParams.pageNum"
      :limit.sync="queryParams.pageSize"
      @pagination="getList"
    />

    <!-- 添加或修改博客管理对话框 -->
    <el-dialog :title="title" :visible.sync="open" width="900px" append-to-body>
      <el-form ref="form" :model="form" :rules="rules" label-width="80px" inline>
        <el-form-item label="标题" prop="title">
          <el-input v-model="form.title" style="width: 305px" placeholder="请输入标题"/>
        </el-form-item>
        <el-form-item label="博客来源" prop="source">
          <el-select v-model="form.source" style="width: 305px" placeholder="请选择博客来源" clearable>
            <el-option
              v-for="dict in dict.type.tb_blog_source"
              :key="dict.value"
              :label="dict.label"
              :value="dict.value"
            />
          </el-select>
        </el-form-item>
        <el-form-item label="内容">
          <editor v-model="form.content" style="width: 700px" :min-height="192"/>
        </el-form-item>
<!--        <el-form-item label="浏览次数" prop="views">-->
<!--          <el-input v-model="form.views" placeholder="请输入浏览次数"/>-->
<!--        </el-form-item>-->
        <el-form-item label="博客描述" prop="description">
          <el-input v-model="form.description" type="textarea" style="width: 700px" placeholder="请输入内容"/>
        </el-form-item>
        <el-form-item label="是否推荐" prop="recommend">
          <el-select v-model="form.recommend" placeholder="请选择是否推荐">
            <el-option
              v-for="dict in dict.type.t_blog_y_n"
              :key="dict.value"
              :label="dict.label"
              :value="parseInt(dict.value)"
            ></el-option>
          </el-select>
        </el-form-item>
        <el-form-item label="版权开关" prop="copyright">
          <el-select v-model="form.copyright" placeholder="请选择版权开关">
            <el-option
              v-for="dict in dict.type.tb_blog_o_c"
              :key="dict.value"
              :label="dict.label"
              :value="parseInt(dict.value)"
            ></el-option>
          </el-select>
        </el-form-item>
        <el-form-item label="赞赏开关" prop="appreciation">
          <el-select v-model="form.appreciation" placeholder="请选择赞赏开关">
            <el-option
              v-for="dict in dict.type.tb_blog_o_c"
              :key="dict.value"
              :label="dict.label"
              :value="parseInt(dict.value)"
            ></el-option>
          </el-select>
        </el-form-item>
        <el-form-item label="评论开关" prop="comment">
          <el-select v-model="form.comment" placeholder="请选择评论开关">
            <el-option
              v-for="dict in dict.type.tb_blog_o_c"
              :key="dict.value"
              :label="dict.label"
              :value="parseInt(dict.value)"
            ></el-option>
          </el-select>
        </el-form-item>
        <el-form-item label="是否发布" prop="published">
          <el-select v-model="form.published" placeholder="请选择是否发布">
            <el-option
              v-for="dict in dict.type.t_blog_y_n"
              :key="dict.value"
              :label="dict.label"
              :value="parseInt(dict.value)"
            ></el-option>
          </el-select>
        </el-form-item>
        <el-form-item label="类型" prop="typeId">
          <el-select v-model="form.typeId" placeholder="请选择类型" clearable>
            <el-option
              v-for="item in typeList"
              :key="item.id"
              :label="item.name"
              :value="item.id"
            />
          </el-select>
        </el-form-item>
        <el-form-item label="备注" prop="remark">
          <el-input v-model="form.remark" type="textarea" placeholder="请输入内容"/>
        </el-form-item>
        <el-form-item label="默认图片">
          <image-upload v-model="form.defaultPicture"/>
        </el-form-item>
      </el-form>
      <div slot="footer" class="dialog-footer">
        <el-button type="primary" @click="submitForm">确 定</el-button>
        <el-button @click="cancel">取 消</el-button>
      </div>
    </el-dialog>
  </div>
</template>

<script>
import {listBlog, getBlog, delBlog, addBlog, updateBlog} from "@/api/blog/blog";
import { listType } from "@/api/blog/type";
export default {
  name: "Blog",
  dicts: ['t_blog_y_n', 'tb_blog_o_c', 'tb_blog_source'],
  data() {
    return {
      // 遮罩层
      loading: true,
      // 选中数组
      ids: [],
      // 非单个禁用
      single: true,
      // 非多个禁用
      multiple: true,
      // 显示搜索条件
      showSearch: true,
      // 总条数
      total: 0,
      // 博客管理表格数据
      blogList: [],
      typeList: [],
      // 弹出层标题
      title: "",
      // 是否显示弹出层
      open: false,
      // 查询参数
      queryParams: {
        pageNum: 1,
        pageSize: 10,
        title: null,
        content: null,
        defaultPicture: null,
        source: null,
        views: null,
        description: null,
        recommend: null,
        copyright: null,
        appreciation: null,
        comment: null,
        published: null,
        typeId: null,
        userId: null,
        standby1: null,
        standby2: null,
        standby3: null,
        standby4: null,
        standby5: null
      },
      // 表单参数
      form: {},
      // 表单校验
      rules: {
        title: [
          {required: true, message: "标题不能为空", trigger: "blur"}
        ],
        content: [
          {required: true, message: "内容不能为空", trigger: "blur"}
        ],
        defaultPicture: [
          {required: true, message: "默认图片不能为空", trigger: "blur"}
        ],
      }
    };
  },
  created() {
    this.getList();
  },
  methods: {
    /** 查询博客管理列表 */
    getList() {
      this.loading = true;
      listBlog(this.queryParams).then(response => {
        this.blogList = response.rows;
        this.total = response.total;
        this.loading = false;
      });
      listType().then(response => {
        this.typeList = response.rows;
      });
    },
    // 取消按钮
    cancel() {
      this.open = false;
      this.reset();
    },
    // 表单重置
    reset() {
      this.form = {
        id: null,
        title: null,
        content: null,
        defaultPicture: null,
        source: null,
        views: null,
        description: null,
        recommend: null,
        copyright: null,
        appreciation: null,
        comment: null,
        published: null,
        createTime: null,
        updateTime: null,
        typeId: null,
        userId: null,
        delFlag: null,
        remark: null,
        standby1: null,
        standby2: null,
        standby3: null,
        standby4: null,
        standby5: null
      };
      this.resetForm("form");
    },
    /** 搜索按钮操作 */
    handleQuery() {
      this.queryParams.pageNum = 1;
      this.getList();
    },
    /** 重置按钮操作 */
    resetQuery() {
      this.resetForm("queryForm");
      this.handleQuery();
    },
    // 多选框选中数据
    handleSelectionChange(selection) {
      this.ids = selection.map(item => item.id)
      this.single = selection.length !== 1
      this.multiple = !selection.length
    },
    /** 新增按钮操作 */
    handleAdd() {
      this.reset();
      this.open = true;
      this.title = "添加博客管理";
    },
    /** 修改按钮操作 */
    handleUpdate(row) {
      this.reset();
      const id = row.id || this.ids
      getBlog(id).then(response => {
        this.form = response.data;
        this.open = true;
        this.title = "修改博客管理";
      });
    },
    /** 提交按钮 */
    submitForm() {
      this.$refs["form"].validate(valid => {
        if (valid) {
          if (this.form.id != null) {
            updateBlog(this.form).then(response => {
              this.$modal.msgSuccess("修改成功");
              this.open = false;
              this.getList();
            });
          } else {
            addBlog(this.form).then(response => {
              this.$modal.msgSuccess("新增成功");
              this.open = false;
              this.getList();
            });
          }
        }
      });
    },
    /** 删除按钮操作 */
    handleDelete(row) {
      const ids = row.id || this.ids;
      this.$modal.confirm('是否确认删除博客管理编号为"' + ids + '"的数据项？').then(function () {
        return delBlog(ids);
      }).then(() => {
        this.getList();
        this.$modal.msgSuccess("删除成功");
      }).catch(() => {
      });
    },
    /** 导出按钮操作 */
    handleExport() {
      this.download('blog/blog/export', {
        ...this.queryParams
      }, `blog_${new Date().getTime()}.xlsx`)
    }
  }
};
</script>

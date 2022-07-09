<template>
  <el-card>
    <el-breadcrumb separator-class="el-icon-arrow-right">
      <el-breadcrumb-item :to="{ path: '/home' }">首页</el-breadcrumb-item>
      <el-breadcrumb-item>商品管理</el-breadcrumb-item>
      <el-breadcrumb-item>商品分类</el-breadcrumb-item>
    </el-breadcrumb>
    <tree-table
      :data="catesList"
      show-index
      :expand-type="false"
      :selection-type="false"
      :columns="columns"
      border
    >
      <template slot="isok" slot-scope="scope">
        <i
          class="el-icon-success"
          v-if="scope.row.cat_deleted == false"
          style="color: lightgreen"
        ></i>
        <i class="el-icon-error" v-else style="color: red"></i>
      </template>
      <!-- 排序 -->
      <template slot="order" slot-scope="scope">
        <el-tag v-if="scope.row.cat_level == 0" size="mini">一级</el-tag>
        <el-tag v-else-if="scope.row.cat_level == 1" type="success" size="mini"
          >二级</el-tag
        >
        <el-tag v-else type="warning" size="mini">三级</el-tag>
      </template>
      <!-- 操作 -->
      <template slot="opt" slot-scope="scope">
        <el-button
          :hidden="scope"
          type="primary"
          icon="el-icon-edit"
          size="mini"
          >编辑</el-button
        >
        <el-button type="danger" icon="el-icon-delete" size="mini"
          >删除</el-button
        >
      </template>
    </tree-table>
    <!-- 分页 -->
    <el-pagination
      @size-change="handleSizeChange"
      @current-change="handleCurrentChange"
      :current-page="queryInfo.pagenum"
      :page-sizes="[1, 2, 5, 10]"
      :page-size="queryInfo.pagesize"
      layout="total, sizes, prev, pager, next, jumper"
      :total="total"
    >
    </el-pagination>
  </el-card>
</template>

<script>
export default {
  name: 'Categories',
  created() {
    this.getCatesList()
  },
  data() {
    return {
      catesList: [],
      // 查询信息
      queryInfo: {
        query: '',
        pagenum: 1,
        pagesize: 5,
      },
      total: 0,
      columns: [
        {
          // 表格的配置信息
          label: '分类名称',
          prop: 'cat_name',
        },
        {
          label: '是否有效',
          type: 'template', // 表示当前为模板列
          template: 'isok',
        },
        {
          label: '排序',
          //表示当前定义为模板列
          type: 'template',
          //表示这一列使用使用模板名称
          template: 'order',
        },
        {
          label: '操作',
          //表示当前定义为模板列
          type: 'template',
          //表示这一列使用使用模板名称
          template: 'opt',
        }
      ],
    }
  },
  methods: {
    async getCatesList() {
      const { data: res } = await this.$http.get('categories', {
        params: this.queryInfo,
      })
      if (res.meta.status == 200) {
        this.catesList = res.data.result
        this.total = res.data.total
      } else {
        this.$message.error(res.meta.msg)
      }
    },
    // 分页大小发生变化
    handleSizeChange(newSize) {
      this.queryInfo.pagesize = newSize
      this.getCatesList()
    },
    // 监听 页码的变化
    handleCurrentChange(newPage) {
      this.queryInfo.pagenum = newPage
      this.getCatesList()
    },
  },
}
</script>

<style lang="scss" scoped>
.el-card {
  padding: 20px;
}
</style>
<template>
  <el-card>
    <el-breadcrumb separator-class="el-icon-arrow-right">
      <el-breadcrumb-item :to="{ path: '/home' }">首页</el-breadcrumb-item>
      <el-breadcrumb-item>商品管理</el-breadcrumb-item>
      <el-breadcrumb-item>商品分类</el-breadcrumb-item>
    </el-breadcrumb>
    <el-table :data="catesList" border stripe style="width: 100%">
      <el-table-column type="index"></el-table-column>
      <el-table-column prop="authName" label="权限名称"></el-table-column>
      <el-table-column prop="path" label="路径"></el-table-column>
      <el-table-column prop="level" label="权限等级">
        <template slot-scope="scope">
          <el-tag effect="dark" v-if="scope.row.level === '0'">一级</el-tag>
          <el-tag
            effect="dark"
            v-else-if="scope.row.level === '1'"
            type="success"
            >二级</el-tag
          >
          <el-tag effect="dark" v-else type="warning">三级</el-tag>
        </template>
      </el-table-column>
    </el-table>
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
      total: 0
    }
  },
  methods: {
    async getCatesList() {
      const { data: res } = await this.$http.get('categories', {params: this.queryInfo})
      if (res.meta.status == 200) {
        this.catesList = res.data.result
      } else {
        this.$message.error(res.meta.msg)
      }
    },
  },
}
</script>

<style lang="scss" scoped>
.el-card {
  padding: 20px;
}
</style>
<template>
  <el-card>
    <el-breadcrumb separator-class="el-icon-arrow-right">
      <el-breadcrumb-item :to="{ path: '/home' }">首页</el-breadcrumb-item>
      <el-breadcrumb-item>权限管理</el-breadcrumb-item>
      <el-breadcrumb-item>权限列表</el-breadcrumb-item>
    </el-breadcrumb>
    <el-table :data="rightsList" border stripe style="width: 100%">
      <el-table-column type="index"></el-table-column>
      <el-table-column prop="psName" label="权限名称"></el-table-column>
      <el-table-column prop="path" label="路径"></el-table-column>
      <el-table-column prop="level" label="权限等级">
        <template slot-scope="scope">
          <el-tag effect="dark" v-if="scope.row.psLevel === '0'">一级</el-tag>
          <el-tag
            effect="dark"
            v-else-if="scope.row.psLevel === '1'"
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
  name: 'Rights',
  created() {
    this.getRightsList()
  },
  data() {
    return {
      rightsList: [],
    }
  },
  methods: {
    async getRightsList() {
      const { data: res } = await this.$http.get('rights/list')
      //console.log(res.data)
      if (res.status == 200) {
        this.rightsList = res.data
      } else {
        this.$message.error(res.message)
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
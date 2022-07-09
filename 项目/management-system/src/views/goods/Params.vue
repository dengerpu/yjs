<template>
  <el-card>
    <el-breadcrumb separator-class="el-icon-arrow-right">
      <el-breadcrumb-item :to="{ path: '/home' }">首页</el-breadcrumb-item>
      <el-breadcrumb-item>商品管理</el-breadcrumb-item>
      <el-breadcrumb-item>分类参数</el-breadcrumb-item>
    </el-breadcrumb>
    <el-empty description="暂时没有内容"></el-empty>
  </el-card>
</template>

<script>
export default {
  name: 'Params'
}
</script>

<style lang="scss" scoped>
.el-card {
  padding: 20px;
}
</style>
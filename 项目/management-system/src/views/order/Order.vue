<template>
  <el-card>
    <el-breadcrumb separator-class="el-icon-arrow-right">
      <el-breadcrumb-item :to="{ path: '/home' }">首页</el-breadcrumb-item>
      <el-breadcrumb-item>订单管理</el-breadcrumb-item>
      <el-breadcrumb-item>订单列表</el-breadcrumb-item>
    </el-breadcrumb>
    <el-empty description="暂时没有内容"></el-empty>
  </el-card>
</template>

<script>
export default {
  name: 'Orders',
  created() {
    
  }
}
</script>

<style lang="scss" scoped>
.el-card {
  padding: 20px;
}
</style>
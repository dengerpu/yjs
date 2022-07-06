<template>
    <el-container class="home_container">
    <el-header>Header <el-button type="info" @click="layout">退出</el-button></el-header>
    <el-container>
        <el-aside width="200px">Aside</el-aside>
        <el-main>Main</el-main>
    </el-container>
    </el-container>
</template>

<script>
export default {
  name: 'Home',
  methods: {
    layout() {
      window.sessionStorage.clear()
      this.$router.push('/login')
    },
  },
}
</script>

<style lang="scss" scope>
.home_container {
    height: 100%;
}
.el-header {
    box-shadow: 0 1px 4px rgb(0 21 41 / 8%);
}
.el-aside {
    background-color: #304156;
}
</style>
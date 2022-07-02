<template>
  <div>
    <h2>我是首页</h2>
    <p>我是首页的内容111111</p>
    <router-link to="/home/news">新闻</router-link>
    <router-link to="/home/message">消息</router-link>
    <router-view></router-view>
  </div>
</template>

<script>
export default {
  data() {
    return {
       path: '/home/news'
    }
  },
  // created () {
  //   document.title = "首页"
  //    console.log('首页')
  // }
  created() {
    console.log('home  created')
  },
  destroyed() {
    console.log('home destroyed')
  },
  // 这两个函数，只有该组件被保持了状态使用了keep-alive
  activated() {
    this.$router.push(this.path)
    console.log('home  active')
  },
  deactivated() {
    console.log('home deactive')
  },
  beforeRouteLeave (to, from, next) {
    this.path = this.$route.path
    next()
  }
}
</script>

<style>

</style>
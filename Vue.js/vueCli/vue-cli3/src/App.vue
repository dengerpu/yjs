<template>
  <div id="app">
      <h1>我是网站标题</h1>
      <!-- <router-link to="/home" tag="button" replace>首页</router-link>
      <router-link to="/about" tag="button" replace>关于</router-link> -->
      <button @click="indexbtnClick">首页</button>
       <button @click="aboutbtnClick">关于</button>
      <router-view></router-view>
      <h2>我是底部的内容</h2>
  </div>
</template>

<script>


export default {
  name: 'App',
  components: {
    
  },
  methods: {
    indexbtnClick () {
      // this.$router.push('/home').catch(err => console.log(err))
      // console.log(this.$router.path)
      // console.log('indexbtnClick')
      this.$router.replace('/home')
      // if (this.$route.path != '/home') {
      //   this.$router.push('/home')
      // }
      
    },
    aboutbtnClick () {
      // this.$router.push('/about')
      this.$router.replace('/about')
      // console.log('aboutbtnClick')
    }
  }
}
</script>

<style>
/*
.router-link-active {
  color: red;
}
*/
.active {
  color: red;
}
</style>

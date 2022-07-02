<template>
  <div id="app">
      <h1>我是网站标题</h1>
      <router-link to="/home" tag="button" >首页</router-link>
      <router-link to="/about" tag="button" >关于</router-link>
      <!-- <router-link :to="'/user/'+userId" tag="button" >用户</router-link> -->
      <!-- <router-link :to="{path: '/profile', query: {name: 'zhangsan', age: 19, height: 188}}" tag="button">档案</router-link> -->
      <button @click="userClick">用户</button>
      <button @click="profileClick">档案</button>
      <!-- <button @click="indexbtnClick">首页</button>
       <button @click="aboutbtnClick">关于</button> -->
       <keep-alive exclude="User,Profile">
        <router-view>
          <!-- 所有路径匹配到的视图组件都会被缓存 -->
        </router-view>
       </keep-alive>
      
      <h2>我是底部的内容</h2>
  </div>
</template>

<script>


export default {
  name: 'App',
  data () {
    return {
      userId: 'lisi'
    }
  },
  components: {
    
  },
  mounted() {
    // console.log(this.$router)
    // console.log(this.$route)
  },
  methods: {
    profileClick () {
      this.$router.push({
        path: '/profile',
        query: {
          name: 'zhangsan',
          age: 18
        }
      })
    },
    userClick() {
      this.$router.push('/user/'+ this.userId)
    },
    indexbtnClick () {
      // this.$router.push('/home').catch(err => console.log(err))
      // console.log(this.$router.path)
      // console.log('indexbtnClick')
      //this.$router.replace('/home')
      // if (this.$route.path != '/home') {
      //   this.$router.push('/home')
      // }
      
    },
    aboutbtnClick () {
      // this.$router.push('/about')
      // this.$router.replace('/about')
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

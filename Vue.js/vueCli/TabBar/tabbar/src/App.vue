<template>
  <div id="app">
    <!-- 路由占位符 -->
    <router-view></router-view>
    <main-tab></main-tab>
  </div>
</template>

<script>
import MainTab from './components/maintab/MainTab.vue'
export default {
  name: 'App',
  components: {
    MainTab
  }
}
</script>

<style>
  @import "./assets/css/base.css"
</style>

import Vue from 'vue'
import App from './App.vue'
import router from './router'
import './plugins/element.js'


// 导入字体图标
import './assets/fonts/iconfont.css'
// 导入全局样式表
import './assets/css/global.css'
// 导入树形表格插件
import TreeTable from 'vue-table-with-tree-grid'
// 导入NProgress包对应的JS和css
import NProgress from 'nprogress'
import 'nprogress/nprogress.css'

import tinymce from 'tinymce'
import VueTinymce from '@packy-tang/vue-tinymce'

Vue.prototype.$tinymce = tinymce // 将全局tinymce对象指向给Vue作用域下
Vue.use(VueTinymce)              // 安装vue的tinymce组件


import axios from 'axios'
axios.defaults.baseURL = "http://127.0.0.1:8888/"
axios.timeout = 5
// 在request请求拦截器中，展示进度条 NProgress.start()
axios.interceptors.request.use(config => {
  NProgress.start()
  // 为请求头对象，添加Token验证的Authorization字段
  config.headers.Authorization = window.sessionStorage.getItem('token')
  return config
})
// 在response拦截器中，隐藏进度条NProgress.done()
axios.interceptors.response.use(config => {
  NProgress.done()
  return config
})


Vue.prototype.$http = axios

Vue.config.productionTip = false

Vue.component('tree-table', TreeTable)

new Vue({
  router,
  render: h => h(App)
}).$mount('#app')

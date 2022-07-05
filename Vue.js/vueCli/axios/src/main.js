import Vue from 'vue'
import App from './App.vue'
import router from './router'

import axios from 'axios'

Vue.config.productionTip = false

new Vue({
  router,
  render: h => h(App)
}).$mount('#app')

// axios({
//   url: 'http://123.207.32.32:8000/home/multidata',
//   method: 'get' // 默认是get请求
// }).then(res => {
//   console.log(res.data)
// })

// axios.get('http://123.207.32.32:8000/home/data',
//   {params: { type: 'shell', page: 1}})
//     .then(res => {
//       console.log(res.data)
//   })

// axios.defaults.baseURL = "http://123.207.32.32:8000"

// axios.all([axios.get('/home/multidata'),axios.get('/home/data',
//   {params: {type: 'shell', page: 1}})
// ]).then(axios.spread((res1, res2) =>{
//   console.log(res1)
//   console.log(res2)
// }))

// 创建新的实例
// const axiosInstance = axios.create({
//   baseURL: 'http://123.207.32.32:8000',
//   timeout: 5000,
//   headers: {
//     'Content-Type': 'application/x-www-form-urlencoded'
//   }
// })

// axiosInstance({
//   url:'/home/multidata',
//   method: 'get'
// }).then(res => {
//   console.log(res)
// }).catch(err => {
//   console.log(err)
// })

import {request} from './network/request'

request({
  url: '/home/multidata'
})
.then(res => {
  console.log(res)
})
.catch(err => {
  console.log(err)
})




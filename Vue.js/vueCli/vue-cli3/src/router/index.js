import Vue from 'vue'
import VueRouter from 'vue-router'

import Home from '../components/Home.vue'
import About from '../components/About.vue'

// 1.注入插件
Vue.use(VueRouter)

// 2.定义路由
const routes = [
    {
        path: '/',
        // 重定向
        redirect: '/home'
    },
    {
        path: '/home',
        component: Home
    },
    {
        path: '/about',
        component: About
    }
]

// 3.创建路由实例
const router = new VueRouter({
    routes,
    mode: 'history',
    // 修改linkActiveClass
    linkActiveClass: 'active'

})

// const VueRouterPush = VueRouter.prototype.push
// VueRouter.prototype.push = function push (to) {
//   return VueRouterPush.call(this, to).catch(err => err)
// }

// 4.导出router实例
export default router
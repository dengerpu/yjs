import Vue from 'vue'
import VueRouter from 'vue-router'

import Home from '../pages/home/Home.vue'
import Cart from '../pages/cart/Cart.vue'
import Category from '../pages/category/Category.vue'
import Profile from '../pages/profile/Profile.vue'
// 1.安装插件
Vue.use(VueRouter)
// 2.创建路由对象
const routes = [
    {
        path: '',
        redirect: '/home'
    },
    {
        path: '/home',
        component: Home
    },
    {
        path: '/cart',
        component: Cart
    },
    {
        path: '/category',
        component: Category
    },
    {
        path: '/Profile',
        component: Profile
    }
]

const router = new VueRouter({
    routes,
    mode: 'history'
})
//导出router
export default router

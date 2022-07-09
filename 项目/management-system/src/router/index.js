import Vue from 'vue'
import VueRouter from 'vue-router'
import Login from '../components/Login.vue'
import Home from '../components/Home.vue'

const Users = () => import('../views/user/Users.vue')
const Rights = () => import('../views/power/Rights.vue')
const Roles = () => import('../views/power/Roles.vue')
const Categories = () => import('../views/goods/Categories.vue')
const Goods = () => import('../views/goods/Goods.vue')
const Params = () => import('../views/goods/Params.vue')
const Orders = () => import('../views/order/Order.vue')
const Report = () => import('../views/report/Report.vue')

Vue.use(VueRouter)

const routes = [
  {
    path:'',
    redirect: '/login'
  },
  {
    path:'/login',
    component: Login
  },
  {
    path: '/home',
    component: Home,
    children:[
      {path: '/users', component: Users},
      {path: '/rights', component: Rights},
      {path: '/roles', component: Roles},
      {path: '/categories', component: Categories},
      {path: '/goods', component: Goods},
      {path: '/params', component: Params},
      {path: '/orders', component: Orders},
      {path: '/reports', component: Report},
      
      
    ]
  }
]

const router = new VueRouter({
  mode: 'history',
  base: process.env.BASE_URL,
  routes
})
// 为路由对象，添加beforeEach导航守卫
// to 将要访问的路径
// from 代表从哪个路径跳转而来
// next 是一个函数，表示放行
// next 是一个函数，表示放行  next() 放行 next('/login') 强制跳转
router.beforeEach((to, from, next) => {
  // 如果用户访问的登录页，直接放行
  if(to.path == '/login') return next()
  const tokenStr = window.sessionStorage.getItem('token')
  // 没有token,强制跳转到登录页
  if(!tokenStr) return next('/login')
  next()
})

export default router

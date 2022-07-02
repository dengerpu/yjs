import Vue from 'vue'
import VueRouter from 'vue-router'

const Home = () => import('../components/Home.vue')
const About = () => import('../components/About.vue')
const User = () => import('../components/User.vue')
const HomeNews = () => import('../components/HomeNews.vue')
const HomeMessage = () => import('../components/HomeMessage.vue')
const Profile = () => import('../components/Profile.vue')

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
        component: Home,
        meta: {
            title: '首页'
        },
        children:[
            {
                path: '',
                redirect: 'news'
            },
            {
                path: 'news',
                component: HomeNews
            },
            {
                path: 'message',
                component: HomeMessage
            }
        ]
    },
    {
        path: '/about',
        component: About,
        meta: {
            title: '关于'
        }
    },
    {
        path: '/user/:userId',
        component: User,
        meta: {
            title: '用户'
        }
    },
    {
        path: '/profile',
        component: Profile,
        meta: {
            title: '档案'
        }
    }
]

// 3.创建路由实例
const router = new VueRouter({
    routes,
    mode: 'history',
    // 修改linkActiveClass
    linkActiveClass: 'active'

})

// 路由导航守卫
router.beforeEach((to, from, next) => {
    window.document.title = to.matched[0].meta.title
    // console.log(to)
    next()
})

// 解决按钮$.router.push()跳转，点击相同页面报错问题
// const VueRouterPush = VueRouter.prototype.push
// VueRouter.prototype.push = function push (to) {
//   return VueRouterPush.call(this, to).catch(err => err)
// }

// 4.导出router实例
export default router
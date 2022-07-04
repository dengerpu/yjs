import {add, mul} from './js/mathUtils.js'
import { name, age, height } from './js/info.js'


//引入css
import normal from './css/normal.css'
require('./css/index.less')

import Vue from 'vue'

import App from './vue/App.vue'

const app = new Vue({
    el: '#app',
    template:'<App/>',
    components:{
        App
    }
})

console.log(name)
console.log(age)
console.log(height)
console.log(add(10,20))
console.log(mul(10,20))
console.log('配置入口和出口，使用webpack命令打包')
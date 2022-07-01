// The Vue build version to load with the `import` command
// (runtime-only or standalone) has been set in webpack.base.conf with an alias.
import Vue from 'vue'
import App from './App'

Vue.config.productionTip = false

// const cpn = Vue.component('cpn', {
//   template: '<div>我是cpn组件</div>',
//   data () {
//     return {}
//   }
// })

/* eslint-disable no-new */
new Vue({
  el: '#app',
  // components: { App },
  // template: '<App/>'
  render: (createElement) => {
    // 使用方式一： return createElement('标签', '相关数据对象（可以不传）', ['内容数组'])
    // return createElement('div', {class: 'box'}, ['我是div中的内容'])
    // 嵌套render函数
    // return createElement('div', {class: 'box'}, [createElement('h2', {class: 'h2box'}, ['我是render函数里面嵌套的h2'])])
    // 使用方式二: 传入一个组件对象
    // return createElement(cpn)
    return createElement(App)
  }

})

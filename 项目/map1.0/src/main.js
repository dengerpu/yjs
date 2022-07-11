import Vue from 'vue'
import App from './App.vue'
import router from './router'

import VueAMap from 'vue-amap'

Vue.config.productionTip = false

Vue.use(VueAMap)
VueAMap.initAMapApiLoader({
  key: 'd730c990002e45acb910b669bde5ffa6',
  plugin: [ 'AMap.Autocomplete', 'AMap.PlaceSearch', 'AMap.Scale', 'AMap.OverView', 'AMap.ToolBar', 'AMap.MapType' , 'AMap.PolyEditor' , 'AMap.CircleEditor'],
  v:'1.4.4'
})
  

new Vue({
  router,
  render: h => h(App)
}).$mount('#app')

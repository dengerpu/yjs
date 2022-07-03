<template>
  <div>
    <tab-bar>
      <tab-bar-item path="/home" activeColor="#FF5777">
        <img slot="item-icon" src="~img/tabbar/home.svg">
        <img slot="item-icon-active" src="~img/tabbar/home_active.svg"/>
        <div slot="item-text">首页</div>
      </tab-bar-item>
      <tab-bar-item path="/category" activeColor="#FF5777">
        <img slot="item-icon" src="~img/tabbar/category.svg">
        <img slot="item-icon-active" src="~img/tabbar/category_active.svg"/>
        <div slot="item-text">分类</div>
      </tab-bar-item>
      <tab-bar-item path="/cart" activeColor="#FF5777">
        <img slot="item-icon" src="~img/tabbar/shopcart.svg">
        <img slot="item-icon-active" src="~img/tabbar/shopcart_active.svg"/>
        <div slot="item-text">购物车</div>
      </tab-bar-item>
      <tab-bar-item path="/profile" activeColor="#FF5777">
        <img slot="item-icon" src="~img/tabbar/profile.svg">
        <img slot="item-icon-active" src="~img/tabbar/profile_active.svg"/>
        <div slot="item-text">我的</div>
      </tab-bar-item>
     </tab-bar>
  </div>
</template>

<script>
import TabBar from '../tabbar/TabBar.vue'
import TabBarItem from '../tabbar/TabBarItem.vue'
export default {
    name: 'MianTab',
    components: {
        TabBar,
        TabBarItem
    }
}
</script>

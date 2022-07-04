<template>
  <div id="app">
    <info></info>
    <h2>------APP组件------</h2>
    <h2>{{$store.state.counter}}</h2>
    <button @click="addCounter">+</button>
    <button @click="subCounter">-</button>
    <button @click="addCounter1(5)">+5</button>
    <button @click="subCounter1(10)">-10</button>
    <ul>
      <li v-for="item in this.$store.state.students">{{item}}</li>
    </ul>
    <!-- <h2>{{getAge}}</h2> -->
    <h2>------getters基本使用------</h2>
    <h2>{{$store.getters.powerCounter}}</h2>
    <p>{{$store.getters.more20Age}}</p>
    <h2>年龄超过20的数量：{{$store.getters.more20AgeLength}}</h2>
    <p>{{$store.getters.moreAgestu(12)}}</p>
    <hello-vuex></hello-vuex>
  </div>
</template>

<script>
import HelloVuex from './components/HelloVuex.vue'
import Info from './components/Info.vue'

import {INCREMENT, DECREMENT} from './store/motations-types'

export default {
  name: 'App',
  components: {
    HelloVuex,
    Info
  },
  methods: {
    addCounter() {
      this.$store.commit(INCREMENT)
    },
    subCounter() {
      this.$store.commit(DECREMENT)
    },
    addCounter1(count) {
      //  payload: 负载
      //   1.普通的提交封装
        this.$store.commit('addCounter', count)
    },
    subCounter1(count) {
        // // 2.特殊的提交封装
        this.$store.commit({
          type: 'subCounter',
          count
        })
    }

  },
  computed: {
    getAge(){  // 这种方法虽然可以实现，晒窜出年龄大于20的，但是只能在单页面使用
      return this.$store.state.students.filter(item => item.age >= 20)
    }
  }
}
</script>

<style scoped>

</style>

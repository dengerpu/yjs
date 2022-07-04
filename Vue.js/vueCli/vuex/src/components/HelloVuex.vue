<template>
  <div>
    <h2>------HelloVuex组件------</h2>
    <h2>{{this.$store.state.counter}}</h2>
    <ul>
      <li v-for="item in this.$store.state.students">{{item}}</li>
    </ul>
    <h2>------getters基本使用------</h2>
    <h2>{{this.$store.getters.powerCounter}}</h2>
    <p>{{this.$store.getters.more20Age}}</p>
    <h2>年龄超过20的数量：{{this.$store.getters.more20AgeLength}}</h2>
    <p>{{this.$store.getters.moreAgestu(12)}}</p>
  </div>
</template>

<script>
export default {

}
</script>

<style lang="sass" scoped>

</style>
<template>
  <div>
    <h2>------Info组件------</h2>
    <h2>{{this.$store.state.info}}</h2>
    <button @click="updateInfo">更新信息</button>
  </div>
</template>

<script>
export default {
    methods: {
        updateInfo() {
            this.$store.commit('updateInfo')
        }
    }
}
</script>

<style>

</style>
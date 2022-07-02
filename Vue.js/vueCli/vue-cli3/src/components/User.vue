<template>
  <div>
        <h2>我是user界面</h2>
        <h2>{{this.$route.params.userId}}</h2>
  </div>
</template>

<script>
export default {
  name: 'User',
  created () {
    console.log('user  created')
  },
  destroyed () {
    console.log('user destroyed')
  }

}
</script>

<style>

</style>
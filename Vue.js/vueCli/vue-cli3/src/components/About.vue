<template>
  <div>
    <h2>我是关于的内容</h2>
    <p>我是关于的内容2222</p>
  </div>
</template>

<script>
export default {
    //  created () {
    //     document.title = "关于"
    //     console.log('about')
    // }
    created () {
    console.log('about  created')
  },
  destroyed () {
    console.log('about destroyed')
  }
}
</script>

<style>

</style>
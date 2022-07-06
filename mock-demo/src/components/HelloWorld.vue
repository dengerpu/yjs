<template>
  <div class="hello">

  </div>
</template>

<script>
import axios from 'axios'
export default {
  name: 'HelloWorld',
  mounted() {
    axios.get('/user/userinfo')
    .then(res => {
      console.log(res)
    })
    .catch(err => {
      console.log(err)
    })
  }
}
</script>


<style scoped>

</style>

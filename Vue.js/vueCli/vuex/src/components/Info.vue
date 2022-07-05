<template>
  <div>
    <h2>------Info组件------</h2>
    <h2>{{this.$store.state.info}}</h2>
    <button @click="updateInfo">更新信息</button>
    <h2>--------module模块---------</h2>
    <h2>{{$store.state.a.counter}}</h2>
    <button @click="addInfoCounter">+</button>
  </div>
</template>

<script>
export default {
    methods: {
        updateInfo() {
            // this.$store.commit('updateInfo')
            //  this.$store.dispatch('aUpdateInfo', {
            //     message: '我是携带的信息',
            //     success: () => {
            //         console.log('里面已经完成了');
            //     }
            // })

              this.$store
            .dispatch('aUpdateInfo', '我是携带的信息')
            .then(res => {
                console.log('里面完成了提交');
                console.log(res);
            })
        },
        addInfoCounter() {
            this.$store.commit('add')
        }
    }
}
</script>

<style>

</style>
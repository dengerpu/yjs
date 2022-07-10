<template>
  <el-card>
    <el-row>
      <el-col class="show_box" v-for="item in info" :key="info.name">
        <div class="card_box">
          <img :src="item.path"/>
          <p>{{ item.name }}</p>
          <span>{{ item.desc }}</span>
        </div>
      </el-col>
    </el-row>
  </el-card>
</template>

<script>
export default {
  name: 'Welcome',
  data() {
    return {
      info: [
        {
          path: require('../assets/img/vue.svg'),
          name: 'Vue',
          desc: '渐进式JavaScript 框架',
        },
        {
          path: require('../assets/img/react.svg'),
          name: 'React',
          desc: '用于构建用户界面的 JavaScript 库',
        },
        {
          path: require('../assets/img/angular.svg'),
          name: 'Angular',
          desc: '现代 Web 开发平台',
        },
        {
          path: require('../assets/img/mybatis-plus.svg'),
          name: 'MyBatis-Plus',
          desc: '为简化开发而生',
        },
        {
          path: require('../assets/img/spring.svg'),
          name: 'Spring',
          desc: 'Spring makes Java simple modern productive',
        },
      ],
    }
  },
}
</script>

<style lang="scss" scoped>
.el-card {
  padding: 20px;
  .el-row {
    display: flex;
    justify-content: space-between;
    .el-col {
      flex: 1;
      display: flex;
      justify-content: center;
      .card_box {
        box-shadow: 0 1px 4px rgb(0 21 41 / 30%);
        width: 200px;
        padding: 10px 20px;
        text-align: center;
        img {
          width: 200px;
          height: 200px;
        }
        p {
          font-size: 20px;
          font-weight: 700;
        }
      }
    }
  }
}
</style>
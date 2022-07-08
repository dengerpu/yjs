<template>
  <el-container class="home_container">
    <el-aside :width="isCollapse ? '60px' : '200px'">
      <!-- 菜单区域 -->
      <el-menu
        default-active="2"
        class="el-menu-vertical-demo"
        background-color="#304156"
        text-color="#fff"
        active-text-color="#409EFF"
        unique-opened
        :collapse-transition="false"
        :collapse="isCollapse"
        router
        :default-active="activePath"
      >
        <!-- 一级菜单 -->
        <el-submenu
          :index="'/' + item.path"
          v-for="item in menulist"
          :key="item.id"
        >
          <template slot="title">
            <i :class="iconslist[item.id]"></i>
            <span>{{ item.authName }}</span>
          </template>
          <!-- 二级菜单 -->
          <el-menu-item
            :index="'/' + subItem.path"
            v-for="subItem in item.children"
            :key="subItem.id"
            @click="saveNavPath('/' + subItem.path)"
          >
            <template slot="title">
              <i class="el-icon-menu"></i>
              <span>{{ subItem.authName }}</span>
            </template>
          </el-menu-item>
        </el-submenu>
      </el-menu>
    </el-aside>
    <el-container>
      <el-header>
        <el-row>
          <el-col :xs="12" :sm="8" :md="8" :lg="8" :xl="8">
            <div class="header_left">
              <div class="toggle-button" @click="toggleCollapse">
                <span
                  :class="isCollapse ? 'el-icon-s-unfold' : 'el-icon-s-fold'"
                ></span>
              </div>
              <el-breadcrumb separator="/">
                <el-breadcrumb-item :to="{ path: '/home' }"
                  >首页</el-breadcrumb-item
                >
                <el-breadcrumb-item
                  >用户</el-breadcrumb-item
                >
              </el-breadcrumb>
            </div>
          </el-col>
          <el-col :xs="0" :sm="12" :md="12" :lg="12" :xl="12">
            <div class="header_center">
              <div class="logo_box"><img src="../assets/img/logo.png" /></div>
              <span>xxx后台管理系统</span>
            </div>
          </el-col>
          <el-col :xs="12" :sm="4" :md="4" :lg="4" :xl="4">
            <div class="header_right">
              <el-dropdown trigger="click" class="profile">
                <span class="el-dropdown-link">
                  点我查看<i class="el-icon-caret-bottom el-icon--right"></i>
                </span>
                <el-dropdown-menu slot="dropdown">
                  <el-dropdown-item class="clearfix">
                    个人中心
                  </el-dropdown-item>
                  <el-dropdown-item class="clearfix"> 首页 </el-dropdown-item>
                  <el-dropdown-item class="clearfix">
                    <div @click="layout">退出</div>
                  </el-dropdown-item>
                </el-dropdown-menu>
              </el-dropdown>
            </div>
          </el-col>
        </el-row>
      </el-header>
      <el-main>
        <!-- <div class="navbar"></div> -->
        <router-view></router-view>
      </el-main>
    </el-container>
  </el-container>
</template>

<script>
export default {
  name: 'Home',
  created() {
    this.getMenuList()
    this.activePath = window.sessionStorage.getItem('activePath')
  },
  data() {
    return {
      menulist: [], // 菜单列表
      iconslist: {
        // 菜单图标
        125: 'iconfont icon-user',
        103: 'iconfont icon-tijikongjian',
        101: 'iconfont icon-shangpin',
        102: 'iconfont icon-danju',
        145: 'iconfont icon-baobiao',
      },
      isCollapse: false,
      activePath: '', // 当前激活的链接地址
    }
  },
  methods: {
    // 退出
    layout() {
      window.sessionStorage.clear()
      this.$router.push('/login')
    },
    // 获取菜单
    async getMenuList() {
      const { data: res } = await this.$http.get('/menus')
      // console.log(res)
      if (res.meta.status != 200) return this.$message.error(res.meta.msg)
      this.menulist = res.data
    },
    // 菜单折叠
    toggleCollapse() {
      this.isCollapse = !this.isCollapse
    },
    // 保存当前激活的地址
    saveNavPath(activePath) {
      window.sessionStorage.setItem('activePath', activePath)
      this.activePath = activePath
    },
  },
}
</script>

<style lang="scss" scope>
.home_container {
  height: 100%;
  .el-aside {
    background-color: #304156;
    .el-menu {
      border-right: 0px;
    }
  }
  .el-header {
    padding-left: 0px;
    height: 60px;
    line-height: 60px;
    overflow: hidden;
    box-shadow: 0 1px 4px rgb(0 21 41 / 8%);
    .header_left {
      display: flex;
      .toggle-button {
        padding: 0px 18px;
        font-size: 24px;
        box-sizing: border-box;
        cursor: pointer;
      }
      .toggle-button:hover {
        background-color: rgba(0, 0, 0, 0.025);
      }
    }
    .header_center {
      display: flex;
      align-content: center;
      .logo_box {
        padding: 10px 0;
        img {
          display: block;
          width: 40px;
          height: 40px;
        }
      }
      span {
        color: #000000;
        font-size: 24px;
        font-weight: 700;
        padding-left: 10px;
      }
    }
    .header_right {
      .profile {
        float: right;
      }
    }
  }
  .el-main {
    padding: 0px;
    .navbar {
      height: 30px;
      box-shadow: 0 1px 4px rgb(0 21 41 / 30%);
    }
  }
}
.iconfont {
  margin-right: 10px;
}
</style>
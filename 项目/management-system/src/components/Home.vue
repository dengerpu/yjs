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
        <el-menu-item index="/home" @click="saveNavPath('/home', '首页')">
          <i class="el-icon-s-home"></i>
          <span slot="title">首页</span>
        </el-menu-item>
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
            @click="saveNavPath('/' + subItem.path, subItem.authName)"
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
              <!-- <el-breadcrumb separator="/">
                <el-breadcrumb-item>首页</el-breadcrumb-item>
                <el-breadcrumb-item>用户</el-breadcrumb-item>
              </el-breadcrumb> -->
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
        <div class="navbar">
          <el-tag
            :class="[
              'route_tag',
              activePath == item.path ? 'route_tag_active' : '',
            ]"
            :key="item.path"
            v-for="(item, index) in tagPaths"
            :closable="index == 0 || index == 1 ? false : true"
            size="small"
            type="info"
            :disable-transitions="false"
            @click="routeTagclick(item.path)"
            @close="handleClose(item.path)"
          >
            {{ item.name }}
          </el-tag>
        </div>
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
    this.tagPaths = JSON.parse(window.sessionStorage.getItem('tagPaths'))
    if (this.tagPaths == null) {
      this.tagPaths = [
        {
          path: '/home',
          name: '首页',
        },
        {
          path: '/users',
          name: '用户列表',
        },
      ]
    }
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
      tagPaths: [
        {
          path: '/home',
          name: '首页',
        },
        {
          path: '/users',
          name: '用户列表',
        },
      ],
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
       if (res.status != 200) return this.$message.error(res.meta.msg)
       this.menulist = res.data;
      // if (res.meta.status != 200) return this.$message.error(res.meta.msg)
      // this.menulist = res.data
    },
    // 菜单折叠
    toggleCollapse() {
      this.isCollapse = !this.isCollapse
    },
    // 保存当前激活的地址
    saveNavPath(activePath, name) {
      window.sessionStorage.setItem('activePath', activePath)
      this.activePath = activePath
      // 先查找路径数组中是否有
      let result = this.tagPaths.findIndex((item) => item.path === activePath)
      // 没有找过就加入数组中去
      if (result == -1) {
        this.tagPaths.push({
          path: activePath,
          name,
        })
        window.sessionStorage.setItem('tagPaths', JSON.stringify(this.tagPaths))
      }
    },
    handleClose(path) {
      const index = this.tagPaths.findIndex((item) => item.path == path)
      // this.dynamicTags.splice(this.dynamicTags.indexOf(tag), 1)
      // 如果是最后一个,并且在当前路径，删除之后跳转到前一个
      if (index == this.tagPaths.length - 1) {
        if (this.activePath == path) {
          // 在当前路径，删除之后跳到前一个
          this.tagPaths.splice(index, 1)
          const lastPath = this.tagPaths[this.tagPaths.length - 1].path
          window.sessionStorage.setItem('activePath', lastPath)
          this.activePath = lastPath
          this.$router.push(lastPath)
        } else {
          // 是最后一个，但是不在当前路径，直接删除
          this.tagPaths.splice(index, 1)
        }
      } else {
        // 如果是中间，且在当前路径，如果后面有则跳到后一个
        if (this.activePath == path) {
          this.tagPaths.splice(index, 1)
          const lastPath = this.tagPaths[index].path
          window.sessionStorage.setItem('activePath', lastPath)
          this.activePath = lastPath
        } else {
          // 在中间，且不在当前路径直接删除
          this.tagPaths.splice(index, 1)
        }
      }
      window.sessionStorage.setItem('tagPaths', JSON.stringify(this.tagPaths))
    },
    // 点击标签跳转路由
    routeTagclick(path) {
      window.sessionStorage.setItem('activePath', path)
      this.activePath = path
      if (this.$route.path != path) {
        this.$router.push(path)
      }
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
      display: flex;
      align-items: center;
      padding: 0 20px;
      height: 30px;
      box-shadow: 0 1px 4px rgb(0 21 41 / 30%);
      .route_tag {
        margin-left: 5px;
        border-radius: 0px;
        background-color: #fff;
        border: 1px solid #d8dce5;
        color: #495060;
        font-size: 12px;
        font-weight: 500;
        cursor: pointer;
      }
      .route_tag_active {
        background-color: #42b983;
        color: #fff;
        border-color: #42b983;
      }
      .route_tag_active::before {
        content: '';
        background: #fff;
        display: inline-block;
        width: 8px;
        height: 8px;
        border-radius: 50%;
        position: relative;
        margin-right: 2px;
      }
      .el-tag__close {
        color: #fff;
      }
    }
  }
}
.iconfont {
  margin-right: 10px;
}
.el-icon-s-home:before {
  font-size: 16px;
}
</style>
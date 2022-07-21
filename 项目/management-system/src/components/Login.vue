<template>
  <div class="login_container" :style="LoginContainerSize">
    <img
      src="../assets/img/login_bg.png"
      class="login_img"
      :style="LoginContainerSize"
    />
    <el-card class="login">
      <el-row class="login_row">
        <!-- 标题 -->
        <el-col :xs="0" :sm="13" :md="13" :lg="13" :xl="13">
          <div class="login_left">
            <img src="../assets/img/login-left.jpg" alt="" />
          </div>
        </el-col>
        <el-col :xs="24" :sm="11" :md="11" :lg="11" :xl="11">
          <el-card class="login_right">
            <div class="login_right_top">登 陆</div>
            <!-- 登陆区域 -->
            <el-form
              ref="loginFormRef"
              :model="loginForm"
              :rules="loginFormRules"
              label-width="0px"
            >
              <el-form-item prop="username">
                <el-input
                  v-model="loginForm.username"
                  prefix-icon="iconfont icon-user"
                ></el-input>
              </el-form-item>
              <el-form-item prop="password">
                <el-input
                  v-model="loginForm.password"
                  type="password"
                  prefix-icon="iconfont icon-3702mima"
                ></el-input>
              </el-form-item>
              <el-form-item class="btn_box">
                <el-button type="primary" @click="login">登陆</el-button>
                <el-button type="info" @click="resetLoginForm">重置</el-button>
              </el-form-item>
            </el-form>
          </el-card>
        </el-col>
      </el-row>
    </el-card>
  </div>
</template>

<script>
export default {
  name: 'Login',
  data() {
    return {
      LoginContainerSize: {
        width: '',
        height: '',
      },
      loginForm: {
        username: 'admin',
        password: '123456',
      },
      loginFormRules: {
        username: [
          { required: true, message: '请输入用户名', trigger: 'blur' },
          {
            min: 3,
            max: 15,
            message: '长度在 3 到 15 个字符',
            trigger: 'blur',
          },
        ],
        password: [
          { required: true, message: '请输入密码', trigger: 'blur' },
          {
            min: 6,
            max: 18,
            message: '长度在 6 到 18 个字符',
            trigger: 'blur',
          },
        ],
      },
    }
  },
  methods: {
    // 获取浏览器的宽度和高度
    GetWindowInfo() {
      this.LoginContainerSize.width = window.innerWidth + 'px'
      this.LoginContainerSize.height = window.innerHeight + 'px'
    },
    // 登陆
    login() {
      this.$refs.loginFormRef.validate(async (valid) => {
        if (!valid) {
          return this.$message.error('输入的信息不合法')
        } else {
          const { data: res } = await this.$http.post('/login', this.loginForm)
          if (res.status == 200){
            this.$message.success(res.message)
            window.sessionStorage.setItem('token', res.data.token)
            this.$router.push('/home')
          }else {
            this.$message.error(res.message)
          }
          // if (res.meta.status == 200) {
          //   this.$message.success(res.meta.msg)
          //   window.sessionStorage.setItem('token', res.data.token)
          //   this.$router.push('/home')
          // } else {
          //   this.$message.error(res.meta.msg)
          // }
        }
      })
    },
    // 重置表单
    resetLoginForm() {
      this.$refs.loginFormRef.resetFields()
    },
  },
  created() {
    window.addEventListener('resize', this.GetWindowInfo) //注册监听器
    this.GetWindowInfo() // 页面创建时先调用一次
  },
  destroyed() {
    window.removeEventListener('resize', this.GetWindowInfo)
  },
}
</script>

<style lang="scss" scoped>

.login_container {
  .login_img {
    position: absolute;
    z-index: -1;
  }
  .login {
    width: 50%;
    height: 360px;
    background: #ffffff;
    border-radius: 5px;
    position: relative;
    top: 50%;
    left: 50%;
    transform: translate(-50%, -50%);
    padding: 0px;
    .login_row {
      .login_left {
        img {
          width: 100%;
          height: 360px;
        }
      }
      .login_right {
        padding: 40px;
        height: 360px;
        box-sizing: border-box;
        .login_right_top {
          padding: 18px 20px;
          border-bottom: 1px solid #ebeef5;
          font-size: 24px;
          font-weight: 700;
          text-align: center;
          box-sizing: border-box;
        }
        .btn_box {
          display: flex;
          justify-content: space-between;
        }
      }
    }
  }
}
</style>


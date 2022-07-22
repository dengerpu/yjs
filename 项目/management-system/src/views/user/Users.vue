<template>
  <div>
    <el-card>
      <el-breadcrumb separator-class="el-icon-arrow-right">
        <el-breadcrumb-item :to="{ path: '/home' }">首页</el-breadcrumb-item>
        <el-breadcrumb-item>用户管理</el-breadcrumb-item>
        <el-breadcrumb-item>用户列表</el-breadcrumb-item>
      </el-breadcrumb>
      <!-- 搜索与添加区域 -->
      <el-row :gutter="20">
        <el-col :span="6">
          <el-input
            placeholder="请输入内容"
            class="input-with-select"
            clearable
            v-model="queryInfo.query"
            @clear="getUserList"
          >
            <el-button
              slot="append"
              icon="el-icon-search"
              @click="getUserList"
            ></el-button>
          </el-input>
        </el-col>
        <el-col :span="4"
          ><el-button type="primary" @click="showAddAialog()"
            >添加用户</el-button
          ></el-col
        >
      </el-row>
      <!-- 表格区域 -->
      <el-table :data="userList" border stripe style="width: 100%">
        <el-table-column type="index"></el-table-column>
        <el-table-column prop="username" label="用户名"></el-table-column>
        <el-table-column prop="mobile" label="手机"></el-table-column>
        <el-table-column prop="email" label="邮箱"></el-table-column>
        <el-table-column prop="roleName" label="权限"></el-table-column>
        <el-table-column label="状态">
          <template slot-scope="scope">
            <el-switch
              v-model="scope.row.state"
              @change="userStateChange(scope.row)"
            ></el-switch>
          </template>
        </el-table-column>
        <el-table-column label="操作" width="180px">
          <template slot-scope="scope">
            <el-button
              type="primary"
              icon="el-icon-edit"
              size="mini"
              @click="editUser(scope.row.id)"
            ></el-button>
            <el-button
              type="danger"
              icon="el-icon-delete"
              size="mini"
              @click="deleteUser(scope.row.id)"
            ></el-button>
            <el-tooltip
              effect="dark"
              content="分配角色"
              placement="top"
              :enterable="false"
            >
              <el-button
                type="warning"
                icon="el-icon-setting"
                size="mini"
                @click="setRole(scope.row)"
              ></el-button>
            </el-tooltip>
          </template>
        </el-table-column>
      </el-table>
      <!-- 分页 -->
      <el-pagination
        @size-change="handleSizeChange"
        @current-change="handleCurrentChange"
        :current-page="queryInfo.pagenum"
        :page-sizes="[1, 2, 5, 10]"
        :page-size="queryInfo.pagesize"
        layout="total, sizes, prev, pager, next, jumper"
        :total="total"
      >
      </el-pagination>

      <!-- 添加用户对话框 -->
      <el-dialog
        title="添加用户"
        :visible.sync="addDialogVisible"
        width="50%"
        @close="closeAddDialog"
      >
        <el-form
          :model="addUserForm"
          :rules="addUserRules"
          ref="addUserFormRef"
          label-width="100px"
          class="demo-ruleForm"
        >
          <el-form-item label="用户名" prop="username">
            <el-input v-model="addUserForm.username"></el-input>
          </el-form-item>
          <el-form-item label="密码" prop="password">
            <el-input v-model="addUserForm.password"></el-input>
          </el-form-item>
          <el-form-item label="邮箱" prop="email">
            <el-input v-model="addUserForm.email"></el-input>
          </el-form-item>
          <el-form-item label="手机号" prop="mobile">
            <el-input v-model="addUserForm.mobile"></el-input>
          </el-form-item>
        </el-form>
        <span slot="footer" class="dialog-footer">
          <el-button @click="addDialogVisible = false">取 消</el-button>
          <el-button type="primary" @click="addUser">确 定</el-button>
        </span>
      </el-dialog>

      <!-- 修改用户的对话框 -->
      <el-dialog title="修改用户" destroy-on-close :visible.sync="editDialogVisible" width="50%">
        <el-form
          :model="editUserForm"
          :rules="addUserRules"
          ref="editUserFormRef"
          label-width="100px"
          class="demo-ruleForm"
        >
          <el-form-item label="用户名" prop="username">
            <el-input v-model="editUserForm.username" disabled></el-input>
          </el-form-item>
          <el-form-item label="邮箱" prop="email">
            <el-input v-model="editUserForm.email"></el-input>
          </el-form-item>
          <el-form-item label="手机号" prop="mobile" >
            <el-input v-model="editUserForm.mobile"></el-input>
          </el-form-item>
        </el-form>
        <span slot="footer" class="dialog-footer">
          <el-button @click="closeEditUserDialog">取 消</el-button>
          <el-button type="primary" @click="editUserCommit">确 定</el-button>
        </span>
      </el-dialog>

      <!-- 分配角色对话框 -->
      <el-dialog
        title="分配角色"
        :visible.sync="setRoledialogVisible"
        width="30%"
        @close="closeSetRole()"
      >
        <p>当前用户：{{ userinfo.username }}</p>
        <p>当前角色：{{ userinfo.roleName }}</p>
        <p>
          分配新角色：<el-select v-model="selectRoleId" placeholder="请选择">
            <el-option
              v-for="item in roleslist"
              :key="item.roleId"
              :label="item.roleName"
              :value="item.roleId"
            >
            </el-option>
          </el-select>
        </p>
        <span slot="footer" class="dialog-footer">
          <el-button @click="setRoledialogVisible = false">取 消</el-button>
          <el-button type="primary" @click="saveSetRole()">确 定</el-button>
        </span>
      </el-dialog>
    </el-card>
  </div>
</template>

<script>
export default {
  name: 'Users',
  created() {
    this.getUserList()
  },
  data() {
    // 验证邮箱的规则
    var checkEmail = (rule, value, callback) => {
      // 验证邮箱的正则表达式
      const regEmail = /^\w+([-+.]\w+)*@\w+([-.]\w+)*\.\w+([-.]\w+)*$/
      if (regEmail.test(value)) {
        return callback()
      } else {
        return callback(new Error('请输入合法的邮箱'))
      }
    }
    // 验证手机的规则
    var checkPhone = (rule, value, callback) => {
      // 验证手机的正则表达式
      const regPhone =
        /^(13[0-9]|14[01456879]|15[0-35-9]|16[2567]|17[0-8]|18[0-9]|19[0-35-9])\d{8}$/
      if (regPhone.test(value)) {
        return callback()
      } else {
        return callback(new Error('请输入合法的手机号'))
      }
    }

    return {
      // 查询信息
      queryInfo: {
        query: '',
        pagenum: 1,
        pagesize: 5,
      },
      userList: [], // 用户信息
      total: 0,
      addUserForm: {
        // 添加用户的信息
        username: '',
        password: '',
        email: '',
        mobile: '',
      },
      editUserForm: {
        // 修改用户的信息
        username: '',
        password: '',
        email: '',
        mobile: '',
      },
      userinfo: {}, // 用户信息
      roleslist: [], // 所有角色信息
      selectRoleId: '', // 选中的角色id值
      addDialogVisible: false,
      editDialogVisible: false,
      setRoledialogVisible: false,
      addUserRules: {
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
          { required: true, message: '请输入密码', trigger: 'change' },
          {
            min: 6,
            max: 18,
            message: '长度在 6 到 18 个字符',
            trigger: 'blur',
          },
        ],
        email: [
          { required: true, message: '请输入邮箱', trigger: 'blur' },
          { validator: checkEmail, trigger: 'blur' },
        ],
        mobile: [
          { required: true, message: '请输入手机号', trigger: 'blur' },
          { validator: checkPhone, trigger: 'blur' },
        ],
      },
    }
  },
  methods: {
    // 获取用户列表数据
    async getUserList() {
      const { data: res } = await this.$http.get('users', {
        params: this.queryInfo,
      })
      //console.log(res);
      if (res.status == 200) {
        this.userList = res.data.records;
        this.total = res.data.total
      } else {
        this.$message.error(res.meta.msg)
      }
    },
    // 分页大小发生变化
    handleSizeChange(newSize) {
      this.queryInfo.pagesize = newSize
      this.getUserList()
    },
    // 监听 页码的变化
    handleCurrentChange(newPage) {
      this.queryInfo.pagenum = newPage
      this.getUserList()
    },
    // 用户状态发生改变
    async userStateChange(userinfo) {
      const { data: res } = await this.$http.put(
        `users/${userinfo.id}/state/${userinfo.state}`
      )
      if (res.status == 201) {
        this.$message.success('更新用户状态成功')
      } else {
        userinfo.state = !userinfo.state
        this.$message.error('更新用户状态失败')
      }
    },
    // 控制添加用户对话框的显示与隐藏
    showAddAialog() {
      this.addDialogVisible = true
    },
    // 添加用户对话框关闭事件
    closeAddDialog() {
      this.$refs.addUserFormRef.resetFields()
    },
    // 添加用户
    addUser() {
      this.$refs.addUserFormRef.validate(async (valid) => {
        if (!valid) return
        const { data: res } = await this.$http.post('/users', this.addUserForm)
        if (res.status == 201) {
          this.$message.success(res.message)
          this.getUserList()
          this.addDialogVisible = false
        } else {
          this.$message.error(res.message)
        }
      })
    },
    // 修改用户，先查询用户信息
    async editUser(id) {
      const { data: res } = await this.$http.get(`/users/${id}`)
      if (res.status != 201) return this.$message.error(res.message)
      //console.log(res.data)
      this.editUserForm = res.data
      this.editDialogVisible = true
    },
    closeEditUserDialog() {
      this.$refs.editUserFormRef.resetFields()
      this.editDialogVisible = false
    },
    // 修改用户，提交用户信息
    editUserCommit() {
      this.$refs.editUserFormRef.validate(async (valid) => {
        if (!valid) return
        const { data: res } = await this.$http.put(
          `users/${this.editUserForm.id}`,
          this.editUserForm
        )
        if (res.status == 201) {
          this.$message.success(res.message)
          this.getUserList()
          this.editDialogVisible = false
        } else {
          this.$message.error(res.message)
        }
      })
    },
    // 删除用户
    deleteUser(id) {
      this.$confirm('此操作将永久删除该用户, 是否继续?', '提示', {
        confirmButtonText: '确定',
        cancelButtonText: '取消',
        type: 'warning',
        center: true,
      })
        .then(async () => {
          const { data: res } = await this.$http.delete('users/' + id)
          if (res.status == 204) {
            this.$message.success(res.message)
            this.getUserList()
          } else {
            this.$message.error(res.message)
          }
        })
        .catch(() => {
          this.$message({
            type: 'info',
            message: '已取消删除',
          })
        })
    },
    // 展示和获取分配角色
    async setRole(userinfo) {
      this.userinfo = userinfo
      // 在对话框展示之前，获取所有的角色列表
      const { data: res } = await this.$http.get('/roles')
      if (res.status == 200) {
        // this.$message.success(res.meta.msg)
        this.roleslist = res.data
      } else {
        this.$message.error(res.message)
      }
      console.log(res)
      this.setRoledialogVisible = true
    },
    // 点击确定，分配角色
    async saveSetRole() {
      const { data: res } = await this.$http.put(
        `users/${this.userinfo.id}/role`,
        {
          rid: this.selectRoleId,
        }
      )
      if (res.status == 201) {
        this.$message.success(res.message)
        this.getUserList()
        this.setRoledialogVisible = false
      } else {
        this.$message.error(res.message)
      }
    },
    // 分配角色对话框，关闭事件
    closeSetRole() {
      this.userinfo = {}
      this.selectRoleId = ''
    },
  },
}
</script>

<style lang="scss" scoped>
.el-card {
  padding: 20px;
}
</style>
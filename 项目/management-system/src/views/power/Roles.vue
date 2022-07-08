<template>
  <el-card>
    <el-breadcrumb separator-class="el-icon-arrow-right">
      <el-breadcrumb-item :to="{ path: '/home' }">首页</el-breadcrumb-item>
      <el-breadcrumb-item>权限管理</el-breadcrumb-item>
      <el-breadcrumb-item>角色列表</el-breadcrumb-item>
    </el-breadcrumb>
    <el-table :data="rolesList" border stripe style="width: 100%">
      <el-table-column type="expand">
        <template slot-scope="scope">
          <el-row
            :class="['bdbottom', i1 == 0 ? 'bdtop' : '', 'vcenter']"
            v-for="(item1, i1) in scope.row.children"
            :key="item1.id"
          >
            <el-col :span="5">
              <el-tag closable @close="removeRoles(scope.row, item1.id)">{{
                item1.authName
              }}</el-tag>
              <i class="el-icon-caret-right"></i>
            </el-col>
            <el-col :span="19">
              <el-row
                :class="[i2 == 0 ? '' : 'bdtop', 'vcenter']"
                v-for="(item2, i2) in item1.children"
                :key="item2.id"
              >
                <el-col :span="6">
                  <el-tag
                    closable
                    type="success"
                    @close="removeRoles(scope.row, item2.id)"
                    >{{ item2.authName }}</el-tag
                  >
                  <i class="el-icon-caret-right"></i>
                </el-col>
                <el-col :span="18">
                  <el-tag
                    closable
                    type="warning"
                    v-for="(item3, i3) in item2.children"
                    :key="item3.id"
                    @close="removeRoles(scope.row, item3.id)"
                    >{{ item3.authName }}</el-tag
                  >
                </el-col>
              </el-row>
            </el-col>
          </el-row>
        </template>
      </el-table-column>
      <el-table-column type="index"></el-table-column>
      <el-table-column prop="roleName" label="角色名称"></el-table-column>
      <el-table-column prop="roleDesc" label="角色描述"></el-table-column>
      <el-table-column label="操作">
        <template slot-scope="scope">
          <el-button type="primary" icon="el-icon-edit" size="mini"
            >编辑</el-button
          >
          <el-button type="danger" icon="el-icon-delete" size="mini"
            >删除</el-button
          >
          <el-button
            type="warning"
            icon="el-icon-setting"
            size="mini"
            @click="setRole(scope.row)"
            >分配角色</el-button
          >
        </template>
      </el-table-column>
    </el-table>

    <!-- 分配权限弹框 -->
    <el-dialog title="提示" :visible.sync="setRightdialogVisible" width="30%">
      <el-tree
        show-checkbox
        default-expand-all
        node-key="id"
        ref="treeRef"
        :default-checked-keys="defKeys"
        :data="rightslist"
        :props="treeProps"
      ></el-tree>
      <span slot="footer" class="dialog-footer">
        <el-button @click="setRightdialogVisible = false">取 消</el-button>
        <el-button type="primary" @click="allotRights">确 定</el-button>
      </span>
    </el-dialog>
  </el-card>
</template>

<script>
export default {
  name: 'Roles',
  created() {
    this.getRolesList()
  },
  data() {
    return {
      rolesList: [],
      setRightdialogVisible: false,
      rightslist: [],
      treeProps: {
        // 树形控件的属性绑定对象
        label: 'authName',
        children: 'children',
      },
      defKeys: [], // 三级结点
      roleId: '', // 当前分配角色的id
    }
  },
  methods: {
    // 获取角色列表
    async getRolesList() {
      const { data: res } = await this.$http.get('roles')
      if (res.meta.status == 200) {
        this.rolesList = res.data
      } else {
        this.$message.error(res.meta.msg)
      }
    },
    // 删除角色对应的权限
    async removeRoles(role, rightId) {
      const confirmResult = await this.$confirm(
        '此操作将永久删除该权限, 是否继续?',
        '提示',
        {
          confirmButtonText: '确定',
          cancelButtonText: '取消',
          type: 'warning',
        }
      ).catch((err) => err)
      if (confirmResult != 'confirm') {
        return this.$message.info('取消了删除')
      }
      const { data: res } = await this.$http.delete(
        `roles/${role.id}/rights/${rightId}`
      )
      if (res.meta.status == 200) {
        this.$message.success(res.meta.msg)
        role.children = res.data
      } else {
        this.$message.error(res.meta.msg)
      }
    },
    async setRole(role) {
      this.defKeys = []
      const { data: res } = await this.$http.get('rights/tree')
      if (res.meta.status == 200) {
        this.$message.success(res.meta.msg)
        this.rightslist = res.data
      } else {
        this.$message.error(res.meta.msg)
      }
      // 获取所有的三级结点
      this.getLeafKeys(role, this.defKeys)
      // console.log(this.defKeys)
      this.roleId = role.id
      this.setRightdialogVisible = true
    },
    // 通过递归形式，获取角色下所有三级权限的id,并保存到defKeys数组中
    getLeafKeys(node, arr) {
      // 如果当前node节点不包含children属性，则是三级结点
      if (!node.children) {
        return arr.push(node.id)
      }
      node.children.forEach((item) => {
        this.getLeafKeys(item, arr)
      })
    },
    async allotRights() {
      const keys = [
        ...this.$refs.treeRef.getCheckedKeys(),
        ...this.$refs.treeRef.getHalfCheckedKeys(),
      ]
      const idStr = keys.join(',')
      const { data: res } = await this.$http.post(
        `roles/${this.roleId}/rights`,
        { rids: idStr }
      )
      if (res.meta.status == 200) {
        this.$message.success(res.meta.msg)
        this.getRolesList()
        this.setRightdialogVisible = false
      } else {
        this.$message.error(res.meta.msg)
      }
    },
  },
}
</script>

<style lang="scss" scoped>
.el-card {
  padding: 20px;
}
.el-tag {
  margin: 7px;
}
.bdtop {
  border-top: 1px solid #eee;
}
.bdbottom {
  border-bottom: 1px solid #eee;
}
.vcenter {
  display: flex;
  align-items: center;
}
</style>
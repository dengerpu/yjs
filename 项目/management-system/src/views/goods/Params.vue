<template>
  <el-card>
    <el-breadcrumb separator-class="el-icon-arrow-right">
      <el-breadcrumb-item :to="{ path: '/home' }">首页</el-breadcrumb-item>
      <el-breadcrumb-item>商品管理</el-breadcrumb-item>
      <el-breadcrumb-item>分类参数</el-breadcrumb-item>
    </el-breadcrumb>
    <el-row>
      <el-col :span="4"
        ><el-button type="primary" @click="exportAll"
          >导出全部</el-button
        ></el-col
      >
    </el-row>
    <el-table
      id="userInfo"
      :data="tableData"
      border
      style="width: 100%"
      :default-sort="{ prop: 'date', order: 'descending' }"
    >
      <el-table-column type="selection"> </el-table-column>
      <el-table-column type="index"></el-table-column>
      <el-table-column prop="date" label="日期" sortable> </el-table-column>
      <el-table-column prop="name" label="姓名" sortable> </el-table-column>
      <el-table-column prop="address" label="地址"> </el-table-column>
    </el-table>
  </el-card>
</template>

<script>
import FileSaver from 'file-saver'
import * as XLSX from 'xlsx'
export default {
  name: 'Params',
  data() {
    return {
      tableData: [
        {
          date: '2016-05-02',
          name: '王小虎',
          address: '上海市普陀区金沙江路 1518 弄',
        },
        {
          date: '2016-05-04',
          name: '王小虎',
          address: '上海市普陀区金沙江路 1517 弄',
        },
        {
          date: '2016-05-01',
          name: '王小虎',
          address: '上海市普陀区金沙江路 1519 弄',
        },
        {
          date: '2016-05-03',
          name: '王小虎',
          address: '上海市普陀区金沙江路 1516 弄',
        },
      ],
    }
  },
  methods: {
    // 导出全部行函数
    exportExcelAll() {
      var xlsxParam = { raw: true } // 导出的内容只做解析，不进行格式转换
      var table = document.querySelector('#userInfo').cloneNode(true)
      // table.removeChild(table.querySelector('.el-table__fixed')) //这里是双下划线
      var wb = XLSX.utils.table_to_book(table, xlsxParam)
      /* get binary string as output */
      var wbout = XLSX.write(wb, {
        bookType: 'xlsx',
        bookSST: true,
        type: 'array',
      })
      try {
        FileSaver.saveAs(
          new Blob([wbout], { type: 'application/octet-stream' }),
          'fileName.xlsx'
        )
      } catch (e) {
        if (typeof console !== 'undefined') {
          console.log(e, wbout)
        }
      }
      return wbout
    },
    exportAll() {
      this.exportExcelAll()
    },
  },
}
</script>

<style lang="scss" scoped>
.el-card {
  padding: 20px;
}
</style>
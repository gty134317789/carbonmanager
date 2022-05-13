
<style scoped>

</style>

<template>
  <div style="margin-top: 60px;margin-left:80px;border: 0px solid red;" >

    <el-table
      :data="tableData"
      border
      stripe
      style="width: 100%">
      <el-table-column
        prop="managerID"
        label="用户编号"
        width="100">
      </el-table-column>
      <el-table-column
        prop="managerName"
        label="用户姓名"
        width="100">
      </el-table-column>
      <el-table-column
        prop="managerDepartment"
        label="负责部门"
        width="200">
      </el-table-column>
      <el-table-column
        prop="managerPhone"
        label="部门电话"
        width="120">
      </el-table-column>
      <el-table-column
        prop="managerFunds"
        label="部门经费"
        width="200">
      </el-table-column>

      <el-table-column label="操作">
        <template slot-scope="scope">
          <el-button
            size="mini"
            @click="edit(scope.row)">编辑</el-button>
          <el-button
            size="mini"
            type="danger"
            @click="del(scope.row)">删除</el-button>
        </template>
      </el-table-column>
    </el-table>
  </div>
</template>

<script>
const axios = require('axios');
export default {
  name: "ProductManage",
  created() {
    const _this = this
    axios.get('http://localhost:8181/manager/List').then(function (resp) {
      console.log(resp)
      _this.tableData = resp.data
    })
  },
  data(){
    return{
      tableData: null
    }
  }

}
</script>

<style scoped>

</style>

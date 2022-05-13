
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
        prop="companyCode"
        label="企业代码"
        width="100">
      </el-table-column>
      <el-table-column
        prop="companyManager"
        label="公司管理员"
        width="150">
      </el-table-column>
      <el-table-column
        prop="companyAddress"
        label="公司地址"
        width="200">
      </el-table-column>
      <el-table-column
        prop="companyIndustry"
        label="所属行业"
        width="120">
      </el-table-column>
      <el-table-column
        prop="companyPhone"
        label="联系电话"
        width="200">
      </el-table-column>
      <el-table-column
        prop="isUpToStandard"
        label="碳排放是否达标"
        width="150">
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
    axios.get('http://localhost:8181/company/List').then(function (resp) {
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

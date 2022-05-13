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
    <el-pagination style="margin-top: 20px;float: right"
                   background
                   layout="prev, pager, next"
                   :page-size="pageSize"
                   :total="total"
                   :current-page.sync="currentPage"
                   @current-change="page">
    </el-pagination>
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
      _this.total = resp.data.total
    })
  },
  data(){
    return{
      tableData: '',
      pageSize: 5,
      total: 100,
      currentPage: 1
    }
  },
  methods:{
    page(currentPage){
      const _this = this
      axios.get('http://localhost:8181/company/List/'+currentPage+'/'+this.pageSize).then(function (resp) {
        _this.tableData = resp.data.data
        _this.total = resp.data.total
      })
    },
    edit(rows){
      this.$router.push('/update?id='+rows.id)
    },
    del(rows){
      const _this = this
      this.$confirm('确认删除【'+rows.name+'】吗？', '提示', {
        confirmButtonText: '确定',
        cancelButtonText: '取消',
        type: 'warning'
      }).then(() => {
        axios.delete('http://localhost:8181/product/delete/'+rows.id).then(function (resp) {
          if(resp.data){
            _this.$alert('【'+rows.name+'】已删除', '', {
              confirmButtonText: '确定',
              callback: action => {
                location.reload()
              }
            });
          }
        });
      }).catch(() => {
        this.$message({
          type: 'info',
          message: '已取消删除'
        });
      });
    }
  }

}
</script>


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
        prop="managerid"
        label="用户编号"
        width="100">
      </el-table-column>
      <el-table-column
        prop="managername"
        label="用户姓名"
        width="100">
      </el-table-column>
      <el-table-column
        prop="managerdepartment"
        label="负责部门"
        width="200">
      </el-table-column>
      <el-table-column
        prop="managerphone"
        label="部门电话"
        width="120">
      </el-table-column>
      <el-table-column
        prop="managerfunds"
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
  name: "UserManage",
  created() {
    const _this = this
    axios.get('http://localhost:8181/manager/list/1/'+this.pageSize).then(function (resp) {
      console.log(resp.data)
      _this.tableData=resp.data.data
      _this.total=resp.data.total
    })
  },
  data(){
    return{
      tableData: '',
      pageSize: 5,
      total: 100,
      currentPage: 1,
      search:'',
    }
  },

  methods:{
    page(currentPage){
      const _this = this
      axios.get('http://localhost:8181/manager/list/'+currentPage+'/'+this.pageSize).then(function (resp) {
        _this.tableData=resp.data.data
        _this.total=resp.data.total
      })
    },
    edit(row){
      //console.log(row)
      //console.log(row.managerid)
      this.$router.push('/updateuser?id='+row.managerid)
    },
    del(rows){
      //console.log(rows)
      const _this = this
      this.$confirm('确认删除【生产编号'+rows.managerid+'】吗？', '提示', {
        confirmButtonText: '确定',
        cancelButtonText: '取消',
        type: 'warning'
      }).then(() => {
        axios.delete('http://localhost:8181/manager/delete/'+rows.managerid).then(function (resp) {
          if(resp.data){
            _this.$alert('【生产编号'+rows.managerid+'】已删除', '', {
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
    },

  }

}
</script>

<style scoped>

</style>

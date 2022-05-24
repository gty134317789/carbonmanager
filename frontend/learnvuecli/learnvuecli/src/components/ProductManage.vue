<template>
    <div style="margin-top: 60px;margin-left:80px;border: 0px solid red;" >
        <el-table
                :data="tableData.filter(data => !search || data.productName.toLowerCase().includes(search.toLowerCase()))"
                border
                stripe
                style="width: 100%">
            <el-table-column
                    prop="productNum"
                    label="生产编号"
                    width="100">
            </el-table-column>
            <el-table-column
                    prop="companyCode"
                    label="生产公司代码"
                    width="120">
            </el-table-column>
            <el-table-column
                    prop="productName"
                    label="生产项目名"
                    width="100">
            </el-table-column>
            <el-table-column
                    prop="beginDate"
                    label="生产开始日期"
                    width="120">
            </el-table-column>
            <el-table-column
                    prop="endDate"
                    label="生产结束日期"
                    width="120">
            </el-table-column>
            <el-table-column
                    prop="cost"
                    label="生产成本(元)"
                    width="120">
            </el-table-column>
            <el-table-column
                    prop="carbonEmission"
                    label="总碳排放量(吨)"
                    width="120">
            </el-table-column>
            <el-table-column
                    prop="yield"
                    label="产量(吨)"
                    width="100">
            </el-table-column>
            <el-table-column
              prop="notes"
              label="备注"
              width="200">
            </el-table-column>

            <el-table-column label="操作"
                align="right">
                <template slot="header" slot-scope="scope">
                  <el-input
                    v-model="search"
                    size="mini"
                    placeholder="输入关键字搜索"/>
                </template>

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
          axios.get('http://localhost:8181/production/list/1/'+this.pageSize).then(function (resp) {
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
              axios.get('http://localhost:8181/production/list/'+currentPage+'/'+this.pageSize).then(function (resp) {
                _this.tableData=resp.data.data
                _this.total=resp.data.total
                })
            },
            edit(row){
                // console.log(row)
                // console.log(row.productNum)
                this.$router.push('/updateproduction?id='+row.productNum)
            },
            del(rows){
                //console.log(rows)
                const _this = this
                this.$confirm('确认删除【生产编号'+rows.productNum+'】吗？', '提示', {
                    confirmButtonText: '确定',
                    cancelButtonText: '取消',
                    type: 'warning'
                }).then(() => {
                    axios.delete('http://localhost:8181/production/delete/'+rows.productNum).then(function (resp) {
                        if(resp.data){
                            _this.$alert('【生产编号'+rows.productNum+'】已删除', '', {
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

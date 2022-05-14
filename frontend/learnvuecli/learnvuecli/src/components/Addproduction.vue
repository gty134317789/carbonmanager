<template>
  <div style="margin-top: 60px;margin-left:80px;width: 600px" >
    <el-form :model="ruleForm" :rules="rules" ref="ruleForm" label-width="120px" class="demo-ruleForm">

      <el-form-item label="生产编号" prop="ProductNum">
        <el-input   v-model="ruleForm.ProductNum" ></el-input>
      </el-form-item>

      <el-form-item label="生产公司代码" prop="CompanyCode">
        <el-input v-model="ruleForm.CompanyCode"></el-input>
      </el-form-item>

      <el-form-item label="生产项目名" prop="ProductName">
        <el-input v-model="ruleForm.ProductName"></el-input>
      </el-form-item>

      <el-form-item label="生产开始日期" prop="BeginDate"
                    :rules="[
    { required: true, message: '生产开始日期不能为空'},
  ]"
      >
        <el-date-picker
          v-model="ruleForm.BeginDate"
          type="date"
          placeholder="选择生产开始日期"
          format="yyyy 年 MM 月 dd 日"
          value-format="yyyy-MM-dd">
          style="200px"
        </el-date-picker
      >
      </el-form-item>

      <el-form-item label="生产结束日期" prop="EndDate"
                    :rules="[
    { required: true, message: '生产结束日期不能为空'},
  ]"
      >
        <el-date-picker
          v-model="ruleForm.EndDate"
          type="date"
          placeholder="选择生产结束日期"
          format="yyyy 年 MM 月 dd 日"
          value-format="yyyy-MM-dd">
          style="200px"
        </el-date-picker
        >
      </el-form-item>

      <el-form-item label="生产成本(元)" prop="Cost"
                    :rules="[
    { required: true, message: '生产成本不能为空'},
    { type: 'number', message: '生产成本必须为数字值'}
  ]"
      >
        <el-input v-model.number="ruleForm.Cost"></el-input>
      </el-form-item>

      <el-form-item label="总碳排放量(吨)" prop="CarbonEmission"
                    :rules="[
    { required: true, message: '总碳排放量不能为空'},
    { type: 'number', message: '总碳排放量必须为数字值'}
  ]"
      >
        <el-input v-model.number="ruleForm.CarbonEmission"></el-input>
      </el-form-item>

      <el-form-item label="产量(吨)" prop="Yield"
                    :rules="[
    { required: true, message: '产量不能为空'},
    { type: 'number', message: '产量必须为数字值'}
  ]"
      >
        <el-input v-model.number="ruleForm.Yield"></el-input>
      </el-form-item>

      <el-form-item label="备注" prop="Notes">
        <el-input v-model="ruleForm.Notes"></el-input>
      </el-form-item>


      <el-form-item>
        <el-button type="primary" @click="submitForm('ruleForm')">立即创建</el-button>
        <el-button @click="resetForm('ruleForm')">重置</el-button>
      </el-form-item>
    </el-form>
  </div>
</template>

<script>
import  Qs from 'qs'
const axios = require('axios');
export default {
  name: "Add",
  data() {
    return {
      ruleForm: {
        ProductNum: '',
        CompanyCode: '',
        ProductName: '',
        BeginDate:'',
        EndDate:'',
        Cost:'',
        CarbonEmission:'',
        Yield:'',
        Notes:''
      },
      rules: {
        ProductNum: [
          {required: true, message: '生产编号不能为空',trigger: 'change' }
        ],
        CompanyCode: [
          {required: true, message: '生产公司代码不能为空',trigger: 'change' }
        ],
        ProductName: [
          { required: true, message: '生产项目名不能为空', trigger: 'change' }
        ]
      }
    };
  },

  methods: {
    submitForm(formName) {
      let _this = this
      console.log(_this.ruleForm)
      this.$refs[formName].validate((valid) => {
        if (valid) {
          axios.post('http://localhost:8181/production/save',_this.ruleForm).then(function (resp) {
            console.log(resp.data)
            if(resp.data){
              _this.$alert('【'+_this.ruleForm.ProductNum+'】添加成功', '', {
                confirmButtonText: '确定',
                callback: action => {
                  _this.$router.push('/')
                }
              });
            }
          })
        }
      });
    },
    resetForm(formName) {
      this.$refs[formName].resetFields();
    }
  }
}
</script>

<style scoped>

</style>

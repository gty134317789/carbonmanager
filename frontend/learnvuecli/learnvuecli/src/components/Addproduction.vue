<template>
  <div style="margin-top: 60px;margin-left:80px;width: 600px" >
    <el-form :model="ruleForm" :rules="rules" ref="ruleForm" label-width="120px" class="demo-ruleForm">

      <el-form-item label="生产编号" prop="productNum">
        <el-input   v-model="ruleForm.productNum" ></el-input>
      </el-form-item>

      <el-form-item label="生产公司代码" prop="companyCode">
        <el-input v-model="ruleForm.companyCode"></el-input>
      </el-form-item>

      <el-form-item label="生产项目名" prop="productName">
        <el-input v-model="ruleForm.productName"></el-input>
      </el-form-item>

      <el-form-item label="生产开始日期" prop="beginDate"
                    :rules="[
    { required: true, message: '生产开始日期不能为空'},
  ]"
      >
        <el-date-picker
          v-model="ruleForm.beginDate"
          type="date"
          placeholder="选择生产开始日期"
          format="yyyy 年 MM 月 dd 日"
          value-format="yyyy-MM-dd">
          style="200px"
        </el-date-picker
      >
      </el-form-item>

      <el-form-item label="生产结束日期" prop="endDate"
                    :rules="[
    { required: true, message: '生产结束日期不能为空'},
  ]"
      >
        <el-date-picker
          v-model="ruleForm.endDate"
          type="date"
          placeholder="选择生产结束日期"
          format="yyyy 年 MM 月 dd 日"
          value-format="yyyy-MM-dd">
          style="200px"
        </el-date-picker
        >
      </el-form-item>

      <el-form-item label="生产成本(元)" prop="cost"
                    :rules="[
    { required: true, message: '生产成本不能为空'},
    { type: 'number', message: '生产成本必须为数字值'}
  ]"
      >
        <el-input v-model.number="ruleForm.cost"></el-input>
      </el-form-item>

      <el-form-item label="总碳排放量(吨)" prop="carbonEmission"
                    :rules="[
    { required: true, message: '总碳排放量不能为空'},
    { type: 'number', message: '总碳排放量必须为数字值'}
  ]"
      >
        <el-input v-model.number="ruleForm.carbonEmission"></el-input>
      </el-form-item>

      <el-form-item label="产量(吨)" prop="yield"
                    :rules="[
    { required: true, message: '产量不能为空'},
    { type: 'number', message: '产量必须为数字值'}
  ]"
      >
        <el-input v-model.number="ruleForm.yield"></el-input>
      </el-form-item>

      <el-form-item label="备注" prop="notes">
        <el-input v-model="ruleForm.notes"></el-input>
      </el-form-item>


      <el-form-item>
        <el-button type="primary" @click="submitForm('ruleForm')">立即创建</el-button>
        <el-button @click="resetForm('ruleForm')">重置</el-button>
      </el-form-item>
    </el-form>
  </div>
</template>

<script>
const axios = require('axios');
export default {
  name: "Addproduction",
  data() {
    return {
      ruleForm: {
        productNum: '',
        companyCode: '',
        productName: '',
        beginDate:'',
        endDate:'',
        cost:'',
        carbonEmission:'',
        yield:'',
        notes:''
      },
      rules: {
        productNum: [
          {required: true, message: '生产编号不能为空',trigger: 'change' }
        ],
        companyCode: [
          {required: true, message: '生产公司代码不能为空',trigger: 'change' }
        ],
        productName: [
          { required: true, message: '生产项目名不能为空', trigger: 'change' }
        ]
      }
    };
  },

  methods: {
    submitForm(formName) {
      let _this = this
      // _this.$alert('公司代码不存在，请先添加企业', '', {
      //   confirmButtonText: '确定',
      //   callback: action => {
      //     _this.$router.push('/productmanager')
      //   }
      // });
      console.log(_this.ruleForm)
      this.$refs[formName].validate((valid) => {
        if (valid) {
          axios.post('http://42.192.207.238:8181/production/save',_this.ruleForm).then(function (resp) {
            console.log(resp.data)
            if(resp.data){
              _this.$alert('【'+_this.ruleForm.productNum+'】添加成功', '', {
                confirmButtonText: '确定',
                callback: action => {
                  _this.$router.push('/productmanager')
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

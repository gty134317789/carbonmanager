<template>
  <div style="margin-top: 60px;margin-left:80px;width: 600px" >
    <el-form :model="ruleForm" :rules="rules" ref="ruleForm" label-width="120px" class="demo-ruleForm">
      <el-form-item label="公司代码" prop="companyCode"
                    :rules="[
    { required: true, message: '公司代码不能为空'},
  ]">
        <el-input v-model="ruleForm.companyCode"></el-input>
      </el-form-item>

      <el-form-item label="公司管理员" prop="companyManager"
                    :rules="[
    { required: true, message: '公司管理员不能为空'},
  ]">
        <el-input v-model="ruleForm.companyManager"></el-input>
      </el-form-item>

      <el-form-item label="公司地址" prop="companyAddress"
                    :rules="[
    { required: true, message: '公司地址不能为空'},
  ]">
        <el-input v-model="ruleForm.companyAddress"></el-input>
      </el-form-item>

      <el-form-item label="所属行业" prop="companyIndustry"
                    :rules="[
    { required: true, message: '所属行业不能为空'},
  ]">
        <el-input v-model="ruleForm.companyIndustry"></el-input>
      </el-form-item>

      <el-form-item label="联系电话" prop="companyPhone"
                    :rules="[
    { required: true, message: '联系电话不能为空'},
  ]">
        <el-input v-model="ruleForm.companyPhone"></el-input>
      </el-form-item>

      <el-form-item label="碳排放是否达标" prop="isUpToStandard"
                    :rules="[
    { required: true, message: '碳排放是否达标不能为空'},
  ]">
        <el-input v-model="ruleForm.isUpToStandard"></el-input>
      </el-form-item>

      <el-form-item>
        <el-button type="primary" @click="submitForm('ruleForm')">立即更新</el-button>
        <el-button @click="resetForm('ruleForm')">重置</el-button>
      </el-form-item>
    </el-form>
  </div>
</template>

<script>
const axios = require('axios');
export default {
  name: "Updatecompany",
  data() {
    return {
      ruleForm: {
        companyCode: '',
        companyManager: '',
        companyAddress: '',
        companyIndustry: '',
        companyPhone:'',
        isUpToStandard:''
      },
      rules: {
        companyCode: [
          { required: true, message: '公司代码不能为空', trigger: 'change' }
        ],
        companyManager: [
          { required: true, message: '公司管理员不能为空', trigger: 'change' },
          { min: 3, max: 5, message: '长度在 3 到 5 个字符', trigger: 'blur' }
        ],

      },
    };
  },
  created() {
    let _this=this
    axios.get('http://42.192.207.238:8181/company/findById/'+this.$route.query.id).then(function (resp){
      console.log(resp.data)
      _this.ruleForm=resp.data
      console.log(_this.ruleForm)
    })
  },

  methods: {
    submitForm(formName) {
      let _this = this
      this.$refs[formName].validate((valid) => {
        if (valid) {
          axios.put('http://42.192.207.238:8181/company/update',_this.ruleForm).then(function (resp) {
            console.log(_this.resetForm())
            console.log(resp.data)
            if(resp.data){
              _this.$alert('【'+_this.ruleForm.companyCode+'】更新成功', '', {
                confirmButtonText: '确定',
                callback: action => {
                  _this.$router.push('/companymanager')
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

<template>
  <div style="margin-top: 60px;margin-left:80px;width: 600px" >
    <el-form :model="ruleForm" :rules="rules" ref="ruleForm" label-width="120px" class="demo-ruleForm">
      <el-form-item label="用户编号" prop="managerid"
                    :rules="[
    { required: true, message: '用户编号不能为空'},
  ]">
        <el-input v-model="ruleForm.managerid"></el-input>
      </el-form-item>

      <el-form-item label="用户姓名" prop="managername"
                    :rules="[
    { required: true, message: '用户姓名不能为空'},
  ]">
        <el-input v-model="ruleForm.managername"></el-input>
      </el-form-item>

      <el-form-item label="负责部门" prop="managerdepartment"
                    :rules="[
    { required: true, message: '负责部门名不能为空'},
  ]">
        <el-input v-model="ruleForm.managerdepartment"></el-input>
      </el-form-item>

      <el-form-item label="部门电话" prop="managerphone"
                    :rules="[
    { required: true, message: '部门电话不能为空'},
  ]">
        <el-input v-model="ruleForm.managerphone"></el-input>
      </el-form-item>

      <el-form-item label="部门经费" prop="managerfunds"
                    :rules="[
    { required: true, message: '部门经费不能为空'},
    // { type: 'number', message: '部门经费必须为数字值'}
  ]">
        <el-input v-model="ruleForm.managerfunds"></el-input>
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
  name: "Updateuser",
  data() {
    return {
      ruleForm: {
        managerid: '',
        managername: '',
        managerdepartment: '',
        managerphone: '',
        managerfunds:'',
      },
      rules: {

      },
    };
  },
  created() {
    let _this=this
    axios.get('http://localhost:8181/manager/findById/'+this.$route.query.id).then(function (resp){
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
          axios.put('http://localhost:8181/manager/update',_this.ruleForm).then(function (resp) {
            console.log(resp.data)
            if(resp.data){
              _this.$alert('【'+_this.ruleForm.managerid+'】更新成功', '', {
                confirmButtonText: '确定',
                callback: action => {
                  _this.$router.push('/usermanager')
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

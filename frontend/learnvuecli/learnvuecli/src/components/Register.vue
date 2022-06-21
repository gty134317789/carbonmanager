
<template>
  <div  class="login-container" >

    <el-form
      :model="ruleForm2"
      :rules="rules2"
      status-icon
      ref="ruleForm2"
      label-position="left"
      class="demo-ruleForm login-page"
    >
      <h3 class="title">企业碳排放管理系统</h3>

      <el-form-item label="用户名" prop="username" label-width="80px"
        :rules="[
        { required: true, message: '用户名不能为空'} ]">
        <el-input
          type="text"
          v-model="ruleForm2.username"
          auto-complete="off"
          placeholder="用户名"
        ></el-input>
      </el-form-item>


      <el-form-item label="密码" prop="password" label-width="80px"
                    :rules="[
        { required: true, message: '密码不能为空'} ]">
        <el-input
          type="password"
          v-model="ruleForm2.password"
          auto-complete="off"
          placeholder="密码"
        ></el-input>

      </el-form-item>
      <el-form-item label="真实姓名" prop="truename" label-width="80px"
                    :rules="[
        { required: true, message: '真实姓名不能为空'} ]">
        <el-input
          type="text"
          v-model="ruleForm2.truename"
          auto-complete="off"
          placeholder="真实姓名"
        ></el-input>
      </el-form-item>

      <el-form-item label="证件号" prop="papers" label-width="80px"
                                    :rules="[
        { required: true, message: '证件号不能为空'} ]">
      <el-input
        type="text"
        v-model="ruleForm2.papers"
        auto-complete="off"
        placeholder="证件号"
      ></el-input>
    </el-form-item>

      <el-form-item style="width: 100%">
        <el-button type="primary" plain style="width: 100%" @click="handleSubmit" :loading="logining">已有账号，去登录</el-button>
      </el-form-item>
      <el-form-item style="width: 100%">
        <el-button type="primary" plain style="width: 100%" @click="regisiter" :loading="logining">注册</el-button>
      </el-form-item>
    </el-form>

    <!--    <el-carousel :interval="3000" type="card" height="300px">-->
    <!--      <el-carousel-item v-for="item in picture" :key="item">-->
    <!--        <img :src="item.url" alt="" />-->
    <!--      </el-carousel-item>-->
    <!--    </el-carousel>-->

  </div>
</template>

<script>
export default {
  data() {
    return {
      logining: false,
      ruleForm2: {
        username: "admin",
        password: "123456",
        truename:"",
        papers:""
      },
      rules2: {
        username: [
          {
            required: true,
            message: "请输入您的账号",
            trigger: "blur",
          },
        ],
        password: [
          { required: true, message: "请输入您的密码", trigger: "blur" },
        ],
      },
    };
  },
  methods: {
    regisiter(){
      this.$alert('【'+this.ruleForm2.username+'】注册成功', '', {
          confirmButtonText: '确定',
      });
      this.$router.push({path: '/login'});
    },
    handleSubmit(){
      this.$router.push({path: '/login'});
    }
  },
};
</script>

<style scoped>



.login-container {
  padding: 0px;
  background-size: 100%;
  height: 100%;
  width: 100%;
  position:fixed;
  margin-top: -60px;/*上边距*/
  margin-left: 0px;/*左边距*/
  background: url("../assets/img.png") no-repeat;
  background-size: cover;

}

.login-page {
  -webkit-border-radius: 5px;
  border-radius: 5px;
  margin: 180px auto;
  width: 350px;
  padding: 35px 35px 15px;
  background: #fff;
  border: 1px solid #eaeaea;
  box-shadow: 0 0 25px #cac6c6;
}
label.el-checkbox.rememberme {
  margin: 0px 0px 15px;
  text-align: left;
}

.el-carousel__item h3 {
  color: #475669;
  font-size: 14px;
  opacity: 0.75;
  line-height: 200px;
  margin: 0;
}

.el-carousel__item:nth-child(2n) {
  background-color: #3880e3;
}

.el-carousel__item:nth-child(2n+1) {
  background-color: #2179da;
}
</style>


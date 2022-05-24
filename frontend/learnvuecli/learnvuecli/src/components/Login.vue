
<template>
  <div class="login-container">

    <el-form
      :model="ruleForm2"
      :rules="rules2"
      status-icon
      ref="ruleForm2"
      label-position="left"
      label-width="0px"
      class="demo-ruleForm login-page"
    >
      <h3 class="title">企业碳排放管理系统</h3>
      <el-form-item prop="username">
        <el-input
          type="text"
          v-model="ruleForm2.username"
          auto-complete="off"
          placeholder="用户名"
        ></el-input>
      </el-form-item>
      <el-form-item prop="password">
        <el-input
          type="password"
          v-model="ruleForm2.password"
          auto-complete="off"
          placeholder="密码"
        ></el-input>
      </el-form-item>
      <el-form-item style="width: 100%">
        <el-button type="primary" style="width: 100%" @click="handleSubmit" :loading="logining">登录</el-button>
      </el-form-item>
      <el-form-item style="width: 100%">
        <el-button type="primary" style="width: 100%" @click="handleSubmit" :loading="logining">注册</el-button>
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
      picture:[
        {url:require("../assets/logo.png")},
        {url:require("../assets/img.png")},
        {url:require("../assets/logo.png")},
        {url:require("../assets/logo.png")}
      ],
      ruleForm2: {
        username: "admin",
        password: "123456",
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
    handleSubmit(){
      this.$refs.ruleForm2.validate((valid) => {
        if(valid){
          this.logining = true;
          if(this.ruleForm2.username === 'admin' && this.ruleForm2.password === '123456'){
            this.logining = false;
            sessionStorage.setItem('user', this.ruleForm2.username);
            this.$router.push({path: '/'});
          }else{
            this.logining = false;
            this.$alert('用户名或密码错误', '登录失败', {
              confirmButtonText: 'ok'
            })
          }
        }else{
          console.log('error submit!');
          return false;
        }
      })
    }
  },
};
</script>

<style scoped>
.login-container {
  width: 100%;
  height: 100%;
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


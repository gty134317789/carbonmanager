<template>
  <el-container class="home_container">
    <el-header>
      <div class="home_title">企业碳排放管理系统</div>
    </el-header>
    <el-container>

      <el-aside width="210px" style="background-color: #a5e7f0">

        <el-menu router>

          <el-submenu :index="0">
            <template slot="title"><i class="el-icon-goods"></i>企业管理</template>

            <el-menu-item index="/CompanyManager">
              <div style="position: relative;left: 20px;">
                <i class="el-icon-s-unfold"></i>现有企业信息
              </div>
            </el-menu-item>

            <el-menu-item index="/addcompany">
              <div style="position: relative;left: 20px;">
                <i class="el-icon-circle-plus"></i>添加企业
              </div>
            </el-menu-item>
          </el-submenu>

          <el-submenu :index="1">
            <template slot="title"><i class="el-icon-finished"></i>生产项目管理</template>
            <el-menu-item index="/productmanager">
              <div style="position: relative;left: 20px;">
                <i class="el-icon-s-data"></i>现有生产信息
              </div>
            </el-menu-item>

            <el-menu-item index="/addproduction">
              <div style="position: relative;left: 20px;">
                <i class="el-icon-s-marketing"></i>添加生产项目
              </div>
            </el-menu-item>
          </el-submenu>

          <el-submenu :index="2">
            <template slot="title"><i class="el-icon-finished"></i>用户管理</template>
            <el-menu-item index="/usermanager">
              <div style="position: relative;left: 20px;">
                <i class="el-icon-s-data"></i>修改用户信息
              </div>
            </el-menu-item>

            <el-menu-item index="/system">
              <div style="position: relative;left: 20px;">
                <i class="el-icon-s-data"></i>退出系统
              </div>
            </el-menu-item>
          </el-submenu>

        </el-menu>

      </el-aside>

      <el-container>
        <el-main>
          <el-breadcrumb separator-class="el-icon-arrow-right">
            <el-breadcrumb-item :to="{ path: '/update' }">首页</el-breadcrumb-item>
            <el-breadcrumb-item v-text="this.$router.currentRoute.name"></el-breadcrumb-item>
          </el-breadcrumb>
          <router-view></router-view>
        </el-main>
        <el-footer>P.E.E.K.A</el-footer>
      </el-container>

    </el-container>

  </el-container>
</template>

<script>
// @ is an alias to /src
import HelloWorld from '@/components/HelloWorld.vue'
import footer from "@/components/footer.vue";


export default {
  name: 'Home',
  components: {
    HelloWorld,
    footer
  }
}
</script>

<style>
.home_container {
  height: 100%;
  position: absolute;
  top: 0px;
  left: 0px;
  width: 100%;
}

.el-header {
  background-color: #20a0ff;
  color: #333;
  text-align: center;
  display: flex;
  align-items: center;
  justify-content: space-between;
}

.el-aside {
  background-color: #ECECEC;
}

.el-main {
  background-color: #fff;
  color: #000;
  text-align: center;
}

.el-footer {
  background-color: #ea7e53;
  color: #fff;
  font-size: 22px;
  line-height: 60px;
}

.home_title {
  color: #fff;
  font-size: 22px;
  display: inline;
}

.home_userinfo {
  color: #fff;
  cursor: pointer;
}

.home_userinfoContainer {
  display: inline;
  margin-right: 20px;
}
</style>

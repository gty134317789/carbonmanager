import Vue from 'vue'
import Router from 'vue-router'
import HelloWorld from '@/components/HelloWorld'
import Home from '../components/Home.vue'
import companyManager from "../components/CompanyManager"
import Addcompany from "../components/Addcompany"
import Bar from "../components/Bar"
import Pie from "../components/Pie"
import ProductManage from "../components/ProductManage"
import Update from "../components/Update";
import UserManage from"../components/UserManager"
import Addproduction from "../components/Addproduction";

Vue.use(Router)

export default new Router({
  routes: [
    {
      path: '/',
      name: 'home',
      component: Home,
      children:[
        {path: '/companymanager', name: '企业管理', component: companyManager},
        {path: '/addcompany', name: '添加企业', component: Addcompany},
        {path: '/addproduction', name: '添加生产项目', component: Addproduction},
        {path: '/bar', name: 'bar', component: Bar},
        {path: '/pie', name: 'pie', component: Pie},
        {path: '/productmanager', name: '生产项目管理', component: ProductManage},
        {path: '/update', name: 'update', component: Update},
        {path: '/usermanager', name: '修改用户信息', component:UserManage},
      ]
    },
]
})

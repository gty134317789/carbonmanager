import Vue from 'vue'
import Router from 'vue-router'
import Home from '../components/Home.vue'
import companyManager from "../components/CompanyManager"
import Addcompany from "../components/Addcompany"
import Bar from "../components/Bar"
import Pie from "../components/Print"
import ProductManage from "../components/ProductManage"
import UserManage from"../components/UserManager"
import Addproduction from "../components/Addproduction";
import ProductionUpdate from "../components/ProductionUpdate";
import CompanyUpdate from "../components/CompanyUpdate";
import Adduser from "../components/Adduser"
import UserUpdate from "../components/UserUpdate";
import login from "../components/Login";
import register from "../components/Register";
import help from "../components/Help";
import print from "../components/Print";

Vue.use(Router)

export default new Router({
  routes: [
    {
      path: '/',
      name: '',
      component: Home,
      children:[
        {path: '/addcompany', name: '添加企业', component: Addcompany},
        {path: '/addproduction', name: '添加生产项目', component: Addproduction},
        {path: '/adduser', name: '添加用户', component: Adduser},

        {path: '/updatecompany', name: '更新企业信息', component: CompanyUpdate},
        {path: '/updateproduction', name: '更新生产项目', component: ProductionUpdate},
        {path: '/updateuser', name: '更新用户信息', component: UserUpdate},

        {path: '/companymanager', name: '企业管理', component: companyManager},
        {path: '/productmanager', name: '生产项目管理', component: ProductManage},
        {path: '/usermanager', name: '用户信息管理', component:UserManage},

        {path: '/bar', name: 'bar', component: Bar},
        {path: '/pie', name: 'pie', component: Pie},

        {path: '/print', name: '打印', component:print},
        {path: '/help', name: '帮助', component:help},
      ]
    },
    {
      path:'/login',
      name:'login',
      component:login
    },
    {
      path:'/regisiter',
      name:'regisiter',
      component:register
    }
]
})

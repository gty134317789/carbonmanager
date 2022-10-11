# 企业碳排放管理系统

## 概要

​        这一段时间学了Java，觉得Java还算是很规范的语言，而且写起来也蛮顺手的，就业岗位也多。正好有一个大作业，就了解了一下前后端分离的开发模式，做了这个小项目。前后端分离，且热部署在腾讯云服务器上。http://42.192.207.238:8181/#/

---

## 工具和技术栈

- SpringBoot+MyBatis Plus——后端框架，实现CURD、接口实现
- Vue+Element UI——前端框架，实现注册登录、数据展示
- MySQL——数据库
- 腾讯云轻量级应用服务器——热部署jar包
- Ubuntu 18.04 +XShell——运维

---

## 过程

### 1.搭建前端页面

​        使用Vue的脚手架初始化项目，然后就直接Element UI上找合适的组件，然后搭建，具体的效果就像下面这样：

![image text](https://github.com/gty134317789/carbonmanager/blob/main/image/image-20221011135854916.png)

![image text](https://github.com/gty134317789/carbonmanager/blob/main/image/image-20221011135932910.png)

### 2.设计后端逻辑

​        先自己搭好环境，比如maven、MyBatis Plus等等，然后就看官方文档去写CURD，包括四层的东西。也要实现一些子功能，比如翻页什么的。

![image text](https://github.com/gty134317789/carbonmanager/blob/main/image/image-20221011140404725.png)



### 3.热部署

​        直接去租了一个腾讯云的服务器，然后开公网ip、配置防火墙等等。为了学习，直接用的Ubuntu，没用宝塔。所有的服务也都是自己装的，包括MySQL、Java等等。

![image text](https://github.com/gty134317789/carbonmanager/blob/main/image/image-20221011140807646.png)

---

## 总结

​		基本就是从零开始搭建了一个前后端分离的项目，遇到了很多坑，但也都解决了。未来希望进行高数据量的吞吐，毕竟是大数据专业。

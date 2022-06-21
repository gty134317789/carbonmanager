<template>
<div>

  <h3>如果对本系统有问题，欢迎联系本作者。</h3>
 <h4>QQ:1234567890</h4>
  <h4> 电话:1234567891</h4>


  <h3>喜欢的话评个分吧</h3>
  <span class="demonstration"></span>
  <el-rate
    v-model="value"
    show-text>
  </el-rate>

</div>

</template>



<script>
export default {
  data() {
    return {
      tableData: [{
        way: 'QQ',
        data: '1343177289',
      }, {
        way: '微信',
        data: '13917082543',
      }, ],
      value:''
    }
  }
}
</script>

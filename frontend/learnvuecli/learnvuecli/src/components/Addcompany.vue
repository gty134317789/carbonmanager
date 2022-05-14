<template>
    <div style="margin-top: 60px;margin-left:80px;width: 600px" >
        <el-form :model="ruleForm" :rules="rules" ref="ruleForm" label-width="120px" class="demo-ruleForm">
            <el-form-item label="公司代码" prop="code"
                          :rules="[
    { required: true, message: '公司代码不能为空'},
    { type: 'number', message: '公司代码必须为数字值'}
  ]">
                <el-input v-model="ruleForm.code"></el-input>
            </el-form-item>

            <el-form-item label="公司管理员" prop="manager"
                          :rules="[
    { required: true, message: '公司管理员不能为空'},
  ]">
                <el-input v-model="ruleForm.manager"></el-input>
            </el-form-item>

            <el-form-item label="公司地址" prop="address"
                          :rules="[
    { required: true, message: '公司地址不能为空'},
  ]">
                <el-input v-model="ruleForm.address"></el-input>
            </el-form-item>

            <el-form-item label="所属行业" prop="concept"
                          :rules="[
    { required: true, message: '所属行业不能为空'},
  ]">
                <el-input v-model="ruleForm.concept"></el-input>
             </el-form-item>

            <el-form-item label="联系电话" prop="phone"
                          :rules="[
    { required: true, message: '联系电话不能为空'},
  ]">
                <el-input v-model="ruleForm.phone"></el-input>
            </el-form-item>

            <el-form-item label="碳排放是否达标" prop="isstrandard"
                          :rules="[
    { required: true, message: '碳排放是否达标不能为空'},
  ]">
                <el-input v-model="ruleForm.isstrandard"></el-input>
            </el-form-item>

            <el-form-item>
                <el-button type="primary" @click="submitForm('ruleForm')">立即创建</el-button>
                <el-button @click="resetForm('ruleForm')">重置</el-button>
            </el-form-item>
        </el-form>
    </div>
</template>

<script>
    export default {
        name: "Add",
        data() {
            return {
                ruleForm: {
                    code: '',
                    manager: '',
                    address: '',
                    concept: '',
                    phone:'',
                    isStandard:''
                },
                rules: {
                    code: [
                        { required: true, message: '公司代码不能为空', trigger: 'change' }
                    ],
                    manager: [
                        { required: true, message: '公司管理员不能为空', trigger: 'change' },
                        { min: 3, max: 5, message: '长度在 3 到 5 个字符', trigger: 'blur' }
                    ],

                },
                options1: '',
                options2: '',
                options3: ''
            };
        },
        created() {
            let _this = this
            axios.get('http://localhost:8181/productCategory/init').then(function (resp) {
                _this.options1 = resp.data
            })
        },
        methods: {
            change1(){
                let _this = this
                axios.get('http://localhost:8181/productCategory/children/2/'+this.ruleForm.categoryleveloneId).then(function (resp) {
                    _this.options2 = resp.data
                    _this.ruleForm.categoryleveltwoId = ''
                    _this.options3 = ''
                    _this.ruleForm.categorylevelthreeId = ''
                })
            },
            change2(){
                let _this = this
                axios.get('http://localhost:8181/productCategory/children/3/'+this.ruleForm.categoryleveltwoId).then(function (resp) {
                    _this.options3 = resp.data
                    _this.ruleForm.categorylevelthreeId = ''
                })
            },
            submitForm(formName) {
                let _this = this
                this.$refs[formName].validate((valid) => {
                    if (valid) {
                        axios.post('http://localhost:8181/product/save',_this.ruleForm).then(function (resp) {
                            if(resp.data){
                                _this.$alert('【'+_this.ruleForm.name+'】添加成功', '', {
                                    confirmButtonText: '确定',
                                    callback: action => {
                                        _this.$router.push('/')
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

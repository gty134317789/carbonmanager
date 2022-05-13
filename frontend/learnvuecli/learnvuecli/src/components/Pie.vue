<template>
    <div id="myChart" style="width: 1000px;height: 500px;margin: 60px 60px"></div>
</template>

<script>
    export default {
        name: "Pie",
        mounted(){
            this.drawLine();
        },
        methods: {
            drawLine(){
                const _this = this
                axios.get('http://localhost:8181/product/pie').then(function (resp) {
                    // 基于准备好的dom，初始化echarts实例
                    let myChart = _this.$echarts.init(document.getElementById('myChart'))
                    // 绘制图表
                    myChart.setOption({
                        backgroundColor: '#2c343c',
                        title: {
                            text: '饼图',
                            left: 'center',
                            top: 20,
                            textStyle: {
                                color: '#ccc'
                            }
                        },
                        tooltip: {
                            trigger: 'item'
                        },
                        visualMap: {
                            show: false,
                            min: 80,
                            max: 600,
                            inRange: {
                                colorLightness: [0, 1]
                            }
                        },
                        series: [
                            {
                                name: '销量',
                                type: 'pie',
                                radius: '60%',
                                center: ['50%', '50%'],
                                data: resp.data.sort(function (a, b) {
                                    return a.value - b.value;
                                }),
                                roseType: 'radius',
                                label: {
                                    color: 'rgba(255, 255, 255, 0.3)'
                                },
                                labelLine: {
                                    lineStyle: {
                                        color: 'rgba(255, 255, 255, 0.3)'
                                    },
                                    smooth: 0.2,
                                    length: 10,
                                    length2: 20
                                },
                                itemStyle: {
                                    color: '#c23531',
                                    shadowBlur: 200,
                                    shadowColor: 'rgba(0, 0, 0, 0.5)'
                                },
                                animationType: 'scale',
                                animationEasing: 'elasticOut',
                                animationDelay: function (idx) {
                                    return Math.random() * 200;
                                }
                            }
                        ]
                    });
                })
            }
        }
    }
</script>

<style scoped>

</style>
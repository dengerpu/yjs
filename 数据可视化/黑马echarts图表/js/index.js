(function () {
    // 1.实例化对象
    let myChart = echarts.init(document.querySelector('.bar .chart'))
    // 2.设置数据源
    // 指定配置和数据
    let option = {
        color: ["#2f89cf"],
        tooltip: {
            trigger: "axis",
            axisPointer: {
                // 坐标轴指示器，坐标轴触发有效
                type: "shadow" // 默认为直线，可选为：'line' | 'shadow'
            }
        },
        grid: {
            left: "0%",
            top: "10px",
            right: "0%",
            bottom: "4%",
            containLabel: true
        },
        xAxis: [
            {
                type: "category",
                data: ["旅游行业", "教育培训", "游戏行业", "医疗行业", "电商行业", "社交行业", "金融行业"],
                axisTick: {
                    alignWithLabel: true
                },
                // 设置x轴标签文字样式
                // x轴的文字颜色和大小
                axisLabel: {
                    color: "rgba(255,255,255,.6)",
                    fontSize: "9"
                },
                //  x轴样式不显示
                axisLine: {
                    show: false
                    // 如果想要设置单独的线条样式 
                    // lineStyle: {
                    //    color: "rgba(255,255,255,.1)",
                    //    width: 1,
                    //    type: "solid"
                },
                // 不显示刻度
                axisTick: {
                    show: false
                },
            },

        ],
        yAxis: [
            {
                type: "value",
                axisLabel: {
                    color: "rgba(255,255,255,.6)",
                    fontSize: "12"
                },
                // y轴线条样式
                axisLine: {
                    lineStyle: {
                        color: "rgba(255,255,255,.1)",
                        // width: 1,
                        // type: "solid"
                    },
                },
                // y 轴分隔线样式
                splitLine: {
                    lineStyle: {
                        color: "rgba(255,255,255,.1)"
                    }
                }
            }
        ],
        series: [
            {
                name: "直接访问",
                type: "bar",
                // 修改柱子宽度
                barWidth: "35%",
                data: [200, 300, 300, 900, 1500, 1200, 600],
                itemStyle: {
                    // 修改柱子圆角
                    barBorderRadius: 5
                }
            }
        ]
    };

    // 3.配置给实例化对象
    myChart.setOption(option);
    // 4.图表自适应
    window.addEventListener('resize', function () {
        myChart.resize()
    })
})();
// 柱状图2
(function () {
    // 1.实例化对象
    let myChart = echarts.init(document.querySelector('.bar2 .chart'))
    // 声明颜色数组
    let myColor = ["#1089E7", "#F57474", "#56D0E3", "#F8B448", "#8B78F6"];
    // 2.设置数据源
    let option = {
        grid: {
            top: "10%",
            left: "22%",
            bottom: "10%",
            containLabel: false // 不显示刻度
        },
        // 不显示x轴的相关信息
        xAxis: {
            type: 'value',
            show: false
        },
        yAxis: [
            {
                type: 'category',
                data: ["HTML5", "CSS3", "javascript", "VUE", "NODE"],
                inverse: true, // 保证和data顺序一样（翻转一下）
                // 不显示y轴的线
                axisLine: {
                    show: false
                },
                // 不显示刻度
                axisTick: {
                    show: false
                },
                // 把刻度标签里面的颜色设置为白色
                axisLabel: {
                    color: '#fff'
                },

            },
            {
                type: 'category',
                data: [702, 350, 610, 793, 664],
                inverse: true, // 保证和data顺序一样（翻转一下）
                //不显示y轴线条
                axisLine: {
                    show: false
                },
                // 不显示刻度
                axisTick: {
                    show: false
                },
                // 把刻度标签里面的颜色设置为白色
                axisLabel: {
                    textStyle: {
                        fontSize: 12,
                        color: "#fff"
                    }
                }
            }
        ],
        series: [{
            name: '条',
            type: 'bar',
            data: [70, 34, 60, 78, 69],
            yAxisIndex: 0,  // 显示在下面，类似z-index
            // 修改第一组柱子的圆角
            itemStyle: {
                barBorderRadius: 20,
                color: function (params) {
                    // params 传进来的是柱子对象
                    // dataIndex 是当前柱子的索引号
                    return myColor[params.dataIndex]
                }
            },
            // 柱子之间的距离
            barCategoryGap: 50,
            // 主子的宽度
            barWidth: 10,
            // 图形上的文本标签
            label: {
                normal: {
                    show: true,
                    // 图形内显示
                    position: 'inside',
                    // 文字的显示格式
                    formatter: '{c}%'
                }
            }
        },
        {
            name: "框",
            type: "bar",
            yAxisIndex: 1,
            barCategoryGap: 50,
            barWidth: 15,
            itemStyle: {
                color: "none",  // 不显示颜色
                borderColor: "#00c1de",
                borderWidth: 3,
                barBorderRadius: 15
            },
            data: [100, 100, 100, 100, 100],
        },
        ]
    }
    // 3.为实例化对象配置数据源
    myChart.setOption(option)
    // 4.图表自适应
    window.addEventListener('resize', function () {
        myChart.resize()
    })
})();

// 折线图1
(function () {
    // 1.创建实例化对象
    let myChart = echarts.init(document.querySelector('.line .chart'))
    let option = {
        color: ['#00f2f1', '#ed3f35'],
        title: {
            text: ''
        },
        tooltip: {
            trigger: 'axis',
            axisPointer: {
                lineStyle: {
                    type: 'solid'
                }
            }
        },
        // 设置网格样式
        grid: {
            top: '20%',
            left: '3%',
            right: '4%',
            bottom: '3%',
            show: true,// 显示边框
            borderColor: '#012f4a',// 边框颜色
            containLabel: true // 包含刻度文字在内
        },
        // 图例组件
        legend: {
            textStyle: {
                color: '#4c9bfd' // 图例文字颜色
            },
            right: '10%' // 距离右边10%
        },
        xAxis: {
            type: 'category',
            boundaryGap: false,  // 去除轴间距
            data: ['1月', '2月', '3月', '4月', '5月', '6月', '7月', '8月', '9月', '10月', '11月', '12月'],
            axisTick: {
                show: false // 去除刻度线
            },
            axisLabel: {
                color: '#4c9bfd' // 文本颜色
            },
            axisLine: {
                show: false // 去除轴线
            },
        },
        yAxis: {
            type: 'value',
            boundaryGap: false,  // 去除轴间距
            axisTick: {
                show: false // 去除刻度线
            },
            axisLabel: {
                color: '#4c9bfd' // 文本颜色
            },
            axisLine: {
                show: false // 去除轴线
            },
            splitLine: {
                lineStyle: {
                    color: '#012f4a' // 分割线颜色
                }
            }
        },
        series: [
            {
                name: '新增粉丝',
                data:  [24, 40, 101, 134, 90, 230, 210, 230, 120, 230, 210, 120],
                type: 'line',
                // 折线修饰为圆滑
                smooth: true,

            },
            {
                name: '新增游客',
                data: [40, 64, 191, 324, 290, 330, 310, 213, 180, 200, 180, 79],     
                type: 'line',
                smooth: true,

            }
        ]
    };
    myChart.setOption(option)

})();
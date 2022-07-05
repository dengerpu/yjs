<template>
  <div id="map" style="width: 800px; height: 800px"></div>
</template>

<script>
import * as echarts from "echarts";
import ChongQing from "../assets/map/重庆市.json";

export default {
  name: "ChongQing",
  methods: {
    showChongQing() {
      //
      const that = this;
      setTimeout(() => {
        // var echarts = require("echarts");
        that.graph = echarts.init(document.getElementById("map"));
        echarts.registerMap("ChongQing", ChongQing); // 地图注册
        var option = {
          tooltip: {
            trigger: "item",
          },
          // 左下角视觉映射组件
          visualMap: {
            min: 0, // 最小值
            max: 18000, // 最大值
            text: ["多", "少"],
            realtime: false,
            calculable: true,
            inRange: {
              color: ["#fff", "yellow", "orangered"],
            },
            textStyle: {
              color: "rgba(255,255,255,0.8)", //图例文字颜色，大小等配置
            },
            left: "1%",
          },
          series: [
            {
              name: "分布图",
              type: "map",
              mapType: "ChongQing",
              label: {
                normal: {
                  show: true,
                },
                emphasis: {
                  show: true,
                },
              },
              itemStyle: {
                normal: {
                  borderColor: "#000",
                },
                // emphasis: {
                //   areaColor: '#07caa9'
                // }
              },
              data: this.data,
              // nameMap: {
              //   // 映射名
              //   遵义市: "遵义",
              //   铜仁市: "铜仁",
              //   毕节市: "毕节",
              //   六盘水市: "六盘水",
              //   贵阳市: "贵阳",
              //   安顺市: "安顺",
              //   黔西南布依族苗族自治州: "黔西南",
              //   黔东南苗族侗族自治州: "黔东南",
              //   黔南布依族苗族自治州: "黔南",
              // },
            },
          ],
        };
        that.graph.setOption(option, true);
        window.addEventListener("resize", () => {
          that.graphInit();
        });
      });
    },
  },

  mounted() {
    this.showChongQing();
  },
};
</script>

<style>
</style>
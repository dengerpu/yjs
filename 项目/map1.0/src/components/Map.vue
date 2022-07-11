<template>
  <div class="map">map地图</div>
</template>

<script>
import * as echarts from "echarts";
export default {
  name: "Map",
  mounted() {},
  data() {
    return {
      namedata: [
        { name: "张" },
        { name: "刘" },
        { name: "李" },
        { name: "邓" },
        { name: "熊" },
        { name: "田" },
        { name: "周" },
        { name: "赵" },
        { name: "钱" },
        { name: "孙" },
        { name: "吴" },
        { name: "郑" },
        { name: "王" },
        { name: "冯" },
        { name: "陈" },
        { name: "杨" },
        { name: "朱" },
        { name: "秦" },
        { name: "许" },
        { name: "徐" },
        { name: "何" },
        { name: "曹" },
        { name: "陶" },
        { name: "邹" },
        { name: "苏" },
        { name: "范" },
        { name: "彭" },
        { name: "鲁" },
        { name: "马" },
        { name: "方" },
        { name: "唐" },
        { name: "顾" },
      ],
      option: null,
      geoCoordMap: {
        上海: [119.1803, 31.2891],
        福建: [119.4543, 25.9222],
        重庆: [108.384366, 30.439702],
        北京: [116.4551, 40.2539],
        辽宁: [123.1238, 42.1216],
        河北: [114.4995, 38.1006],
        天津: [117.4219, 39.4189],
        山西: [112.3352, 37.9413],
        陕西: [109.1162, 34.2004],
        甘肃: [103.5901, 36.3043],
        宁夏: [106.3586, 38.1775],
        青海: [101.4038, 36.8207],
        新疆: [87.9236, 43.5883],
        西藏: [91.11, 29.97],
        四川: [103.9526, 30.7617],
        吉林: [125.8154, 44.2584],
        山东: [117.1582, 36.8701],
        河南: [113.4668, 34.6234],
        江苏: [118.8062, 31.9208],
        安徽: [117.29, 32.0581],
        湖北: [114.3896, 30.6628],
        浙江: [119.5313, 29.8773],
        内蒙古: [110.3467, 41.4899],
        江西: [116.0046, 28.6633],
        湖南: [113.0823, 28.2568],
        贵州: [106.6992, 26.7682],
        云南: [102.9199, 25.4663],
        广东: [113.12244, 23.009505],
        广西: [108.479, 23.1152],
        海南: [110.3893, 19.8516],
        黑龙江: [127.9688, 45.368],
        台湾: [121.4648, 25.563],
      },
      chinaDatas: [
        {
          name: "北京",
          value: 86,
        },
        {
          name: "福建",
          value: 65,
        },
        {
          name: "广东",
          value: 53,
        },
        {
          name: "上海",
          value: 48,
        },

        {
          name: "河北",
          value: 2,
        },
        {
          name: "天津",
          value: 6,
        },
        {
          name: "山西",
          value: 12,
        },
        {
          name: "陕西",
          value: 2,
        },
        {
          name: "甘肃",
          value: 4,
        },
        {
          name: "宁夏",
          value: 5,
        },
        {
          name: "青海",
          value: 3,
        },
        {
          name: "新疆",
          value: 0.4,
        },
        {
          name: "西藏",
          value: 0.3,
        },
        {
          name: "四川",
          value: 22,
        },
        {
          name: "重庆",
          value: 12,
        },
        {
          name: "山东",
          value: 9,
        },
        {
          name: "河南",
          value: 0.9,
        },
        {
          name: "江苏",
          value: 24,
        },
        {
          name: "安徽",
          value: 15,
        },
        {
          name: "湖北",
          value: 6,
        },
        {
          name: "浙江",
          value: 15,
        },
        {
          name: "内蒙古",
          value: 0.3,
        },
        {
          name: "江西",
          value: 34,
        },
        {
          name: "湖南",
          value: 12,
        },
        {
          name: "贵州",
          value: 0.8,
        },
        {
          name: "广西",
          value: 16,
        },
        {
          name: "海南",
          value: 37,
        },
        {
          name: "辽宁",
          value: 0.2,
        },
        {
          name: "吉林",
          value: 0.4,
        },
        {
          name: "云南",
          value: 34,
        },
        {
          name: "黑龙江",
          value: 5,
        },
        {
          name: "台湾",
          value: 43,
        },
      ],
    };
  },
  methods: {
    convertData(data, type) {
	/*type:1 地图参数；type:2数据参数*/
	var res = [];
	for (var i = 0; i < data.length; i++) {
		var geoCoord = geoCoordMap[data[i].name];
		if (geoCoord) {
			if (type == 2) {
				res.push({
					name: data[i].name,
					value: geoCoord.concat(data[i].value),
					username: data[i].username,
					telphone: data[i].telphone,
					address: data[i].address
				});
			} else {
				res.push({
					name: data[i].name,
					value: geoCoord.concat(data[i].value)
				});
			}
		}
	}
	//console.log(res);
	return res;
},
  },
};
</script>

<style scoped>
</style>

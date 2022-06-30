const vm = new Vue({
    el: "#demo",
    data: {
        num1: 1,
        num2: 2
    },
    methods:{
        inputChange1(value){
            this.num1 = parseInt(value);
        },
        inputChange2(value){
            this.num2 = parseInt(value);
        }
    },
    components: {
        cpn: {
            template: "#cpn",
            props: {
                data1: Number,
                data2: Number,
            },
            data() {
                return {
                    cData1: this.data1,
                    cData2: this.data2
                }
            },
            methods: {
                inputMes1(e){
                    this.cData1 = e.target.value;
                    this.$emit("inputchange1",this.cData1);
                },
                inputMes2(e){
                    this.cData2 = e.target.value;
                    this.$emit("inputchange2",this.cData2);

                },
            }
        }
    }
})
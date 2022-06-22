// alert('111')
// alert(Math.PI)
// alert('Hello'+'word')
"hello".length
console.log("hello".length)
console.log("hello".charAt(0))
console.log('hello world'.replace('hello','goodbye'))
console.log('hello world'.toUpperCase())

var string = "abcde"
console.log(string)

let a = 1
console.log(a)

string="modify"
console.log(string)

a = 1+1
console.log(a)

const PI = 3.14
// PI = 3  会报错，不能改变
console.log(PI)

var x = 5
console.log(x+5)
x = x+5
x += 5
x++
console.log(x)

x = "3" + "4"
console.log(x)

x = "3" + 4 + 5
console.log(x)  //345

x = 3 + 4 + "5" //75,先算3+4 = 7 然后7+"5"
console.log(x)

console.log( 123 == "123")  //true
console.log(123 === "123")  //false
console.log( 1 == true)  //true
console.log(1 === true)  //false

var name = "zhangsan"
var age = 20
if (name == "zhangsan" && age == 20 ){
    console.log('zhangsan')
}else if(name == "lisi"){
    console.log('lisi')
}else{
    console.log("error")
}

// while(true){
//     console.log("true")
// }

a = 19

do{
    a++
    console.log(a)
} while(a<20)

if (true){
    // var b = 20
    // let b = 20  作用范围在当前作用域
}
a = 20

// if (b == a){
//     console.log('var没有作用范围')
// }

for(let i = 0; i < 5; i++){
    a ++ 
    console.log(a)
}

var allowed = (age >= 18) ? 'yes': 'no'  //三元操作符
console.log(allowed)

option = '3'
switch(option){
    case '1':
        console.log(1);
        break;
    case '2':
        console.log(2)
        break;
    default:
        console.log('default')
}

//集合
var obj = new Object();
var obj2 = {};
obj = {
    name: 'zhangsan',
    age: 20,
    email: 'zhangsan@qq.com',
    contact:{
        phone: 123456,
        area: '重庆市南岸区'
    }
}
obj.contact.wechat = 'wx'
console.log(obj)
console.log(obj.name)
console.log(obj.contact)

//数组
var arr = new Array()
var b = []

arr[0] = 'dog'
arr[5] = 'tiger'  //中间是underfined
console.log(arr)
console.log(arr.length)

b = ['a', 'b', 'c']
console.log(b)

for(let i =0; i<b.length;i++){
    console.log(b[i])
}

for (let i in arr){  //普通遍历会输出underfined，这种不会
    console.log(arr[i])
}

arr.forEach(function(value){
    console.log(value)
})

b.push('aaa')  //末尾追加
console.log(b)

b.reverse()   //反转
console.log(b)

b.shift()  //删除第一个
console.log(b)

b.unshift('first')  //数组第一个位置添加
console.log(b)

a = 1
function add(x){  //只是定义了一下，还没执行
    a += x;
}
add(2)  //函数执行
console.log(a)

// function add(a, b, c){

// }

function add(){
    let sum = 0
    for (let i = 0, j = arguments.length; i < j ;i++){
        sum += arguments[i]
    }
    return sum
}

let sum = add(1, 2, 3, 4, 5, 6, 7, 8)
console.log(sum)


//闭包（函数返回一个函数）
function makeAdder(a){
    return function(b){
        return a + b
    }
}

var x = makeAdder(4)
sum = x(5)
console.log(sum)
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

if (b == a){
    console.log('var没有作用范围')
}

# JavaScript

## DOM

### 学习目标：

能够说出什么是DOM

能够获取页面元素

能够给元素注册事件

能够操作DOM元素的属性

能够创建元素

能够操作DOM节点

DOM是什么：

文档对象模型（Document Objext Model,简称DOM），是W3C组织推荐的处理可扩展标记语言（HTML或者XML）的标准编程接口

![image-20220625150247258](https://trpora-1300527744.cos.ap-chongqing.myqcloud.com/img/image-20220625150247258.png)

### 获取页面元素

标签渲染后成之后，才能获取到，所以js代码代码写在获取标签的后面

根据ID获取元素，返回的是一个元素对象

```javascript
var element = document.getElementById("idValue")  //里面填写的是id值 
```

```javascript
console.dir(element)  //打印我们返回的元素对象，更好的查看里面的属性和方法
```

根据标签名获取元素，返回带有指定标签名的对象的集合

```javascript
var elements = document.getElementsByTagName('li') //以伪数组的形式存储的
for (var i = 0; i< elements.length; i++){
    console.log(elements[i])
}
//如果页面中只有一个元素，返回的还是伪数组的形式

var childElements = parentElement.getElementsByTagName('li')
//根据父元素获取子类元素
```

### HTML5新增方法获取元素

```javascript
var element = document.getElementByClassName('类名')//根据类名返回元素对象集合
```

```javascript
var element = document.querySelector('选择器')  //根据指定选择器返回第一个元素对象（.类名）（#id名）（标签名）
```

```javascript
var elements = document.querySelectorAll('标签名') //返回指定选择器的所有元素的集合
```

### 获取body,html元素

```javascript
var bodyEle = document.body;  //获取body元素
var htmlEle = document.documentElement //获取html元素对象
```

## 事件

JavaScript检测到的行为

（事件三要素）事件源  事件类型  事件处理程序

（1）事件源    事件被触发的对象

（2）事件类型    如何触发 什么事件  比如鼠标点击（onclick）还是鼠标经过 还是键盘按下

（3）事件处理程序   通过一个函数赋值的方式完成

```javascript
var btn = document.getElementById('btn')
btn.onclick = function (){
    alert('触发')
}
```

#### 常见鼠标事件

![image-20220625153340117](https://trpora-1300527744.cos.ap-chongqing.myqcloud.com/img/image-20220625153340117.png)

### 操作属性

改变元素内容

```javascript
element.innerText  //获取内容
element.innerText = '内容'
//从起始位置到终止位置的内容，但它去除html标签，同时空格和换行也会去掉
element.innerHTML  //获取内容
element.innerHTML = 'html代码'
//起始位置到终止位置的全部内容，包括html标签，同时保留空格和换行
```

案例：显示系统时间

![image-20220625154023234](https://trpora-1300527744.cos.ap-chongqing.myqcloud.com/img/image-20220625154023234.png)

```javascript
//元素可以不用添加事件
var p = document.querySelector('p')
p.innerText = getDate()
```

区别：

innerText不识别html标签，去除空格和换行

![image-20220625154542451](https://trpora-1300527744.cos.ap-chongqing.myqcloud.com/img/image-20220625154542451.png)

修改元素属性 src title

```javascript
element.src = '新路径'
element.title = '新图片标题'
```

案例：分时显示不同图片，显示不同问候语

![image-20220625155040325](https://trpora-1300527744.cos.ap-chongqing.myqcloud.com/img/image-20220625155040325.png)

表单元素的属性操作

type,value,checked,selected,disabled

```javascript
//先获取input元素
input.value = '修改表单value'
btn.disabled = true  //禁用按钮
```

案例：伪京东显示密码明文案例

![image-20220625155603253](https://trpora-1300527744.cos.ap-chongqing.myqcloud.com/img/image-20220625155603253.png)

![image-20220625160358018](https://trpora-1300527744.cos.ap-chongqing.myqcloud.com/img/image-20220625160358018.png)

样式属性操作：

```javascript
element.style  行内样式操作，css权重比较高
element.className  类名样式操作

div.style.backgroundColor = 'purple'  //驼峰命名法
```

案例：仿淘宝关闭案例

![image-20220625161125066](https://trpora-1300527744.cos.ap-chongqing.myqcloud.com/img/image-20220625161125066.png)

案例：循环精灵图背景

![image-20220625161320727](https://trpora-1300527744.cos.ap-chongqing.myqcloud.com/img/image-20220625161320727.png)

![image-20220625161607316](C:\Users\Administrator.SC-201902031211\AppData\Roaming\Typora\typora-user-images\image-20220625161607316.png)

案例：显示隐藏文本框内容

![image-20220625162408790](https://trpora-1300527744.cos.ap-chongqing.myqcloud.com/img/image-20220625162408790.png)

使用className修改样式属性











# ES6高级语法

## let/var

![image-20220627165831454](https://trpora-1300527744.cos.ap-chongqing.myqcloud.com/img/image-20220627165831454.png)

```html
 <button>按钮1</button>
    <button>按钮2</button>
    <button>按钮3</button>
    <button>按钮4</button>
    <button>按钮5</button>
    <button>按钮6</button>
    <script>
        //变量作用域，变量在什么范围内是可用的
        {
            var name = 'zhangsan'
            console.log(name)
        }
        console.log(name) //外部也可以访问到

        //2.没有会计作用域引起的问题：if的块级
        var func;
        if (true) {
            var name = 'why'
            func = function(){
                console.log(name)
            }
        }
        func()
        name = "abc"
        func()

        //3.没有块级作用域引起的问题： for的块级
        // var btns = document.getElementsByTagName('button')
        // //console.log(btns)
        // for(var i = 0; i < btns.length; i++){
        //     btns[i].addEventListener('click',function(){
        //         console.log('第'+i+'个按钮被点击')
        //     })
        // }   //添加的点击事件全是最后一个按钮的点击事件

        //使用let解决
        var btns = document.getElementsByTagName('button')
        //console.log(btns)
        for(let i = 0; i < btns.length; i++){
            btns[i].addEventListener('click',function(){
                index = i + 1
                console.log('第'+index+'个按钮被点击')
            })
        }   //添加的点击事件全是最后一个按钮的点击事件


    </script>
```

## const的使用

const关键字
1.在很多语言中已经存在, 比如C/C++中, 主要的作用是将某个变量修饰为常量.
2.在JavaScript中也是如此, 使用const修饰的标识符为常量, 不可以再次赋值.
什么时候使用const呢?
当我们修饰的标识符不会被再次赋值时, 就可以使用const来保证数据的安全性.
建议: 在ES6开发中,优先使用const, 只有需要改变某一个标识符的时候才使用let. 

注意1：

```javascript
 const name = 'abc'
 name = "123"  //错误，
//const使用.html:12 Uncaught TypeError: Assignment to constant variable.
```

注意2：

```javascript
 const title;  //const标识的变量必须赋初始值
```

注意点3:常量的含义是指向的对象不能修改,但是可以改变内部属性

```javascript
 const obj = {
            name : 'why',
            age : 18,
            height: 1.88
        }
        console.log(obj)
        // obj = {} 错误写法，不能被更改
        obj.name = 'lisi'
        obj.age = 22
        obj.height = 1.99
        console.log(obj)
```



## 对象增强写法

![image-20220627172839600](https://trpora-1300527744.cos.ap-chongqing.myqcloud.com/img/image-20220627172839600.png)

```javascript
       let name = 'why';
        let age = 18;
        let  height = 1.88;
        const obj = {
            name,
            age,
            height
        }
        console.log(obj)
        let obj1 = {
            func(){
                console.log('func函数被调用了')
            }
        }
       obj1.func()
```

## 高阶函数

### filter函数

filter中的回调函数有一个要求: 必须返回一个boolean值

* true: 当返回true时, 函数内部会自动将这次回调的n加入到新的数组中

* false: 当返回false时, 函数内部会过滤掉这次的n

```javascript
 const nums = [10, 20, 111, 222, 444, 40, 50]
        // 1.filter函数的使用
        // // 10, 20, 40, 50
        let newNums = nums.filter(function(n){
            return n < 100
        })
        console.log(newNums)
```

### map函数

```javascript
        // // 2.map函数的使用
        // // 20, 40, 80, 100
        let new2Nums = newNums.map(function(n){
            return n*2
        })
        console.log(new2Nums)
```

### reduce函数

```javascript
 // // 3.reduce函数的使用
        // // reduce作用对数组中所有的内容进行汇总
        let total = new2Nums.reduce(function(preValue, n){
            return preValue + n
        }, 0)
        console.log(total)
        
        // 第一次: preValue 0 n 20
        // 第二次: preValue 20 n 40
        // 第二次: preValue 60 n 80
        // 第二次: preValue 140 n 100
        // 240
```

```javascript
let total1 = nums
        .filter(n => n < 100)
        .map(n => n*2)
        .reduce((preValue, n) => preValue + n)
        console.log(total1)
 let total2 = nums.filter(function (n) {
        return n < 100
        }).map(function (n) {
        return n * 2
        }).reduce(function (prevValue, n) {
        return prevValue + n
        }, 0)
        console.log(total2);
```

## 箭头函数

### 箭头函数的使用

```javascript
 //箭头函数：也是一种定义函数的方式
        //1. 定义函数的方式： function
        const aaa = function (){
            console.log('aaa')
        }
        //2.对象字面量中定义函数
        const obj = {
            bbb() {
                console.log('bbbb')
            }
        }
        //3.Es6中的箭头函数
        const ccc = () => {
            console.log('ccc')
        }


        // 1.参数问题
        // 1.1放入两个参数
        const sum = (num1, num2) => {
            return num1*num2
        }
        // 1.2 放入一个参数
        const power = num => {
            return num*num
        }

        // 2.函数中
        // 2.1函数代码块中有多行代码时
        const test = () => {
            console.log('hello word')
            console.log('hello vue')
        }
        // 2.2只有一行代码
        const add = (num1, num2) => num1+num2
        const demo = () => console.log('demo')
```

### 箭头函数中this的指向

```javascript
setTimeout(function () {
            console.log(this)  //window
        }, 1000)

        setTimeout(() => {
            console.log(this)   //window
        }, 1000)
        //箭头函数中的this,向外层作用域中，一层层查找this，直到有this的定义
        const obj = {
            aaa () {
                setTimeout(function () {
                    console.log(this)  //window
                }, 1000)
            },
            bbb () {
                setTimeout(() => {
                    console.log(this)   //object
                }, 1000)
            } 
        }

        // obj.aaa()
        // obj.bbb()
        const obj2 = {
            aaa() {
            setTimeout(function () {
                setTimeout(function () {
                console.log(this); // window
                })

                setTimeout(() => {
                console.log(this); // window
                })
            })

            setTimeout(() => {
                setTimeout(function () {
                console.log(this); // window
                })

                setTimeout(() => {
                console.log(this); // obj
                })
            })
            }
        }

        obj2.aaa()
```


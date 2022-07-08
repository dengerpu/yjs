const fs = require('fs');
const path = require('path');
const Mock = require('mockjs');//mockjs 导入依赖模块
const JSON5 = require('json5');
const qs = require('qs')

//读取json文件
function getJsonFile(filePath) {
    //读取指定json文件
    var json = fs.readFileSync(path.resolve(__dirname,filePath), 'utf-8');
    //解析并返回
    return JSON5.parse(json);
}

module.exports = function(app){
    if(process.env.MOCK == 'true'){  // 添加的代码
        //监听http请求
        app.get('/user/userinfo', function (rep, res) {
            //每次响应请求时读取mock data的json文件
            //getJsonFile方法定义了如何读取json文件并解析成数据对象
            let json = getJsonFile('./userInfo.json5');
            //将json传入 Mock.mock 方法中，生成的数据返回给浏览器
            res.json(Mock.mock(json));
        });
        // 登陆接口
        app.post('/login', function(req, res) {
            // let item = JSON5.parse(req.body);
            // let username = item.username;
            // let password = item.password;
            let username = 'admin'
            let password = '123456'
            let result = {};
            if(username === 'admin' && password === '123456'){
              result = {
                'data':{
                  'orgCode':'000',
                  'token':'eyJhbGciOiJIUzUxMiJ9.eyJ1c2VySWQiOiJhZG1pbiIsInVzZXJOYW1lIjoiYWRtaW4iLCJvcmdDb2RlIjoiMzUwMDAiLCJkZXB0Q29kZSI6IjM1MDAwIiwiYXVkIjoiYWRtaW4iLCJpc3MiOiJhZG1pbiIsImV4cCI6MTU5MzUzNTU5OH0.0pJAojRtT5lx6PS2gH_Q9BmBxeNlgBL37ABX22HyDlebbr66cCjVYZ0v0zbLO_9241FX9-FZpCkEqE98MQOyWw',
                },
                "meta": {
                  "msg": "登录成功",
                  "status": 200
                }
              }
            }else{
              result =  {
                "meta": {
                  "msg": "登录失败",
                  "status": 400
                }
              }
            }
            res.json(result)
        })
    }
} 


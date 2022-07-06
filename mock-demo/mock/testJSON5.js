const fs = require('fs')
const path = require('path')
const JSON5 = require('json5')

// 读取json文件
function getJsonFile(fileParh) {
    // 读取指定json文件
    var json = fs.readFileSync(path.resolve(__dirname, fileParh), 'utf-8')
    // 解析并返回
    return JSON5.parse(json)
}
// var json = fs.readFileSync(path.join(__dirname, './userinfo.json5'), 'utf-8')
// var obj = JSON5.parse(json)

console.log(path.resolve(__dirname))

var json = getJsonFile('./userinfo.json5')
console.log(json)
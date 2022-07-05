const fs = require('fs')
const path = require('path')
const JSON5 = require('json5')

var json = fs.readFileSync(path.join(__dirname), './userinfo.json5', 'utf-8')
var obj = JSON5.parse(json)

console.log(path.join(__dirname))
console.log(obj)
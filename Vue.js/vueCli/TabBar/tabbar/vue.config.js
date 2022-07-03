const path = require('path')
function resolve(dir) {
    return path.join(__dirname, dir);
}
module.exports = {
    lintOnSave: false,  //去掉EsLint代码规范验证
    configureWebpack: {
        resolve: {
            alias: {
                '@': resolve('src'),
                'img': resolve('src/assets/img')
            }
        }
    },
}
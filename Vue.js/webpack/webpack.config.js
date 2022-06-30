const path = require('path')
const webpack = require('webpack')
const HtmlWebpackPlugin = require('html-webpack-plugin')
const UglifyjsWebpackPlugin = require('uglifyjs-webpack-plugin')

module.exports = {
    //入口，可以是字符串/数组/对象，这里我们入口只有一个，所以写一个字符串即可
    entry: './src/main.js',
    //出口，通常是一个对象，里面至少包含两个重要性，path和filename
    output: {
        path: path.resolve(__dirname, 'dist'),  //注意：path是一个绝对路径
        filename: 'bundle.js',
        // publicPath: 'dist/'  安装html-webpack-plugin需要删去
    },
    module: {
        rules: [
          { test: /\.css$/, 
           // css-loader只负责将css文件进行加载
            // style-loader负责将样式添加到DOM中
            // 使用多个loader时, 是从右向左
            use: ['style-loader','css-loader'] 
          },
          {
            test: /\.less$/,
            use: [{
              loader: "style-loader", // creates style nodes from JS strings
            }, {
              loader: "css-loader" // translates CSS into CommonJS
            }, {
              loader: "less-loader", // compiles Less to CSS
            }]
          },
          {
            test: /\.(png|jpg|gif|jpeg)$/,
            use: [
              {
                loader: 'url-loader',
                options: {
                  // 当加载的图片, 小于limit时, 会将图片编译成base64字符串形式.
                  // 当加载的图片, 大于limit时, 需要使用file-loader模块进行加载.
                  limit: 18000,
                  name: 'img/[name].[hash:8].[ext]'
                },
              }
            ]
          },
          {
            test: /\.js$/,
            // exclude: 排除
            // include: 包含
            exclude: /(node_modules|bower_components)/,
            use: {
              loader: 'babel-loader',
              options: {
                presets: ['es2015']
              }
            }
          },
          {
            test: /\.vue$/,
            use: ['vue-loader']
          }
        ]
    },
    resolve: {
        // alias: 别名
        extensions: ['.js', '.css', '.vue'],
        alias: {
        'vue$': 'vue/dist/vue.esm.js'
        }
    },
    plugins: [
        new webpack.BannerPlugin('最终版权归aaa所有'),
        new HtmlWebpackPlugin({
          template: 'index.html'
        }),
        new UglifyjsWebpackPlugin()
    ],
    devServer: {
        contentBase: './dist',
        inline: true
    }
}
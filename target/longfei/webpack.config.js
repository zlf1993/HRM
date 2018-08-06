const path = require('path')
const HtmlWebpackPlugin = require('html-webpack-plugin')
const webpack = require('webpack')

module.exports = { 
// 当前执行文件的路径 
  // 输入 
  entry:"./index.js", 
  // 输出 
  output:{ 
      path:path.resolve(__dirname ,"build/"), 
      filename:"bundle.js"
  },  
  watch:true,   
  module: {
    rules: [
      {
        test: /\.jsx?$/,
        loader: 'babel-loader',
        exclude: /node_modules/,
        query: {
          presets: ['es2015','react']
        }
      },
      {
        test: /\.(sass|scss|css)$/,
        use:['style-loader','css-loader','sass-loader']
      }
    ]
  },
  devServer: { 
    historyApiFallback: true,//不跳转 
    inline: true,//实时刷新 
    contentBase: path.resolve(__dirname,"build/"),//本地服务器所加载的页面所在的目录
    port:8091
  },
  plugins:[
    new HtmlWebpackPlugin({
      template: path.resolve(__dirname,'index.tpl.html'),
      filename: 'index.html'
    })
  ]
   
}


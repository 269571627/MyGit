//node/nodemon app.js启动
const express = require('express')
const router = require('./router')

// 创建 express 应用
const app = express()

app.use('/',router)

// 使 express 监听 5000 端口号发起的 http 请求
const server = app.listen(5000, function() {
    const { address, port } = server.address()
})
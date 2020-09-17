import Vue from 'vue'
import VueRouter from 'vue-router'
Vue.use(VueRouter)

import Login from '../components/VueRouterDemo/Login.vue'
import Home from '../components/VueRouterDemo/Home.vue'
import Register from '../components/VueRouterDemo/Register.vue'
import User from '../components/VueRouterDemo/User.vue'
import UserDetail from '../components/VueRouterDemo/UserDetail.vue'

//地址栏上 路由范式
//（1）xxx.html#/useer/1 params动态路由参数
//(2) ooo.html#/user?userId=10 query查询

const router = new VueRouter({
    routes: [
        {
            path: '/login',
            component: Login,
            meta:{title:'Login'}
        },
        {
            path: '/home',
            component: Home
        },
        {
            path: '/register',
            component: Register,
            // 命名路由
            name: 'register'
        },
        {
            //动态参数：id，动态路由组件结构相同数据不同
            path:'/user/:id',
            component:User,
            name:'userParams'
        },
        {
            path:'/user',
            component:User,
            name:'userQuery',
            //子路由：加载的组件结构不同
            children:[
                {
                    path:'detail',
                    component:UserDetail,
                    name:'userDteail'
                },
            ]
        },
        {
            path: '/',
            component: Home
        }
    ]
})

router.beforeEach((to,from,next)=>{
    console.log("beforeEach",to,from,next)
    if(to.meta.title){
        document.title = to.meta.title
    }else{
        document.title = 'Vue Demo'
    }
    next()
})

export default router
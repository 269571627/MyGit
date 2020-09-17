<template>
  <div>
    <h1>{{msg}}(VueRouterDemo)</h1>
    <!-- router-link相当于a
    to相当于herf-->
    <!-- router-link、router-view是全局组件，router-view是路由匹配组件的出口 -->
    <!-- 普通使用 -->
    <router-link to="/login">登录页面</router-link>
    <br />
    <!-- 命名路由 -->
    <router-link :to="{name:'register'}">注册页面</router-link>
    <br />
    <!-- 带动态参数params -->
    <router-link :to="{name:'userParams',params:{id:1}}">用户params</router-link>
    <br />
    <router-link :to="{name:'userQuery',query:{userName:2}}">用户query</router-link>
    <br />
    <router-view></router-view>
  </div>
</template>

<script>
export default {
  name: "VueRouterDemo",
  props: {
    msg: {
      type: String,
    },
  },
};
</script>

<style>
</style>
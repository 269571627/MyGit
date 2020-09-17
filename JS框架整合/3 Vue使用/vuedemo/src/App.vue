<template>
  <div id="app">
    <VueDemo msg="一、Vue 基础"/>
    <hr>
    <VueComponentsDemo msg="二、Vue 组件"/>
    <hr>
    <AdvanceUseDemo msg="三、Vue高级特性"/>
    <hr>
    <VuexDemo msg="四、Vuex"/>
    <!-- <p>APP————store中获取state中的count：{{count}}</p> -->
    <hr>
    <VueRouterDemo msg="五、VueRouter"/>
  </div>
</template>

<script>
import VueDemo from './components/VueDemo.vue'
import VueComponentsDemo from './components/VueComponentsDemo.vue'
import AdvanceUseDemo from './components/AdvanceUse/index'
import VuexDemo from './components/VuexDemo'
import VueRouterDemo from './components/VueRouterDemo'


export default {
  name: 'App',
  components: {
    VueDemo,
    VueComponentsDemo,
    AdvanceUseDemo,
    VuexDemo,
    VueRouterDemo
  },
  computed:{
    // count(){
    //   return this.$store.state.count
    // }
  }
}
</script>

<style>
#app {
  font-family: Avenir, Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  text-align: center;
  color: #2c3e50;
  margin-top: 60px;
}
</style>

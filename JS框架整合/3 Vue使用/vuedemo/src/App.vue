<template>
  <div id="app">
    <VueDemo msg="Welcome to VueDemo"/>
    <!-- <TplDemo></TplDemo> -->
  </div>
</template>

<script>
import VueDemo from './components/VueDemo.vue'
// import TplDemo from './components/BaseUse/TplDemo'
export default {
  name: 'App',
  components: {
    VueDemo
    // TplDemo
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

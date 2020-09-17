<template>
  <div>
    <h1>{{msg}}(ComponentsDemo)</h1>
    <hr>
    <IndexDemo/>
    <hr>
  </div>
</template>

<script>
import IndexDemo from './ComponentsDemo/index.vue'
export default {
    name:'VueComponentsDemo',
    props:{
      msg:String
    },
    components:{
      IndexDemo
    }
}
</script>

<style>

</style>
<template>
  <div>
      <h4>(4)IfShowDemo</h4>
      <p v-if=" type === 'a' ">A v-if</p>
      <p v-else-if=" type === 'b' ">B v-else-if</p>
      <p v-else>other v-else</p>

      <p v-show=" type === 'a' ">A v-show</p>
      <p v-show=" type === 'b' ">B v-show</p>
  </div>
</template>

<script>
export default {
    name:'IfShowDemo',
    data(){
        return{
            type:'a'
        }
    }
}
</script>

<style>

</style>
<template>
  <div>
      <h3>User</h3>
      <router-link :to="{name:'userDteail'}">用户信息页</router-link>
      <router-view></router-view>
  </div>
</template>

<script>
export default {
    name:'User',
    created(){
        //抛出两个对象，挂载vue实例化对象
        console.log(this.$router,this.$route)
        
    },
    mounted(){

    }
}
</script>

<style>

</style>
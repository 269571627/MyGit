<template>
  <div>
      <h4>(2)$nextTick</h4>
      <input type="text" name="" id="" v-model="addListText">
      <button @click='sendAdd'>添加</button>
  </div>
</template>

<script>
export default {
    name:'NextTick',
    data(){
        return{
            addListText:''
        }
    },
    methods:{
        sendAdd(){
            this.$emit('addListItem',this.addListText)
        }
    }
}
</script>

<style>

</style>
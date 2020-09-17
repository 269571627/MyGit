<template>
  <div>
      <h4>ListSonDemo（多层通讯）</h4>
      <p>index->list->listson</p>
      <p>{{$attrs.sendGrandF}}</p>
      <button @click="gsonMoney">点我向爷爷要零花钱</button>
      {{msg}}
  </div>
</template>

<script>
export default {
    name:'ListSonDemo',
    mounted(){
        console.log("listson",this.$attrs)
    },
    methods:{
        gsonMoney(){
            this.$emit('gsMsg',"孙子找到爷爷要了5毛钱")
        }
    },
    inject: ["foo2"],
    created(){
        this.msg = this.foo2
    }
}
</script>

<style>

</style>
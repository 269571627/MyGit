<template>
  <div>
      <!-- <lable></lable>的for属性与表单控件的id属性相关联 -->
      <input type="text" id="title" v-model="title">
      <button @click="sendTitle">add</button>
      <hr>
      <p>点击按钮后拿到爸爸给的值：{{indextoinputmsg}}</p>
      <input v-model="indextoinputmsg" @change="inputtoindex"/>
  </div>
</template>

<script>
import event from "./event";

export default {
    name:'InputDemo',
    data(){
        return{
            title:'',
            indextoinputmsg:this.value
        }
    },
    props:{
        value:{
            type:String
        }
    },
    methods:{
        sendTitle(){
            console.log('sendTitle 子$emit传值',this.title)
            //调用父组件事件  
            //两个参数：
            //add是父组件中自定义的@add
            //this.title是传递给父组件的值
            this.$emit('add',this.title)

            //调用自定义事件
            event.$emit('sendBroTitle',this.title)

            this.title = ''
        },
        inputtoindex(){
            this.$parent.sonInputMsg = this.indextoinputmsg
        }
    },
    created(){
        console.log("input created")
    },
    mounted(){
        console.log("input mounted")
    },
    beforeUpdate(){
        console.log("input beforeUpdate")
    },
    updated(){
        console.log("input updated")
    },
    beforeDestroy(){
        console.log("input beforeDestroy")
    },
    destroyed(){
        console.log("input destroyed")
    }
}
</script>

<style>

</style>
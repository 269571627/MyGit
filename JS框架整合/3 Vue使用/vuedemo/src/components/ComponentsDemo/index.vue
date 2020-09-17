<template>
  <div>
      <p>addList:</p>
      <InputDemo @add="addList"/>
      <button @click="indexToinput">通过parent、children传值</button>
      <p>input改变传来的值：{{sonInputMsg}}</p>
      <!-- :showlist是父绑定自定义属性给子 -->
      <ListDemo :showlist="list" @delete="deleteItem" :sendGrandF='grandf' @gsMsg='getgsMsg'/>
  </div>
</template>

<script>
//同步加载
// import InputDemo from './input'
// import ListDemo from './list'
export default {
    name:'IndexDemo',
    components:{
        // InputDemo,
        // ListDemo

        //异步加载
        InputDemo:() => import('./input'),
        ListDemo:() => import('./list')
    },
    data(){
        return{
            list:[
                {
                    id:'01',
                    title:'父子组件通讯'
                },
                                {
                    id:'02',
                    title:'xxxxxxxx'
                }
            ],
            grandf:'爷爷找到孙子问要不要零花钱',
            sonInputMsg:'时搁26年爷爷找到爸爸了'
        }
    },
    methods:{
        addList(title){
            this.list.push({
                id:`id-${Date.now()}`,
                title
            })
            console.log("父 addList",this.list)
        },
        deleteItem(id){
            //过滤器
            this.list = this.list.filter(item => {
                //全部遍历，返回true的结果
                console.log("deleteItem",item.id !== id)
                return item.id !== id
            })
        },
        getgsMsg(msg){
           alert(msg)
        },
        indexToinput(){
            this.$children[0].indextoinputmsg = this.sonInputMsg
        }
    },
    provide:{
        foo:'provide 父传子'
    },
    created(){
        console.log("index created")
    },
    mounted(){
        console.log("index mounted",this.$children)
    },
    beforeUpdate(){
        console.log("index beforeUpdate")
    },
    updated(){
        console.log("index updated")
    },
    beforeDestroy(){
        console.log("index beforeDestroy")
    },
    destroyed(){
        console.log("index destroyed")
    }
}
</script>

<style>

</style>
<template>
    <div>
        <h4>(5)ListDemo</h4>
        <p>遍历数组</p>
        <ul>
            <li v-for="(item,index) in newArray" :key="item.id">
                {{index}} - {{item.id}} - {{item.name}}
            </li>
        </ul>

        <p>遍历对象</p>
        <ul v-if="flag">
            <li v-for="(item,key,index) in newObj" :key="key">
                {{index}} - {{key}} - {{item.title}}
            </li>
        </ul>
        <h4>总结：3-3 循环（列表）渲染</h4>
        <hr>
    </div>
</template>

<script>
export default {
  name: "ListDemo",
  data(){
      return {
          flag:true,
          newArray:[
              {id:'01',name:'张三'},
              {id:'02',name:'李四'},
              {id:'03',name:'王二'}
          ],
          newObj:{
              a:{title:'标题1'},
              b:{title:'标题2'},
              c:{title:'标题3'}
          }
      }
  }
};
</script>

<style>
</style>
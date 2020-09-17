<template>
  <div>
      <!-- 应用：颜色选择器 -->
    <h4>(1)自定义v-model</h4>
    <!-- 双向数据绑定：向父组件传值： -->
    <label for="">双向数据绑定：</label>
    <input type="text"
        :value="textIn"
        @input="$emit('change',$event.target.value)">
  </div>
</template>

<script>
export default {
  name: "CustomVmodel",
  model: {
      prop:'textIn',//对应props内的textOne
      event:'change'
  },
  props: {
      //双向数据绑定：接收父组件的textOne
    textIn: {
      type: String,
      default() {
        return "";
      },
    },
  },
  
  data(){
      return{

      }
  }
};
</script>

<style>
</style>
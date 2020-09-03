<template>
  <div>
    <h4>(3)ClassDemo</h4>
    <p :class="{ blacck:isBlack, yellow:isYellow }">使用class</p>
    <p :class="[ black, yellow ]">使用class（数组）</p>
    <p :style="styleData">使用style</p>
    <h4>总结：3-2 class和style</h4>
    <hr>
  </div>
</template>

<script>
export default {
  name: "ClassDemo",
  data() {
    return {
      isBlack: true,
      isYellow: true,

      black: "black",
      yellow: "yellow",

      styleData: {
          fontSize:'40px',//驼峰
          color:'red',
          backgroundColor:'#ccc'//驼峰
      },
    };
  },
};
</script>

<style>
</style>
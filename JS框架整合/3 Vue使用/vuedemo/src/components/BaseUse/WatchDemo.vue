<template>
  <div>
    <h4>(2)侦听器WatchDemo</h4>
    <div>
      <input type="text" v-model="name" />
      <input type="text" v-model="info.city" />
    </div>
  </div>
</template>

<script>
export default {
  name: "WatchDemo",
  data() {
    return {
      name: "王富贵",
      info: {
        city: "东家村儿",
      },
    };
  },
  watch: {
    //值类型监听
    name(oldVal, val) {
      console.log("name:", oldVal, val, this.name);
    },
    info: {
      //深度监听,引用类型，因为为指针赋值指向同一个地址，故三者相同
      handler(oldVal, val) {
        console.log("info:", oldVal.city, val.city, this.info.city);
      },
      deep: true,
    },
  },
};
</script>

<style>
</style>
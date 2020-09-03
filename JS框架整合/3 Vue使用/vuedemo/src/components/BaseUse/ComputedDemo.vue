<template>
  <div>
    <h4>(2)计算属性ComputedDemo</h4>
    <div>
      <p>num {{num}}（初始值20）</p>
      <p>double1 {{double1}}(double1 = num * 2)</p>
      <p class="total">double2:(双向数据绑定)：</p>
      <input class="total" v-model="double2" />
    </div>
    <h4>总结：3-2 计算属性和侦听器</h4>
  <hr>
  </div>
</template>

<script>
export default {
  name: "ComputedDemo",
  data() {
    return {
      num: 20,
    };
  },
  computed: {
    double1() {
      console.log("double1");
      return this.num * 2;
    },
    double2: {
      get() {
        console.log("get()");
        return this.num * 2;
      },
      set(val) {
        this.num = val / 2;
        console.log("set()");
      },
    },
  },
};
</script>

<style>
.total{
    display: inline;
}
</style>
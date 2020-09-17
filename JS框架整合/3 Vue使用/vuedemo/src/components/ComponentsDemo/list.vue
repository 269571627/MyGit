<template>
  <div>
    <ul>
      <li v-for="item in showlist" :key="item.id">
        {{item.title}}
        <button @click="deleteItem(item.id)">删除</button>
      </li>
    </ul>
    {{msg}}
    <!-- $attrs相当于拿到了没有在props定义的sendGrandF值 -->
    <ListSonDemo v-bind="$attrs" v-on="$listeners" />
  </div>
</template>

<script>
import event from "./event";
import ListSonDemo from "./listson";

export default {
  name: "ListDemo",
  // props:['showlist'] 接收
  props: {
    //prop 类型和默认值
    showlist: {
      type: Array,
      default() {
        return [];
      },
    },
  },
  inject: ["foo"],
  data() {
    return {
      msg: "",
    };
  },
  components: {
    ListSonDemo,
  },
  methods: {
    deleteItem(id) {
      console.log("deleteItem 子$emit传值", id);
      this.$emit("delete", id);
    },
    broDoTitle(title) {
      console.log("Bro title", title);
    },
  },
  provide: {
    foo2: "provide 子传孙",
  },
  created() {
    console.log("list created");
    this.msg = this.foo;
  },

  //实例被挂载后调用:
  mounted() {
    console.log("list mounted");
    event.$on("sendBroTitle", this.broDoTitle);
    console.log("list", this.$attrs);
  },

  beforeUpdate() {
    console.log("list beforeUpdate");
  },
  updated() {
    console.log("list updated");
  },

  //及时解绑销毁，否则会造成内存泄漏
  beforeDestroy() {
    console.log("list beforeDestroy");
    console.log("beforeDestor");
    event.$off("sendBroTitle", this.broDoTitle);
  },

  destroyed() {
    console.log("list destroyed");
  },
};
</script>

<style>
li {
  list-style: none;
}
</style>
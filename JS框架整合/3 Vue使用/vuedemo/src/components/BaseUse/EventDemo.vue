<template>
  <div>
    <h4>(6)EventDemo</h4>
    <p>运算结果：{{num}}</p>
    <button @click="addNum">+1</button>
    <button @click="subNum(1,$event)">-1</button>
    <h4>事件修饰符</h4>
    <a @click.stop="doThis">阻止单击事件继续传播</a>
    <form @submit.prevent="onSubmit">提交事件不再重载页面</form>
    <a @click.stop.prevent="doThat">修饰符可以串联</a>
    <form @submit.prevent>只有修饰符</form>
    <div @click.capture="doThis">添加事件监听器时使用事件捕获模式...内部元素触发的事件先在此处理，然后交由内部元素进行处理</div>
    <div @click.self="doThat">只有在event.target是当前元素自身时触发处理函数，即事件不是从内部元素触发</div>
    <h4>按键修饰符</h4>
    <button @click.ctrl="onClick">Alt或Shift被一同按下也会触发</button>
    <button @click.ctrl.exact="onCtrlClick">只有Ctrl被按下时触发</button>
    <button @click.exact="onClick">没有任何系统修饰符被按下时触发</button>
    <a v-on:click.once="doThis">点击事件将只会触发一次</a>
    <div v-on:scroll.passive="onScroll">...滚动事件的默认行为 (即滚动行为) 将会立即触发,而不会等待 `onScroll` 完成,包含 `event.preventDefault()`</div>
    <h4>总结：3-3 事件、修饰符</h4>
    <hr />
  </div>
</template>

<script>
export default {
  name: "EventDemo",
  data() {
    return {
      num: 0,
    };
  },
  methods: {
    addNum(event) {
      console.log("add", event, event.__proto__.constructor); //enent是原生的
      console.log("add", event.target); //监听挂载对象
      console.log("add", event.currentTarget); //触发对象
      this.num++;
    },
    subNum(val, event) {
      console.log("sub", event);
      console.log("sub", event.target);
      this.num -= val;
    },
  },
};
</script>

<style>
button {
  display: inline;
  margin: 8px;
}
li {
  list-style: none;
}
</style>
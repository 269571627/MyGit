<template>
  <div>
    <h4>(3)slot</h4>

      <a href="fsendSonObj.url">
        <slot name="basic">
          基础使用————
          {{fsendSonObj.url}}{{fsendSonObj.msg}}
          (默认内容，即父组件没设置内容时在这里显示)
        </slot>
      </a>



      <a href="sonSlot.url">
        <slot :sonMsg="slotObj" name='scoped'>作用域插槽————默认内容：{{slotObj.url}}{{slotObj.msg}}</slot>
      </a>

      <slot></slot>
  </div>
</template>

<script>
export default {
  name: "SlotDemo",
  props: {
    fsendSonObj: {
      type: Object,
      default() {
        return {};
      },
    },
  },
  data() {
    return {
      slotObj: {
        url: "sonSlot.url",
        msg: "我是子插槽传递的内容",
      },
    };
  },
};
</script>

<style>
</style>
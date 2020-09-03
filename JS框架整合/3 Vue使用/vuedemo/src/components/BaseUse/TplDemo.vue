<template>
  <div>
    <h4>(1)TplDemo</h4>
    <p>文本插值实例：{{message}}</p>
    <p>JS表达式实例：此时data中flag为{{flag}}显示{{flag? 'yes' : 'no'}} (只能是表达式不能是JS语句)</p>
    <p v-html="rawHtml">
        <span>有xss危险</span>
      <span>注：使用v-html后会覆盖子元素</span>
    </p>
    <p :id="dynamicId">动态属性id：{{dynamicId}}</p>
    <h4>总结 3-2 插值、指令</h4>
    <hr>
  </div>
</template>

<script>
export default {
  name: "TplDemo",
  data() {
    return {
      message:
        "指令、插值知识点:插值、表达式|指令、动态属性|v-html:有XSS风险，会覆盖子组件",
      flag: "true",
      rawHtml:'插值覆盖实例：<b>覆盖</b>掉子元素<i>span</i>了',
      dynamicId:`id-${Date.now()}`
    };
  },
};
</script>

<style>
</style>
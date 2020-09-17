<template>
  <div>
    <h1>{{msg}}(BaseUse)</h1>
    <hr>
    <h3>目录</h3>
    <h3>1 指令、插值:TplDemo</h3>
    <h3>2 计算属性和侦听器:ComputedDemo&WatchDemo</h3>
    <h3>3 class&style:ClassDemo</h3>
    <h3>4 条件渲染:IfShowDemo</h3>
    <h3>5 循环渲染:ListDemo</h3>
    <h3>6 事件、修饰符:EventDemo</h3>
    <h3>7 表单:FormDemo</h3>
    <hr>
    <TplDemo/>
    <WatchDemo/>
    <ComputedDemo/>
    <ClassDemo/>
    <IfShowDemo/>
    <ListDemo/>
    <EventDemo/>
    <FormDemo/>
  </div>
</template>

<script>
import TplDemo from './BaseUse/TplDemo'
import WatchDemo from './BaseUse/WatchDemo'
import ComputedDemo from './BaseUse/ComputedDemo'
import ClassDemo from './BaseUse/ClassDemo'
import IfShowDemo from './BaseUse/IfShowDemo'
import ListDemo from './BaseUse/ListDemo'
import EventDemo from './BaseUse/EventDemo'
import FormDemo from './BaseUse/FormDemo'
export default {
  name: 'VueDemo',
  props: {
    msg: String
  },
  components:{
    TplDemo,
    WatchDemo,
    ComputedDemo,
    ClassDemo,
    IfShowDemo,
    ListDemo,
    EventDemo,
    FormDemo
  }
}
</script>

<!-- Add "scoped" attribute to limit CSS to this component only -->
<style scoped>
h3 {
  margin: 40px 0 0;
}
ul {
  list-style-type: none;
  padding: 0;
}
li {
  display: inline-block;
  margin: 0 10px;
}
a {
  color: #42b983;
}
</style>

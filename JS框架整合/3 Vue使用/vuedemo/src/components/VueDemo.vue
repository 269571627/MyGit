<template>
  <div>
    <h1>{{msg}}</h1>
    <hr>
    <h2>目录</h2>
    <h3>1 指令、插值:TplDemo</h3>
    <h3>2 计算属性和侦听器:ComputedDemo&WatchDemo</h3>
    <h3>3 class&style:ClassDemo</h3>
    <hr>
    <TplDemo/>
    <WatchDemo/>
    <ComputedDemo/>
    <ClassDemo/>
    <IfShowDemo/>
  </div>
</template>

<script>
import TplDemo from './BaseUse/TplDemo'
import WatchDemo from './BaseUse/WatchDemo'
import ComputedDemo from './BaseUse/ComputedDemo'
import ClassDemo from './BaseUse/ClassDemo'
import IfShowDemo from './BaseUse/IfShowDemo'
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
    IfShowDemo
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

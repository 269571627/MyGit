<template>
  <div>
      <h4>(6)MixInDemo</h4>
      <div>
          <p>{{number}}:{{name}}————{{classroom}}</p>
          <button @click="showItem">打印信息</button>
      </div>
  </div>
</template>

<script>
import myMixIns from './myMixIns'
export default {
    mixins:[myMixIns],
    name:'MixInDemo',
    data(){
        return{
            name:'大大',
            number:'x86',
        }
    },
    mounted(){
        console.log('main mounted')
    }
}
</script>

<style>

</style>
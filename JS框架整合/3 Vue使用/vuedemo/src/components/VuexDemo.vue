<template>
  <div>
    <h1>{{msg}}(Vuex)</h1>
    <p>Vuex————store中获取state中的count：{{countGet}}</p>
    <button @click="addCount">同步点击执行count+1</button>
    <button @click="addCountByasync">异步点击执行count+4</button>
    <button @click="addCountByasyncAction">触发action异步点击执行count+5</button>
    <p>Vuex————store中获取state中的map：{{mapGet}}</p>
    <p>计算值count+num：{{countFnState}}</p>
    <p>{{tip}}</p>
    <p>mapGMsg:{{mapGMsg}}</p>
    <ul>
      <li v-for="(item,index) in getlists" :key="index">{{item.id}}:{{item.name}}</li>
    </ul>
    <p>getters:{{getlistsitem}}</p>
    <hr>
  </div>

</template>

<script>
import { mapGetters, mapState } from "vuex";

export default {
  name: "VuexDemo",
  props: {
    msg: String,
  },
  /** 普通获取state
   * computed: {
    countGet() {
      return this.$store.state.count;
    },
    mapGet(){
      return this.$store.state.map;
    }
  },
   * 
   */

  //mapState获取state

  //【1】
  // computed: mapState({
  //   //1. // 箭头函数
  //   // countGet:state=>state.count,
  //   mapGet: (state) => state.map,

  //   //2.直接传字符串参数
  //   countGet: "count",

  //   //3.方法
  //   countFnState(state) {
  //     return state.count + this.num;
  //   },
  // }),

  //对象的展开运算符
  //【2】
  computed: {
    //state
    ...mapState(["tip"]),//上{{tip}}和state中tip为相同
    ...mapState({
      countGet: "count",
      mapGet: (state) => state.map,
      countFnState(state) {
        return state.count + this.num;
      },
    }),

    //getters
    getlists(){
      return this.$store.getters.lists
    },
    ...mapGetters(['mapGMsg']),
    getlistsitem(){
      return this.$store.getters.listsitem(2)
    }
  },
  data() {
    return {
      num: 1,
    };
  },
  methods: {
    addCount(){
      //不能直接修改state中的count，只能通过mutations提交
      // this.$store.state.count++

      //普通提交
      // this.$store.commit('addNum',1)

      //对象方式提交
      this.$store.commit({
        type:'addNum',
        num:this.num,
      })

    },
    addCountByasync(){
      this.$store.commit('addNumByAsync',{number:4})
    },
    addCountByasyncAction(){
      this.$store.dispatch('addNumByAsyncActions',{number:5})
    }
  },
  mounted() {
    console.log("vux", this.getlistsitem);
  },
};
</script>

<style>
</style>
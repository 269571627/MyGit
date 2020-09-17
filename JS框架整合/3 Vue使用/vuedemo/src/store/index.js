import Vue from 'vue'
import Vuex from 'vuex'

//注入
Vue.use(Vuex)

const store = new Vuex.Store({
  state: {
    count:1,
    map:"使用mapState简化代码",
    tip:"定义为相同情况",
    list:[
      {
        id:1,name:"张三"
      },
      {
        id:2,name:"李四"
      },
      {
        id:3,name:"王二"
      }
    ],
    mapGetters:"我是mapGetters"
  },
  getters:{
    lists(state){
      return state.list
    },
    listsitem:(state)=>(i)=>{
      return state.list[i]
    },
    mapGMsg(state){
      return state.mapGetters
    }
  },
  //mutations中的方法是同步的
  mutations: {
    addNum(state,payload){
      console.log("payload",payload)
      state.count+=payload.num
    },
    //不要在这里操作异步数据,应该放在actions中，虽然页面数据没问题但是在控制台查看state的count会发现没有改变
    addNumByAsync(state,payload){
      setTimeout(()=>{
        state.count+=payload.number
      })
    },

    addNumByAsync2(state,num){
      //num是actions中commit出来了payload.number
        state.count+=num
      
    }

  },
  actions: {
    addNumByAsyncActions({commit},payload){
      console.log("{commit}",{commit})
      setTimeout(()=>{
        //commit触发mutations方法
        commit('addNumByAsync2',payload.number)
      },1000)
    }
  },
  modules: {
  }
})


export default store
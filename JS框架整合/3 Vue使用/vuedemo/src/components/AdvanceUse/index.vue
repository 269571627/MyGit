<template>
  <div>
    <h1>{{msg}}(AdvanceUse)</h1>
    <hr />
    <h3>目录</h3>
    <h3>1 自定义v-model(CustomVmodel)</h3>
    <h3>2 $nextTick(NextTick)</h3>
    <h3>3 slot(SlotDemo)</h3>
    <h3>4 keep-alive(KeepAlive)</h3>
    <h3>5 动态组件</h3>
    <h3>6 mixin(MixInDemo)</h3>
    <hr />
    <CustomVmodel v-model="textOne" />
    <p>数据显示：{{textOne}}</p>
    <hr />
    <NextTick @addListItem="doAddtwo" />
    <ul ref="ulE">
      <li v-for="(item,index) in list" :key="index">{{item}}</li>
    </ul>
    <hr />

    <SlotDemo :fsendSonObj="slotObj">
      <template v-slot:basic>
        <p v-if="slotFlag===true">基础使用——父传子——{{slotObj.msg}}</p>
      </template>

      <template v-slot:scoped="sonSlotMsg">
        <p v-if="slotFlag2===true">作用域插槽——子传父——{{sonSlotMsg.sonMsg.msg}}</p>
      </template>

      <p>父组件默认slot内容</p>
    </SlotDemo>
    <button @click="changeFlag">slot基础使用：显示/隐藏默认插槽值</button>

    <button @click="changeFlag2">slot作用域插槽使用：显示/隐藏默认插槽值</button>
    <hr>
    <KeepAlive/>
    <hr>
    <h4>(5)动态组件————引入next-tick组件</h4>
    <component :is="chooseNextTick" @addListItem="doAddtwo"></component>
    <ul ref="ulE">
      <li v-for="(item,index) in list" :key="index">{{item}}</li>
    </ul>
    <hr>
    <MixInDemo/>
  </div>
</template>

<script>
import CustomVmodel from "./CustomVmodel";
import NextTick from "./NextTick";
import SlotDemo from "./SlotDemo";
import KeepAlive from "./KeepAlive";
import MixInDemo from "./MixInDemo";
export default {
  name: "AdvanceUseDemo",
  props: {
    msg: {
      type: String,
      default() {
        return "";
      },
    },
  },
  components: {
    CustomVmodel,
    NextTick,
    SlotDemo,
    KeepAlive,
    MixInDemo
  },
  data() {
    return {
      textOne: "123",
      list: ["a", "b", "c"],
      slotObj: {
        url: "slotFather.url",
        msg: "我是父级插槽内容",
      },
      slotFlag: true,
      slotFlag2: true,
      chooseNextTick:'NextTick'
    };
  },
  methods: {
    doAddtwo(val) {
      this.list.push(val);
      this.list.push(`${Date.now()}`);
      this.list.push(`${Date.now()}`);

      //异步渲染，待DOM渲染完后再回调
      //页面渲染时整合data修改，每次点击按钮只渲染一次
      this.$nextTick(() => {
        //获取DOM元素
        const ulElment = this.$refs.ulE;
        console.log(
          "$nextTick",
          ulElment.childNodes,
          ulElment.childNodes.length
        );
      });
    },
    changeFlag() {
      this.slotFlag = !this.slotFlag;
    },
    changeFlag2() {
      this.slotFlag2 = !this.slotFlag2;
    },
    changeState() {
      this.slotObj.slotState = !this.slotObj.slotState;
    },
  },
};
</script>

<style>
</style>
<template>
  <div>
    <h4>(7)FormDemo</h4>

    <p>名字：{{name}}</p>
    <!-- 自动过滤用户输入的首尾空白字符 -->
    <input type="text" v-model.trim="name" />

    <p>班级：{{classRoom}}</p>
    <!-- 在每次 input 事件触发后将输入框的值与数据进行同步 -->
    <input type="text" v-model.lazy="classRoom" />

    <p>年龄：{{age}}</p>
    <!-- 自动将用户的输入值转为数值类型 -->
    <input v-model.number="age" type="number" />

    <!-- 注：在文本区域插值 (<textarea>{{text}}</textarea>) 并不会生效，应用 v-model 来代替。 -->
    <p>多行文本：{{desc}}</p>
    <textarea cols="30" rows="10" v-model="desc"></textarea>

    <p>复选框：{{checked}}</p>
    <input type="checkbox" v-model="checked" />

    <p>多个复选框：{{checkNameAll}}</p>
    <input type="checkbox" value="A" v-model="checkNameAll" />
    <label for="A">A</label>
    <input type="checkbox" value="B" v-model="checkNameAll" />
    <label for="B">B</label>
    <input type="checkbox" value="C" v-model="checkNameAll" />
    <label for="C">C</label>

    <p>单选按钮：{{ picked }}</p>
    <input type="radio" id="one" value="One" v-model="picked" />
    <label for="one">One</label>
    <input type="radio" id="two" value="Two" v-model="picked" />
    <label for="two">Two</label>

    <p>下拉列表（单选）：{{ selected }}</p>
    <select v-model="selected">
      <option disabled value>请选择</option>
      <option>A</option>
      <option>B</option>
      <option>C</option>
    </select>


    <p>下拉列表（多选）：{{ selectedList }}</p>
    <select v-model="selectedList" multiple>
      <option disabled value>请选择</option>
      <option>A</option>
      <option>B</option>
      <option>C</option>
    </select>

    <h4>总结 3-3 表单</h4>
    <hr />
  </div>
</template>

<script>
export default {
  name: "FormDemo",
  data() {
    return {
      name: "",
      classRoom: "",
      age: "",
      desc: "",
      checked: true,
      checkNameAll: [],
      picked: "",
      selected:'',
      selectedList:[]
    };
  },
};
</script>

<style>
</style>
<template>
    <div>
            <h4>(4)keep-alive</h4>
        <button @click="changeState('A')">A</button>
        <button @click="changeState('B')">B</button>
        <button @click="changeState('C')">C</button>

        <!-- <keep-alive>       -->
            <keepA v-if="state === 'A'"/> <!-- v-show -->
            <keepB v-if="state === 'B'"/>
            <keepC v-if="state === 'C'"/>
        <!-- </keep-alive> -->
    </div>
</template>

<script>
import keepA from './keepA'
import keepB from './keepB'
import keepC from './keepC'

export default {
    name:'KeepAlive',
    components: {
        keepA,
        keepB,
        keepC
    },
    data() {
        return {
            state: 'A'
        }
    },
    methods: {
        changeState(state) {
            this.state = state
        }
    }
}
</script>
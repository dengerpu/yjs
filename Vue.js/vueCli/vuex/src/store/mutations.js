import { INCREMENT, DECREMENT } from "./motations-types.js"
import Vue from 'vue'
export default {
   [INCREMENT](state) {  // 默认会传入state
        state.counter++
    },
    [DECREMENT](state) {
        state.counter--
    },
    addCounter(state, n) {
        state.counter += n
    },
    subCounter(state, payload) {
        state.counter -= payload.count
    },
    updateInfo(state) {
        state.info.name = 'modify'

        // 错误的代码: 不能在这里进行异步操作
        // setTimeout(() => {
        //   state.info.name = 'modify'
        // }, 1000)
    
        //state.info['address'] = '洛杉矶'
    
        //Vue.set(state.info, 'address', '洛杉矶')
        // 该方式做不到响应式
    
        // delete state.info.age
        //Vue.delete(state.info, 'age')
    }
}
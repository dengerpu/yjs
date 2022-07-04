import Vue from 'vue'
import Vuex from 'vuex'

import mutations from './mutations'
import getters from './getters'

Vue.use(Vuex)

const state = {
  counter: 0,
  students: [
    {id: 110, name: 'aaa', age: 18},
    {id: 111, name: 'bbb', age: 24},
    {id: 112, name: 'ccc', age: 30},
    {id: 113, name: 'ddd', age: 10}
  ],
  info: {
    name: 'abc',
    age: 18
  }
}

const store =  new Vuex.Store({
  state,
  mutations,
  getters,
  actions: {
  },
  modules: {
  }
})

export default store

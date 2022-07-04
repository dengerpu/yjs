export default {
    powerCounter(state) {
        return state.counter * state.counter
    },
    more20Age(state) {
        return state.students.filter(s => s.age >= 20) 
    },
    more20AgeLength(state, getters){
        return getters.more20Age.length
    },
    moreAgestu(state) {
        // return function (age) {
        //   return state.students.filter(s => s.age > age)
        // }
        return age => {
            return state.students.filter(s => s.age >= 20)
        }
    }
}
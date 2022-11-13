import Teacher from "../model/teacher";
import {createStore} from "vuex";
import axios from "axios";


let store = createStore({
    state: {
        teacher: new Teacher('Рамзия', 'Маняхина', 'Накиповна'),
    },
    mutations: {
        SET_ENUMS(state, enums) {
            state.enums = enums
        }
    },
    actions: {
        LOAD_ENUMS({commit}) {
            let url = 'http://localhost:8080/enum'
            return axios(url, { method: 'GET'})
                .then((enums) => {
                    commit('SET_ENUMS', enums)
                })
                .catch((error) => { console.log(error) })
        }
    },
    modules: {},
    getters: {
        GET_TEACHER(state) {
            return state.teacher
        },
        GET_ENUMS(state) {
            return state.enums
        },
        GET_TEACHER_CATEGORIES(state) {
            return state.enums.categories
        }
    }
})

export default store;
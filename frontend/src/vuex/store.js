import Teacher from "../model/teacher";
import {createStore} from "vuex";
import axios from "axios";

let store = createStore({
    state: {
        teacher: new Teacher('Рамзия', 'Маняхина', 'Накиповна'),
        enums: {},
        departments: []
    },
    mutations: {
        SET_ENUMS: (state, enums) => {
            state.enums = enums
            state.enums.category = enums.Category
            state.enums.employmentType = enums.EmploymentType
            state.enums.position = enums.Position
        },
        SET_DEPARTMENTS: (state, departments) => {
            state.departments = departments
        }
    },
    actions: {
        LOAD_ENUMS({commit}) {
            let url = '/api/enum'
            return axios(url, { method: 'GET'})
                .then((enums) => {
                    commit('SET_ENUMS', enums.data)
                    return enums.data
                })
                .catch((error) => { console.log(error) })
        },
        LOAD_DEPARTMENTS({commit}){
            let url = '/api/department/all'
            return axios(url, { method: 'GET'})
            .then((departments) => {
                commit('SET_DEPARTMENTS', departments.data)
                return departments.data
            })
            .catch((error) => {
                console.log(error)
            })
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
            return state.enums.category
        },
        GET_EMPLOYMENT_TYPES(state){
            return state.enums.employmentType
        },
        GET_POSITIONS(state){
            return state.enums.position
        },
        GET_ALL_DEPARTMENTS(state){
            return state.departments
        },
    },
})

export default store;
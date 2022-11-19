import Teacher from "../model/teacher";
import {createStore} from "vuex";
import axios from "axios";

let store = createStore({
    state: {
        teacher: new Teacher('Рамзия', 'Маняхина', 'Накиповна'),
        enums: {},
        departments: [],
        specializations: [],
        disciplines: [],
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
        },
        SET_SPECIALIZATIONS: (state, specializations) => {
            state.specializations = specializations
        },
        SET_ACADEMIC_DISCIPLINES: (state, disciplines) => {
            state.disciplines = disciplines
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
        },
        LOAD_SPECIALIZATION({commit}){
            let url = '/api/specialization/all'
            return axios(url, { method: 'GET'})
            .then((specializations) => {
                commit('SET_SPECIALIZATIONS', specializations.data)
                return specializations.data
            })
            .catch((error) => {
                console.log(error)
            })
        },
        LOAD_ACADEMIC_DISCIPLINE({commit}){
            let url = '/api/discipline/all'
            return axios(url, { method: 'GET'})
            .then((disciplines) => {
                commit('SET_ACADEMIC_DISCIPLINES', disciplines.data)
                return disciplines.data
            })
            .catch((error) => {
                console.log(error)
            })
        },
        LOAD_SPECIALIZATION({commit}){
            let url = '/api/specialization/all'
            return axios(url, { method: 'GET'})
            .then((specializations) => {
                commit('SET_SPECIALIZATIONS', specializations.data)
                return specializations.data
            })
            .catch((error) => {
                console.log(error)
            })
        },
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
        GET_ALL_SPECIALIZATIONS(state){
            return state.specializations
        },
        GET_ALL_ACADEMIC_DISCIPLINES(state){
            return state.disciplines
        },
    },
})

export default store;
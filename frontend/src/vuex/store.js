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
        academicWork: []
    },
    mutations: {
        SET_ENUMS: (state, enums) => {
            state.enums = enums
            state.enums.category = enums.Category
            state.enums.employmentType = enums.EmploymentType
            state.enums.position = enums.Position
        },
        SET_GROUPS: (state, groups) => {
            state.groups = groups;
        },
        SET_DEPARTMENTS: (state, departments) => {
            state.departments = departments
        },
        SET_SPECIALIZATIONS: (state, specializations) => {
            state.specializations = specializations
        },
        SET_ACADEMIC_DISCIPLINES: (state, disciplines) => {
            state.disciplines = disciplines
        },
        SET_ACADEMIC_WORK: (state, works) => {
            state.academicWork = works
        },
        ADD_ACADEMIC_WORK: (state, academicWork) => {
            console.log(academicWork);
            state.academicWork.push(academicWork)
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
        LOAD_ACADEMIC_WORKS({commit}) {
            let url = '/api/work/all'
            return axios(url, { method: 'GET'})
                .then((works) => {
                    commit('SET_ACADEMIC_WORK', works.data)
                    return works.data
                })
                .catch((error) => {
                    console.log(error)
                })
        },
        LOAD_GROUPS({commit}){
            let url = '/api/group/all'
            return axios(url, { method: 'GET'})
                .then((groups) => {
                    commit('SET_GROUPS', groups.data)
                    return groups.data
                })
                .catch((error) => {
                    console.log(error)
                })
        },
        UPLOAD_ACADEMIC_WORK({commit}, work) {
            let url = '/api/work/create';
            let data = {
                academicDisciplineId: work.discipline.id,
                specializationId: work.specialization.id,
                groupId: work.group.id
            }

            return axios.post(url, data)
                .then((work) => {
                    commit('ADD_ACADEMIC_WORK', work.data)
                    return work.data;
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
        GET_ALL_SPECIALIZATIONS(state){
            return state.specializations
        },
        GET_ALL_ACADEMIC_DISCIPLINES(state){
            return state.disciplines
        },
        GET_ACADEMIC_WORK(state) {
            return state.academicWork
        },
        GET_ALL_GROUPS(state) {
            return state.groups
        }
    },
})

export default store;
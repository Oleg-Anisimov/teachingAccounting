import axios from "axios";

export const categoryBased = {
    namespaced: true,
    state: {
        specializations: [],
        academicDisciplines: [],
        enums: {},
        departments: [],
    },
    getters: {
        GET_ALL_SPECIALIZATIONS(state){
            return state.specializations
        },
        GET_ALL_ACADEMIC_DISCIPLINES(state){
            return state.academicDisciplines
        },
        GET_ALL_GROUPS(state) {
            return state.groups
        },
        GET_ENUMS(state) {
            return state.enums
        },
        GET_TEACHER_CATEGORIES(state) {
            return state.enums.category
        },
        GET_EMPLOYMENT_TYPES(state) {
            return state.enums.employmentType
        },
        GET_POSITIONS(state) {
            return state.enums.position
        },
        GET_ALL_DEPARTMENTS(state) {
            return state.departments
        },
        GET_ALL_DEPARTMENTS_NAMES(state) {
            return state.departments.map((d) => d.name)
        },
    },
    mutations: {
        SET_SPECIALIZATIONS: (state, specializations) => {
            state.specializations = specializations
        },
        SET_ACADEMIC_DISCIPLINES: (state, academicDisciplines) => {
            state.academicDisciplines = academicDisciplines
        },
        SET_GROUPS: (state, groups) => {
            state.groups = groups;
        },
        SET_ENUMS: (state, enums) => {
            state.enums = enums
            state.enums.category = enums.Category
            state.enums.employmentType = enums.EmploymentType
            state.enums.position = enums.Position
        },
        SET_DEPARTMENTS: (state, departments) => {
            state.departments = departments
        },
    },
    actions: {
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
            .then((academicDisciplines) => {
                commit('SET_ACADEMIC_DISCIPLINES', academicDisciplines.data)
                return academicDisciplines.data
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

    },

}
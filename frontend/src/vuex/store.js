import Teacher from "../model/teacher";
import {createStore} from "vuex";
import axios from "axios";

let store = createStore({
    state: {
        teacher: new Teacher('Рамзия', 'Маняхина', 'Накиповна'),
        enums: {},
        departments: [],
        specializations: [],
        academicDisciplines: [],
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
        SET_ACADEMIC_DISCIPLINES: (state, academicDisciplines) => {
            state.academicDisciplines = academicDisciplines
        },
        SET_ACADEMIC_WORK: (state, works) => {
            state.academicWork = works
        },
        SET_ACADEMIC_METHOD: (state, methods) => {
            state.academicMethod = methods
        },
        SET_ORGANIZED_METHOD: (state, organs) => {
            state.organizedMethod = organs
        },
        SET_SCIENTIFIC_METHOD: (state, sciens) => {
            state.scientificMethod = sciens
        },
        SET_ACADEMIC_PRODUCTION: (state, products) => {
            state.academicProduction = products
        },
        SET_EDUCATE_WORK: (state, educats) => {
            state.educateWork = educats
        },
        SET_PROMOTION_QUALIFICATION_LVL: (state, lvls) => {
            state.promotionQualificationLvl = lvls
        },
        ADD_ACADEMIC_WORK: (state, academicWork) => {
            console.log(academicWork);
            state.academicWork.push(academicWork)
        },
        ADD_ACADEMIC_METHOD: (state, academicMethod) => {
            console.log(academicMethod);
            state.academicMethod.push(academicMethod)
        },
        ADD_ORGANIZ_METHOD: (state, organizedMethod) => {
            console.log(organizedMethod);
            state.organizedMethod.push(organizedMethod)
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
            .then((academicDisciplines) => {
                commit('SET_ACADEMIC_DISCIPLINES', academicDisciplines.data)
                return academicDisciplines.data
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
        LOAD_ACADEMIC_METHODS({commit}) {
            let url = '/api/methods/all'
            return axios(url, { method: 'GET'})
                .then((methods) => {
                    commit('SET_ACADEMIC_METHOD', methods.data)
                    return methods.data
                })
                .catch((error) => {
                    console.log(error)
                })
        },
        LOAD_ORGANIZED_METHODS({commit}) {
            let url = '/api/organized/all'
            return axios(url, { method: 'GET'})
                .then((organs) => {
                    commit('SET_ORGANIZED_METHOD', organs.data)
                    return organs.data
                })
                .catch((error) => {
                    console.log(error)
                })
        },
        LOAD_SCIENTIFIC_METHODS({commit}) {
            let url = '/api/scientific/all'
            return axios(url, { method: 'GET'})
                .then((sciens) => {
                    commit('SET_SCIENTIFIC_METHOD', sciens.data)
                    return sciens.data
                })
                .catch((error) => {
                    console.log(error)
                })
        },
        LOAD_ACADEMIC_PRODUCTIONS({commit}) {
            let url = '/api/production/all'
            return axios(url, { method: 'GET'})
                .then((products) => {
                    commit('SET_ACADEMIC_PRODUCTION', products.data)
                    return products.data
                })
                .catch((error) => {
                    console.log(error)
                })
        },
        LOAD_EDUCATE_WORKS({commit}) {
            let url = '/api/educate/all'
            return axios(url, { method: 'GET'})
                .then((educats) => {
                    commit('SET_EDUCATE_WORK', educats.data)
                    return educats.data
                })
                .catch((error) => {
                    console.log(error)
                })
        },
        LOAD_PROMOTION_QUALIFICATION_LVLS({commit}) {
            let url = '/api/promotion/all'
            return axios(url, { method: 'GET'})
                .then((lvls) => {
                    commit('SET_PROMOTION_QUALIFICATION_LVL', lvls.data)
                    return lvls.data
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
            console.log()
            let url = '/api/work/create';
            let data = {
                academicDisciplineId: work.academicDiscipline.id,
                specializationId: work.specialization.id,
                groupId: work.group.id
            }
            console.log(data)
            return axios.post(url, data)
                .then((work) => {
                    commit('ADD_ACADEMIC_WORK', work.data)
                    return work.data;
                })
                .catch((error) => {
                    console.log(error)
                })
        },
        UPLOAD_ACADEMIC_METHOD({commit}, method) {
            let url = '/api/methods/create';
            let data = {
                academicDisciplineId: method.academicDiscipline.id,
                specializationId: method.specialization.id,
            }

            return axios.post(url, data)
                .then((method) => {
                    commit('ADD_ACADEMIC_METHOD', method.data)
                    return method.data;
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
            return state.academicDisciplines
        },
        GET_ACADEMIC_WORK(state) {
            return state.academicWork
        },
        GET_ACADEMIC_METHOD(state) {
            return state.academicMethod
        },
        GET_ORGANIZED_METHOD(state) {
            return state.organizedMethod
        },
        GET_SCIENTIFIC_METHOD(state) {
            return state.scientificMethod
        },
        GET_ACADEMIC_PRODUCTION(state) {
            return state.academicProduction
        },
        GET_EDUCATE_WORK(state) {
            return state.educateWork
        },
        GET_PROMOTION_QUALIFICATION_LVL(state) {
            return state.promotionQualificationLvl
        },
        GET_ALL_GROUPS(state) {
            return state.groups
        },
    },
})

export default store;
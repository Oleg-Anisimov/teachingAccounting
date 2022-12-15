import Teacher from "../model/teacher";
import {createStore} from "vuex";
import axios from "axios";
import qs from 'qs'

let store = createStore({
    state: {
        currentUser: {},
        teacher: {},
        enums: {},
        departments: [],
        specializations: [],
        academicDisciplines: [],
        academicWork: [],
        academicMethod: []
    },
    mutations: {
        SET_CURRENT_USER: (state, user) => {
            console.log("trying to commit")
            state.currentUser = user
        },
        SET_TEACHER: (state, teacher) => {
            state.teacher = teacher
        },
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
            works.forEach((w) => {
                w.specialization = state.specializations.find((spec) => {return spec.id === w.specializationId})
                w.academicDiscipline = state.academicDisciplines.find((disc) => {return disc.id === w.academicDisciplineId})
                w.group = state.groups.find((group) => {return group.id === w.groupId})
            })
            console.log(works)
            state.academicWork = works
        },
        SET_ACADEMIC_METHOD: (state, methods) => {
            methods.forEach((m) => {
                m.specialization = state.specializations.find((spec) => {return spec.id === m.specializationId})
                m.academicDiscipline = state.academicDisciplines.find((disc) => {return disc.id === m.academicDisciplineId})
            })
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
        ADD_ORGANIZED_METHOD: (state, organizedMethod) => {
            console.log(organizedMethod);
            state.organizedMethod.push(organizedMethod)
        },
        ADD_SCIENTIFIC_METHOD: (state, scientificMethod) => {
            console.log(scientificMethod);
            state.scientificMethod.push(scientificMethod)
        },
        ADD_ACADEMIC_PRODUCTION: (state, academicProduction) => {
            console.log(academicProduction);
            state.academicProduction.push(academicProduction)
        },
        ADD_EDUCATE_WORK: (state, educateWork) => {
            console.log(educateWork);
            state.educateWork.push(educateWork)
        },
        ADD_PROMOTION_QUALIFICATION_LVL: (state, promotionQualificationLvl) => {
            console.log(promotionQualificationLvl);
            state.promotionQualificationLvl.push(promotionQualificationLvl)
        },
    },
    actions: {
        LOGIN({commit}, credentials) {
            const url = '/api/perform_login'
            const options = {
                method: 'POST',
                data: qs.stringify(credentials)
            }
            return axios(url, options)
                .then((response) => {
                    console.log(response.data)
                    commit('SET_CURRENT_USER', response.data)
                    return response
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
        LOAD_TEACHER({commit}) {
            let url = '/api/teacher'
            return axios.get(url)
                .then((response) => {
                    commit('SET_TEACHER', response.data)
                    return response.data
                })
                .catch((error) => {
                    console.log(error)
                })
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
            let url = '/api/work'
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
            let url = '/api/methods'
            return axios(url, { method: 'GET'})
                .then((methods) => {
                    commit('SET_ACADEMIC_METHOD', methods.data)
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
        UPLOAD_ACADEMIC_WORK({commit, getters}, work) {
            let url = '/api/work/create';
            let data = {
                academicDisciplineId: work.academicDiscipline.id,
                specializationId: work.specialization.id,
                groupId: work.group.id
            }
            console.log(getters)
            return axios.post(url, data)
                .then((work) => {
                    function transformWorkResponse(data) {
                        return {
                            id: data.id,
                            group: getters.GET_ALL_GROUPS.find((group) => {return group.id === data.groupId}),
                            academicDiscipline: getters.GET_ALL_ACADEMIC_DISCIPLINES.find((dis) => {return dis.id === data.academicDisciplineId}),
                            specialization: getters.GET_ALL_SPECIALIZATIONS.find((spec) => {return spec.id === data.specializationId})
                        }
                    }

                    let transformedWork = transformWorkResponse(work.data);
                    commit('ADD_ACADEMIC_WORK', transformedWork)
                    return work.data;
                })
                .catch((error) => {
                    console.log(error)
                })
        },
        UPLOAD_ACADEMIC_METHOD({commit, getters}, method) {
            let url = '/api/methods/create';
            let data = {
                academicDisciplineId: method.academicDiscipline.id,
                specializationId: method.specialization.id,
                activityType: method.activityType,
            }
            console.log(getters)
            return axios.post(url, data)
                .then((method) => {
                    function transformMethodResponse(data) {
                        return {
                            id: data.id,
                            academicDiscipline: getters.GET_ALL_ACADEMIC_DISCIPLINES.find((dis) => {return dis.id === data.academicDisciplineId}),
                            specialization: getters.GET_ALL_SPECIALIZATIONS.find((spec) => {return spec.id === data.specializationId}),
                            activityType: getters.GET_ENUMS.ActivityType.find((actType) => {return actType === data.activityType}),
                        }
                    }

                    let transformedMethod = transformMethodResponse(method.data);
                    commit('ADD_ACADEMIC_METHOD', transformedMethod)
                    return method.data;
                })
                .catch((error) => {
                    console.log(error)
                })
        },
        UPLOAD_ORGANIZED_METHOD({commit, getters}, organ) {
            let url = '/api/organized/create';
            console.log(getters)
            return axios.post(url, organ)
                .then((organResponse) => {
                    commit('ADD_ORGANIZED_METHOD', organResponse.data)
                    return organResponse.data;
                })
                .catch((error) => {
                    console.log(error)
                })
        },
        UPLOAD_SCIENTIFIC_METHOD({commit, getters}, scien) {
            let url = '/api/scientific/create';
            console.log(getters)
            return axios.post(url, scien)
                .then((scienResponse) => {
                    commit('ADD_SCIENTIFIC_METHOD', scienResponse.data)
                    return scienResponse.data;
                })
                .catch((error) => {
                    console.log(error)
                })
        },
        UPLOAD_ACADEMIC_PRODUCTION({commit, getters}, product) {
            let url = '/api/production/create';
            let data = {
                specializationId: product.specialization.id,
                activityType: product.activityType
            }
            console.log(getters)
            return axios.post(url, data)
                .then((product) => {
                    function transformProductResponse(data) {
                        return {
                            id: data.id,
                            specialization: getters.GET_ALL_SPECIALIZATIONS.find((spec) => {return spec.id === data.specializationId}),
                            activityType: getters.GET_ENUMS.ActivityType.find((actType) => {return actType === data.activityType}),
                        }
                    }
                    let transformedProduct = transformProductResponse(product.data);
                    commit('ADD_ACADEMIC_PRODUCTION', transformedProduct)
                    return product.data;
                })
                .catch((error) => {
                    console.log(error)
                })
        },
        UPLOAD_EDUCATE_WORK({commit, getters}, educate) {
            let url = '/api/educate/create';
            console.log(getters)
            return axios.post(url, educate)
                .then((educateResponse) => {
                    commit('ADD_EDUCATE_WORK', educateResponse.data)
                    return educateResponse.data;
                })
                .catch((error) => {
                    console.log(error)
                })
        },
        UPLOAD_PROMOTION_QUALIFICATION_LVL({commit, getters}, lvl) {
            let url = '/api/promotion/create';
            console.log(getters)
            return axios.post(url, lvl)
                .then((lvlResponse) => {
                    commit('ADD_PROMOTION_QUALIFICATION_LVL', lvlResponse.data)
                    return lvlResponse.data;
                })
                .catch((error) => {
                    console.log(error)
                })
        },

    },
    modules: {},
    getters: {
        GET_CURRENT_USER(state) {
            return this.state.currentUser
        },
        GET_TEACHER(state) {
            return state.teacher
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
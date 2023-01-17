import {createStore} from "vuex";
import axios from "axios";
import qs from 'qs';
import {user} from "./userStore";
import {academicWork} from "./pageStores/academicWork";
import {academicMethod} from "./pageStores/academicMethod";
import {categoryBased} from "./categoryBased";

let store = createStore({

    modules: {
        user,
        academicWork,
        academicMethod,
        categoryBased
    },

    state: {
        teacher: {},
    },
    mutations: {
        SET_TEACHER: (state, teacher) => {
            state.teacher = teacher
        },
        SET_ORGANIZED_METHOD: (state, organs) => {
            state.organizedMethod = organs
        },
        SET_SCIENTIFIC_METHOD: (state, sciens) => {
            state.scientificMethod = sciens
        },
        SET_ACADEMIC_PRODUCTION: (state, products) => {
            products.forEach((e) =>{
                e.specialization = state.specializations.find((spec) => {return  spec.id === e.specializationId})
            })
            state.academicProduction = products
        },
        SET_EDUCATE_WORK: (state, educats) => {
            state.educateWork = educats
        },
        SET_PROMOTION_QUALIFICATION_LVL: (state, lvls) => {
            state.promotionQualificationLvl = lvls
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
        LOAD_ORGANIZED_METHODS({commit}, pageRequest) {
            let url = '/api/organized'
            const options = {
                method: 'POST',
                data: qs.stringify(pageRequest)
            }
            return axios(url, options)
                .then((organs) => {
                    commit('SET_ORGANIZED_METHOD', organs.data.content)
                    return organs.data
                })
                .catch((error) => {
                    console.log(error)
                })
        },
        LOAD_SCIENTIFIC_METHODS({commit}, pageRequest) {
            let url = '/api/scientific'
            const options = {
                method: 'POST',
                data: qs.stringify(pageRequest)
            }
            return axios(url, options)
                .then((sciens) => {
                    commit('SET_SCIENTIFIC_METHOD', sciens.data.content)
                    console.log(sciens.data)
                    return sciens.data
                })
                .catch((error) => {
                    console.log(error)
                })
        },
        LOAD_ACADEMIC_PRODUCTIONS({commit}, pageRequest) {
            let url = '/api/production'
            const options = {
                method: 'POST',
                data: qs.stringify(pageRequest)
            }
            return axios(url, options)
                .then((products) => {
                    commit('SET_ACADEMIC_PRODUCTION', products.data.content)
                    console.log(products.data)
                    return products.data
                })
                .catch((error) => {
                    console.log(error)
                })
        },
        LOAD_EDUCATE_WORKS({commit}, pageRequest) {
            let url = '/api/educate'
            const options = {
                method: 'POST',
                data: qs.stringify(pageRequest)
            }
            return axios(url, options)
                .then((products) => {
                    commit('SET_EDUCATE_WORK', products.data.content)
                    console.log(products.data)
                    return products.data
                })
                .catch((error) => {
                    console.log(error)
                })
        },
        LOAD_PROMOTION_QUALIFICATION_LVLS({commit}, pageRequest) {
            let url = '/api/promotion'
            const options = {
                method: 'POST',
                data: qs.stringify(pageRequest)
            }
            return axios(url, options)
            
                .then((lvls) => {
                    commit('SET_PROMOTION_QUALIFICATION_LVL', lvls.data.content)
                    console.log(lvls.data)
                    return lvls.data
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
    getters: {
        GET_TEACHER(state) {
            return state.teacher
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
    },
})

export default store;
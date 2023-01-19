import {createStore} from "vuex";
import axios from "axios";
import {user} from "./userStore";
import {categoryBased} from "./categoryBased";
import {academicWork} from "./pageStores/academicWork";
import {academicMethod} from "./pageStores/academicMethod";
import {organizMethod} from "./pageStores/organizMethod";
import {scienMethod} from "./pageStores/scienMethod";
import {academicProduct} from "./pageStores/academicProduct";
import {educateWork} from "./pageStores/educateWork";
import {promotionQualificLVL} from "./pageStores/promotionQualificLVL";

let store = createStore({

    modules: {
        user,
        categoryBased,
        academicWork,
        academicMethod,
        organizMethod,
        scienMethod,
        academicProduct,
        educateWork,
        promotionQualificLVL
    },

    state: {
        teacher: {},
        specializations: [],
        academicDisciplines: [],
    },
    mutations: {
        SET_TEACHER: (state, teacher) => {
            state.teacher = teacher
        },
        SET_SPECIALIZATIONS: (state, specializations) => {
            state.specializations = specializations
        },
        SET_ACADEMIC_DISCIPLINES: (state, academicDisciplines) => {
            state.academicDisciplines = academicDisciplines
        },
        SET_GROUPS: (state, groups) => {
            state.groups = groups;
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


    },
    getters: {
        GET_TEACHER(state) {
            return state.teacher
        },
        GET_ALL_SPECIALIZATIONS(state){
            return state.specializations
        },
        GET_ALL_ACADEMIC_DISCIPLINES(state){
            return state.academicDisciplines
        },
        GET_ALL_GROUPS(state) {
            return state.groups
        },
    },
})

export default store;
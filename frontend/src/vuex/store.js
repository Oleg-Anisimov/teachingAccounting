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
import {methods} from "./dateMethods";

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
        promotionQualificLVL,
    },

    state: {
        teacher: {},
        specializations: [],
        academicDisciplines: [],
        departments: [],
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
        SET_DEPARTMENTS: (state, departments) => {
            state.departments = departments
        },
    },
    actions: {
        LOAD_TEACHER({commit}) {
            let url = '/api/teacher'
            return axios.get(url)
            .then((response) => {
                response.data.certificationDate = methods.methods.DATE_TO_STRING(response.data.certificationDate)
                console.log(response.data)
                commit('SET_TEACHER', response.data)
                return response.data
            })
            .catch((error) => {
                console.log(error)
            })
        },
        UPLOAD_TEACHER({commit, getters}, tec) {
            let url = '/api/teacher/update';
            let transformedTec = {
                id: tec.id,
                category: tec.category,
                department: tec.department,
                employmentType: tec.employmentType,
                position: tec.position,
                firstName: tec.firstName,
                lastName: tec.lastName,
                middleName: tec.middleName,
                certificationDate: tec.certificationDate,
                userId: user.getters.GET_ALL_USERS(user.state).find((user) => {return user.id === tec.userId}),
            }
            transformedTec.certificationDate = methods.methods.STRING_TO_DATE(transformedTec.certificationDate)
            console.log(transformedTec)
            return axios.post(url, transformedTec)
                .then((tecResponse) => {
                    commit('SET_TEACHER', transformedTec)
                    return tecResponse.data;
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
        STRING_TO_DATE(string){
            // dataToSplit = string.split('-')
            // dataToSplit[0] = parseInt(dataToSplit[0])
            // dataToSplit[1] = parseInt(dataToSplit[1])
            // dataToSplit[2] = parseInt(dataToSplit[2])
            // string = dataToSplit
            console.log(string)
            return string
        }

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
        GET_ALL_DEPARTMENTS_NAMES(state) {
            return state.departments.map((d) => d.name)
        },
        GET_ALL_DEPARTMENTS(state) {
            return state.departments
        },
    },
})

export default store;
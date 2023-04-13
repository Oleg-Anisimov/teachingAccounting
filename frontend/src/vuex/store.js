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
        cabinets: [],
        groups: []
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
        SET_CABINETS: (state, cabinets) => {
            state.cabinets = cabinets;
        },

        ADD_GROUP: (state, group) => {
            state.groups.push(group)
        },
        ADD_SPEC: (state, spec) => {
            state.specializations.push(spec)
        },
        ADD_DISCIPLINE: (state, disc) => {
            state.academicDisciplines.push(disc)
        }
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

        CREATE_GROUP({commit, getters}, groupName) {
            let url = '/api/group/create'
            let data = {
                id: 0,
                groupName: groupName
            }
            return axios.post(url, data)
                .then((res) => {
                    console.log(res)
                    commit('ADD_GROUP', res.data)
                })
                .catch(error => {
                    console.log(error)
                })
        },

        CREATE_SPECIALIZATION({commit, getters}, spec) {
            let url = '/api/specialization/create'
            let data = {
                id: 0,
                specialization: spec.specialization,
                specializationName: spec.specializationName
            }
            return axios.post(url, data)
                .then((res) => {
                    console.log(res)
                    commit('ADD_SPEC', res.data)
                })
                .catch(error => {
                    console.log(error)
                })
        },

        CREATE_DISCIPLINE({commit, getters}, disc) {
            let url = '/api/discipline/create'
            let data = {
                id: 0,
                disciplineNumber: disc.disciplineNumber,
                name: disc.disciplineName
            }
            return axios.post(url, data)
                .then((res) => {
                    console.log(res)
                    commit('ADD_DISCIPLINE', res.data)
                })
                .catch(error => {
                    console.log(error)
                })
        },


        LOAD_CABINETS({commit}) {
            const url = '/api/cabinet/all';
            return axios(url, {method: 'GET'})
            .then((cabinets) => {
                commit('SET_CABINETS', cabinets.data)
                return cabinets.data
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
        GET_ALL_DEPARTMENTS_NAMES(state) {
            return state.departments.map((d) => d.name)
        },
        GET_ALL_DEPARTMENTS(state) {
            return state.departments
        },
        GET_ALL_CABINETS(state) {
            return state.cabinets
        }
    },
})

export default store;
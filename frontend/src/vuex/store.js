import {createStore} from "vuex";
import axios from "axios";
import qs from 'qs';
import {user} from "./userStore";
import {categoryBased} from "./categoryBased";
import {academicWork} from "./pageStores/academicWork";
import {academicMethod} from "./pageStores/academicMethod";
import {organizMethod} from "./pageStores/organizMethod";
import {scienMethod} from "./pageStores/scienMethod";
import {academicProduct} from "./pageStores/academicProduct";
import {educateWork} from "./pageStores/educateWork";

let store = createStore({

    modules: {
        user,
        categoryBased,
        academicWork,
        academicMethod,
        organizMethod,
        scienMethod,
        academicProduct,
        educateWork
    },

    state: {
        teacher: {},
    },
    mutations: {
        SET_TEACHER: (state, teacher) => {
            state.teacher = teacher
        },
        SET_PROMOTION_QUALIFICATION_LVL: (state, lvls) => {
            state.promotionQualificationLvl = lvls
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
        GET_PROMOTION_QUALIFICATION_LVL(state) {
            return state.promotionQualificationLvl
        },
    },
})

export default store;
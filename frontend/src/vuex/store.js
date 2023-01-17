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
    },
    mutations: {
        SET_TEACHER: (state, teacher) => {
            state.teacher = teacher
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


    },
    getters: {
        GET_TEACHER(state) {
            return state.teacher
        },
    },
})

export default store;
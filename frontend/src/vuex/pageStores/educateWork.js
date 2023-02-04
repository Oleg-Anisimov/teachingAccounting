import qs from "qs";
import axios from "axios";
import {categoryBased} from "../categoryBased";
import {methods} from "../dateMethods";

export const educateWork = {
    namespaced: true,
    modules: {
        categoryBased,
        methods
    },
    state: {
        educateWork: [],
    },
    getters: {
        GET_EDUCATE_WORK(state) {
            return state.educateWork
        },
    },
    mutations: {
        SET_EDUCATE_WORK: (state, educats) => {
            state.educateWork = educats
        },
        ADD_EDUCATE_WORK: (state, educateWork) => {
            educateWork.date = methods.methods.DATE_TO_STRING(educateWork.date)
            console.log(educateWork);
            state.educateWork.push(educateWork)
        },
    },
    actions: {
        LOAD_EDUCATE_WORKS({commit}, pageRequest) {
            let url = '/api/educate'
            const options = {
                method: 'POST',
                data: qs.stringify(pageRequest)
            }
            return axios(url, options)
                .then((products) => {
                    products.data.content.forEach(element => {
                        element.date = methods.methods.DATE_TO_STRING(element.date)
                        console.log(element.date)
                    })
                    commit('SET_EDUCATE_WORK', products.data.content)
                    console.log(products.data)
                    return products.data
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
    },
    

}


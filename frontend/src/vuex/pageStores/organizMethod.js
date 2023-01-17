import qs from "qs";
import axios from "axios";
import {categoryBased} from "../categoryBased";

export const organizMethod = {
    namespaced: true,
    modules: {
        categoryBased
    },
    state: {
        organizMethod: [],
    },
    getters: {
        GET_ORGANIZED_METHOD(state) {
            return state.organizedMethod
        },
    },
    mutations: {
        SET_ORGANIZED_METHOD: (state, organs) => {
            state.organizedMethod = organs
        },
        ADD_ORGANIZED_METHOD: (state, organizedMethod) => {
            console.log(organizedMethod);
            state.organizedMethod.push(organizedMethod)
        },
    },
    actions: {
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
    },
    

}


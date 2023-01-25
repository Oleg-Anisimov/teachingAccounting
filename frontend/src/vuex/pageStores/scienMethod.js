import qs from "qs";
import axios from "axios";
import {categoryBased} from "../categoryBased";

export const scienMethod = {
    namespaced: true,
    modules: {
        categoryBased
    },
    state: {
        scienMethod: [],
    },
    getters: {
        GET_SCIENTIFIC_METHOD(state) {
            return state.scientificMethod
        },
    },
    mutations: {
        SET_SCIENTIFIC_METHOD: (state, sciens) => {
            state.scientificMethod = sciens
        },
        ADD_SCIENTIFIC_METHOD: (state, scientificMethod) => {
            console.log(scientificMethod);
            state.scientificMethod.push(scientificMethod)
        },
    },
    actions: {
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
    },
    

}


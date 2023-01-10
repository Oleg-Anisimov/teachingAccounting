import qs from "qs";
import axios from "axios";

export const user = {
    namespaced: true,

    state: {
        currentUser: null
    },

    getters: {
        GET_CURRENT_USER(state) {
            return state.currentUser
        },
    },


    mutations: {
        SET_CURRENT_USER: (state, user) => {
            state.currentUser = user
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
        },
        LOGOUT({commit}) {
            const url = '/api/perform_logout'
            return axios(url, {method: 'POST'})
                .then(() => {
                    commit('SET_CURRENT_USER', null)
                })
        }
    }
}

import qs from "qs";
import axios from "axios";

export const user = {
    namespaced: true,

    state: {
        currentUser: null,
        usersAll: []
    },

    getters: {
        GET_CURRENT_USER(state) {
            return state.currentUser
        },
        GET_ALL_USERS(state){
            return state.usersAll
        }
    },


    mutations: {
        SET_CURRENT_USER: (state, user) => {
            state.currentUser = user
        },
        SET_ALL_USERS: (state, users) => {
            state.usersAll = users
        },
    },


    actions: {
        LOAD_ALL_USERS({commit}){
            let url = '/api/user/all'
            return axios(url, { method: 'GET'})
                .then((users) => {
                    commit('SET_ALL_USERS', users.data)
                    return users.data
                })
                .catch((error) => {
                    console.log(error)
                })
        },
        
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

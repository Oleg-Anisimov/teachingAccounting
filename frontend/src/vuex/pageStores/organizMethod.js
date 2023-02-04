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
                // var dataToSplit = []
                // for(var i = 0; i < organs.data.content.length; i++){
                //     dataToSplit = organs.data.content[i].date
                //     console.log(organs.data.content[i].date)
                // }    
                // console.log(organs.data.content[2].date)
                // for(var i = 0; i < dataToSplit.length; i++){
                //     if(dataToSplit[i].toString().length ===1){
                //         dataToSplit[i] = "0" + dataToSplit[i]
                //     }
                // }
                
                // dataToSplit = dataToSplit.join('-')
                
                // for(var i = 0; i < organs.data.content.length; i++){
                //     organs.data.content[i].date = dataToSplit
                    
                // }

                

                console.log(organs.data)
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


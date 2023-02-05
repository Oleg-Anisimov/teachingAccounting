import qs from "qs";
import axios from "axios";
import {categoryBased} from "../categoryBased";
import {methods} from "../dateMethods";

export const organizMethod = {
    namespaced: true,
    modules: {
        categoryBased,
        methods
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
            organizedMethod.date = methods.methods.DATE_TO_STRING(organizedMethod.date)
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
                organs.data.content.forEach(element => {
                    element.date = methods.methods.DATE_TO_STRING(element.date)
                    console.log(element.date)
                })
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
                    console.log(organResponse.data)
                    commit('ADD_ORGANIZED_METHOD', organResponse.data)
                    return organResponse.data;
                })
                .catch((error) => {
                    console.log(error)
                })
        },
        EXPORT_TO_EXCEL() {
            const url = '/api/organized/excel';
            return axios({
                url: url,
                method: 'GET',
                responseType: 'blob',
            }).then((response) => {
                const filename = response.headers['content-disposition'].split('filename="')[1].split('"')[0];
                var fileURL = window.URL.createObjectURL(new Blob([response.data]));
                var fileLink = document.createElement('a');

                fileLink.href = fileURL;
                fileLink.setAttribute('download', filename);
                document.body.appendChild(fileLink);

                fileLink.click();
            });
        }
    },
    

}


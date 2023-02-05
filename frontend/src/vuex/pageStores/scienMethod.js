import qs from "qs";
import axios from "axios";
import {categoryBased} from "../categoryBased";
import {methods} from "../dateMethods";

export const scienMethod = {
    namespaced: true,
    modules: {
        categoryBased,
        methods
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
            scientificMethod.date = methods.methods.DATE_TO_STRING(scientificMethod.date)
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
                    sciens.data.content.forEach(element => {
                        element.date = methods.methods.DATE_TO_STRING(element.date)
                        console.log(element.date)
                    })
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
        EXPORT_TO_EXCEL() {
            const url = '/api/scientific/excel';
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


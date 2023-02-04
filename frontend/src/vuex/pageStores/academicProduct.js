import qs from "qs";
import axios from "axios";
import {categoryBased} from "../categoryBased";
import store from "../store";
import {methods} from "../dateMethods";

export const academicProduct = {
    namespaced: true,
    modules: {
        categoryBased,
        methods
    },
    state: {
        academicProduct: [],
    },
    getters: {
        GET_ACADEMIC_PRODUCTION(state) {
            return state.academicProduction
        },
    },
    mutations: {
        SET_ACADEMIC_PRODUCTION: (state, products) => {
            products.forEach((e) =>{
                e.specialization = store.getters.GET_ALL_SPECIALIZATIONS.find((spec) => {return  spec.id === e.specializationId})
            })
            state.academicProduction = products
        },
        ADD_ACADEMIC_PRODUCTION: (state, academicProduction) => {
            academicProduction.date = methods.methods.DATE_TO_STRING(academicProduction.date)
            console.log(academicProduction);
            state.academicProduction.push(academicProduction)
        },
    },
    actions: {
        LOAD_ACADEMIC_PRODUCTIONS({commit}, pageRequest) {
            let url = '/api/production'
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
                    commit('SET_ACADEMIC_PRODUCTION', products.data.content)
                    console.log(products.data)
                    return products.data
                })
                .catch((error) => {
                    console.log(error)
                })
        },
        UPLOAD_ACADEMIC_PRODUCTION({commit, getters}, product) {
            let url = '/api/production/create';
            let data = {
                specializationId: product.specialization.id,
                activityType: product.activityType
            }
            console.log(getters)
            return axios.post(url, data)
                .then((product) => {
                    function transformProductResponse(data) {
                        return {
                            id: data.id,
                            specialization: store.getters.GET_ALL_SPECIALIZATIONS.find((spec) => {return spec.id === data.specializationId}),
                            activityType: categoryBased.getters.GET_ENUMS(categoryBased.state).ActivityType.find((actType) => {return actType === data.activityType}),
                        }
                    }
                    let transformedProduct = transformProductResponse(product.data);
                    commit('ADD_ACADEMIC_PRODUCTION', transformedProduct)
                    return product.data;
                })
                .catch((error) => {
                    console.log(error)
                })
        },
    },
    

}


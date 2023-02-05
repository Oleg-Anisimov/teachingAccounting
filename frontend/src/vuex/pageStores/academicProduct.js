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
            
            academicProduction.cabinet = store.getters.GET_ALL_CABINETS.find((cab) => {return cab.id === academicProduction.cabinetId})
            console.log(academicProduction)
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
                        element.cabinet = store.getters.GET_ALL_CABINETS.find((cab) => {return cab.id === element.cabinetId})
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
                activityType: product.activityType,
                date: product.date,
                academicProductionActivityForm: product.academicProductionActivityForm,
                cabinetId: product.cabinetId
            }
            console.log(getters)
            console.log(data.date)
            return axios.post(url, data)
                .then((product) => {
                    function transformProductResponse(data) {
                        return {
                            id: data.id,
                            specialization: store.getters.GET_ALL_SPECIALIZATIONS.find((spec) => {return spec.id === data.specializationId}),
                            date: data.date,
                            activityType: categoryBased.getters.GET_ENUMS(categoryBased.state).ActivityType.find((actType) => {return actType === data.activityType}),
                            academicProductionActivityForm: data.academicProductionActivityForm,
                            cabinetId: data.cabinetId
                        }
                    }
                    console.log(data.date)
                    let transformedProduct = transformProductResponse(product.data);
                    commit('ADD_ACADEMIC_PRODUCTION', transformedProduct)
                    return product.data;
                })
                .catch((error) => {
                    console.log(error)
                })
        },
        EXPORT_TO_EXCEL() {
            const url = '/api/production/excel';
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


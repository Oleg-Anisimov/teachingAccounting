import qs from "qs";
import axios from "axios";
import store from "../store";
import { categoryBased } from "../categoryBased";
import {methods} from "../dateMethods";

export const academicMethod = {
    namespaced: true,
    modules: {
        categoryBased,
    },
    state: {
        academicMethod: [],
    },
    getters: {
        GET_ACADEMIC_METHOD(state) {
            return state.academicMethod
        },
    },
    mutations: {
        SET_ACADEMIC_METHOD: (state, meths) => {
            meths.forEach((m) => {
                m.specialization = store.getters.GET_ALL_SPECIALIZATIONS.find((spec) => {return spec.id === m.specializationId})
                m.academicDiscipline = store.getters.GET_ALL_ACADEMIC_DISCIPLINES.find((disc) => {return disc.id === m.academicDisciplineId})
                m.deadLine = methods.methods.DATE_TO_STRING(m.deadLine)
            })
            state.academicMethod = meths
        },
        ADD_ACADEMIC_METHOD: (state, academicMethod) => {
            console.log(academicMethod);
            academicMethod.deadLine = methods.methods.DATE_TO_STRING(academicMethod.deadLine)
            state.academicMethod.push(academicMethod)
        },
    },
    actions: {
        LOAD_ACADEMIC_METHODS({commit}, pageRequest) {
            let url = '/api/methods'
            const options = {
                method: 'POST',
                data: qs.stringify(pageRequest)
            }
            return axios(url, options)
                .then((methods) => {
                    commit('SET_ACADEMIC_METHOD', methods.data.content)
                    console.log(methods.data)
                    return methods.data;
                })
                .catch((error) => {
                    console.log(error)
                })
        },
        UPLOAD_ACADEMIC_METHOD({commit, getters}, method) {
            let url = '/api/methods/create';
            let data = {
                academicDisciplineId: method.academicDiscipline.id,
                specializationId: method.specialization.id,
                activityType: method.activityType,
                academicMethodActivityType: method.academicMethodActivityType,
                academicMethodActivityForm: method.academicMethodActivityForm,
                deadLine: method.deadLine
            }
            console.log(getters)
            return axios.post(url, data)
                .then((method) => {
                    function transformMethodResponse(data) {
                        return {
                            id: data.id,
                            academicDiscipline: store.getters.GET_ALL_ACADEMIC_DISCIPLINES.find((dis) => {return dis.id === data.academicDisciplineId}),
                            specialization: store.getters.GET_ALL_SPECIALIZATIONS.find((spec) => {return spec.id === data.specializationId}),
                            activityType: categoryBased.getters.GET_ENUMS(categoryBased.state).ActivityType.find((actType) => {return actType === data.activityType}),
                            academicMethodActivityType: data.academicMethodActivityType,
                            academicMethodActivityForm: data.academicMethodActivityForm,
                            deadLine: data.deadLine
                        }
                    }

                    let transformedMethod = transformMethodResponse(method.data);
                    commit('ADD_ACADEMIC_METHOD', transformedMethod)
                    return method.data;
                })
                .catch((error) => {
                    console.log(error)
                })
        },
        EXPORT_TO_EXCEL() {
            const url = '/api/methods/excel';
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


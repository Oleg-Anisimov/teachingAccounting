import qs from "qs";
import axios from "axios";
import {categoryBased} from "../categoryBased";

export const academicMethod = {
    namespaced: true,
    modules: {
        categoryBased
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
        SET_ACADEMIC_METHOD: (state, methods) => {
            methods.forEach((m) => {
                m.specialization = categoryBased.state.specializations.find((spec) => {return spec.id === m.specializationId})
                m.academicDiscipline = categoryBased.state.academicDisciplines.find((disc) => {return disc.id === m.academicDisciplineId})
            })
            state.academicMethod = methods
        },
        ADD_ACADEMIC_METHOD: (state, academicMethod) => {
            console.log(academicMethod);
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
            }
            console.log(getters)
            return axios.post(url, data)
                .then((method) => {
                    function transformMethodResponse(data) {
                        return {
                            id: data.id,
                            academicDiscipline: categoryBased.getters.GET_ALL_ACADEMIC_DISCIPLINES(categoryBased.state).find((dis) => {return dis.id === data.academicDisciplineId}),
                            specialization: categoryBased.getters.GET_ALL_SPECIALIZATIONS(categoryBased.state).find((spec) => {return spec.id === data.specializationId}),
                            activityType: categoryBased.getters.GET_ENUMS(categoryBased.state).ActivityType.find((actType) => {return actType === data.activityType}),
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
    },
    

}


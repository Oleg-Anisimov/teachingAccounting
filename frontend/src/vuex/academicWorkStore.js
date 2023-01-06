import axios from "axios";
import qs from "qs";

function transform(data) {
    let result = [];
    for (let i = 0; i < data.work.length; i++) {
        result[i] = {
            id: data.work[i].id,
            group: data.groups.find((group) => {return group.id === data.work[i].groupId}),
            academicDiscipline: data.disciplines.find((disc) => {return disc.id === data.work[i].academicDisciplineId}),
            specialization: data.specializations.find((spec) => {return spec.id === data.work[i].specializationId}),
            firstSemester: data.work[i].firstSemester,
            secondSemester:  data.work[i].secondSemester
        }
    }
    return result;
}


export default {
    namespaced: true,
    state: {
        academicWork: []
    },
    getters: {
        GET_ACADEMIC_WORK(state) {
            return state.academicWork
        },
    },
    // Can't call rootGetters from nested module mutation
    // Look at Vuex developers response
    // https://github.com/vuejs/vuex/issues/684
    // The data passes to mutation should be processed in ACTIONS block
    mutations: {
        SET_ACADEMIC_WORK: (state, works) => {
            state.academicWork = works
        },
        ADD_ACADEMIC_WORK: (state, academicWork) => {
            state.academicWork.push(academicWork)
        },
    },

    actions: {
        LOAD_ACADEMIC_WORKS({commit, rootState, rootGetters, dispatch}, pageRequest) {
            console.log("LOADED ACA WORKS")
            const url = '/api/work';
            const options = {
                method: 'POST',
                data: qs.stringify(pageRequest)
            }
            return axios(url, options)
                .then((response) => {
                    const data = {
                        work: response.data.content,
                        groups: rootState.groups,
                        specializations: rootState.specializations,
                        disciplines: rootState.academicDisciplines
                    }
                    const transformedData = transform(data);
                    commit('SET_ACADEMIC_WORK', transformedData)
                    return response.data;
                })
                .catch((error) => {
                    console.log(error)
                })
        },

        UPLOAD_ACADEMIC_WORK({commit, getters}, work) {
            const url = '/api/work/create';
            const data = {
                academicDisciplineId: work.academicDiscipline.id,
                specializationId: work.specialization.id,
                groupId: work.group.id,
                firstSemester: work.firstSemester,
                secondSemester: work.secondSemester
            }
            return axios.post(url, data)
                .then((work) => {
                   let transformedWork = transform(work.data);
                    commit('ADD_ACADEMIC_WORK', transformedWork)
                    return work.data;
                })
                .catch((error) => {
                    console.log(error)
                })
        },

    },

}


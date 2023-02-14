import qs from "qs";
import axios from "axios";
import store from "../store";

export const academicWork = {
    namespaced: true,
    state: {
        academicWork: [],
    },
    getters: {
        GET_ACADEMIC_WORK(state) {
            return state.academicWork
        },
    },
    mutations: {
        SET_ACADEMIC_WORK: (state, works) => {
            console.log(works)
            works.forEach((w) => {
                w.group = store.getters.GET_ALL_GROUPS.find((group) => {return group.id === w.groupId})
                w.specialization = store.getters.GET_ALL_SPECIALIZATIONS.find((spec) => {return spec.id === w.specializationId})
                w.academicDiscipline = store.getters.GET_ALL_ACADEMIC_DISCIPLINES.find((disc) => {return disc.id === w.academicDisciplineId})
            })
            state.academicWork = works
        },
        ADD_ACADEMIC_WORK: (state, academicWork) => {
            state.academicWork.push(academicWork)
        },

        MARK_WORK_AS_EDITED: (state, id) => {
            state.academicWork.map((item) => {
                item.isEdit = (item.id === id)
            })
        }

    },
    actions: {
        MARK_WORK_AS_EDITED({commit}, id) {
          commit('MARK_WORK_AS_EDITED', id)
        },
        LOAD_ACADEMIC_WORKS({commit}, pageRequest,) {
            let url = '/api/work';
            const options = {
                method: 'POST',
                data: qs.stringify(pageRequest)
            }
            return axios(url, options)
                .then((response) => {
                    commit('SET_ACADEMIC_WORK', response.data.content)
                    console.log(response.data)
                    return response.data;
                })
                .catch((error) => {
                    console.log(error)
                })
        },
        UPLOAD_ACADEMIC_WORK({commit, getters}, work) {
            let url = '/api/work/create';
            let data = {
                groupId: work.group.id,
                specializationId: work.specialization.id,
                academicDisciplineId: work.academicDiscipline.id,
                firstSemester: work.firstSemester,
                secondSemester: work.secondSemester,
                academicYear: work.academicYear,
                incompleteReason: work.incompleteReason,
                absoluteResults: work.absoluteResults,
                qualityResults: work.qualityResults
            }
            return axios.post(url, data)
                .then((work) => {
                    function transformWorkResponse(data) {
                        return {
                            id: data.id,
                            group: store.getters.GET_ALL_GROUPS.find((group) => {return group.id === data.groupId}),
                            specialization: store.getters.GET_ALL_SPECIALIZATIONS.find((spec) => {return spec.id === data.specializationId}),
                            academicDiscipline: store.getters.GET_ALL_ACADEMIC_DISCIPLINES.find((dis) => {return dis.id === data.academicDisciplineId}),
                            firstSemester: data.firstSemester,
                            secondSemester: data.secondSemester,
                            academicYear: data.academicYear,
                            incompleteReason: data.incompleteReason,
                            absoluteResults: data.absoluteResults,
                            qualityResults: data.qualityResults
                        }
                    }
                    return work.data;
                    
                })
                .catch((error) => {
                    console.log(error)
                })
        },


        UPDATE_ACADEMIC_WORK({commit, getters}, work) {
            let url = '/api/work/update';
            console.log(work)
            let data = {
                id: work.id,
                groupId: work.group.id,
                specializationId: work.specialization.id,
                academicDisciplineId: work.academicDiscipline.id,
                firstSemester: work.firstSemester,
                secondSemester: work.secondSemester,
                academicYear: work.academicYear,
                incompleteReason: work.incompleteReason,
                absoluteResults: work.absoluteResults,
                qualityResults: work.qualityResults
            }
            return axios.post(url, data)
                        .catch((error) => {
                            console.log(error)
                        })
        },

        EXPORT_TO_EXCEL() {
            const url = '/api/work/excel';
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


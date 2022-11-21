// import axios from "axios";
//
// export default {
//     namespaced: true,
//     state: {
//         works: []
//     },
//     getters: {
//         GET_ACADEMIC_WORK(state) {
//             console.log("getting academic work from second state manager")
//             return state.works
//         },
//     },
//     mutations: {
//         SET_ACADEMIC_WORK: (state, works) => {
//             state.academicWork = works
//         },
//         ADD_ACADEMIC_WORK: (state, academicWork) => {
//             console.log(academicWork);
//             state.academicWork.push(academicWork)
//         }
//     },
//     actions: {
//         LOAD_ACADEMIC_WORKS({commit}) {
//             console.log("try to fetch academic works")
//             let url = '/api/work/all'
//             return axios(url, { method: 'GET'})
//                 .then((works) => {
//                     commit('SET_ACADEMIC_WORK', works.data)
//                     return works.data
//                 })
//                 .catch((error) => {
//                     console.log(error)
//                 })
//         },
//         UPLOAD_ACADEMIC_WORK({commit}, work) {
//             let url = '/api/work/create';
//             let data = {
//                 academicDisciplineId: work.discipline.id,
//                 specializationId: work.specialization.id,
//                 groupId: work.group.id
//             }
//
//             return axios.post(url, data)
//                 .then((work) => {
//                     commit('ADD_ACADEMIC_WORK', work.data)
//                     return work.data;
//                 })
//                 .catch((error) => {
//                     console.log(error)
//                 })
//         },
//
//     },
//
// }
//

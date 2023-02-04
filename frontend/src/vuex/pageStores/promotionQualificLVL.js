import qs from "qs";
import axios from "axios";
import {categoryBased} from "../categoryBased";
import {methods} from "../dateMethods";

export const promotionQualificLVL = {
    namespaced: true,
    modules: {
        categoryBased,
        methods
    },
    state: {
        promotionQualificLVL: [],
    },
    getters: {
        GET_PROMOTION_QUALIFICATION_LVL(state) {
            return state.promotionQualificationLvl
        },
    },
    mutations: {
        SET_PROMOTION_QUALIFICATION_LVL: (state, lvls) => {
            state.promotionQualificationLvl = lvls
        },
        ADD_PROMOTION_QUALIFICATION_LVL: (state, promotionQualificationLvl) => {
            promotionQualificationLvl.date = methods.methods.DATE_TO_STRING(promotionQualificationLvl.date)
            console.log(promotionQualificationLvl);
            state.promotionQualificationLvl.push(promotionQualificationLvl)
        },
    },
    actions: {
        LOAD_PROMOTION_QUALIFICATION_LVLS({commit}, pageRequest) {
            let url = '/api/promotion'
            const options = {
                method: 'POST',
                data: qs.stringify(pageRequest)
            }
            return axios(url, options)
            
                .then((lvls) => {
                    lvls.data.content.forEach(element => {
                        element.date = methods.methods.DATE_TO_STRING(element.date)
                        console.log(element.date)
                    })
                    commit('SET_PROMOTION_QUALIFICATION_LVL', lvls.data.content)
                    console.log(lvls.data)
                    return lvls.data
                })
                .catch((error) => {
                    console.log(error)
                })
        },
        UPLOAD_PROMOTION_QUALIFICATION_LVL({commit, getters}, lvl) {
            let url = '/api/promotion/create';
            console.log(getters)
            return axios.post(url, lvl)
                .then((lvlResponse) => {
                    commit('ADD_PROMOTION_QUALIFICATION_LVL', lvlResponse.data)
                    return lvlResponse.data;
                })
                .catch((error) => {
                    console.log(error)
                })
        },
    },
    

}


<template>
    <div class="filling-form">
        <div class="academ-year">
            <p class="main-p">Академический год</p>
            <div class="form-border">
                <select name="year">
                    <option value="option0">2021/2022</option>
                    <option value="option1">2022/2023</option>
                    <option value="option2">2023/2024</option>
                    <option value="option3">2024/2025</option>
                    <option value="option4">2025/2026</option>
                    <option value="option5">2026/2027</option>
                </select>
            </div>
        </div>
        <div class="article">
            <p class="main-p">Новая запись</p>
            <div class="form-border">
                <p>Форма повышения</p>
                <select v-model="model.promotionForm">
                    <option disabled value="">Выберите форму повышения</option>
                    <option v-for="promotionForm in GET_ENUMS().PromotionForm" :key="promotionForm" :value="promotionForm">{{$t('enum.PromotionForm.' + promotionForm)}}</option>
                </select>
                <p>Дата</p>
                <input v-model="this.model.date" type="date">
                <p>Место</p>
                <input type="text" v-model="model.place">
                <p>Тема</p>
                <input type="text" v-model="model.topic">
                <button @click="addPromotionQual()">Добавить</button> 
            </div>    
        </div>
        <div class="export">
            <div class="form-border">
                <button class="last-button" v-on:click="EXPORT_TO_EXCEL">
                <img src="../../../assets/img/excel.png">Экспорт в Excel</button>
            </div>
        </div>
    </div>
</template>
<script>
import {mapActions, mapGetters, mapMutations} from 'vuex';
import PromotionQualificationLvl from "../../../model/promotionQualificationLvl";

export default{
    name: "PromQual",
    props: [
        'enums'
    ],
    data() {
      return {
        model: {
          id: '',
          promotionForm: '',
          date: '',
          place: '',
          topic: ''
        },
        
      }
    },
    methods: {
    ...mapActions({
      LOAD_ENUMS: 'categoryBased/LOAD_ENUMS',
      UPLOAD_PROMOTION_QUALIFICATION_LVL: 'promotionQualificLVL/UPLOAD_PROMOTION_QUALIFICATION_LVL',
      EXPORT_TO_EXCEL: 'promotionQualificLVL/EXPORT_TO_EXCEL'
    }),
    ...mapMutations({
      ADD_PROMOTION_QUALIFICATION_LVL: 'promotionQualificLVL/ADD_PROMOTION_QUALIFICATION_LVL'
    }),
    ...mapGetters({
      GET_ENUMS: 'categoryBased/GET_ENUMS',
      //'',
      // 'GET_DEPARTMENT_NAMES'
    }),

    addPromotionQual(){
      let lvl = new PromotionQualificationLvl(
          this.id,
          this.model.promotionForm,
          this.model.date,
          this.model.place,
          this.model.topic
      )
      console.log(lvl)
      this.UPLOAD_PROMOTION_QUALIFICATION_LVL(lvl)
    },
  },
  mounted(){
    this.LOAD_ENUMS()
    //this.
  },

}

</script>


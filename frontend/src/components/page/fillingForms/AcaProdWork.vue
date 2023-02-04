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
                <p>Специальность</p>
                <select v-model="model.specialization">
                    <option disabled value="">Выберите специальность</option>
                    <option v-for="specialization in GET_ALL_SPECIALIZATIONS()" :key="specialization" :value="specialization">{{specialization.specialization}}</option>
                </select>
                <p>Наименование кабинета</p>
                <select>
                  <option value=""></option>
                </select>
                <p>Вид деятельности</p>
                <select v-model="model.activityType">
                    <option disabled value="">Выберите вид деятельности</option>
                    <option v-for="activityType in GET_ENUMS().ActivityType" :key="activityType" :value="activityType">{{$t('enum.ActivityType.' + activityType)}}</option>
                </select><br>
                <p>Вид УПД</p>
                <select>
                    <option value=""></option>
                </select><br>
                <p>Дата</p>
                <input v-model="this.model.date" type="date">
                <button @click="addAcademicProduct()">Добавить</button> 
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
import AcademicProduct from "../../../model/academicProduction";

export default{
    name: "AcaProdWork",
    props: [
        'enums'
    ],
    data() {
      return {
        model: {
          id: 1,
          specialization: '',
          activityType: '',
          date: '',
        },
        
      }
    },
    methods: {
    ...mapActions({
      LOAD_ENUMS: 'categoryBased/LOAD_ENUMS',
      LOAD_SPECIALIZATION: 'LOAD_SPECIALIZATION',
      UPLOAD_ACADEMIC_PRODUCTION: 'academicProduct/UPLOAD_ACADEMIC_PRODUCTION',
      EXPORT_TO_EXCEL: 'academicProduct/EXPORT_TO_EXCEL'
    }),
    ...mapMutations({
      ADD_ACADEMIC_PRODUCTION: 'academicProduct/ADD_ACADEMIC_PRODUCTION'
    }),
    ...mapGetters({
      GET_ENUMS: 'categoryBased/GET_ENUMS',
      GET_ALL_SPECIALIZATIONS: 'GET_ALL_SPECIALIZATIONS',
      //'',
      // 'GET_DEPARTMENT_NAMES'
    }),

    addAcademicProduct(){
      let product = new AcademicProduct(
          this.id,
          this.model.specialization,
          this.model.activityType,
          this.model.date,
      )
      this.UPLOAD_ACADEMIC_PRODUCTION(product)
    },
  },
  mounted(){
    this.LOAD_ENUMS()
    this.LOAD_SPECIALIZATION()
    //this.
  },

}

</script>


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
                <p>Учебная дисциплина</p>
                <select v-model="model.discipline">
                  <option disabled value="">Выберите дисциплину</option>
                  <option v-for="discipline in GET_ALL_ACADEMIC_DISCIPLINES()" :key="discipline" :value="discipline">{{discipline.disciplineNumber}}</option>
                </select>
                <p>Учебная группа</p>
                <select v-model="model.group">
                    <option v-for="group in GET_ALL_GROUPS()" :key="group.id" :value="group">{{group.groupName}}</option>
                </select><br>
                <p>Кол-во часов по плану:</p>
                <p>l Семестр</p>
                <input type="text" v-model.number="model.firstSemPlan" name="first_half">
                <p>ll Семестр</p>
                <input type="text" v-model.number="model.secondSemPlan" name="last_half">
                <button @click="addAcademicWork()">Добавить</button>
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
import AcademicWork from "../../../model/academicWork";

export default{
    name: "AcaWork",
    props: [
        'enums'
    ],
    data() {
      return {
        model: {
          id: 1,
          specialization: '',
          group: '',
          academicDiscipline: '',
          firstSemPlan: 0,
          secondSemPlan: 0
        }
        
      }
    },

    methods: {
    ...mapActions({
      LOAD_ENUMS: 'categoryBased/LOAD_ENUMS',
      LOAD_DEPARTMENTS: 'LOAD_DEPARTMENTS',
      LOAD_SPECIALIZATION: 'LOAD_SPECIALIZATION',
      LOAD_ACADEMIC_DISCIPLINE: 'LOAD_ACADEMIC_DISCIPLINE',
      LOAD_GROUPS: 'LOAD_GROUPS',
      UPLOAD_ACADEMIC_WORK: 'academicWork/UPLOAD_ACADEMIC_WORK',
      EXPORT_TO_EXCEL: 'academicWork/EXPORT_TO_EXCEL'
    }),
    ...mapMutations({
      ADD_ACADEMIC_WORK: 'academicWork/ADD_ACADEMIC_WORK'
    }),
    ...mapGetters({
      GET_ENUMS: 'categoryBased/GET_ENUMS',
      GET_TEACHER_CATEGORIES: 'categoryBased/GET_TEACHER_CATEGORIES',
      GET_EMPLOYMENT_TYPES: 'categoryBased/GET_EMPLOYMENT_TYPES',
      GET_POSITIONS: 'categoryBased/GET_POSITIONS',
      GET_ALL_DEPARTMENTS: 'GET_ALL_DEPARTMENTS',
      GET_ALL_SPECIALIZATIONS: 'GET_ALL_SPECIALIZATIONS',
      GET_ALL_ACADEMIC_DISCIPLINES: 'GET_ALL_ACADEMIC_DISCIPLINES',
      GET_ALL_GROUPS: 'GET_ALL_GROUPS',

    }),

    addAcademicWork(){
      let work = new AcademicWork(
          this.id,
          this.model.specialization,
          this.model.group,
          this.model.discipline,
          {
            plan: this.model.firstSemPlan
          },
          {
            plan: this.model.secondSemPlan
          }
      )
      console.log(work)
      this.UPLOAD_ACADEMIC_WORK(work)
    },
  },
  mounted(){
    this.LOAD_ENUMS()
    this.LOAD_SPECIALIZATION()
    this.LOAD_ACADEMIC_DISCIPLINE()
    this.LOAD_GROUPS()
  },

}

</script>


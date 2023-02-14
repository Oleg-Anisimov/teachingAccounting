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
                <select v-model="model.academicDiscipline">
                  <option disabled value="">Выберите дисциплину</option>
                  <option v-for="discipline in GET_ALL_ACADEMIC_DISCIPLINES()" :key="discipline" :value="discipline">{{discipline.disciplineNumber}}</option>
                </select>
                <p>Учебная группа</p>
                <select v-model="model.group">
                  <option disabled value="">Выберите группу</option>
                    <option v-for="group in GET_ALL_GROUPS()" :key="group.id" :value="group">{{group.groupName}}</option>
                </select><br>
                <p>Кол-во часов по плану:</p>
                <p>l Семестр</p>
                <input type="text" v-bind:class="{'input_edit_mode': model.isEditMode}" v-model.number="model.firstSemPlan" name="first_half">
                <input type="text" v-if="model.isEditMode" v-bind:class="{'input_edit_mode': model.isEditMode}" v-model.number="model.firstSemFact" name="first_half">
                <p>ll Семестр</p>
                <input type="text" v-bind:class="{'input_edit_mode': model.isEditMode}" v-model.number="model.secondSemPlan" name="last_half">
              <input type="text" v-if="model.isEditMode" v-bind:class="{'input_edit_mode': model.isEditMode}" v-model.number="model.secondSemFact" name="first_half">


              <p v-if="model.isEditMode">Причина невыполнения</p>
                <input v-if="model.isEditMode" type="text" v-model="model.incompleteReason" name="last_half">

                <p v-if="model.isEditMode">Абсолютная успеваемость</p>
                <input v-if="model.isEditMode" type="text" v-model="model.absoluteResults" name="last_half">

                <p v-if="model.isEditMode">Качественная успеваемость</p>
                <input v-if="model.isEditMode" type="text" v-model="model.qualityResults" name="last_half">

                <button v-if="!model.isEditMode" @click="addAcademicWork()">Добавить</button>
                <button v-if="model.isEditMode" style="width: 42%" v-on:click="updateAcademicWork"> <img src="../../../assets/img/save.png">Сохранить</button>
                <button v-if="model.isEditMode" style="width: 37%; margin-left: 1%" @click="cancelUpdate"> <img src="../../../assets/img/cancel.png">Отмена</button>
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
    props: {
      model: {
        type: Object,
        required: false,
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
      UPDATE_ACADEMIC_WORK: 'academicWork/UPDATE_ACADEMIC_WORK',
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
          this.model.academicDiscipline,
          {
            plan: this.model.firstSemPlan,
            fact: 0
          },
          {
            plan: this.model.secondSemPlan,
            fact: 0
          },
          {
            plan: 0,
            fact: 0
          },
          "Отсутствует",
          0,
          0
      )
      this.UPLOAD_ACADEMIC_WORK(work)
          .then(() => this.$emit('dataUpdated'))

    },

    updateAcademicWork(){
      let work = new AcademicWork(
          this.model.id,
          this.model.specialization,
          this.model.group,
          this.model.academicDiscipline,
          {
            plan: this.model.firstSemPlan,
            fact: this.model.firstSemFact
          },
          {
            plan: this.model.secondSemPlan,
            fact: this.model.secondSemFact
          },
          {
            plan: 0,
            fact: 0
          },
          this.model.incompleteReason,
          this.model.absoluteResults,
          this.model.qualityResults
      )
      this.UPDATE_ACADEMIC_WORK(work)
          .then(() => this.$emit('dataUpdated'))
    },

    cancelUpdate() {
      this.$emit('cancelUpdate')
    }
  },
  mounted(){
    this.LOAD_ENUMS()
    this.LOAD_SPECIALIZATION()
    this.LOAD_ACADEMIC_DISCIPLINE()
    this.LOAD_GROUPS()
  },

}

</script>

<style>
.input_edit_mode {
  width: 39% !important;
  margin: 1%;
}
</style>


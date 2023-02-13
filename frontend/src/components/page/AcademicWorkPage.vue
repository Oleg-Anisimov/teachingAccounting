<script setup>
import AcaWork from "./fillingForms/AcaWork.vue";
</script>
<template>
  <div class="academic_work_page">
    <AcaWork grid-area="filling-form"></AcaWork>
    <div class="main-table" grid-area="table1">
      <button id="red" grid-area="img"><img src="../../assets/img/11111123123123.png" v-on:click="REDACTION_STATE_TURN"></button>  
      <table> 
            <tr>
              <th colspan="140">
                <img src="" />Учебная работа - Заполнение индивидуального плана
              </th>
            </tr>
            <tr>
              <td rowspan="2" class="left-helf simvol">№</td>
              <td rowspan="2" class="left-helf">Специальность</td>
              <td rowspan="2" class="left-helf">Уч. дисциплина (ПМ,МДК)</td>
              <td rowspan="2" class="left-helf">
                Наименование уч. дисциплины (ПМ,МДК)
              </td>
              <td rowspan="2" class="left-helf">Группа</td>
              <td colspan="2" class="left-helf">Первый семестр</td>
              <td colspan="2" class="left-helf">Второй семестр</td>
              <td colspan="2" class="left-helf">Учебный год</td>
              <td rowspan="2" class="right-helf">Причина невыполнения</td>
              <td rowspan="2" class="right-helf">Абсолютная успеваемость</td>
              <td rowspan="2" class="right-helf">Качественная успеваемость</td>
            </tr>
            <tr>
              <td class="td-bottom">План</td>
              <td class="td-bottom">Факт</td>
              <td class="td-bottom">План</td>
              <td class="td-bottom">Факт</td>
              <td class="td-bottom">План</td>
              <td class="td-bottom">Факт</td>
            </tr>
            <tr v-for="work in GET_ACADEMIC_WORK()" :key="work.id">
              <td>{{ work.id }}</td>

              <td>
                <div v-if="!redactState">{{ work.specialization.specialization }}</div>
                <select v-if="redactState" v-model="newWorkModel.specialization">
                  <option value="0" disabled>Выберите специальность</option>
                  <option v-for="specialization in GET_ALL_SPECIALIZATIONS()" :key="specialization.id" :value="specialization">{{ specialization.specialization }}</option>
                </select>
              </td>

              <td>
                <div v-if="!redactState">{{ work.academicDiscipline.disciplineNumber }}</div>
                <select v-if="redactState" v-model="newWorkModel.academicDiscipline">
                  <option value="0" disabled>Выберите учебную дисциплину</option>
                  <option v-for="academicDiscipline in GET_ALL_ACADEMIC_DISCIPLINES()" :key="academicDiscipline.id" :value="academicDiscipline">{{ academicDiscipline.disciplineNumber }}</option>
                </select>
              </td>

              <td>
                <div v-if="!redactState">{{ work.academicDiscipline.name }}</div>
                <div v-if="redactState">{{ newWorkModel.academicDiscipline.name }}</div>
              </td>

              <td><div v-if="!redactState">{{ work.group.groupName }}</div>
                <select v-if="redactState" v-model="newWorkModel.group">
                  <option value="0" disabled>Выберите группу</option>
                  <option v-for="group in GET_ALL_GROUPS()" :key="group.id" :value="group">{{ group.groupName }}</option>
                </select>
              </td>

              <td><div v-if="!redactState">{{ work.firstSemester ? work.firstSemester.plan : "" }}</div><input type="number" v-if="redactState"></td>
              <td><div v-if="!redactState">{{ work.firstSemester ? work.firstSemester.fact : "" }}</div><input type="number" v-if="redactState"></td>
              <td><div v-if="!redactState">{{ work.secondSemester ? work.secondSemester.plan : "" }}</div><input type="number" v-if="redactState"></td>
              <td><div v-if="!redactState">{{ work.secondSemester ? work.secondSemester.fact : "" }}</div><input type="number" v-if="redactState"></td>
              <td><div v-if="!redactState">{{ work.academicYear ? work.academicYear.plan : "" }}</div><input type="number" v-if="redactState"></td>
              <td><div v-if="!redactState">{{ work.academicYear ? work.academicYear.fact : "" }}</div><input type="number" v-if="redactState"></td>
              <td><div v-if="!redactState">{{ work.incompleteReason ? work.incompleteReason : "" }}</div><input type="text" v-if="redactState"></td>
              <td><div v-if="!redactState">{{ work.absoluteResults ? work.absoluteResults : "" }}</div><input type="number" v-if="redactState"></td>
              <td><div v-if="!redactState">{{ work.qualityResults ? work.qualityResults : "" }}</div><input type="number" v-if="redactState"></td>
            </tr>
            <pog :totalPages="totalPages" :totalElements="totalElements" :pageRequest="pageRequest"></pog>
          </table>
    </div>
  </div>
</template>
<script>
import { mapActions, mapGetters } from "vuex";
import pog from "../pogination/pog.vue";

export default {
  components: { pog },
  name: "AcademicWorkPage",
  props: ["enums"],
  watch: {
    "pageRequest.page"() {
      let resultPromise = this.LOAD_ACADEMIC_WORKS(this.pageRequest);
      resultPromise.then((data) => {
        this.totalPages = data.totalPages;
        this.pageNumber = data.pageable.pageNumber + 1;
      });
    },
    "pageRequest.size"() {
      let resultPromise = this.LOAD_ACADEMIC_WORKS(this.pageRequest);
      resultPromise.then((data) => {
        this.totalPages = data.totalPages;
        this.pageNumber = data.pageable.pageNumber + 1;
      });
    },
  },  
  data() {
    return {
      redactState: false,
      pageRequest: {
        page: 0,
        size: 10,
      },
      totalElements: 0,
      totalPages: 0,
      offset: 0,
      pageNumber: 0,
      newWorkModel: {
        specialization: 0, 
        academicDiscipline: 0, 
        group: 0,
      },
    };
  },
  methods: {
    ...mapActions({
      LOAD_ACADEMIC_WORKS: 'academicWork/LOAD_ACADEMIC_WORKS',

    }),
    ...mapGetters({
      GET_ACADEMIC_WORK: 'academicWork/GET_ACADEMIC_WORK',
      GET_ALL_SPECIALIZATIONS: 'GET_ALL_SPECIALIZATIONS',
      GET_ALL_ACADEMIC_DISCIPLINES: 'GET_ALL_ACADEMIC_DISCIPLINES',
      GET_ALL_GROUPS: 'GET_ALL_GROUPS',
    }),
    REDACTION_STATE_TURN(){
      this.redactState = !this.redactState;
      console.log(this.newWorkModel)
      // console.log(this.redactState);
    }
  },
  mounted() {
    document.title = "Учебная работа";
    this.resultPromise = this.LOAD_ACADEMIC_WORKS(this.pageRequest)
    this.resultPromise.then((data) => {
      this.totalElements = data.totalElements;
      this.totalPages = data.totalPages;
      this.pageNumber = data.pageable.pageNumber + 1;
    });
  },
}
</script>
<style scoped>
#red{
  width: 50px;
  height: 50px;
  border: 3px solid royalblue;
  margin-right: -8px;
}
.academic_work_page{
  padding: 1em;
  display: grid;
  grid-template-areas: "filling-form table1";
}
.main-table{
  display: grid;
  grid-template-areas: "img table table";
  padding: 0;
  margin: 0;
}
table{
  max-width: 1400px;
}
table input, table select{
  width: 80px;
}
</style>
<script>
import {mapActions, mapGetters, mapMutations} from "vuex";
import pog from "../pogination/pog.vue";
import AcaWork from "./fillingForms/AcaWork.vue";

export default {
  components: { pog, AcaWork },
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
      defaultModel: {
        id: 1,
        specialization: '',
        group: '',
        academicDiscipline: '',
        firstSemPlan: 0,
        secondSemPlan: 0,
        isEditMode: false
      },
      model: {
        id: 1,
        specialization: '',
        group: '',
        academicDiscipline: '',
        firstSemPlan: 0,
        secondSemPlan: 0,
        isEditMode: false
      }
    };
  },
  methods: {
    ...mapActions({
      LOAD_ACADEMIC_WORKS: 'academicWork/LOAD_ACADEMIC_WORKS',
      MARK_WORK_AS_EDITED: 'academicWork/MARK_WORK_AS_EDITED'
    }),
    ...mapGetters({
      GET_ACADEMIC_WORK: 'academicWork/GET_ACADEMIC_WORK',
      GET_ALL_SPECIALIZATIONS: 'GET_ALL_SPECIALIZATIONS',
      GET_ALL_ACADEMIC_DISCIPLINES: 'GET_ALL_ACADEMIC_DISCIPLINES',
      GET_ALL_GROUPS: 'GET_ALL_GROUPS',
    }),
    REDACTION_STATE_TURN(work){
      this.model.isEditMode = true

      this.MARK_WORK_AS_EDITED(work.id)

      this.model.id = work.id
      this.model.specialization = work.specialization;
      this.model.academicDiscipline = work.academicDiscipline;
      this.model.group = work.group;
      this.model.incompleteReason = work.incompleteReason
      this.model.firstSemPlan = work.firstSemester.plan;
      this.model.firstSemFact = work.firstSemester.fact;

      this.model.secondSemPlan = work.secondSemester.plan;
      this.model.secondSemFact = work.secondSemester.fact;
      this.model.absoluteResults = work.absoluteResults;
      this.model.qualityResults = work.qualityResults;
    },

    onDataUpdated() {
      this.LOAD_ACADEMIC_WORKS(this.pageRequest).then((data) => {
        this.totalElements = data.totalElements;
        this.totalPages = data.totalPages;
        this.pageNumber = data.pageable.pageNumber + 1;
      });
    },

    onCancelUpdate() {
      this.model = {...this.defaultModel};
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

<template>
  <div class="academic_work_page">
    <AcaWork grid-area="filling-form" :model="this.model" @dataUpdated="onDataUpdated" @cancelUpdate="onCancelUpdate"></AcaWork>
    <table>
      <thead>
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
      </thead>
      <tbody>
        <tr v-for="work in GET_ACADEMIC_WORK()" v-bind:class="{'selected_row': work.isEdit}" :key="work.id" v-on:click="REDACTION_STATE_TURN(work)">
          <td>{{ work.id }}</td>
          <td>{{ work.specialization.specialization }}</td>
          <td>{{ work.academicDiscipline.disciplineNumber }}</td>
          <td>{{ work.academicDiscipline.name }}</td>
          <td>{{ work.group.groupName }}</td>
          <td>{{ work.firstSemester ? work.firstSemester.plan : "" }}</td>
          <td>{{ work.firstSemester ? work.firstSemester.fact : "" }}</td>
          <td>{{ work.secondSemester ? work.secondSemester.plan : "" }}</td>
          <td>{{ work.secondSemester ? work.secondSemester.fact : "" }}</td>
          <td>{{ work.academicYear ? work.academicYear.plan : "" }}</td>
          <td>{{ work.academicYear ? work.academicYear.fact : "" }}</td>
          <td>{{ work.incompleteReason ? work.incompleteReason : "" }}</td>
          <td>{{ work.absoluteResults ? work.absoluteResults : "" }}</td>
          <td>{{ work.qualityResults ? work.qualityResults : "" }}</td>
        </tr>
      </tbody>

      <pog :totalPages="totalPages" :totalElements="totalElements" :pageRequest="pageRequest"></pog>
    </table>
  </div>
</template>

<style scoped>

.academic_work_page{
  padding: 1em;
  display: grid;
  grid-template-columns: 270px 1fr;
}

table input, table select{
  width: 80px;
}
.selected_row {
  background-color: #e1e1e1;
}
</style>
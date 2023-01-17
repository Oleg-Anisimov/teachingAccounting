<script setup>
import AcaWork from "./fillingForms/AcaWork.vue";
</script>
<template>
  <div class="academic_work_page">
    <AcaWork grid-area="filling-form"></AcaWork>
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
      <pog :totalPages="totalPages" :totalElements="totalElements" :pageRequest="pageRequest"></pog>
    </table>
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
      pageRequest: {
        page: 0,
        size: 10,
      },
      totalElements: 0,
      totalPages: 0,
      offset: 0,
      pageNumber: 0,
    };
  },
  methods: {
    ...mapActions({
      LOAD_ACADEMIC_WORKS: 'academicWork/LOAD_ACADEMIC_WORKS',

    }),
    ...mapGetters({
      GET_ACADEMIC_WORK: 'academicWork/GET_ACADEMIC_WORK',
    }),
  },
  mounted() {
    document.title = "Учебная работа";
    let resultPromise = this.LOAD_ACADEMIC_WORKS(this.pageRequest);
    resultPromise.then((data) => {
      this.totalElements = data.totalElements;
      this.totalPages = data.totalPages;
      this.pageNumber = data.pageable.pageNumber + 1;
    });
  },
}
</script>
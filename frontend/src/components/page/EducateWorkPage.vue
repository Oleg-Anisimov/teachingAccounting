<script setup>
import EducWork from "./fillingForms/EducWork.vue";
</script>
<template>
  <div class="academic_work_page">
    <EducWork grid-area="filling-form"></EducWork>
    <table>
      <tr>
        <th colspan="140"><img src="">Воспитательная работа - Заполнение индивидуального плана</th>
      </tr>
      <tr>
        <td class="left-helf simvol">№</td>
        <td class="left-helf">Направление работы</td>
        <td class="left-helf">Вид деятельности</td>
        <td class="left-helf">Вид мероприятия</td>
        <td class="left-helf">Название мероприятия</td>
        <td class="left-helf">Уровень мероприятия</td>
        <td class="left-helf">Дата</td>
        <td class="left-helf">Информация о студентах</td>
        <td class="right-helf">Результат</td>
      </tr>
      <tr v-for="educate in GET_EDUCATE_WORK()" :key="educate">
        <td>{{ educate.id }}</td>
        <td>{{ $t('enum.WorkVector.' + educate.workVector) }}</td>
        <td>{{ $t('enum.ActivityType.' + educate.activityType) }}</td>
        <td>{{ $t('enum.eventType.' + educate.eventType) }}</td>
        <td>{{ $t('enum.eventLevel.' + educate.eventLevel) }}</td>
        <td></td>
        <td></td>
        <td></td>
        <td></td>
      </tr>
      <pog :totalPages="totalPages" :totalElements="totalElements" :pageRequest="pageRequest"></pog>
    </table>
  </div>
</template>
<script>
import {mapActions, mapGetters} from 'vuex';
import pog from "../pogination/pog.vue";

export default {
  components: {pog},
  name: "EducateWorkPage",
  props: [
    'enums'
  ],
  watch: {
    "pageRequest.page"() {
      let resultPromise = this.LOAD_EDUCATE_WORKS(this.pageRequest);
      resultPromise.then((data) => {
        this.totalPages = data.totalPages;
        this.pageNumber = data.pageable.pageNumber + 1;
      });
    },
    "pageRequest.size"() {
      let resultPromise = this.LOAD_EDUCATE_WORKS(this.pageRequest);
      resultPromise.then((data) => {
        this.totalPages = data.totalPages;
        this.pageNumber = data.pageable.pageNumber + 1;
      });
    },
  },
  data() {
    return {
      totalPages: 0,
      totalElements: 0,
      pageRequest: {
        size: 10,
        page: 0
      }
    }
  },
  methods: {
    ...mapActions([
      'LOAD_EDUCATE_WORKS'
    ]),
    ...mapGetters([
      'GET_EDUCATE_WORK'
      // 'GET_DEPARTMENT_NAMES'
    ]),
  },
  mounted() {
    document.title = 'Воспитательная работа'
    let resultPromise = this.LOAD_EDUCATE_WORKS(this.pageRequest)
    resultPromise.then((data) => {
      this.totalPages = data.totalPages;
      this.pageNumber = data.pageable.pageNumber + 1;
      this.totalElements = data.totalElements;
    })
  },
}
</script>
<style scoped>
.academic_work_page {
  grid-template-areas: "filling-form table table";
}

table {
  max-width: 80em;
}
</style>

 
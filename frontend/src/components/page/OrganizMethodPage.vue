<script setup>
import OrgMethWork from "./fillingForms/OrgMethWork.vue";
</script>
<template>
  <div class="academic_work_page">
    <OrgMethWork grid-area="filling-form"></OrgMethWork>
    <table>
      <tr>
        <th colspan="140"><img src="">Организационно-методическая работа - Заполнение индивидуального плана</th>
      </tr>
      <tr>
        <td class="left-helf simvol">№</td>
        <td class="left-helf">Вид деятельности</td>
        <td class="left-helf">Вид мероприятия</td>
        <td class="left-helf">Название мероприятия</td>
        <td class="left-helf">Уровень мероприятия</td>
        <td class="left-helf">Дата</td>
        <td class="left-helf">Информация о студентах</td>
        <td class="left-helf">Результат</td>

      </tr>
      <tr v-for="organ in GET_ORGANIZED_METHOD()" :key="organ">
        <td>{{ organ.id }}</td>
        <td>{{ $t('enum.ActivityType.' + organ.activityType) }}</td>
        <td>{{ $t('enum.eventType.' + organ.eventType) }}</td>
        <td></td>
        <td>{{ $t('enum.eventLevel.' + organ.eventLevel) }}</td>
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
  name: "OrganizMethodPage",
  props: [
    'enums'
  ],
  watch: {
    "pageRequest.page"() {
      let resultPromise = this.LOAD_ORGANIZED_METHODS(this.pageRequest);
      resultPromise.then((data) => {
        this.totalPages = data.totalPages;
        this.pageNumber = data.pageable.pageNumber + 1;
      });
    },
    "pageRequest.size"() {
      let resultPromise = this.LOAD_ORGANIZED_METHODS(this.pageRequest);
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
      'LOAD_ORGANIZED_METHODS'
    ]),
    ...mapGetters([
      'GET_ORGANIZED_METHOD'
    ]),
  },
  mounted() {
    document.title = 'Организационно-методическая работа'
    let resultPromise = this.LOAD_ORGANIZED_METHODS(this.pageRequest);
    resultPromise.then((data) => {
      this.totalPages = data.totalPages;
      this.pageNumber = data.pageable.pageNumber + 1;
      this.totalElements = data.totalElements;
    });
  },
}
</script>
<style scoped>
.academic_work_page {
  grid-template-areas: "filling-form table table";
}

table {
  max-width: 75em;
}
</style>
 
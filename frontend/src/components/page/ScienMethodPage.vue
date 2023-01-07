<script setup>
import ScienMethWork from "./fillingForms/ScienMethWork.vue";
</script>
<template>
    <div class="academic_work_page">
        <ScienMethWork grid-area="filling-form"></ScienMethWork>
        <table>
            <tr>
                <th colspan="140"><img src="">Научно-методическая работа - Заполнение индивидуального плана</th>
            </tr>
            <tr>
                    <td class="left-helf simvol">№</td>
                    <td class="left-helf">Вид деятельности</td>
                    <td class="left-helf">Вид мероприятия</td>
                    <td class="left-helf">Название мероприятия</td>
                    <td class="left-helf">Уровень мероприятия</td>
                    <td class="left-helf">Дата</td>
                    <td class="left-helf">Место</td>
                    <td class="left-helf">Вид участия</td>
                    <td class="right-helf">Результат</td>
            </tr>
              <tr v-for="scien in GET_SCIENTIFIC_METHOD()" :key="scien">
                <td>{{scien.id}}</td>
                <td>{{$t('enum.ActivityType.' + scien.activityType)}}</td>
                <td>{{$t('enum.eventType.' + scien.eventType)}}</td>
                <td></td>
                <td>{{$t('enum.eventLevel.' + scien.eventLevel)}}</td>
                <td></td>
                <td></td>
                <td></td>
                <td>{{$t('enum.ParticipationType.' + scien.participationType)}}</td>
              </tr>
              <pog :totalPages="totalPages" :totalElements="totalElements" :pageRequest="pageRequest"></pog>
        </table>
    </div>
</template>
<script>
import { mapActions, mapGetters } from 'vuex';
import pog from "../pogination/pog.vue";

export default{
    components: { pog },
    name: "ScienMethodPage",
    props: [
        'enums'
    ],
    watch: {
    "pageRequest.page"() {
      let resultPromise = this.LOAD_SCIENTIFIC_METHODS(this.pageRequest);
      resultPromise.then((data) => {
        this.totalPages = data.totalPages;
        this.pageNumber = data.pageable.pageNumber + 1;
      });
    },
    "pageRequest.size"() {
      let resultPromise = this.LOAD_SCIENTIFIC_METHODS(this.pageRequest);
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
    ...mapActions([
      'LOAD_SCIENTIFIC_METHODS'
    ]),
    ...mapGetters([
      'GET_SCIENTIFIC_METHOD'
      // 'GET_DEPARTMENT_NAMES'
    ]),
  },
  mounted(){
    document.title = 'Научно-методическая работа';
    let resultPromise = this.LOAD_SCIENTIFIC_METHODS(this.pageRequest);
    resultPromise.then((data) => {
      this.totalElements = data.totalElements;
      this.totalPages = data.totalPages;
      this.pageNumber = data.pageable.pageNumber + 1;
    });
  },
}
</script>
<style scoped>
    .academic_work_page{
        grid-template-areas: "filling-form table table";
    }
    table{
        max-width: 70em;
    }
</style>

 
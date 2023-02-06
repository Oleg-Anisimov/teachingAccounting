<script setup>
import PromQual from "./fillingForms/PromQual.vue";
</script>
<template>
    <div class="academic_work_page">
        <PromQual grid-area="filling-form"></PromQual>
        <table>
            <tr>
                <th colspan="140"><img src="">Повышение уровня квалификации - Заполнение индивидуального плана</th>
            </tr>
            <tr>
                    <td class="left-helf simvol">№</td>
                    <td class="left-helf">Форма повышения</td>
                    <td class="left-helf">Дата</td>
                    <td class="left-helf">Место</td>
                    <td class="left-helf">Тема</td>
                    <td class="left-helf">Документ/Результат</td>
            </tr>
              <tr v-for="lvl in GET_PROMOTION_QUALIFICATION_LVL()" :key="lvl">
                <td>{{lvl.id}}</td>
                <td>{{$t('enum.PromotionForm.' + lvl.promotionForm)}}</td>
                <td>{{ lvl.date }}</td>
                <td>{{ lvl.place }}</td>
                <td>{{ lvl.topic }}</td>
                <td>{{ lvl.documentOrResult }}</td>

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
    name: "PromotionQualificLVLPage",
    props: [
        'enums'
    ],
  watch: {
    "pageRequest.page"() {
      let resultPromise = this.LOAD_PROMOTION_QUALIFICATION_LVLS(this.pageRequest);
      resultPromise.then((data) => {
        this.totalPages = data.totalPages;
        this.pageNumber = data.pageable.pageNumber + 1;
      });
    },
    "pageRequest.size"() {
      let resultPromise = this.LOAD_PROMOTION_QUALIFICATION_LVLS(this.pageRequest);
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
      LOAD_PROMOTION_QUALIFICATION_LVLS: 'promotionQualificLVL/LOAD_PROMOTION_QUALIFICATION_LVLS'
    }),
    ...mapGetters({
      GET_PROMOTION_QUALIFICATION_LVL: 'promotionQualificLVL/GET_PROMOTION_QUALIFICATION_LVL'
      // 'GET_DEPARTMENT_NAMES'
    }),
  },
  mounted(){
    document.title = 'Повышение уровня квалификации';
    let resultPromise = this.LOAD_PROMOTION_QUALIFICATION_LVLS(this.pageRequest);
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
        max-width: 45em;
    }
</style>

 
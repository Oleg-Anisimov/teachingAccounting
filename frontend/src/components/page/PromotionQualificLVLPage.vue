<script setup>
import PromQual from "./fillingForms/PromQual.vue";
</script>
<template>
    <div class="academic_work_page">
        <PromQual grid-area="filling-form"></PromQual>
        <table>
            <tr>
                <th colspan="140"><img src="">Учебная работа - Заполнение индивидуального плана</th>
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
                <td>{{lvl.index}}</td>
                <td>{{ lvl.specialization }}</td>
                <td>{{ lvl.discipline.disciplineNumber }}</td>
                <td>{{ lvl.discipline.name }}</td>
                <td>{{ lvl.group }}</td>
                <td></td>

              </tr>
            <tr>
                <td colspan="100" class="last-td">
                    <p>1 - 10 (Всего: 0) На страницу: <input type="number" value="0"></p>    
                </td>
                
            </tr>
        </table>
    </div>
</template>
<script>
import { mapActions, mapGetters } from 'vuex';

export default{
    name: "PromotionQualificLVLPage",
    props: [
        'enums'
    ],
    methods: {
    ...mapActions([
      'LOAD_PROMOTION_QUALIFICATION_LVLS'
    ]),
    ...mapGetters([
      'GET_PROMOTION_QUALIFICATION_LVL'
      // 'GET_DEPARTMENT_NAMES'
    ]),
  },
  mounted(){
    this.LOAD_PROMOTION_QUALIFICATION_LVLS()
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

 
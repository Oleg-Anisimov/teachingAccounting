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
              <tr v-for="work in GET_ACADEMIC_WORK()" :key="work">
                <td>{{work.index}}</td>
                <td>{{ work.specialization }}</td>
                <td>{{ work.discipline.disciplineNumber }}</td>
                <td>{{ work.discipline.name }}</td>
                <td>{{ work.group }}</td>
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
      'LOAD_ENUMS',
      'LOAD_DEPARTMENTS',
      'LOAD_SPECIALIZATION',
      'LOAD_ACADEMIC_DISCIPLINE',
    ]),
    ...mapGetters([
      'GET_ENUMS',
      'GET_TEACHER_CATEGORIES',
      'GET_EMPLOYMENT_TYPES',
      'GET_POSITIONS',
      'GET_ALL_DEPARTMENTS',
      'GET_ALL_SPECIALIZATIONS',
      'GET_ALL_ACADEMIC_DISCIPLINES',
      'GET_ACADEMIC_WORK'
      // 'GET_DEPARTMENT_NAMES'
    ]),
  },
  mounted(){
    this.LOAD_ENUMS()
    this.LOAD_DEPARTMENTS()
    this.LOAD_SPECIALIZATION()
    this.LOAD_ACADEMIC_DISCIPLINE()
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

 
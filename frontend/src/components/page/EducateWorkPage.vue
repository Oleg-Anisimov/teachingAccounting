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
                <td>{{educate.id}}</td>
                <td>{{$t('enum.WorkVector.' + educate.workVector)}}</td>
                <td>{{$t('enum.ActivityType.' + educate.activityType)}}</td>
                <td>{{$t('enum.eventType.' + educate.eventType)}}</td>
                <td>{{$t('enum.eventLevel.' + educate.eventLevel)}}</td>
                <td></td>
                <td></td>
                <td></td>
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
    name: "EducateWorkPage",
    props: [
        'enums'
    ],
    methods: {
    ...mapActions([
      'LOAD_EDUCATE_WORKS'
    ]),
    ...mapGetters([
      'GET_EDUCATE_WORK'
      // 'GET_DEPARTMENT_NAMES'
    ]),
  },
  mounted(){
    this.LOAD_EDUCATE_WORKS()
  },
}
</script>
<style scoped>
    .academic_work_page{
        grid-template-areas: "filling-form table table";
    }
    table{
        max-width: 80em;
    }
</style>

 
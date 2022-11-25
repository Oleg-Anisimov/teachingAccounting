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
    name: "ScienMethodPage",
    props: [
        'enums'
    ],
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
    this.LOAD_SCIENTIFIC_METHODS()
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

 
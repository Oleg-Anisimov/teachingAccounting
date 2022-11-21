<script setup>
import OrgMethWork from "./fillingForms/OrgMethWork.vue";
</script>
<template>
    <div class="academic_work_page">
        <OrgMethWork grid-area="filling-form"></OrgMethWork>
        <table>
            <tr>
                <th colspan="140"><img src="">Учебная работа - Заполнение индивидуального плана</th>
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
                <td>{{organ.index}}</td>
                <td></td>
                <td>{{organ.eventType}}</td>
                <td></td>
                <td>{{organ.eventLevel}}</td>
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
    name: "OrganizMethodPage",
    props: [
        'enums'
    ],
    methods: {
    ...mapActions([
      'LOAD_ORGANIZED_METHODS'
    ]),
    ...mapGetters([
      'GET_ORGANIZED_METHOD'
    ]),
  },
  mounted(){
    this.LOAD_ORGANIZED_METHODS()
  },
}
</script>
<style scoped>
    .academic_work_page{
        grid-template-areas: "filling-form table table";
    }
    table{
        max-width: 75em;
    }
</style>
 
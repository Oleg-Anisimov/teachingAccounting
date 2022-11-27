<script setup>
import AcaProdWork from "./fillingForms/AcaProdWork.vue";
</script>
<template>
    <div class="academic_work_page">
        <AcaProdWork grid-area="filling-form"></AcaProdWork>
        <table>
            <tr>
                <th colspan="140"><img src="">Учебная-производственная работа - Заполнение индивидуального плана</th>
            </tr>
            <tr>
                    <td class="left-helf simvol">№</td>
                    <td class="left-helf">Специальность</td>
                    <td class="left-helf">Тип кабинета</td>
                    <td class="left-helf">Наименование кабинета</td>
                    <td class="left-helf">Вид деятельности</td>
                    <td class="left-helf">Вид УПД</td>
                    <td class="left-helf">Дата</td>
                    <td class="left-helf">Результат</td>
            </tr>
              <tr v-for="product in GET_ACADEMIC_PRODUCTION()" :key="product">
                <td>{{ product.id }}</td>
                <td>{{ product.specialization.specialization }}</td>
                <td></td>
                <td></td>
                <td>{{$t('enum.ActivityType.' + product.activityType)}}</td>
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
    name: "AcademicProductWorkPage",
    props: [
        'enums'
    ],
    methods: {
    ...mapActions([
      'LOAD_ACADEMIC_PRODUCTIONS',
    ]),
    ...mapGetters([
      'GET_ACADEMIC_PRODUCTION'
    ]),
    },
    mounted(){
        document.title = 'Учебно-производственная работа'
      this.LOAD_ACADEMIC_PRODUCTIONS()

  },
}
</script>
<style scoped>
    .academic_work_page{
        grid-template-areas: "filling-form table table";
    }
    table{
        max-width: 60em;
    }
</style>

 
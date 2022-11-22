<script setup>
import AcaMethWork from "./fillingForms/AcaMethWork.vue";
</script>
<template>
    <div class="academic_work_page">
        <AcaMethWork grid-area="filling-form"></AcaMethWork>
        <table>
            <tr>
                <th colspan="140"><img src="">Учебная работа - Заполнение индивидуального плана</th>
            </tr>
            <tr>
                    <td class="left-helf simvol">№</td>
                    <td class="left-helf">Специальность</td>
                    <td class="left-helf">Наименование специальности</td>
                    <td class="left-helf">Уч. дисциплина(ПМ,МДК)</td>
                    <td class="left-helf">Наименование уч.дисциплины(ПМ,МДК)</td>
                    <td class="left-helf">Вид деятельности</td>
                    <td class="left-helf">Вид УМД</td>
                    <td class="left-helf">Тип УМД</td>
                    <td class="left-helf">Срок исполнения</td>
                    <td class="left-helf">Краткий отчёт о выполении</td>
            </tr>
              <tr v-for="method in GET_ACADEMIC_METHOD()" :key="method.id">
                <td>{{method.id}}</td>
                <td>{{ method.specialization.specialization }}</td>
                <td>{{ method.specialization.specializationName }}</td>
                <td>{{ method.academicDiscipline.disciplineNumber }}</td>
<!--                Название уч дисциплины-->
                <td>{{ method.academicDiscipline.name }}</td>
                <td>{{ method.activityType }}</td>
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
    name: "AcademMethodPage",
    props: [
        'enums'
    ],
    methods: {
    ...mapActions([
      'LOAD_ACADEMIC_METHODS',
    ]),
    ...mapGetters([
      'GET_ACADEMIC_METHOD',
    ]),
  },
  mounted(){
    this.LOAD_ACADEMIC_METHODS()
  },
}
</script>

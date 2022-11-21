<script setup>
import AcaWork from "./fillingForms/AcaWork.vue";
</script>
<template>
    <div class="academic_work_page">
        <AcaWork grid-area="filling-form"></AcaWork>
        <table>
            <tr>
                <th colspan="140"><img src="">Учебная работа - Заполнение индивидуального плана</th>
            </tr>
            <tr>
                    <td rowspan="2" class="left-helf simvol">№</td>
                    <td rowspan="2" class="left-helf">Специальность</td>
                    <td rowspan="2" class="left-helf">Уч. дисциплина (ПМ,МДК)</td>
                    <td rowspan="2" class="left-helf">Наименование уч. дисциплины (ПМ,МДК)</td>
                    <td rowspan="2" class="left-helf">Группа</td>
                    <td colspan="2" class="left-helf">Первый семестр</td>
                    <td colspan="2" class="left-helf">Второй семестр</td>
                    <td colspan="2" class="left-helf">Учебный год</td>
                    <td rowspan="2" class="right-helf">Причина невыполнения</td>
                    <td rowspan="2" class="right-helf">Абсолютная успеваемость</td>
                    <td rowspan="2" class="right-helf">Качественная успеваемость</td>
            </tr>
            <tr>
                <td class="td-bottom">План</td>
                <td class="td-bottom">Факт</td>
                <td class="td-bottom">План</td>
                <td class="td-bottom">Факт</td>
                <td class="td-bottom">План</td>
                <td class="td-bottom">Факт</td>
            </tr>
              <tr v-for="work in GET_ACADEMIC_WORK()" :key="work.id">
                <td>{{ work.id }}</td>
                <td>{{ work.specialization.specialization }}</td>
                <td>{{ work.academicDiscipline.disciplineNumber }}</td>
<!--                Название уч дисциплины-->
                <td>{{ work.academicDiscipline.name }}</td>
                <td>{{ work.group.groupName }}</td>
                <td>{{ work.firstSemPlan }}</td>
                <td></td>
                <td>{{ work.secondSemPlan }}</td>
                <td></td>
                <td></td>
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
import {mapActions, mapGetters} from 'vuex';

export default {
    name: "AcademicWorkPage",
    props: [
        'enums'
    ],
    methods: {
    ...mapActions([
      'LOAD_ACADEMIC_WORKS',
    ]),
    ...mapGetters([
      'GET_ACADEMIC_WORK'
    ]),
  },
  mounted(){
    this.LOAD_ACADEMIC_WORKS()

  },
}
</script>

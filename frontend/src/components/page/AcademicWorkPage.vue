<script setup>
import Table from "../Table.vue";
</script>
<template>
    <div class="academic_work_page">
        <Table grid-area="filling-form"></Table>
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
            <tr>
                <td></td>
                <td></td>
                <td></td>
                <td></td>
                <td></td>
                <td></td>
                <td></td>
                <td></td>
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
import { mapActions, mapGetters } from 'vuex';

export default{
    name: "AcademicWorkPage",
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
<style>
    .academic_work_page{
        padding: 1em;
        background-color: #e1e1e1;
        height: 53em;
        display: grid;
        grid-template-areas: "filling-form table";
        grid-gap: 1em;
    }
    table{
        grid-area: table;
        max-height: 50px;
        max-width: 94em;
        border: 0.2em solid royalblue;
        background-color: #f1f1f1;
    }
    table td{
        border: 0.2em solid royalblue;
        text-align: center;
        justify-content: center;
        vertical-align: middle;
    }
    table th{
        border: 0.2em solid royalblue;
        text-align: center;
        justify-content: center;
        vertical-align: middle;
    }
    .left-helf{
        padding: 10px 0;
    }
    .right-helf{
        padding: 0px 20px;
        word-wrap:break-word;
        width: 100px;
    }
    .td-bottom{
        padding: 5px 0;
    }
    .simvol{
        padding: 0 5px;
    }
    .last-td p{
        text-align: left;
    }
    .last-td input{
        width: 3em;
        border: 1px solid black;
    }
    .last-td{
        padding: 3px;
    }
</style>

 
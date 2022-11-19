<template>
    <div class="filling-form">
        <div class="academ-year">
            <p class="main-p">Академический год</p>
            <div class="form-border">
                <select name="year">
                    <option value="option0">2021/2022</option>
                    <option value="option1">2022/2023</option>
                    <option value="option2">2023/2024</option>
                    <option value="option3">2024/2025</option>
                    <option value="option4">2025/2026</option>
                    <option value="option5">2026/2027</option>
                </select>
            </div>
        </div>
        <div class="article">
            <p class="main-p">Новая запись</p>
            <div class="form-border">
                <p>Вид деятельности</p>
                <select v-model="work.specialization">
                    <option disabled value="">Выберите специальность</option>
                    <option v-for="specialization in GET_ALL_SPECIALIZATIONS()" :key="specialization" :value="specialization.specialization">{{specialization.specialization}}</option>
                </select>
                <p>Вид мероприятия</p>
                <select v-model="work.discipline">
                  <option disabled value="">Выберите дисциплину</option>
                  <option v-for="discipline in GET_ALL_ACADEMIC_DISCIPLINES()" :key="discipline" :value="discipline">{{discipline.disciplineNumber}}</option>
                </select>
                <p>Название мероприятия</p>
                <input type="text">
                <p>Уровень мероприятия</p>
                <select v-model="work.discipline">
                  <option disabled value="">Выберите дисциплину</option>
                  <option v-for="discipline in GET_ALL_ACADEMIC_DISCIPLINES()" :key="discipline" :value="discipline">{{discipline.disciplineNumber}}</option>
                </select>
                <p>Дата</p>
                <input type="text">
                <p>Место</p>
                <input type="text">
                <p>Вид участия</p>
                <select v-model="work.discipline">
                  <option disabled value="">Выберите дисциплину</option>
                  <option v-for="discipline in GET_ALL_ACADEMIC_DISCIPLINES()" :key="discipline" :value="discipline">{{discipline.disciplineNumber}}</option>
                </select>
                <button @click="clickButton()">Добавить</button> 
            </div>    
        </div>
        <div class="export">
            <div class="form-border">
                <button><img src="../../../assets/img/print.png"> Версия для печати</button>
                <button class="last-button"><img src="../../../assets/img/excel.png">Экспорт в Excel</button>
            </div>
        </div>
    </div>
</template>
<script>
import {mapActions, mapGetters, mapMutations} from 'vuex';

export default{
    name: "ScienMethWork",
    props: [
        'enums'
    ],
    data() {
      return {
        selected: '',
        work: {
          specialization: '',
          group: '',
          discipline: {
            
          },
          input: '<input type="text">',
          index: 0,
        },
        
      }
    },
    methods: {
    ...mapActions([
      'LOAD_ENUMS',
      'LOAD_DEPARTMENTS',
      'LOAD_SPECIALIZATION',
      'LOAD_ACADEMIC_DISCIPLINE',
    ]),
    ...mapMutations([
        'ADD_ACADEMIC_WORK'
    ]),
    ...mapGetters([
      'GET_ENUMS',
      'GET_TEACHER_CATEGORIES',
      'GET_EMPLOYMENT_TYPES',
      'GET_POSITIONS',
      'GET_ALL_DEPARTMENTS',
      'GET_ALL_SPECIALIZATIONS',
      'GET_ALL_ACADEMIC_DISCIPLINES',
      //'',
      // 'GET_DEPARTMENT_NAMES'
    ]),

    clickButton(){
      this.ADD_ACADEMIC_WORK(this.work);
      console.log(this.work.specialization)
      this.work.index++
    },
  },
  mounted(){
    this.LOAD_ENUMS()
    this.LOAD_SPECIALIZATION()
    this.LOAD_ACADEMIC_DISCIPLINE()
    //this.
  },

}

</script>

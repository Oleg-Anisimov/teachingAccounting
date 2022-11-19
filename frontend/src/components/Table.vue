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
                <p>Специальность</p>
                <select v-model="work.specialization">
                    <option disabled value="">Выберите специальность</option>
                    <option v-for="specialization in GET_ALL_SPECIALIZATIONS()" :key="specialization" :value="specialization.specialization">{{specialization.specialization}}</option>
                </select>
                <p>Учебная дисциплина</p>
                <select v-model="work.discipline">
                  <option disabled value="">Выберите дисциплину</option>
                  <option v-for="discipline in GET_ALL_ACADEMIC_DISCIPLINES()" :key="discipline" :value="discipline.disciplineNumber">{{discipline.disciplineNumber}}</option>
                </select>
                <p>Учебная группа</p>
                <select v-model="work.group">
                    <option v-for="specialization in GET_ALL_SPECIALIZATIONS()" :key="specialization" :value="specialization.specialization">{{specialization.specialization}}</option>
                </select><br>
                <p>Кол-во часов по плану:</p>
                <p>l Семестр</p>
                <input type="number" name="first_half" value="0">
                <p>ll Семестр</p>
                <input type="number" name="last_half" value="0">
                <button @click="clickButton()">Добавить</button> 
            </div>    
        </div>
        <div class="export">
            <div class="form-border">
                <button><img src="../assets/img/print.png"> Версия для печати</button>
                <button class="last-button"><img src="../assets/img/excel.png">Экспорт в Excel</button>
            </div>
        </div>
    </div>
</template>
<script>
import {mapActions, mapGetters, mapMutations} from 'vuex';

export default{
    name: "Table",
    props: [
        'enums'
    ],
    data() {
      return {
        selected: '',
        work: {
          specialization: '',
          group: '',
          discipline: ''
        }
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

<style>
.filling-form{
    text-align: center;
    width: 15em;
}
.academ-year{
    border-top: 0;
}
.aboba{
    border:  0.2em solid royalblue;
    border-radius: 0 0 0.7em 0.7em;
}
.form-border{
    padding: 0.5em 0;
    border:  0.2em solid royalblue;
    border-radius: 0 0 0.7em 0.7em;
}
.filling-form .main-p{
    text-align: center;
    color: white;
    background-color: royalblue;
    border-radius: 0.7em 0.7em 0 0;
}
.article{
    margin: 1em 0;
}
.filling-form button,input,select{
    width: 11em;
    border-radius: 0.2em;
}
.filling-form select{
    border: 1px solid black;
}
.filling-form input{
    border: 1px solid black;
}
.filling-form button{
    text-align: center;
    border: 1px solid black;
    margin-top: 0.8em;
}
.export .form-border{
    border-radius: 0.7em;
    padding: 0;
}
.export .form-border button{
    margin-top: 0.5em;
    font-size: 0.96em;
}
.export .form-border .last-button{
    margin-bottom: 0.5em;
}
.export .form-border button img{
    width: 1em;
    height: 1em;
    margin-right: 0.1em;
    font-size: medium;
}
.article .form-border select,input,button{
    margin-bottom: 0.5em;
}
.form-border p{
    margin-bottom: 0.2em;
}



</style>
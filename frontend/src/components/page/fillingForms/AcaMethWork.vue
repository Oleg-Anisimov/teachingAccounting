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
                <select v-model="model.specialization">
                    <option disabled value="">Выберите специальность</option>
                    <option v-for="specialization in GET_ALL_SPECIALIZATIONS()" :key="specialization" :value="specialization.specialization">{{specialization.specialization}}</option>
                </select>
                <p>Учебная дисциплина</p>
                <select v-model="model.discipline">
                  <option disabled value="">Выберите дисциплину</option>
                  <option v-for="discipline in GET_ALL_ACADEMIC_DISCIPLINES()" :key="discipline" :value="discipline">{{discipline.disciplineNumber}}</option>
                </select>
                <p>Вид деятельности</p>
                <select>
                    <option value=""></option>
                </select><br>
                <p>Вид УМД</p>
                <select>
                    <option value=""></option>
                </select><br>
                <p>Тип УМД</p>
                <select>
                    <option value=""></option>
                </select><br>
                <p>Срок исполнения</p>
                <input type="text">
                <button @click="addAcademicMethod()">Добавить</button> 
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
import AcademicMethod from "../../../model/academicMethod";

export default{
    name: "AcaMethWork",
    props: [
        'enums'
    ],
    data() {
      return {
        model: {
          id: 1,
          specialization: '',
          academicDiscipline: '',
        },
        
      }
    },
    methods: {
    ...mapActions([
      'LOAD_ENUMS',
      'LOAD_SPECIALIZATION',
      'LOAD_ACADEMIC_DISCIPLINE',
      'UPLOAD_ACADEMIC_METHOD',
    ]),
    ...mapMutations([
        'ADD_ACADEMIC_METHOD'
    ]),
    ...mapGetters([
      'GET_ENUMS',
      'GET_EMPLOYMENT_TYPES',
      'GET_ALL_SPECIALIZATIONS',
      'GET_ALL_ACADEMIC_DISCIPLINES',
      'GET_ACADEMIC_METHOD',
    ]),
    addAcademicMethod(){
      this.UPLOAD_ACADEMIC_METHOD(new AcademicMethod(
          this.id,
          this.model.specialization,
          this.model.academicDiscipline,
      ))
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


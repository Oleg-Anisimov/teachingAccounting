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
                <select>
                    <option disabled value="">Выберите специальность</option>
                    <option value=""></option>
                </select>
                <p>Вид мероприятия</p>
                <select v-model="model.eventType">
                  <option disabled value="">Выберите вид мероприятие</option>
                  <option v-for="organ in GET_ENUMS().EventType" :key="organ" :value="organ">{{organ}}</option>
                </select>
                <p>Название мероприятия</p>
                <input type="text">
                <p>Уровень мероприятия</p>
                <select v-model="model.eventLevel">
                  <option disabled value="">Выберите уровень мероприятие</option>
                  <option v-for="organ in GET_ENUMS().EventLevel" :key="organ" :value="organ">{{organ}}</option>
                </select>
                <p>Дата</p>
                <input type="date">
                <p>Инфо о студентах</p>
                <input type="text">
                <button @click="addOranizMethod()">Добавить</button> 
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
import OrganizedMethod from "../../../model/organizedMethod";

export default{
    name: "OrgMethWork",
    props: [
        'enums'
    ],
    data() {
      return {
        model: {
          id: 1,
          eventType: '',
          eventLevel: '',
        },

      }
    },
    methods: {
    ...mapActions([
      'LOAD_ENUMS',
      'LOAD_ORGANIZED_METHODS'
    ]),
    ...mapMutations([
        'ADD_ORGANIZ_METHOD'
    ]),
    ...mapGetters([
      'GET_ENUMS',
      'GET_ORGANIZED_METHOD'
      //'',
      // 'GET_DEPARTMENT_NAMES'
    ]),

    addOranizMethod(){
      this.ADD_ORGANIZ_METHOD(new OrganizedMethod(
          this.model.id,
          this.model.eventLevel,
          this.model.eventType
      ))
    },
  },
  mounted(){
    this.LOAD_ENUMS()
    this.LOAD_ORGANIZED_METHODS()
    //this.
  },

}

</script>

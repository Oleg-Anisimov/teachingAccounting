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
                <select v-model="model.activityType">
                  <option disabled value="">Выберите вид деятельности</option>
                  <option v-for="activityType in GET_ENUMS().ActivityType" :key="activityType" :value="activityType">{{$t('enum.ActivityType.' + activityType)}}</option>
                </select>
                <p>Вид мероприятия</p>
                <select v-model="model.eventType">
                  <option disabled value="">Выберите вид мероприятия</option>
                  <option v-for="eventType in GET_ENUMS().EventType" :key="eventType" :value="eventType">{{$t('enum.eventType.' + eventType)}}</option>
                </select>
                <p>Название мероприятия</p>
                <input type="text">
                <p>Уровень мероприятия</p>
                <select v-model="model.eventLevel">
                  <option disabled value="">Выберите уровень мероприятия</option>
                  <option v-for="eventLevel in GET_ENUMS().EventLevel" :key="eventLevel" :value="eventLevel">{{$t('enum.eventLevel.' + eventLevel)}}</option>
                </select>
                <p>Дата</p>
                <input v-model="this.model.date" type="date">
                <p>Место</p>
                <input type="text">
                <p>Вид участия</p>
                <select v-model="model.participationType">
                  <option disabled value="">Выберите вид участия</option>
                  <option v-for="participationType in GET_ENUMS().ParticipationType" :key="participationType" :value="participationType">{{$t('enum.ParticipationType.' + participationType)}}</option>
                </select>
                <button @click="addScienMethod()">Добавить</button> 
            </div>    
        </div>
        <div class="export">
            <div class="form-border">
                <button class="last-button" v-on:click="EXPORT_TO_EXCEL">
                <img src="../../../assets/img/excel.png">Экспорт в Excel</button>
            </div>
        </div>
    </div>
</template>
<script>
import {mapActions, mapGetters, mapMutations} from 'vuex';
import ScientificMethod from "../../../model/scientificMethod";

export default{
    name: "ScienMethWork",
    props: [
        'enums'
    ],
    data() {
      return {
        selected: '',
        model: {
          id: '',
          activityType: '',
          eventLevel: '',
          eventType: '',
          participationType: '',
          date: '',
        },
        
      }
    },
    methods: {
    ...mapActions({
      LOAD_ENUMS: 'categoryBased/LOAD_ENUMS',
      UPLOAD_SCIENTIFIC_METHOD: 'scienMethod/UPLOAD_SCIENTIFIC_METHOD',
      EXPORT_TO_EXCEL: 'scienMethod/EXPORT_TO_EXCEL'
    }),
    ...mapMutations({
      ADD_SCIENTIFIC_METHOD: 'scienMethod/ADD_SCIENTIFIC_METHOD'
    }),
    ...mapGetters({
      GET_ENUMS: 'categoryBased/GET_ENUMS',
      //'',
      // 'GET_DEPARTMENT_NAMES'
    }),

    addScienMethod(){
      let scien = new ScientificMethod(
          this.id,
          this.model.activityType,
          this.model.eventType,
          this.model.eventLevel,
          this.model.participationType,
          this.model.date,
      )
      console.log(scien)
      this.UPLOAD_SCIENTIFIC_METHOD(scien)
    },
  },
  mounted(){
    this.LOAD_ENUMS()
    //this.
  },

}

</script>

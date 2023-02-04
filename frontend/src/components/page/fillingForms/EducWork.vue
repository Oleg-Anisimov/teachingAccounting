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
                <p>Направление работы</p>
                <select v-model="model.workVector">
                    <option disabled value="">Выберите направление работы</option>
                    <option v-for="workVector in GET_ENUMS().WorkVector" :key="workVector" :value="workVector">{{$t('enum.WorkVector.' + workVector)}}</option>
                </select>
                <p>Вид деятельности</p>
                <select v-model="model.activityType">
                  <option disabled value="">Выберите вид деятельности</option>
                  <option v-for="activityType in GET_ENUMS().ActivityType" :key="activityType" :value="activityType">{{$t('enum.ActivityType.' + activityType)}}</option>
                </select>
                <p>Вид мероприятия</p>
                <select v-model="model.eventType">
                  <option disabled value="">Выберите вид мероприятия</option>
                    <option v-for="eventType in GET_ENUMS().EventType" :key="eventType" :value="eventType">{{$t('enum.eventType.' + eventType)}}</option>
                </select><br>
                <p>Название мероприятия</p>
                <input type="text">
                <p>Уровень мероприятия</p>
                <select v-model="model.eventLevel">
                  <option disabled value="">Выберите уровень мероприятия</option>
                    <option v-for="eventLevel in GET_ENUMS().EventLevel" :key="eventLevel" :value="eventLevel">{{$t('enum.eventLevel.' + eventLevel)}}</option>
                </select><br>
                <p>Дата</p>
                <input v-model="this.model.date" type="date">
                <p>Информация о студентах</p>
                <input type="text">
                <button @click="addEducateWork()">Добавить</button> 
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
import EducateWork from "../../../model/educateWork";

export default{
    name: "EducWork",
    props: [
        'enums'
    ],
    data() {
      return {
        model: {
          index: 1,
          workVector: '',
          activityType: '',
          eventType: '',
          eventLevel: '',
          date: '',

        },
        
      }
    },
    methods: {
    ...mapActions({
      LOAD_ENUMS: 'categoryBased/LOAD_ENUMS',
      UPLOAD_EDUCATE_WORK: 'educateWork/UPLOAD_EDUCATE_WORK',
      EXPORT_TO_EXCEL: 'educateWork/EXPORT_TO_EXCEL'
    }),
    ...mapMutations({
      ADD_EDUCATE_WORK: 'educateWork/ADD_EDUCATE_WORK'
    }),
    ...mapGetters({
      GET_ENUMS: 'categoryBased/GET_ENUMS',
      //'',
      // 'GET_DEPARTMENT_NAMES'
    }),

    addEducateWork(){
      let educate = new EducateWork(
          this.id,
          this.model.workVector,
          this.model.activityType,
          this.model.eventType,
          this.model.eventLevel,
          this.model.date,
      )
      this.UPLOAD_EDUCATE_WORK(educate)
    },
  },
  mounted(){
    this.LOAD_ENUMS()
    //this.
  },

}

</script>


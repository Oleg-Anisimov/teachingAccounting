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
                <input type="text" v-model="model.eventName">
                <p>Уровень мероприятия</p>
                <select v-model="model.eventLevel">
                  <option disabled value="">Выберите уровень мероприятия</option>
                  <option v-for="eventLevel in GET_ENUMS().EventLevel" :key="eventLevel" :value="eventLevel">{{$t('enum.eventLevel.' + eventLevel)}}</option>
                </select>
                <p>Дата</p>
                <input v-model="model.date" type="date">
                <p>Инфо о студентах</p>
                <input type="text" v-model="model.studentInfo">
                <button @click="addOrganizedMethod()">Добавить</button> 
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
          activityType: '',
          date: '',
          studentInfo: '',
          eventName: ''
        },

      }
    },
    methods: {
    ...mapActions({
      LOAD_ENUMS: 'categoryBased/LOAD_ENUMS',
      UPLOAD_ORGANIZED_METHOD: 'organizMethod/UPLOAD_ORGANIZED_METHOD',
      EXPORT_TO_EXCEL: 'organizMethod/EXPORT_TO_EXCEL'
    }),
    ...mapMutations({
      ADD_ORGANIZED_METHOD: 'organizMethod/ADD_ORGANIZED_METHOD'
    }),
    ...mapGetters({
      GET_ENUMS: 'categoryBased/GET_ENUMS',
      //'',
      // 'GET_DEPARTMENT_NAMES'
    }),

    addOrganizedMethod(){
      let organ = new OrganizedMethod(
          this.id,
          this.model.activityType,
          this.model.eventLevel,
          this.model.eventType,
          this.model.date,
          this.model.studentInfo,
          this.model.eventName
      )
      console.log(organ)
      this.UPLOAD_ORGANIZED_METHOD(organ)
    },
  },
  mounted(){
    this.LOAD_ENUMS()
    //this.
  },

}

</script>

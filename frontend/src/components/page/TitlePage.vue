<template>
  <div class="title_page">
    <h1>Титульная страница</h1>
    <form style="max-width: 400px;">
      <div class="ui-input-group">
        <!-- INPUT -->
        <div class="ui-input">
          <label for="input-last-name">Фамилия</label>
          <input id="input-last-name" type="text" :value="teacher.lastName" placeholder="Иванов" />
        </div>
        <div class="ui-input">
          <label for="input-first-name">Имя</label>
          <input id="input-first-name" type="text" :value="teacher.firstName" placeholder="Иван" />
        </div>
        <div class="ui-input">
          <label for="input-middle-name">Отчество</label>
          <input id="input-middle-name" type="text" :value="teacher.middleName" placeholder="Иванович" />
        </div>
        <!-- SELECT -->
        <div class="ui-input">
          <label for="input-last-name">Тип сотрудника</label>
          <select class="ui-select" name="select-XcA1">
            <option selected disabled>Отсутствует</option>
            <option v-for="employmentType in GET_EMPLOYMENT_TYPES()" :key="employmentType" :value="employmentType">{{$t('enum.employmentType.' + employmentType)}}</option>
          </select>
        </div>
        <div class="ui-input">
          <label for="input-last-name">Отделение</label>
          <select class="ui-select" name="select-XcA1">
            <option selected disabled>Отсутствует</option>
            <option v-for="department in GET_ALL_DEPARTMENTS()" :value="department" :key="department.id">{{department.name}}</option>
            <!-- <option v-for="name in GET_DEPARTMENT_NAMES()" :value="name" :key="name">{{name}}</option> -->
          </select>
        </div>
        <div class="ui-input">
          <label for="input-last-name">Должность</label>
          <select class="ui-select" name="select-XcA1">
            <option selected disabled>Отсутствует</option>
            <option v-for="position in GET_POSITIONS()" :key="position" :value="position">{{$t('enum.position.' + position)}}</option>
          </select>
        </div>
        <div class="ui-input">
          <label for="input-last-name">Категория</label>
          <select class="ui-select" name="select-XcA1">
            <option selected disabled>Отсутствует</option>
            <option v-for="category in GET_TEACHER_CATEGORIES()" :key="category" :value="category">
              {{ $t('enum.categories.'+category) }}
            </option>
          </select>
        </div>
        <!-- DATE -->
        <div class="ui-input">
          <label for="input-last-name">Дата последней аттестации</label>
          <input id="input-last-name" type="date"/>
        </div>
        <!-- BUTTON -->
        <div class="ui-button-group">
          <button class="ui-button isDefault">Редактировать</button>
        </div>
      </div>
    </form>
  </div>
</template>

<script>
import { mapActions, mapGetters } from 'vuex';

export default {
  name: "TitlePage",
  props: [
      'teacher',
      'enums'
  ],
  methods: {
    ...mapActions([
      'LOAD_ENUMS',
      'LOAD_DEPARTMENTS'
    ]),
    ...mapGetters([
      'GET_ENUMS',
      'GET_TEACHER_CATEGORIES',
      'GET_EMPLOYMENT_TYPES',
      'GET_POSITIONS',
      'GET_ALL_DEPARTMENTS',
      // 'GET_DEPARTMENT_NAMES'
    ]),
  },
  mounted(){
    this.LOAD_ENUMS()
    this.LOAD_DEPARTMENTS()
  },
}
</script>

<style scoped>
.ui-input-group{
  margin: 1em
}
.title_page{
  padding: 0.5em 1em;
  background-color: #e1e1e1;
}
.title_page h1{
  font-size: 1.5em;
}
.ui-select{
  margin-bottom: 100em;
  width: 800px;
}
.ui-input{
  margin: -0.4em 0;
  width: 400px;
}
.ui-input label{
  font-size: 0.9em;
}
.ui-button{
  background-color: white;
  border-radius: 0.5em;
  padding: 0 1em;
}
.ui-button-group{
  margin-top: 0.2em;
}
</style>
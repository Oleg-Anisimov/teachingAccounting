<template>
  <div class="title_page">
    <h1>Титульная страница</h1>
    <form style="max-width: 400px;">
      <div class="ui-input-group">
        <!-- INPUT -->
        <div class="ui-input">
          <label for="input-last-name">Фамилия</label>
          <input id="input-last-name" type="text" v-model="this.teacher.lastName" :disabled="!editing" placeholder="Иванов"/>
        </div>
        <div class="ui-input">
          <label for="input-first-name">Имя</label>
          <input id="input-first-name" type="text" v-model="this.teacher.firstName" :disabled="!editing" placeholder="Иван"/>
        </div>
        <div class="ui-input">
          <label for="input-middle-name">Отчество</label>
          <input id="input-middle-name" type="text" v-model="this.teacher.middleName" :disabled="!editing"
                 placeholder="Иванович"/>
        </div>
        <!-- SELECT -->
        <div class="ui-input">
          <label for="input-last-name">Тип сотрудника</label>
          <select class="ui-select" :disabled="!editing" name="select-XcA1" v-model="this.teacher.employmentType">
            <option disabled>Отсутствует</option>
            <option v-for="employmentType in GET_EMPLOYMENT_TYPES()" :key="employmentType" :value="employmentType">
              {{ $t('enum.employmentType.' + employmentType) }}
            </option>
          </select>
        </div>
        <div class="ui-input">
          <label for="input-last-name">Отделение</label>
          <select class="ui-select" :disabled="!editing" name="select-XcA1" v-model="this.teacher.department">
            <option disabled>Отсутствует</option>
            <option v-for="department in GET_ALL_DEPARTMENTS()" :value="department" :key="department.id">
              {{ department.name }}
            </option>
            <!-- <option v-for="name in GET_DEPARTMENT_NAMES()" :value="name" :key="name">{{name}}</option> -->
          </select>
        </div>
        <div class="ui-input">
          <label for="input-last-name">Должность</label>
          <select class="ui-select" :disabled="!editing" name="select-XcA1" v-model="this.teacher.position">
            <option disabled>Отсутствует</option>
            <option v-for="position in GET_POSITIONS()" :key="position" :value="position">
              {{ $t('enum.position.' + position) }}
            </option>
          </select>
        </div>
        <div class="ui-input">
          <label for="input-last-name">Категория</label>
          <select class="ui-select" :disabled="!editing" name="select-XcA1" v-model="this.teacher.category">
            <option disabled>Отсутствует</option>
            <option v-for="category in GET_TEACHER_CATEGORIES()" :key="category" :value="category">
              {{ $t('enum.categories.' + category) }}
            </option>
          </select>
        </div>
        <!-- DATE -->
        <div class="ui-input">
          <label for="input-last-name">Дата последней аттестации</label>
          <input v-model="this.teacher.certificationDate" id="last-attestation-date" :disabled="!editing" type="date"/>
        </div>
        <!-- BUTTON -->
        <div class="ui-button-group" v-if="!editing">
          <button class="ui-button isDefault" @click="toggleRedacting()">Редактировать</button>
        </div>
        <div class="ui-button-group" v-if="editing">
          <button class="ui-button isDefault" @click="toggleRedacting()">Отменить</button>
          <button class="ui-button isDefault" v-if="editing" @click="SAVE_EDITED()">Сохранить</button>
        </div>
      </div>
    </form>
  </div>
</template>

<script>
import {mapActions, mapGetters} from 'vuex';
import Teacher from '../../model/teacher';

export default {
  name: "TitlePage",
  props: [
    // 'teacher',
    'enums',
    'user'
  ],
  computed: {
    editing: false,
  },
  data() {
    return {
      teacher: {},
      editing: false
    }
  },
  methods: {

    toggleRedacting() {
      this.editing = !this.editing
    },
    SAVE_EDITED() {
      console.log('Data should be saved')
      var data = new Teacher(
        this.teacher.id,
        this.teacher.lastName,
        this.teacher.firstName,
        this.teacher.middleName,
        this.teacher.employmentType,
        this.teacher.department,
        this.teacher.position,
        this.teacher.category,
        this.teacher.certificationDate,
        this.teacher.userId,
      )
      this.UPLOAD_TEACHER(data)
      console.log(this.GET_ALL_USERS())

      event.preventDefault();
    },
    ...mapActions({
      LOAD_ENUMS: 'categoryBased/LOAD_ENUMS',
      LOAD_DEPARTMENTS: 'LOAD_DEPARTMENTS',
      LOAD_TEACHER: 'LOAD_TEACHER',
      UPLOAD_TEACHER: 'UPLOAD_TEACHER',
      LOAD_ALL_USERS: 'user/LOAD_ALL_USERS',
     }),
    ...mapGetters({
      GET_TEACHER: 'GET_TEACHER',
      GET_ENUMS: 'categoryBased/GET_ENUMS',
      GET_TEACHER_CATEGORIES: 'categoryBased/GET_TEACHER_CATEGORIES',
      GET_EMPLOYMENT_TYPES: 'categoryBased/GET_EMPLOYMENT_TYPES',
      GET_POSITIONS: 'categoryBased/GET_POSITIONS',
      GET_ALL_DEPARTMENTS: 'GET_ALL_DEPARTMENTS',
      GET_ALL_DEPARTMENTS_NAMES: 'GET_ALL_DEPARTMENTS_NAMES',
      getCurrentUser: 'user/GET_CURRENT_USER',
      GET_ALL_USERS: 'user/GET_ALL_USERS',
    }),
  },
  mounted() {
    document.title = 'Титульная страница'
    this.LOAD_TEACHER().then((response) => {
      this.teacher = response
      let deps = this.GET_ALL_DEPARTMENTS();
      let currentDep = deps.find((d) => {return d.id === this.teacher.departmentId})
      this.teacher.department = currentDep;
    })
    this.LOAD_ENUMS()
    this.LOAD_DEPARTMENTS()
    this.LOAD_ALL_USERS()
  },
}
</script>

<style scoped>
.ui-input-group {
  margin: 1em
}

.title_page {
  padding: 0.5em 1em;
  background-color: #e1e1e1;
}

.title_page h1 {
  font-size: 1.5em;
}

.ui-select {
  margin-bottom: 100em;
  width: 800px;
}

.ui-input {
  margin: -0.4em 0;
  width: 400px;
}

.ui-input label {
  font-size: 0.9em;
}

.ui-button {
  background-color: white;
  border-radius: 0.5em;
  padding: 0 1em;
}

.ui-button-group {
  margin-top: 0.2em;
}
</style>
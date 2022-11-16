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
            <option value="option0" selected disabled>Отсутсвует</option>
            <option value="option1">option 1</option>
            <option value="option2">option 2</option>
            <option value="option3">option 3</option>
          </select>
        </div>
        <div class="ui-input">
          <label for="input-last-name">Отделение</label>
          <select class="ui-select" name="select-XcA1">
            <option value="option0" selected disabled>Отсутсвует</option>
            <option value="option1">option 1</option>
            <option value="option2">option 2</option>
            <option value="option3">option 3</option>
          </select>
        </div>
        <div class="ui-input">
          <label for="input-last-name">Должность</label>
          <select class="ui-select" name="select-XcA1">
            <option value="option0" selected disabled>Отсутсвует</option>
            <option value="option1">option 1</option>
            <option value="option2">option 2</option>
            <option value="option3">option 3</option>
          </select>
        </div>
        <div class="ui-input">
          <label for="input-last-name">Категория</label>
          <select class="ui-select" name="select-XcA1">
            <option value="option0" selected disabled>Без категории</option>
            <option value="option1">option 1</option>
            <option value="option2">option 2</option>
            <option value="option3">option 3</option>
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
export default {
  name: "TitlePage",
  props: [
      'teacher',
      'enums'
  ],    
  
}
</script>

<style scoped>
.ui-input-group{
  margin: 1em
}
.title_page{
  padding: 0.5em 1em;
  height: 42em;
  background-color: #ececec;
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
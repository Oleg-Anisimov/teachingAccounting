<template>
  <div class="title_page">
    <h1>Титульная страница</h1>
    <form style="max-width: 400px;">
      <div class="ui-input-group">
        <div class="ui-input">
          <label for="input-last-name">Фамилия</label>
          <input id="input-last-name" type="text" :value="lastName" placeholder="Иванов" />
        </div>
        <div class="ui-input">
          <label for="input-first-name">Имя</label>
          <input id="input-first-name" type="text" :value="firstName" placeholder="Иван" />
        </div>
        <div class="ui-input">
          <label for="input-middle-name">Отчество</label>
          <input id="input-middle-name" type="text" :value="middleName" placeholder="Иванович" />
        </div>
      </div>
    </form>
  </div>
</template>

<script>
export default {
  name: "TitlePage",
  props: [
      'firstName', 'lastName', 'middleName'
  ]
}
</script>

<style lang="stylus" scoped>
.ui-input-group
  margin 1.5em
.title_page
  height 700px
  background-color darkgray
</style>
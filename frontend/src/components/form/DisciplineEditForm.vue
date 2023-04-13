<template>
  <p>Номер дисциплины</p>
  <input type="text" v-model="disciplineNumber">
  <p>Название дисциплины</p>
  <input type="text" v-model="disciplineName">
  <button v-on:click="$parent.$emit('addItem', {disciplineNumber: disciplineNumber, disciplineName: disciplineName})">Добавить</button>
</template>

<script>
export default {
  name: "DisciplineEditForm",
  data() {
    return {
      disciplineNumber: '',
      disciplineName: ''
    }
  }
}
</script>

<style scoped>

</style>
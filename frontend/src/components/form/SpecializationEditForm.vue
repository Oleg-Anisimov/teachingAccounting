<template>
  <p>Номер специальности</p>
  <input type="text" v-model="specialization">
  <p>Название специальности</p>
  <input type="text" v-model="specializationName">
  <button v-on:click="$parent.$emit('addItem', {specialization: specialization, specializationName: specializationName})">Добавить</button>
</template>

<script>
export default {
  name: "SpecializationEditForm",
  data() {
    return {
      specialization: '',
      specializationName: ''
    }
  }
}
</script>

<style scoped>

</style>
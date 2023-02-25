<template>
  <p>Номер группы</p>
  <input type="text" v-model="groupName">

  <button v-on:click="$parent.$emit('addItem', groupName)">Добавить</button>
</template>

<script>
export default {
  name: "GroupEditForm",
  data() {
    return {
      groupName: ''
    }
  }
}
</script>

<style scoped>

</style>
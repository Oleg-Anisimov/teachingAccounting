<template>
  <table>
    <tr>
      <td v-for="header in headers"> {{ header }}</td>
    </tr>
    <tr v-for="item in values" :key="item.id">
      <td v-for="cell in item" :key="cell.toString()"> {{ cell }}</td>
    </tr>
  </table>
</template>

<script>
import {defineComponent} from "vue";

export default defineComponent({
  name: "Table",
  props: {
    headers: {
      type: Object,
      required: true
    },
    values: {
      type: Array,
      required: true
    }
  },
})
</script>

<style scoped>

table td{
  border: 0.2em solid royalblue;
  text-align: center;
  justify-content: center;
  vertical-align: middle;
  padding: 0.5em;
}
table th{
  border: 0.2em solid royalblue;
  text-align: center;
  justify-content: center;
  vertical-align: middle;
}
</style>
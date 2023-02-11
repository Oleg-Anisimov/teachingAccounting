<template>
  <table>
    <tr>
      <td v-for="column in columns"> {{column}}</td>
    </tr>
    <tr v-for="row in rows">
      <td v-for="cell in row"> {{cell}} </td>
    </tr>
  </table>
</template>

<script>
import {defineComponent} from "vue";

export default defineComponent({
  name: "Table",
  props: {
    columns: Array,
    rows: Array
  }
})
</script>

<style scoped>
table{
  grid-area: table;
  max-height: 50px;
  max-width: 94em;
  border: 0.2em solid royalblue;
  background-color: #f1f1f1;
}
table td{
  border: 0.2em solid royalblue;
  text-align: center;
  justify-content: center;
  vertical-align: middle;
}
table th{
  border: 0.2em solid royalblue;
  text-align: center;
  justify-content: center;
  vertical-align: middle;
}
</style>
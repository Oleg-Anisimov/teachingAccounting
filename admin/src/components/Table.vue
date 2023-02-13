<template>
  <table>
    <thead>
      <tr>
        <td v-for="column in columns"> {{column}}</td>
      </tr>
    </thead>
    <tbody>
      <tr v-for="row in rows" v-on:click="this.$emit('onUserSelected', row[0])">
        <td v-for="cell in row"> {{cell}} </td>
      </tr>
    </tbody>

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
table {
  border-collapse: collapse;
}

thead {
  background-color: #123E89;
  color: #fff;
  font-weight: 600;
}

tbody > tr:nth-child(even) {
  background-color: #fff;
}

tbody > tr:nth-child(odd) {
  background-color: #e1e1e1;
}

td {
  padding: 11px;
}
</style>
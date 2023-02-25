<template>
  <table>
    <tr>
      <td v-for="header in headers"> {{header}}</td>
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
  props: ['layout', 'values'],
  data() {
    let headers = this.layout.columns.map(item => item.header)
    console.log(this.values)
    let rows = this.values.map((object) => {
      let row = []
      this.layout.columns.forEach(colunm => {
        row.push(object[colunm.valueRef])
      })
      return row
    })
    return {
      headers: headers,
      rows: rows
    }
  }
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
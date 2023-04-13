<template>
  <table>
    <tr>
      <td v-for="header in getHeaders(values[0])"> {{ $t('catalog.' + header) || header}}</td>
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
    values: {
      type: Array,
      required: true
    }
  },
  methods: {
    getHeaders(obj) {
      let arr = [];
      for (var key in obj) {
        if (obj.hasOwnProperty(key)) {
          arr.push(key)
        }
      }
      return arr;
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
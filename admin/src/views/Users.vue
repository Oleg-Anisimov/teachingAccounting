<template>
  <h3>Список преподавателей</h3>
  <Table :columns="columns" :rows="rows" @onUserSelected="onUserSelected"/>
</template>

<script lang="ts">
import {defineComponent} from "vue";
import User from "../model/User";
import Table from "../components/Table.vue";

export default defineComponent({
  name: "Users",
  components: {Table},
  props: {
    users: Array<User>
  },
  data() {

    let rowsData = this.users?.map((user) => {
      return [user.id, user.lastName, user.firstName, user.password]
    })

    return {
      columns: ['Id', 'Фамилия', 'Имя', 'Пароль'],
      rows: rowsData
    }
  },
  methods: {
    onUserSelected(id: any) {
      console.log(id)
      this.$router.push("user/" + id)
    }
  }
})
</script>

<style scoped>

</style>
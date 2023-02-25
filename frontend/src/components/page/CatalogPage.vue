<template>
  <div class="catalog_page">
    <CatalogForm grid-area="filling-form" @addItem="onAddItem">
      <GroupEditForm/>
    </CatalogForm>
    <base-table :head="tableHeads" :column-template="columnsTemplate" :items="groupList()">

    </base-table>
  </div>
</template>

<script>
import CatalogForm from "./fillingForms/CatalogForm.vue";
import BaseTable from "../table-view/Table.vue";
import GroupEditForm from "../form/GroupEditForm.vue";
import DisciplineEditForm from "../form/DisciplineEditForm.vue";
import * as layout from '../table-view/layout.json'
import {mapActions, mapGetters} from "vuex";
import TableRow from "../table-view/TableRow.vue";
import {ref} from "vue";
import TableColumn from "../table-view/TableColumn.vue";

export default {
  name: "CatalogPage",
  components: {TableColumn, TableRow, DisciplineEditForm, BaseTable, CatalogForm, GroupEditForm},
  data() {
    return {
      tableHeads: ['id', 'groupName'],
      columnsTemplate: '50px 1fr',
    }
  },
  methods: {
    ...mapActions(['CREATE_GROUP']),
    ...mapGetters({
      groupList: 'GET_ALL_GROUPS'
    }),

    onAddItem(value) {
      this.CREATE_GROUP(value)
    }
  }
}
</script>

<style scoped>
.catalog_page{
  display: grid;
  padding: 1em;
  grid-template-columns: 270px 1fr;
  grid-gap: 1em;
}
BaseTable {
  justify-self: start;
}
</style>
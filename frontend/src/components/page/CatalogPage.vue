<template>
  <div class="catalog_page">
    <CatalogForm grid-area="filling-form" @addItem="onAddItem">
      <GroupEditForm/>
    </CatalogForm>
    <Table :values="groupList()" :layout="layout"/>
    {{groupList()}}
  </div>
</template>

<script>
import CatalogForm from "./fillingForms/CatalogForm.vue";
import Table from "../table-view/Table.vue";
import GroupEditForm from "../form/GroupEditForm.vue";
import DisciplineEditForm from "../form/DisciplineEditForm.vue";
import * as layout from '../table-view/layout.json'
import {mapActions, mapGetters} from "vuex";

export default {
  name: "CatalogPage",
  components: {DisciplineEditForm, Table, CatalogForm, GroupEditForm},
  data() {
    return {
      layout: layout,
      values: [
        {id: 1, groupName: 'ПКС-206'},
        {id: 2, groupName: 'ИС-31(д)'},
        {id: 2, groupName: 'ИС-31(д)'},
        {id: 2, groupName: 'ИС-31(д)'},
        {id: 2, groupName: 'ИС-31(д)'},
        {id: 2, groupName: 'ИС-31(д)'},
        {id: 2, groupName: 'ИС-31(д)'},
        {id: 2, groupName: 'ИС-31(д)'},
        {id: 2, groupName: 'ИС-31(д)'},
        {id: 2, groupName: 'ИС-31(д)'},
        {id: 2, groupName: 'ИС-31(д)'},
        {id: 2, groupName: 'ИС-31(д)'},
        {id: 2, groupName: 'ИС-31(д)'},
        {id: 2, groupName: 'ИС-31(д)'},
        {id: 2, groupName: 'ИС-31(д)'},
        {id: 2, groupName: 'ИС-31(д)'},
        {id: 2, groupName: 'ИС-31(д)'},
        {id: 2, groupName: 'ИС-31(д)'},
        {id: 2, groupName: 'ИС-31(д)'}
      ]
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
Table {
  justify-self: start;
}
</style>
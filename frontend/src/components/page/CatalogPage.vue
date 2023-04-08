<template>
  <div class="catalog_page">
    <CatalogForm grid-area="filling-form" @addItem="onAddItem" @catalogSelected="selected">
      <GroupEditForm v-if="selectedItem === 'group'"/>
<!--      <GroupEditForm v-if:="selectedItem === 'group'"/>-->
<!--      <GroupEditForm v-if:="selectedItem === 'group'"/>-->
    </CatalogForm>
    <Table :values="this[selectedItem + 'List']()" :headers="headers"/>
  </div>
</template>

<script>
import CatalogForm from "./fillingForms/CatalogForm.vue";
import Table from "../table-view/Table.vue";
import GroupEditForm from "../form/GroupEditForm.vue";
import DisciplineEditForm from "../form/DisciplineEditForm.vue";
import {mapActions, mapGetters} from "vuex";

export default {
  name: "CatalogPage",
  components: {DisciplineEditForm, Table, CatalogForm, GroupEditForm},
  data() {
    return {
      headers: ['id', 'Название группы'],
      selectedItem: 'group'
    }
  },
  methods: {
    ...mapActions(['CREATE_GROUP']),
    ...mapGetters({
      groupList: 'GET_ALL_GROUPS',
      specializationList: 'GET_ALL_SPECIALIZATIONS',
      disciplineList: 'GET_ALL_ACADEMIC_DISCIPLINES'
    }),

    selected(e) {
      this.selectedItem = e.target.value;
    },

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
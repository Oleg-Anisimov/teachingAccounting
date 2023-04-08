<template>
  <div class="catalog_page">
    <catalog-form grid-area="filling-form" @addItem="onAddItem" @catalogSelected="selected">
      <group-edit-form v-if="selectedItem === 'group'"/>
      <discipline-edit-form v-if:="selectedItem === 'discipline'"/>
      <specialization-edit-form v-if:="selectedItem === 'specialization'"/>
    </catalog-form>
    <Table :values="this[selectedItem + 'List']()" :headers="headers"/>
  </div>
</template>

<script>
import CatalogForm from "./fillingForms/CatalogForm.vue";
import Table from "../table-view/Table.vue";
import GroupEditForm from "../form/GroupEditForm.vue";
import DisciplineEditForm from "../form/DisciplineEditForm.vue";
import {mapActions, mapGetters} from "vuex";
import SpecializationEditForm from "../form/SpecializationEditForm.vue";

export default {
  name: "CatalogPage",
  components: {SpecializationEditForm, DisciplineEditForm, Table, CatalogForm, GroupEditForm},
  data() {
    return {
      headers: ['id', 'Название группы'],
      selectedItem: 'group'
    }
  },
  methods: {
    ...mapActions({
      groupAdd:'CREATE_GROUP',
      specializationAdd:'CREATE_SPECIALIZATION',
      disciplineAdd:'CREATE_DISCIPLINE'
    }),
    ...mapGetters({
      groupList: 'GET_ALL_GROUPS',
      specializationList: 'GET_ALL_SPECIALIZATIONS',
      disciplineList: 'GET_ALL_ACADEMIC_DISCIPLINES'
    }),

    selected(e) {
      this.selectedItem = e.target.value;
    },

    onAddItem(value) {
      let funcName = this.selectedItem + 'Add';
      console.log(funcName)
      this[this.selectedItem + 'Add'](value)
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
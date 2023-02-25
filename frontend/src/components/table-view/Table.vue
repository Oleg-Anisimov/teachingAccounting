<template>
  <div class="table-wrapper">
    <div class="table">
      <div class="table-head" :style="{'grid-template-columns': columnTemplate}">
        <div
            class="table-head__name"
            v-for="(element, i) of head"
            :key="i"
        >
          {{element}}
        </div>
      </div>
      <table-row
          :key="item.id"
          v-for="item in items"
          :column-template="columnTemplate"
          :item="item"
      />
    </div>
  </div>
</template>

<script>
import {defineComponent} from "vue";
import TableRow from "./TableRow.vue";

export default defineComponent({
  name: "BaseTable",
  components: {TableRow},
  props: {
    head: {
      type: Array,
      required: false
    },
    columnTemplate: {
      type: String,
      required: false
    },
    items: {
      type: Array,
      required: true
    }
  }
})
</script>

<style lang="scss" scoped>
.table {
  background-color: #fff;
  width: 100%;
  margin-bottom: 40px;
  margin-top: 15px;
  &-wrapper {
    display: flex;
    justify-content: center;
  }
  &-head {
    padding: 5px 16px;
    display: grid;
    column-gap: 10px;
    align-items: center;
    border-bottom: 2px solid #EEEFF4;
    background: #fff;
    &__name {
      display: flex;
      justify-content: flex-start;
      align-items: center;
      color: #999;
      cursor: pointer;
    }
    @media screen and (max-width: 767px) {
      display: none;
    }
  }
}
</style>
<template>
  <div
      class="table-row"
      :style="{'grid-template-columns':columnTemplate}"
  >
    <table-column>{{item.id}}</table-column>
    <table-column>{{item.groupName}}</table-column>
  </div>
</template>

<script>
export default {
  name: "TableRow",
  props: {
    columnTemplate: {
      type: String,
      required: false
    },
    item: {
      type: Object,
      required: true
    }
  }
}
</script>

<style lang="scss" scoped>
.table-row {
  border-bottom: 2px solid #EEEFF4;
  position: relative;
  display: grid;
  column-gap: 10px;
  align-items: center;
  padding: 0 16px;
  @media screen and (max-width: 767px) {
    display: block;
  }
  &:last-child {
    border-bottom: none;
  }
  &--items-center {
    justify-items: center;
  }
}
</style>
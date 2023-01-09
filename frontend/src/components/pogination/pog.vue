<template>
    <tr>
        <td colspan="100" class="last-td">
          <div class="bottomTableNavigation">
            <div>
              <p>
                (Всего: {{ totalElements }}) На страницу:
                <input type="number" min="0" :max="totalElements" v-model="pageRequest.size"/>.
              </p>
            </div>
            <div>
              <button :disabled="pageRequest.page === 0" v-on:click="pageRequest.page -= 1">
                ❮ Назад
              </button>
              {{ pageRequest.page + 1 }}
              <button :disabled="pageRequest.page === totalPages - 1" v-on:click="pageRequest.page += 1">
                Вперед ❯
              </button>
            </div>
            <div class="rightColumn">Страниц: {{ totalPages }}</div>
          </div>
        </td>
      </tr>
</template>
<script>
export default {
  name: "pog",
  props: ["totalElements","totalPages","pageRequest"],
  watch: {
    "pageRequest.page"() {
      this.$emit('pageRequestUpdated')
    },
    "pageRequest.size"() {
      this.$emit('pageRequestUpdated')
    },
  },
}
</script>
<style>
.bottomTableNavigation {
  display: grid;
  grid-template-columns: 1fr 1fr 1fr;
}
.rightColumn {
  text-align: right;
}
</style>
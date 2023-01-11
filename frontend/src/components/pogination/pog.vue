<template>
    <tr>
        <td colspan="100" class="last-td">
          <div class="bottomTableNavigation">
            <div>
              <p>
                (Всего: {{ totalElements }}) На страницу:
                <input type="number" min="0" :max="totalElements" v-model="pageRequest.size"/>
              </p>
            </div>
            <div>
              <button :class="pageRequest.page === 0 ? '' :'back'" :disabled="pageRequest.page === 0" v-on:click="pageRequest.page -= 1">
                <span>Назад</span>
              </button>
              {{ pageRequest.page + 1 }}
              <button :class="pageRequest.page === totalPages - 1 ? '' : 'next'" :disabled="pageRequest.page === totalPages - 1" v-on:click="pageRequest.page += 1">
                <span>Вперед</span>
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

.next span {
  display: inline-block;
  position: relative;
  transition: 0.5s;
}

.next span:after {
  content: '\00bb';
  position: absolute;
  opacity: 0;
  top: 0;
  right: -0.8em;
  transition: 0.5s;

}

.next:hover span {
  padding-left: 0em;
}

.next:hover span:after {
  opacity: 1;
  right: -1em;
}
.back span {
  display: inline-block;
  position: relative;
  transition: 0.5s;
}

.back span:after{
  content: '\00AB';
  position: absolute;
  opacity: 0;
  top: 0;
  left: -0.8em;
  transition: 0.5s;
}

.back:hover span {
  padding-right: 0em;
}

.back:hover span:after {
  opacity: 1;
  left: -1em;
}
/*.qwe {
  display: grid;
  grid-template-columns: 1fr 1fr 1fr;
}*/
</style>
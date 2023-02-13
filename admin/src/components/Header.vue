<template>
  <header>
    <div class="company_logo">
      <img src="logo.svg" alt="">
      <h2>ГБПОУ ОК «Юго-Запад»</h2>

    </div>
    <div class="userbar">
      Кринжов Ж.А.
      <img  src="avatar_mock.jpg" alt="">
    </div>
  </header>

</template>

<script lang="ts">
import {defineComponent} from "vue";

export default defineComponent({
  name: 'Header'
})
</script>

<style scoped>
header {
  display: grid;

  grid-template-columns: 1fr 1fr;
  align-content: center;
}

h2 {
  display: inline-block;
  margin: 0;
}
img {
  display: inline-block;
  width: 50px;
  border-radius: 10px;
}

.userbar {
  justify-self: end;
  align-items: center;
}

</style>
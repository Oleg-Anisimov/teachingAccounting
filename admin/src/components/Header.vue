<template>
  <header>
    <div class="company_logo">
      <img src="logo.svg" alt="">
      <h2>ГБПОУ ОК «Юго-Запад»</h2>

    </div>
    <div class="userbar">
      <p>Кринжов Ж.А.</p>
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
  padding: 1em;
  display: grid;

  grid-template-columns: 1fr 1fr;
  align-content: center;
}

h2 {
  display: inline-block;
}

p {
  display: inline-block;
}
img {
  display: inline-block;
  width: 60px;
  height: 60px;
  border-radius: 10px;
}

.userbar {
  justify-self: end;
  vertical-align: middle;
}

</style>
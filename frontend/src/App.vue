<script setup>
import Header from "./components/Header.vue";
import Navbar from "./components/Navbar.vue";
import Auth from "./components/Auth.vue";
import './assets/style/fillingForm.vue';
import './assets/style/tableStyle.vue';
document.title = 'ГБПОУ ОК "ЮГО-ЗАПАД"'
</script>

<template>
  <div class="wrapper">
    <Auth></Auth>
    <Header></Header>
    <Navbar></Navbar>
    <RouterView/>
  </div>
</template>

<style scoped lang="stylus">

</style>

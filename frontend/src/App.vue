<script setup>
import Header from "./components/Header.vue";
import Navbar from "./components/Navbar.vue";
import './assets/style/fillingForm.vue';
import './assets/style/tableStyle.vue';
</script>

<template>
  <div class="wrapper">
    <Header></Header>
    <Navbar></Navbar>
    <RouterView/>
  </div>
</template>

<style scoped lang="stylus">

</style>

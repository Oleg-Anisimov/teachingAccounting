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
    <Auth username="{{username}}"></Auth>
    <Header></Header>
    <Navbar></Navbar>
    <RouterView/>
  </div>
</template>

<script>

import { mapGetters } from 'vuex';


export default {
  name:"App",
  computed: {
    username: GET_CURRENT_USER()
  },
  methods: {
    ...mapGetters(['GET_CURRENT_USER']),
  }
  }
</script>

<style scoped lang="stylus">

</style>

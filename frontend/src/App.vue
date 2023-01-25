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
    <Auth :user="getUser"></Auth>
    <Header></Header>
    <Navbar></Navbar>
    <RouterView/>
  </div>
</template>

<script>

import {mapActions, mapGetters, mapMutations} from 'vuex';

export default {
  name:"App",
  computed: {
    ...mapGetters({
      getCurrentUser: 'user/GET_CURRENT_USER'
    }),
    getUser() {
      return this.getCurrentUser
    }
  },
  
  methods: {
    ...mapActions({
      LOAD_SPECIALIZATION: 'LOAD_SPECIALIZATION',
      LOAD_ACADEMIC_DISCIPLINE: 'LOAD_ACADEMIC_DISCIPLINE',
      LOAD_GROUPS: 'LOAD_GROUPS',
    }),
  },
  created(){
      this.LOAD_GROUPS();
      this.LOAD_SPECIALIZATION();
      this.LOAD_ACADEMIC_DISCIPLINE();
    }
}
</script>

<style scoped lang="stylus">

</style>

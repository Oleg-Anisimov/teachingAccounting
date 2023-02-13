<script setup lang="ts">

import Sidebar from "./components/Sidebar.vue";
import Header from "./components/Header.vue";</script>

<template>
  <div class="wrapper">
    <Sidebar/>
    <div class="main">
      <Header/>
      <div class="content">
        <router-view>

        </router-view>
      </div>
    </div>
  </div>

</template>

<style scoped>

.wrapper {
  height: 100vh;
  display: grid;

  grid-template-columns: 85px 1fr;
}

body {
  background-color: #ececec;
}

.main {
  padding: 1.5em;
}





</style>

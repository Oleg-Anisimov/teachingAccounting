<template>
  <div class="sidebar_item">
    <img :src="icon" alt="icon">
    <p>{{text}}</p>
  </div>
</template>

<script lang="ts">
import {defineComponent} from "vue";

export default defineComponent({
  name: "SidebarItem",
  props: {
    icon: String,
    text: String
  }
})
</script>

<style scoped>
.sidebar_item {
  margin-top: 1em;
  text-align: center;
}
img {
  color: #242424;

}
p {
  margin: 0;
  font-size: 0.7em;
}
</style>
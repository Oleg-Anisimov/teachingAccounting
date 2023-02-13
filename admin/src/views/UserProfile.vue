<template>
  <h1>User page</h1>
  <p>selected user with id {{id}}</p>
</template>

<script lang="ts">
import {defineComponent} from "vue";

export default defineComponent({
  name: "UserProfile",
  props: {
    id: String
  }
})
</script>

<style scoped>

</style>
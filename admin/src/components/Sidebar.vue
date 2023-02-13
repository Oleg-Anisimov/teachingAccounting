<template>
  <aside>
    <div>
      <SidebarItem icon="icon_users.svg" text="Пользователи"/>
      <SidebarItem icon="icon_payments.svg" text="Платежи"/>
      <SidebarItem icon="icon_calendar.svg" text="Календарь"/>
    </div>
  </aside>

</template>

<script lang="ts">
import {defineComponent} from "vue";
import SidebarItem from "./SidebarItem.vue";

export default defineComponent({
  name: "Sidebar",
  components: {SidebarItem}
})
</script>

<style scoped>

aside {
  padding: 0.5em;
  background-color: #f3f3f3;
  box-shadow: 0px 0 5px 1px  black;
}
</style>
<template>
  <aside>
    <div>
      <SidebarItem icon="icon_users.svg" text="Пользователи"/>
      <SidebarItem icon="icon_deals.svg" text="Учебная работа"/>
      <SidebarItem icon="icon_tasks.svg" text="Организационно-методическая работа"/>
      <SidebarItem icon="icon_payments.svg" text="Платежи"/>
      <SidebarItem icon="icon_calendar.svg" text="Календарь"/>
    </div>
    <div>
      <SidebarItem icon="icon_settings.svg" text="Настройки"/>

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
</style>
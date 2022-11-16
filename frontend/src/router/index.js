import { createRouter, createWebHistory } from 'vue-router'
import TitlePage from "../components/page/TitlePage.vue";
import HomePage from "../components/page/HomePage.vue";
import store from "../vuex/store";
import Teacher from "../model/teacher";

const router = createRouter({
  history: createWebHistory(import.meta.env.BASE_URL),
  routes: [
    {
      path: '/',
      alias: '/manual',
      name: 'home',
      component: HomePage

    },
    {
      path: '/title',
      name: 'title',
      component: TitlePage,
      props: {
        teacher: store.getters.GET_TEACHER
      }
    },
  ]
})

export default router

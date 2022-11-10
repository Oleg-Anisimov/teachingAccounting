import { createRouter, createWebHistory } from 'vue-router'
import TitlePage from "../components/page/TitlePage.vue";
import HomePage from "../components/page/HomePage.vue";

const router = createRouter({
  history: createWebHistory(import.meta.env.BASE_URL),
  routes: [
    {
      path: '/',
      name: 'home',
      component: HomePage

    },
    {
      path: '/title',
      name: 'title',
      component: TitlePage,
      props: {
        lastName: 'Маняхина',
        firstName: 'Рамзия',
        middleName: 'Накиповна'
      }
    }
  ]
})

export default router

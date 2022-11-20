import { createRouter, createWebHistory } from 'vue-router'
import TitlePage from "../components/page/TitlePage.vue";
import HomePage from "../components/page/HomePage.vue";
import AcademicWorkPage from "../components/page/AcademicWorkPage.vue";
import AcademMethodPage from "../components/page/AcademMethodPage.vue";
import OrganizMethodPage from "../components/page/OrganizMethodPage.vue";
import ScienMethodPage from "../components/page/ScienMethodPage.vue";
import AcademicProductWorkPage from "../components/page/AcademicProductWorkPage.vue";
import EducateWorkPage from "../components/page/EducateWorkPage.vue";
import PromotionQualificLVLPage from "../components/page/PromotionQualificLVLPage.vue";
import AuthorizationPage from "../components/page/AuthorizationPage.vue";
import RegistrationPage from "../components/page/RegistrationPage.vue";
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
    {
      path: '/academic-work',
      name: 'academic-work',
      component: AcademicWorkPage,
    },
    {
      path: '/academ-method',
      name: 'academ-method',
      component: AcademMethodPage,
    },
    {
      path: '/organiz-method',
      name: 'organiz-method',
      component: OrganizMethodPage,
    },
    {
      path: '/scien-method',
      name: 'scien-method',
      component: ScienMethodPage,
    },
    {
      path: '/academic-product-work',
      name: 'academic-product-work',
      component: AcademicProductWorkPage,
    },
    {
      path: '/educate-work',
      name: 'educate-work',
      component: EducateWorkPage,
    },
    {
      path: '/promotion-qualific-lvl',
      name: 'promotion-qualific-lvl',
      component: PromotionQualificLVLPage,
    },
    {
      path: '/authorization',
      name: 'authorization',
      component: AuthorizationPage,
    },
    {
      path: '/registration',
      name: 'registration',
      component: RegistrationPage,
    },
  ]
})

export default router

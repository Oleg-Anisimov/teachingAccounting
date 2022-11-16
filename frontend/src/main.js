import App from './App.vue'
import router from './router'

import './assets/main.css'
import store from "./vuex/store";
import i18n from "./i18n";
import {createApp} from "vue";

createApp(App)
    .use(i18n)
    .use(router)
    .use(store)
    .mount('#app')

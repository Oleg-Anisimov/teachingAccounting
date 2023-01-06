import App from './App.vue'
import router from './router'

import './assets/main.css'
import rootStore from "./vuex/rootStore";
import i18n from "./i18n";
import {createApp} from "vue";

createApp(App)
    .use(i18n)
    .use(router)
    .use(rootStore)
    .mount('#app')

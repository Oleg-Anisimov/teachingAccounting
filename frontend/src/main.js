import App from './App.vue'
import router from './router'

import './assets/main.css'
import store from "./vuex/store";
import {createApp} from "vue";

createApp(App)
    .use(router)
    .use(store)
    .mount('#app')

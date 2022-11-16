import { createI18n } from 'vue-i18n'

const i18n = createI18n({
    locale: 'ru',
    messages:{
        ru: {
            enum: {
                categories: {
                    WITHOUT_CATEGORY:"Без категории",
                    FIRST_CATEGORY:"Первая",
                    HIGHEST_CATEGORY:"Высшая"
                }
            }
        }
    }

});

export default i18n;
<script setup>
import AcaProdWork from "./fillingForms/AcaProdWork.vue";
</script>
<template>
    <div class="academic_work_page">
        <AcaProdWork grid-area="filling-form"></AcaProdWork>
        <table>
            <tr>
                <th colspan="140"><img src="">Учебная-производственная работа - Заполнение индивидуального плана</th>
            </tr>
            <tr>
                    <td class="left-helf simvol">№</td>
                    <td class="left-helf">Специальность</td>
                    <td class="left-helf">Тип кабинета</td>
                    <td class="left-helf">Наименование кабинета</td>
                    <td class="left-helf">Вид деятельности</td>
                    <td class="left-helf">Вид УПД</td>
                    <td class="left-helf">Дата</td>
                    <td class="left-helf">Результат</td>
            </tr>
              <tr v-for="product in GET_ACADEMIC_PRODUCTION()" :key="product.id">
                <td>{{ product.id }}</td>
                <td>{{ product.specialization.specialization }}</td>
                <td></td>
                <td></td>
                <td>{{$t('enum.ActivityType.' + product.activityType)}}</td>
                <td></td>
                <td></td>
                <td></td>
              </tr>
              <pog :totalPages="totalPages" :totalElements="totalElements" :pageRequest="pageRequest"></pog>
        </table>
    </div>
</template>
<script>
import { mapActions, mapGetters } from 'vuex';
import pog from "../pogination/pog.vue";

export default{
    components: { pog },
    name: "AcademicProductWorkPage",
    props: [
        'enums'
    ],
    methods: {
    ...mapActions({
        LOAD_ACADEMIC_PRODUCTIONS: 'academicProduct/LOAD_ACADEMIC_PRODUCTIONS',
    }),
    ...mapGetters({
        GET_ACADEMIC_PRODUCTION: 'academicProduct/GET_ACADEMIC_PRODUCTION'
    }),
    },
    watch: {
        "pageRequest.page"() {
        let resultPromise = this.LOAD_ACADEMIC_PRODUCTIONS(this.pageRequest);
        resultPromise.then((data) => {
            this.totalPages = data.totalPages;
            this.pageNumber = data.pageable.pageNumber + 1;
        });
        },
        "pageRequest.size"() {
        let resultPromise = this.LOAD_ACADEMIC_PRODUCTIONS(this.pageRequest);
        resultPromise.then((data) => {
            this.totalPages = data.totalPages;
            this.pageNumber = data.pageable.pageNumber + 1;
        });
        },
    },
    data() {
        return {
        pageRequest: {
            page: 0,
            size: 10,
        },
        totalElements: 0,
        totalPages: 0,
        offset: 0,
        pageNumber: 0,
        };
    },
    mounted(){
        document.title = 'Учебно-производственная работа';
        let resultPromise = this.LOAD_ACADEMIC_PRODUCTIONS(this.pageRequest);
        resultPromise.then((data) => {
        this.totalElements = data.totalElements;
        this.totalPages = data.totalPages;
        this.pageNumber = data.pageable.pageNumber + 1;
    });

  },
}
</script>
<style scoped>
    .academic_work_page{
        grid-template-areas: "filling-form table table";
    }
    table{
        max-width: 60em;
    }
</style>

 
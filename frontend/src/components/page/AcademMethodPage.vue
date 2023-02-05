<script setup>
import AcaMethWork from "./fillingForms/AcaMethWork.vue";
</script>
<template>
    <div class="academic_work_page">
        <AcaMethWork grid-area="filling-form"></AcaMethWork>
        <table>
            <tr>
                <th colspan="140"><img src="">Учебно-методическая работа - Заполнение индивидуального плана</th>
            </tr>
            <tr>
                    <td class="left-helf simvol">№</td>
                    <td class="left-helf">Специальность</td>
                    <td class="left-helf">Наименование специальности</td>
                    <td class="left-helf">Уч. дисциплина(ПМ,МДК)</td>
                    <td class="left-helf">Наименование уч.дисциплины(ПМ,МДК)</td>
                    <td class="left-helf">Вид деятельности</td>
                    <td class="left-helf">Вид УМД</td>
                    <td class="left-helf">Тип УМД</td>
                    <td class="left-helf">Срок исполнения</td>
                    <td class="left-helf">Краткий отчёт о выполении</td>
            </tr>
              <tr v-for="method in GET_ACADEMIC_METHOD()" :key="method.id">
                <td>{{method.id}}</td>
                <td>{{ method.specialization.specialization }}</td>
                <td>{{ method.specialization.specializationName }}</td>
                <td>{{ method.academicDiscipline.disciplineNumber }}</td>
<!--                Название уч дисциплины-->
                <td>{{ method.academicDiscipline.name }}</td>
                <td>{{ $t('enum.ActivityType.' + method.activityType) }}</td>
                <td>{{ method.academicMethodActivityForm }}</td>
                <td>{{ method.academicMethodActivityType }}</td>
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
  name: "AcademMethodPage",
  props: ['enums'],
  watch: {
    "pageRequest.page"() {
      let resultPromise = this.LOAD_ACADEMIC_METHODS(this.pageRequest);
      resultPromise.then((data) => {
        this.totalPages = data.totalPages;
        this.pageNumber = data.pageable.pageNumber + 1;
      });
    },
    "pageRequest.size"() {
      let resultPromise = this.LOAD_ACADEMIC_METHODS(this.pageRequest);
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
  methods: {
    ...mapActions({
      LOAD_ACADEMIC_METHODS: 'academicMethod/LOAD_ACADEMIC_METHODS',
    }),
    ...mapGetters({
      GET_ACADEMIC_METHOD: 'academicMethod/GET_ACADEMIC_METHOD',
    }),
  },
  mounted(){
    document.title = 'Учебно-методическая работа';
    let resultPromise = this.LOAD_ACADEMIC_METHODS(this.pageRequest);
    resultPromise.then((data) => {
      this.totalElements = data.totalElements;
      this.totalPages = data.totalPages;
      this.pageNumber = data.pageable.pageNumber + 1;
    });
  },
}
</script>

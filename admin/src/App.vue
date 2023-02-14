<script setup lang="ts">

import Sidebar from "./components/Sidebar.vue";
import Header from "./components/Header.vue";
import Table from "./components/Table.vue";

const data = [
    [1, 'Анисимов', 'Олег', 'Борисович', 'o.anisimov@gmail.com', '24521$slm21smsgdfsld'],
    [2, 'Анисимов', 'Олег', 'Борисович', 'o.anisimov@gmail.com', '24521$slm21smsgdfsld']

];
</script>

<template>
  <div class="wrapper">
    <Sidebar/>
    <div class="main">
      <Header/>
      <div class="content">
        <h3>Список преподавателей</h3>
        <table>
          <thead>
            <tr>
              <td>№</td>
              <td>Фото</td>
              <td>Фамилия</td>
              <td>Имя</td>
              <td>Отчество</td>
              <td>Тип сотрудника</td>
              <td>Отделение</td>
              <td>Должность</td>
              <td>Категория</td>
              <td>Дата аттестации</td>
            </tr>
          </thead>
          <tbody>
            <tr>
              <td>1</td>
              <td>Тест</td>
              <td>Тест</td>
              <td>Тест</td>
              <td>Тест</td>
              <td>2022-02-25</td>
              <td>Тест</td>
              <td>Тест</td>
            </tr>
            <tr>
              <td>2</td>
              <td>Тест</td>
              <td>Тест</td>
              <td>Тест</td>
              <td>Тест</td>
              <td>2022-02-25</td>
              <td>Тест</td>
              <td>Тест</td>
            </tr>
            <tr>
              <td>3</td>
              <td>Тест</td>
              <td>Тест</td>
              <td>Тест</td>
              <td>Тест</td>
              <td>2022-02-25</td>
              <td>Тест</td>
              <td>Тест</td>
            </tr>
            <tr>
              <td>4</td>
              <td>Тест</td>
              <td>Тест</td>
              <td>Тест</td>
              <td>Тест</td>
              <td>2022-02-25</td>
              <td>Тест</td>
              <td>Тест</td>
            </tr>
          </tbody>
        </table>
      </div>
    </div>
  </div>

</template>

<style scoped>

.wrapper {
  height: 100vh;
  display: grid;

  grid-template-columns: 80px 1fr;
}

.main {
  background-color: #ececec;
}

Sidebar {
  align-self: center;
  align-content: center;
  align-items: center;
}

table {
  border-collapse: collapse;
}

thead {
  background-color: #123E89;
  color: #fff;
  font-weight: 600;
}

tbody > tr:nth-child(even) {
 background-color: #fff;
}

tbody > tr:nth-child(odd) {
  background-color: #e1e1e1;
}

td {
  padding: 11px;
}



</style>

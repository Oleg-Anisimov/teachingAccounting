<template>
  <div class="home_page">

    <article>
      <p class="top">Организационно-методические материалы</p>
      <div class="nav">
        <p><a href="#">Расписание звонков</a></p>
        <p><a href="#">Памятка по работе с индивидуальным планом</a></p>
        <p><a href="#">Планирование_2020</a></p>
        <p><a href="#">График аттестации ПР 2021 год</a></p>
        <p><a href="#">О журнале учебной группы</a></p>
        <p><a href="#">Об организации образовательного процесса (вуз)</a></p>
        <p><a href="#">О составе отделений</a></p>
        <p><a href="#">Перечень ПК(ПЦК)</a></p>
        <p><button @click="button_click"><i>Показать все...</i></button></p>
      </div>
      <div class="nav_none">
        <p><a href=""></a></p>
        <p><a href=""></a></p>
        <p><a href=""></a></p>
        <p><a href=""></a></p>
      </div>  
    </article>
    <main>
      <p>Индивидуальный план работы педагогического работника содержит следующие разделы по видам работ,
        осуществляемым в рамках реализации образовательных программ среднего профессионального образования:</p>
      <ul type="disc">
        <li>титульный лист;</li>
        <li>учебная (преподавательская) работа;</li>
        <li>учебно-методическая работа;</li>
        <li>организационно-методическая работа;</li>
        <li>научно-исследовательская работа;</li>
        <li>учебно-производственная работа;</li>
        <li>воспитательная работа;</li>
        <li>повышение уровня квалификации</li>
      </ul>
    </main>
    
  </div>
</template>

<script>
export default {
  name: "HomePage"
}
</script>

<style scoped>
.home_page{
  height: 747px;
  background-color: #ececec;
  padding: 0.7em;
  display: grid;
  grid-template-areas: "article main main main main main main";
  grid-gap: 1em;
}
main{
  grid-area: main;
}
article{
  text-align: center;
  width: 20em;
  grid-area: article;

}
article a{
  text-decoration: none;
  color: black;
}
.top{
  color: white;
  background-color: royalblue;
  border-radius: 0.7em 0.7em 0 0;
}
.nav p{
  margin: 0.4em 0 0 0;
  border-bottom: solid royalblue;
  padding: 0 0 0.7em;
}
.nav button{
  background-color: #ececec;
}
.nav_none{
  display: none;
}
main ul li{
  list-style-type: disc;
  margin-left: 1.2em;
}
</style>
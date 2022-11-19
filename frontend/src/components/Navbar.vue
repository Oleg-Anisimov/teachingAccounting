<template>
  <div class="header_nav">
    <p><router-link to="/title">Титульный лист</router-link></p>
    <p><router-link to="/academic-work">Учебная работа</router-link></p>
    <p><router-link to="/academ-method">Учебно-методическая работа</router-link></p>
    <p><router-link to="/organiz-method">Организационно-методическая работа</router-link></p>
    <p><router-link to="/scien-method">Научно-методическая работа</router-link></p>
    <p><router-link to="/academic-product-work">Учебно-производственная работа</router-link></p>
    <p><router-link to="/educate-work">Воспитательная работа</router-link></p>
    <p><router-link to="/promotion-qualific-lvl">Повышение уровня квалификации</router-link></p>
  </div>
</template>

<script>
export default {
  name: "Navbar"
}
</script>

<style scoped>
p{
  display: inline-block;
  margin-right: 0.5em;
}  
a:link{
  text-decoration: none;
  color: #f2f2f2;
}
a:visited{
  text-decoration: none;
  color: #f2f2f2;
}
.header_nav{
  padding: 0.2em 0;
  background-color: #282828;
  color: #f2f2f2;
  text-align: center;
}
.header_nav p{
  margin: 0.07em 0.8em;
  font-size: 1.03em;
}
</style>
<template>
  <div class="header_nav">
    <p><router-link to="/title">Титульный лист</router-link></p>
    <p><a href="/#">Учебная работа</a></p>
    <p><a href="/#">Учебно-методическая работа</a></p>
    <p><a href="/#">Организационно-методическая работа</a></p>
    <p><a href="/#">Научно-методическая работа</a></p>
    <p><a href="/#">Учебно-производственная работа</a></p>
    <p><a href="/#">Воспитательная работа</a></p>
    <p><a href="/#">Повышение уровня квалификации</a></p>
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
  height: 70px;
  background-color: #282828;
  color: #f2f2f2;
  text-align: center;
}
.header_nav p{
  margin: 0.07em 0.8em;
  font-size: 1.03em;
}
</style>
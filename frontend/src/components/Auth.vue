<template>
    <div class="authorization">
        <div class="guest">
            <a href="#">Гость</a>
        </div>
        <div class="auth">
            <a href="/authorization"><b>Вход</b></a>
        </div>
        <div class="auth">
            <a href="/registration"><b>Регистрация</b></a>
        </div>
    </div>
  </template>
  
  <script>
  export default {
    name: "Auth"
  }
  </script>
  
  <style scoped>
    .authorization{
        background-color: #5f83ee;
        color: white;
        padding: 10px;
        text-align: right;
    }
    .authorization a{
        color: white;
    }
    .guest{
        padding: 0.4em 0.1em;
        border-radius: 8px;
        display: inline;
    }
    .auth{
        margin: 0.4em;
        padding: 0.4em 0.5em;
        background-color: #343434;
        border-radius: 8px;
        display: inline;
        font: bold;
    }
  </style>
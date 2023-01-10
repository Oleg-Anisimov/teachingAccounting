<template>
    <div class="authorization">
      <div v-if="user">
         <div class="guest">
            <a href="#">{{user.userName}}</a>
        </div>
        <button class="auth" v-on:click="logout"><span>Выход</span></button>
      </div>
      <div v-if="!user">
        <div class="guest">
            <a href="#">Гость</a>
        </div>
          <button class="auth" v-on="logg"><span>Вход</span></button>
          <button class="reg" v-on="logg"><span>Регистрация</span></button>
      </div>
    </div>
  </template>
  
  <script>
  import {mapActions} from "vuex";

  export default {
    name: "Auth",
    props: ["user"],
    methods: {
      ...mapActions({
        sendLogout: 'user/LOGOUT'
      }),
      logout (){
        this.sendLogout()
        this.$router.push('authorization');
      },
      logg (){
        this.$router.push('authorization');
      }
    }
  }
  
  </script>
  
  <style scoped>
    .authorization{
        background-color: #3e65a0;
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
    .auth, .reg{
        margin: 0.2em 0.4em;
        padding: 0.4em 0.5em;
        background-color: #343434;
        border-radius: 8px;
        display: inline-block;
        font: bold;
        height: 2.5em;
        color: #e1e1e1;
        width: 5em;
    }
    .auth span, .reg span {
      display: inline-block;
      position: relative;
      transition: 0.5s;
    }

    .auth span:after, .reg span:after {
      content: '\00bb';
      position: absolute;
      opacity: 0;
      top: 0;
      right: -0.8em;
      transition: 0.5s;
    }

    .auth:hover span, .reg:hover span {
      padding-right: 1em;
    }

    .auth:hover span:after, .reg:hover span:after {
      opacity: 1;
      right: 0;
    }
    .reg {
      width: 8.4em;
    }
  </style>
<template>
    <div class="authPage" >
<!--        <center>-->
        <div class="authBox">
            <div class="auth">
            <label><b>Войти</b></label>
            </div>
            <div class="ui-input-group">
                <div class="ui-input">
                    <label for="input-login">Логин</label>
                    <input id="input-login" type="text" v-model="this.model.username" placeholder="Введите логин"/>
                </div>
                <div class="ui-input">
                    <label for="input-password">Пароль</label>
                    <input id="input-password" type="password" v-model="this.model.password" placeholder="Введите пароль"/>
                </div>
              <p class="alertMessage" v-if="model.invalid">Неверный логин или пароль</p>
                <div class="ui-input">
                    <button class="ui-button isDefault" @click="perfromLogin()">Вход</button>
                    <button class="ui-button isDefault"><router-link to="/registration">Зарегистрироваться</router-link></button>
                </div>
            </div>
        </div>
<!--        </center>-->
    </div>
</template>
<script>
import {mapActions} from "vuex";

export default{
    name: "AuthorizationPage",
    data() {
      return {
        model: {
          username:'',
          password:'',
          invalid: false
        }
      }
    },
    methods: {
      ...mapActions(['LOGIN']),
      perfromLogin() {
        this.LOGIN({
          username: this.model.username,
          password: this.model.password
        }).then((data) => {
          this.$router.push('title');
        }).catch((e) => {
          this.model.invalid = true
        })
      }
    },
    mounted() {
        document.title = 'Авторизация'
    }
}

</script>
<style scoped>
.alertMessage{
  color: red;
}
.authPage{
    background-color: #e1e1e1;
    padding-bottom: 26em;
    padding-top: 1em;
}
.authBox{
    border: 5px solid royalblue;
    border-radius: 10px;
    width: 500px;
    /* margin-top: 2em; */
    margin: 2em auto auto auto;
}
.ui-input-group{
    padding: 0.5em 2em;
    background-color: white;
    border-radius: 0 0 5px 5px;
    padding-top: 1.5em;
}
.authBox .auth label{
    font-size: 1.7em;
    color: white;
}
.authBox .auth{
    background-color: royalblue;
    padding: 0.5em 0em;
    border-radius: px 5px 0 0;
}
.ui-input label{
    font-size: 1.1em;
}
.ui-input{
    display: inline;
    text-align: left;
}
.ui-button{
    margin-bottom: 0.5em;
    margin-right: 1.2em;
    border-radius: 8px;
    padding: 0.6em;
    text-decoration: none;
}
a:visited{
  text-decoration: none;
  color: black;
}
</style>
<template>
    <div class="registrPage">
        <div class="ui-input-group">
            <div class="ui-input">
                <label for="input-first-name">Имя</label>
                <input id="input-first-name" type="text" placeholder="Иван" />
            </div>
            <div class="ui-input">
                <label for="input-last-name">Фамилия</label>
                <input id="input-last-name" type="text" placeholder="Иванов" />
            </div>
            <div class="ui-input">
                <label for="input-middle-name">Отчество</label>
                <input id="input-middle-name" type="text" placeholder="Иванович" />
            </div>
            <div class="ui-input">
                <label for="input-login">Логин</label>
                <input id="input-login" type="text" placeholder="Ivan123" />
            </div>
            <div class="ui-input">
                <label for="select-role">Доступ</label>
                <select class="ui-select" name="select-XcA1">
                    <option value="option0" selected disabled>Choose here</option>
                    <option value="option1">option 1</option>
                    <option value="option2">option 2</option>
                    <option value="option3">option 3</option>
                </select>
            </div>
            <div class="ui-input">
                <label for="input-password">Пароль</label>
                <input id="input-password" type="password"/>
            </div>
            <div class="ui-input">
                <label for="input-password">Подтвердите пароль</label>
                <input id="input-password" type="password"/>
            </div>
            <div class="ui-input">
                <button class="ui-button isDefault">Регистрация</button>
            </div>
        </div>
    </div>
</template>
<script>

export default{
    name: "RegistrationPage",
    mounted() {
        document.title = 'Регистрация'
    }
}
</script>
<style scoped>
.registrPage{
    background-color: #e1e1e1;
    padding-bottom: 5em;
    padding-top: 1em;

}
.ui-input{
    margin: 0.5em  4em;
}
.ui-input input,select{
    max-width: 20em;
}
.ui-button{
    border-radius: 5px;
    width: 10em;
    text-align: center;
    justify-content: center;
    font-size: 1.1em;
}
.ui-input button{
    background-color: white;
}
.ui-input-group .ui-input label{
    font-size: 1.05em;
}
</style>

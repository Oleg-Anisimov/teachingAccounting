<template>
    <div class="filling-form">
        <div class="academ-year">
            <p class="main-p">Академический год</p>
            <div class="form-border">
                <select name="year">
                    <option value="option0">2021/2022</option>
                    <option value="option1">2022/2023</option>
                    <option value="option2">2023/2024</option>
                    <option value="option3">2024/2025</option>
                    <option value="option4">2025/2026</option>
                    <option value="option5">2026/2027</option>
                </select>
            </div>
        </div>
        <div class="article">
            <p class="main-p">Новая запись</p>
            <div class="form-border">
                <button>Добавить</button> 
            </div>
            
        </div>
        <div class="export">
            <div class="form-border">
                <button><img src="../assets/img/print.png"> Версия для печати</button>
                <button class="last-button"><img src="../assets/img/excel.png">Экспорт в Excel</button>
            </div>
        </div>
    </div>
</template>
<style>
.filling-form{
    text-align: center;
    width: 15em;
    margin: 0.7em;
}
.academ-year{
    border-top: 0;
}
.form-border{
    padding: 0.5em 0;
    border:  0.2em solid royalblue;
    border-radius: 0 0 0.7em 0.7em;
}
.filling-form select{
    border: 1px solid black;
    width: 11em;
}
.filling-form .main-p{
    text-align: center;
    color: white;
    background-color: royalblue;
    border-radius: 0.7em 0.7em 0 0;
}
.article{
    margin: 1em 0;
}
.filling-form button{
    width: 11em;
    text-align: center;
    border: 0.4px solid;
    border-radius: 0.2em;
}
.export .form-border{
    border-radius: 0.7em;
    padding: 0;
}
.export .form-border button{
    margin-top: 0.5em;
    font-size: 0.96em;
}
.export .form-border .last-button{
    margin-bottom: 0.5em;
}
.export .form-border button img{
    width: 1em;
    height: 1em;
    margin-right: 0.1em;
    font-size: medium;
}

</style>
<script>
    export default{
        name: "Table"
    }
</script>
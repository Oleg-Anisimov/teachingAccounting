<script>
    export default{
        name: 'fillingForm'
    }
</script>
<style>
.filling-form{
    text-align: center;
    width: 15em;
}
.academ-year{
    border-top: 0;
    background-color: #f1f1f1;
}
.form-border{
    padding: 0.5em 0;
    border:  0.2em solid royalblue;
    border-radius: 0 0 0.7em 0.7em;
}
.filling-form .main-p{
    text-align: center;
    color: white;
    background-color: royalblue;
    border-radius: 0.7em 0.7em 0 0;
}
.article{
    margin: 1em 0;
    background-color: #f1f1f1;
}
.filling-form button,input,select{
    width: 11em;
    border-radius: 0.2em;
}
.filling-form select{
    border: 1px solid black;
}
.filling-form input{
    border: 1px solid black;
}
.filling-form button{
    text-align: center;
    border: 1px solid black;
    margin-top: 0.8em;
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
.article .form-border select,input,button{
    margin-bottom: 0.5em;
}
.form-border p{
    margin-bottom: 0.2em;
}
.export{
    background-color: #f1f1f1;
}
</style>
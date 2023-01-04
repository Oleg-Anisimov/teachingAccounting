<script>
    export default{
        name: 'tableStyle'
    }
</script>
<style>
    .academic_work_page{
        padding: 1em;
        display: grid;
        grid-template-areas: "filling-form table";
        grid-gap: 1em;
    }
    table{
        grid-area: table;
        max-height: 50px;
        max-width: 94em;
        border: 0.2em solid royalblue;
        background-color: #f1f1f1;
    }
    table td{
        border: 0.2em solid royalblue;
        text-align: center;
        justify-content: center;
        vertical-align: middle;
    }
    table th{
        border: 0.2em solid royalblue;
        text-align: center;
        justify-content: center;
        vertical-align: middle;
    }
    .left-helf{
        padding: 10px 0;
    }
    .right-helf{
        padding: 0px 20px;
        word-wrap:break-word;
        width: 100px;
    }
    .td-bottom{
        padding: 5px 0;
    }
    .simvol{
        padding: 0 5px;
    }
    .last-td p{
        text-align: left;
    }
    .last-td input{
        width: 3em;
        border: 1px solid black;
    }
    .last-td{
        padding: 3px;
    }
</style>
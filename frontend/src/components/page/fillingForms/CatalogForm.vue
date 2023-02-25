<template>
    <div class="filling-form">
        <div class="academ-year">
            <p class="main-p">Справочники</p>
            <div class="form-border">
                <select name="year">
                    <option value="option0">Группы</option>
                    <option value="option1">Специальности</option>
                    <option value="option2">Ак. дисциплины</option>
                </select>
            </div>
        </div>
        <div class="article">
          <p class="main-p">Новая запись</p>
          <div class="form-border">
            <slot></slot>
          </div>
        </div>
    </div>
</template>

<script>

export default{
  name: "CatalogForm",
  props: {
    model: {
      type: Object,
      required: false,
    }
  },

  methods: {
  },
  mounted(){

  },

}

</script>

<style>
.input_edit_mode {
  width: 39% !important;
  margin: 1%;
}
</style>


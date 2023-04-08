<template>
    <div class="filling-form">
        <div class="academ-year">
            <p class="main-p">Справочники</p>
            <div class="form-border">
                <select name="year" @change="(e) => this.$emit('catalogSelected', e)">
                    <option value="group">Группы</option>
                    <option value="specialization">Специальности</option>
                    <option value="discipline">Ак. дисциплины</option>
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


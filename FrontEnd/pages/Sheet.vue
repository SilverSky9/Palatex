<template>
  <div>
    <b-row>
      <b-card class="content bg-light w-100 ml-3 mr-4">
        <b-row>
          <b-col>
            <p>น้ำหนักน้ำยางรวม</p>
            <b-form-input
              type="text"
              placeholder="All Latex"
              v-model="allLatex"
              required
              disabled
            ></b-form-input
          ></b-col>
          <b-col
            ><p>น้ำหนักยางแผ่นรวม</p>
            <b-form-input
              type="text"
              v-model="sheetPrice"
              placeholder="Sheet Price"
              required
              disabled
            ></b-form-input
          ></b-col>
          <b-col
            ><b-button pill variant="outline-success" class="w-100 py-3 mt-3"
              >Record</b-button
            ></b-col
          >
        </b-row>
      </b-card>
    </b-row>
    <b-row class="pr-2 my-3">
      <b-col>
        <b-card class="content bg-light">
          <b-card-text class="m-2">
            <fa :icon="['fa', 'money-bill']" size="2x" />
            <span class="h3">ราคายางแผ่นรมควัน</span>
          </b-card-text>

          <b-card-text class="display-2 p-3">
            <!-- <fa :icon="['fab', 'btc']" size="2xb" /> -->
            {{ allLatex * sheetPrice }} ฿
            <!-- {{ date }} -->
          </b-card-text>
          <!-- <NuxtLink class="ml-3" to="/analysis"
            ><b-button variant="danger">Analysis</b-button></NuxtLink
          > -->
        </b-card>
      </b-col>
    </b-row>
  </div>
</template>

<script>
export default {
  layout: 'Navbar',
  data() {
    return {
      sheetPrice: null,
      allLatex: 1500,
    }
  },
  fetch() {
    this.sheetPrice = this.allLatex * 0.35
  },
}
</script>

<style>
</style>
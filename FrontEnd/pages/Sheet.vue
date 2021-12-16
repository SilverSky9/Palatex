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
              v-model="sheetWeight"
              placeholder="Sheet Price"
              required
              disabled
            ></b-form-input
          ></b-col>
          <b-col
            ><p>ราคายางแผ่นรวม</p>
            <b-form-input
              type="text"
              v-model="sheetPrice"
              placeholder="Sheet Price"
              required
              disabled
            ></b-form-input
          ></b-col>
          <b-col
            ><b-button
              pill
              variant="outline-success"
              class="w-100 py-3 mt-3"
              @click="postSheet()"
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
            {{ sheetWeight * sheetPrice }} ฿
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
  methods: {
    async getLatexSheetPrice() {
      const price = await this.$axios.$get('http://localhost:8093/price')
      this.sheetPrice = price
    },
    async getTransaction() {
      const tran = await this.$axios.$get(
        'http://localhost:8093/transaction/all'
      )
      this.transaction = tran
    },
    async getSheetData() {
      await this.getTransaction()
      const currentDateMin = new Date()
      currentDateMin.setHours(0, 0, 0, 0)
      const currentDateMax = new Date()
      currentDateMax.setHours(23, 59, 0, 0)
      const filterData = this.transaction.filter(
        (x) =>
          Date.parse(x.dateTime) < currentDateMax &&
          Date.parse(x.dateTime) > currentDateMin
      )
      // console.log(test)
      var allUnit = 0
      var allPrice = 0
      filterData.forEach((x) => {
        allUnit += x.unit
      })
      this.allLatex = allUnit
      this.sheetWeight = allUnit * 0.35
    },

    async postSheet() {
      var data = {
        sumUnit: this.allLatex,
        sumMoneyBuy: this.sheetPrice * this.sheetWeight,
        weightToSheet: this.sheetWeight,
        date: new Date(),
        dateTime: new Date(),
      }
      await this.$axios
        .$post('http://localhost:8093/sheet/add', data)
        .then((res) => console.log(res))

      // console.log(this.total_sheet_price)
    },
  },
  mounted() {
    this.getLatexSheetPrice()
    this.getSheetData()
  },
  data() {
    return {
      sheetPrice: 0,
      sheetWeight: 0,
      allLatex: 0,
      transaction: [],
      // total_sheet_price: 0,
    }
  },
  fetch() {
    // this.total_sheet_price = this.sheetWeight * this.sheetPrice
  },
}
</script>

<style>
</style>
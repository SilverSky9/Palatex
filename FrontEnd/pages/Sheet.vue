<template>
  <div>
    <b-row>
      <b-card class="content bg-light w-100 ml-3 mr-4">
        <b-row>
          <b-col>
            <p>น้ำหนักน้ำยางรวม ของวันนี้</p>
            <b-form-input
              type="text"
              placeholder="All Latex"
              v-model="allLatex"
              required
              disabled
            ></b-form-input
          ></b-col>
          <b-col
            ><p>น้ำหนักยางแผ่นรวม ของวันนี้</p>
            <b-form-input
              type="text"
              v-model="sheetWeight"
              placeholder="Sheet Price"
              required
              disabled
            ></b-form-input
          ></b-col>
          <b-col
            ><p>ราคายางแผ่นรวม ของวันนี้</p>
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
              :disabled="sheetPrice == 0"
              >บันทึกข้อมูล</b-button
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
            <span class="h3">ราคารวมยางแผ่นรมควัน ของวันนี้</span>
          </b-card-text>

          <b-card-text class="display-2 p-3">
            <!-- <fa :icon="['fab', 'btc']" size="2xb" /> -->
            {{ (sheetWeight * sheetPrice).toFixed(2) }} ฿
            <!-- {{ date }} -->
          </b-card-text>
          <!-- <NuxtLink class="ml-3" to="/analysis"
            ><b-button variant="danger">Analysis</b-button></NuxtLink
          > -->
        </b-card>
      </b-col>
    </b-row>
    <b-row>
      <b-col>
        <b-card class="content bg-light">
          <b-card-text class="m-2">
            <fa :icon="['fa', 'money-bill']" size="2x" />
            <span class="h3">ยางแผ่นรมควันทั้งหมด</span>
          </b-card-text>

          <b-card-text>
            <b-table
              sticky-header="26rem"
              hover
              :items="allSheet"
              :fields="fields"
            >
              <template #cell(dateTime)="data">
                {{ $moment(data.item.date).format('DD MMM YYYY') }}
              </template>
            </b-table>
          </b-card-text>
          <!-- <NuxtLink class="ml-3" to="/analysis"
            ><b-button variant="danger">Analysis</b-button></NuxtLink
          > -->
        </b-card>
      </b-col>
    </b-row>
    <b-row class="pr-2 my-3">
      <b-col>
        <b-card class="content bg-light">
          <b-card-text class="m-2">
            <fa :icon="['fa', 'money-bill']" size="2x" />
            <span class="h3">น้ำหนักยางแผ่นรวม</span>
          </b-card-text>

          <b-card-text class="display-2 p-3">
            <!-- <fa :icon="['fab', 'btc']" size="2xb" /> -->
            {{ sumAllSheetUnit.toFixed(2) }} Kg
            <!-- {{ date }} -->
          </b-card-text>
          <!-- <NuxtLink class="ml-3" to="/analysis"
            ><b-button variant="danger">Analysis</b-button></NuxtLink
          > -->
        </b-card>
      </b-col>
      <b-col>
        <b-card class="content bg-light">
          <b-card-text class="m-2">
            <fa :icon="['fa', 'money-bill']" size="2x" />
            <span class="h3">ราคายางแผ่นรวม</span>
          </b-card-text>

          <b-card-text class="display-2 p-3">
            <!-- <fa :icon="['fab', 'btc']" size="2xb" /> -->
            {{ sumAllSheetProfit.toFixed(2) }} ฿
            <!-- {{ date }} -->
          </b-card-text>
          <!-- <NuxtLink class="ml-3" to="/analysis"
            ><b-button variant="danger">Analysis</b-button></NuxtLink
          > -->
        </b-card>
      </b-col>
    </b-row>
    <b-row class="pr-2 my-3">
      <b-col>
        <b-card class="content bg-light">
          <b-card-text class="m-2">
            <fa :icon="['fa', 'money-bill']" size="2x" />
            <span class="h3">สัดส่วนกำไร</span>
          </b-card-text>

          <b-card-text class="display-2 p-3">
            <!-- <fa :icon="['fab', 'btc']" size="2xb" /> -->
            <b-row class="text-center">
              <b-col>
                <h1>รับซื้อ</h1>
                {{ cost.toFixed(2) }}
              </b-col>
              <b-col
                :class="
                  sumAllSheetProfit - cost < 0 ? 'text-danger' : 'text-success'
                "
                class="font-weight-bold"
              >
                <h1>กำไร</h1>
                {{ (sumAllSheetProfit - cost).toFixed(2) }}
              </b-col>
              <b-col>
                <h1>ขาย</h1>
                {{ sumAllSheetProfit.toFixed(2) }}
              </b-col>
            </b-row>
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
import moment from 'moment'
export default {
  layout: 'Navbar',
  methods: {
    async getLatexSheetPrice() {
      const price = await this.$axios.$get(
        'http://localhost:8093/price',
        this.$store.state.header_token
      )
      this.sheetPrice = price
    },
    async getAllLatexSheet() {
      const sheet = await this.$axios.$get(
        'http://localhost:8093/sheet/all',
        this.$store.state.header_token
      )
      this.allSheet = sheet
      // console.log(this.allSheet)

      this.allSheet.map((x) => {
        this.sumAllSheetUnit += x.weightToSheet
        this.sumAllSheetProfit += x.sumMoneyBuy
      })
    },
    async getTransaction() {
      const tran = await this.$axios.$get(
        'http://localhost:8093/transaction/all',
        this.$store.state.header_token
      )
      this.transaction = tran

      this.transaction.map((x) => {
        this.cost += x.total_price
      })
    },
    async getSheetData() {
      let dateI = 0
      let select = ''
      await this.getTransaction()
      // const currentDateMin = new Date()
      // currentDateMin.setHours(0, 0, 0, 0)
      // const currentDateMax = new Date()
      // currentDateMax.setHours(23, 59, 0, 0)

      // const filterData = this.transaction.filter(
      //   (x) =>
      // Date.parse(x.dateTime) < currentDateMax &&
      // Date.parse(x.dateTime) > currentDateMin
      //     x
      // )
      // console.log(test)

      this.transaction.map((i, index) => {
        select = i.date
        dateI = this.sheet.findIndex((x) => x.Date == select)
        if (dateI < 0) {
          this.sheet.push({ Date: select, Kg: i.unit })
          // this.totalBaht.push({
          //   Date: select,
          //   total: (i.percent / 100) * i.unit * i.price_buy,
          // })
        } else {
          this.sheet[dateI].Kg += i.unit
          // this.totalBaht[dateI].total +=
          //   (i.percent / 100) * i.unit * i.price_buy
        }
      })
      console.log(this.sheet)


      this.toDay = this.sheet.filter(
        (x) => x.Date == moment().format('YYYY-MM-DD')
      )

      this.toDay.map((x) => {
        this.allLatex += x.Kg
        this.sheetWeight += x.Kg * 0.35
      })

      // var allUnit = 0
      // var allPrice = 0
      // filterData.forEach((x) => {
      //   allUnit += x.unit
      // })
      // this.allLatex = allUnit
      // this.sheetWeight = allUnit * 0.35
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
        .$post(
          'http://localhost:8093/sheet/add',
          data,
          this.$store.state.header_token
        )
        .then((res) => console.log(res))

      // console.log(this.total_sheet_price)
    },
  },
  mounted() {
    this.getLatexSheetPrice()
    this.getSheetData()
    this.getAllLatexSheet()
  },
  data() {
    return {
      sheetPrice: 0,
      sheetWeight: 0,
      allLatex: 0,
      sumAllSheetUnit: 0,
      sumAllSheetProfit: 0,
      cost: 0,
      transaction: [],
      sheet: [],
      toDay: [],

      allSheet: [],
      fields: [
        { key: 'dateTime', label: 'Date' },

        { key: 'sumUnit', label: 'Latex Unit' },
        { key: 'weightToSheet', label: 'Latex Sheet Unit' },

        { key: 'sumMoneyBuy', label: 'Price' },
      ],
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
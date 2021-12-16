<template>
  <div>
    <b-row class="pr-2 my-3">
      <b-col>
        <b-card class="content bg-light">
          <b-card-text class="m-2">
            <fa :icon="['fa', 'money-bill']" size="2x" />
            <span class="h3">ราคารวมปีนี้</span>
          </b-card-text>

          <b-card-text class="display-2 p-3">
            <!-- <fa :icon="['fab', 'btc']" size="2xb" /> -->
            ฿ {{ allTotal }} บาท
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
            <span class="h3">ราคารวมปีนี้</span>
          </b-card-text>

          <b-card-text>
            <b-table
              sticky-header="26rem"
              hover
              :items="analysis"
              :fields="fields"
            >
              <template #cell(firstname)="data">
                {{ data.item.firstname + ' ' + data.item.lastname }}
              </template>
              <template #cell(dateTime)="data">
                {{ $moment(data.item.date).format('DD MMM YYYY') }}
              </template>
              <template #cell(total_price)="data">
                {{ data.item.total_price.toFixed(2) }}
              </template>
            </b-table>
          </b-card-text>
          <!-- <NuxtLink class="ml-3" to="/analysis"
            ><b-button variant="danger">Analysis</b-button></NuxtLink
          > -->
        </b-card>
      </b-col>
      <b-col cols="4">
        <b-card class="content bg-light">
          <b-card-text class="m-2">
            <fa :icon="['fa', 'money-bill']" size="2x" />
            <span class="h3">แปลรูป</span>
          </b-card-text>

          <b-card-text class="display-2 p-3">
            <BarChart
              :chartData="donutData"
              :options="chartOptions"
              class="chart"
            />
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
            <fa :icon="['fa', 'chart-line']" size="2x" />

            <span class="h3">น้ำหนักต่อวันรวมทั้งปี</span>
          </b-card-text>

          <b-card-text class="display-3 p-3">
            <!-- <fa :icon="['fab', 'btc']" size="2xb" /> -->
            <LineChart
              :chartData="chartData"
              :options="chartOptions"
              class="chart"
            />
            <!-- <fa :icon="['fab', 'btc']" size="2xb" /> -->
            Total : {{ allKg }} Kg
          </b-card-text>
          <!-- <NuxtLink class="ml-3" to="/analysis"
            ><b-button variant="danger">Analysis</b-button></NuxtLink
          > -->
        </b-card>
      </b-col>
      <b-col>
        <b-card class="content bg-light">
          <b-card-text class="m-2">
            <fa :icon="['fa', 'chart-line']" size="2x" />

            <span class="h3">ราคาต่อวันรวมทั้งปี</span>
          </b-card-text>

          <b-card-text class="display-3 p-3">
            <!-- <fa :icon="['fab', 'btc']" size="2xb" /> -->
            <LineChart
              :chartData="bahtData"
              :options="chartOptions"
              class="chart"
            />
            <!-- <fa :icon="['fab', 'btc']" size="2xb" /> -->
            Total : {{ allTotal }} ฿
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

  test() {
    console.log('kuy')
  },

  data() {
    return {
      userTest: [],
      latex: [],
      haha: 'susprayuth',
      allTime: [],
      totalBaht: [],
      allTotal: null,

      allKg: null,
      fields: [
        { key: 'firstname', label: 'name' },
        // { key: 'user_id', label: 'User Id' },

        { key: 'dateTime', label: 'Date' },
        { key: 'price_buy', label: 'Price' },
        { key: 'unit', label: 'Unit' },
        { key: 'total_price', label: 'Total' },
      ],
      donutData: {
        // labels: ['10 / 12 / 21', '9 / 12 / 21', '8 / 12 / 21', '7 / 12 / 21'],
        labels: ['น้ำหนักน้ำยางสด', 'น้ำหนักยางแผ่นรมควัน'],
        datasets: [
          {
            label: 'Kilogram Over Year',
            data: [2, 2],
            backgroundColor: ['#6731fb', '#ffb531'],
            fill: false,
          },
        ],
      },
      chartData: {
        // labels: ['10 / 12 / 21', '9 / 12 / 21', '8 / 12 / 21', '7 / 12 / 21'],
        labels: [],
        datasets: [
          {
            label: 'Kilogram Over Year',
            data: [],
            borderColor: '#ee801e',
            borderWidth: 4,
            fill: false,
          },
        ],
      },
      bahtData: {
        labels: [],
        datasets: [
          {
            label: 'Money Over Year',
            data: [],
            borderColor: '#6731FB',
            borderWidth: 4,
            fill: false,
          },
        ],
      },
      chartOptions: {
        maintainAspectRatio: false,
        responsive: true,
      },
      user: [],
      transaction: [],
      analysis: [],
    }
  },
  methods: {
    async getUser() {
      const user = await this.$axios.$get('http://localhost:8093/user/all')
      //console.log(user)
      this.user = user
      //console.log(this.haha)
    },
    async getTransaction() {
      const tran = await this.$axios.$get(
        'http://localhost:8093/transaction/all'
      )
      this.transaction = tran
      // console.log(tran)
    },
    async getAnalysis() {
      await this.getUser()
      await this.getTransaction()
      this.transaction.forEach((x) => {
        this.user.forEach((y) => {
          if (x.user_id == y.user_id) {
            this.analysis.push(Object.assign(x, y))
          }
        })
      })

      //await this.transaction.map((x) => this.analysis.push(x))
      console.log(this.analysis)
    },
  },

  mounted() {
    console.log('mounted')
    // console.log(this.haha, 'asd')
    //console.log(this.haha)
    this.getAnalysis()
  },

  async fetch() {
    let dateI = 0
    let select = ''

    //console.log('asdasd')

    // const userTest = await fetch('https://api.nuxtjs.dev/mountains').then(
    //   (res) => res.json()
    // )
    // console.log(userTest)

    this.analysis.map((i, index) => {
      select = i.dateTime
      dateI = this.allTime.findIndex((x) => x.Date == select)
      if (dateI < 0) {
        this.allTime.push({ Date: select, Kg: i.unit })
        this.totalBaht.push({ Date: select, total: i.price_buy * i.unit })
      } else {
        this.allTime[dateI].Kg += i.unit
        this.totalBaht[dateI].total += i.price_buy * i.unit
      }
      this.allKg += i.unit
      this.allTotal += i.price_buy * i.unit
      console.log(this.allTime)
    })

    this.allTime.sort(function (a, b) {
      var keyA = new Date(a.Date),
        keyB = new Date(b.Date)
      // Compare the 2 dates
      if (keyA < keyB) return -1
      if (keyA > keyB) return 1
      return 0
    })

    this.totalBaht.sort(function (a, b) {
      var keyA = new Date(a.Date),
        keyB = new Date(b.Date)
      // Compare the 2 dates
      if (keyA < keyB) return -1
      if (keyA > keyB) return 1
      return 0
    })
    // console.log(this.allTime)
    this.chartData.labels = this.allTime.map((x) =>
      moment(x.Date).format('DD MMM')
    )
    this.chartData.datasets[0].data = this.allTime.map((x) => x.Kg)

    this.bahtData.labels = this.totalBaht.map((x) =>
      moment(x.Date).format('DD MMM')
    )
    this.bahtData.datasets[0].data = this.totalBaht.map((x) => x.total)

    this.donutData.datasets[0].data[0] = this.allKg
    this.donutData.datasets[0].data[1] = this.allKg * 0.35
  },
}
</script>

<style>
.content {
  border-radius: 2rem;
  font-family: 'Kanit';
}
.chart {
  height: 100%;
}
.borderRadius {
  border-radius: 2rem;
}
</style>
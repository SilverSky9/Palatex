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
            ฿ 5,000,000 บาท
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

          <b-card-text class="">
            <b-table hover :items="user">
              <template #cell(date)="data">
                {{ $moment(data.item.date).format('DD MMM YYYY') }}
              </template>
              <template #cell(total)="data">
                {{ data.item.total.toFixed(2) }}
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
            <span class="h3">ราคารวมปีนี้</span>
          </b-card-text>

          <b-card-text class="display-2 p-3">
            <!-- <fa :icon="['fab', 'btc']" size="2xb" /> -->
            ฿ 5,000,000 บาท
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

          <b-card-text class="display-2 p-3">
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

            <span class="h3">น้ำหนักต่อวันรวมทั้งปี</span>
          </b-card-text>

          <b-card-text class="display-2 p-3">
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
      haha: 'susprayuth',
      allTime: [],
      totalBaht: [],
      allTotal: null,

      allKg: null,
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
        // labels: ['10 / 12 / 21', '9 / 12 / 21', '8 / 12 / 21', '7 / 12 / 21'],
        labels: [],
        datasets: [
          {
            label: 'Money Over Year',
            data: [],
            borderColor: '#ee801e',
            borderWidth: 4,
            fill: false,
          },
        ],
      },
      chartOptions: {
        maintainAspectRatio: false,
        responsive: true,
      },
      user: [
        {
          name: 'Marilyn Shaffer',
          date: '2022-01-02',
          price_buy: 56.9,
          unit: 65,
          total: 3698.5,
        },
        {
          name: 'Jeanine Quinn',
          date: '2022-01-06',
          price_buy: 53.46,
          unit: 92,
          total: 4918.32,
        },
        {
          name: 'Selma James',
          date: '2022-01-02',
          price_buy: 51.4,
          unit: 97,
          total: 4985.8,
        },
        {
          name: 'Minnie Reilly',
          date: '2022-01-10',
          price_buy: 51.29,
          unit: 75,
          total: 3846.75,
        },
        {
          name: 'Sybil Mccray',
          date: '2022-01-03',
          price_buy: 57.84,
          unit: 83,
          total: 4800.72,
        },
        {
          name: 'Clayton Mcclain',
          date: '2022-01-08',
          price_buy: 57.6,
          unit: 97,
          total: 5587.2,
        },
        {
          name: 'Dejesus Harrison',
          date: '2022-01-09',
          price_buy: 55.72,
          unit: 72,
          total: 4011.84,
        },
        {
          name: 'Macdonald Reid',
          date: '2022-01-01',
          price_buy: 53.35,
          unit: 91,
          total: 4854.85,
        },
        {
          name: 'Richardson Melendez',
          date: '2022-01-04',
          price_buy: 57.18,
          unit: 68,
          total: 3888.24,
        },
        {
          name: 'Solomon Chavez',
          date: '2022-01-06',
          price_buy: 56.58,
          unit: 68,
          total: 3847.44,
        },
        {
          name: 'Tanner Page',
          date: '2022-01-02',
          price_buy: 56.37,
          unit: 90,
          total: 5073.3,
        },
        {
          name: 'Pacheco Gordon',
          date: '2022-01-02',
          price_buy: 58.21,
          unit: 60,
          total: 3492.6,
        },
        {
          name: 'Delaney Sutton',
          date: '2022-01-05',
          price_buy: 55.82,
          unit: 95,
          total: 5302.9,
        },
        {
          name: 'Bradshaw Torres',
          date: '2022-01-03',
          price_buy: 54.02,
          unit: 100,
          total: 5402,
        },
        {
          name: 'Warner Cooke',
          date: '2022-01-10',
          price_buy: 59.84,
          unit: 65,
          total: 3889.6000000000004,
        },
        {
          name: 'Gwendolyn Harrington',
          date: '2022-01-01',
          price_buy: 55.82,
          unit: 89,
          total: 4967.9800000000005,
        },
        {
          name: 'Daphne Mclean',
          date: '2022-01-07',
          price_buy: 57.49,
          unit: 95,
          total: 5461.55,
        },
        {
          name: 'Vicki Richard',
          date: '2022-01-06',
          price_buy: 50.24,
          unit: 60,
          total: 3014.4,
        },
        {
          name: 'Bobbie Ayers',
          date: '2022-01-02',
          price_buy: 59.65,
          unit: 68,
          total: 4056.2,
        },
        {
          name: 'Rowe Emerson',
          date: '2022-01-04',
          price_buy: 54.23,
          unit: 60,
          total: 3253.7999999999997,
        },
      ],
    }
  },
  methods: {
    async getUser() {
      const ip = await this.$axios.$get('http://localhost:8093/user/all')
      //console.log(ip)
      this.userTest = ip
      console.log(this.userTest)
      //console.log(this.haha)
    },
  },

  mounted() {
    console.log('mounted')
    // console.log(this.haha, 'asd')
    //console.log(this.haha)
    this.getUser()
  },

  async fetch() {
    let dateI = 0
    let select = ''

    //console.log('asdasd')

    // const userTest = await fetch('https://api.nuxtjs.dev/mountains').then(
    //   (res) => res.json()
    // )
    // console.log(userTest)

    this.user.map((i, index) => {
      select = i.date
      dateI = this.allTime.findIndex((x) => x.Date == select)
      if (dateI < 0) {
        this.allTime.push({ Date: select, Kg: i.unit })
        this.totalBaht.push({ Date: select, total: i.total })
      } else {
        this.allTime[dateI].Kg += i.unit
        this.totalBaht[dateI].total += i.total
      }
      this.allKg += i.unit
      this.allTotal += i.total
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
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
            <fa :icon="['fa', 'users']" size="2x" />
            <span class="h3">รายชื่อผู้ใช้ทั้งหมด</span>
          </b-card-text>

          <b-card-text>
            <b-table sticky-header="26rem" hover :items="user">
              <template #cell(date)="data">
                {{ $moment(data.item.date).format('DD MMM YYYY') }}
              </template>
              <template #cell(total)="data">
                {{ data.item.price_buy * data.item.unit }}
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
            <DoughNut
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
  data() {
    return {
      allTime: [],
      totalBaht: [],
      allTotal: null,

      allKg: null,
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
      user: [
        {
          name: 'Marilyn Shaffer',
          date: '2022-01-02',
          price_buy: 56.9,
          unit: 65,
        },
        {
          name: 'Jeanine Quinn',
          date: '2022-01-06',
          price_buy: 53.46,
          unit: 92,
        },
        {
          name: 'Selma James',
          date: '2022-01-02',
          price_buy: 51.4,
          unit: 97,
        },
        {
          name: 'Minnie Reilly',
          date: '2022-01-10',
          price_buy: 51.29,
          unit: 75,
        },
        {
          name: 'Sybil Mccray',
          date: '2022-01-03',
          price_buy: 57.84,
          unit: 83,
        },
        {
          name: 'Clayton Mcclain',
          date: '2022-01-08',
          price_buy: 57.6,
          unit: 97,
        },
        {
          name: 'Dejesus Harrison',
          date: '2022-01-09',
          price_buy: 55.72,
          unit: 72,
        },
        {
          name: 'Macdonald Reid',
          date: '2022-01-01',
          price_buy: 53.35,
          unit: 91,
        },
        {
          name: 'Richardson Melendez',
          date: '2022-01-04',
          price_buy: 57.18,
          unit: 68,
        },
        {
          name: 'Solomon Chavez',
          date: '2022-01-06',
          price_buy: 56.58,
          unit: 68,
        },
        {
          name: 'Tanner Page',
          date: '2022-01-02',
          price_buy: 56.37,
          unit: 90,
        },
        {
          name: 'Pacheco Gordon',
          date: '2022-01-02',
          price_buy: 58.21,
          unit: 60,
        },
        {
          name: 'Delaney Sutton',
          date: '2022-01-05',
          price_buy: 55.82,
          unit: 95,
        },
        {
          name: 'Bradshaw Torres',
          date: '2022-01-03',
          price_buy: 54.02,
          unit: 100,
        },
        {
          name: 'Warner Cooke',
          date: '2022-01-10',
          price_buy: 59.84,
          unit: 65,
        },
        {
          name: 'Gwendolyn Harrington',
          date: '2022-01-01',
          price_buy: 55.82,
          unit: 89,
        },
        {
          name: 'Daphne Mclean',
          date: '2022-01-07',
          price_buy: 57.49,
          unit: 95,
        },
        {
          name: 'Vicki Richard',
          date: '2022-01-06',
          price_buy: 50.24,
          unit: 60,
        },
        {
          name: 'Bobbie Ayers',
          date: '2022-01-02',
          price_buy: 59.65,
          unit: 68,
        },
        {
          name: 'Rowe Emerson',
          date: '2022-01-04',
          price_buy: 54.23,
          unit: 60,
        },
      ],
    }
  },
  fetch() {
    let dateI = 0
    let select = ''

    this.user.map((i, index) => {
      select = i.date
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
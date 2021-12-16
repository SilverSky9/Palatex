<template>
  <div>
    <b-row class="pr-2 my-3">
      <b-col>
        <b-card class="content bg-light">
          <b-card-text class="m-2">
            <fa :icon="['fa', 'tag']" size="lg" />
            <span class="h3">ราคายางในวันนี้</span>
          </b-card-text>

          <b-card-text class="display-2 p-3">
            <!-- <fa :icon="['fab', 'btc']" size="2xb" /> -->
            ฿ 59.30 บาท/กิโลกรัม
          </b-card-text>
          <NuxtLink class="ml-3" to="/Transection"
            ><b-button pill variant="outline-info" class="px-5" size="lg"
              >Transection</b-button
            ></NuxtLink
          >
          <NuxtLink class="ml-3" to="/analysis"
            ><b-button pill variant="outline-success" class="px-5" size="lg"
              >Analysis</b-button
            ></NuxtLink
          >
          <a class="ml-3"
            ><b-button pill variant="outline-warning" class="px-5" size="lg"
              >Edit</b-button
            ></a
          >
        </b-card>
      </b-col>
    </b-row>

    <b-row class="pr-2 my-4">
      <b-col cols="3">
        <b-card class="content bg-light">
          <b-card-text class="m-2">
            <fa :icon="['fa', 'fast-backward']" size="lg" />
            <span class="h3 ml-2">ราคาย้อนหลัง</span>
          </b-card-text>

          <b-card-text class="">
            <b-table hover :items="items">
              <template #cell(Date)="data">
                {{ $moment(data.item.Date).format('DD MMM YY') }}
              </template>
              <template #cell(Price)="data">
                {{ data.item.Price + ' ฿/Kg' }}
              </template>
            </b-table>
          </b-card-text>

          <!-- <b-link href="#" class="card-link">Nothing To link Dont Click</b-link> -->
        </b-card>
      </b-col>
      <b-col cols="9">
        <b-card class="content bg-light">
          <b-card-text class="m-2">
            <fa :icon="['fa', 'chart-line']" size="2x" />
            <span class="h3 ml-2">กราฟ</span>
          </b-card-text>

          <b-card-text class="display-2 p-3">
            <LineChart
              :chartData="chartData"
              :options="chartOptions"
              class="chart"
            />
          </b-card-text>

          <!-- <b-link href="#" class="card-link">Nothing To link Dont Click</b-link> -->
        </b-card>
      </b-col>
    </b-row>
  </div>
</template>
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

<script>
import moment from 'moment'
import LineChart from '../components/LineChart.vue'
export default {
  components: { LineChart },
  layout: 'Navbar',
  data: () => ({
    items: [
      { Date: '12-7-2021', Price: 59 },
      { Date: '12-8-2021', Price: 58.9 },
      { Date: '12-9-2021', Price: 58.6 },

      { Date: '12-10-2021', Price: 59.3 },
    ],
    chartData: {
      // labels: ['10 / 12 / 21', '9 / 12 / 21', '8 / 12 / 21', '7 / 12 / 21'],
      labels: [],

      datasets: [
        {
          label: 'Price Over Month',
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
    selected: null,
    options: [
      { value: null, text: 'Please select an option' },
      { value: 'a', text: 'This is First option' },
      { value: 'b', text: 'Selected Option' },
      { value: '', text: 'This is an option with object value' },
      { value: 'd', text: 'This one is disabled', disabled: true },
    ],
  }),
  fetch() {
    this.chartData.labels = this.items.map((x) =>
      moment(x.Date).format('DD MMM')
    )
    this.chartData.datasets[0].data = this.items.map((x) => x.Price)
  },
}
</script>

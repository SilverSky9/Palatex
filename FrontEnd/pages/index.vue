<template>
  <div>
    <b-row class="pr-2 my-1">
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

          <!-- <b-link href="#" class="card-link">Nothing To link Dont Click</b-link> -->
        </b-card>
      </b-col>
    </b-row>
    <b-row class="pr-2 my-3">
      <b-col cols="3">
        <b-card class="content bg-light">
          <b-card-text class="m-2">
            <fa :icon="['fa', 'fast-backward']" size="2x" />
            <span class="h3 ml-2">ราคายางย้อนหลัง</span>
          </b-card-text>

          <b-card-text class="">
            <b-table hover :items="items"></b-table>
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
</style>

<script>
import LineChart from '../components/LineChart.vue'

export default {
  components: { LineChart },
  layout: 'Navbar',
  data() {
    return {
      items: [
        { Date: '10 / 12 / 21', Price: 59.3 },
        { Date: '9 / 12 / 21', Price: 58.6 },
        { Date: '8 / 12 / 21', Price: 58.9 },
        { Date: '7 / 12 / 21', Price: 59 },
      ],
      chartData: {
        // labels: ['10 / 12 / 21', '9 / 12 / 21', '8 / 12 / 21', '7 / 12 / 21'],
        labels: [],

        datasets: [
          {
            label: 'Price Over Time',
            data: [59.3, 58.6, 58.9, 59],
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
    }
  },
  async fetch() {
    this.chartData.labels = await this.items.map((x) => x.Date)
    this.chartData.datasets.data = await this.items.map((x) => x.Price)

    // console.log(this.labels)
  },
}
</script>

<template>
  <div>
    <b-row class="pr-2 my-3">
      <b-col>
        <b-card class="content bg-light">
          <b-card-text class="m-2">
            <fa :icon="['fa', 'tag']" size="lg" />
            <span class="h3">ราคายางในวันนี้</span>
          </b-card-text>

          <b-card-text class="p-3">
            <!-- <fa :icon="['fab', 'btc']" size="2xb" /> -->
            <h1 class="display-2" v-show="!edit">฿ {{ price }} บาท/กิโลกรัม</h1>
            <b-form-input
              v-show="edit"
              v-model="price"
              size="lg"
              class="w-25 my-4"
              type="text"
              placeholder="Sheet Price"
            ></b-form-input>
          </b-card-text>
          <NuxtLink class="ml-3" to="/Transection"
            ><b-button pill variant="outline-info" class="px-5" size="lg"
              >Transaction</b-button
            ></NuxtLink
          >
          <NuxtLink class="ml-3" to="/analysis"
            ><b-button pill variant="outline-success" class="px-5" size="lg"
              >Analysis</b-button
            ></NuxtLink
          >
          <a class="ml-3"
            ><b-button
              pill
              v-show="!edit"
              variant="outline-warning"
              @click="edit = !edit"
              class="px-5"
              size="lg"
              >Edit</b-button
            ></a
          >
          <a class="ml-3"
            ><b-button
              pill
              v-show="edit"
              variant="outline-success"
              @click="
                postLatex()
                save = !save
                edit = !edit
              "
              class="px-5"
              size="lg"
              >Save</b-button
            ></a
          ><a class="ml-3"
            ><b-button
              pill
              v-show="edit"
              variant="outline-danger"
              @click="
                cancel = !cancel
                edit = !edit
              "
              class="px-5"
              size="lg"
              >Cancel</b-button
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
            <b-table
              sticky-header="26rem"
              hover
              :items="latex"
              :fields="fields"
            >
              <template #cell(dateTime)="data">
                {{ $moment(data.item.dateTime).format('DD MMM YY') }}
              </template>
              <template #cell(price)="data">
                {{ data.item.price + ' ฿/Kg' }}
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
  methods: {
    async getLatex() {
      const latex = await this.$axios.$get(
        'http://localhost:8093/latex/all',
        this.$store.state.header_token
      )

      console.log(this.chartData)
      this.latex = latex

      latex.sort(function (a, b) {
        var keyA = new Date(a.dateTime),
          keyB = new Date(b.dateTime)
        // Compare the 2 dates
        if (keyA < keyB) return -1
        if (keyA > keyB) return 1
        return 0
      })
      this.price = latex[latex.length - 1].price

      this.chartData.labels = latex.map((x) =>
        moment(x.dateTime).format('DD MMM')
      )
      this.chartData.datasets[0].data = latex.map((x) => x.price)
      // console.log(latex)
    },
    async postLatex() {
      const data = {
        price: this.price,
        dateTime: new Date(),
      }
      await this.$axios
        .$post('http://localhost:8093/latex/add', data)
        .then((res) => console.log(res))
    },
  },
  mounted() {
    this.getLatex()
    //console.log(this.latex[0])
  },
  data: () => ({
    latex: [],
    edit: false,
    save: false,
    cancel: false,
    price: 0,
    fields: [
      { key: 'dateTime', label: 'Date' },
      { key: 'price', label: 'Price' },
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
  }),
  fetch() {},
}
</script>

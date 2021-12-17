<template>
  <div>
    <b-row class="pr-2 my-3">
      <b-col>
        <b-card class="content bg-light">
          <b-card-text class="m-2">
            <fa :icon="['fa', 'user']" size="2x" />
            <span class="h3">Profile</span>
          </b-card-text>

          <b-card-text class="display-4 p-3">
            <!-- <fa :icon="['fab', 'btc']" size="2xb" /> -->
            {{ Fname + ' ' + Lname }}
            <h1>User ID : 1</h1>
          </b-card-text>
          <!-- <NuxtLink class="ml-3" to="/analysis"
            ><b-button variant="danger">Analysis</b-button></NuxtLink
          > -->
        </b-card>
      </b-col>
      <b-col>
        <b-card class="content bg-light">
          <b-card-text class="m-2">
            <fa :icon="['fa', 'table']" size="2x" />
            <span class="h3">ยางที่เคยขายไป</span>
          </b-card-text>

          <b-card-text class="p-3">
            <!-- <fa :icon="['fab', 'btc']" size="2xb" /> -->
            <b-table
              sticky-header="26rem"
              hover
              :items="history"
              :fields="fields"
            >
              <template #cell(date)="data">
                {{ $moment(data.item.date).format('DD MMM YYYY') }}
              </template>
              <template #cell(total)="data">
                {{ (data.item.unit * data.item.price_buy).toFixed(1) }}
              </template>
            </b-table>
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
    async mountedQueue() {
      await this.getClaim()
      await this.getByUsername()
    },
    async getClaim() {
      await this.$axios
        .$get(
          'http://localhost:8093/checktoken/' + localStorage.getItem('token'),
          this.$store.state.header_token
        )
        .then((res) => {
          console.log(res)
          this.username = res.sub
        })
    },
    async getByUsername() {
      await this.$axios
        .$get(
          'http://localhost:8093/user/getbyusername/' + this.username,
          this.$store.state.header_token
        )
        .then((res) => console.log(res))
    },
  },
  mounted() {
    this.mountedQueue()
  },
  data: () => ({
    username: '',
    Fname: 'Pawaris',
    Lname: 'Wongsaied',
    fields: [
      { key: 'date', label: 'Date' },
      { key: 'price_buy', label: 'Price' },
      { key: 'unit', label: 'Unit' },
      { key: 'total', label: 'Total' },
    ],
    history: [
      {
        userId: 1,
        date: '2021-12-07',
        price_buy: 57.15,
        unit: 60,
      },
      {
        userId: 1,
        date: '2021-12-10',
        price_buy: 56.87,
        unit: 89,
      },
      {
        userId: 1,
        date: '2021-12-05',
        price_buy: 57.51,
        unit: 84,
      },
      {
        userId: 1,
        date: '2021-12-04',
        price_buy: 59.66,
        unit: 87,
      },
      {
        userId: 1,
        date: '2021-12-08',
        price_buy: 50.7,
        unit: 90,
      },
      {
        userId: 1,
        date: '2021-12-09',
        price_buy: 59.11,
        unit: 98,
      },
      {
        userId: 1,
        date: '2021-12-07',
        price_buy: 51.88,
        unit: 100,
      },
      {
        userId: 1,
        date: '2021-12-08',
        price_buy: 54.4,
        unit: 100,
      },
      {
        userId: 1,
        date: '2021-12-09',
        price_buy: 53.98,
        unit: 66,
      },
      {
        userId: 1,
        date: '2021-12-10',
        price_buy: 59.83,
        unit: 89,
      },
    ],
  }),
}
</script>

<style>
</style>
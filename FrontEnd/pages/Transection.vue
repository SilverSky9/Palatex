<template>
  <div>
    <b-row>
      <b-card class="content bg-light w-100 ml-3 mr-4">
        <b-row>
          <b-col>
            <p>รายชื่อผู้ใช้ทั้งหมด</p>
            <b-form-select v-model="selected">
              <template #first>
                <b-form-select-option :value="null" disabled
                  >-- Please select an option --</b-form-select-option
                >
              </template>
              <b-form-select-option
                v-for="(item, i) in user"
                :key="i"
                :value="item.memberId"
                >{{
                  item.memberId + ' ' + item.firstname + ' ' + item.lastname
                }}</b-form-select-option
              ></b-form-select
            >
            <!-- {{ selected }} -->
          </b-col>

          <b-col>
            <p>ราคายางในวันนี้</p>
            <b-form-input
              type="text"
              placeholder="Price_buy"
              v-model="price"
              required
              disabled
            ></b-form-input
          ></b-col>
          <b-col>
            <p>จำนวนน้ำยาง</p>
            <b-form-input
              type="text"
              v-model="unit"
              placeholder="Unit"
              required
            ></b-form-input
          ></b-col>
          <b-col
            ><b-button
              pill
              variant="outline-success"
              class="w-100 py-3 mt-3"
              @click="postTran()"
              >Transection</b-button
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
            <span class="h3">ราคาน้ำยาง</span>
          </b-card-text>

          <b-card-text class="display-2 p-3">
            <!-- <fa :icon="['fab', 'btc']" size="2xb" /> -->
            {{ price * unit }} ฿
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
      selected: null,
      date: new Date(),
      options: [
        { value: null, text: 'Please Select Name' },
        { value: 'a', text: 'nuchayaporn' },
        { value: 'b', text: 'noppadon' },
        { value: 'c', text: 'sinlapawit' },
        { value: 'd', text: 'pobjang' },
        { value: 'd', text: 'nigga' },
      ],
      date: new Date(),
      user: [],
      price: 0,
      unit: null,
    }
  },

  methods: {
    async getTran() {
      const ip = await this.$axios.$get(
        'http://localhost:8093/transaction/all',
        this.$store.state.header_token
      )
      console.log(ip)
    },
    async getAllUser() {
      const list = await this.$axios.$get(
        'http://localhost:8093/user/all',
        this.$store.state.header_token
      )
      this.user = list
      console.log(list)
    },
    async getLatex() {
      const latex = await this.$axios.$get(
        'http://localhost:8093/latex/all',
        this.$store.state.header_token
      )

      this.price = latex[latex.length - 1].price
    },
    async postTran() {
      var data = {
        user_id: '2',
        date: new Date(),
        dateTime: new Date(),
        unit: this.unit,
        price_buy: this.price,
        total_price: this.price * this.unit,
      }
      await this.$axios
        .$post(
          'http://localhost:8093/transaction/add',
          data,
          this.$store.state.header_token
        )
        .then((res) => console.log(res))
      // console.log(this.date)
      console.log(data)
    },
  },
  mounted() {
    console.log('moun')
    console.log(this.$store.state.header_token)
    this.getAllUser()
    this.getLatex()
  },
}
</script>

<style>
.content {
  border-radius: 2rem;
  font-family: 'Kanit';
}
</style>
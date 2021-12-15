<template>
  <div>
    <b-row>
      <b-card class="content bg-light w-100 mr-4">
        <b-row>
          <b-col>
            <b-form-select v-model="selected" :options="user"></b-form-select>
          </b-col>

          <b-col
            ><b-form-input
              type="text"
              placeholder="Price_buy"
              v-model="price"
              required
              disabled
            ></b-form-input
          ></b-col>
          <b-col
            ><b-form-input
              type="text"
              v-model="unit"
              placeholder="Unit"
              required
            ></b-form-input
          ></b-col>
          <b-col
            ><b-button pill variant="outline-success" class="w-100"
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
      options: [
        { value: null, text: 'Please Select Name' },
        { value: 'a', text: 'nuchayaporn' },
        { value: 'b', text: 'noppadon' },
        { value: 'c', text: 'sinlapawit' },
        { value: 'd', text: 'pobjang' },
        { value: 'd', text: 'nigga' },
      ],
      user: [],
      price: 56.9,
      unit: null,
    }
  },

  methods: {
    async getTran() {
      const ip = await this.$axios.$get('http://localhost:8093/transaction/all')
      console.log(ip)
    },
    async getAllUser() {
      const list = await this.$axios.$get('http://localhost:8093/user/all')
      console.log(list)
    },

    // async postTran(){
    //   var data : {
    //     unit

    //   }
    //   await this.$axios.$post('http://localhost:8093/transaction/add', data)
    // }
  },
  mounted() {
    console.log('moun')
    this.getAllUser()
  },
}
</script>

<style>
.content {
  border-radius: 2rem;
  font-family: 'Kanit';
}
</style>
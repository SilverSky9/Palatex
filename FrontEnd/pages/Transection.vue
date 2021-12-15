<template>
  <div>
    <b-row>
      <b-card class="content bg-light w-100 ml-3 mr-4">
        <b-row>
          <b-col>
            <b-form-select v-model="selected">
              <template #first>
                <b-form-select-option :value="null" disabled
                  >-- Please select an option --</b-form-select-option
                >
              </template>
              <b-form-select-option
                v-for="(item, i) in options"
                :key="item"
                :value="i"
                >{{ item.text }}</b-form-select-option
              ></b-form-select
            >{{ selected }}
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
            {{ date }}
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
      price: 56.9,
      unit: null,
    }
  },
}
</script>

<style>
.content {
  border-radius: 2rem;
  font-family: 'Kanit';
}
</style>